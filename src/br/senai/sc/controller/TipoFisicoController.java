/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.controller;

import br.senai.sc.model.negocio.TipoFisico;
import br.senai.sc.model.persistencia.TipoFisicoDaoJDCB;
import br.senai.sc.model.persistencia.dao.TipoFisicoDAO;
import java.util.List;

/**
 * @author Gustavo L. Alves
 * @version 1.0 05/11/2013
 */
public class TipoFisicoController {

    /**
     * Método que serve para realizar a ligação entre o método listAll da base
     * de dados e a interface gráfica.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @return
     */
    public List<TipoFisico> listAll() {
        TipoFisicoDAO dao = new TipoFisicoDaoJDCB();
        return dao.listAll();
    }

    /**
     * Método que serve para realizar a ligação entre o método inserir da base
     * de dados e a interface gráfica.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param tf
     * @return
     */
    public int inserir(TipoFisico tf) {
        TipoFisicoDAO dao = new TipoFisicoDaoJDCB();
        return dao.insert(tf);
    }

    /**
     * Método que serve para realizar a ligação entre o método delete da base de
     * dados e a interface gráfica.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */
    public boolean delete(int id) {
        TipoFisicoDAO dao = new TipoFisicoDaoJDCB();
        return dao.delete(id);
    }

    /**
     * Método que serve para realizar a ligação entre o método pesquisar da base
     * de dados e a interface gráfica.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param texto
     * @return
     */
    public List<TipoFisico> pesquisar(String texto) {
        TipoFisicoDAO dao = new TipoFisicoDaoJDCB();
        return dao.ListPesquisa(texto);
    }

    /**
     * Método que serve para realizar a ligação entre o método update da base de
     * dados e a interface gráfica.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param tf
     * @return
     */
    public boolean update(TipoFisico tf) {
        TipoFisicoDAO dao = new TipoFisicoDaoJDCB();
        return dao.update(tf);
    }

    /**
     * Método que serve para realizar a ligação entre o método listId da base de
     * dados e a interface gráfica.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */
    public TipoFisico listId(int id) {
        TipoFisicoDAO dao = new TipoFisicoDaoJDCB();
        return dao.listById(id);
    }
}
