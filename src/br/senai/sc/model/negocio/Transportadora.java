package br.senai.sc.model.negocio;

//------------------------------------------------------------------------------
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//------------------------------------------------------------------------------
//**
// * Classe responsável por representar a transportadora, a qual se encarrega da
// * distribuição de mercadorias
// *
//* @author wesley_s
// * @version 1.0
// *
//------------------------------------------------------------------------------
@Entity
public class Transportadora extends PessoaJuridica {

    @Id
    @GeneratedValue
    private String email;
    private String paginaWeb;
    private String contato;

    public Transportadora() {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transportadora other = (Transportadora) obj;
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

    @Override
    public String toString() {
        return "------ TRANSPORTADORA ------"
                + "\nContato: " + contato
                + "\nE-mail: " + email
                + "\nPagina Web: " + paginaWeb
                + "\n\n";
    }
}