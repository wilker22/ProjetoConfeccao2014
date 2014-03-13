/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.negocio;

import java.util.Date;
import java.util.Objects;

/**
 * Classe de representação da ferramenta
 * @version 1.0 28/08/2013
 * @author ariane_souza
 */
public class Ferramenta {

    //Atributos da classe

    private int codFerramenta;
    private String nome;
    private String descricao;
    private Fabricante nmFabricante;
    private Date dtCadastro;
    private String status;

    //Métodos Get e Set
    public int getCodFerramenta() {
        return codFerramenta;
    }

    public void setCodFerramenta(int codFerramenta) {
        this.codFerramenta = codFerramenta;
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

    public Fabricante getNmFabricante() {
        return nmFabricante;
    }

    public void setNmFabricante(Fabricante nmFabricante) {
        this.nmFabricante = nmFabricante;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    //Equals
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ferramenta other = (Ferramenta) obj;
        if (this.codFerramenta != other.codFerramenta) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.nmFabricante, other.nmFabricante)) {
            return false;
        }
        if (!Objects.equals(this.dtCadastro, other.dtCadastro)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

    
    //Construtor vazio

    public Ferramenta() {
    }
        
    //toString
    @Override
    public String toString() {
        return "Ferramenta: " + nome + 
                "\nDescricao: " + descricao +
                "\nNome do Fabricante: " + nmFabricante +
                "\nData do Cadastro: " + dtCadastro +
                "\nStatus: " + status+
                "\nCódigo: " + codFerramenta;
    }

    public void setDtCadastro(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
