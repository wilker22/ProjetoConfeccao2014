package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Endereco;
import br.senai.sc.model.persistencia.dao.EnderecoDAON;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/*
* Responsável pelos métodos do Banco de Dados
* da classe Endereço.
* @author gustavo_cm
* @version 1.0 06/11/2013
* @param Endereço
*/
public class EnderecoDAOJDBC implements EnderecoDAON {

    private static final String PESQUISA =
            "SELECT * from cadastro_endereco\n" +
"where rua like ? or bairro like ? or cidade like ? or cep like ? or complemento like ? or numero like ? ";
    
    private static final String REMOVE =
            "delete from cadastro_endereco where codigo =?";
    private static final String UPDATE =
            "update cadastro_endereco set Rua = ?, bairro = ?, Cidade = ?, Cep = ?, Complemento = ?, numero = ? where Codigo = ?";
    private static final String LISTBYID =
            "select * from cadastro_endereco where codigo =? ";
    private static final String LIST =
            "select * from cadastro_endereco;";
    private static final String INSERT =
            "insert into cadastro_endereco( rua, bairro, cidade, cep, complemento, numero)\n"
            + "            values (?,?,?,?,?,?)";

    
/**
* Responsável por inserir no Banco de Dados.
* @author gustavo_cm
* @version 1.0 06/11/2013
*@param Endereço
*/
    public int insert(Endereco p) {

        Connection con = null;
        PreparedStatement pstm = null;
        int resposta = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT,
                    Statement.RETURN_GENERATED_KEYS);


            pstm.setString(1, p.getRua());
            pstm.setString(2, p.getBairro());
            pstm.setString(3, p.getCidade());
            pstm.setString(4, p.getCep());
            pstm.setString(5, p.getComplemento());
            pstm.setDouble(6, p.getNumero());
            pstm.execute();
            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    resposta = rs.getInt(1);
                    rs.close();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao inserir Endereço"
                    + e.getMessage());

        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Erro ao fechar a conexão");

            }
        }
        return resposta;
    }
/**
* Responsável por lista todos os Endereços.
* @author gustavo_cm
* @version 1.0 06/11/2013
* @param Endereço
*/
    
    public List<Endereco> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Endereco> pessoas = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Endereco p = new Endereco();
                p.setCodigo(rs.getInt("codigo"));
                p.setRua(rs.getString("rua"));
                p.setBairro(rs.getString("bairro"));
                p.setCidade(rs.getString("cidade"));
                p.setCep(rs.getString("cep"));
                p.setComplemento(rs.getString("complemento"));
                p.setNumero(rs.getInt("numero"));
                pessoas.add(p);


            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao listar os Endereço"
                    + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Erro ao fechar a conexão."
                        + e.getMessage());


            }

        }

        return pessoas;

    }

/**
* Responsável por altera o registro no Banco de Dados.
* @author gustavo_cm
* @version 1.0 06/11/2013
* @param Endereço
*/

    public int update(Endereco e) {
        Connection con = null;
        PreparedStatement pstm = null;
        int resposta = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);


            pstm.setString(1, e.getRua());
            pstm.setString(2, e.getBairro());
            pstm.setString(3, e.getCidade());
            pstm.setString(4, e.getCep());
            pstm.setString(5, e.getComplemento());
            pstm.setDouble(6, e.getNumero());
            pstm.setInt(7, e.getCodigo());
            pstm.execute();
            resposta = e.getCodigo();
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao inserir Endereço"
                    + a.getMessage());
            
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null,
                        "Erro ao fechar a conexão");

            }
        }
        return resposta;
    }

 /**
* Responsável por remover os endereços no Banco de Dados.
* @author gustavo_cm
* @version 1.0 06/11/2013
* @param Endereço
*/
 
    public boolean remove(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        boolean resposta = false;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(REMOVE);
            
            pstm.setInt(1, id);

            pstm.execute();
            resposta = true;
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao remover Endereço"
                    + a.getMessage());
            
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null,
                        "Erro ao fechar a conexão");

            }
        }
        return resposta;
    }

/**
* Responsável por lista por id no Banco de Dados.
* @author gustavo_cm
* @version  1.0 06/11/2013
* @param Endereço
*/
 
    public Endereco listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Endereco p = new Endereco();

        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {

                p.setCodigo(rs.getInt("codigo"));
                p.setRua(rs.getString("rua"));
                p.setBairro(rs.getString("bairro"));
                p.setCidade(rs.getString("cidade"));
                p.setCep(rs.getString("cep"));
                p.setComplemento(rs.getString("complemento"));
                p.setNumero(rs.getInt("numero"));



            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao listar os Endereço"
                    + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Erro ao fechar a conexão."
                        + e.getMessage());


            }

        }

        return p;
    }

    
/**
* Responsável por lista através da pesquisa.
* @author gustavo_cm
* @version 1.0 06/11/2013
* @param Endereço
*/
    public List<Endereco> pesquisar(String text) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Endereco> pessoas = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(PESQUISA);
            pstm.setString(1,"%"+ text +"%");
            pstm.setString(2,"%"+ text +"%");
            pstm.setString(3,"%"+ text +"%");
            pstm.setString(4,"%"+ text +"%");
            pstm.setString(5,"%"+ text +"%");
            pstm.setString(6,"%"+ text +"%");
            rs = pstm.executeQuery();

            while (rs.next()) {
                Endereco p = new Endereco();
                p.setCodigo(rs.getInt("codigo"));
                p.setRua(rs.getString("rua"));
                p.setBairro(rs.getString("bairro"));
                p.setCidade(rs.getString("cidade"));
                p.setCep(rs.getString("cep"));
                p.setComplemento(rs.getString("complemento"));
                p.setNumero(rs.getInt("numero"));
                pessoas.add(p);


            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao listar os Endereço"
                    + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Erro ao fechar a conexão."
                        + e.getMessage());


            }

        }

        return pessoas;
    }
}