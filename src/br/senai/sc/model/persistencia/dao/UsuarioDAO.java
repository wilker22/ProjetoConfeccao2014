/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Usuario;
import java.util.List;

/**
 *
 * @author larissa_mezari
 */
public interface UsuarioDAO {
    

   
	boolean insert(Usuario u);

 
	boolean update(Usuario u);

 
	boolean delete(int id);

 
	List<Usuario> listAll();

        Usuario listById(int cod);
 
         List<Usuario> listPesquisa(String texto);

}


