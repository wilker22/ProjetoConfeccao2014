package br.senai.sc.model.negocio;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Entrada {

    @Id
    @GeneratedValue
    private int codigo;
    private double preco;
    @ManyToOne
    private Produto produto;
    @Temporal(TemporalType.DATE)
    private Date dtEmissao;
    private int qtProduto;
    private String notaFiscal;
    @ManyToOne
    private Funcionario funcionario;

    public Entrada() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(Date dtEmissao) {
        this.dtEmissao = dtEmissao;
    }

    public int getQtProduto() {
        return qtProduto;
    }

    public void setQtProduto(int qtProduto) {
        this.qtProduto = qtProduto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    //Final Getters and Setters --------------------------------------------
    //To String Retorna os valores do Objeto.
    @Override
    public String toString() {
        return "Entrada{" + "codigo=" + codigo + ", preco=" + preco + ", produto=" + produto + ", dtEmissao=" + dtEmissao + ", qtProduto=" + qtProduto + ", notaFiscal=" + notaFiscal + ", funcionario=" + funcionario + '}';
    }

    //Final Equals-------------------------------------------- 
    //Final toString--------------------------------------------
    // Equals que vai ser usado mais a frente
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
        final Entrada other = (Entrada) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.dtEmissao, other.dtEmissao)) {
            return false;
        }
        if (this.qtProduto != other.qtProduto) {
            return false;
        }
        if (!Objects.equals(this.notaFiscal, other.notaFiscal)) {
            return false;
        }
        return true;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
}