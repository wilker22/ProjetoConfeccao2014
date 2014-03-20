
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Treinamento;
import br.senai.sc.model.persistencia.dao.TreinamentoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

    /**
     * Classe responsavél por declarar metodos insert, delete, listar por id,
     * update, listar todos, pesquisa. E seus metodos implementados com dados
     * escolhidos que serão executados da classe TreinamentoDaoJDBC na principal.
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */


public class TreinamentoDaoJDBC implements TreinamentoDAO {

    @Override
    public List<Treinamento> pesquisarNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Treinamento save(Treinamento cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Class<Treinamento> classe, Integer pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Treinamento> getAll(Class<Treinamento> classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Treinamento getById(Class<Treinamento> classe, Integer pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*
    //Declarando os métodos de INSERT, DELETE, LISTAR POR ID, UPDATE, PESQUISAR E LISTAR TODOS de TREINAMENTO
    private final String INSERT = "insert into treinamento (nm_treinamento, carga_horaria, conteudo, id_treinamento) values (?,?,?,?)";
    
    private final String UPDATE = "update treinamento set nm_treinamento = ?, carga_horaria = ?, conteudo = ? where id_treinamento = ?";
    
    private final String DELETE = "delete from treinamento where" + " id_treinamento = ?";
    
    private static final String pesquisa = "select * from treinamento where id_treinamento like ? or nm_treinamento like ?";
    
    private final String LIST = "select * from treinamento where treinamento.id_treinamento = id_treinamento";
    
    private static final String LISTBYID = "select * from treinamento where id_treinamento = ?";

    

    
    
    
     /**
     * Método responsavél por inserir treinamento
     * de acordo com o banco de dados
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */
  
/*
    public boolean insert(Treinamento treina) {
        Connection conn;
        try{
            
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);
            
            
            pstm.setString(1, treina.getNome());
            pstm.setInt(2, treina.getCargaHoraria());
            pstm.setString(3, treina.getConteudo());
            pstm.setLong(4, treina.getId());
           
            
            pstm.execute();
            
            JOptionPane.showMessageDialog(null, "Dados enviados com sucesso!");
            ConnectionFactory.closeConnection(conn, pstm);
            
            return true;
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dados não enviados!" + e.getMessage());
            
          }
        return false;
    }
    
   
    
    
     /**
     * Método responsavél por alterar treinamento
     * de acordo com o banco de dados
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */
    /*
    public boolean update(Treinamento treina) {
         Connection conn;
         
        try{
            conn = ConnectionFactory.getConnection(); 
            PreparedStatement pstm = conn.prepareStatement(UPDATE);
            
            
            pstm.setString(1, treina.getNome());
            pstm.setInt(2, treina.getCargaHoraria());
            pstm.setString(3, treina.getConteudo());
            pstm.setLong(4, treina.getId());
            
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
     * Método responsavél por deletar treinamento
     * de acordo com o banco de dados
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */
    
    /*
    public boolean delete(int id) {
         Connection conn;
         
        try{
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);
        
            pstm.setInt(1, id);
            
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
     * Método responsavél por listar todos os treinamento
     * de acordo com o banco de dados
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */
/*
    public List<Treinamento> listAll() {
         Connection conn;
         
         List<Treinamento> treino = new ArrayList<>();
         
        try{
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            
            
            ResultSet rs = pstm.executeQuery();
             while (rs.next()){
                 
            Treinamento treina = new Treinamento();
            
            treina.setId(rs.getInt("id_treinamento"));
            treina.setNome(rs.getString("nm_treinamento"));
            treina.setCargaHoraria(rs.getInt("carga_horaria"));
            treina.setConteudo(rs.getString("conteudo"));
            
            treino.add(treina);
       } 
        ConnectionFactory.closeConnection(conn, pstm);
       
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Dados não enviados!" + e.getMessage());
            
          
        }return treino;   
        
        }
    
    
    
    
     /**
     * Método responsavél por listar pesquisa de treinamento
     * de acordo com o banco de dados
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */
    /*
     public List<Treinamento> listPesquisa(String texto) {
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Treinamento> treino = new ArrayList<>();


        try {

            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(pesquisa);
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");
            rs = pstm.executeQuery();
             while (rs.next()) {

                Treinamento treina = new Treinamento();

                treina.setId(rs.getInt("id_treinamento"));
                treina.setNome(rs.getString("nm_treinamento"));
                treina.setCargaHoraria(rs.getInt("carga_horaria"));
                treina.setConteudo(rs.getString("conteudo"));

                //metodo list que add e mostra
                treino.add(treina);

            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os treinamentos! " + e.getMessage());

        } finally {
            try {

                ConnectionFactory.closeConnection(con, pstm);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão! " + e.getMessage());

 
        }
            return treino;
 
        }
    }
       
     
     
      /**
     * Método responsavél por listar por id do treinamento
     * de acordo com o banco de dados
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */
     /*
        public Treinamento listById(int id) {
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Treinamento treina = new Treinamento();
        
        try{
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            
            pstm.setInt(1, id);
            rs = pstm.executeQuery();  
            
            while (rs.next()){ 
                
                treina.setId(rs.getInt("id_treinamento"));
                treina.setNome(rs.getString("nm_treinamento"));
                treina.setCargaHoraria(rs.getInt("carga_horaria"));
                treina.setConteudo(rs.getString("conteudo"));
                
                
                
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
      return treina;

    }*/
}