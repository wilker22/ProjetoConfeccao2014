/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.app;

import br.senai.sc.controller.TesteController;
import br.senai.sc.model.negocio.Teste;

/**
 *
 * @author rosicleia.souza
 */
public class TestePrincipal {
    
    public static void main(String[] args) {
        
        Teste t = new Teste();
        
        t.setNome("tt");
        
        TesteController tc = new TesteController();
        tc.salvar(t);
        
        
    }
}
