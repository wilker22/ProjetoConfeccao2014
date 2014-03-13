
package br.senai.sc.model.negocio;

import java.util.Objects;

/**Essa classe representa as matérias-prima utilizadas pela confecção
 * *@version v1.0 28/08/2013
 * @author leticia_jesus
 */
public class MateriaPrima {
//declaração das variaveis
    private int cod;
    private Fornecedor Fornecedor;
    private String nome;
    private CategoriaMateriaPrima categoria;
    private double preco;
    private String tpUnidade;
    private int quantidade;

    //construtor
    public MateriaPrima() {
    }

    //getters e setters
    public int getCodigo() {
        return cod;
    }

    public void setCodigo(int codigo) {
        this.cod = codigo;
    }

    public Fornecedor getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(Fornecedor Fornecedor) {
        this.Fornecedor = Fornecedor;
    }

   
  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaMateriaPrima getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaMateriaPrima categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTpUnidade() {
        return tpUnidade;
    }

    public void setTpUnidade(String tpUnidade) {
        this.tpUnidade = tpUnidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    //para mostrar os atributos da materia-prima
    @Override
    public String toString() {
        return "MateriaPrima{" + "codigo=" + cod + ", fornecedor=" + Fornecedor + ", nome=" + nome + ", categoria=" + categoria + ", preco=" + preco + ", tpUnidade=" + tpUnidade + ", quantidade=" + quantidade + '}';
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
        final MateriaPrima other = (MateriaPrima) obj;
        if (this.cod != other.cod) {
            return false;
        }
        if (!Objects.equals(this.Fornecedor, other.Fornecedor)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (!Objects.equals(this.tpUnidade, other.tpUnidade)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        return true;
    }

  

   

    
    }
    

