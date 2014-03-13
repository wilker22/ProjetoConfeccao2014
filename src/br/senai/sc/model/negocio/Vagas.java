
package br.senai.sc.model.negocio;

import java.util.Objects;

    /**
     * Classe responsavél por guardar os métodos
     * get e set dp vagas
     * de acordo com o banco de dados
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param vag
     * @return 
     */ 

public class Vagas {
    
    //VARIAVEIS declaradas
    public int codigo;
    public String nome;
    public int qtVaga;
    public String preRequisito;
    public String funcao;
    public double faixaSalarial;
    

 
    public Vagas() {
    }

    //Get e Set iniciado
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtVaga() {
        return qtVaga;
    }

    public void setQtVaga(int qtVaga) {
        this.qtVaga = qtVaga;
    }

    public String getPreRequisito() {
        return preRequisito;
    }

    public void setPreRequisito(String preRequisito) {
        this.preRequisito = preRequisito;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public double getfaixaSalarial() {
        return faixaSalarial;
    }

    public void setfaixaSalaria(double faixaSalarial) {
        this.faixaSalarial = faixaSalarial;
    }
    //Get e Set finalizado
    
    
    //toString declarado
    public String toString(){
        return "Código: " + this.getCodigo() +
               "\nNome: " + this.getNome() +
               "\nQuantidade de vagas: " + this.getQtVaga()+ 
               "\nPré Requisitos: " + this.getPreRequisito() +
               "\nFunção: " + this.getFuncao() +
               "\nFaixa Salarial: " + this.getfaixaSalarial();
        
        
        

    }


    //Iniciando o equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vagas other = (Vagas) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
   
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.qtVaga != other.qtVaga) {
            return false;
        }
        if (!Objects.equals(this.preRequisito, other.preRequisito)) {
            return false;
        }
        if (!Objects.equals(this.funcao, other.funcao)) {
            return false;
        }
        if (Double.doubleToLongBits(this.faixaSalarial) != Double.doubleToLongBits(other.faixaSalarial)) {
            return false;
        }
        return true;
        
        //Finalizando o equals
    }
    
}
