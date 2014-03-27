package br.senai.sc.model.persistencia.dao;
import br.senai.sc.model.negocio.Medida;
import java.util.List;


/**
 * @author Gustavo L. ALves
 * @version 1.0 05/11/2013
 */

public interface MedidaDAO extends DAO<Medida, Integer> {
    
    List<Medida> pesquisarNome(String nome);
    

   
}
