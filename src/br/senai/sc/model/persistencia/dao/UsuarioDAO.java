package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Usuario;
import java.util.List;

/**
 *
 * @author mateus_aguiar
 */
public interface UsuarioDAO extends DAO<Usuario, Integer>{
     
         List<Usuario> listPesquisa(String texto);

}


