package br.senai.sc.controller;

import br.senai.sc.model.negocio.Funcionario;
import br.senai.sc.model.persistencia.FuncionarioDAOJPA;
import br.senai.sc.model.persistencia.dao.FuncionarioDAO;

import java.util.List;

/**
 *
 * @author patricia_gageiro
 * @version 1.0 09/10/2013
 */
public class FuncionarioController {

    public Funcionario salvar(Funcionario funcionario) {
        FuncionarioDAO dao = new FuncionarioDAOJPA();
        return dao.save(funcionario);
    }

    public boolean excluir(int codigo) {
        FuncionarioDAO dao = new FuncionarioDAOJPA();
        return dao.remove(Funcionario.class, codigo);
    }

    public List<Funcionario> listarFuncionario() {
        FuncionarioDAO dao = new FuncionarioDAOJPA();
        return dao.getAll(Funcionario.class);
    }

    public Funcionario listarFuncionarioById(int codigo) {
        FuncionarioDAO dao = new FuncionarioDAOJPA();
        return dao.getById(Funcionario.class, codigo);
    }

    public List<Funcionario> pesquisarNome(String nome) {
        FuncionarioDAO dao = new FuncionarioDAOJPA();
        return dao.pesquisarNome(nome);

    }
}
