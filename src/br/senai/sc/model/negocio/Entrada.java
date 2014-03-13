package br.senai.sc.model.negocio;




import java.util.Date;
import java.util.Objects;



/**
 * @version 1.0
 * @author nathan_bettiol
 */

// Classe Entrada onde seram recebidas as informações de entrada de Produtos no Sistima

public class Entrada {
   
    //Declaração das Variaveis
    private int codigo;
    private  double preco;
    private Produto produto;
    private Date dtEmissao;
    private int qtProduto;
    private NotaFiscal notaFiscal;
    private Funcionario funcionario;



    //Construtor sem parametros
    
    public Entrada() {
    }
   
    //Final Construtor sem parametro--------------------------------------------
    //Getters and Setters dos atributos da classe entrada
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
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

   
    
} 
