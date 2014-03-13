/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.CategoriaProduto;
import br.senai.sc.model.negocio.Entrada;
import br.senai.sc.model.negocio.Fabricante;
import br.senai.sc.model.negocio.Funcionario;
import br.senai.sc.model.negocio.NotaFiscal;
import br.senai.sc.model.negocio.Produto;
import br.senai.sc.model.persistencia.dao.EntradaDAO;
import br.senai.sc.model.persistencia.dao.FuncionarioDAO;
import br.senai.sc.model.persistencia.dao.NotaFiscalDAO;
import br.senai.sc.model.persistencia.dao.ProdutoDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author nathan_bettiol
 */
 
 /* classe EntradaDaoJDBC que sera responsavel pela inserção, atualização, remoção, e lista dos registros  */
public class EntradaDaoJDBC implements EntradaDAO {


//Comando SLQ que insere um registro no banco de dados 
     private final String INSERT = "insert into entrada(data_emissao, cod_funcionario, cod_produto ,quantidade , preco , cod_nota_fiscal  ) "
            + "values (?, ?, ?, ?, ?, ?)";

//Comando SLQ que atualiza um registro no banco de dados           
    private final String UPDATE = "update entrada set data_emissao = ?, cod_funcionario = ?, cod_produto = ?, quantidade = ?, preco = ?, cod_nota_fiscal = ? where cod_entrada = ?";

//Comando SLQ que remove um registro no banco de dados    
    private final String DELETE = "delete from entrada where cod_entrada = ?";

//Comando SQL que lista os registro do banco de dados
    private final String LIST = "select * FROM entrada e, produtos p, nota_fiscal n, funcionario f" +
" WHERE e.cod_produto = p.cod_produto" +
" AND e.cod_nota_fiscal = n.cod_nota_fiscal" +
" AND e.cod_funcionario = f.cod_funcionario";

// COMANDO SQL QUE BUSCA ENTRADA NABASE DE DADOS CONFORME ID SELECIONADO
    private final String LISTBYID = "select * FROM entrada e, produtos p, nota_fiscal n, funcionario f" +
" WHERE e.cod_produto = p.cod_produto" +
" AND e.cod_nota_fiscal = n.cod_nota_fiscal" +
" AND e.cod_funcionario = f.cod_funcionario "
            + " where e.cod_entrada = ?";
    private static final String SELECTBYNAME = "select * from entrada where cod_entrada like ?  ";
    
    
            
           
    
    
    
 //inserir um registro no banco de dados   
    @Override
    public boolean insert(Entrada e) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);

            
            pstm.setDate(1, new java.sql.Date(e.getDtEmissao().getTime()));
            pstm.setInt(2, e.getFuncionario().getCod());
            pstm.setInt(3, e.getProduto().getCodProduto());
            pstm.setInt(4, e.getQtProduto());
            pstm.setDouble(5, e.getPreco());
            pstm.setInt(6, e.getNotaFiscal().getCodNumero());
            
           
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Inserção efetuada com "
                    + "sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a "
                    + "Inserção" + ex.getMessage());
            return false;
        }
    }


//atualiza um registro no banco de dados
    @Override
    public boolean update(Entrada e) {
          Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);

            
            pstm.setDate(1, (Date) new java.sql.Date(e.getDtEmissao().getTime()));
            pstm.setInt(2, e.getFuncionario().getCod());
            pstm.setInt(3, e.getProduto().getCodProduto());
            pstm.setInt(4, e.getQtProduto());
            pstm.setDouble(5, e.getPreco());
            pstm.setInt(6, e.getNotaFiscal().getCodNumero());
            pstm.setInt(7, e.getCodigo());
            
           
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Atualização efetuada com "
                    + "sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a "
                    + "Atualização" + ex.getMessage());
            return false;
        }
    }

