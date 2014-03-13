/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.CategoriaFornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
* Categoria Fornecedor
*
* @version v1.0 Setembro/2013
* @author Giliard Carvalho
*/
public class CategoriaFornecedorDaoJDBC {
    private final String INSERT   = "INSERT INTO categoria_fornecedor VALUES (?,?,?,?);";
    private final String UPDATE   = "UPDATE categoria_fornecedor SET cod_categoria_fornecedor = ?,nome = ?, descricao = ?, observacoes = ? "
                                  + " WHERE cod_categoria_fornecedor = ?";
    private final String DELETE   = "DELETE FROM categoria_fornecedor WHERE cod_categoria_fornecedor = ?";
    private final String LIST     = "SELECT * FROM categoria_fornecedor";
    private final String LISTBYID = "SELECT * FROM categoria_fornecedor";
    
    /**
     * Método que efetua a Inserção da Categoria Fornecedor.
     * @param CatForn
     * @return 
     */
    public boolean insert(CategoriaFornecedor CatForn) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);

            pstm.setInt(1, CatForn.getCodCategoriaFornecedor());
            pstm.setString(2, CatForn.getNome());
            pstm.setString(3, CatForn.getDescricao());
            pstm.setString(4, CatForn.getObservacoes());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso!");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação!" + e.getMessage());
            return false;
        }
    }

    /**
     * Método que efetua a Atualização da Categoria Fornecedor.
     * @param CatForn
     * @return 
     */
    public boolean update(CategoriaFornecedor CatForn) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);
            
            pstm.setInt(1, CatForn.getCodCategoriaFornecedor());
            pstm.setString(2, CatForn.getNome());
            pstm.setString(3, CatForn.getDescricao());
            pstm.setString(4, CatForn.getObservacoes());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso!");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação!");
            return false;
        }
    }

   /**
     * Método que Remove uma Categoria Fornecedor.
     * @param CatForn
     * @return 
     */
    public boolean delete(int codCategoriaFornecedor) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);

            pstm.setInt(1, codCategoriaFornecedor);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso!");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação!");
            return false;
        }
    }

    /**
     * Método que Lista a Categoria Fornecedor.
     * @param CatForn
     * @return 
     */
    public List<CategoriaFornecedor> listall() {
        Connection conn;
        List<CategoriaFornecedor> categoriaFornecedor = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                CategoriaFornecedor CatForn = new CategoriaFornecedor();
                CatForn.setCodCategoriaFornecedor(rs.getInt("codigo"));
                CatForn.setNome(rs.getString("nome"));
                CatForn.setDescricao(rs.getString("descrição"));
                CatForn.setObservacoes(rs.getString("observacoes"));
                categoriaFornecedor.add(CatForn);
            }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação: " + e.getMessage());
        }
        return categoriaFornecedor;
    }
    
    /**
     * Método que efetua a Atualização da Categoria Fornecedor.
     * @param codCategoriaFornecedor
     * @return 
     */
    public CategoriaFornecedor listById(int codCategoriaFornecedor) {

        Connection conn;

        try {
            conn = ConnectionFactory.getConnection();

            PreparedStatement pstm = conn.prepareStatement(LISTBYID);

            pstm.setInt(1, codCategoriaFornecedor);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                CategoriaFornecedor CatForn = new CategoriaFornecedor();
                CatForn.setCodCategoriaFornecedor(rs.getInt("codigo Categoria matéria-prima"));
                CatForn.setNome(rs.getString("nome"));
                CatForn.setDescricao(rs.getString("descrição"));
                CatForn.setObservacoes(rs.getString("observacoes"));
                return CatForn;
            }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação!");
        }
        return null;
    }
    
}
