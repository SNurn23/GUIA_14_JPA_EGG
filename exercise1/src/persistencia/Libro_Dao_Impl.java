/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Libro;
import java.util.List;

/**
 *
 * @author Sofia
 */
public class Libro_Dao_Impl extends Generic_Dao_Impl<Libro> implements Libro_Dao_Inter{
    
    public Libro_Dao_Impl() {
        super(Libro.class);
    }

    @Override
    public List<Libro> getByTitle(String title) {
       try {  
            List<Libro> list = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo", Libro.class)
                    .setParameter("titulo", title)
                    .getResultList();
            return list;
        } catch (Exception e) {
            System.err.println("ERROR: Error al obtener los libros por titulo " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Libro> getByAuthor(String name) {
        try {  
            List<Libro> list = em.createQuery("SELECT l FROM Libro l JOIN l.autores a WHERE a.nombre LIKE :autor", Libro.class)
                    .setParameter("autor", name)
                    .getResultList();
            return list;
        } catch (Exception e) {
            System.err.println("ERROR: Error al obtener los libros por titulo " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Libro> getByEditorial(String name) {
        try {  
            List<Libro> list = em.createQuery("SELECT l FROM Libro l JOIN l.editoriales e WHERE e.nombre LIKE :editorial", Libro.class)
                    .setParameter("editorial", name)
                    .getResultList();
            return list;
        } catch (Exception e) {
            System.err.println("ERROR: Error al obtener los libros por titulo " + e.getMessage());
        }
        return null;
    }
    
}
