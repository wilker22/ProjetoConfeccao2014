/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.CategoriaMateriaPrima;
import java.util.List;

/**
 *
 * @author Letícia de Jesus Ribeiro
 * @version 1.0 20/09/2013
 *
 */
public interface CategoriaMateriaPrimaDAO {

    /*
     *Declaração do  método responsável pela inserção de dados de uma categoria de matéria-prima 
     * @author LetíciaJRibeiro
     * @version 1.0 13/09/2013
     * @param mp
     * @return
     */
    int insert(CategoriaMateriaPrima mp);

    /*
     * Declaração do método responsável pela atualização de dados de  uma categoria de matéria-prima 
     * @author LetíciaJRibeiro
     * @version 1.0 13/09/2013
     * @param mp
     * @return
     */
    int update(CategoriaMateriaPrima mp);


    /*
     * Declaração do método responsável por deletar dados de uma categoria de materia-prima .
     * @author LetíciaJRibeiro
     * @version 1.0 13/09/2013
     * @param codCategoriaMateriaPrima
     * @return
     */
    boolean delete(int codCategoriaMateriaPrima);


    /*
     * Declaração do método responsável pela listagem de dados de categoria de  matéria-prima.
     * @author LetíciaJRibeiro
     * @version 1.0 13/09/2013
     * @param 
     * @return
     */
    List<CategoriaMateriaPrima> listAll();


    /*
     * Declaração do método responsável pela pesquisa de dados de  categoria de  matéria-prima.
     * @author LetíciaJRibeiro
     * @version 1.0 29/10/2013
     * @param 
     * @return
     */
    List<CategoriaMateriaPrima> listPesquisa(String texto);


    /*
     * Declaração do método responsável pela listagem de dados de categoria matéria-prima por id.
     * @author LetíciaJRibeiro
     * @version 1.0 29/10/2013
     * @param codCategoriaMateriaPrima
     * @return
     */
    CategoriaMateriaPrima listById(int codCategoriaMateriaPrima);
}
