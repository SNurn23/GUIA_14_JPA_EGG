/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Sofia
 */
public abstract class Generic_Dao_Impl <T> implements Generic_Dao_Inter<T> {
    
    protected final Class<T> clase;
    protected final EntityManager em;

    public Generic_Dao_Impl(Class<T> clase) {
        this.clase = clase;
        this.em = Persistence
                .createEntityManagerFactory("Libreria")
                .createEntityManager();
    }
    
    @Override
    public void saveObjeto(T t) {
        try {
           em.getTransaction().begin();
           em.persist(t);
           em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("ERROR: Error al guardar " + e.getMessage());
        }
    }

    @Override
    public void deleteObjeto(T t) {
        try {
           em.getTransaction().begin();
           em.remove(t);
           em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("ERROR: Error al borrar " + e.getMessage());
        }
    }

    @Override
    public void updateObjeto(T t) {
       try {
           em.getTransaction().begin();
           em.merge(t);
           em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("ERROR: Error al actualizar " + e.getMessage());
        }
    }

    @Override
    public T getObjeto(int id) {
        try {
           T object = em.find(clase, id);
           return object;
        } catch (Exception e) {
            System.err.println("ERROR: Error al obtener por id " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        try {
            String jpql = "SELECT c FROM " + clase.getName() + " c " ;
            List<T> list = em.createQuery(jpql, clase).getResultList();
            return list;
        } catch (Exception e) {
            System.err.println("ERROR: Error al obtener todos " + e.getMessage());
        }
        return null;
    }
    
}
