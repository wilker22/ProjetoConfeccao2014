package br.senai.sc.controller;

//------------------------------------------------------------------------------
import br.senai.sc.model.negocio.Transportadora;
import br.senai.sc.model.persistencia.TransportadoraDaoJDBC;
import br.senai.sc.model.persistencia.dao.TransportadoraDAO;
import java.util.List;

//------------------------------------------------------------------------------
/**
 * Classe responsável por representar a ligação dos métodos na base de dados e
 * interface gráfica
 *
 * @author Wesley Batista
 * @since 1.0 05/11/2013
 */
public class TransportadoraController {

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a ligação entre o método listar na base de
     * dados e a interface gráfica
     *
     * @author Wesley Batista
     * @since 1.0 05/11/2013
     * @return
     */
    public List<Transportadora> listAll() {
        TransportadoraDAO dao = new TransportadoraDaoJDBC();
        return dao.listAll();
    }

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a ligação entre o método inserir na base
     * de dados e a interface gráfica
     *
     * @author Wesley Batista
     * @since 1.0 05/11/2013
     * @param t
     * @return
     */
    public int inserir(Transportadora t) {
        TransportadoraDAO dao = new TransportadoraDaoJDBC();
        return dao.insert(t);
    }

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a ligação entre o método deletar na base
     * de dados e a interface gráfica
     *
     * @author Wesley Batista
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */
    public boolean delete(int id) {
        TransportadoraDAO dao = new TransportadoraDaoJDBC();
        return dao.delete(id);
    }

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a ligação entre o método atualizar na base
     * de dados e a interface gráfica
     *
     * @author Wesley Batista
     * @since 1.0 05/11/2013
     * @param t
     * @return
     */
    public int update(Transportadora t) {
        TransportadoraDAO dao = new TransportadoraDaoJDBC();
        return dao.update(t);
    }

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a ligação entre o método listar por um id
     * na base de dados e a interface gráfica
     *
     * @author Wesley Batista
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */
    public Transportadora listById(int id) {
        TransportadoraDAO dao = new TransportadoraDaoJDBC();
        return dao.listById(id);
    }

    //--------------------------------------------------------------------------
    /**
     * Método que serve para realizar a ligação entre o método listar por um
     * texto na base de dados e a interface gráfica
     *
     * @author Wesley Batista
     * @since 1.0 05/11/2013
     * @param texto
     * @return
     */
    public List<Transportadora> pesquisar(String texto) {
        TransportadoraDAO dao = new TransportadoraDaoJDBC();
        return dao.listPesquisa(texto);
    }
}
