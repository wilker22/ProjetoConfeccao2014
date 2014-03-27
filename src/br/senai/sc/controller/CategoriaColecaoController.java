package br.senai.sc.controller;

import br.senai.sc.model.negocio.CategoriaColecao;
import br.senai.sc.model.persistencia.CategoriaColecaoDaoJPA;
import br.senai.sc.model.persistencia.dao.CategoriaColecaoDAO;
import java.util.List;

/**
 *
 * @author Gabriel
 * @version 1.0 29/10/2013
 */
public class CategoriaColecaoController {

    public CategoriaColecao salvar(CategoriaColecao cc) {
        CategoriaColecaoDAO dao = new CategoriaColecaoDaoJPA();
        return dao.save(cc);
    }

    public boolean excluir(int codigo) {
        CategoriaColecaoDAO dao = new CategoriaColecaoDaoJPA();
        return dao.remove(CategoriaColecao.class, codigo);

    }

    public List<CategoriaColecao> listarCategoriaColecao() {
        CategoriaColecaoDAO dao = new CategoriaColecaoDaoJPA();
        return dao.getAll(CategoriaColecao.class);
    }

    public CategoriaColecao listarCategoriaColecaoById(int codCategoriaColecao) {
        CategoriaColecaoDAO dao = new CategoriaColecaoDaoJPA();
        return dao.getById(CategoriaColecao.class, codCategoriaColecao);

    }

    public List<CategoriaColecao> pesquisarNome(String nome) {
        CategoriaColecaoDAO dao = new CategoriaColecaoDaoJPA();
        return dao.pesquisaNome(nome);
    }
}