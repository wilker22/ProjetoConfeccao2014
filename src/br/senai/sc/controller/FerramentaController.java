package br.senai.sc.controller;

import br.senai.sc.model.negocio.Ferramenta;
import br.senai.sc.model.persistencia.FerramentaDaoJDBC;
import br.senai.sc.model.persistencia.dao.FerramentaDAO;
import java.util.List;

public class FerramentaController {
    /**
     * 
     * @return 
     */
    public List<Ferramenta> listAll() {
        FerramentaDAO dao = (FerramentaDAO) new FerramentaDaoJDBC();
        return dao.listAll();
    }

    public int insert (Ferramenta f){
        FerramentaDAO dao = (FerramentaDAO) new FerramentaDaoJDBC();
        return dao.insert(f);
    }
    
    public int update (Ferramenta f){
        FerramentaDaoJDBC dao = new FerramentaDaoJDBC();
        return dao.update(f);
    }
    
     public boolean remove (int codFerramenta){
        FerramentaDAO dao = (FerramentaDAO) new FerramentaDaoJDBC();
        return dao.delete(codFerramenta);
    } 

    public List<Ferramenta> pesquisar(String texto){
        FerramentaDaoJDBC dao = new FerramentaDaoJDBC();
        return dao.listPesquisa(texto);
    }

}

