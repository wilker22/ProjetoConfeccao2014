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
public class FabricantesController {
    /**
     * Método de ligação do método de listagem dos registros com a interface gráfica
     * @author Mateus Generoso
     * @since 1.0 05/11/2013
     * @param f
     * @return 
     */
    public List<Fabricante> listAll() {
        FabricanteDAO dao = new FabricanteDaoJDBC();
        return dao.listAll();
    }
    
    /**
     * Método de ligação do método de inserção com a interface gráfica
     * @author Mateus Generoso
     * @since 1.0 05/11/2013
     * @param fab
     * @return 
     */

    public int insert(Fabricante fab) {
        FabricanteDAO dao = new FabricanteDaoJDBC();
        return dao.insert(fab);
    }
    
    /**
     * Método de ligação do método de atualização com a interface gráfica
     * @author Mateus Generoso
     * @since 1.0 05/11/2013
     * @param fab
     * @return 
     */
    public int update(Fabricante fab) {
        FabricanteDAO dao = new FabricanteDaoJDBC();
        return dao.update(fab);
    }
    /**
     * Método de ligação do método de deleção com a interface gráfica
     * @author Mateus Generoso
     * @since 1.0 05/11/2013
     * @param fab
     * @return 
     */
    public boolean delete(Fabricante fab) {
        FabricanteDAO dao = new FabricanteDaoJDBC();
        return dao.delete(fab);
    }
    /**
     * Método de ligação do método de pesquisa com a interface gráfica
     * @author Mateus Generoso
     * @since 1.0 05/11/2013
     * @param texto
     * @return 
     */
     public List<Fabricante> pesquisa(String texto){
        FabricanteDAO dao = new FabricanteDaoJDBC();
        return dao.ListPesquisar(texto);
    }
}

