package br.senai.sc.model.negocio;

//------------------------------------------------------------------------------
import java.util.Objects;

//------------------------------------------------------------------------------
/**
 * Classe responsável por representar a assistencia que sera oferecidada as
 * maquinas e equipamentos da confecção
 *
 * @author wesley_s
 * @version v1.0 04/09/2013
 */
//------------------------------------------------------------------------------
public class Assistencia extends PessoaJuridica {

    //Atributos
    private String email;
    private String paginaWeb;
    private String contato;

    //--------------------------------------------------------------------------
    //Construtor Padrão
    public Assistencia() {
    }

    //--------------------------------------------------------------------------
    //Métodos getters e setters
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

    //--------------------------------------------------------------------------
    //Método equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Assistencia other = (Assistencia) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.paginaWeb, other.paginaWeb)) {
            return false;
        }
        if (!Objects.equals(this.contato, other.contato)) {
            return false;
        }
        return true;
    }

    //--------------------------------------------------------------------------
    //Método toString
    @Override
    public String toString() {
        return "------ ASSISTÊNCIA ------"
                + "\nE-mail: " + email
                + "\nPágina Web: " + paginaWeb
                + "\nContato: " + contato
                + "\n\n";
    }
}