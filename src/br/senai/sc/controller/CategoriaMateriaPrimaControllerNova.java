package br.senai.sc.controller;

import br.senai.sc.model.negocio.CategoriaMateriaPrima;
import br.senai.sc.model.persistencia.CategoriaMateriaPrimaDaoJDBC;
import br.senai.sc.model.persistencia.dao.CategoriaMateriaPrimaDAO;
import java.util.List;

public class CategoriaMateriaPrimaControllerNova {

    /**
     * Método que serve para realizar a ligação entre o método inserir da base
     * de dados e a interface gráfica.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 05/11/2013
     * @version 1.0
     * @param cmp
     * @return
     *
     */
    public int inserir(CategoriaMateriaPrima cmp) {
        CategoriaMateriaPrimaDAO dao = new CategoriaMateriaPrimaDaoJDBC();
        return dao.insert(cmp);

    }

    /**
     * Método que serve para realizar a ligação entre o método listar da base de
     * dados e a interface gráfica.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 05/11/2013
     * @version 1.0
     * @param
     * @return
     *
     */
    public List<CategoriaMateriaPrima> listAll() {
        CategoriaMateriaPrimaDAO dao = new CategoriaMateriaPrimaDaoJDBC();
        return dao.listAll();
    }

    /**
     * Método que serve para realizar a ligação entre o método delete da base de
     * dados e a interface gráfica.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 05/11/2013
     * @version 1.0
     * @param IdCategoriaMateriaPrima
     * @return
     *
     */
    public boolean delete(int IdCategoriaMateriaPrima) {
        CategoriaMateriaPrimaDAO dao = new CategoriaMateriaPrimaDaoJDBC();
        return dao.delete(IdCategoriaMateriaPrima);
    }

    /**
     * Método que serve para realizar a ligação entre o método atualizar dados
     * de categorias de matéria-prima da base de dados e a interface gráfica.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 05/11/2013
     * @version 1.0
     * @param cmp
     * @return
     *
     */
    public int update(CategoriaMateriaPrima cmp) {
        CategoriaMateriaPrimaDAO dao = new CategoriaMateriaPrimaDaoJDBC();
        return dao.update(cmp);
    }

    /**
     * Método que serve para realizar a ligação entre o método listar por id
     * dados de categorias de matéria-prima da base de dados e a interface
     * gráfica.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 05/11/2013
     * @version 1.0
     * @param IdCategoriaMateriaPrima
     * @return
     *
     */
    public CategoriaMateriaPrima listById(int IdCategoriaMateriaPrima) {
        CategoriaMateriaPrimaDAO dao = new CategoriaMateriaPrimaDaoJDBC();
        return dao.listById(IdCategoriaMateriaPrima);
    }

    /**
     * Método que serve para realizar a ligação entre o método de pesquisa de
     * dados de categorias de matéria-prima da base de dados e a interface
     * gráfica.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 05/11/2013
     * @version 1.0
     * @param
     * @return
     *
     */
    public List<CategoriaMateriaPrima> pesquisar(String texto) {
        CategoriaMateriaPrimaDAO dao = new CategoriaMateriaPrimaDaoJDBC();
        return dao.listPesquisa(texto);
    }
}
