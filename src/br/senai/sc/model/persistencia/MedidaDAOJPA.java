package br.senai.sc.model.persistencia;
import br.senai.sc.model.negocio.Medida;
import br.senai.sc.model.persistencia.dao.MedidaDAO;
import java.util.List;

/**
 *
 * @author gustavo_lourenço
 */


public class MedidaDAOJPA extends DAOJPA<Medida, Integer> implements MedidaDAO{

    @Override
    public List<Medida> pesquisarNome(String nome) {
               return getEntityManager().createQuery("select c from Medida c where c.nome like '%" 
                + nome + "%'").getResultList();
    
    
    }
        
    }
    

