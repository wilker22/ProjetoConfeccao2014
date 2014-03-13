/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.TipoFisico;
import java.util.List;

/**
 * @author Gustavo L. Alves
 * @version 1.0 05/11/2013
 *
 */
public interface TipoFisicoDAO {

    /**
     * Interface responsável pelo método insert da classe TipoFisicoDaoJDCB.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param tf
     * @return
     */
    int insert(TipoFisico tf);

    /**
     * Interface responsável pelo método update da classe TipoFisicoDaoJDCB.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param tf
     * @return
     */
    boolean update(TipoFisico tf);

    /**
     * Interface responsável pelo método delete da classe TipoFisicoDaoJDCB.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * Interface responsável pelo método listAll da classe TipoFisicoDaoJDCB.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @return
     */
    List<TipoFisico> listAll();

    /**
     * Interface responsável pelo método ListPesquisa da classe
     * TipoFisicoDaoJDCB.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param texto
     * @return
     */
    List<TipoFisico> ListPesquisa(String texto);

    /**
     * Interface responsável pelo método listById da classe TipoFisicoDaoJDCB.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */
    TipoFisico listById(int id);
}
