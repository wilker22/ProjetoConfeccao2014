/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Ferias;
import br.senai.sc.model.negocio.Funcionario;
import br.senai.sc.model.persistencia.dao.FeriasDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author larissa_mezari
 */
public class FeriasDaoJDBC implements FeriasDAO {

    private final String INSERT = "insert into ferias(cod_funcionario, dt_inicio, dt_fim) values (?, ?, ?)";
    private final String UPDATE = "update ferias set cod_funcionario = ?, "
            + "dt_inicio = ?, dt_fim  where id = ?";
    private final String DELETE = "delete from ferias where id = ?";
    private final String LIST = "select fr.cod_ferias, fr.dt_inicio, fr.dt_fim, "
            + "fn.login, fn.email, fn.ctps, fn.cargo, fn.salario, fn.dt_admissao, fn.dt_recisao, fn.nome, fn.cpf, fn.rg, fn.dt_nascimento, fn.telefone, fn.endereco, fn.dt_cadastro from ferias fr INNER JOIN funcionario fn ON (fr.cod_funcionario = fn.cod_funcionario)";
    private static final String LISTBYID = "select * from ferias where cod_funcionario = ?";
    /*
     * Método que realiza a inserção de uma pessoa na base de dados
     */

    public boolean insert(Ferias f) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);
            Funcionario fu = new Funcionario();

            pstm.setInt(1, f.getFuncionario().getCod());
            pstm.setDate(2, (Date) new java.sql.Date(f.getDataFim().getTime()));
            pstm.setDate(3, (Date) new java.sql.Date(f.getDataInicio().getTime()));
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso ");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir "
                    + e.getMessage());
            return false;
        }
    }

    /*
     * Método responsável por atualizar uma pessoa na base de dados
     */
    public boolean update(Ferias f) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);
            Funcionario fu = new Funcionario();
            pstm.setInt(1, f.getFuncionario().getCod());
            pstm.setDate(2, (Date) new java.sql.Date(f.getDataFim().getTime()));
            pstm.setDate(3, (Date) new java.sql.Date(f.getDataInicio().getTime()));
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Atualização feita com"
                    + "sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível fazer a "
                    + "atualização");
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
            JOptionPane.showMessageDialog(null, "Deletado com "
                    + "sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível deletar ");
            return false;
        }
    }

    /*
     * Método responsável por trazer as pessoas da base de dados
     */
    public List<Ferias> listAll() {
        Connection conn;
        List<Ferias> ferias = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Ferias f = new Ferias();

                Funcionario fu = new Funcionario();
                fu.setCod(rs.getInt("cod_funcionario"));
                fu.setLogin(rs.getString("login"));
                fu.setEmail(rs.getString("email"));
                fu.setCtps(rs.getString("ctps"));
                fu.setCargo(rs.getString("cargo"));
                fu.setSalario(rs.getDouble("salario"));
                fu.setDtAdmissao(rs.getDate("dt_admissao"));
                fu.setDtRecisao(rs.getDate("dt_recisao"));
                fu.setNome(rs.getString("nome"));
                fu.setCpf(rs.getString("cpf"));
                fu.setRg(rs.getString("rg"));
                fu.setDtNascimento(rs.getDate("dt_nascimento"));
                fu.setTelefone(rs.getString("telefone"));
                fu.setEndereco(rs.getString("endereco"));
                fu.setDtCadastro(rs.getDate("dt_cadastro"));

                f.setFuncionario(fu);
                f.setDataInicio(rs.getDate("dt_inicio"));
                f.setDataFim(rs.getDate("dt_fim"));
                Ferias.add(f);

            }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar "
                    + e.getMessage());
        }
        return ferias;
    }

    public Ferias listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Ferias ff = new Ferias();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario fu = new Funcionario();
                fu.setCod(rs.getInt("cod_funcionario"));

                ff.setDataInicio(rs.getDate("dt_inicio"));
                ff.setDataFim(rs.getDate("da_fim"));
                return ff;

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
}
