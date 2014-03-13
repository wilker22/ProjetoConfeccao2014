package br.senai.sc.model.persistencia;

//------------------------------------------------------------------------------
import br.senai.sc.model.negocio.Assistencia;
import br.senai.sc.model.persistencia.dao.AssistenciaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//------------------------------------------------------------------------------
/**
 * Classe responsável pela persistência da entidade assistencia na base de
 * dados
 *
 * @author Wesley Batista
 * @since 1.0 06/11/2013
 */
public class AssistenciaDaoJDBC implements AssistenciaDAO { 

    //--------------------------------------------------------------------------
    private final String INSERT = "insert into assistencia("
            + "nm_assistencia, razao_social, cnpj, endereco, telefone, "
            + "contato, email, pagina_web, dt_cadastro) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE = "update assistencia set "
            + "nm_assistencia = ?, razao_social = ?, cnpj = ?, endereco = ?, "
            + "telefone = ?, contato = ?, email = ?, pagina_web = ?, "
            + "dt_cadastro = ? where cod_assistencia = ?";
    private final String DELETE = "delete from assistencia "
            + "where cod_assistencia = ?";
    private final String LIST = "select * from assistencia";
    private final String LISTBYID = "select * from assistencia "
            + "where cod_assistencia = ?";
    private static final String PESQUISA = "select * from assistencia where "
            + "cod_assistencia like ? or nm_assistencia like ?";

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a inserção de uma assistência na base
     * de dados
     *
     * @author Wesley Batista
     * @since 1.0 06/11/2013
     * @param a
     * @return
     */
    @Override
    public int insert(Assistencia a) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, 
                    Statement.RETURN_GENERATED_KEYS);

            pstm.setString(1, a.getNmFantasia());
            pstm.setString(2, a.getRazaoSocial());
            pstm.setString(3, a.getCnpj());
            pstm.setString(4, a.getEndereco());
            pstm.setString(5, a.getTelefone());
            pstm.setString(6, a.getContato());
            pstm.setString(7, a.getEmail());
            pstm.setString(8, a.getPaginaWeb());
            pstm.setDate(9, new java.sql.Date(a.getDtCadastro().getTime()));
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                    rs.close();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir uma "
                    + "assistência: " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a "
                        + "conexão: " + e.getMessage());
            }
        }
        return retorno;
    }

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a atualização de uma assistência na
     * base de dados
     *
     * @author Wesley Batista
     * @since 1.0 06/11/2013
     * @param a
     * @return
     */
    @Override
    public int update(Assistencia a) {
        int retorno = -1;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);

            pstm.setString(1, a.getNmFantasia());
            pstm.setString(2, a.getRazaoSocial());
            pstm.setString(3, a.getCnpj());
            pstm.setString(4, a.getEndereco());
            pstm.setString(5, a.getTelefone());
            pstm.setString(6, a.getContato());
            pstm.setString(7, a.getEmail());
            pstm.setString(8, a.getPaginaWeb());
            pstm.setDate(9, new java.sql.Date(a.getDtCadastro().getTime()));
            pstm.setInt(10, a.getCod());
            pstm.execute();
            retorno = a.getCod();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar uma "
                    + "assistência: " + e.getMessage());

        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: "
                        + e.getMessage());
            }
        }
        return retorno;
    }

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a remoção de uma assistência na base de
     * dados
     *
     * @author Wesley Batista
     * @since 1.0 05/11/2013
     * @param a
     * @return
     */
    @Override
    public boolean delete(int cod) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);

            pstm.setInt(1, cod);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com "
                    + "sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a "
                    + "transação");
            return false;
        }
    }

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a listagem de todas as assistência na
     * base de dados
     *
     * @author Wesley Batista
     * @since 1.0 06/11/2013
     * @param 
     * @return
     */
    @Override
    public List<Assistencia> listAll() {
        Connection conn;
        List<Assistencia> assistencias = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Assistencia a = new Assistencia();
                a.setCod(rs.getInt("cod_assistencia"));
                a.setNmFantasia(rs.getString("nm_assistencia"));
                a.setRazaoSocial(rs.getString("razao_social"));
                a.setCnpj(rs.getString("cnpj"));
                a.setEndereco(rs.getString("endereco"));
                a.setTelefone(rs.getString("telefone"));
                a.setContato(rs.getString("contato"));
                a.setEmail(rs.getString("email"));
                a.setPaginaWeb(rs.getString("pagina_web"));
                a.setDtCadastro(rs.getDate("dt_cadastro"));
                assistencias.add(a);
            }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a "
                    + "transação: " + e.getMessage());
        }
        return assistencias;
    }
    
    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a listagem de uma assistência na base
     * de dados através de um id
     *
     * @author Wesley Batista
     * @since 1.0 06/11/2013
     * @param cod
     * @return
     */
    @Override
    public Assistencia listById(int cod) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);

            pstm.setInt(1, cod);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Assistencia a = new Assistencia();
                a.setCod(rs.getInt("cod_assistencia"));
                a.setNmFantasia(rs.getString("nm_assistencia"));
                a.setRazaoSocial(rs.getString("razao_social"));
                a.setCnpj(rs.getString("cnpj"));
                a.setEndereco(rs.getString("endereco"));
                a.setTelefone(rs.getString("telefone"));
                a.setContato(rs.getString("contato"));
                a.setEmail(rs.getString("email"));
                a.setPaginaWeb(rs.getString("pagina_web"));
                a.setDtCadastro(rs.getDate("dt_cadastro"));
                return a;
            }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a "
                    + "transação");
        }
        return null;
    }

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a pesquisa de assistências na base de
     * dados e que serão apresentadas na interface gráfica
     *
     * @author Wesley Batista
     * @since 1.0 06/11/2013
     * @param texto
     * @return
     */
    @Override
    public List<Assistencia> listPesquisa(String texto) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Assistencia> assistencias = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(PESQUISA);
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Assistencia a = new Assistencia();
                a.setCod(rs.getInt("cod_assistencia"));
                a.setNmFantasia(rs.getString("nm_assistencia"));
                assistencias.add(a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: "
                    + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão:"
                        + e.getMessage());
            }
        }
        return assistencias;
    }
}
