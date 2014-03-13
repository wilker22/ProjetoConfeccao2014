package br.senai.sc.model.negocio;

import java.util.Objects;

public class CategoriaProduto {

    private int codCategoriaProduto;
    private String nomeCategoriaProduto;
    private String descricaoCategoriaProduto;

    public CategoriaProduto() {
    }

    public int getCodCategoriaProduto() {
        return codCategoriaProduto;
    }

    public void setCodCategoriaProduto(int codCategoriaProduto) {
        this.codCategoriaProduto = codCategoriaProduto;
    }

    public String getNomeCategoriaProduto() {
        return nomeCategoriaProduto;
    }

    public void setNomeCategoriaProduto(String nomeCategoriaProduto) {
        this.nomeCategoriaProduto = nomeCategoriaProduto;
    }

    public String getDescricaoCategoriaProduto() {
        return descricaoCategoriaProduto;
    }

    public void setDescricaoCategoriaProduto(String descricaoCategoriaProduto) {
        this.descricaoCategoriaProduto = descricaoCategoriaProduto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoriaProduto other = (CategoriaProduto) obj;
        if (this.codCategoriaProduto != other.codCategoriaProduto) {
            return false;
        }
        if (!Objects.equals(this.nomeCategoriaProduto, other.nomeCategoriaProduto)) {
            return false;
        }
        if (!Objects.equals(this.descricaoCategoriaProduto, other.descricaoCategoriaProduto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNomeCategoriaProduto();
    }
}
