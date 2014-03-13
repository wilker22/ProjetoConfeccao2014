package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.CategoriaProduto;
import br.senai.sc.model.persistencia.dao.CategoriaProdutoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaProdutoDaoJDBC implements CategoriaProdutoDAO {

    private final String INSERT = "INSERT INTO categoria_produto (nome, descricao) values (?,?)";
    private final String UPDATE = "UPDATE categoria_produto SET nome = ?, descricao = ? WHERE cod_categoria = ?";
    private final String DELETE = "DELETE FROM categoria_produto WHERE cod_categoria = ?";
    private final String LIST = "SELECT * FROM categoria_produto";
    private final String LISTBYID = "SELECT * FROM categoria_produto WHERE cod_categoria = ?";
    private final String SEARCH = "SELECT * FROM categoria_produto WHERE cod_categoria LIKE ? OR nome LIKE ? OR descricao LIKE ?";

    /**
     * Método responsável pela inserção de dados na tabela categoria_produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param CP
     * @return
     */
    @Override
    public boolean insert(CategoriaProduto CP) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, CP.getNomeCategoriaProduto());
            pstm.setString(2, CP.getDescricaoCategoriaProduto());
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    CP.setCodCategoriaProduto(rs.getInt(1));
                }
            }

            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação" + e.getMessage());
            return false;
        }
    }

    /**
     * Método responsável pela alteração de dados na tabela categoria_produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param CP
     * @return
     */
    @Override
    public boolean update(CategoriaProduto CP) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, CP.getNomeCategoriaProduto());
            pstm.setString(2, CP.getDescricaoCategoriaProduto());
            pstm.setInt(3, CP.getCodCategoriaProduto());
            System.out.println(UPDATE);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação");
            return false;
        }
    }

    /**
     * Método responsável por deletar dados da tabela categoria_produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param codCategoriaProduto
     * @return
     */
    @Override
    public boolean delete(int codCategoriaProduto) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);

            pstm.setInt(1, codCategoriaProduto);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação" + e.getMessage());
            return false;
        }
    }

    /**
     * Método responsável por listar as informações da tabela categoria_produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @return
     */
    public List<CategoriaProduto> listAll() {
        Connection conn;
        List<CategoriaProduto> CP = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                CategoriaProduto CPList = new CategoriaProduto();
                CPList.setCodCategoriaProduto(rs.getInt("cod_categoria"));
                CPList.setNomeCategoriaProduto(rs.getString("nome"));
                CPList.setDescricaoCategoriaProduto(rs.getString("descricao"));
                CP.add(CPList);
            }
            ConnectionFactory.closeConnection(conn, pstm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação 2");
        }
        return CP;
    }

    /**
     * Método responsável por selecionar a categoria por ID.
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param codCategoriaProduto
     * @return
     */
    @Override
    public CategoriaProduto listById(int codCategoriaProduto) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, codCategoriaProduto);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                CategoriaProduto CPList = new CategoriaProduto();
                CPList.setCodCategoriaProduto(rs.getInt("cod_categoria"));
                CPList.setNomeCategoriaProduto(rs.getString("nome"));
                CPList.setDescricaoCategoriaProduto(rs.getString("descricao"));
                return CPList;
            }
            ConnectionFactory.closeConnection(conn, pstm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação 3");
        }
        return null;
    }

    /**
     * Método responsável por pesquisar categorias na tabela categoria_produtos.
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param texto
     * @return
     */
    @Override
    public List<CategoriaProduto> search(String texto) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<CategoriaProduto> LCP = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(SEARCH);
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");
            pstm.setString(3, "%" + texto + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                CategoriaProduto CP = new CategoriaProduto();
                CP.setCodCategoriaProduto(rs.getInt("cod_categoria"));
                CP.setNomeCategoriaProduto(rs.getString("nome"));
                CP.setDescricaoCategoriaProduto(rs.getString("descricao"));
                LCP.add(CP);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return LCP;
    }
}