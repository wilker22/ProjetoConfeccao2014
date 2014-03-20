
package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Treinamento;
import java.util.List;


    /**
     * Interface responsavél pela declaração dos métodos relacionados
     * a persistencia de classe treinamento.
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */

public interface TreinamentoDAO extends DAO<Treinamento, Integer> {
    
 	
     List <Treinamento> pesquisarNome(String nome);   

    public Treinamento save(Treinamento cliente);

    
    
}
    

