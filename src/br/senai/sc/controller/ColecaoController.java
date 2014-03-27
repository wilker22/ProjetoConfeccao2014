package br.senai.sc.controller;

import br.senai.sc.model.negocio.Colecao;
import br.senai.sc.model.persistencia.ColecaoDaoJPA;
import br.senai.sc.model.persistencia.dao.ColecaoDAO;
import java.util.List;

public class ColecaoController {

    public Colecao salve(Colecao colecao) {
        ColecaoDAO dao = new ColecaoDaoJPA();

        return dao.save(colecao);
    }

    public boolean deletar(int codigo) {
        ColecaoDAO dao = new ColecaoDaoJPA();

        return dao.remove(Colecao.class, codigo);
    }

    public List<Colecao> listarTodas() {
        ColecaoDAO dao = new ColecaoDaoJPA();

        return dao.getAll(Colecao.class);
    }

    public Colecao listarColecaoById(int codigo) {
        ColecaoDAO dao = new ColecaoDaoJPA();

        return dao.getById(Colecao.class, codigo);
    }

    public List<Colecao> listEstacao(String estacao) {
        ColecaoDAO dao = new ColecaoDaoJPA();
        return dao.listEstacao(estacao);
    }

    public List<Colecao> pesquisarEstacao(String estacao) {
        ColecaoDAO dao = new ColecaoDaoJPA();
        return dao.pesquisarEstacao(estacao);
    }

    public List<Colecao> pesquisarAno(int ano) {
        ColecaoDAO dao = new ColecaoDaoJPA();
        return dao.pesquisarAno(ano);
    }
}
