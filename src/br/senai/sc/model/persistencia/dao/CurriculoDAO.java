/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Curriculo;
import java.util.List;


/**
 *
 * @author evaldo_matias
 */
public interface CurriculoDAO {

    int insert(Curriculo f);

    List<Curriculo> listAll();

    List<Curriculo> Pesquisa(String texto);

    boolean remove(int id);

    int update(Curriculo f);

    Curriculo listById(int id);
}
