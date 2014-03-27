package br.senai.sc.model.negocio;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.*;

/**
 *
 * @author mateus_aguiar
 * @version v2.0 27/03/2014
 */

@MappedSuperclass
public abstract class Pessoa {

    // Atributos
    @Id @GeneratedValue
    private int cod;
    
    @Lob
    private String endereco;
    private String telefone;
    
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    //Contrutor Vazio
    public Pessoa() {
    }

    //Gets e Sets
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    // equals
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.cod != other.cod) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.dtCadastro, other.dtCadastro)) {
            return false;
        }
        return true;
    }

    //toString
    public String toString() {
        return "- PESSOA - "
                + "\nCódigo: " + this.cod
                + "\nEndereço:" + this.endereco
                + "\nTelefone: " + this.telefone
                + "\nData Cadastro: " + this.dtCadastro + "\n---";
    }
}
