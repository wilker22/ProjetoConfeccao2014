package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Produto;
import java.util.List;

public interface ProdutoDAO extends DAO<Produto, Integer> {
    List<Produto> listarNome(String nome);
}
//    /**
//     * Método responsável pela inserção de um Produto
//     *
//     * @author Gustavo Motta Agustinho
//     * @version 1.0 11/09/2013
//     * @param p
//     * @return
//     */
//    boolean insert(Produto p);
//
//    /**
//     * Método responsável pela atualização de um Produto
//     *
//     * @author Gustavo Motta Agustinho
//     * @version 1.0 11/09/2013
//     * @param p
//     * @return
//     */
//    boolean update(Produto p);
//
//    /**
//     * Método responsável pela remoção de um Produto
//     *
//     * @author Gustavo Motta Agustinho
//     * @version 1.0 11/09/2013
//     * @param codProduto
//     * @return
//     */
//    boolean delete(int codProduto);
//
//    /**
//     * Método responsável pela listagem de todos os Produtos
//     *
//     * @author Gustavo Motta Agustinho
//     * @version 1.0 11/09/2013
//     * @return
//     */
//    List<Produto> listAll();
//
//    /**
//     * Método responsável pela listagem de um Produto por ID.
//     *
//     * @author Gustavo Motta Agustinho
//     * @version 1.0 11/09/2013
//     * @param codProduto
//     * @return
//     */
//    Produto listById(int codProduto);
//
//    /**
//     * Método responsável pela pesquisa.
//     *
//     * @author Gustavo Motta Agustinho
//     * @version 1.0 04/11/2013
//     * @param texto
//     * @return
//     */
//    List<Produto> search(String texto);
//}
