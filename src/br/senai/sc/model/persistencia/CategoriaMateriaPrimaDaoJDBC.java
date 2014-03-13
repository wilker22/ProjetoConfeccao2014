package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.CategoriaMateriaPrima;
import br.senai.sc.model.persistencia.dao.CategoriaMateriaPrimaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Letícia de Jesus Ribeiro
 * @version 1.0 20/09/2013
 *
 */
public class CategoriaMateriaPrimaDaoJDBC implements CategoriaMateriaPrimaDAO {

    private final String INSERT = "insert into categoria_materia_prima(nm_categoria_materia_prima,descricao) "
            + "values (?, ?)";
    private final String UPDATE = "update categoria_materia_prima set nm_categoria_materia_prima = ?, "
            + "descricao = ? where cod_categoria_materia_prima = ?";
    private final String DELETE = "delete from categoria_materia_prima where cod_categoria_materia_prima= ?";
    private static final String ListPesquisa = "select * from categoria_materia_prima where cod_categoria_materia_prima like ? or nm_categoria_materia_prima like? or descricao like?";
    private final String LIST = "select * from categoria_materia_prima";
    private static final String LISTBYID = "select * from categoria_materia_prima where cod_categoria_materia_prima = ?";
    /*
     * Método que realiza a inserção de dados de uma categoria de matéria-prima na base de dados
     * @author Letícia de Jesus Ribeiro
     * @since 1.0 05/11/2013
     * @param cmp
     * @return
     */

    @Override
    public int insert(CategoriaMateriaPrima cmp) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);


            pstm.setString(1, cmp.getNome());
            pstm.setString(2, cmp.getDescricao());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com "
                    + "sucesso");

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a "
                    + "transação" + e.getMessage());
            return -1;
        }
        return -1;
    }

    /*
     * Método responsável por atualizar dados de uma categoria de matéria-prima na base de dados.
     * @author Letícia de Jesus Ribeiro
     * @since 1.0 05/11/2013
     * @param cmp
     * @return
     */
    public int update(CategoriaMateriaPrima cmp) {
        int retorno = -1;
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);

            pstm.setInt(1, cmp.getCod());
            pstm.setString(2, cmp.getNome());
            pstm.setString(3, cmp.getDescricao());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com "
                    + "sucesso");

            retorno = cmp.getCod();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a "
                    + "transação" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, pstm);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: "
                        + e.getMessage());
            }
        }
        return retorno;
    }

    /*
     * Método responsável por remover dados de uma categoria de matéria-prima da base de dados
     * @author Letícia de Jesus Ribeiro
     * @since 1.0 05/11/2013
     * @param codCategoriaMateriaPrima
     * @return
     */
    @Override
    public boolean delete(int codCategoriaMateriaPrima) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);

            pstm.setInt(1, codCategoriaMateriaPrima);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com "
                    + "sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a "
                    + "transação: " + e.getMessage());
            return false;
        }
    }

    /*
     * Método responsável por listar dados de  categorias de matéria-prima  da base de dados.
     * @author Letícia de Jesus Ribeiro
     * @since 1.0 05/11/2013
     * @param 
     * @return
     */
    public List<CategoriaMateriaPrima> listAll() {
        Connection conn;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<CategoriaMateriaPrima> categoriamateriaprima = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);

            rs = pstm.executeQuery();
            while (rs.next()) {
                CategoriaMateriaPrima cmp = new CategoriaMateriaPrima();
                cmp.setCod(rs.getInt("cod_categoria_materia_prima"));
                cmp.setNome(rs.getString("nm_categoria_materia_prima"));
                cmp.setDescricao(rs.getString("descricao"));

                categoriamateriaprima.add(cmp);


            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a "
                    + "transação: " + e.getMessage());
        }
        return categoriamateriaprima;
    }
    /*
     *Método responsável por listar por id dados categorias de matéria-prima de uma base de dados.
     * @author Letícia de Jesus Ribeiro
     * @since 1.0 05/11/2013
     * @param codCategoriaMateriaPrima
     * @return
     */

    public CategoriaMateriaPrima listById(int codCategoriaMateriaPrima) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        CategoriaMateriaPrima cmp = new CategoriaMateriaPrima();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, codCategoriaMateriaPrima);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cmp.setCod(rs.getInt("cod_categoria_materia_prima"));
                cmp.setNome(rs.getString("nm_categoria_materia_prima"));
                cmp.setDescricao(rs.getString("descricao"));
            }
        } catch (Exception e) {
        }
        return cmp;
    }

    /**
     * Método responsável pela pesquisa de dados de categorias de matéria-prima
     * por id, e nome.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 1.0 05/11/2013
     * @param
     * @return
     */
    public List<CategoriaMateriaPrima> listPesquisa(String texto) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<CategoriaMateriaPrima> categoriasmateriaprima = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(ListPesquisa);
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");
            pstm.setString(3, "%" + texto + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                CategoriaMateriaPrima cmp = new CategoriaMateriaPrima();
                cmp.setCod(rs.getInt("cod_categoria_materia_prima"));
                cmp.setNome(rs.getString("nm_categoria_materia_prima"));
                cmp.setDescricao(rs.getString("descricao"));
                categoriasmateriaprima.add(cmp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão:"
                        + e.getMessage());

            }
            return categoriasmateriaprima;
        }

    }
}