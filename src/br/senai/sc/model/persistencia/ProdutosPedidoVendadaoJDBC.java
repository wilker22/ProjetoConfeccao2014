package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Funcionario;
import br.senai.sc.model.negocio.ProdutosPedidoVenda;
import br.senai.sc.model.persistencia.dao.ProdutosPedidosVendasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pati Gageiro
 * @version 1.0 07/10/2013
 */
public class ProdutosPedidoVendadaoJDBC implements ProdutosPedidosVendasDAO {

    private static final String INSERT = "insert into ProdutosPedidoVenda(nome, qt_produto)";
    private static final String UPDATE = "update ProdutoPedidoVenda set nome = ?, qt_prouto = ? where codProdutoPedidoVenda";
    private static final String DELETE = "delete from ProdutosPedidoVenda where codProdutoPedidoVenda = ?";
    private static final String LIST   = "select * from ProdutosPedidoVenda";
    private static final String LISTBYID = "select * from ProdutosPedidoVenda where codProdutosPedidoVenda = ?";

   
    public boolean insert(ProdutosPedidoVenda ppv) {
        Connection con;
        
        try{
           con =  ConnectionFactory.getConnection();
            PreparedStatement pstm = con.prepareStatement(INSERT);
            pstm.setString(1, ppv.getNome());
            pstm.setString(2, ppv.getQtProduto());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(con, pstm);
            return true;
        }catch (Exception e ){
            JOptionPane.showMessageDialog(null, "Erro na transição" + e.getMessage());
            return false;
        }
        
    }

    
    public boolean update(ProdutosPedidoVenda ppv) {
        Connection con;
        
        try{
            
            con = ConnectionFactory.getConnection();
            PreparedStatement pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, ppv.getNome());
            pstm.setString(2, ppv.getNome());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(con, pstm);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na transação" + e.getMessage());
            return false;
            
        }
    }

    
    public boolean delete(ProdutosPedidoVenda ppv) {
        Connection con;
        
        try{
            con = ConnectionFactory.getConnection();
            PreparedStatement pstm = con.prepareStatement(DELETE);
            pstm.setString(1, ppv.getNome());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            return true;
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Erro na transação");
            return false;
        }
        
    }

    @Override
    public List<ProdutosPedidoVenda> ListAll() {
       Connection con;
       List<ProdutosPedidoVenda> produtospv = new ArrayList<>();
       
       try{
           con = ConnectionFactory.getConnection();
           PreparedStatement pstm = con.prepareStatement(LIST);
           ResultSet rs = pstm.executeQuery();
           while (rs.next()){
               ProdutosPedidoVenda ppv = new ProdutosPedidoVenda();
               ppv.setNome(rs.getString("nome"));
               ppv.setQtProduto(rs.getString("qt_produto"));
               
                produtospv.add(ppv);
               
           }
          ConnectionFactory.closeConnection(con, pstm);
          
    }catch(Exception e ){
        JOptionPane.showMessageDialog(null, "Erro na transição" + e.getMessage());
    }
       return produtospv;
    }

    @Override
    public Funcionario listById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
