
package br.senai.sc.controller;
import br.senai.sc.model.negocio.Treinamento;
import br.senai.sc.model.persistencia.TreinamentoDaoJDBC;
import br.senai.sc.model.persistencia.TreinamentoDaoJPA;
import br.senai.sc.model.persistencia.dao.TreinamentoDAO;
import java.util.List;


    /**
     * Métodos responsavél por fazer ligação entre um método 
     * inserir da base de dados e a interface gráfica.
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */


public class TreinamentoController {
    
    public Treinamento salvar(Treinamento treinamento) {
        TreinamentoDAO dao = new TreinamentoDaoJPA();
        return dao.save(treinamento);
    }

    public boolean excluir(int codigo) {
        TreinamentoDAO dao = new TreinamentoDaoJPA();
        return dao.remove(Treinamento.class, codigo);
    }

    public List<Treinamento> listarTreinamento() {
        TreinamentoDAO dao = new TreinamentoDaoJPA();
        return dao.getAll(Treinamento.class);
    }

    public Treinamento listarTreinamentoById(int codigo) {
        TreinamentoDAO dao = new TreinamentoDaoJPA();
        return dao.getById(Treinamento.class, codigo);
    }
    
    public List<Treinamento> pesquisarNome(String nome){
        TreinamentoDAO dao = new TreinamentoDaoJPA();
        return dao.pesquisarNome(nome);
        
    }
 

}