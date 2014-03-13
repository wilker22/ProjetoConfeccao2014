package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.TipoMaquinaAssistencia;
import java.sql.SQLException;
import java.util.List;

/**
 * Interface da classe TipoMaquinaAssistenciaDaoJDBC
 *
 * @author Gabriel Arsênio
 * @version 1.0 01/10/2013
 */
public interface TipoMaquinaAssistenciaDAO {

    /**
     * Método para cadastrar um novov tipo de assistência de máquina.
     *
     * @author Gabriel Arsênio
     * @version 1.0 01/10/2013
     * @param tma
     * @return
     */
    boolean insert(TipoMaquinaAssistencia tma) throws SQLException;

    /**
     * Método para atualizar um tipo de assisência de máquina.
     *
     * @author Gabriel Arsênio
     * @version 1.0 01/10/2013
     * @param tma
     * @return
     */
    boolean update(TipoMaquinaAssistencia tma) throws SQLException;

    /**
     * Método para deletar um tipo de assistência de máquina.
     *
     * @author Gabriel Arsênio
     * @version 1.0 01/10/2013
     * @param cod
     * @return
     */
    boolean delete(int cod) throws SQLException;

    /**
     * Método para listar todos os tipos de assistência de máquina.
     *
     * @author Gabriel Arsênio
     * @version 1.0 01/10/2013
     * @param tma
     * @return
     */
    List<TipoMaquinaAssistenciaDAO> listAll() throws SQLException;
}
