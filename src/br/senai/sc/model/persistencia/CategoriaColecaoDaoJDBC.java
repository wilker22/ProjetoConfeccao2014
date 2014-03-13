/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.CategoriaColecao;
import br.senai.sc.model.persistencia.dao.CategoriaColecaoDAO;
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
 * @version v1.0 30/08/2013
 * @author Gabriel Arsênio
 */
public class CategoriaColecaoDaoJDBC implements CategoriaColecaoDAO {

    //Strings com os comandos SQL
    private static final String INSERT = "INSERT INTO categoria_colecao VALUES (null, ?, ?)";
    private static final String UPDATE = "UPDATE categoria_colecao set nm_categoria_colecao = ?, descricao = ? where cod_categoria = ?";
    private static final String DELETE = "DELETE FROM categoria_colecao WHERE cod_categoria = ?";
    private static final String SELECT = "select * from categoria_colecao";
    private static final String SELECTBYID = "select * from categoria_colecao where cod_categoria = ?";
    private static final String SELECTBYNAME = "select * from categoria_colecao where nm_categoria_colecao like ? or cod_categoria like ?";

    //Método para atualizar valores da tabela categoria_colecao
    @Override
    public int update(CategoriaColecao cc) {
        int retorno = -1;
        //Cria uma nova conexão
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            //Abre a conexão
            con = ConnectionFactory.getConnection();
            //Prepara o comando SQL
            pstm = con.prepareStatement(UPDATE);
            //Substitui os pontos de interrogação do comando
            pstm.setString(1, cc.getNomeCategoriaColecao());
            pstm.setString(2, cc.getDescricaoCategoriaColecao());
            pstm.setInt(3, cc.getCodCategoriaColecao());
            //Executa o comando
            pstm.execute();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            retorno = cc.getCodCategoriaColecao();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão." + "\n" + ex.getMessage());
            }
        }
        return retorno;
    }

    //Método para deletar valores da tabela categoria_colecao
    @Override
    public boolean delete(int cod) {
        //Cria uma nova conexão
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            //Abre a conexão
            con = ConnectionFactory.getConnection();
            //Executa o comando SQL
            pstm = con.prepareStatement(DELETE);
            //Substitui os pontos de interrogação do comando            
            pstm.setInt(1, cod);
            //Executa o comando
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
            return false;
        } finally {
            try {
                //Fecha a conexão
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão!" + "\n" + ex.getMessage());
            }
        }
    }

    //Método para procurar valores da tabela categoria_colecao
    @Override
    public List<CategoriaColecao> listAll() {
        //Cria uma nova conexão
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        //Cria lista onde vai ser colocado os resultados da busca
        List<CategoriaColecao> listaCategoriasColecao = new ArrayList();
        try {
            //Abre a conexão
            con = ConnectionFactory.getConnection();
            //Executa o comando SQL, no caso o comando SELECT
            pstm = con.prepareStatement(SELECT);
            //Executa o comando SQL dentro do ResultSet rs
            rs = pstm.executeQuery();
            //Percorre a lista colocando os resultados dentro do ResultSet rs
            while (rs.next()) {
                CategoriaColecao cc = new CategoriaColecao();

                cc.setCodCategoriaColecao(rs.getInt("cod_categoria"));
                //Pega os valores que estão no campo "nm_categoria_colecao" da tabela
                cc.setNomeCategoriaColecao(rs.getString("nm_categoria_colecao"));
                //pega os valores que estão no campo "descricao" da tabela
                cc.setDescricaoCategoriaColecao(rs.getString("descricao"));
                //Adiciona os valores na lista
                listaCategoriasColecao.add(cc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro  no busca: " + ex.getMessage());
        } finally {
            try {
                //Fecha a conexão
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão!" + "\n" + ex.getMessage());
            }
        }
        return listaCategoriasColecao;
    }

    //Método de inserção de valores da tabela categoria_colecao
    @Override
    public int insert(CategoriaColecao cc) {
        int retorno = -1;
        //Cria uma nova conexão
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            //Abre a conexão 'conn'
            con = ConnectionFactory.getConnection();

            //Recebe a String com o comando SQL, no caso, o comando INSERT
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            //Subustitui os pontos de interrogação do comando
            pstm.setString(1, cc.getNomeCategoriaColecao());
            pstm.setString(2, cc.getDescricaoCategoriaColecao());

            //Executa o comando SQL
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                    JOptionPane.showMessageDialog(null, "Categoria de coleção inserida com sucesso.");
                    cc.setCodCategoriaColecao(retorno);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão." + "\n" + ex.getMessage());
            }
        }
        return retorno;
    }

    @Override
    public CategoriaColecao listId(int id) {
        //Cria uma nova conexão
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        //Cria lista onde vai ser colocado os resultados da busca
        CategoriaColecao cc = new CategoriaColecao();
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
                cc.setCodCategoriaColecao(rs.getInt("cod_categoria"));
                //Pega os valores que estão no campo "nm_categoria_colecao" da tabela
                cc.setNomeCategoriaColecao(rs.getString("nm_categoria_colecao"));
                //pega os valores que estão no campo "descricao" da tabela
                cc.setDescricaoCategoriaColecao(rs.getString("descricao"));

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
        return cc;
    }

    @Override
    public List<CategoriaColecao> listName(String nome) {
        //Cria uma nova conexão
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        //Cria lista onde vai ser colocado os resultados da busca
        List<CategoriaColecao> categoriasColecao = new ArrayList<>();
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
                CategoriaColecao cc = new CategoriaColecao();
                cc.setCodCategoriaColecao(rs.getInt("cod_categoria"));
                //Pega os valores que estão no campo "nm_categoria_colecao" da tabela
                cc.setNomeCategoriaColecao(rs.getString("nm_categoria_colecao"));
                //pega os valores que estão no campo "descricao" da tabela
                cc.setDescricaoCategoriaColecao(rs.getString("descricao"));
                categoriasColecao.add(cc);
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
        return categoriasColecao;
    }
}
