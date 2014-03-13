package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.CategoriaProduto;
import java.util.List;

public interface CategoriaProdutoDAO {

    /**
     * Método responsável pela inserção de uma categoria de produto.
     *
     * @author Gustavo Motta
     * @version 1.0 16/09/2013
     * @param CP
     * @return
     */
    boolean insert(CategoriaProduto CP);

    /**
     * Método responsável pela atualização de uma categoria de produto.
     *
     * @author Gustavo Motta
     * @version 1.0 16/09/2013
     * @param CP
     * @return
     */
    boolean update(CategoriaProduto CP);

    /**
     * Método responsável pela remoção de uma categoria de produto.
     *
     * @author Gustavo Motta
     * @version 1.0 16/09/2013
     * @param codCategoriaProduto
     * @return
     */
    boolean delete(int codCategoriaProduto);

    /**
     * Método responsável pela listagem de todas as categoria de produto.
     *
     * @author Gustavo Motta
     * @version 1.0 16/09/2013
     * @return
     */
    List<CategoriaProduto> listAll();

    /**
     * Método responsável pela listagem de categoria de produto.
     *
     * @author Gustavo Motta
     * @version 1.0 16/09/2013
     * @param codCategoriaProduto
     * @return
     */
    CategoriaProduto listById(int codCategoriaProduto);

    /**
     * Método responsável pela busca de categoria de produtos.
     *
     * @author Gustavo Motta
     * @version 1.0 30/10/2013
     * @param text
     * @return
     */
    List<CategoriaProduto> search(String text);
}