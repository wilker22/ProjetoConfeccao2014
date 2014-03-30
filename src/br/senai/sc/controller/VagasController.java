package br.senai.sc.controller;

import br.senai.sc.model.negocio.Vagas;
import br.senai.sc.model.persistencia.VagasDaoJDBC;
import br.senai.sc.model.persistencia.dao.VagasDAO;
import java.util.List;

/**
 * Métodos responsavél por fazer ligação entre um método inserir da base de
 * dados e a interface gráfica.
 *
 * @author Bruna Zakrzeski
 * @since 1.0 05/11/2013
 * @param vaga
 * @return
 */
public class VagasController {

    /**
     * Método que lista todas as vagas
     *
     * @author Bruna Zakrzeski
     * @since 1.0 05/11/2013
     * @param vaga
     * @return
     */
    public List<Vagas> ListAll() {

        VagasDAO dao = new VagasDaoJDBC();
        return dao.getAll(Vagas.class);
    }

    /**
     * Método que inseri vagas
     *
     * @author Bruna Zakrzeski
     * @since 1.0 05/11/2013
     * @param vaga
     * @return
     */
    public Vagas inserir(Vagas vag) {

        VagasDAO dao = new VagasDaoJDBC();
        return dao.save(vag);
    }

    /**
     * Método que remove vagas
     *
     * @author Bruna Zakrzeski
     * @since 1.0 05/11/2013
     * @param vaga
     * @return
     */
    public boolean delete(int codVaga) {

        VagasDAO dao = new VagasDaoJDBC();
        return dao.remove(Vagas.class, codVaga);
    }

    /**
     * Método que pesquisa vagas
     *
     * @author Bruna Zakrzeski
     * @since 1.0 05/11/2013
     * @param vaga
     * @return
     */
    public List<Vagas> pesquisar(String texto) {

        VagasDAO dao = new VagasDaoJDBC();
        return dao.listPesquisa(texto);
    }

    /**
     * Método que lista vagas por id
     *
     * @author Bruna Zakrzeski
     * @since 1.0 05/11/2013
     * @param vaga
     * @return
     */
    public Vagas listById(int id) {

        VagasDAO dao = new VagasDaoJDBC();
        return dao.getById(Vagas.class, id);
    }
}
