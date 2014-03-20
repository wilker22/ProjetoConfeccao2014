
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Ferias;
import br.senai.sc.model.persistencia.dao.FeriasDAO;
import java.util.List;

/**
 *
 * @author ariane_souza
 */
public class FeriasDaoJPA extends DAOJPA<Ferias,Integer> implements FeriasDAO{

    @Override
    public List<Ferias> pesquisarNome(String nome) {
        return getEntityManager().createQuery("select c from Ferias c where c.nome like '%" + nome + "%'").getResultList();
    }
    
}
