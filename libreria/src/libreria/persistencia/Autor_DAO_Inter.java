/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import libreria.entidades.Autor;

/**
 *
 * @author Sofia
 */
public interface Autor_DAO_Inter extends Generic_DAO_Inter<Autor> {
    public Autor getByName(String name);
}
