/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Ferias;
import java.util.List;


public interface FeriasDAO extends DAO<Ferias, Integer> {
 	
     List <Ferias> pesquisarNome(String nome);   

    public Ferias save(Ferias cliente);
}
 


