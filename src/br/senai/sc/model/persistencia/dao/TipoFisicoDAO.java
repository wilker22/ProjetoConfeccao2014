/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.TipoFisico;
import java.util.List;

/**
 * @author Gustavo L. Alves
 * @version 1.0 05/11/2013
 *
 */
public interface TipoFisicoDAO extends DAO<TipoFisico, Integer> {

    public List<TipoFisico> pesquisaNome(String nome);
}
