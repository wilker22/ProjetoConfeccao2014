/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.controller;


import br.senai.sc.model.negocio.Conserto;
import br.senai.sc.model.persistencia.ConsertoDAOJDBC;
import br.senai.sc.model.persistencia.dao.ConsertoDAO;
import java.util.List;

/**
 *
 * @author gustavo_cardoso
 */
public class ConsertoController {
    
     public List<Conserto> listAll(){
        ConsertoDAO dao = new ConsertoDAOJDBC();
        return dao.listAll();
    }
    
    public int inserir (Conserto c){
        ConsertoDAO dao = new ConsertoDAOJDBC();
        return dao.insert(c);
    }
    
}
