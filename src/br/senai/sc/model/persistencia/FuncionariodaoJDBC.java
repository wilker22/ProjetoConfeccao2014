package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Funcionario;
import br.senai.sc.model.persistencia.dao.FuncionarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @version 1.0 16/09/2013
 * @author Patricia Gageiro
 */
public class FuncionariodaoJDBC implements FuncionarioDAO {

    private static final String INSERT = "insert into funcionario( nome, cpf, rg, telefone,  dt_nascimento, endereco,  login, email, ctps, cargo, salario, dt_cadastro, dt_admissao, dt_recisao) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "update funcionario set nome = ? , cpf = ? , rg = ?,telefone = ?,  dt_nascimento = ?, login = ?, email = ?, ctps = ?, cargo = ?, salario = ?,dt_cadastro = ?,  dt_admissao = ?, dt_recisao = ? where cod_funcionario = ?";
    private static final String DELETE = "delete from funcionario where cod_funcionario = ?";
    private static final String LIST = "select * from funcionario";
    private static final String LISTBYID = "select * from funcionario where cod_funcionario = ?";
    private static final String LISTPESQUISA = "select * from funcionario where cod_funcionario like ? or nome like ?";

    /**
     * Método que serve para inserir um funcionário no banco de dados.
     *
     * @author Patricia Gageiro
     * @since 1.0 05/11/2013
     * @param fun
     * @return
     */
    public int insert(Funcionario fun) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;

        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            pstm.setString(1, fun.getNome());
            pstm.setString(2, fun.getCpf());
            pstm.setString(3, fun.getRg());
            pstm.setString(4, fun.getTelefone().toString());

            pstm.setDate(5, new java.sql.Date(fun.getDtNascimento().getTime()));
            pstm.setString(6, fun.getEndereco());

            pstm.setString(7, fun.getLogin());
            pstm.setString(8, fun.getEmail());
            pstm.setString(9, fun.getCtps());
            pstm.setString(10, fun.getCargo());
            pstm.setDouble(11, fun.getSalario());
            pstm.setDate(12, new java.sql.Date(fun.getDtCadastro().getTime()));
            pstm.setDate(13, new java.sql.Date(fun.getDtAdmissao().getTime()));
            pstm.setDate(14, new java.sql.Date(fun.getDtRecisao().getTime()));
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = (rs.getInt(1));
                }
            }


            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão." + "\n" + ex.getMessage());
            }
        }
        return retorno;
    }

    /**
     * Método que serve para atualizar um funcionário no banco de dados.
     *
     * @author Patricia Gageiro
     * @since 1.0 05/11/2013
     * @param fun
     * @return
     */
    public boolean update(Funcionario fun) {
        Connection con;

        try {
            con = ConnectionFactory.getConnection();
            PreparedStatement pstm = con.prepareStatement(UPDATE);

            pstm.setString(1, fun.getNome());
            pstm.setString(2, fun.getCpf());
            pstm.setString(3, fun.getRg());
            pstm.setString(4, fun.getTelefone().toString());
            pstm.setDate(5, new java.sql.Date(fun.getDtNascimento().getTime()));
            pstm.setString(6, fun.getLogin());
            pstm.setString(7, fun.getEmail());
            pstm.setString(8, fun.getCtps());
            pstm.setString(9, fun.getCargo());
            pstm.setString(10, Double.toString(fun.getSalario()));
            pstm.setDate(11, new java.sql.Date(fun.getDtCadastro().getTime()));
            pstm.setDate(12, new java.sql.Date(fun.getDtAdmissao().getTime()));
            pstm.setDate(13, new java.sql.Date(fun.getDtRecisao().getTime()));
            pstm.setInt(14, fun.getCod());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação" + ex.getMessage());
            return false;
        }
    }

    /**
     * Método que serve para deletar um funcionário no banco de dados.
     *
     * @author Patricia Gageiro
     * @since 1.0 05/11/2013
     * @param fun
     * @return
     */
    public boolean delete(Funcionario fun) {
        Connection con;

        try {
            con = ConnectionFactory.getConnection();
            PreparedStatement pstm = con.prepareStatement(DELETE);
            pstm.setInt(1, fun.getCod());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação" + ex.getMessage());
            return false;
        }
    }

    /**
     * Método que serve para fazer a listagem por id de um funcionário.
     *
     * @author Patricia Gageiro
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */
    public Funcionario listById(int id) {
        Connection con;

        try {

            con = ConnectionFactory.getConnection();
            PreparedStatement pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario fun = new Funcionario();
                fun.setCod(rs.getInt("cod_funcionario"));
                fun.setLogin(rs.getString("login"));
                fun.setEmail(rs.getString("email"));
                fun.setCtps(rs.getString("ctps"));
                fun.setCargo(rs.getString("cargo"));
                fun.setSalario(rs.getDouble("salario"));
                fun.setDtAdmissao(rs.getDate("dt_admissao"));
                fun.setDtRecisao(rs.getDate("dt_recisao"));
                fun.setDtNascimento(rs.getDate("dt_nascimento"));
                fun.setDtCadastro(rs.getDate("dt_cadastro"));
                fun.setNome(rs.getString("nome"));
                fun.setCpf(rs.getString("cpf"));
                fun.setRg(rs.getString("rg"));
                fun.setEndereco(rs.getString("endereco"));
                fun.setTelefone(rs.getString("telefone"));
                return fun;

            }

            ConnectionFactory.closeConnection(con, pstm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação" + ex.getMessage());
        }

        return null;

    }

    /**
     * Método que serve para realizar a listagem dos funcionários.
     *
     * @author Patricia Gageiro
     * @since 1.0 05/11/2013
     * @param f
     * @return
     */
    @Override
    public List<Funcionario> listAll() {
        Connection con;
        List<Funcionario> funcionarios = new ArrayList<>();


        try {
            con = ConnectionFactory.getConnection();
            PreparedStatement pstm = con.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario fun = new Funcionario();
                fun.setCod(rs.getInt("cod_funcionario"));
                fun.setNome(rs.getString("nome"));
                fun.setEmail(rs.getString("email"));
                fun.setTelefone(rs.getString("telefone"));


                funcionarios.add(fun);

            }
            ConnectionFactory.closeConnection(con, pstm);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação" + ex.getMessage());

        }
        return funcionarios;
    }

    /**
     * Método que serve para realizar a listagem por pesquisa de um funcionário.
     * @author Patricia Gageiro
     * @since 1.0 05/11/2013
     * @param texto
     * @return
     */
    @Override
    public List<Funcionario> ListPesquisa(String texto) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTPESQUISA);
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");




            rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario fun = new Funcionario();
                fun.setCod(rs.getInt("cod_funcionario"));
                fun.setNome(rs.getString("nome"));
                fun.setEmail(rs.getString("email"));
                fun.setTelefone(rs.getString("telefone"));



                funcionarios.add(fun);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
            return funcionarios;
        }
    }
}
