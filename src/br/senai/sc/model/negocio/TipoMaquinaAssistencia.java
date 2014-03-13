package br.senai.sc.model.negocio;

import java.util.Objects;

/**
 * Classe TipoMaquinaAssistencia
 *
 * @version v1.0 05/09/2013
 * @author Gabriel Arsênio
 */
public class TipoMaquinaAssistencia {

    //Atributos do tipo de máquina
    private Assistencia assistenciaTipoMaquina;
    private int codTipoMaquina;

    //Contrutor default
    public TipoMaquinaAssistencia() {
    }

    //Método toString
    @Override
    public String toString() {
        return "\nTipos de Máquina da Assistência"
                + "\nTipoMaquina: " + assistenciaTipoMaquina
                + "\nCódigo do tipo de máquina: " + codTipoMaquina;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    //Método equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoMaquinaAssistencia other = (TipoMaquinaAssistencia) obj;
        if (!Objects.equals(this.assistenciaTipoMaquina, other.assistenciaTipoMaquina)) {
            return false;
        }
        if (this.codTipoMaquina != other.codTipoMaquina) {
            return false;
        }
        return true;
    }

    //Getters e Setters
    public Assistencia getAssistenciaTipoMaquina() {
        return assistenciaTipoMaquina;
    }

    public void setAssistenciaTipoMaquina(Assistencia assistenciaTipoMaquina) {
        this.assistenciaTipoMaquina = assistenciaTipoMaquina;
    }

    public int getCodTipoMaquina() {
        return codTipoMaquina;
    }

    public void setCodTipoMaquina(int codTipoMaquina) {
        this.codTipoMaquina = codTipoMaquina;
    }
    //Fim Getters e Setters
}
