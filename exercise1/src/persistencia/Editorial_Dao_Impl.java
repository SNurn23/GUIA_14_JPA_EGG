/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Editorial;

/**
 *
 * @author Sofia
 */
public class Editorial_Dao_Impl extends Generic_Dao_Impl<Editorial> implements Editorial_Dao_Inter{
    
    public Editorial_Dao_Impl() {
        super(Editorial.class);
    }

    @Override
    public Editorial getByName(String name) {
        try {  
           Editorial ed = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre", Editorial.class)
                    .setParameter("nombre", name);
            return ed;
        } catch (Exception e) {
            System.err.println("ERROR: Error al obtener los libros por titulo " + e.getMessage());
        }
        return null;
    }
}
