package br.senai.sc.controller;

import br.senai.sc.model.negocio.MateriaPrima;

import br.senai.sc.model.persistencia.MateriaPrimaDAOJPA;

import br.senai.sc.model.persistencia.dao.MateriaPrimaDAO;

import java.util.List;

/**
 *
 * @author Letícia de Jesus Ribeiro
 * @version 1.0 09/10/2013
 */
public class MateriaPrimaController {

    public MateriaPrima salvar(MateriaPrima materiaprima) {
        MateriaPrimaDAO dao = new MateriaPrimaDAOJPA();
        return dao.save(materiaprima);

    }

    public boolean excluir(int codigo) {
        MateriaPrimaDAO dao = new MateriaPrimaDAOJPA();
        return dao.remove(MateriaPrima.class, codigo);
    }

    public List<MateriaPrima> ListarMateriaPrima() {
        MateriaPrimaDAO dao = new MateriaPrimaDAOJPA();
        return dao.getAll(MateriaPrima.class);

    }

    public MateriaPrima listarMateriaPrimaById(int codigo) {
        MateriaPrimaDAO dao = new MateriaPrimaDAOJPA();
        return dao.getById(MateriaPrima.class, codigo);
    }

    public List<MateriaPrima> pesquisarNome(String nome) {
        MateriaPrimaDAO dao = new MateriaPrimaDAOJPA();
        return dao.pesquisarNome(nome);

    }
    
}
//    /**
//     * Método que serve para realizar a ligação entre o método inserir
//     * matéria-prima da base de dados e a interface gráfica.
//     *
//     * @author Letícia de Jesus Ribeiro
//     * @since 05/11/2013
//     * @version 1.0
//     * @param mp
//     * @return
//     *
//     */
//    public int inserir(MateriaPrima mp) {
//        MateriaPrimaDAO dao = new MateriaPrimaDaoJPA();
//        return dao.insert(mp);
//    }
//
//    /**
//     * Método que serve para realizar a ligação entre o método listar dados de
//     * uma matéria-prima da base de dados e a interface gráfica.
//     *
//     * @author Letícia de Jesus Ribeiro
//     * @since 05/11/2013
//     * @version 1.0
//     * @param
//     * @return
//     *
//     */
//    public List<MateriaPrima> listAll() {
//        MateriaPrimaDAO dao = new MateriaPrimaDaoJPA();
//        return dao.listAll();
//    }
//
//    /**
//     * Método que serve para realizar a ligação entre o método deletar dados de
//     * uma matéria-prima da base de dados e a interface gráfica.
//     *
//     * @author Letícia de Jesus Ribeiro
//     * @since 05/11/2013
//     * @version 1.0
//     * @param CodMateriaPrima
//     * @return
//     *
//     */
//    public boolean delete(int CodMateriaPrima) {
//        MateriaPrimaDAO dao = new MateriaPrimaDaoJPA();
//        return dao.delete(CodMateriaPrima);
//    }
//
//    /**
//     * Método que serve para realizar a ligação entre o método atualizar dados
//     * de uma matéria-prima da base de dados e a interface gráfica.
//     *
//     * @author Letícia de Jesus Ribeiro
//     * @since 05/11/2013
//     * @version 1.0
//     * @param mp
//     * @return
//     *
//     */
//    public int update(MateriaPrima mp) {
//        MateriaPrimaDAO dao = new MateriaPrimaDaoJPA();
//        return dao.update(mp);
//    }
//
//    /**
//     * Método que serve para realizar a ligação entre o método listar dados de
//     * uma matéria-prima da base de dados e a interface gráfica.
//     *
//     * @author Letícia de Jesus Ribeiro
//     * @since 05/11/2013
//     * @version 1.0
//     * @param codMateriaPrima
//     * @return
//     *
//     */
//    public MateriaPrima listById(int codMateriaPrima) {
//        MateriaPrimaDAO dao = new MateriaPrimaDaoJPA();
//        return dao.listById(codMateriaPrima);
//    }
//
//    /**