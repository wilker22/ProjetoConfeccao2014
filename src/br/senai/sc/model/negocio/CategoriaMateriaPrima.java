package br.senai.sc.model.negocio;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Esta classe representa as categorias das materias-prima utilizadas.
 *
 * @version v1.0 28/08/2013
 * @author leticia_jesus
 */
@Entity
public class CategoriaMateriaPrima {
    //declaraĂ§ĂŁo das variĂˇveis
    @Id
    @GeneratedValue
    private int cod;
    private String nome;
    @Lob
    private String descricao;

    //construtor
    public CategoriaMateriaPrima() {
    }
    //getters e setters

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    //para mostrar os atributos da categoria matĂ©ria-prima

    @Override
    public String toString() {
        return nome;


    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    //equals:faz comparaĂ§Ăµes se Ă© sĂł nĂşmeros ou letras
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoriaMateriaPrima other = (CategoriaMateriaPrima) obj;
        if (this.cod != other.cod) {
            return false;

        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }
}
