package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Funcionario;
import br.senai.sc.model.negocio.ProdutosPedidoVenda;
import java.util.List;

/**
 *
 * @author Pati Gageiro
 * @version 1.0 07/10/2013
 */
public interface ProdutosPedidosVendasDAO {

    /*
     * Método responsável pela inserção de um produto pedido venda.
     * @version 1.0 07/10/2013
     * @author Patricia Gageiro
     * @param p
     * @return
     * 
     */
    boolean insert(ProdutosPedidoVenda ppv);

    /*
     * Método responsável pela atualização de um produto pedido venda.
     * @version 1.0 07/10/2013
     * @author Patricia Gageiro
     * @param p
     * @return
     * 
     */
    boolean update(ProdutosPedidoVenda ppv);


    /*
     * Método responsável pela deleção de um produto pedido venda.
     * @version 1.0 07/10/2013
     * @author Patricia Gageiro
     * @param p
     * @return
     */
    boolean delete(ProdutosPedidoVenda ppv);

    /*
     * Método responsável pela listagem dos produto pedido venda.
     * @version 1.0 07/10/2013
     * @author Patricia Gageiro
     * @param p
     * @return
     */
    List<ProdutosPedidoVenda> ListAll();
    
    /*
     * Método responsável pela listagem por id dos produto pedido venda.
     * @version 1.0 07/10/2013
     * @author Patricia Gageiro
     * @param p
     * @return
     */
    Funcionario listById(int id);
}

