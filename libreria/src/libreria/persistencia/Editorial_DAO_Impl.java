/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import libreria.entidades.Editorial;

/**
 *
 * @author Sofia
 */
public class Editorial_DAO_Impl  extends Generic_DAO_Impl<Editorial> implements Editorial_DAO_Inter{

     public Editorial_DAO_Impl() {
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
