package br.senai.sc.model.negocio;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Patricia Gageiro
 * @version 1.0 25/09/2013
 */
public class PedidoVenda {

    private int codPedidoVenda;
    private int numPedido;
    private PessoaJuridica cliente;
    private Date dtCadastro;
    private Date dtEntrega;
    private double valorTotal;
    private String formaPagamento;
    private Transportadora transportadoraResp;
    private int notaFiscal;

    //Métodos Getters e Setters
    public int getCodPedidoVenda() {
        return codPedidoVenda;
    }

    public void setCodPedidoVenda(int codPedidoVenda) {
        this.codPedidoVenda = codPedidoVenda;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public PessoaJuridica getCliente() {
        return cliente;
    }

    public void setCliente(PessoaJuridica cliente) {
        this.cliente = cliente;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Date getDtEntrega() {
        return dtEntrega;
    }

    public void setDtEntrega(Date dtEntrega) {
        this.dtEntrega = dtEntrega;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Transportadora getTransportadoraResp() {
        return transportadoraResp;
    }

    public void setTransportadoraResp(Transportadora transportadoraResp) {
        this.transportadoraResp = transportadoraResp;
    }

    public int getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(int notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    //Métodos Equals
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PedidoVenda other = (PedidoVenda) obj;
        if (this.codPedidoVenda != other.codPedidoVenda) {
            return false;
        }
        if (this.numPedido != other.numPedido) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.dtCadastro, other.dtCadastro)) {
            return false;
        }
        if (!Objects.equals(this.dtEntrega, other.dtEntrega)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.formaPagamento, other.formaPagamento)) {
            return false;
        }
       
        if (!Objects.equals(this.transportadoraResp, other.transportadoraResp)) {
            return false;
        }
        if (this.notaFiscal != other.notaFiscal) {
            return false;
        }
        return true;
    }

    //Método ToString
    public String toString() {
        return "  \nCódigo Pedido: " + this.getCodPedidoVenda()
                + "\nNúmero Pedido: " + this.getNumPedido()
                + "\nCliente: " + this.getCliente()
                + "\nData Cadastro: " + this.getDtCadastro()
                + "\nData Entrega: " + this.getDtEntrega()
                + "\nValor Total: " + this.getValorTotal()
                + "\nForma de Pagamento: " + this.getFormaPagamento()
                + "\nTransportadora Responsável: " + this.getTransportadoraResp()
                + "Nota Fiscal: " + this.getNotaFiscal();


    }
}
