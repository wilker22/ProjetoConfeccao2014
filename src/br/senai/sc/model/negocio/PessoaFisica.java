/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.negocio;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 * Pessoa Física
 * @author mateus_aguiar
 * @version v2.0 27/03/2014
 */

@MappedSuperclass
public class PessoaFisica extends Pessoa {
    
    // Atributos
    private String cpf;

    private String nome;
    
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;
    private String rg;
    
    //Construtor vazio
    public PessoaFisica() {
    }
    
    
    //Gets e Sets
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
   
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    //equals
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaFisica other = (PessoaFisica) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }

        if (!Objects.equals(this.dtNascimento, other.dtNascimento)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        return true;
    }
    
    //toString
    public String toString() {
        return "- PESSOA FÍSICA - " +
               "\nData de Nascimento: " + this.dtNascimento + 
               "\nRG: " + this.rg + "\n---";    }
    
    
}
