/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.controller;

import br.senai.sc.model.negocio.Usuario;
import br.senai.sc.model.persistencia.UsuarioDaoJDBC;
import br.senai.sc.model.persistencia.dao.UsuarioDAO;
import java.util.List;

/**
 *
 * @author larissa_mezari
 */
public class UsuarioController {

    public List<Usuario> listAll() {
        UsuarioDAO dao = new UsuarioDaoJDBC();
        return dao.listAll();
    }

    public boolean insert(Usuario u) {
        UsuarioDAO dao = new UsuarioDaoJDBC();
        return dao.insert(u);
    }

    public boolean update(Usuario u) {
        UsuarioDAO dao = new UsuarioDaoJDBC();
        return dao.update(u);
    }

    public boolean delete(int codUsuario) {
        UsuarioDAO dao = new UsuarioDaoJDBC();
        return dao.delete(codUsuario);
    }

    public Usuario listById(int id) {
        UsuarioDAO dao = new UsuarioDaoJDBC();
        return dao.listById(id);
    }

    public List<Usuario> pesquisar(String texto) {
        UsuarioDAO dao = new UsuarioDaoJDBC();
        return dao.listPesquisa(texto);
    }
}
