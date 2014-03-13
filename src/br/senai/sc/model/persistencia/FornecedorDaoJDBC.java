/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Fornecedor;
import br.senai.sc.model.persistencia.dao.FornecedorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
* Fornecedor
*
* @version v1.0 Setembro/2013
* @author Giliard Carvalho
*/
public class FornecedorDaoJDBC implements FornecedorDAO{
    private final String INSERT = "INSERT INTO fornecedor VALUES (?,?,?,?,?,?,?,?,?,?);";
    private final String UPDATE = "UPDATE fornecedor SET cod_fornecedor = ?, nome = ?, cnpj = ?,endereco = ?, razao_social = ?, telefone = ?, email = ?, pagina_web = ?, contato = ?, categoria_fornecedor = ? WHERE cod_fornecedor = ?;";
    private final String DELETE = "DELETE FROM fornecedor WHERE cod_fornecedor = ?";
    private final String LIST = "SELECT * FROM fornecedor";
    private final String LISTBYID = "SELECT * FROM fornecedor";
    
    /**
     * Método que efetua a Inserção de um Fornecedor.
     * @param Forn
     * @return 
     */
    public boolean insert(Fornecedor Forn) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);

            pstm.setInt(1, Forn.getCodFornecedor());
            pstm.setString(2, Forn.getNome());
            pstm.setString(3, Forn.getCnpj());
            pstm.setString(4, Forn.getEndereco());
            pstm.setString(5, Forn.getRazaoSocial());
            pstm.setString(6, Forn.getTelefone());
            pstm.setString(7, Forn.getEmail());
            pstm.setString(8, Forn.getPaginaWeb());
            pstm.setString(9, Forn.getContato());
            pstm.setInt(10, Forn.getCategoriaFornecedor().getCodCategoriaFornecedor());

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
     * Método que efetua a Atualização do Fornecedor.
     * @param Forn
     * @return 
     */
    public boolean update(Fornecedor Forn) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);
            
            pstm.setInt(1, Forn.getCodFornecedor());
            pstm.setString(2, Forn.getNome());
            pstm.setString(3, Forn.getCnpj());
            pstm.setString(4, Forn.getEndereco());
            pstm.setString(5, Forn.getRazaoSocial());
            pstm.setString(6, Forn.getTelefone());
            pstm.setString(7, Forn.getEmail());
            pstm.setString(8, Forn.getPaginaWeb());
            pstm.setString(9, Forn.getContato());
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
     * Método que Remove um Fornecedor.
     * @param Forn
     * @return 
     */
    public boolean delete(int codFornecedor) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);

            pstm.setInt(1, codFornecedor);
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
     * Método que Lista o Fornecedor.
     * @param Forn
     * @return 
     */
    public List<Fornecedor> listall() {
        Connection conn;
        List<Fornecedor> fornecedor = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Fornecedor Forn = new Fornecedor();
                Forn.setCodFornecedor(rs.getInt("cod_fornecedor"));
                Forn.setNome(rs.getString("nm_fornecedor"));
                Forn.setCnpj(rs.getString("cnpj"));
                Forn.setEndereco(rs.getString("endereco"));
                Forn.setRazaoSocial(rs.getString("razao_social"));
                Forn.setTelefone(rs.getString("telefone"));
                Forn.setEmail(rs.getString("email"));
                Forn.setPaginaWeb(rs.getString("pagina_web"));
                Forn.setContato(rs.getString("contato"));
                fornecedor.add(Forn);
            }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação: " + e.getMessage());
        }
        return fornecedor;
    }
    
    /**
     * Método que Lista o Fornecedor com parametro.
     * @param Forn
     * @return 
     */
    public List<Fornecedor> listById(int codFornecedor) {

        Connection conn;

        try {
            conn = ConnectionFactory.getConnection();

            PreparedStatement pstm = conn.prepareStatement(LISTBYID);

            pstm.setInt(1, codFornecedor);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Fornecedor Forn = new Fornecedor();
                Forn.setCodFornecedor(rs.getInt("codigo"));
                Forn.setNome(rs.getString("nome"));
                Forn.setCnpj(rs.getString("cnpj"));
                Forn.setEndereco(rs.getString("endereco"));
                Forn.setRazaoSocial(rs.getString("razao_social"));
                Forn.setTelefone(rs.getString("telefone"));
                Forn.setEmail(rs.getString("email"));
                Forn.setPaginaWeb(rs.getString("pagina_web"));
                Forn.setContato(rs.getString("contato"));
                return null;
            }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação!");
        }
        return null;
    }

    @Override
    public boolean Insert(Fornecedor forn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Update(Fornecedor forn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Delete(Fornecedor forn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
