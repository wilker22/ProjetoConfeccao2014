/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Funcionario;
import br.senai.sc.model.persistencia.dao.FuncionarioDAO;
import java.util.List;

/**
 *
 * @author nathan_bettiol
 */
public class FuncionarioDAOJPA extends DAOJPA<Funcionario, Integer> implements FuncionarioDAO {

    @Override
    public List<Funcionario> pesquisarNome(String nome) {
        return getEntityManager().createQuery("select f from Funcionario f where f.nome like '%" + nome + "%'").getResultList();
    }
}
