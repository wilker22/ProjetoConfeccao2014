/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;


import br.senai.sc.model.negocio.Curriculo;
import br.senai.sc.model.persistencia.dao.CurriculoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



/**
 *
 * @author evaldo_matias
 */
public class CurriculoDAOJDBC implements CurriculoDAO {

    private static final String INSERT = "insert into cadastrocurriculo(login ,senha ,nome ,cpf ,email ,telefone ,ctps ,cargo ,rg ,salario ,dataadimissao ,datanascimento ,datarecisao ,status ,experienciaprofissional) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT = "select * from cadastrocurriculo";
    private static final String DELETE = "delete from cadastrocurriculo where codigo = ?";
    private static final String UPDATE = "update cadastrocurriculo set login = ? ,senha = ? ,nome = ? ,cpf = ? ,email = ? ,telefone = ? ,ctps = ? ,rg = ? ,salario = ? ,dataadimissao = ? ,datanascimento = ? ,datarecisao = ? ,status = ? ,experienciaprofissional = ? where codigo = ?";
    private static final String LISTBYID = "select * from cadastrocurriculo where codigo = ?";
    private static final String pesquisa = "select * from cadastrocurriculo where codigo like ? or nome like ?";

    public int insert(Curriculo p) {
        //Cria uma nova conexão
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            //Abre a conexão 'conn'
            con = ConnectionFactory.getConnection();
            //Recebe a String com o comando SQL, no caso, o comando INSERT
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, p.getLogin());
            pstm.setString(2, p.getSenha());
            pstm.setString(3, p.getNome());
            pstm.setString(4, p.getCpf());
            pstm.setString(5, p.getEmail());
            pstm.setString(6, p.getTelefone());
            pstm.setString(7, p.getCtps());
            pstm.setString(8, p.getCargo());
            pstm.setString(9, p.getRg());
            pstm.setString(10, p.getSalario());
            pstm.setDate(11, new java.sql.Date(p.getDataadimissao().getTime()));
            pstm.setDate(12, new java.sql.Date(p.getDatanascimento().getTime()));
            pstm.setDate(13, new java.sql.Date(p.getDatarecisao().getTime()));
            pstm.setString(14, p.getStatus());
            pstm.setString(15, p.getExperienciaprofissional());
//            pstm.setInt(16, p.getEndereco().getCodigo());
            //Executa o comando SQL
            pstm.execute();
            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = (rs.getInt(1));
                }
            }
            //Fecha a conexão
            ConnectionFactory.closeConnection(con, pstm);
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            return retorno;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir: " + ex.getMessage());
        } finally {
            try {
                //Fecha a conxão
                ConnectionFactory.closeConnection(con);
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + ex1.getMessage());
            }
        }
        return retorno;
    }

        public List<Curriculo> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Curriculo> funcoes = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(SELECT);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Curriculo ff = new Curriculo();
                ff.setCodigo(rs.getInt("codigo"));
                ff.setNome(rs.getString("nome"));
                ff.setStatus(rs.getString("status"));
                funcoes.add(ff);
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
        return funcoes;
    }

    public boolean remove(int id) {
        boolean retorno = false;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(DELETE);
            pstm.setInt(1, id);
            pstm.execute();
            retorno = true;
            System.out.println(retorno);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex.getMessage());
        } finally {
            try {
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return retorno;
    }

    public int update(Curriculo f) {
        int retorno = -1;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            
            pstm.setString(1, f.getLogin());
            pstm.setString(2, f.getSenha());
            pstm.setString(3, f.getNome());
            pstm.setString(4, f.getCpf());
            pstm.setString(5, f.getEmail());
            pstm.setString(6, f.getTelefone());
            pstm.setString(7, f.getCtps());
            pstm.setString(8, f.getCargo());
            pstm.setString(9, f.getRg());
            pstm.setString(10,f.getSalario());
            pstm.setDate(11, new java.sql.Date(f.getDataadimissao().getTime()));
            pstm.setDate(12, new java.sql.Date(f.getDatanascimento().getTime()));
            pstm.setDate(13, new java.sql.Date(f.getDatarecisao().getTime()));
            pstm.setString(14, f.getStatus());
            pstm.setString(15, f.getExperienciaprofissional());
           // pstm.setInt(16, f.getEndereco().getCodigo());
            pstm.execute();
            retorno = f.getCodigo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao editars " + ex.getMessage());
        } finally {
            try {
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return retorno;
    }

    public Curriculo listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Curriculo ff = new Curriculo();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ff.setCodigo(rs.getInt("codigo"));
                ff.setLogin(rs.getString("login"));
                ff.setSenha(rs.getString("senha"));
                ff.setNome(rs.getString("nome"));
                ff.setCpf(rs.getString("Cpf"));
                ff.setEmail(rs.getString("email"));
                ff.setTelefone(rs.getString("telefone"));
                ff.setCtps(rs.getString("ctps"));
                ff.setCargo(rs.getString("cargo"));
                ff.setRg(rs.getString("rg"));
                ff.setSalario(rs.getString("salario"));
                ff.setDataadimissao(rs.getDate("dataadimissao"));
                ff.setDatanascimento(rs.getDate("datanascimento"));
                ff.setDatarecisao(rs.getDate("datarecisao"));
                ff.setStatus(rs.getString("status"));
                ff.setExperienciaprofissional(rs.getString("experienciaprofissional"));
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
        return ff;
    }

    public List<Curriculo> Pesquisa(String texto) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Curriculo> funcoes = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(pesquisa);
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Curriculo ff = new Curriculo();
                ff.setCodigo(rs.getInt("codigo"));
                ff.setNome(rs.getString("nome"));
                ff.setStatus(rs.getString("Status"));
                funcoes.add(ff);
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
        return funcoes;
    }
}
