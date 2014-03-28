package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.MateriaPrima;
import java.util.List;

/**
 *
 * @author Leticia de Jesus Ribeiro
 * @version 1.0 20/09/2013
 */
public interface MateriaPrimaDAO extends DAO<MateriaPrima, Integer> {

    List<MateriaPrima> pesquisarNome(String nome);
     

}
//    /*
//     * Declaração do método responsável pela inserção de dados de  uma matéria-prima. 
//     * @author Letícia de Jesus Ribeiro
//     * @version 1.0 13/09/2013
//     * @param mp
//     * @return
//     */
//
//    int insert(MateriaPrima mp);
//
//    /*
//     * Declaração do método responsável pela atualiização de dados de uma matéria-prima.
//     * @author Letícia de Jesus Ribeiro
//     * @version 1.0 13/09/2013
//     * @param mp
//     * @return
//     */
//    int update(MateriaPrima mp);
//
//    /*
//     * Método responsável por deletar dados de matéria-prima. 
//     * @author Letícia de Jesus Ribeiro
//     * @version 1.0 13/09/2013
//     * @param codMateriaPrima
//     * @return
//     */
//    boolean delete(int CodMateriaPrima);
//
//    /*
//     * Declaração do método responsável pela listagem de dados de matéria-prima.
//     * @author Letícia de Jesus Ribeiro
//     * @version 1.0 13/09/2013
//     * @param 
//     * @return
//     */
//    List<MateriaPrima> listAll();
//
//    /*
//     *Declaração do método responsável pela pesquisa de dados de  matéria-prima.
//     * @author Letícia de Jesus Ribeiro
//     * @version 1.0 29/10/2013
//     * @param 
//     * @return
//     */
//    List<MateriaPrima> listPesquisa(String texto);
//
//    /*
//     * Declaração do método responsável pela listagem de matéria-prima por id co código enviado por parâmetro. 
//     * @author Letícia de Jesus Ribeiro
//     * @version 1.0 29/10/2013
//     * @param codMateriaPrima
//     * @return
//     */
//    MateriaPrima listById(int CodMateriaPrima);
//}