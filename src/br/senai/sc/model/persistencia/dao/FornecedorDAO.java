/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Fornecedor;
import java.util.List;

/**
* Fornecedor
*
* @version v1.0 Setembro/2013
* @author Giliard Carvalho
*/
public interface FornecedorDAO {
    
    /*
     * Método responsável pela Atualização do Fornecedor .
     * @author Giliard Carvalho
     * @param forn
     * @return
     */
    boolean Insert(Fornecedor forn);
    
    /*
     * Método responsável pela Inserção de um Fornecedor. 
     * @author Giliard Carvalho
     * @param forn
     * @return
     */
    boolean Update(Fornecedor forn);
    
    /*
     * Método que remove um Fornecedor. 
     * @author Giliard Carvalho
     * @param forn
     * @return
     */
    boolean Delete(Fornecedor forn);
    
    /*
     * Método responsável pela Listagem de todos os Fornecedores. 
     * @author Giliard Carvalho
     * @param forn
     * @return
     */
    List<Fornecedor> listall();
    
    /*
     * Método responsável pela Listagem do Fornecedor com o código enviado por parametro. 
     * @author Giliard Carvalho
     * @param forn
     * @return
     */
    List<Fornecedor> listById(int codFornecedor);
}
