/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia.dao;


import br.senai.sc.model.negocio.Conserto;
import java.util.List;

/**
 *
 * @author gustavo_cardoso
 */
public interface ConsertoDAO {
    
    int insert(Conserto c);

    List<Conserto> listAll();
    
    
}
