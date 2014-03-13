
package br.senai.sc.model.negocio;

import java.util.Objects;


public class Pedido {
    //Atributos da Classe Pedido
    public String status;
    public String fornecedor;
    public String produto;
    public int qtProduto;
    public int preco;
    public int dataPedido;
    public int dataPrevistaEntrega;
    public int codigo;
    public String formaPagamento;

    //Construtor 
    public Pedido() {
    }

    //Metodos Get e Set iniciado
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQtProduto() {
        return qtProduto;
    }

    public void setQtProduto(int qtProduto) {
        this.qtProduto = qtProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(int dataPedido) {
        this.dataPedido = dataPedido;
    }

    public int getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(int dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public String getFomaPagamento() {
        return formaPagamento;
    }

    public void setFomaPagamento(int fomarPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    //Métodos ToString
    public String toString() {

        return "Status: " + this.getStatus()
                + "\nFornecedor: " + this.getFornecedor()
                + "\nProduto: " + this.getProduto()
                + "\nQuantidade Produto: " + this.getProduto()
                + "\nEmail: " + this.getPreco()
                + "\nTelefone: " + this.getDataPedido()
                + "\nEndereço: " + this.getDataPrevistaEntrega()
                + "\nCtps: " + this.getCodigo()
                + "\nCargo: " + this.getFomaPagamento();


    

    //Metodo equals

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (this.qtProduto != other.qtProduto) {
            return false;
        }
        if (this.preco != other.preco) {
            return false;
        }
        if (this.dataPedido != other.dataPedido) {
            return false;
        }
        if (this.dataPrevistaEntrega != other.dataPrevistaEntrega) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.formaPagamento, other.formaPagamento)) {
            return false;
        }
        return true;
    }
}
    

