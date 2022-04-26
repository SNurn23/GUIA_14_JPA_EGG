/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author Sofia
 */

@Entity 
@Table(name = "Libro")
public class Libro implements Serializable, Comparable<Libro> {
    @Id
    @Column(name = "isbn")
    private Integer isbn;
    
    @Column(name = "titulo", length = 145, nullable = false)
    private String titulo;
    
    @Column(name = "anio", length = 4)
    private int anio;
    
    @Column(name = "ejemplares", nullable = false)  
    private int ejemplares;
    
    @Column(name = "ejemplaresPrestados", nullable = false)  
    private int ejemplaresPrestados;
    
    @Column(name = "ejemplaresRestantes", nullable = false) 
    private int ejemplaresRestantes;
    
    @Column(name = "alta", nullable = false) 
    private boolean alta;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="libro_autor", joinColumns=@JoinColumn(name="libro_isbn"), inverseJoinColumns=@JoinColumn(name="autor_id_Autor"))
    private List<Autor> autores;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="libro_editorial", joinColumns= @JoinColumn(name="libro_isbn"), inverseJoinColumns=@JoinColumn(name="editorial_id_editorial"))
    private List<Editorial> editoriales;

    public Libro(Integer isbn, String titulo, int anio, int ejemplares, int ejemplaresPrestados, int ejemplaresRestantes, boolean alta, List<Autor> autores, List<Editorial> editoriales) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.ejemplaresRestantes = ejemplaresRestantes;
        this.alta = alta;
        this.autores = autores;
        this.editoriales = editoriales;
    }

    public Libro() {
    }


    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public int getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(int ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public int getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public void setEjemplaresRestantes(int ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    public boolean getAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Editorial> getEditoriales() {
        return editoriales;
    }

    public void setEditoriales(List<Editorial> editoriales) {
        this.editoriales = editoriales;
    }

    @Override
    public int compareTo(Libro t) {
        return isbn.compareTo(t.isbn);
    }
}
