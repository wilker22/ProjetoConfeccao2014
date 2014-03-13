package br.senai.sc.controller;

import br.senai.sc.model.negocio.Funcionario;
import br.senai.sc.model.persistencia.FuncionariodaoJDBC;
import br.senai.sc.model.persistencia.dao.FuncionarioDAO;

import java.util.List;

/**
 *
 * @author patricia_gageiro
 * @version 1.0 09/10/2013
 */
public class FuncionarioController {

    /**
     * Método que serve para realizar a ligação do método listAll da base de dados com a interface gráfica.
     * @author Patricia Gageiro
     * @since 1.0 05/11/2013
     * @param f
     * @return
     */
    public List<Funcionario> listAll() {
        FuncionarioDAO dao = new FuncionariodaoJDBC();
        return dao.listAll();
    }
    /**
     * Método que serve para realizar a ligação do método inserir da base de dados com a interface gráfica.
     * @author Patricia Gageiro
     * @since 1.0 05/11/2013
     * @param fun
     * @return
     */

    public int inserir(Funcionario fun) {
        FuncionarioDAO dao = new FuncionariodaoJDBC();
        return dao.insert(fun);
    }
    /**
     * Método que serve para realizar a ligação do método deletar da base de dados com a interface gráfica.
     * @author Patricia Gageiro
     * @since 1.0 05/11/2013
     * @param fun
     * @return
     */

    public boolean delete(Funcionario fun) {
        FuncionarioDAO dao = new FuncionariodaoJDBC();
        return dao.delete(fun);
    }
    /**
     * Método que serve para realizar a ligação do método pesquisar da base de dados com a interface gráfica.
     * @author Patricia Gageiro
     * @since 1.0 05/11/2013
     * @param texto
     * @return
     */

    public List<Funcionario> pesquisar(String texto) {
        FuncionarioDAO dao = new FuncionariodaoJDBC();
        return dao.ListPesquisa(texto);
    }
    /**
     * Método que serve para realizar a ligação do método atualizar da base de dados com a interface gráfica.
     * @author Patricia Gageiro
     * @since 1.0 05/11/2013
     * @param fun
     * @return
     */

    public boolean update(Funcionario fun) {
        FuncionarioDAO dao = new FuncionariodaoJDBC();
        return dao.update(fun);
    }
    /**
     * Método que serve para realizar a ligação do método listagem por id da base de dados com a interface gráfica.
     * @author Patricia Gageiro
     * @since 1.0 05/11/2013
     * @param idFuncionario
     * @return
     */

    public Funcionario listById(int idFuncionario) {
        FuncionarioDAO dao = new FuncionariodaoJDBC();
        return dao.listById(idFuncionario);
    }
}
