package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Entrada;
import java.util.List;

/**
 * *
 *
 * @author patricia_gageiro
 */
public interface EntradaDAO extends DAO<Entrada, Integer> {

    List<Entrada> pesquisaNome(String nome);
}