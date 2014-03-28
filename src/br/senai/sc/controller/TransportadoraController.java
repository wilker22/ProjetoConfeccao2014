package br.senai.sc.controller;

import br.senai.sc.model.negocio.Transportadora;
import br.senai.sc.model.persistencia.TransportadoraDAOJPA;
import br.senai.sc.model.persistencia.dao.TransportadoraDAO;
import java.util.List;

//package br.senai.sc.controller;
//
////------------------------------------------------------------------------------
//import br.senai.sc.model.negocio.Transportadora;
//import br.senai.sc.model.persistencia.TransportadoraDaoJPA;
//import br.senai.sc.model.persistencia.dao.TransportadoraDAO;
//import java.util.List;
//
////------------------------------------------------------------------------------
///**
// * Classe responsável por representar a ligação dos métodos na base de dados e
// * interface gráfica
// *
// * @author Wesley Batista
// * @since 1.0 05/11/2013
// */
//public class TransportadoraController {
//
//    //--------------------------------------------------------------------------
//    /**
//     * Método que serve para realizar a ligação entre o método listar na base de
//     * dados e a interface gráfica
//     *
//     * @author Wesley Batista
//     * @since 1.0 05/11/2013
//     * @return
//     */
//    public List<Transportadora> listAll() {
//        TransportadoraDAO dao = new TransportadoraDaoJPA();
//        return dao.listAll();
//    }
//
//    //--------------------------------------------------------------------------
//    /**
//     * Método que serve para realizar a ligação entre o método inserir na base
//     * de dados e a interface gráfica
//     *
//     * @author Wesley Batista
//     * @since 1.0 05/11/2013
//     * @param t
//     * @return
//     */
//    public int inserir(Transportadora t) {
//        TransportadoraDAO dao = new TransportadoraDaoJPA();
//        return dao.insert(t);
//    }
//
//    //--------------------------------------------------------------------------
//    /**
//     * Método que serve para realizar a ligação entre o método deletar na base
//     * de dados e a interface gráfica
//     *
//     * @author Wesley Batista
//     * @since 1.0 05/11/2013
//     * @param id
//     * @return
//     */
//    public boolean delete(int id) {
//        TransportadoraDAO dao = new TransportadoraDaoJPA();
//        return dao.delete(id);
//    }
//
//    //--------------------------------------------------------------------------
//    /**
//     * Método que serve para realizar a ligação entre o método atualizar na base
//     * de dados e a interface gráfica
//     *
//     * @author Wesley Batista
//     * @since 1.0 05/11/2013
//     * @param t
//     * @return
//     */
//    public int update(Transportadora t) {
//        TransportadoraDAO dao = new TransportadoraDaoJPA();
//        return dao.update(t);
//    }
//
//    //--------------------------------------------------------------------------
//    /**
//     * Método que serve para realizar a ligação entre o método listar por um id
//     * na base de dados e a interface gráfica
//     *
//     * @author Wesley Batista
//     * @since 1.0 05/11/2013
//     * @param id
//     * @return
//     */
//    public Transportadora listById(int id) {
//        TransportadoraDAO dao = new TransportadoraDaoJPA();
//        return dao.listById(id);
//    }
//
//    //--------------------------------------------------------------------------
//    /**
//     * Método que serve para realizar a ligação entre o método listar por um
//     * texto na base de dados e a interface gráfica
//     *
//     * @author Wesley Batista
//     * @since 1.0 05/11/2013
//     * @param texto
//     * @return
//     */
//    public List<Transportadora> pesquisar(String texto) {
//        TransportadoraDAO dao = new TransportadoraDaoJPA();
//        return dao.listPesquisa(texto);
//    }
//}
public class TransportadoraController {

    public Transportadora salvar(Transportadora cliente) {
        TransportadoraDAO dao = new TransportadoraDAOJPA();
        return dao.save(cliente);
    }

    public boolean delete(int codigo) {
        TransportadoraDAO dao = new TransportadoraDAOJPA();
        return dao.remove(Transportadora.class, codigo);

    }

    public List<Transportadora> listAll() {
        TransportadoraDAO dao = new TransportadoraDAOJPA();
        return dao.getAll(Transportadora.class);
    }

    public Transportadora listById(int codigo) {
        TransportadoraDAO dao = new TransportadoraDAOJPA();
        return dao.getById(Transportadora.class, codigo);

    }

    public List<Transportadora> pesquisar(String nome) {
        TransportadoraDAO dao = new TransportadoraDAOJPA();
        return dao.pesquisaNome(nome);
    }
}