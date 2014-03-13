package br.senai.sc.controller;

import br.senai.sc.model.negocio.Fabricante;
import br.senai.sc.model.persistencia.FabricanteDaoJDBC;
import br.senai.sc.model.persistencia.dao.FabricanteDAO;
import java.util.List;

/**
 *
 * @author Mateus Generoso
 * @version 1.0 28/10/2013
 */
public class FabricanteController {
    
    public List<Fabricante> listAll() {
        FabricanteDAO dao = new FabricanteDaoJDBC();
        return dao.listAll();
    }

    public int insert(Fabricante fab) {
        FabricanteDAO dao = new FabricanteDaoJDBC();
        return dao.insert(fab);
    }

    public int update(Fabricante fab) {
        FabricanteDAO dao = new FabricanteDaoJDBC();
        return dao.update(fab);
    }

    public boolean delete(Fabricante fab) {
        FabricanteDAO dao = new FabricanteDaoJDBC();
        return dao.delete(fab);
    }
    
     public List<Fabricante> pesquisa(String texto){
        FabricanteDAO dao = new FabricanteDaoJDBC();
        return dao.ListPesquisar(texto);
    }
}
