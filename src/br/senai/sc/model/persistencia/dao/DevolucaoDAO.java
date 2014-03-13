/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Devolucao;
import br.senai.sc.model.negocio.Endereco;
import java.util.List;

/**
 *
 * @author douglas_ghisleri
 */
public interface DevolucaoDAO {
    
     /**
     * Método responsável pela inserção de uma devolução
     * na base de dados
     * @author douglas_ghisleri
     * @version 1.0 09/09/13
     * @param d
     * @return 
     */
    int insert(Devolucao d);
    
    /**
     * Método responsável pela atualização de uma devolução
     * na base de dados
     * @author douglas_ghisleri
     * @version 1.0 09/09/13
     * @param d
     * @return 
     */
    int update(Devolucao d);
    
    /**
     * Método responsável pela remoção de uma devolução na
     * base de dados
     * @author douglas_ghisleri
     * @version 1.0 09/09/13
     * @param d
     * @return 
     */
    boolean delete (Devolucao d);
    
    /**
     * Método responsável pela listagem de todas as 
     * devoluções cadastradas na base de dados
     * @author douglas_ghisleri
     * @version 1.0 09/09/13
     * @return 
     */
    List<Devolucao> listAll();
    
    /**
     * Método responsável por buscar uma devolução na base de
     * dados através de um id
     * @author douglas_ghisleri
     * @version 1.0 09/09/13
     * @param id
     * @return 
     */
    Devolucao listById(int id);
   
    /**
    * responsável pelo lista pesquisa de devoluções.
    * @author douglas_ghisleri
    * @version 1.0 05/11/2013
    * @param 
    */

     public List<Devolucao> ListPesquisar(String texto);

 
}
