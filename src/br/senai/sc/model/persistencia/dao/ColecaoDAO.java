package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Colecao;
import java.util.List;

/**
 *
 * @author Gabriel Arsênio
 * @version 1.0 01/10/2013
 */
public interface ColecaoDAO extends DAO<Colecao, Integer> {

    List<Colecao> listEstacao(String estacao);

    List<Colecao> pesquisarEstacao(String estacao);

    List<Colecao> pesquisarAno(int ano);
}
