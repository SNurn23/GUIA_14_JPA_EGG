/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.List;

/**
 *
 * @author Sofia
 */
public interface Generic_DAO_Inter <T> {
    public void saveObjeto(T t);
    public void deleteObjeto(T t);
    public void updateObjeto(T t);
    public T getObjeto(int id);
    public List<T> getAll();
}
