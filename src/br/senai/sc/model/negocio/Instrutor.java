package br.senai.sc.model.negocio;

import java.util.Objects;

/**
 * Instrutor
 *
 * @version v1.0 28/08/2013
 * @author Bruna Zakrzeski
 */



public class Instrutor {

    //Variaveis declaradas
    public Long id;
    public String treinamento;
    public String nmfuncionario;
    public int codTreinamento;

    //Iniciando o id com LONG
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //Finalizando o id com LONG

    //Método construtor sem retorno
    public Instrutor() {
    }

    //Inico de Get e Set
    public String getFuncionario() {
        return nmfuncionario;
    }

    public void setFuncionario(String funcionario) {
        this.nmfuncionario = funcionario;
    }

    public int getCodTreinamento() {
        return codTreinamento;
    }

    public void setCodTreinamento(int codTreinamento) {
        this.codTreinamento = codTreinamento;
    }

    //Finalizando o Get e Set
    public String getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(String treinamento) {
        this.treinamento = treinamento;
    }

    public String getNmfuncionario() {
        return nmfuncionario;
    }

    public void setNmfuncionario(String nmfuncionario) {
        this.nmfuncionario = nmfuncionario;
    }

    //Iniciando o método equals
    
    
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Instrutor other = (Instrutor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.treinamento, other.treinamento)) {
            return false;
        }
        if (!Objects.equals(this.nmfuncionario, other.nmfuncionario)) {
            return false;
        }
        if (this.codTreinamento != other.codTreinamento) {
            return false;
        }
        return true;
    }
    
    //Finalizando o equals
    
    
    
    //Iniciando o toString
    
    public String toString(){
        return "Nome Treinamento: " + this.getTreinamento() +
               "\nCódigo do Treinamento: " + this.getCodTreinamento() +
                "\nNome do Funcionário: " + this.getNmfuncionario();

    
        //Finalizando o toString
    }

}
