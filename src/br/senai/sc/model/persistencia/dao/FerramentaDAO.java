/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Ferramenta;
import br.senai.sc.model.negocio.Pessoa;
import java.util.List;

/**
 *
 * @author ariane_souza
 */
public interface FerramentaDAO {
    
     /*
     * Método responsável pela inserção de uma ferramenta
     * @author Ariane Souza da Silva
     * @version 1.0 09/09/2013
     * @param f
     * @return
     */
    int insert(Ferramenta f);
    /**
     * Método responsável pela atualização de uma ferramenta
     * @author Ariane Souza da Silva
     * @version 1.0 09/09/2013
     * @param f
     * @return 
     */
    int update(Ferramenta f);
    
    /*
     * Método responsável pela remoção de uma ferramenta
     * @author Ariane Souza da Silva
     * @version 1.0 09/09/2013
     * @param codFerramenta
     * @return
     */
    boolean delete(int codFerramenta);
    
    /**
     * Método responsável pela listagem de todas as ferramentas
     * @author Ariane Souza da Silva
     * @version 1.0 09/09/2013
     * @return 
     */
    
    List<Ferramenta> listAll();
    
    /**
     * Método responsável pela listagem de ferramentas com o codigo enviado pelo parametro
     * @author Ariane Souza da Silva
     * @version 1.0 09/09/2013
     * @param codFerramenta
     * @return 
     */
    
    Ferramenta listById(int codFerramenta);
    
    /**
     * Método responsável pela listagem de ferramentas, com filtragem, mostrando apenas correspondentes que tiverem ao menos parte do digitado
     * @author Ariane Souza da Silva
     * @version 1.0 05/11/2013
     * @param texto
     * @return 
     */
    
    List<Ferramenta> listPesquisa(String texto);
}


