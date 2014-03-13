/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;


import br.senai.sc.model.negocio.Conserto;
import br.senai.sc.model.persistencia.dao.ConsertoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo_cardoso
 */
public class ConsertoDAOJDBC implements ConsertoDAO {

    private static final String LIST =
            "select * from cadastro_conserto;";
    private static final String INSERT =
            "insert into(codigo, dataEnvio, dataRecebimento, assistencia, descricaoProblema)"
            + "values (?,?,?,?,?)";

    @Override
    public int insert(Conserto c) {

        Connection con = null;
        PreparedStatement pstm = null;
        int resposta = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT,
                    Statement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, c.getDataEnvio());
            pstm.setInt(2, c.getDataRecebimento());
            pstm.setString(3, c.getAssistencia());
            pstm.setString(4, c.getDescricaoProblema());

            pstm.execute();
            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    resposta = rs.getInt(1);
                    c.setCodigo(resposta);
                }
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,
                    "Erro ao inserir conserto"
                    + e.getMessage());

        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null,
                        "Erro ao fechar a conexão");

            }
        }
        return resposta;
    }

    public List<Conserto> listAll() {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Conserto> concertos =
                new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Conserto c = new Conserto();
                c.setCodigo(rs.getInt("codigo"));
                c.setDataEnvio(rs.getInt("DataEnvio"));
                c.setDataRecebimento(rs.getInt("DataRecebimento"));
                c.setAssistencia(rs.getString("Assistencia"));
                c.setDescricaoProblema(rs.getString("DescricaoProblema"));

                concertos.add(c);


            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,
                    "Erro ao listar conserto"
                    + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null,
                        "Erro ao fechar a conexão."
                        + e.getMessage());


            }

        }
        return concertos;
    }
}
