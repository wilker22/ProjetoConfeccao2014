/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.app;

import br.senai.sc.controller.TesteController;
import br.senai.sc.controller.UsuarioController;
import br.senai.sc.model.negocio.Teste;
import br.senai.sc.model.negocio.Usuario;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rosicleia.souza
 */
public class TestePrincipal {
    
    public static void main(String[] args) {
        
       
        Usuario u = new Usuario();
        
        u.setNome("Teste");
        
        UsuarioController uc = new UsuarioController();
        uc.insert(u);
        
        
    }
}
