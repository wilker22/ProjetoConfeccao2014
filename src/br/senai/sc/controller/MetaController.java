/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.controller;


import br.senai.sc.model.negocio.Meta;
import br.senai.sc.model.persistencia.MetaDaoJDBC;
import br.senai.sc.model.persistencia.dao.MetaDAO;
import java.util.List;

/**
 *
 * @author douglas_ghisleri
 */
public class MetaController {

     /**
     * Método serve para listar as metas.
     *
     * @author douglas_ghisleri
     * @since 1.0 05/11/2013
     * @param me
     * @return
     */
    
   // controller listar todos
    public List<Meta> ListAll(){        
    MetaDAO dao = new MetaDaoJDBC();
    return dao.listAll();
    }
        
    
     /**
     * Método serve para inserir uma meta.
     *
     * @author douglas_ghisleri
     * @since 1.0 05/11/2013
     * @param me
     * @return
     */
    
    //controller inserir 
   public boolean inserir (Meta Me){
    MetaDAO dao = new MetaDaoJDBC();
    return dao.insert(Me);
   }
   
    
    
     /**
     * Método serve para atualizar uma meta.
     *
     * @author douglas_ghisleri
     * @since 1.0 05/11/2013
     * @param me
     * @return
     */
    
  //controller editar
   public boolean update (Meta Me){
    MetaDAO dao = new MetaDaoJDBC();
    return dao.update(Me);
    }
       
    
     /**
     * Método serve para remover uma meta.
     *
     * @author douglas_ghisleri
     * @since 1.0 05/11/2013
     * @param me
     * @return
     */
    
    //controller remover
    public boolean delete (int codigo){
    
    MetaDAO dao = new MetaDaoJDBC();
    return dao.delete(codigo);
    }
     
    
     /**
     * Método serve para listar por id as metas.
     *
     * @author douglas_ghisleri
     * @since 1.0 05/11/2013
     * @param me
     * @return
     */
    
    //Controller listar por id
    public Meta listById(int id){
          MetaDAO dao = new MetaDaoJDBC();
          return dao.listById(id);
   }
    
}
