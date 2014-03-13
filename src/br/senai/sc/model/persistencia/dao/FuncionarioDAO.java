package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Funcionario;
import java.util.List;

/**
 * @version 1.0 21/09/2013
 * @author patricia_gageiro
 */
public interface FuncionarioDAO {

    /*
     * Método responsável pela inserção de um funcionário.
     * @since 1.0 05/11/2013
     * @author Patricia Gageiro
     * @param p
     * @return
     * 
     */
    int insert(Funcionario fun);

    /*
     * Método responsável pela atualização de um funcionário.
     * @since 1.0 05/11/2013
     * @author Patricia Gageiro
     * @param p
     * @return
     * 
     */
    boolean update(Funcionario fun);


    /*
     * Método responsável pela deleção de um funcionário.
     * @since 1.0 05/11/2013
     * @author Patricia Gageiro
     * @param p
     * @return
     */
    boolean delete(Funcionario fun);

    
    /*
     * Método responsável pela listagem por id dos funcionários.
     * @since 1.0 05/11/2013
     * @author Patricia Gageiro
     * @param p
     * @return
     */
    Funcionario listById(int id);
    
    /**
     * Método responsável pela listagem dos funcionários.
     * @since 1.0 05/11/2013
     *@author Patricia Gageiro
     *@param id
     *@return
     */

    public List<Funcionario> listAll();
    
    
    /**
     * Método responsável pela pesquisa dos funcionários
     *@author Patricia Gageiro
     *@since 1.0 05/11/2013
     *@param texto
     *@return 
     */
    List<Funcionario> ListPesquisa(String texto);

}
