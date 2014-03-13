/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Medida;
import br.senai.sc.model.negocio.Usuario;
import br.senai.sc.model.persistencia.dao.MedidaDAO;
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
public class MedidaDaoJDBC implements MedidaDAO {

    private final String INSERT = "Insert into medidas(id_usuario, md_busto, md_cintura, md_quadril, md_ombros, md_altura) values (?, ?, ?, ?, ?, ?)";
    private final String UPDATE = "update medidas set id_usuario = ?, md_busto = ?, md_cintura = ?, md_quadril = ?, md_ombros = ?, md_altura = ? where cod_medida = ?";
    private final String DELETE = "delete from medidas where cod_medida = ?";
    private final String LIST = "select * from medidas";
    private static final String LISTBYID = "select * from medidas where cod_medida = ?";
    private static final String LISTPESQUISA = "select * from medidas where cod_medida like ? or id_usuario like ?";

    /**
     * Método reponsável por inserir valores na base de dados.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param m
     * @return
     */
    public int insert(Medida m) {
        Connection conn;

        try {
            conn = ConnectionFactory.getConnection();

            PreparedStatement pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, m.getUsuario().getCod());
            pstm.setDouble(2, m.getMdBusto());
            pstm.setDouble(3, m.getMdCintura());
            pstm.setDouble(4, m.getMdQuadril());
            pstm.setDouble(5, m.getMdOmbros());
            pstm.setDouble(6, m.getAltura());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Operação realizada sem problemas");

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }

            }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro \nClasse MedidaDaoJDBC INSERT \n" + ex);
            return -1;
        }
        return -1;
    }

    /**
     * Método reponsável por atualizar valores na base de dados.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param m
     * @return
     */
    public boolean update(Medida m) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);
            pstm.setInt(1, m.getUsuario().getCod());
            pstm.setDouble(2, m.getMdBusto());
            pstm.setDouble(3, m.getMdCintura());
            pstm.setDouble(4, m.getMdQuadril());
            pstm.setDouble(5, m.getMdOmbros());
            pstm.setDouble(6, m.getAltura());
            pstm.setInt(7, m.getCodigo());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Operação realizada sem problemas");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro\nClasse MedidaDaoJDBC UPDATE \n " + ex);
            return false;
        }
    }

    /**
     * Método reponsável por deletar valores na base de dados.
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
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a transação \nClasse MedidaDaoJDBC DELETE \n" + e.getMessage());
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
    public List<Medida> listall() {
        List<Medida> medidas = new ArrayList<>();
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                Medida m = new Medida();

                m.setCodigo(rs.getInt("cod_medida"));
                m.setMdBusto(rs.getDouble("md_busto"));
                m.setMdCintura(rs.getDouble("md_cintura"));
                m.setMdQuadril(rs.getDouble("md_quadril"));
                m.setMdOmbros(rs.getDouble("md_ombros"));
                m.setAltura(rs.getDouble("md_altura"));

                Usuario u = new Usuario();
                u.setNome(rs.getString("id_usuario"));
                m.setUsuario(u);
                medidas.add(m);

            }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro \nClasse MedidaDaoJDBC LISTALL \n " + ex.getMessage());
        }
        return medidas;
    }

    /**
     * Método reponsável por pesquisar valores na base de dados.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param texto
     * @return
     */
    public List<Medida> ListPesquisa(String texto) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Medida> medidas = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTPESQUISA);
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");

            rs = pstm.executeQuery();
            while (rs.next()) {
                Medida m = new Medida();
                Usuario u = new Usuario();

                m.setCodigo(rs.getInt("cod_medida"));

                u.setNome(rs.getString("id_usuario"));
                m.setUsuario(u);

                m.setMdBusto(rs.getDouble("md_busto"));
                m.setMdCintura(rs.getDouble("md_cintura"));
                m.setMdQuadril(rs.getDouble("md_quadril"));
                m.setMdOmbros(rs.getDouble("md_ombros"));
                m.setAltura(rs.getDouble("md_altura"));

                medidas.add(m);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar \nClasse MedidaDaoJDBC PESQUISAR \n" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão \nClasse MedidaDaoJDBC PESQUISAR \n" + e.getMessage());
            }
            return medidas;
        }

    }

    /**
     * Método reponsável por listar valores por id da base de dados.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */
    public Medida listById(int id) {

        Connection con;

        try {

            con = ConnectionFactory.getConnection();
            PreparedStatement pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                Medida m = new Medida();

                Usuario u = new Usuario();

                m.setCodigo(rs.getInt("cod_medida"));

                u.setNome(rs.getString("id_usuario"));
                m.setUsuario(u);

                m.setMdBusto(rs.getDouble("md_busto"));
                m.setMdCintura(rs.getDouble("md_cintura"));
                m.setMdQuadril(rs.getDouble("md_quadril"));
                m.setMdOmbros(rs.getDouble("md_ombros"));
                m.setAltura(rs.getDouble("md_altura"));

                return m;

            }

            ConnectionFactory.closeConnection(con, pstm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação \nClasse MedidaDaoJDBC LISTARID \n" + ex.getMessage());
        }

        return null;


    }
}
