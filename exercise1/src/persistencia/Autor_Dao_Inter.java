/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Autor;

/**
 *
 * @author Sofia
 */
public interface Autor_Dao_Inter extends Generic_Dao_Inter<Autor>{
    public Autor getByName(String name);
}
