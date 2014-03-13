/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.controller;

import br.senai.sc.model.negocio.Curriculo;
import br.senai.sc.model.persistencia.CurriculoDAOJDBC;
import br.senai.sc.model.persistencia.dao.CurriculoDAO;
import java.util.List;




/**
 *
 * @author evaldo_matias
 */
public class CurriculoController {

    public int insert(Curriculo ff) {
        CurriculoDAO dao = new CurriculoDAOJDBC();
        return dao.insert(ff);
    }

    public List<Curriculo> listarTodos() {
        CurriculoDAO dao = new CurriculoDAOJDBC();
        return dao.listAll();
    }

    public boolean remove(int id) {
        CurriculoDAO dao = new CurriculoDAOJDBC();
        return dao.remove(id);
    }

    public int update(Curriculo f) {
        CurriculoDAO dao = new CurriculoDAOJDBC();
        return dao.update(f);
    }

    public Curriculo listById(int id) {
        CurriculoDAO dao = new CurriculoDAOJDBC();
        return dao.listById(id);
    }

    public List<Curriculo> pesquisar(String texto) {
        CurriculoDAO dao = new CurriculoDAOJDBC();
        return dao.Pesquisa(texto);
    }
}
