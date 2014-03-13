package br.senai.sc.controller;

import br.senai.sc.model.negocio.Funcionario;
import br.senai.sc.model.negocio.Sobra;
import br.senai.sc.model.persistencia.FuncionariodaoJDBC;
import br.senai.sc.model.persistencia.SobradaoJDBC;
import br.senai.sc.model.persistencia.dao.FuncionarioDAO;
import br.senai.sc.model.persistencia.dao.SobraDAO;
import java.util.List;

/**
 *
 * @author patricia_gageiro
 */
public class SobraController {

    /**
     * Método que serve para realizar a ligação do método listAll da base de
     * dados com a interface gráfica.
     *
     * @author Patricia Gageiro
     * @since 1.0 06/11/2013
     * @param s
     * @return
     */
    public List<Sobra> listAll() {
        SobraDAO dao = new SobradaoJDBC();
        return dao.ListAll();
    }

    /**
     * Método que serve para realizar a ligação do método listagem por id da
     * base de dados com a interface gráfica.
     *
     * @author Patricia Gageiro
     * @since 1.0 06/11/2013
     * @param idFuncionario
     * @return
     */
    public Sobra listById(int idSobra) {
        SobraDAO dao = new SobradaoJDBC();
        return dao.listById(idSobra);
    }
    
     /**
     * Método que serve para realizar a ligação do método atualizar da base de dados com a interface gráfica.
     * @author Patricia Gageiro
     * @since 1.0 06/11/2013
     * @param fun
     * @return
     */

    public boolean update(Sobra sob) {
       SobraDAO dao = new SobradaoJDBC();
        return dao.update(sob);
    }
    
    /**
     * Método que serve para realizar a ligação do método inserir da base de dados com a interface gráfica.
     * @author Patricia Gageiro
     * @since 1.0 06/11/2013
     * @param fun
     * @return
     */

    public int inserir(Sobra sob) {
        SobraDAO dao = new SobradaoJDBC();
        return dao.insert(sob);
    }
    
    /**
     * Método que serve para realizar a ligação do método pesquisar da base de dados com a interface gráfica.
     * @author Patricia Gageiro
     * @since 1.0 06/11/2013
     * @param texto
     * @return
     */

    public List<Sobra> pesquisar(String texto) {
        SobraDAO dao = new SobradaoJDBC();
        return dao.ListPesquisa(texto);
    }
    
    /**
     * Método que serve para realizar a ligação do método deletar da base de dados com a interface gráfica.
     * @author Patricia Gageiro
     * @since 1.0 05/11/2013
     * @param fun
     * @return
     */

    public boolean delete(Sobra sob) {
        SobraDAO dao = new SobradaoJDBC();
        return dao.delete(sob);
    }
}
