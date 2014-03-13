/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Ferias;
import java.util.List;

/**
 *
 * @author larissa_mezari
 */
public interface FeriasDAO {
 	 
	boolean insert(Ferias f);

 
	boolean update(Ferias f);

 
	boolean delete(int id);

 
	List<Ferias> listAll();
        
        Ferias listById(int cod);

 
    
}
 


