/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.controller.CategoriaColecaoController;
import br.senai.sc.controller.FuncionarioController;
import br.senai.sc.model.negocio.CategoriaColecao;
import br.senai.sc.model.negocio.Colecao;
import br.senai.sc.model.negocio.Funcionario;
import br.senai.sc.model.persistencia.dao.ColecaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Arsênio
 */
public class ColecaoDaoJDBC implements ColecaoDAO {

    //Strings com os comandos SQL
    private static final String INSERT = "INSERT INTO colecao VALUES "
            + "(null, ?, ?, ? ,? ,?)";
    private static final String UPDATE = "UPDATE colecao set estacao = ?, ano = ?, pub_alvo = ?, cod_funcionario = ?, categoria_colecao_cod_categoria = ? where cod_colecao = ?";
    private static final String DELETE = "DELETE FROM colecao "
            + "WHERE cod_colecao = ?";
    private static final String SELECT = "select * from colecao";
    private static final String SELECTBYID = "select * from colecao where cod_colecao = ?";
    private static final String SELECTBYNAME = "select * from colecao where estacao like ? or cod_colecao like ?";

    //Método de inserção de valores da tabela categoria_colecao
    @Override
    public int insert(Colecao c) {
        int retorno = -1;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, c.getEstacaoColecao());
            pstm.setInt(2, c.getAnoColecao());
            pstm.setString(3, c.getPubAlvoColecao());
            pstm.setInt(4, c.getCategoriaColecao().getCodCategoriaColecao());
            pstm.setInt(5, c.getFunResponsavelColecao().getCod());
            pstm.execute();
            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = (rs.getInt(1));
                }
            }
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão!" + "\n" + ex.getMessage());
            }
        }
        return retorno;
    }

    @Override
    public int update(Colecao c) {
        int retorno = -1;
        Connection con = null;
        PreparedStatement pstm = null;
        
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, c.getEstacaoColecao());
            pstm.setInt(2, c.getAnoColecao());
            pstm.setString(3, c.getPubAlvoColecao());
            pstm.setInt(4, c.getFunResponsavelColecao().getCod());
            pstm.setInt(5, c.getCategoriaColecao().getCodCategoriaColecao());
            pstm.setInt(6, c.getCodColecao());
            pstm.execute();
            retorno = c.getCodColecao();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão!" + "\n" + ex.getMessage());
            }
        }
        return retorno;
    }
    
    @Override
    public boolean delete(int cod) {
        Connection con = null;
        PreparedStatement pstm = null;
        
        try {
            con = ConnectionFactory.getConnection();         
            pstm = con.prepareStatement(DELETE);                     
            pstm.setInt(1, cod);      
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
            return false;
        } finally {
            try {        
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão!" + "\n" + ex.getMessage());
            }
        }
    }

    @Override
    public List<Colecao> listAll() {     
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstm = null; 
        List<Colecao> listaColecao = new ArrayList();
        CategoriaColecaoController ccc = new CategoriaColecaoController();
        FuncionarioController fc = new FuncionarioController();
        try {
            //Abre a conexão
            con = ConnectionFactory.getConnection();
            //Executa o comando SQL, no caso o comando SELECT
            pstm = con.prepareStatement(SELECT);
            //Executa o comando SQL dentro do ResultSet rs
            rs = pstm.executeQuery();
            //Percorre a lista colocando os resultados dentro do ResultSet rs
            while (rs.next()) {
                Colecao c = new Colecao();
                //Pega os valores da coluna Int com o nome de "cod_colecao" da tabela
                c.setCodColecao(rs.getInt("cod_colecao"));
                //Pega os valores que estão no campo "estacao" da tabela
                c.setEstacaoColecao(rs.getString("estacao"));
                //pega os valores que estão no campo "ano" da tabela
                c.setAnoColecao(rs.getInt("ano"));
                //Pega os valores que estão no campo "pub_alvo" da tabela
                c.setPubAlvoColecao(rs.getString("pub_alvo"));
                //Pega os valores que estão no campo "cod_funcionario" da tabela
                c.setCategoriaColecao(ccc.listarId(rs.getInt("categoria_colecao_cod_categoria")));
                //Pega os valores que estão no campo "categoria_colecao_cod_categoria" da tabela
                c.setFunResponsavelColecao(fc.listById(rs.getInt("cod_funcionario")));
                //Adiciona os valores na lista
                listaColecao.add(c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro  no busca: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão!" + "\n" + ex.getMessage());
            }
        }
        return listaColecao;
    }

    @Override
    public Colecao listId(int id) {
        //Cria uma nova conexão
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Colecao c = new Colecao();
        CategoriaColecaoController ccc = new CategoriaColecaoController();
        FuncionarioController fc = new FuncionarioController();
        try {
            //Abre a conexão
            con = ConnectionFactory.getConnection();
            //Executa o comando SQL, no caso o comando SELECT
            pstm = con.prepareStatement(SELECTBYID);

            pstm.setInt(1, id);
            //Executa o comando SQL dentro do ResultSet rs
            rs = pstm.executeQuery();
            //Percorre a lista colocando os resultados dentro do ResultSet rs
            while (rs.next()) {
                c.setCodColecao(rs.getInt("cod_colecao"));
                //Pega os valores que estão no campo "nm_categoria_colecao" da tabela
                c.setEstacaoColecao(rs.getString("estacao"));
                //pega os valores que estão no campo "descricao" da tabela
                c.setAnoColecao(rs.getInt("ano"));
                c.setPubAlvoColecao(rs.getString("pub_alvo"));
                c.setCategoriaColecao(ccc.listarId(rs.getInt("categoria_colecao_cod_categoria")));
                c.setFunResponsavelColecao(fc.listById(rs.getInt("cod_funcionario")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro  no busca: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar listagem por ID." + "\n" + ex.getMessage());
            }
        }
        return c;
    }

    @Override
    public List<Colecao> listName(String nome) {
        //Cria uma nova conexão
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        FuncionarioController fc = new FuncionarioController();
        CategoriaColecaoController ccc = new CategoriaColecaoController();
        //Cria lista onde vai ser colocado os resultados da busca
        List<Colecao> colecoes = new ArrayList<>();
        try {
            //Abre a conexão
            con = ConnectionFactory.getConnection();
            //Executa o comando SQL, no caso o comando SELECT
            pstm = con.prepareStatement(SELECTBYNAME);
            pstm.setString(1, "%" + nome + "%");
            pstm.setString(2, "%" + nome + "%");
            //Executa o comando SQL dentro do ResultSet rs
            rs = pstm.executeQuery();
            //Percorre a lista colocando os resultados dentro do ResultSet rs
            while (rs.next()) {
                Colecao c = new Colecao();
                c.setCodColecao(rs.getInt("cod_colecao"));
                //Pega os valores que estão no campo "nm_categoria_colecao" da tabela
                c.setEstacaoColecao(rs.getString("estacao"));
                //pega os valores que estão no campo "descricao" da tabela
                c.setAnoColecao(rs.getInt("ano"));
                c.setPubAlvoColecao(rs.getString("pub_alvo"));
                c.setCategoriaColecao(ccc.listarId(rs.getInt("categoria_colecao_cod_categoria")));
                c.setFunResponsavelColecao(fc.listById(rs.getInt("cod_funcionario")));
                colecoes.add(c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro  no busca: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar listagem por nome." + "\n" + ex.getMessage());
            }
        }
        return colecoes;
    }
}
