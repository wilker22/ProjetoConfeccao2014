/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Meta;
import br.senai.sc.model.persistencia.dao.MetaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author douglas_ghisleri
 */
public class MetaDaoJDBC implements MetaDAO {

    private final String INSERT = "insert into meta"
            + "(dt_inicio, dt_fim, vl_produto, qt_pecas) values "
            + "(?,?,?,?)";
    private final String UPDATE = "update meta set "
            + "dt_inicio = ?, dt_fim = ?, vl_produto = ?, qt_pecas = ?"
            + "where cod_meta = ?";
    private final String DELETE = "delete from meta "
            + "where cod_meta= ?";
    private final String LIST = "select * from meta";
    private final String LISTBYID = "select * from meta "
            + "where cod_meta= ?";

    /*
     * Método que realiza a inserção de uma meta na base 
     * de dados
     * 
     */
    public boolean insert(Meta m) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);
            pstm.setDate(1, new java.sql.Date(m.getDataInicio().getTime()));
            pstm.setDate(2, new java.sql.Date(m.getDataFim().getTime()));
            pstm.setInt(3, m.getQuantidade());
            pstm.setDouble(4, m.getValor());
            pstm.execute();
            JOptionPane.showMessageDialog(null,
                    "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível efetuar a transação" + ex.getMessage());
            return false;
        }
    }

    /*
     * Método responsável por atualizar uma meta 
     * na base de dados
     */
    public boolean update(Meta m) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);
            pstm.setDate(1, new java.sql.Date(m.getDataInicio().getTime()));
            pstm.setDate(2, new java.sql.Date(m.getDataFim().getTime()));
            pstm.setInt(3, m.getQuantidade());
            pstm.setDouble(4, m.getValor());
            pstm.setInt(5, m.getCod_meta());
            pstm.execute();
            JOptionPane.showMessageDialog(null,
                    "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível efetuar a transação" + ex.getMessage());
            return false;
        }
    }

    /*
     * Método responsável por remover uma meta da base de 
     * dados.
     */
    public boolean delete(int id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);

            pstm.setInt(1, id);
            pstm.execute();
            JOptionPane.showMessageDialog(null,
                    "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível efetuar a transação");
            return false;
        }
    }

    /*
     * Método responsável por trazer as metas da base
     * de dados
     */
    public List<Meta> listAll() {
        Connection conn;
        List<Meta> metas = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Meta m = new Meta();
                m.setDataInicio(rs.getDate("dt_inicio")); 
                m.setDataFim(rs.getDate("dt_fim"));
                m.setCod_meta(rs.getInt("Cod_meta"));
                m.setValor(rs.getDouble("vl_produto"));
                m.setQuantidade(rs.getInt("qt_pecas"));

                metas.add(m);
            }
            ConnectionFactory.closeConnection(conn, pstm);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível efetuar a transação"
                    + ex.getMessage());

        }
        return metas;
    }

    /*
     * Método responsável por listar uma meta com o código 
     * enviado por parâmetro
     * 
     */
    public Meta listById(int cod_meta) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, cod_meta);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Meta m = new Meta();
                m.setDataInicio(rs.getDate("dt_inicio")); 
                m.setDataFim(rs.getDate("dt_fim"));
                m.setCod_meta(rs.getInt("Cod_meta"));
                m.setValor(rs.getDouble("vl_produto"));
                m.setQuantidade(rs.getInt("qt_pecas"));
                return m;
            }
            ConnectionFactory.closeConnection(conn, pstm);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível efetuar a transação"
                    + ex.getMessage());

        }
        return null;
    }
}
