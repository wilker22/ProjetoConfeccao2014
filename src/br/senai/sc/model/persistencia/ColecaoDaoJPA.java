package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Colecao;
import br.senai.sc.model.persistencia.dao.ColecaoDAO;
import java.util.List;

/**
 *
 * @author Gabriel Arsênio
 */
public class ColecaoDaoJPA extends DAOJPA<Colecao, Integer> implements ColecaoDAO {

    @Override
    public List<Colecao> pesquisarEstacao(String estacao) {
        return getEntityManager().createQuery("select c from Colecao c where c.estacaoColecao like '%" + estacao + "%'").getResultList();
    }

    @Override
    public List<Colecao> pesquisarAno(int ano) {
        return getEntityManager().createQuery("select c from Colecao c where c.anoColecao like '%" + ano + "%'").getResultList();
    }

    @Override
    public List<Colecao> listEstacao(String estacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
