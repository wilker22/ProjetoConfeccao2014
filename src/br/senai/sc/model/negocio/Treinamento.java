
package br.senai.sc.model.negocio;

import java.util.Objects;
import javax.persistence.*;


     /**
     * Classe responsavél por guardar os métodos
     * get e set dp treinamento
     * de acordo com o banco de dados
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */
@Entity
public class Treinamento {

    //Variaveis declaradas
    @Id
    @GeneratedValue
    private int id;
    
    private String nome;
    private int cargaHoraria;
    private String conteudo;
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    //Iniciando o id com LONG
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //Finalizando o id com LONG


    //Método construtor sem parametro
    public Treinamento() {
    }

    //Inicio de Get e Set


    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    //Finalizando Get e Set
   
    

    //Iniciando o método equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Treinamento other = (Treinamento) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.cargaHoraria != other.cargaHoraria) {
            return false;
        }
        if (!Objects.equals(this.conteudo, other.conteudo)) {
            return false;
        }
        return true;
    }
    
    //Finalizando o método equals
    
    
    
     //toString declarado
    public String toString(){
        return "\nNome: " + this.getNome() +
               "\nCarga Horária: " + this.getCargaHoraria() +
               "\nConteúdo: " + this.getConteudo();
        
        //Finalizando o método toString
               
    }
    
    
    
    
    
}
