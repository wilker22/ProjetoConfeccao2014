
package br.senai.sc.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {
    
    //Nome da unidade de persistência
    private static final String PERSISTENCE_UNIT = "ProjetoConfeccaoPU";
    private EntityManagerFactory emf = null;
    private EntityManager em = null;

    public EntityManager getEntityManager() {
        if(emf == null){
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        if(em == null){
            em = emf.createEntityManager();
        }
        
        return em;
    }


    
    
    
    
}
