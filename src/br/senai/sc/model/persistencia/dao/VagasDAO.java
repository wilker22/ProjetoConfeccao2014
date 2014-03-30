package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Vagas;
import java.util.List;

/**
 * Interface responsavél pela declaração dos métodos relacionados a persistencia
 * de classe vagas.
 *
 * @author Bruna Zakrzeski
 * @since 1.0 05/11/2013
 * @param vag
 * @return
 */
public interface VagasDAO extends DAO<Vagas, Integer> {


    /**
     * Método responsável pela listar pesquisa de treinamento
     *
     * @author Bruna Zakrzeski
     * @version 1.0 09/09/13
     * @param treina
     * @return
     */
    List<Vagas> listPesquisa(String texto);

    
}
