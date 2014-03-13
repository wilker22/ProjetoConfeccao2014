
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

public interface TreinamentoDAO {
    



    
    
  /**
   * Método responsável pela inserção de um treinamento
   * @author Bruna Zakrzeski
   * @version 1.0 09/09/13
   * @param treina
   * @return 
   */
    
    boolean insert(Treinamento treina);
    
    
    
    
  /**
   * Método responsável pela alteração de um treinamento
   * @author Bruna Zakrzeski
   * @version 1.0 09/09/13
   * @param treina
   * @return 
   */
    
    boolean update(Treinamento treina);
    
    
    
    
  /**
   * Método responsável pela remoção de um treinamento
   * @author Bruna Zakrzeski
   * @version 1.0 09/09/13
   * @param treina
   * @return 
   */
    
    boolean delete(int id);
    
    
    
    
  /**
   * Método responsável pela listagem de todo treinamento
   * @author Bruna Zakrzeski
   * @version 1.0 09/09/13
   * @param treina
   * @return 
   */
    
    List<Treinamento> listAll();
    
    
    
    
    
    
   /**
   * Método responsável pela listar por id do treinamento
   * @author Bruna Zakrzeski
   * @version 1.0 09/09/13
   * @param treina
   * @return 
   */
    Treinamento listById(int id);
    
    
    
    
    
    
   /**
   * Método responsável pela listar pesquisa do treinamento
   * @author Bruna Zakrzeski
   * @version 1.0 09/09/13
   * @param treina
   * @return 
   */
    List<Treinamento> listPesquisa(String texto);
    
    
    
}
    

