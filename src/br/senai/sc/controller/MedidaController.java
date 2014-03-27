package br.senai.sc.controller;
import br.senai.sc.model.negocio.Medida;
import br.senai.sc.model.persistencia.MedidaDaoJPA;
import br.senai.sc.model.persistencia.dao.MedidaDAO;
import java.util.List;

/**
 * @author Gustavo L. Alves
 * @version 1.0 05/11/2013
 */
public class MedidaController {



    /**
     * Método que serve para realizar a ligação entre o método salvar da base
     * de dados e a interface gráfica.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param m
     * @return
     */
    
     public Medida salvar(Medida medida) {
        MedidaDAO dao = new MedidaDaoJPA();
        return dao.save(medida);
    }
     
     
     
     

    /**
     * Método que serve para realizar a ligação entre o método delete da base de
     * dados e a interface gráfica.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */
     
         public boolean excluir(int codigo) {
        MedidaDAO dao = new MedidaDaoJPA();
        return dao.remove(Medida.class, codigo);
    }

         
         
         
         


    /**
     * Método que serve para realizar a ligação entre o método listar da base de
     * dados e a interface gráfica.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */
         
         public List<Medida> listarMedida(){
        MedidaDAO dao = new MedidaDaoJPA();
        return dao.getAll(Medida.class);
    }
         
         
         
         
         
     /**
     * Método que serve para realizar a ligação entre o método listId da base de
     * dados e a interface gráfica.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */
         
        public Medida listarMedidaById(int codigo){
        MedidaDAO dao = new MedidaDaoJPA();
        return dao.getById(Medida.class, codigo);
    }    
         
        
        
        
        
        
     /**
     * Método que serve para realizar a ligação entre o método pesquisar da base de
     * dados e a interface gráfica.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     * @param id
     * @return
     */ 
        
        public List<Medida> pesquisarNome(String nome){
        MedidaDAO dao = new MedidaDaoJPA();
        return dao.pesquisarNome(nome);
    }
   
    }

