package br.senai.sc.model.persistencia.dao;

//------------------------------------------------------------------------------
import br.senai.sc.model.negocio.Transportadora;
import java.util.List;

//------------------------------------------------------------------------------
/**
 * Interface responsável pela declaração dos métodos relacionados ao banco de
 * dados que necessitam serem implantados nas classes relacionadas
 *
 * @author Wesley Batista
 * @since 1.0 05/11/2013
 */
public interface TransportadoraDAO {

    //--------------------------------------------------------------------------
    /**
     * Método responsável pela inserção de uma transportadora na base de dados
     *
     * @author Wesley Batista
     * @since 1.0 09/09/13
     * @param t
     * @return
     */
    int insert(Transportadora t);

    //--------------------------------------------------------------------------
    /**
     * Método responsável pela atualização de uma transportadora na base de
     * dados
     *
     * @author Wesley Batista
     * @since 1.0 09/09/13
     * @param t
     * @return
     */
    int update(Transportadora t);

    //--------------------------------------------------------------------------
    /**
     * Método responsável pela remoção de uma transportadora na base de dados
     *
     * @author Wesley Batista
     * @since 1.0 09/09/13
     * @param cod
     * @return
     */
    boolean delete(int cod);

    //--------------------------------------------------------------------------
    /**
     * Método responsável pela listagem de todas as transportadoras na base de
     * dados
     *
     * @author Wesley Batista
     * @since 1.0 09/09/13 ,
     * @param
     * @return
     */
    List<Transportadora> listAll();

    //--------------------------------------------------------------------------
    /**
     * Método responsável por buscar uma transportadora na base de dados através
     * de um id
     *
     * @author Wesley Batista
     * @since 1.0 09/09/13
     * @param cod
     * @return
     */
    Transportadora listById(int cod);

    //--------------------------------------------------------------------------
    /**
     * Método responsável por listar uma transportadora que o usuário deseja
     * pesquisar
     *
     * @author Wesley Batista
     * @since 1.0 28/10/13
     * @param texto
     * @return
     */
    List<Transportadora> listPesquisa(String texto);
}
