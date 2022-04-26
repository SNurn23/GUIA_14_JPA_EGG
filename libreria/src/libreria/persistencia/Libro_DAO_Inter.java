/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Libro;

/**
 *
 * @author Sofia
 */
public interface Libro_DAO_Inter extends Generic_DAO_Inter<Libro>{
    public List<Libro> getByTitle(String title);
    public List<Libro> getByAuthor(String name);
    public List<Libro> getByEditorial(String name);
}
