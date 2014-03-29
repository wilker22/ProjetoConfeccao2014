package br.senai.sc.controller;

import br.senai.sc.model.negocio.Entrada;
import br.senai.sc.model.persistencia.EntradaDaoJPA;
import br.senai.sc.model.persistencia.dao.EntradaDAO;
import java.util.List;

/**
 *
 * @author patricia_gageiro
 */
public class EntradaController {

    public Entrada insert(Entrada entrada) {
        EntradaDAO dao = new EntradaDaoJPA();
        return dao.save(entrada);
    }

    public boolean remove(int codigo) {
        EntradaDAO dao = new EntradaDaoJPA();
        return dao.remove(Entrada.class, codigo);

    }

    public List<Entrada> listarTodos() {
        EntradaDAO dao = new EntradaDaoJPA();
        return dao.getAll(Entrada.class);
    }

    public Entrada listarEntradaById(int codigo) {
        EntradaDAO dao = new EntradaDaoJPA();
        return dao.getById(Entrada.class, codigo);

    }

    public List<Entrada> pesquisarNome(String nome) {
        EntradaDAO dao = new EntradaDaoJPA();
        return dao.pesquisaNome(nome);
    }
}