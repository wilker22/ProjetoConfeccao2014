package br.senai.sc.model.negocio;

import java.util.Objects;

/**
 * Classe Colecao * Representa as informações de cada coleção
 *
 * @version v1.0 28/08/2013
 * @author Gabriel Arsênio
 */
public class Colecao {

    private int codColecao;
    private String estacaoColecao;
    private int anoColecao;
    private String pubAlvoColecao;
    private Funcionario funResponsavelColecao;
    private CategoriaColecao categoriaColecao;

    public Colecao() {
    }

    @Override
    public String toString() {
        return estacaoColecao;
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
        final Colecao other = (Colecao) obj;
        if (this.codColecao != other.codColecao) {
            return false;
        }
        if (!Objects.equals(this.estacaoColecao, other.estacaoColecao)) {
            return false;
        }
        if (this.anoColecao != other.anoColecao) {
            return false;
        }
        if (!Objects.equals(this.pubAlvoColecao, other.pubAlvoColecao)) {
            return false;
        }
        if (!Objects.equals(this.funResponsavelColecao, other.funResponsavelColecao)) {
            return false;
        }
        return true;
    }

    //Getters e Setters
    public int getCodColecao() {
        return codColecao;
    }

    public void setCodColecao(int codColecao) {
        this.codColecao = codColecao;
    }

    public String getEstacaoColecao() {
        return estacaoColecao;
    }

    public void setEstacaoColecao(String estacaoColecao) {
        this.estacaoColecao = estacaoColecao;
    }

    public int getAnoColecao() {
        return anoColecao;
    }

    public void setAnoColecao(int anoColecao) {
        this.anoColecao = anoColecao;
    }

    public String getPubAlvoColecao() {
        return pubAlvoColecao;
    }

    public void setPubAlvoColecao(String pubAlvoColecao) {
        this.pubAlvoColecao = pubAlvoColecao;
    }

    public Funcionario getFunResponsavelColecao() {
        return funResponsavelColecao;
    }

    public void setFunResponsavelColecao(Funcionario funResponsavelColecao) {
        this.funResponsavelColecao = funResponsavelColecao;
    }

    public CategoriaColecao getCategoriaColecao() {
        return categoriaColecao;
    }

    public void setCategoriaColecao(CategoriaColecao categoriaColecao) {
        this.categoriaColecao = categoriaColecao;
    }
    //Fim Getters e Setters
}
