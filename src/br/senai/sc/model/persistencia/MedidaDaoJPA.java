package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Medida;
import br.senai.sc.model.persistencia.dao.MedidaDAO;
import java.util.List;


/**
 * @author Gustavo L. Alves
 * @version 1.0 05/11/2013
 */


public class MedidaDaoJPA extends DAOJPA <Medida, Integer>implements MedidaDAO {
    
    public List<Medida> pesquisarNome(String nome) {
        return getEntityManager().createQuery("select c from Medida c where c.nome like '%" 
                + nome + "%'").getResultList();
    
    
    }

}
