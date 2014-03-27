package br.senai.sc.controller;

import br.senai.sc.model.negocio.Curriculo;
import br.senai.sc.model.persistencia.CurriculoDAOJPA;
import br.senai.sc.model.persistencia.dao.CurriculoDAO;
import java.util.List;

public class CurriculoController {

    public Curriculo salvar(Curriculo curriculo) {
        CurriculoDAO dao = new CurriculoDAOJPA();
        return dao.save(curriculo);
    }

    public boolean excluir(int codigo) {
        CurriculoDAO dao = new CurriculoDAOJPA();
        return dao.remove(Curriculo.class, codigo);
    }

    public List<Curriculo> listarCurriculos() {
        CurriculoDAO dao = new CurriculoDAOJPA();
        return dao.getAll(Curriculo.class);
    }

    public Curriculo listarCurriculoById(int codigo) {
        CurriculoDAO dao = new CurriculoDAOJPA();
        return dao.getById(Curriculo.class, codigo);
    }
}
