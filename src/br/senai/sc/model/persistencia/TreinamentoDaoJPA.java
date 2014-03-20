
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Treinamento;
import br.senai.sc.model.persistencia.dao.TreinamentoDAO;
import java.util.List;

public class TreinamentoDaoJPA  extends DAOJPA<Treinamento,Integer> implements TreinamentoDAO{
  
    @Override
    public List<Treinamento> pesquisarNome(String nome) {
        return getEntityManager().createQuery("select c from Treinamento c where c.nome like '%" + nome + "%'").getResultList();
    }
}
