package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Endereco;
import java.util.List;

/**
 *Responsavel pela declaração dos métodos da classe Endereço.
 * @author gustavo_cm
 */
public interface EnderecoDAON {    
/**
* Responsável pela inserção do Endereço.
* @author gustavo_cm
* @version 1.0 05/11/2013
* @param Endereço
*/
    int insert(Endereco e);
/**
* Responsável pela listagem dos Endereços.
* @author gustavo_cm
* @version 1.0 05/11/2013
* @param Endereço
*/
    List<Endereco> listAll();  
/**
* Responsável pela alteração do Endereço.
* @author gustavo_cm
* @version 1.0 05/11/2013
* @param Endereço
*/
    int update(Endereco e);
/**
* Responsável pela remoção do Endereço.
* @author gustavo_cm
* @version 1.0 05/11/2013
* @param Endereço
*/
    boolean remove (int id);
/**
* Responsável pelo listar dos id dos Endereços.
* @author gustavo_cm
* @version 1.0 05/11/2013
* @param Endereço
*/
    Endereco listById(int id);
/**
* responsável pelo lista pesquisa do Endereço.
* @author gustavo_cm
* @version 1.0 05/11/2013
* @param Endereço
*/
    List<Endereco> pesquisar(String text);
    
}