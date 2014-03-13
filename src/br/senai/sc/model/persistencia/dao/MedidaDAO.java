/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Medida;
import java.util.List;

/**
 * @author Gustavo L. ALves
 * @version 1.0 05/11/2013
 */
public interface MedidaDAO {

    /**
     * Interface responsável pelo método insert da classe MedidaDaoJDBC.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param m
     * @return
     */
    int insert(Medida m);

    /**
     * Interface responsável pelo método update da classe MedidaDaoJDBC.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param m
     * @return
     */
    boolean update(Medida m);

    /**
     * Interface responsável pelo método delete da classe MedidaDaoJDBC.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * Interface responsável pelo método listall da classe MedidaDaoJDBC.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @return
     */
    List<Medida> listall();

    /**
     * Interface responsável pelo método listById da classe MedidaDaoJDBC.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */
    Medida listById(int id);

    /**
     * Interface responsável pelo método ListPesquisa da classe MedidaDaoJDBC.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param texto
     * @return
     */
    List<Medida> ListPesquisa(String texto);
}
