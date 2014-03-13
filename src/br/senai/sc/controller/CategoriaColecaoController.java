package br.senai.sc.controller;

import br.senai.sc.model.negocio.CategoriaColecao;
import br.senai.sc.model.persistencia.CategoriaColecaoDaoJDBC;
import br.senai.sc.model.persistencia.dao.CategoriaColecaoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Gabriel
 * @version 1.0 29/10/2013
 */
public class CategoriaColecaoController {

    public int inserir(CategoriaColecao cc) {
        CategoriaColecaoDAO dao = new CategoriaColecaoDaoJDBC();
        return dao.insert(cc);
    }

    public int atualizar(CategoriaColecao cc) {
        CategoriaColecaoDAO dao = new CategoriaColecaoDaoJDBC();
        return dao.update(cc);
    }

    public boolean deletar(int id) {
        CategoriaColecaoDAO dao = new CategoriaColecaoDaoJDBC();
        return dao.delete(id);
    }

    public List<CategoriaColecao> listarTodas() {
        CategoriaColecaoDAO dao = new CategoriaColecaoDaoJDBC();
        return dao.listAll();
    }

    public CategoriaColecao listarId(int id) {
        CategoriaColecaoDAO dao = new CategoriaColecaoDaoJDBC();
        return dao.listId(id);
    }

    public List<CategoriaColecao> listarNome(String nome) {
        CategoriaColecaoDAO dao = new CategoriaColecaoDaoJDBC();
        return dao.listName(nome);
    }
}
