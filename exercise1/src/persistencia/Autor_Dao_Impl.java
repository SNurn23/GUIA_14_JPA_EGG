
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Autor;
import java.util.List;

/**
 *
 * @author Sofia
 */
public class Autor_Dao_Impl extends Generic_Dao_Impl<Autor> implements Autor_Dao_Inter{
    
    public Autor_Dao_Impl() {
        super(Autor.class);
    }

    @Override
    public Autor getByName(String name) {
        try {  
            Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre", Autor.class)
                    .setParameter("nombre", name);
            return autor;
        } catch (Exception e) {
            System.err.println("ERROR: Error al obtener los autores " + e.getMessage());
        }
        return null;
    }
    
}
