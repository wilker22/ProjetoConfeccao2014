package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.PedidoVenda;
import br.senai.sc.model.negocio.PessoaJuridica;
import br.senai.sc.model.negocio.Transportadora;
import br.senai.sc.model.persistencia.dao.PedidoVendaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author patricia_gageiro
 * @version 1.0 30/09/2013
 */
public class PedidoVendaDaoJDBC implements PedidoVendaDAO {

    private static final String INSERT = "insert into PedidoVenda(cod_pedido_venda, num_pedido, cliente, dt_cadastro, dt_entrega, valor_total, forma_pagamento, transportadora_responsavel)";
    private static final String UPDATE = "update PedidoVenda set num_pedido =?, cliente = ?, dt_cadastro = ?, dt_entrega = ? , valor_total = ? , forma_pagamento = ? , transportadora_responsavel = ? where cod_pedido_venda = ?  ";
    private static final String DELETE = "delete from PedidoVenda where cod_pedido_venda = ?";
    private static final String LIST = "select * from PedidoVenda";
    private static final String LISTBYID = "select * from PedidoVenda where cod_pedido_venda = ?";

    public boolean insert(PedidoVenda pev) {
        Connection con;

        try {

            con = ConnectionFactory.getConnection();
            PreparedStatement pstm = con.prepareStatement(INSERT);
            pstm.setString(1, Integer.toString(pev.getCodPedidoVenda()));
            pstm.setString(2, Integer.toString(pev.getNumPedido()));
            pstm.setInt(3, pev.getCliente().getCod());
            try {
                String data = JOptionPane.showInputDialog("Data Cadastro");

                pev.setDtCadastro(new SimpleDateFormat("dd/mm/yyyy").parse(data));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Data incorreta" + ex);
            }

            try {
                String data = JOptionPane.showInputDialog("Data Entrega");

                pev.setDtEntrega(new SimpleDateFormat("dd/mm/yyyy").parse(data));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Data incorreta" + ex);
            }
            pstm.setString(4, Double.toString(pev.getValorTotal()));
            pstm.setString(5, pev.getFormaPagamento());
            pstm.setInt(6, pev.getTransportadoraResp().getCod());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(con, pstm);
            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação" + ex.getMessage());
            return false;
        }
    }

   
    public boolean update(PedidoVenda pev) {
        Connection con;
        try {
            con = ConnectionFactory.getConnection();
            PreparedStatement pstm = con.prepareStatement(UPDATE);

            pstm.setString(1, Integer.toString(pev.getNumPedido()));
            pstm.setInt(2, pev.getCliente().getCod());
            pstm.setDate(3, new java.sql.Date(pev.getDtCadastro().getTime()));
            pstm.setDate(4, new java.sql.Date(pev.getDtEntrega().getTime()));
            pstm.setString(5, Double.toString(pev.getValorTotal()));
            pstm.setString(6, pev.getFormaPagamento());
            pstm.setInt(7,pev.getTransportadoraResp().getCod());
            pstm.setString(8,Integer.toString(pev.getCodPedidoVenda()));
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(con, pstm);
            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação" + ex.getMessage());
            return false;
        }                
    }

    
    public boolean delete(PedidoVenda pv) {
        
        Connection con;

        try {
            con = ConnectionFactory.getConnection();
            PreparedStatement pstm = con.prepareStatement(DELETE);
            pstm.setString(1, Integer.toString(pv.getCodPedidoVenda()));
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação" + ex.getMessage());
            return false;
        }
    }

    
    public List<PedidoVenda> ListAll() {
       Connection con;
        List<PedidoVenda> pedidovendas = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            PreparedStatement pstm = con.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                PedidoVenda pev = new PedidoVenda();
                pev.setCodPedidoVenda(rs.getInt("cod_pedido_venda"));
                pev.setNumPedido(rs.getInt("num_pedido"));
                PessoaJuridica p = new PessoaJuridica();
                p.setCod(rs.getInt("cliente"));
                pev.setCliente(p);
                
                try {
                    String data = JOptionPane.showInputDialog("Data Cadastro");

                    pev.setDtCadastro(new SimpleDateFormat("dd/mm/yyyy").parse(data));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Data incorreta" + ex);
                }
                 try {
                    String data = JOptionPane.showInputDialog("Data Entrega");

                    pev.setDtEntrega(new SimpleDateFormat("dd/mm/yyyy").parse(data));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Data incorreta" + ex);
                }
                pev.setValorTotal(rs.getDouble("valor_total"));
                Transportadora t = new Transportadora();
                t.setCod(rs.getInt("transportadora_responsavel"));
                pev.setTransportadoraResp(t);
               

               

                pedidovendas.add(pev);

            }
            ConnectionFactory.closeConnection(con, pstm);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação" + ex.getMessage());

        }
        return pedidovendas;
    }
}
