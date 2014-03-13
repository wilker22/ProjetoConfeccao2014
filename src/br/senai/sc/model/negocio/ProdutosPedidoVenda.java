package br.senai.sc.model.negocio;

import java.util.Objects;

/**
 *
 * @author Patricia Gageiro
 * @version 1.0 25/09/2013
 */
public class ProdutosPedidoVenda {
    
    private String nome;
    private String qtProduto;

    
    //Métodos Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQtProduto() {
        return qtProduto;
    }

    public void setQtProduto(String qtProduto) {
        this.qtProduto = qtProduto;
    }
    
    //Métodos Equals     
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProdutosPedidoVenda other = (ProdutosPedidoVenda) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.qtProduto, other.qtProduto)) {
            return false;
        }
        return true;
    }
    
    //Método ToString
    
    public String toString(){
        return "\nNome: "               + this.getNome()
             + "\nQuantidade Produto: " + this.getQtProduto();
        
    }
    
    
}
