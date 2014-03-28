package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Transportadora;
import br.senai.sc.model.persistencia.dao.TransportadoraDAO;
import java.util.List;

/**
 *
 * @author gustavo_cm
 */
public class TransportadoraDAOJPA extends DAOJPA<Transportadora, Integer> implements TransportadoraDAO {

    public List<Transportadora> pesquisaNome(String nome) {
        return getEntityManager().createQuery("select c from Cliente c where c.nome like '%"
                + nome + "%'").getResultList();

    }
}
