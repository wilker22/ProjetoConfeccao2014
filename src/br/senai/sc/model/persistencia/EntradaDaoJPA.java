package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Entrada;
import br.senai.sc.model.persistencia.dao.EntradaDAO;
import java.util.List;

/**
 *
 * @author patricia_gageiro
 */
public class EntradaDaoJPA extends DAOJPA<Entrada, Integer> implements EntradaDAO {

    @Override
    public List<Entrada> pesquisaNome(String nome) {

        return getEntityManager().createQuery("select c from Entrada c where c.nome like '%" + nome + "%'").getResultList();
    }
}