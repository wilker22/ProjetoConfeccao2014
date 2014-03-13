package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Sobra;
import java.util.List;

/**
 *
 * @author Patricia Gageiro
 * @version 1.0 23/09/2013
 * 
 */
public interface SobraDAO {
    /*
     * Método responsável pela inserção de uma sobra.
     * @version 1.0 23/09/2013
     * @author Patricia Gageiro
     * @param p
     * @return
     * 
     */
    int insert(Sobra sob);

    /*
     * Método responsável pela atualização de uma sobra
     * @version 1.0 23/09/2013
     * @author Patricia Gageiro
     * @param p
     * @return
     * 
     */
    boolean update(Sobra sob);


    /*
     * Método responsável pela deleção de uma sobra.
     * @version 1.0 23/06/2013
     * @author Patricia Gageiro
     * @param p
     * @return
     */
    boolean delete(Sobra sob);

    /*
     * Método responsável pela listagem das Sobras.
     * @version 1.0 23/09/2013
     * @author Patricia Gageiro
     * @param p
     * @return
     */
    List<Sobra> ListAll();
    
    /*
     * Método responsável pela listagem por id da Sobras.
     * @version 1.0 23/09/2013
     * @author Patricia Gageiro
     * @param p
     * @return
     */
    Sobra listById(int id);
    
    /**
     * Método responsável pela pesquisa dos funcionários
     *@author Patricia Gageiro
     *@since 1.0 05/11/2013
     *@param texto
     *@return 
     */
    List<Sobra> ListPesquisa(String texto);

}

