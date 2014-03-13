package br.senai.sc.controller;

import br.senai.sc.model.negocio.Funcionario;
import br.senai.sc.model.negocio.MateriaPrima;
import br.senai.sc.model.persistencia.FuncionariodaoJDBC;
import br.senai.sc.model.persistencia.MateriaPrimaDaoJDBC;
import br.senai.sc.model.persistencia.dao.FuncionarioDAO;
import br.senai.sc.model.persistencia.dao.MateriaPrimaDAO;

import java.util.List;

/**
 *
 * @author Letícia de Jesus Ribeiro
 * @version 1.0 09/10/2013
 */
public class MateriaPrimaController {

    /**
     * Método que serve para realizar a ligação entre o método inserir
     * matéria-prima da base de dados e a interface gráfica.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 05/11/2013
     * @version 1.0
     * @param mp
     * @return
     *
     */
    public int inserir(MateriaPrima mp) {
        MateriaPrimaDAO dao = new MateriaPrimaDaoJDBC();
        return dao.insert(mp);
    }

    /**
     * Método que serve para realizar a ligação entre o método listar dados de
     * uma matéria-prima da base de dados e a interface gráfica.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 05/11/2013
     * @version 1.0
     * @param
     * @return
     *
     */
    public List<MateriaPrima> listAll() {
        MateriaPrimaDAO dao = new MateriaPrimaDaoJDBC();
        return dao.listAll();
    }

    /**
     * Método que serve para realizar a ligação entre o método deletar dados de
     * uma matéria-prima da base de dados e a interface gráfica.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 05/11/2013
     * @version 1.0
     * @param CodMateriaPrima
     * @return
     *
     */
    public boolean delete(int CodMateriaPrima) {
        MateriaPrimaDAO dao = new MateriaPrimaDaoJDBC();
        return dao.delete(CodMateriaPrima);
    }

    /**
     * Método que serve para realizar a ligação entre o método atualizar dados
     * de uma matéria-prima da base de dados e a interface gráfica.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 05/11/2013
     * @version 1.0
     * @param mp
     * @return
     *
     */
    public int update(MateriaPrima mp) {
        MateriaPrimaDAO dao = new MateriaPrimaDaoJDBC();
        return dao.update(mp);
    }

    /**
     * Método que serve para realizar a ligação entre o método listar dados de
     * uma matéria-prima da base de dados e a interface gráfica.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 05/11/2013
     * @version 1.0
     * @param codMateriaPrima
     * @return
     *
     */
    public MateriaPrima listById(int codMateriaPrima) {
        MateriaPrimaDAO dao = new MateriaPrimaDaoJDBC();
        return dao.listById(codMateriaPrima);
    }

    /**
     * Método que serve para realizar a ligação entre o método de pesquisa de
     * dados de uma matéria-prima da base de dados e a interface gráfica.
     *
     * @author Letícia de Jesus Ribeiro
     * @since 05/11/2013
     * @version 1.0
     * @param
     * @return
     *
     */
    public List<MateriaPrima> pesquisar(String texto) {
        MateriaPrimaDAO dao = new MateriaPrimaDaoJDBC();
        return dao.listPesquisa(texto);
    }
}
