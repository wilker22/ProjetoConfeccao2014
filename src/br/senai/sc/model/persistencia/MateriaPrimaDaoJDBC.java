package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.CategoriaMateriaPrima;
import br.senai.sc.model.negocio.Fornecedor;
import br.senai.sc.model.negocio.MateriaPrima;
import br.senai.sc.model.persistencia.dao.MateriaPrimaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Letícia de Jesus Ribeiro
 * @version 1.0 20/09/2013
 */
public class MateriaPrimaDaoJDBC implements MateriaPrimaDAO {

    private final String INSERT = "insert into materia_prima(nome,preco,tipo_unidade,qt_materiaprima,cod_fornecedor,cod_categoria_materia_prima) "
            + "values (?,?,?,?,?,?)";
    private final String UPDATE = "update materia_prima set nome = ?, "
            + "preco = ?,tipo_unidade = ?,qt_materiaprima=?,cod_categoria_materia_prima=?,cod_fornecedor=? where codigo_materia_prima = ?";
    private static final String PESQUISA = "select * from materia_prima,fornecedor,categoria_materia_prima "
            + "where materia_prima.cod_fornecedor=fornecedor.cod_fornecedor "
            + "and materia_prima.cod_categoria_materia_prima=categoria_materia_prima.cod_categoria_materia_prima "
            + "and materia_prima.codigo_materia_prima like ? or "
            + "materia_prima.nome like ? ";
    private final String DELETE = "delete from materia_prima where codigo_materia_prima = ?";
    private final String LIST = " select * from materia_prima,fornecedor,categoria_materia_prima where materia_prima.cod_fornecedor=fornecedor.cod_fornecedor and materia_prima.cod_categoria_materia_prima=categoria_materia_prima.cod_categoria_materia_prima";
    private static final String LISTBYID = " select * from materia_prima,fornecedor,categoria_materia_prima where materia_prima.cod_fornecedor=fornecedor.cod_fornecedor and materia_prima.cod_categoria_materia_prima=categoria_materia_prima.cod_categoria_materia_prima  and  codigo_materia_prima = ?";

//------------------------------------------------------------------------------
    /**
     * Método reponsável por inserir valores na base de dados.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 1.0 05/11/2013
     * @param mp
     * @return
     */
    public int insert(MateriaPrima mp) {
        Connection con;
        try {
            con = ConnectionFactory.getConnection();
            PreparedStatement pstm = con.prepareStatement(INSERT,
                    Statement.RETURN_GENERATED_KEYS);

            pstm.setString(1, mp.getNome());
            pstm.setDouble(2, mp.getPreco());
            pstm.setString(3, mp.getTpUnidade());
            pstm.setInt(4, mp.getQuantidade());
            pstm.setInt(5, mp.getFornecedor().getCodFornecedor());
            pstm.setInt(6, mp.getCategoria().getCod());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");



            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            ConnectionFactory.closeConnection(con, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a "
                    + "transação" + e.getMessage());
            return -1;
        }
        return -1;
    }
//------------------------------------------------------------------------------

    /**
     * Método responsável por atualizar dados de uma materia-prima na base de
     * dados
     *
     * @author Letícia de Jesus Ribeiro
     * @since 1.0 05/11/2013
     * @param mp
     * @return
     */
    public int update(MateriaPrima mp) {
        int retorno = -1;
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, mp.getNome());
            pstm.setDouble(2, mp.getPreco());
            pstm.setString(3, mp.getTpUnidade());
            pstm.setInt(4, mp.getQuantidade());
            pstm.setInt(5, mp.getFornecedor().getCodFornecedor());
            pstm.setInt(6, mp.getCategoria().getCod());
            pstm.setInt(7, mp.getCodigo());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com "
                    + "sucesso");
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

        retorno = mp.getCodigo();


        return retorno;

    }

//------------------------------------------------------------------------------
    /*
     * Método responsável por deletar uma materia-prima na base de dados
     * @author Letícia de Jesus Ribeiro
     * @since 1.0 05/11/2013
     * @param CodMateriaPrima
     * @return
     */
    @Override
    public boolean delete(int CodMateriaPrima) {

        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);

            pstm.setInt(1, CodMateriaPrima);
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

