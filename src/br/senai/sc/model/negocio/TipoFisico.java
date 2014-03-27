/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.negocio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * @version 1.0 28/08/2013
 * @author gustavo_lourenco
 */
@Entity
public class TipoFisico {

    @Id
    @GeneratedValue
    private int codigo;
    private String genero;
    private String nome;
    @Lob
    private String descricao;

    public TipoFisico() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescicao() {
        return descricao;
    }

    public void setDescicao(String descicao) {
        this.descricao = descicao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoFisico other = (TipoFisico) obj;
        return true;
    }

    @Override
    public String toString() {
        return "TiposFisicos{" + "codigo=" + codigo + ", genero=" + genero + ", nome=" + nome + ", descricao=" + descricao + '}';
    }
}
