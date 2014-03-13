/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.negocio;

import java.util.Date;
import java.util.Objects;

/*
 * Classe Usuário
 * @version v1.0 Agosto/2013
 * @author Larissa Mezari
 */


public class Ferias {

    public static void add(Ferias f) {
        
    }

    private Funcionario funcionario;
    private Date dataInicio;
    private Date dataFim;

    //Construtor padrão
    public Ferias() {
    }
    
    //getters e setters
    
    
    

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

   
    public int hashCode() {
        int hash = 7;
        return hash;
    }

     //equals
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ferias other = (Ferias) obj;
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        if (!Objects.equals(this.dataFim, other.dataFim)) {
            return false;
        }
        return true;
    }

    //toString
    public String toString() {
        return "Ferias " + 
                "\nFuncionario: " + funcionario 
                + "\nData de Inicio: " + dataInicio 
                + "\nData do Fim: " + dataFim;
    }

    
    
}
