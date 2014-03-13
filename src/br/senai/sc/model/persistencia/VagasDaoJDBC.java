
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Vagas;
import br.senai.sc.model.persistencia.dao.VagasDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

    /**
     * Classe responsavél por declarar metodos insert, delete, listar por id,
     * update, listar todos, pesquisa. E seus metodos implementados com dados
     * escolhidos que serão executados da classe VagasDaoJDBC na principal.
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param vaga
     * @return 
     */


public class VagasDaoJDBC implements VagasDAO {
    
    //Declarando os métodos de INSERT, DELETE, LISTAR POR ID, PESQUISAR, UPDATE E LISTAR TODOS de VAGAS
    private final String INSERT = "insert into vagas (nm_vaga, qt_vaga, pre_requisitos, funcao, faixa_salarial) values (?,?,?,?,?)";
    
    private final String UPDATE = "update vagas set nm_vaga = ?, qt_vaga = ?, pre_requisitos = ?, funcao = ?, faixa_salarial = ? where cod_vaga = ?";
    
    private final String DELETE = "delete from vagas where" + " cod_vaga = ?";
    
     private static final String pesquisa = "select * from vagas where cod_vaga like ? or nm_vaga like ?";
    
    private final String LIST = "select * from vagas where vagas.cod_vaga = cod_vaga";
    
    private static final String LISTBYID = "select * from vagas where cod_vaga = ?";

    
    
    /**
     * Método responsavél por inserir vagas
     * de acordo com o banco de dados
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param vag
     * @return 
     */
    
    public boolean insert(Vagas vaga) {
        Connection conn;
        try{
            
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);
            
            
            pstm.setString(1, vaga.getNome());
            pstm.setInt(2, vaga.getQtVaga());
            pstm.setString(3, vaga.getPreRequisito());
            pstm.setString(4, vaga.getFuncao());
            pstm.setDouble(5, vaga.getfaixaSalarial());
            
            
            pstm.execute();
            
            
            JOptionPane.showMessageDialog(null, "Dados enviados com sucesso!");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Dados não enviados! " + e.getMessage());
            
          }
        return false;
    }
      
        
        
       
     /**
     * Método responsavél por alterar vagas
     * de acordo com o banco de dados
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param vag
     * @return 
     */
        

    public boolean update(Vagas vaga) {
        Connection conn;
         
        try{
            conn = ConnectionFactory.getConnection(); 
            PreparedStatement pstm = conn.prepareStatement(UPDATE);
           
            
            pstm.setString(1, vaga.getNome());
            pstm.setInt(2, vaga.getQtVaga());
            pstm.setString(3, vaga.getPreRequisito());
            pstm.setString(4, vaga.getFuncao());
            pstm.setDouble(5, vaga.getfaixaSalarial());
            pstm.setInt(6, vaga.getCodigo());
            
            pstm.execute();
        
        
        JOptionPane.showMessageDialog(null, "Dados enviados!");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
            
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Dados não enviados!" + e.getMessage());
            return false;
        }  
    }
    
    
    
     /**
     * Método responsavél por remover vagas
     * de acordo com o banco de dados
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param vag
     * @return 
     */
    
   
    public boolean delete(int codigo) {
        
         Connection conn;
         
        try{
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);
            
            pstm.setInt(1, codigo);
            
            pstm.execute();
            
            JOptionPane.showMessageDialog(null, "Dados enviados!");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Dados não enviados!" + e.getMessage());
            return false;
        }
    }
            
             
    
    
     /**
     * Método responsavél por listar todas as vagas
     * de acordo com o banco de dados
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param vag
     * @return 
     */

    
    public List<Vagas> listAll() {
        Connection conn;
         
         List<Vagas> vaga = new ArrayList<>();
         
        try{
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            
            
            ResultSet rs = pstm.executeQuery();
             while (rs.next()){
        
                 Vagas vag = new Vagas();
                 
                 
                 vag.setCodigo(rs.getInt("cod_vaga"));
                 vag.setNome(rs.getString("nm_vaga"));
                 vag.setQtVaga(rs.getInt("qt_vaga"));
                 vag.setPreRequisito(rs.getString("pre_requisitos"));
                 vag.setFuncao(rs.getString("funcao"));
                 vag.setfaixaSalaria(rs.getDouble("faixa_salarial"));
                 
                 
            vaga.add(vag);
       } 
        ConnectionFactory.closeConnection(conn, pstm);
       
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Dados não enviados!" + e.getMessage());
            
          
        }return vaga;   
        
        }
    
    
    
      
    /**
     * Método responsavél por listar pesquisa de vagas
     * de acordo com o banco de dados
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param vag
     * @return 
     */
    
    public List<Vagas> listPesquisa(String texto) {
        
         Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Vagas> vag = new ArrayList<>();


        try {

            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(pesquisa);
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");
            rs = pstm.executeQuery();
            
             while (rs.next()) {

                Vagas vaga = new Vagas();

                vaga.setCodigo(rs.getInt("cod_vaga"));
                vaga.setNome(rs.getString("nm_vaga"));
                vaga.setQtVaga(rs.getInt("qt_vaga"));
                vaga.setPreRequisito(rs.getString("pre_requisitos"));
                vaga.setFuncao(rs.getString("funcao"));
                vaga.setfaixaSalaria(rs.getDouble("faixa_salarial"));

                //metodo list que add e mostra
                vag.add(vaga);
                

            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os treinamentos! " + e.getMessage());

        } finally {
            try {

                ConnectionFactory.closeConnection(con, pstm);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão! " + e.getMessage());

 
        }
            return vag;
 
        }
        
        
        
    }

    
    
    
    
       
    /**
     * Método responsavél por listar por id de vagas
     * de acordo com o banco de dados
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param vag
     * @return 
     */
    
    
       public Vagas listById(int id) {
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        Vagas vag = new Vagas();
        
        try{
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            
            pstm.setInt(1, id);
            rs = pstm.executeQuery();  
            
            while (rs.next()){ 
                
                vag.setCodigo(rs.getInt("cod_vaga"));
                vag.setNome(rs.getString("nm_vaga"));
                vag.setQtVaga(rs.getInt("qt_vaga"));
                vag.setPreRequisito(rs.getString("pre_requisitos"));
                vag.setFuncao(rs.getString("funcao"));
                vag.setfaixaSalaria(rs.getDouble("faixa_salarial"));
                
                
                
                
                
            }
                    
 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao listar! " + e.getMessage());
            
            
        }finally{   
        try{
            ConnectionFactory.closeConnection(con, pstm, rs);
            
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão! " + e.getMessage());
        }
        
        
      
        
    }
      return vag;
       
    }
        

    }
       
