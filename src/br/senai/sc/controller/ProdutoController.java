package br.senai.sc.controller;

import br.senai.sc.model.negocio.Produto;
import br.senai.sc.model.persistencia.ProdutoDaoJDBC;
import br.senai.sc.model.persistencia.dao.ProdutoDAO;
import java.util.List;

public class ProdutoController {

    /**
     * Método responsável por listar todos os dados da tabela produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @return
     */
    public List<Produto> listAll() {
        ProdutoDAO dao = new ProdutoDaoJDBC();
        return dao.listAll();
    }

    /**
     * Método resonsável por inserir dados na tabela produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param cp
     * @return
     */
    public boolean insert(Produto cp) {
        ProdutoDAO dao = new ProdutoDaoJDBC();
        return dao.insert(cp);
    }

    /**
     * Método resonsável por atualizar dados na tabela produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param cp
     * @return
     */
    public boolean update(Produto cp) {
        ProdutoDAO dao = new ProdutoDaoJDBC();
        return dao.update(cp);
    }

    /**
     * Método resonsável por deletar dados na tabela produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param codProduto
     * @return
     */
    public boolean delete(int codProduto) {
        ProdutoDAO dao = new ProdutoDaoJDBC();
        return dao.delete(codProduto);
    }

    /**
     * Método resonsável por listar por ID dados na tabela produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param id
     * @return
     */
    public Produto listById(int idProduto) {
        ProdutoDAO dao = new ProdutoDaoJDBC();
        return dao.listById(idProduto);
    }

    /**
     * Método resonsável por pesquisar dados na tabela produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param text
     * @return
     */
    public List<Produto> search(String texto) {
        ProdutoDAO dao = new ProdutoDaoJDBC();
        return dao.search(texto);
    }
}