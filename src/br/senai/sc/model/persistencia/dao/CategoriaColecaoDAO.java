package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.CategoriaColecao;
import java.util.List;

/**
 * Interface da classe CategoriaColecaoDaoJDBC.
 *
 * @version 1.0 01/10/2013
 * @author Gabriel Arsênio
 */
public interface CategoriaColecaoDAO extends DAO<CategoriaColecao, Integer> {

    public List<CategoriaColecao> pesquisaNome(String nome);
}
