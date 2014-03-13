/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.negocio;

/**
 *
 * @author gustavo_cardoso
 */
public class Conserto {
    
       private int codigo;
       private int dataEnvio;
       private int dataRecebimento;
       private String assistencia;
       private String descricaoProblema;

    public Conserto() {
 
    }

    public String getAssistencia() {
        return assistencia;
    }

    public void setAssistencia(String assistencia) {
        this.assistencia = assistencia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(int dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public int getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(int dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }
    
    
}