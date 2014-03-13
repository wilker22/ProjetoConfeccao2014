package br.senai.sc.controller;


import br.senai.sc.model.negocio.Fornecedor;


import br.senai.sc.model.persistencia.FornecedorDaoJDBC;


import br.senai.sc.model.persistencia.dao.FornecedorDAO;

import java.util.List;

/**
 *
 * @author leticia_jesus
 * @version 1.0 09/10/2013
 */
public class FornecedorController {

    public List<Fornecedor> listAll() {
        FornecedorDAO dao = new FornecedorDaoJDBC();
        return dao.listall();
    }
    
  
}
