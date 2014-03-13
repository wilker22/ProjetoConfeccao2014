package br.senai.sc.controller;

//------------------------------------------------------------------------------
import br.senai.sc.model.negocio.Assistencia;
import br.senai.sc.model.persistencia.AssistenciaDaoJDBC;
import br.senai.sc.model.persistencia.dao.AssistenciaDAO;
import java.util.List;

//------------------------------------------------------------------------------
/**
 * Classe responsável por representar a ligação dos métodos na base de dados e a
 * interface gráfica
 *
 * @author Wesley Batista
 * @since 1.0 06/11/2013
 */
public class AssistenciaController {

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a ligação entre o método listar na base de
     * dados e a interface gráfica
     *
     * @author Wesley Batista
     * @since 1.0 06/11/2013
     * @return
     */
    public List<Assistencia> listAll() {
        AssistenciaDAO dao = new AssistenciaDaoJDBC();
        return dao.listAll();
    }

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a ligação entre o método inserir na base
     * de dados e a interface gráfica
     *
     * @author Wesley Batista
     * @since 1.0 06/11/2013
     * @param a
     * @return
     */
    public int inserir(Assistencia a) {
        AssistenciaDAO dao = new AssistenciaDaoJDBC();
        return dao.insert(a);
    }

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a ligação entre o método deletar na base
     * de dados e a interface gráfica
     *
     * @author Wesley Batista
     * @since 1.0 06/11/2013
     * @param id
     * @return
     */
    public boolean delete(int id) {
        AssistenciaDAO dao = new AssistenciaDaoJDBC();
        return dao.delete(id);
    }

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a ligação entre o método atualizar na base
     * de dados e a interface gráfica
     *
     * @author Wesley Batista
     * @since 1.0 06/11/2013
     * @param a
     * @return
     */
    public int update(Assistencia t) {
        AssistenciaDAO dao = new AssistenciaDaoJDBC();
        return dao.update(t);
    }

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a ligação entre o método listar por um id
     * na base de dados e a interface gráfica
     *
     * @author Wesley Batista
     * @since 1.0 06/11/2013
     * @param id
     * @return
     */
    public Assistencia listById(int id) {
        AssistenciaDAO dao = new AssistenciaDaoJDBC();
        return dao.listById(id);
    }

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a ligação entre o método listar por um
     * texto na base de dados e a interface gráfica
     *
     * @author Wesley Batista
     * @since 1.0 06/11/2013
     * @param texto
     * @return
     */
    public List<Assistencia> pesquisar(String texto) {
        AssistenciaDAO dao = new AssistenciaDaoJDBC();
        return dao.listPesquisa(texto);
    }
}