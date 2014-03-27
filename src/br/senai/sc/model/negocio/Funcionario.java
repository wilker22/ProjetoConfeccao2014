package br.senai.sc.model.negocio;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 * Classe que representa os funcionarios do software
 *
 * @version 1.0 26/08/2013
 * @author Patricia Gageiro
 */
@Entity
public class Funcionario extends PessoaFisica {

   @Column (nullable = false)
    private String login;
     @Column (nullable = false)
    private String email;
      @Column (nullable = false)
    private String ctps;
       
    private String cargo;
    
        @Column (nullable = false)
    private double salario;
         @Column (nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtAdmissao;
          @Column (nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtRecisao;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public Date getDtRecisao() {
        return dtRecisao;
    }

    public void setDtRecisao(Date dtRecisao) {
        this.dtRecisao = dtRecisao;
    }
   

          
          
    //Métodos ToString
    public String toString() {
        return getNome();
    }

    //Métodos Equals
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;

        if (!Objects.equals(this.login, other.login)) {
            return false;
        }


        if (!Objects.equals(this.email, other.email)) {
            return false;
        }


        if (!Objects.equals(this.ctps, other.ctps)) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }

        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (!Objects.equals(this.dtAdmissao, other.dtAdmissao)) {
            return false;
        }

        if (!Objects.equals(this.dtRecisao, other.dtRecisao)) {
            return false;
        }
        return true;
    }
}
