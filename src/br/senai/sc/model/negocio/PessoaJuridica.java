/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.negocio;

import java.util.Objects;
import javax.persistence.Entity;

/**
 *
 * @author mateus_aguiar
 * @version v2.0 27/03/2014
 */

@Entity
public class PessoaJuridica extends Pessoa {
    
    //Atributos
    private String cnpj;
    private String razaoSocial;
    private String nmFantasia;
    
    //Construtor vazio
    public PessoaJuridica() {
    }
    
    //Gets e Sets
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNmFantasia() {
        return nmFantasia;
    }

    public void setNmFantasia(String nmFantasia) {
        this.nmFantasia = nmFantasia;
    }
    
    //equals
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaJuridica other = (PessoaJuridica) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.razaoSocial, other.razaoSocial)) {
            return false;
        }
        if (!Objects.equals(this.nmFantasia, other.nmFantasia)) {
            return false;
        }
        return true;
    }
    
    //toString
    public String toString() {
        return "- PESSOA JURÍDICA - " +
               "\nCNPJ: " + this.cnpj + 
               "\nRazão Social:" + this.razaoSocial + 
               "\nNome Fantasia: " + this.nmFantasia + "\n---"; }
}
