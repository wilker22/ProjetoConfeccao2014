package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Colecao;
import java.sql.SQLException;
import java.util.List;

/**
 * Interface da classe ColecaoDaoJDBC.
 *
 * @author Gabriel Arsênio
 * @version 1.0 01/10/2013
 */
public interface ColecaoDAO {

    /**
     * Método para cadastrar uma nova coleção.
     *
     * @author Gabriel Arsênio
     * @version 1.0 01/10/2013
     * @param c
     * @return
     */
    int insert(Colecao c);

    /**
     * Método para atualizar coleção.
     *
     * @author Gabriel Arsênio
     * @version 1.0 01/10/2013
     * @param c
     * @return
     */
    int update(Colecao c);

    /**
     * Método para deletar uma coleção.
     *
     * @author Gabriel Arsênio
     * @version 1.0 01/10/2013
     * @param cod
     * @return
     */
    boolean delete(int cod);

    /**
     * Método para listar todas as coleções.
     *
     * @author Gabriel Arsênio
     * @version 1.0 01/10/2013
     * @param c
     * @return
     */
    List<Colecao> listAll();

    Colecao listId(int id);

    List<Colecao> listName(String nome);
}