//remove um registro no banco de dados
    @Override
    public boolean delete(int codEntrada) {
            Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);

            pstm.setInt(1, codEntrada);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Mudança efetuada com "
                    + "sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a "
                    + "mudança");
            return false;
        }
    }

//inserir um registro no banco de dados
    @Override
    public List<Entrada> listAll() {
      List<Entrada> entradas = new ArrayList<>();
         Connection conn;
          try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
                
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
               
                Entrada e = new Entrada();
                
                e.setCodigo(rs.getInt("e.cod_entrada"));
                e.setDtEmissao(rs.getDate("e.data_emissao"));
                
                Funcionario f = new Funcionario();
                f.setCod(rs.getInt("f.cod_funcionario"));
               
                e.setFuncionario(f);
                               
                Produto pro = new Produto();
                pro.setCodProduto(rs.getInt("p.cod_produto"));
                              
                e.setProduto(pro);

                e.setQtProduto(rs.getInt("e.quantidade"));

                
                e.setPreco(rs.getDouble("e.preco"));
               
                
                NotaFiscal n = new NotaFiscal();
                n.setCodNumero(rs.getInt("n.cod_nota_fiscal"));
              

                e.setNotaFiscal(n);
                
                 entradas.add(e);
                 }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a "
                    + "transação: " + e.getMessage());
        }
        return entradas;
    }
    
    
    //inserir um registro no banco de dados
    public List<Entrada> listById(int codEntrada) {
      List<Entrada> entradas = new ArrayList<>();
         Connection conn;
          try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);
             pstm.setInt(1, codEntrada);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
               
                Entrada e = new Entrada();
                e.setDtEmissao(rs.getDate("e.data_emissao"));
                
                Funcionario f = new Funcionario();
                f.setCod(rs.getInt("f.cod_funcionario"));
                
                e.setFuncionario(f);
                e.setQtProduto(rs.getInt("e.quantidade"));

                
                e.setPreco(rs.getDouble("e.preco"));
             
                Produto pro = new Produto();
                pro.setCodProduto(rs.getInt("p.cod_produto"));
                e.setProduto(pro);
               
                
                NotaFiscal n = new NotaFiscal();
                n.setCodNumero(rs.getInt("n.cod_nota_fiscal"));
               
                e.setNotaFiscal(n);
                
                 entradas.add(e);
                 }
            ConnectionFactory.closeConnection(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a "
                    + "transação: " + e.getMessage());
        }
        return entradas;
    }
    
      public List<Entrada> listName(String nome) {
        //Cria uma nova conexão
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        //Cria lista onde vai ser colocado os resultados da busca
        List<Entrada> entrada = new ArrayList<>();
        try {
            //Abre a conexão
            con = ConnectionFactory.getConnection();
            //Executa o comando SQL, no caso o comando SELECT
            pstm = con.prepareStatement(SELECTBYNAME);            
            pstm.setString(1,"%" + nome + "%"  );
            
            //Executa o comando SQL dentro do ResultSet rs
            rs = pstm.executeQuery();
            //Percorre a lista colocando os resultados dentro do ResultSet rs
            while (rs.next()) {
                Entrada en = new Entrada();
               Entrada e = new Entrada();
               e.setCodigo(rs.getInt("cod_entrada"));
                e.setDtEmissao(rs.getDate("data_emissao"));
                
                Funcionario f = new Funcionario();
                f.setCod(rs.getInt("cod_funcionario"));
                
                e.setFuncionario(f);
                e.setQtProduto(rs.getInt("quantidade"));

                
                e.setPreco(rs.getDouble("preco"));
             
                Produto pro = new Produto();
                pro.setCodProduto(rs.getInt("cod_produto"));
                e.setProduto(pro);
               
                
                NotaFiscal n = new NotaFiscal();
                n.setCodNumero(rs.getInt("cod_nota_fiscal"));
               
                e.setNotaFiscal(n);
                
                 entrada.add(e);
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
        return entrada;
    }
    
}