//------------------------------------------------------------------------------
    /*
     * Método responsável por listar dados das materia-prima da base de dados
     * @author Letícia de Jesus Ribeiro
     * @since 1.0 05/11/2013
     * @param 
     * @return
     */
    public List<MateriaPrima> listAll() {
        Connection conn;
        List<MateriaPrima> materiaprima = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                MateriaPrima mp = new MateriaPrima();
                mp.setCodigo(rs.getInt("materia_prima.codigo_materia_prima"));
                mp.setNome(rs.getString("materia_prima.nome"));
                mp.setPreco(rs.getDouble("materia_prima.preco"));

                mp.setTpUnidade(rs.getString("materia_prima.tipo_unidade"));

                mp.setQuantidade(rs.getInt("materia_prima.qt_materiaprima"));
                Fornecedor f = new Fornecedor();
                f.setNome(rs.getString("fornecedor.nm_fornecedor"));
                f.setCodFornecedor(rs.getInt("fornecedor.cod_fornecedor"));

                mp.setFornecedor(f);
                CategoriaMateriaPrima cmp = new CategoriaMateriaPrima();
                cmp.setNome(rs.getString("categoria_materia_prima.cod_categoria_materia_prima"));
                cmp.setNome(rs.getString("categoria_materia_prima.nm_categoria_materia_prima"));
                mp.setCategoria(cmp);
                materiaprima.add(mp);
            }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a "
                    + "transação: " + e.getMessage());
        }
        return materiaprima;
    }

    /**
     * Método responsável pela listagem de dados de matéria-prima por id.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 1.0 05/11/2013
     * @param CodMateriaPrima
     * @return
     */
    public MateriaPrima listById(int CodMateriaPrima) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        MateriaPrima mp = new MateriaPrima();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, CodMateriaPrima);
            rs = pstm.executeQuery();
            while (rs.next()) {
                mp.setCodigo(rs.getInt("materia_prima.codigo_materia_prima"));
                mp.setNome(rs.getString("materia_prima.nome"));
                mp.setPreco(rs.getDouble("materia_prima.preco"));

                mp.setTpUnidade(rs.getString("materia_prima.tipo_unidade"));

                mp.setQuantidade(rs.getInt("materia_prima.qt_materiaprima"));
                Fornecedor f = new Fornecedor();
                f.setNome(rs.getString("fornecedor.nm_fornecedor"));
                f.setCodFornecedor(rs.getInt("fornecedor.cod_fornecedor"));

                mp.setFornecedor(f);
                CategoriaMateriaPrima cmp = new CategoriaMateriaPrima();
                mp.setNome(rs.getString("categoria_materia_prima.cod_categoria_materia_prima"));
                mp.setNome(rs.getString("categoria_materia_prima.nm_categoria_materia_prima"));

                return mp;

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
        }
        return null;
    }

    /**
     * Método responsável pela pesquisa de dados de matéria-prima por id, e
     * nome.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 1.0 05/11/2013
     * @param
     * @return
     */
    public List<MateriaPrima> listPesquisa(String texto) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<MateriaPrima> materiasprima = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(PESQUISA);
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                MateriaPrima mp = new MateriaPrima();
                mp.setCodigo(rs.getInt("materia_prima.codigo_materia_prima"));
                mp.setNome(rs.getString("materia_prima.nome"));
                mp.setPreco(rs.getDouble("materia_prima.preco"));

                mp.setTpUnidade(rs.getString("materia_prima.tipo_unidade"));

                mp.setQuantidade(rs.getInt("materia_prima.qt_materiaprima"));
                Fornecedor f = new Fornecedor();
                f.setNome(rs.getString("fornecedor.nm_fornecedor"));
                f.setCodFornecedor(rs.getInt("fornecedor.cod_fornecedor"));

                mp.setFornecedor(f);
                CategoriaMateriaPrima cmp = new CategoriaMateriaPrima();
                cmp.setNome(rs.getString("categoria_materia_prima.cod_categoria_materia_prima"));
                cmp.setNome(rs.getString("categoria_materia_prima.nm_categoria_materia_prima"));
                mp.setCategoria(cmp);
                materiasprima.add(mp);
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
        }
        return materiasprima;
    }
}
