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
public interface Editorial_Dao_Inter extends Generic_Dao_Inter<Editorial>{
    public Editorial getByName(String name);
}
