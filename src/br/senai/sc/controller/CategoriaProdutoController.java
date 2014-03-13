package br.senai.sc.controller;

import br.senai.sc.model.negocio.CategoriaProduto;
import br.senai.sc.model.persistencia.CategoriaProdutoDaoJDBC;
import br.senai.sc.model.persistencia.dao.CategoriaProdutoDAO;
import java.util.List;

public class CategoriaProdutoController {

    /**
     * Método responsável por listar dados da tabela categoria_produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @return
     */
    public List<CategoriaProduto> listAll() {
        CategoriaProdutoDAO dao = new CategoriaProdutoDaoJDBC();
        return dao.listAll();
    }

    /**
     * Método resonsável por inserir dados na tabela categoria_produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param cp
     * @return
     */
    public boolean insert(CategoriaProduto cp) {
        CategoriaProdutoDAO dao = new CategoriaProdutoDaoJDBC();
        return dao.insert(cp);
    }

    /**
     * Método resonsável por atualizar dados na tabela categoria_produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param cp
     * @return
     */
    public boolean update(CategoriaProduto cp) {
        CategoriaProdutoDAO dao = new CategoriaProdutoDaoJDBC();
        return dao.update(cp);
    }

    /**
     * Método resonsável por deletar dados na tabela categoria_produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param codCategoriaProduto
     * @return
     */
    public boolean delete(int codCategoriaProduto) {
        CategoriaProdutoDAO dao = new CategoriaProdutoDaoJDBC();
        return dao.delete(codCategoriaProduto);
    }

    /**
     * Método resonsável por listar por ID dados na tabela categoria_produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param id
     * @return
     */
    public CategoriaProduto listById(int id) {
        CategoriaProdutoDAO dao = new CategoriaProdutoDaoJDBC();
        return dao.listById(id);
    }

    /**
     * Método resonsável por pesquisar dados na tabela categoria_produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param text
     * @return
     */
    public List<CategoriaProduto> search(String text) {
        CategoriaProdutoDAO dao = new CategoriaProdutoDaoJDBC();
        return dao.search(text);
    }
}
