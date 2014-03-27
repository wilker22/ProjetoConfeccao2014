/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.TipoFisico;
import br.senai.sc.model.persistencia.dao.TipoFisicoDAO;
import java.util.List;

/**
 * @author Gustavo L. Alves
 * @version 1.0 05/11/2013
 */
public class TipoFisicoDaoJPA extends DAOJPA<TipoFisico, Integer> implements TipoFisicoDAO {

    @Override
    public List<TipoFisico> pesquisaNome(String nome) {

        return getEntityManager().createQuery("select c from TipoFisico c where c.nome like '%" + nome + "%'").getResultList();
    }
}