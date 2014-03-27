package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Fabricante;
import br.senai.sc.model.persistencia.dao.FabricanteDAO;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Classe responsável pelos métodos de banco da Classe Fabricante
 * @author Mateus Generoso
 * @version 1.0 16/09/2013
 * @param p
 * @return
 */
public class FabricanteDaoJDBC extends DAOJPA<Fabricante, Integer> implements FabricanteDAO {

    @Override
    public List<Fabricante> pesquisarNome(String nome) {
        return getEntityManager().createQuery(
                "SELECT f from Fabricante f where f.razaoSocial like '%" + nome + "%'")
                .getResultList();
    }
//    private static final String INSERT =        "INSERT INTO fabricante(cod_fabricante, nmfantasia, razao_social, dt_cadastro, cnpj, telefone, email, endereco) values (?,?,?,?,?,?,?,?)";
//    private static final String UPDATE =        "UPDATE fabricante SET nmfantasia = ?, razao_social = ?, dt_cadastro = ?, cnpj = ?, telefone = ?, email = ?, endereco = ? WHERE cod_fabricante = ?";
//    private static final String DELETE =        "DELETE FROM fabricante WHERE cod_fabricante = ?";
//    private static final String LIST =          "SELECT * FROM fabricante";
//    private static final String LISTBYID =      "SELECT * FROM fabricante WHERE cod_fabricante = ?";
//    private static final String LISTPESQUISAR = "SELECT * from fabricante WHERE cod_fabricante LIKE ? or nmfantasia LIKE ? or cnpj LIKE ? or telefone LIKE ? or email LIKE ? or endereco LIKE ? or razao_social LIKE ? or dt_cadastro LIKE ?";
//    
//    @Override
//    /* INSERÇÃO */
//    
//    /**
//     * Método responsável pela inserção no banco de dados
//     * @author Mateus Generoso
//     * @since 1.0 05/11/2013
//     * 
//     */
//    public int insert(Fabricante fab) {
//        Connection conn = null;
//        PreparedStatement pstm = null;
//        int retorno = -1;
//        
//            try {
//            conn = ConnectionFactory.getConnection();
//            pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
//            pstm.setInt(1, fab.getCod());
//            pstm.setString(2, fab.getNmFantasia());
//            pstm.setString(3, fab.getRazaoSocial());
//            pstm.setDate(4, new java.sql.Date(fab.getDtCadastro().getTime()));
//            pstm.setString(5, fab.getCnpj());
//            pstm.setString(6, fab.getTelefone());
//            pstm.setString(7, fab.getEmail());
//            pstm.setString(8, fab.getEndereco());
//            pstm.execute();
//            
//             try (ResultSet rs = pstm.getGeneratedKeys()) {
//                if (rs.next()) {
//                    retorno = (rs.getInt(1));
//                }
//            }
//            
//            
//            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
//           
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
//        } finally {
//            try {
//                ConnectionFactory.closeConnection(conn, pstm);
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão." + "\n" + ex.getMessage());
//            }
//        }
//        return retorno;
//    }
//
//    @Override    
//    /**
//     * Método responsável pela alteração do registro no banco de dados
//     * @author Mateus Generoso
//     * @since 1.0 05/11/2013
//     */
//    /* ALTERAÇÃO */
//    public int update(Fabricante fab) {
//        int retorno = -1;
//        Connection conn = null;
//        PreparedStatement pstm = null;
//        try {
//            conn = ConnectionFactory.getConnection();
//            pstm = conn.prepareStatement(UPDATE);
//            pstm.setString(1, fab.getNmFantasia());
//            pstm.setString(2, fab.getRazaoSocial());
//            pstm.setDate(3, new java.sql.Date(fab.getDtCadastro().getTime()));
//            pstm.setString(4, fab.getCnpj());
//            pstm.setString(5, fab.getTelefone());
//            pstm.setString(6, fab.getEmail());
//            pstm.setString(7, fab.getEndereco());
//            pstm.setInt(8, fab.getCod());
//            pstm.execute();
//            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
//            retorno = fab.getCod();
//          
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
//        } finally {
//            try {
//                ConnectionFactory.closeConnection(conn, pstm);
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão." + "\n" + ex.getMessage());
//            }
//        }
//        return retorno;
//    }    
//    /**
//     * Método responsável pela deleção do registro no banco de dados
//     * @author Mateus Generoso
//     * @since 1.0 05/11/2013
//     * @param fab
//     * @return 
//     */
//    /* DELEÇÃO */
//    public boolean delete(Fabricante fab) {
//            Connection conn;
//        try {
//            conn = ConnectionFactory.getConnection();
//            PreparedStatement pstm = conn.prepareStatement(DELETE);
//
//            pstm.setInt(1, fab.getCod());
//            pstm.execute();
//            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
//            ConnectionFactory.closeConnection(conn, pstm);
//            return true;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação" + e.getMessage());
//            return false;
//
//        }
//    }
//
//    @Override
//    /**
//     * Método responsável pela listagem dos dados da tabela fabricante
//     * @author Mateus Generoso
//     * @since 1.0 05/11/2013
//     */
//    /* LISTAGEM */
//    public List<Fabricante> listAll() {
//    Connection conn;
//        List<Fabricante> fabricante = new ArrayList<>();
//        try {
//            conn = ConnectionFactory.getConnection();
//            PreparedStatement pstm = conn.prepareStatement(LIST);
//            ResultSet rs = pstm.executeQuery();
//            while (rs.next()) {
//                Fabricante f = new Fabricante();
//                f.setCod(rs.getInt("cod_fabricante"));
//                f.setNmFantasia(rs.getString("nmfantasia"));
//                f.setRazaoSocial(rs.getString("razao_social"));
//                f.setDtCadastro(rs.getDate("dt_cadastro"));
//                f.setCnpj(rs.getString("cnpj"));
//                f.setTelefone(rs.getString("telefone"));
//                f.setEmail(rs.getString("email"));
//                f.setEndereco(rs.getString("endereco"));
//                fabricante.add(f);
//            }
//            ConnectionFactory.closeConnection(conn, pstm);
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação" + e.getMessage());
//        }
//        return fabricante;
//    }
//
//    @Override
//    /**
//     * Método responsável pela listagem por ID do banco de dados
//     * @author Mateus Generoso
//     * @since 1.0 05/11/2013
//     */
//    /* LISTAGEM POR ID */
//    public Fabricante listById(int codFabricante) {
//       Connection con = null;
//       ResultSet rs = null;
//       PreparedStatement pstm = null;
//       Fabricante f = new Fabricante();
//        try {
//            con = ConnectionFactory.getConnection();
//            pstm = con.prepareStatement(LISTBYID);
//            pstm.setInt(1, codFabricante);
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                
//                f.setCod(rs.getInt("cod_fabricante"));
//                f.setNmFantasia(rs.getString("nmfantasia"));
//                f.setRazaoSocial(rs.getString("razao_social"));
//                f.setDtCadastro(rs.getDate("dt_cadastro"));
//                f.setCnpj(rs.getString("cnpj"));
//                f.setTelefone(rs.getString("telefone"));
//                f.setEmail(rs.getString("email"));
//                f.setEndereco(rs.getString("endereco"));
//            }
//            ConnectionFactory.closeConnection(con, pstm);
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação");
//        } finally {
//            try {
//                ConnectionFactory.closeConnection(con, pstm, rs);
//            } catch (SQLException ex) {
//                System.out.println("Erro ao fechar listagem por ID." + "\n" + ex.getMessage());
//            }
//       }
//        return f;
//    }
//    
//    
//  /*PESQUISA*/
//    /**
//     * Método responsável pela listagem atraves da pesquisa
//     * @author Mateus Generoso
//     * @since 1.0 05/11/2013
//     * @param texto
//     * @return 
//     */
//   public List<Fabricante> ListPesquisar(String texto) {
//         Connection con = null;
//         PreparedStatement pstm = null;
//         ResultSet rs = null;
//         List<Fabricante> fabs = new ArrayList<>();
//         try{
//             con = ConnectionFactory.getConnection();
//             pstm = con.prepareStatement(LISTPESQUISAR);
//             pstm.setString(1,"%" +  texto + "%");
//             pstm.setString(2,"%" +  texto + "%");
//             pstm.setString(3,"%" +  texto + "%");
//             pstm.setString(4,"%" +  texto + "%");
//             pstm.setString(5,"%" +  texto + "%");
//             pstm.setString(6,"%" +  texto + "%");
//             pstm.setString(7,"%" +  texto + "%");
//             pstm.setString(8,"%" +  texto + "%");
//             
//          
//             
//             rs = pstm.executeQuery();
//             while (rs.next()){
//                 Fabricante fab = new Fabricante();
//                 fab.setCod(Integer.parseInt(rs.getString("cod_fabricante")));
//                 fab.setNmFantasia(rs.getString("nmfantasia"));
//                 fab.setCnpj(rs.getString("cnpj"));
//                 fab.setTelefone(rs.getString("telefone"));
//                 fab.setEmail(rs.getString("email"));
//                 fab.setEndereco(rs.getString("endereco"));
//                 
//                 
//                 
//                 fabs.add(fab);
//                 
//             }
//         }catch(Exception e){
//             JOptionPane.showMessageDialog(null, "Erro ao pesquisar" + e.getMessage());
//         }finally{
//             try{
//                 ConnectionFactory.closeConnection(con, pstm, rs);
//                 
//             }catch(Exception e){
//                 JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
//             }
//             return fabs;
//         }
//    }
}
