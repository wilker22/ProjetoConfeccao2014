/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.controller;

import br.senai.sc.model.negocio.Ferias;
import br.senai.sc.model.persistencia.FeriasDaoJDBC;
import br.senai.sc.model.persistencia.dao.FeriasDAO;
import java.util.List;

/**
 *
 * @author larissa_mezari
 */
public class FeriasController {

    public List<Ferias> listAll() {
        FeriasDAO dao = new FeriasDaoJDBC();
        return dao.listAll();
    }

    public boolean insert(Ferias f) {
        FeriasDAO dao = new FeriasDaoJDBC();
        return dao.insert(f);
    }

    public boolean update(Ferias f) {
        FeriasDAO dao = new FeriasDaoJDBC();
        return dao.update(f);
    }

    public boolean delete(int codUsuario) {
        FeriasDAO dao = new FeriasDaoJDBC();
        return dao.delete(codUsuario);
    }

    public Ferias listById(int id) {
        FeriasDAO dao = new FeriasDaoJDBC();
        return dao.listById(id);
    }
}
