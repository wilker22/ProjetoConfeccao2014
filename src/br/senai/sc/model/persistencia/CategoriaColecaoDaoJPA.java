/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.CategoriaColecao;
import br.senai.sc.model.negocio.TipoFisico;
import br.senai.sc.model.persistencia.dao.CategoriaColecaoDAO;
import java.util.List;

/**
 * @version v1.0 30/08/2013
 * @author Gabriel Arsênio
 */
public class CategoriaColecaoDaoJPA extends DAOJPA<CategoriaColecao, Integer> implements CategoriaColecaoDAO {

    public List<CategoriaColecao> pesquisaNome(String nome) {

        return getEntityManager().createQuery("select c from CategoriaColecao c where c.nome like '%" + nome + "%'").getResultList();
    }
}
