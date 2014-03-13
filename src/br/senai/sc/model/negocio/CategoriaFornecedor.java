/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.negocio;

/**
* Categoria Fornecedor
*
* @version v1.0 Setembro/2013
* @author Giliard Carvalho
*/
public class CategoriaFornecedor {
    private int codCategoriaFornecedor;
    private String nome;
    private String descricao;
    private String observacoes;

    public CategoriaFornecedor() {
        super();
    }
    
    public int getCodCategoriaFornecedor() {
        return codCategoriaFornecedor;
    }

    public void setCodCategoriaFornecedor(int codCategoriaFornecedor) {
        this.codCategoriaFornecedor = codCategoriaFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
}
