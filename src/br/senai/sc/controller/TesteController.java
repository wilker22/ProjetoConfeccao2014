/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.controller;

import br.senai.sc.model.negocio.Teste;
import br.senai.sc.model.persistencia.TesteDAOJPA;
import br.senai.sc.model.persistencia.dao.TesteDAO;
import java.util.List;

/**
 *
 * @author rosicleia.souza
 */
public class TesteController {
    
    public Teste salvar (Teste teste){
        TesteDAO dao = new TesteDAOJPA();
        return dao.save(teste);
    }
    
  
    
}
