package br.senai.sc.model.persistencia.dao;

//------------------------------------------------------------------------------
import br.senai.sc.model.negocio.Assistencia;
import java.util.List;

//------------------------------------------------------------------------------
/**
 * Interface responsável pela declaração dos métodos relacionados ao banco de
 * dados que necessitam serem implantados nas classes relacionadas
 *
 * @author Wesley Batista
 * @since 1.0 06/11/2013
 */
public interface AssistenciaDAO {

    //--------------------------------------------------------------------------
    /**
     * Método responsável pela inserção de uma assistência na base de dados
     *
     * @author Wesley Batista
     * @since 1.0 06/11/13
     * @param a
     * @return
     */
    int insert(Assistencia a);

    //--------------------------------------------------------------------------
    /**
     * Método responsável pela atualização de uma assistência na base de
     * dados
     *
     * @author Wesley Batista
     * @since 1.0 06/11/13
     * @param a
     * @return
     */
    int update(Assistencia a);

    //--------------------------------------------------------------------------
    /**
     * Método responsável pela remoção de uma assistência na base de dados
     *
     * @author Wesley Batista
     * @since 1.0 06/11/13
     * @param cod
     * @return
     */
    boolean delete(int cod);

    //--------------------------------------------------------------------------
    /**
     * Método responsável pela listagem de todas as assistências na base de
     * dados
     *
     * @author Wesley Batista
     * @since 1.0 06/11/13 ,
     * @param
     * @return
     */
    List<Assistencia> listAll();
    
    //--------------------------------------------------------------------------
    /**
     * Método responsável por buscar uma assistência na base de dados através
     * de um id
     *
     * @author Wesley Batista
     * @since 1.0 06/11/13
     * @param cod
     * @return
     */
    Assistencia listById(int cod);
    
    //--------------------------------------------------------------------------
    /**
     * Método responsável por listar uma assistência que o usuário deseja
     * pesquisar
     *
     * @author Wesley Batista
     * @since 1.0 06/11/13
     * @param texto
     * @return
     */
    List<Assistencia> listPesquisa(String texto);
}