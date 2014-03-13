/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.controller;

import br.senai.sc.model.negocio.Medida;
import br.senai.sc.model.persistencia.MedidaDaoJDBC;
import br.senai.sc.model.persistencia.dao.MedidaDAO;
import java.util.List;

/**
 * @author Gustavo L. Alves
 * @version 1.0 05/11/2013
 */
public class MedidaController {

    /**
     * Método que serve para realizar a ligação entre o método listAll da base
     * de dados e a interface gráfica.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @return
     */
    public List<Medida> listAll() {
        MedidaDAO dao = new MedidaDaoJDBC();
        return dao.listall();
    }

    /**
     * Método que serve para realizar a ligação entre o método inserir da base
     * de dados e a interface gráfica.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param m
     * @return
     */
    public int inserir(Medida m) {
        MedidaDAO dao = new MedidaDaoJDBC();
        return dao.insert(m);
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
        MedidaDAO dao = new MedidaDaoJDBC();
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
    public List<Medida> pesquisar(String texto) {
        MedidaDAO dao = new MedidaDaoJDBC();
        return dao.ListPesquisa(texto);
    }

    /**
     * Método que serve para realizar a ligação entre o método update da base de
     * dados e a interface gráfica.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param m
     * @return
     */
    public boolean update(Medida m) {
        MedidaDAO dao = new MedidaDaoJDBC();
        return dao.update(m);
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
    public Medida listId(int id) {
        MedidaDAO dao = new MedidaDaoJDBC();
        return dao.listById(id);
    }
}
