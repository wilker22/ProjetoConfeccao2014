package br.senai.sc.model.negocio;

import java.util.Objects;

/**
 * Fabricante
 * @author mateus_aguiar
 * @version v1.0 28/08/2013
 */
public class Fabricante extends PessoaJuridica {
    
    // Atributos
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
