package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Entrada;
import java.util.List;

/***
 *
 * @author Nathan_Bettiol
 */
public interface EntradaDAO {
    /***
     * Método responsável pela inserção de uma Entrada
     * @author Nathan_bettiol
     * @version 1.0 13/09/2013
     * @param e
     * @return
     */
    boolean insert(Entrada e);
    /**
     * Método responsável pela atualização de uma Entrada
     * @author Nathan Bettiol
     * @version 1.0 13/09/2013
     * @param e
     * @return
     */
    boolean update(Entrada e);
    /**
     * Método responsável pela remoção de um Entrada
     * @author Nathan Bettiol
     * @version 1.0 13/09/2013
     * @param codigoEntrada
     * @return
     */
    boolean delete(int cod_entrada);
    /**
     * Método responsável pela listagem de todos as Entradas
     * @author Nathan Bettiol
     * @version 1.0 13/09/2013
     * @return
     */
    List<Entrada> listAll();
    /**
     * Método responsável pela listagem de uma Entrada por ID.
     * @author Nathan Bettiol
     * @version 1.0 13/09/2013
     * @return
     */
    
     List<Entrada> listById(int codEntrada);
    /**
     * Método responsável pela listagem de uma Entrada por ID.
     * @author Nathan Bettiol
     * @version 1.0 29/10/2013
     * @param cod_entrada
     * @return
     */
     
     List<Entrada> listName(String nome);
    
}