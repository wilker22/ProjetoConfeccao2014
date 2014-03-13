
package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Vagas;
import java.util.List;

    /**
     * Interface responsavél pela declaração dos métodos relacionados
     * a persistencia de classe vagas.
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param vag
     * @return 
     */


public interface VagasDAO {
    
    
    
    
    
    
   /**
   * Método responsável pela inserção de vagas
   * @author Bruna Zakrzeski
   * @version 1.0 09/09/13
   * @param vaga
   * @return 
   */
    
    boolean insert(Vagas vaga);
    
    
    
    
   /**
   * Método responsável pela alteração de vagas
   * @author Bruna Zakrzeski
   * @version 1.0 09/09/13
   * @param vaga
   * @return 
   */
    
    boolean update(Vagas vaga);
    
    
    
    
   /**
   * Método responsável pela remoção de vagas
   * @author Bruna Zakrzeski
   * @version 1.0 09/09/13
   * @param vaga
   * @return 
   */
    
    boolean delete(int codigo);
    
    
    
    
   /**
   * Método responsável pela listagem de vagas todos 
   * @author Bruna Zakrzeski
   * @version 1.0 09/09/13
   * @param vaga
   * @return 
   */
    
    List<Vagas> listAll();
    
    
    
    
   /**
   * Método responsável pela listar pesquisa de treinamento
   * @author Bruna Zakrzeski
   * @version 1.0 09/09/13
   * @param treina
   * @return 
   */
    List<Vagas> listPesquisa(String texto);
    
    
    
    
    
      /**
   * Método responsável pela lista por id do treinamento
   * @author Bruna Zakrzeski
   * @version 1.0 09/09/13
   * @param treina
   * @return 
   */
    Vagas listById(int id);
    
    
}
