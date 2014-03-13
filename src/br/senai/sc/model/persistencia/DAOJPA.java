package br.senai.sc.model.persistencia;

import br.senai.sc.model.util.JPAUtil;
import br.senai.sc.model.persistencia.dao.DAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;


public abstract class DAOJPA<T, I> implements DAO<T, I> {

    private JPAUtil conexao;

    @Override
    public T save(T entity) {
        T saved = entity;
        try {
            //Abrir a transação
            getEntityManager().getTransaction().begin();
            //Persistir a entidade na base de dados
            saved = getEntityManager().merge(saved);
           
            //Confirmar a transação
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            //Verificar se a transação está ativa
            if (getEntityManager().getTransaction().isActive() == false) {
                getEntityManager().getTransaction().begin();
            }
            //Desfazer a transação
            getEntityManager().getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao salvar um "
                    + "elemento na base de dados. " + e.getMessage());
        }
        return saved;
    }

    @Override
    public boolean remove(Class<T> classe, I pk) {
        boolean estado = false;
        try {
            getEntityManager().getTransaction().begin();
           getEntityManager().remove(getEntityManager()
                   .getReference(classe, pk));
            getEntityManager().getTransaction().commit();
            estado = true;
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive() == false) {
                getEntityManager().getTransaction().begin();
            }
            getEntityManager().getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro remover elemento "
                    + "na base de dados " + e.getMessage());
        }
        return estado;
    }

    @Override
    public List<T> getAll(Class<T> classe) {
        return getEntityManager().createQuery("select x from "
                + classe.getSimpleName() + " x").getResultList();
    }

    @Override
    public T getById(Class<T> classe, I pk) {
        try{
            return getEntityManager().find(classe, pk);
        }catch (NoResultException e){
            return null;
            
        }
    }

    @Override
    public EntityManager getEntityManager() {
        if (conexao == null) {
            conexao = new JPAUtil();
        }
        return conexao.getEntityManager();
    }
}
