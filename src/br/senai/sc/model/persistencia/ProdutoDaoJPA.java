/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Produto;
import br.senai.sc.model.persistencia.dao.ProdutoDAO;
import java.util.List;

/**
 *
 * @author elivelton_sipriano
 */
public class ProdutoDaoJPA extends DAOJPA<Produto, Integer> implements ProdutoDAO {

    @Override
    public List<Produto> listarNome(String nome) {
        return getEntityManager().createQuery(
                "SELECT p from Produto p where p.nome like '%" + nome + "%'")
                .getResultList();
    }
}
