/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.controller;

import br.senai.sc.model.negocio.Ferias;
import br.senai.sc.model.persistencia.FeriasDaoJPA;
import br.senai.sc.model.persistencia.dao.FeriasDAO;
import java.util.List;

/**
 *
 * @author larissa_mezari
 */
public class FeriasController {

       public Ferias salvar(Ferias ferias) {
        FeriasDAO dao = new FeriasDaoJPA();
        return dao.save(ferias);
    }

    public boolean excluir(int codigo) {
        FeriasDAO dao = new FeriasDaoJPA();
        return dao.remove(Ferias.class, codigo);
    }

    public List<Ferias> listarFerias() {
        FeriasDAO dao = new FeriasDaoJPA();
        return dao.getAll(Ferias.class);
    }

    public Ferias listarFeriasById(int codigo) {
        FeriasDAO dao = new FeriasDaoJPA();
        return dao.getById(Ferias.class, codigo);
    }
    
    public List<Ferias> pesquisarNome(String nome){
        FeriasDAO dao = new FeriasDaoJPA();
        return dao.pesquisarNome(nome);
        
    }
}
