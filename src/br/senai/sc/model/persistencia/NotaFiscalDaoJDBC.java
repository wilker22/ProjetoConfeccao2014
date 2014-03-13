package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Funcionario;
import br.senai.sc.model.negocio.NotaFiscal;
import br.senai.sc.model.negocio.Produto;
import br.senai.sc.model.persistencia.dao.NotaFiscalDAO;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class NotaFiscalDaoJDBC implements NotaFiscalDAO {

    private final String INSERT = "Insert into Nota_fiscal(dt_emissao,produtos,vl_Total,destinatario,remetente,cod_funcionario) values (?,?,?,?,?,?)";
    private final String UPDATE = "update Nota_fiscal set  dt_emissao= ?,produtos= ?,vl_Total= ?,destinatario= ?,remetente= ?,cod_funcionario=? where cod_nota_fiscal = ?";
    private final String DELETE = "delete from Nota_fiscal where cod_nota_fiscal = ?";
    private final String LIST = "select * from nota_fiscal, produtos, funcionario where nota_fiscal.produtos = produtos.cod_produto and nota_fiscal.cod_funcionario = funcionario.cod_funcionario";
    private final String LISTBYID = "select * from nota_fiscal where cod_nota_fiscal = ?";

        public int insert(NotaFiscal e) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT,
                    Statement.RETURN_GENERATED_KEYS);

            pstm.setDate(1, new java.sql.Date(e.getDataEmissao().getTime()));
            pstm.setInt(2, e.getProdutos().getCodProduto());
            pstm.setDouble(3, e.getValorTotal());
            pstm.setString(4, e.getDestinatario());
            pstm.setString(5, e.getRemetente());
            pstm.setInt(6, e.getFuncionarioResponsavel().getCod());
            pstm.execute();
            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                    rs.close();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir uma "
                    + "Nota Fiscal: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a "
                        + "conexão: " + ex.getMessage());
            }
        }
        return retorno;
    }
    /*
     * Método responsável por atualizar uma endereco na base de dados
     */

    public int update(NotaFiscal e) {
       int retorno = -1;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);

            pstm.setDate(1, new java.sql.Date(e.getDataEmissao().getTime()));
            pstm.setInt(2, e.getProdutos().getCodProduto());
            pstm.setDouble(3, e.getValorTotal());
            pstm.setString(4, e.getDestinatario());
            pstm.setString(5, e.getRemetente());
            pstm.setInt(6, e.getFuncionarioResponsavel().getCod());
            pstm.setInt(7, e.getCodNumero());
            pstm.execute();
            retorno = e.getCodNumero();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar uma "
                    + "assistência: " + ex.getMessage());

        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: "
                        + ex.getMessage());
            }
        }
        return retorno;
    }
    

    /*
     * Método responsável por remover uma endereco da base de dados
     */
    @Override
    public boolean delete(int codNumero) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);
            pstm.setInt(1, codNumero);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a transação" + ex.getMessage());
            return false;
        }
    }

    /*
     * Método responsável por trazer as enderecos da base de dados
     */
    @Override
    public List<NotaFiscal> listAll() {
        Connection conn;
        List<NotaFiscal> notasFiscais = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                NotaFiscal e = new NotaFiscal();
                e.setDataEmissao(rs.getDate("nota_fiscal.dt_emissao"));
                Produto p = new Produto();
                p.setCodProduto(rs.getInt("produtos.cod_produto"));
                p.setNome(rs.getString("produtos.descricao"));
                e.setProdutos(p);
                e.setCodNumero(rs.getInt("nota_fiscal.cod_nota_fiscal"));
                e.setValorTotal(rs.getDouble("nota_fiscal.vl_total"));
                Funcionario f = new Funcionario();
                f.setCod(rs.getInt("funcionario.cod_funcionario"));
                f.setLogin(rs.getString("funcionario.login"));
                f.setEmail(rs.getString("funcionario.email"));
                f.setCtps(rs.getString("funcionario.ctps"));
                f.setCargo(rs.getString("funcionario.cargo"));
                f.setSalario(rs.getDouble("funcionario.salario"));
                f.setDtAdmissao(rs.getDate("funcionario.dt_adimissao"));
                f.setNome("funciona");
                f.setDtRecisao(rs.getDate("funcionario.dt_recisao"));
                e.setFuncionarioResponsavel(f);
                e.setDestinatario(rs.getString("nota_fiscal.destinatario"));
                e.setRemetente(rs.getString("nota_fiscal.remetente"));
                notasFiscais.add(e);
            }
//dataEmissao,produtos,valorTotal,funcionarioResponsavel,destinatario,remetente
//            ConnectionFactory.closeConnection(conn, pstm);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a transação" + ex.getMessage());

        }
        return notasFiscais;
    }

    /*
     * Método responsável por listar uma nota fiscal com o código enviado por parâmetro
     */
    @Override
    public NotaFiscal listById(int id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                NotaFiscal e = new NotaFiscal();

                e.setDataEmissao(rs.getDate("dt_emissao"));
                Produto p = new Produto();
                p.setCodProduto(rs.getInt("cod_produto"));
                p.setNome(rs.getString("descricao"));
                e.setProdutos(p);
                e.setCodNumero(rs.getInt("cod_nota_fiscal"));
                e.setValorTotal(rs.getDouble("vl_total"));
                Funcionario f = new Funcionario();
                f.setCod(rs.getInt("cod_funcionario"));
                f.setLogin(rs.getString("login"));
                f.setEmail(rs.getString("email"));
                f.setCtps(rs.getString("ctps"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getDouble("salario"));
                f.setDtAdmissao(rs.getDate("dt_adimissao"));
                f.setDtRecisao(rs.getDate("dt_recissao"));
                e.setFuncionarioResponsavel(f);
                e.setDestinatario(rs.getString("destinatario"));
                e.setRemetente(rs.getString("remetente"));


                return e;
            }

            ConnectionFactory.closeConnection(conn, pstm);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a transação" + ex.getMessage());

        }
        return null;
    }

    @Override
    public List<NotaFiscal> listPesquisa(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
