/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.controller;

import br.senai.sc.model.negocio.Entrada;
import br.senai.sc.model.persistencia.EntradaDaoJDBC;
import br.senai.sc.model.persistencia.dao.EntradaDAO;

import java.util.List;

/**
 *
 * @author nathan_bettiol
 */
public class EntradaController {
    
    
    public boolean insert(Entrada e) {
        EntradaDAO dao = new EntradaDaoJDBC();
        return dao.insert(e);
    }

    public List<Entrada> listarTodos() {
        EntradaDAO dao = new EntradaDaoJDBC();
        return dao.listAll();
    }

      public boolean remove (int id){
        EntradaDAO dao = new EntradaDaoJDBC();
        return dao.delete(id);
    }
    
    public boolean update(Entrada e){
        EntradaDAO dao = new EntradaDaoJDBC();
        return dao.update(e);
    }
    
    public List<Entrada> listById(int id){
        EntradaDAO dao = new EntradaDaoJDBC();
        return dao.listById(id);
    }
      public List<Entrada> listarNome(String nome) {
        EntradaDAO dao = new EntradaDaoJDBC();
        return dao.listName(nome);
    }
}