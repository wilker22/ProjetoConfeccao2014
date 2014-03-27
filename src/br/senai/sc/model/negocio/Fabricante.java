package br.senai.sc.model.negocio;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Fabricante
 *
 * @author mateus_aguiar
 * @version v1.0 28/08/2013
 */
@Entity
public class Fabricante extends PessoaJuridica {

    // Atributos
    @Column(length = 50)
    private String email;

    // Construtor vazio
    public Fabricante() {
    }

    // Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método toString
    public String toString() {
        return getNmFantasia();
    }

    //Método equals
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fabricante other = (Fabricante) obj;

        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
}
