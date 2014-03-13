package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.PedidoVenda;
import java.util.List;

/**
 *
 * @author patricia_gageiro
 * @version 1.0 30/09/2013
 */
public interface PedidoVendaDAO {

    /*
     * Método responsável pela inserção de um PedidoVenda.
     * @version 1.0 30/09/2013
     * @param p
     * @return
     */
    boolean insert(PedidoVenda pev);

    /*
     * Método responsável pela atualização de um PedidoVenda
     * @version 1.0 30/09/2013
     * @param p
     * @return
     */
    boolean update(PedidoVenda pev);
    /*
     * Método responsável pela deleçao de um PedidoVenda
     * @version 1.0 30/09/2013
     * @param p
     * @return
     */

    boolean delete(PedidoVenda pv);

    /*
     * Método responsável pela listagem de um PedidoVenda
     * @version 1.0 30/09/2013
     * @param p
     * @return
     */
    List<PedidoVenda> ListAll();
    
    /*
     * Método responsável pela listagem por id de um PedidoVenda
     * @version 1.0 30/09/2013
     * @param p
     * @return
     */
}
