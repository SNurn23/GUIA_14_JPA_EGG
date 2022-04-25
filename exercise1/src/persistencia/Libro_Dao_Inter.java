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
public interface Libro_Dao_Inter extends Generic_Dao_Inter<Libro>{
    public List<Libro> getByTitle(String title);
    public List<Libro> getByAuthor(String name);
    public List<Libro> getByEditorial(String name);
}
