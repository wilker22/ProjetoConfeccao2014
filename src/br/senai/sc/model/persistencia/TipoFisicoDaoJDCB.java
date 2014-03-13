/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.TipoFisico;
import br.senai.sc.model.persistencia.dao.TipoFisicoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Gustavo L. Alves
 * @version 1.0 05/11/2013
 */
public class TipoFisicoDaoJDCB implements TipoFisicoDAO {

    private final String INSERT = "Insert into tipos_fisicos(nm_tipos_fisicos, genero, descricao) values (?, ?, ?)";
    private final String UPDATE = "update tipos_fisicos set nm_tipos_fisicos = ?, genero = ?, descricao = ? where cod_tipos_fisicos = ?";
    private final String DELETE = "delete from tipos_fisicos where cod_tipos_fisicos = ?";
    private final String LIST = "select * from tipos_fisicos";
    private static final String LISTBYID = "select * from tipos_fisicos where cod_tipos_fisicos = ?";
    private static final String LISTPESQUISA = "select * from tipos_fisicos where nm_tipos_fisicos like ? or cod_tipos_fisicos like ?";

    /**
     * Método reponsável por inserir valores da base de dados.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param tf
     * @return
     */
    public int insert(TipoFisico tf) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, tf.getNome());
            pstm.setString(2, tf.getGenero());
            pstm.setString(3, tf.getDescicao());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Operação realizada sem problemas");

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro \nClasse TipoFisicoDaoJDBC INSERT \n" + ex);
            return -1;
        }
        return -1;

    }

    /**
     * Método reponsável por atualizar valores da base de dados.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param tf
     * @return
     */
    public boolean update(TipoFisico tf) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, tf.getNome());
            pstm.setString(2, tf.getGenero());
            pstm.setString(3, tf.getDescicao());
            pstm.setInt(4, tf.getCodigo());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Operação realizada sem problemas");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro \nClasse TipoFisicoDaoJDBC UPDATE \n" + ex);
            return false;
        }
    }

    /**
     * Método reponsável por deletar valores da base de dados.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */
    public boolean delete(int id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);
            pstm.setInt(1, id);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Operação realizada sem problemas");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro \nClasse TipoFisicoDaoJDBC DELETE\n " + ex);
            return false;
        }

    }

    /**
     * Método reponsável por listar valores da base de dados.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @return
     */
    public List<TipoFisico> listAll() {
        Connection conn;
        List<TipoFisico> tipofisico = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                TipoFisico tf = new TipoFisico();
                tf.setCodigo(rs.getInt("cod_tipos_fisicos"));
                tf.setNome(rs.getString("nm_tipos_fisicos"));
                tf.setGenero(rs.getString("genero"));
                tf.setDescicao(rs.getString("descricao"));
                tipofisico.add(tf);
            }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro \nClasse TipoFisicoDaoJDBC LISTAR \n " + ex);
        }
        return tipofisico;
    }

    /**
     * Método reponsável por listar valores por id da base de dados.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */
    public TipoFisico listById(int id) {

        Connection con;

        try {

            con = ConnectionFactory.getConnection();
            PreparedStatement pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                TipoFisico tf = new TipoFisico();

                tf.setCodigo(rs.getInt("cod_tipos_fisicos"));
                tf.setNome(rs.getString("nm_tipos_fisicos"));
                tf.setDescicao(rs.getString("descricao"));
                tf.setGenero(rs.getString("genero"));
                return tf;
            }
            ConnectionFactory.closeConnection(con, pstm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação \nClasse TipoFisicoDaoJDBC LISTARID \n" + ex.getMessage());
        }

        return null;


    }

    /**
     * Método reponsável por pesquisar valores na base de dados.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param texto
     * @return
     */
    public List<TipoFisico> ListPesquisa(String texto) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<TipoFisico> tipofisicos = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTPESQUISA);
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");

            rs = pstm.executeQuery();
            while (rs.next()) {
                TipoFisico tf = new TipoFisico();

                tf.setCodigo(rs.getInt("cod_tipos_fisicos"));
                tf.setNome(rs.getString("nm_tipos_fisicos"));
                tf.setGenero(rs.getString("genero"));
                tf.setDescicao(rs.getString("descricao"));

                tipofisicos.add(tf);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar \nClasse TipoFisicoDaoJDBC PESQUISAR \n" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão \nClasse TipoFisicoDaoJDBC PESQUISAR \n" + e.getMessage());
            }
            return tipofisicos;
        }
    }
}
