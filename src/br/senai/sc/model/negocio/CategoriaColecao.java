package br.senai.sc.model.negocio;

import java.util.Objects;

/**
 * Classe CategoriaColecao * A classe possui atributos para cadastrar categorias
 * de coleção
 *
 * @version v1.0 28/08/2013
 * @author Gabriel Arsênio
 */
public class CategoriaColecao {
    
    private int codCategoriaColecao;
    private String nomeCategoriaColecao;
    private String descricaoCategoriaColecao;

    public CategoriaColecao() {
    }

    @Override
    public String toString() {
        return getNomeCategoriaColecao();
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final CategoriaColecao other = (CategoriaColecao) obj;
        if (this.codCategoriaColecao != other.codCategoriaColecao) {
            return false;
        }
        if (!Objects.equals(this.nomeCategoriaColecao, other.nomeCategoriaColecao)) {
            return false;
        }
        if (!Objects.equals(this.descricaoCategoriaColecao, other.descricaoCategoriaColecao)) {
            return false;
        }
        return true;
    }

    //Getters e Setters
    public int getCodCategoriaColecao() {
        return codCategoriaColecao;
    }

    public void setCodCategoriaColecao(int codCategoriaColecao) {
        this.codCategoriaColecao = codCategoriaColecao;
    }

    public String getNomeCategoriaColecao() {
        return nomeCategoriaColecao;
    }

    public void setNomeCategoriaColecao(String nomeCategoriaColecao) {
        this.nomeCategoriaColecao = nomeCategoriaColecao;
    }

    public String getDescricaoCategoriaColecao() {
        return descricaoCategoriaColecao;
    }

    public void setDescricaoCategoriaColecao(String descricaoCategoriaColecao) {
        this.descricaoCategoriaColecao = descricaoCategoriaColecao;
    }
    //Fim Getters e Setters
}
