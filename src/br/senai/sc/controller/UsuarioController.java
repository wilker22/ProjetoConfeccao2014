package br.senai.sc.controller;

import br.senai.sc.model.negocio.Usuario;
import br.senai.sc.model.persistencia.UsuarioDAOJPA;
import br.senai.sc.model.persistencia.dao.UsuarioDAO;
import java.util.List;

/**
 *
 * @author larissa_mezari
 */
public class UsuarioController {

    public List<Usuario> listAll() {
        UsuarioDAO dao = new UsuarioDAOJPA();
        return dao.getAll(Usuario.class);
    }

    public Usuario insert(Usuario u) {
        UsuarioDAO dao = new UsuarioDAOJPA();
        return dao.save(u);
    }

    public Usuario update(Usuario u) {
        UsuarioDAO dao = new UsuarioDAOJPA();
        return dao.save(u);
    }

    public boolean delete(int codUsuario) {
        UsuarioDAO dao = new UsuarioDAOJPA();
        return dao.remove(Usuario.class, codUsuario);
    }

    public Usuario listById(int id) {
        UsuarioDAO dao = new UsuarioDAOJPA();
        return dao.getById(Usuario.class, id);
    }

    public List<Usuario> pesquisar(String texto) {
        UsuarioDAO dao = new UsuarioDAOJPA();
        return dao.listPesquisa(texto);
    }
}
