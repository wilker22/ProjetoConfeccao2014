/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.CategoriaFornecedor;
import java.util.List;

/**
* Categoria Fornecedor
*
* @version v1.0 Setembro/2013
* @author Giliard Carvalho
*/
public interface CategoriaFornecedorDAO {
    /*
     * Método responsável pela Atualização da CategoriaFornecedor .
     * @author Giliard Carvalho
     * @param catForn
     * @return
     */
    boolean Insert(CategoriaFornecedor catForn);
    
    /*
     * Método responsável pela Inserção de uma CategoriaFornecedor. 
     * @author Giliard Carvalho
     * @param catForn
     * @return
     */
    boolean Update(CategoriaFornecedor catForn);
    
    /*
     * Método que remove uma CategoriaFornecedor. 
     * @author Giliard Carvalho
     * @param catForn
     * @return
     */
    boolean Delete(CategoriaFornecedor catForn);
    
    /*
     * Método responsável pela Listagem de todas as CategoriaFornecedores. 
     * @author Giliard Carvalho
     * @param catForn
     * @return
     */
    List<CategoriaFornecedor> listall();
    
    /*
     * Método responsável pela Listagem da CategoriaFornecedor com o código enviado por parametro. 
     * @author Giliard Carvalho
     * @param catForn
     * @return
     */
    List<CategoriaFornecedor> listById(int codCategoriaFornecedor);
}
