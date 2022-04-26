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
public interface Editorial_DAO_Inter extends Generic_DAO_Inter<Editorial> {
    public Editorial getByName(String name);
}
