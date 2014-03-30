package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Vagas;
import br.senai.sc.model.persistencia.dao.VagasDAO;
import java.util.List;

/**
 * Classe responsavél por declarar metodos insert, delete, listar por id,
 * update, listar todos, pesquisa. E seus metodos implementados com dados
 * escolhidos que serão executados da classe VagasDaoJDBC na principal.
 *
 * @author Bruna Zakrzeski
 * @since 1.0 05/11/2013
 * @param vaga
 * @return
 */
public class VagasDaoJDBC extends DAOJPA<Vagas, Integer> implements VagasDAO {

    @Override
    public List<Vagas> listPesquisa(String texto) {
        return getEntityManager().createNamedQuery("select v from Vagas v where v.nome like '%" + texto + "%'").getResultList();
    }
}
