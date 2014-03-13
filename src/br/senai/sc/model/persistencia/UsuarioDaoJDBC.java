/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Usuario;
import br.senai.sc.model.persistencia.dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author larissa_mezari
 */
public class UsuarioDaoJDBC implements UsuarioDAO {

    private final String INSERT = "insert into usuario(login, senha, nm_usuario, cpf, email, dt_nascimento, telefone, dt_cadastro, rg) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE = "update usuario set login = ?, senha = ?, nm_usuario = ?, cpf = ?, email = ?, dt_nascimento = ?, rg = ?, endereco = ?, telefone = ?, dt_cadastro = ? where cod_usuario = ?";
    private final String DELETE = "delete from usuario where cod_usuario = ?";
    private final String LIST = "select * from usuario";
    private static final String LISTBYID = "select * from usuario where cod_usuario = ?";
    private static final String PESQUISA = "select * from usuario where "
            + "cod_usuario like ? or nm_usuario like ?";

    /*
     * Método que realiza a inserção de uma pessoa na base de dados
     */

    @Override
    public boolean insert(Usuario u) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);
           //insert into usuario(login, senha, nm_usuario, cpf, email, dt_nascimento, telefone, dt_cadastro, rg) values (?, ?, ?, ?, ?, ?, ?, ?, ?)
            pstm.setString(1, u.getLogin());
            pstm.setString(2, u.getSenha());
            pstm.setString(3, u.getNome());
            pstm.setString(4, u.getCpf());
            pstm.setString(5, u.getEmail());
            pstm.setDate(6, new java.sql.Date(u.getDtNascimento().getTime()));
//           
//            pstm.setString(8, u.getEndereco());
            pstm.setString(7, u.getTelefone());
            pstm.setDate(8, new java.sql.Date(u.getDtCadastro().getTime()));
             pstm.setString(9, u.getRg());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com "
                    + "sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o "
                    + "usuario" + e.getMessage());
            return false;
        }
    }

    /*
     * Método responsável por atualizar uma pessoa na base de dados
     */
    public boolean update(Usuario u) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);

            pstm.setInt(1, u.getCod());
            pstm.setString(2, u.getLogin());
            pstm.setString(3, u.getSenha());
            pstm.setString(4, u.getNome());
            pstm.setString(5, u.getCpf());
            pstm.setString(6, u.getEmail());
            pstm.setDate(7, new java.sql.Date(u.getDtNascimento().getTime()));
            pstm.setString(8, u.getRg());
            pstm.setString(9, u.getEndereco());
            pstm.setString(10, u.getTelefone());
            pstm.setDate(11, new java.sql.Date(u.getDtCadastro().getTime()));

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Usuario atualizado com "
                    + "sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o "
                    + "usuario" + e.getMessage());
            return false;
        }
    }

    /*
     * Método responsável por remover uma pessoa da base de dados
     */
    public boolean delete(int id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);

            pstm.setInt(1, id);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso ");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível deletar");
            return false;
        }
    }

    /*
     * Método responsável por trazer as pessoas da base de dados
     */
    public List<Usuario> listAll() {
        Connection conn;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setCod(rs.getInt("cod_usuario"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setNome(rs.getString("nm_usuario"));
                u.setCpf(rs.getString("cpf"));
                u.setEmail(rs.getString("email"));
                u.setDtNascimento(rs.getDate("dt_nascimento"));
                u.setRg(rs.getString("rg"));
                u.setEndereco(rs.getString("endereco"));
                u.setTelefone(rs.getString("telefone"));
                u.setDtCadastro(rs.getDate("dt_cadastro"));

                usuarios.add(u);

            }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a "
                    + "transação: " + e.getMessage());
        }
        return usuarios;
    }

    public Usuario listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Usuario u = new Usuario();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                u.setCod(rs.getInt("cod_usuario"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setNome(rs.getString("nm_usuario"));
                u.setCpf(rs.getString("cpf"));
                u.setEmail(rs.getString("email"));
                u.setDtNascimento(rs.getDate("dt_nascimento"));
                
                return u;

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
        return u;
    }

    public List<Usuario> listPesquisa(String texto) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(PESQUISA);
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setCod(rs.getInt("cod_usuario"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setNome(rs.getString("nm_usuario"));
                u.setEmail(rs.getString("email"));
                
                usuarios.add(u);
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
        return usuarios;
    }
    
    
}
