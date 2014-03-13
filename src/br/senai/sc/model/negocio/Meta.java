package br.senai.sc.model.negocio;

import java.util.Date;



/**
 * @version 1.00
 * @author douglas_ghisleri
 */
public class Meta {

    public int cod_meta;
    public Date dataInicio;
    public Date dataFim;
    public double valor;
    public int quantidade;

    public int getCod_meta() {
        return cod_meta;
    }

    public void setCod_meta(int cod_meta) {
        this.cod_meta = cod_meta;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Codigo meta - " + cod_meta + " ,Data inicio - " + dataInicio + " ,Data Fim - " + dataFim + " ,Valor - " + valor + " ,Quantidade - " + quantidade ;
    }

}
