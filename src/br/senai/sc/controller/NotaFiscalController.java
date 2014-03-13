/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.controller;

import br.senai.sc.model.negocio.NotaFiscal;
import br.senai.sc.model.persistencia.NotaFiscalDaoJDBC;
import br.senai.sc.model.persistencia.dao.NotaFiscalDAO;
import java.util.List;

/**
 *
 * @author elivelton_sipriano
 */
public class NotaFiscalController {
    public List<NotaFiscal> listAll() {
        NotaFiscalDAO dao = new NotaFiscalDaoJDBC();
        return dao.listAll();
    }

    //--------------------------------------------------------------------------
    public int inserir(NotaFiscal a) {
        NotaFiscalDAO dao = new NotaFiscalDaoJDBC();
        return dao.insert(a);
    }

    //--------------------------------------------------------------------------
    public boolean delete(int id) {
        NotaFiscalDAO dao = new NotaFiscalDaoJDBC();
        return dao.delete(id);
    }

    //--------------------------------------------------------------------------
    public int update(NotaFiscal t) {
        NotaFiscalDAO dao = new NotaFiscalDaoJDBC();
        return dao.update(t);
    }

    //--------------------------------------------------------------------------
    public NotaFiscal listById(int id) {
        NotaFiscalDAO dao = new NotaFiscalDaoJDBC();
        return dao.listById(id);
    }

    //--------------------------------------------------------------------------
    public List<NotaFiscal> pesquisar(String texto) {
        NotaFiscalDAO dao = new NotaFiscalDaoJDBC();
        return dao.listPesquisa(texto);
    }
        
}

