package br.senai.sc.model.negocio;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produto {

    @Id
    @GeneratedValue
    private int codProduto;
    @ManyToOne
    private Fabricante fabricante;
    private String modelo;
    @Column(length = 100)
    private String nome;
    private double preco;
    @ManyToOne
    private CategoriaProduto categoria;
    @Column(length = 5)
    private String tamanho;
    @ManyToOne
    private Colecao colecao;
    @Column(length = 50)
    private String cor;
    private int qtProdutos;

    public Produto() {
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = (CategoriaProduto) (List<CategoriaProduto>) categoria;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Colecao getColecao() {
        return colecao;
    }

    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQtProdutos() {
        return qtProdutos;
    }

    public void setQtProdutos(int qtProdutos) {
        this.qtProdutos = qtProdutos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Produto other = (Produto) obj;
        if (this.codProduto != other.codProduto) {
            return false;
        }
        if (!Objects.equals(this.fabricante, other.fabricante)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.tamanho, other.tamanho)) {
            return false;
        }
        if (!Objects.equals(this.colecao, other.colecao)) {
            return false;
        }
        if (!Objects.equals(this.cor, other.cor)) {
            return false;
        }
        if (this.qtProdutos != other.qtProdutos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "codProduto=" + codProduto + ", fabricante=" + fabricante + ", modelo=" + modelo + ", nome=" + nome + ", preco=" + preco + ", categoria=" + categoria + ", tamanho=" + tamanho + ", colecao=" + colecao + ", cor=" + cor + ", qtProdutos=" + qtProdutos + '}';
    }
}