/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.controller;


import br.senai.sc.model.negocio.Devolucao;
import br.senai.sc.model.persistencia.DevolucaoDaoJDBC;
import br.senai.sc.model.persistencia.dao.DevolucaoDAO;

import java.util.List;

/**
 *
 * @author douglas_ghisleri
 */
public class DevolucaoController {
    
    /**
     * Método serve para listar as devoluções.
     *
     * @author douglas_ghisleri
     * @since 1.0 05/11/2013
     * @param dev
     * @return
     */
    
   public List<Devolucao> listAll() {
        DevolucaoDAO dao = new DevolucaoDaoJDBC();
        return dao.listAll();
    }

    
     /**
     * Método serve para inserir uma devolução.
     *
     * @author douglas_ghisleri
     * @since 1.0 05/11/2013
     * @param dev
     * @return
     */
    
    public int inserir(Devolucao d) {
       DevolucaoDAO dao = new DevolucaoDaoJDBC();
       return dao.insert(d);
   }
    
     /**
     * Método serve para remover uma devolução.
     *
     * @author douglas_ghisleri
     * @since 1.0 05/11/2013
     * @param dev
     * @return
     */
    
    public boolean delete(Devolucao d) {
        DevolucaoDAO dao = new DevolucaoDaoJDBC();
       return dao.delete(d);
   }

    
    /**
     * Método serve para fazer uma pesquisa em devoluções.
     *
     * @author douglas_ghisleri
     * @since 1.0 05/11/2013
     * @param dev
     * @return
     */
    
    public List<Devolucao> pesquisar(String texto) {
       DevolucaoDAO dao = new DevolucaoDaoJDBC();
        return dao.ListPesquisar(texto);
   }
//
    
    /**
     * Método serve para atualizar uma devolução.
     *
     * @author douglas_ghisleri
     * @since 1.0 05/11/2013
     * @param dev
     * @return
     */
    
    public int update(Devolucao d) {
        DevolucaoDAO dao = new DevolucaoDaoJDBC();
        return dao.update(d);
    }

    
     /**
     * Método serve para listar por id as devoluções.
     *
     * @author douglas_ghisleri
     * @since 1.0 05/11/2013
     * @param dev
     * @return
     */
    
    public Devolucao listById(int cod_devolucao) {
        DevolucaoDAO dao = new DevolucaoDaoJDBC();
        return dao.listById(cod_devolucao);
    }
    
}
