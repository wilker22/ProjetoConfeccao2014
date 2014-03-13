/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Devolucao;
import br.senai.sc.model.persistencia.dao.DevolucaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * Classe responsável pelos métodos de banco da Classe Fabricante
 * @author douglas_ghisleri
 * @version 1.0 16/09/2013
 * @param p
 * @return
 */
public class DevolucaoDaoJDBC implements DevolucaoDAO {

    private final String INSERT = "insert into devolucao"
            + "(peca, dt_devolucao, qt_devolucao) values "
            + "(?,?,?)";
    private final String UPDATE = "update devolucao set "
            + "peca = ?, dt_devolucao = ?, qt_devolucao = ?"
            + "where cod_devolucao = ?";
    private final String DELETE = "delete from devolucao "
            + "where cod_devolucao = ?";
    private final String LIST = "select * from devolucao";
    private final String LISTBYID = "select * from devolucao "
            + "where cod_devolucao = ?";

    /* INSERÇÃO */
    /**
     * Método responsável pela inserção no banco de dados
     *
     * @author douglas_ghisleri
     * @since 1.0 05/11/2013
     *
     */
    public int insert(Devolucao d) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, d.getPeca());
            pstm.setDate(2, new java.sql.Date(d.getDataDevolucao().getTime()));
            pstm.setInt(3, d.getQuantidade());
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = (rs.getInt(1));
                }
            }


            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, pstm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão." + "\n" + ex.getMessage());
            }
        }
        return retorno;
    }

    /**
     * Método responsável pela alteração do registro no banco de dados
     *
     * @author douglas_ghisleri
     * @since 1.0 05/11/2013
     */
    /* ALTERAÇÃO */
    public int update(Devolucao d) {
        int retorno = -1;
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);
            pstm.setDate(1, new java.sql.Date(d.getDataDevolucao().getTime()));
            pstm.setString(2, d.getPeca());
            pstm.setInt(3, d.getQuantidade());
            pstm.setInt(4, d.getCod_devolucao());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            retorno = d.getCod_devolucao();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, pstm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão." + "\n" + ex.getMessage());
            }
        }
        return retorno;
    }

    /**
     * Método responsável pela deleção do registro no banco de dados
     *
     * @author douglas_ghisleri
     * @since 1.0 05/11/2013
     * @param dev
     * @return
     */
    /* DELEÇÃO */
        public boolean delete(int cod_devolucao) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);

            pstm.setInt(1, cod_devolucao);
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
     * Método responsável por trazer as devolucoes da base
     * de dados
     */
    public List<Devolucao> listAll() {
        Connection conn;
        List<Devolucao> devolucoes = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Devolucao d = new Devolucao();
                d.setPeca(rs.getString("Peca"));
                d.setDataDevolucao(rs.getDate("dt_devolucao"));
                d.setCod_devolucao(rs.getInt("cod_devolucao"));
                d.setQuantidade(rs.getInt("qt_devolucao"));

                devolucoes.add(d);
            }
            ConnectionFactory.closeConnection(conn, pstm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível efetuar a transação"
                    + e.getMessage());

        }
        return devolucoes;
    }

    /*
     * Método responsável por listar uma devolucao com o código 
     * enviado por parâmetro
     * 
     */
    public Devolucao listById(int cod_devolucao) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, cod_devolucao);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Devolucao d = new Devolucao();
                d.setPeca(rs.getString("Peca"));
                d.setDataDevolucao(rs.getDate("dt_devolucao"));
                d.setCod_devolucao(rs.getInt("cod_devolucao"));
                d.setQuantidade(rs.getInt("qt_devolucao"));
                return d;
            }
            ConnectionFactory.closeConnection(conn, pstm);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível efetuar a transação"
                    + ex.getMessage());

        }
        return null;
    }

    /*PESQUISA*/
    /**
     * Método responsável pela listagem atraves da pesquisa
     *
     * @author douglas_ghisleri
     * @since 1.0 05/11/2013
     * @param texto
     * @return
     */
        public List<Devolucao> ListPesquisar(String texto) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Devolucao> devs = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
           // pstm = con.prepareStatement();
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");
            pstm.setString(3, "%" + texto + "%");
            pstm.setString(4, "%" + texto + "%");



            rs = pstm.executeQuery();
            while (rs.next()) {
                Devolucao dev = new Devolucao();
                dev.setCod_devolucao(Integer.parseInt(rs.getString("cod_devolucao")));
                dev.setPeca(rs.getString("Peça"));
               // dev.setDataDevolucao(rs.getString("Data devolucao"));
               // dev.setQuantidade(rs.getString("quantidade"));




                devs.add(dev);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
            return devs;
        }
    }

    @Override
    public boolean delete(Devolucao d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
