/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Sofia
 */

@Entity
@Table(name = "Autor")
public class Autor implements Serializable, Comparable<Autor> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre", length = 145, nullable = false)
    private String nombre;
    
    @Column(name = "alta")
    private Boolean alta;

    public Autor(String nombre, Boolean alta) {
        this.nombre = nombre;
        this.alta = alta;
    }

    public Autor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    @Override
    public int compareTo(Autor t) {
        return id.compareTo(t.id);
    }
}
