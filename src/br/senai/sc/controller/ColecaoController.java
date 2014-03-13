package br.senai.sc.controller;

import br.senai.sc.model.negocio.Colecao;
import br.senai.sc.model.persistencia.ColecaoDaoJDBC;
import br.senai.sc.model.persistencia.dao.ColecaoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Gabriel Arsênio
 */
public class ColecaoController {

    public int inserir(Colecao c) {
        ColecaoDAO dao = new ColecaoDaoJDBC();
        return dao.insert(c);
    }

    public int atualizar(Colecao c) {
        ColecaoDAO dao = new ColecaoDaoJDBC();
        return dao.update(c);
    }

    public boolean deletar(int cod) {
        ColecaoDAO dao = new ColecaoDaoJDBC();
        return dao.delete(cod);
    }

    public List<Colecao> listarTodas() {
        ColecaoDAO dao = new ColecaoDaoJDBC();
        return dao.listAll();
    }

    public Colecao listarId(int id) {
        ColecaoDAO dao = new ColecaoDaoJDBC();
        return dao.listId(id);
    }

    public List<Colecao> listarNome(String nome) {
        ColecaoDAO dao = new ColecaoDaoJDBC();
        return dao.listName(nome);
    }
}
