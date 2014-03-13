package br.senai.sc.model.negocio;

import java.util.Date;
import java.util.Objects;

public class NotaFiscal {
//criei estes atributos para a formação da nota fiscal

    private int codNumero;
    private Date dataEmissao;
    private Produto produtos;
    private double valorTotal;
    private Funcionario funcionarioResponsavel;
    private String destinatario;
    private String remetente;

    public NotaFiscal() {
    }

    //criei os metodos get e sets
    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Produto getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }

    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;

    }

    public int getCodNumero() {
        return codNumero;
    }

    public void setCodNumero(int codNumero) {
        this.codNumero = codNumero;
    }

//criei o metodo equals 
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NotaFiscal other = (NotaFiscal) obj;
        if (!Objects.equals(this.dataEmissao, other.dataEmissao)) {
            return false;
        }
        if (!Objects.equals(this.produtos, other.produtos)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.funcionarioResponsavel, other.funcionarioResponsavel)) {
            return false;
        }
        if (!Objects.equals(this.destinatario, other.destinatario)) {
            return false;
        }
        if (!Objects.equals(this.remetente, other.remetente)) {
            return false;
        }

        return true;
    }

}
