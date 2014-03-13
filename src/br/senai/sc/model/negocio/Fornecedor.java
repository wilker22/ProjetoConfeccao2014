/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.negocio;

/**
* Fornecedor
*
* @version v1.0 Setembro/2013
* @author Giliard Carvalho
*/
public class Fornecedor {
    private int codFornecedor;
    private String nome;
    private String cnpj;
    private String endereco;
    private String razaoSocial;
    private String telefone;
    private String email;
    private String paginaWeb;
    private String contato;
    private CategoriaFornecedor categoriaFornecedor;

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public CategoriaFornecedor getCategoriaFornecedor() {
        return categoriaFornecedor;
    }

    public void setCategoriaFornecedor(CategoriaFornecedor categoriaFornecedor) {
        this.categoriaFornecedor = categoriaFornecedor;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
