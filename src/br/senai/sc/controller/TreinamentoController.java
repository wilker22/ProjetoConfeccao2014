
package br.senai.sc.controller;
import br.senai.sc.model.negocio.Treinamento;
import br.senai.sc.model.persistencia.TreinamentoDaoJDBC;
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
    
    
        
     /**
     * Método que lista todos os treinamentos
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */
    
    public List<Treinamento> ListAll(){
        
    TreinamentoDAO dao = new TreinamentoDaoJDBC();
    return dao.listAll();
    }
    
    
    
     /**
     * Método que inseri treinamento
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */
    
    public boolean inserir (Treinamento treina){
        
    TreinamentoDAO dao = new TreinamentoDaoJDBC();
    return dao.insert(treina);
    }
    
    
    
     /**
     * Método que altera treinamento
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */
    public boolean update (Treinamento treina){
        
    TreinamentoDAO dao = new TreinamentoDaoJDBC();
    return dao.update(treina);
    }
    
    
    
    /**
     * Método que remove treinamento
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */
    
    public boolean delete (int idTreinamento){
    
    TreinamentoDAO dao = new TreinamentoDaoJDBC();
    return dao.delete(idTreinamento);
    }
    
    
        

    /**
     * Método que pesquisa treinamento
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */
    
    public List<Treinamento> pesquisar (String texto){
        
        TreinamentoDAO dao = new TreinamentoDaoJDBC();
        return dao.listPesquisa(texto);
}
    
    /**
     * Método que lista treinamento por id
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */
    
    public Treinamento listById(int id){
        
        TreinamentoDAO dao = new TreinamentoDaoJDBC();
        return dao.listById(id);
    }
 

}