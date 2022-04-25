/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import persistencia.Libro_Dao_Impl;

/**
 *
 * @author Sofia
 */
public class LibroService {
    
    private Libro_Dao_Impl libroDAO;
    EditorialService editorial;
    AutorService autor;
    Scanner input = new Scanner(System.in, "ISO_8859_1").useDelimiter("\n").useLocale(Locale.US);
    
   public LibroService(){
       this.libroDAO = new Libro_Dao_Impl();
       this.editorial = new EditorialService();
       this.autor = new AutorService();
   } 
   
   public void crearLibro(){
       
       int isbn;
       String nombre;
       boolean flag;
       
       do{
           System.out.println("Ingrese el isbn del libro");
           isbn = input.nextInt();
           
           flag = existsLibro(isbn);
           
           if(flag){
               System.out.println("Ya se encuentra registrado un libro con ese isbn");
           }
           
           System.out.println("Ingrese el titulo del libro");
           nombre = input.next();
           
           if(nombre == null){
               System.out.println("El titulo del libro debe ser obligatorio");
           }
              
       }while(flag != false && nombre == null);   
       
        System.out.println("Ingrese el año del libro");
        int anio = input.nextInt();
           
        System.out.println("Ingrese el numero de ejemplares");
        int totEjem = input.nextInt();
           
        List <Autor> autores = agregarAutores();
           
        List <Editorial> editoriales = agregarEditoriales();
           
        Libro libro = new Libro(isbn, nombre, anio, totEjem, 0, totEjem, Boolean.TRUE, autores, editoriales);
           
       libroDAO.saveObjeto(libro);
       System.out.println("Se ha guardado correctamente");
   }
   
   
   public List <Autor> agregarAutores(){
       int op;
       List<Autor> autores = new ArrayList<>();
       
       autor.obtenerAutores();
       
       do{
           Autor a = autor.buscarAutor();
           autores.add(a);
           
           System.out.println("Desea agregar otro autor? 1)Si, 2)No");
           op = input.nextInt();
           
       }while(op != 1);
       
       return autores;
   }
   
   public List <Editorial> agregarEditoriales(){
       int op;
       List<Editorial> editoriales = new ArrayList<>();
       
       editorial.obtenerEditoriales();
       
       do{
           Editorial e = editorial.buscarEditorialxNombre();
           editoriales.add(e);
           
           System.out.println("Desea agregar otra editorial? 1)Si, 2)No");
           op = input.nextInt();
           
       }while(op != 1);
       
       return editoriales;
   }
   
   public void actualizarLibro(){
       
        Libro li = buscarLibro();
        
        System.out.println("Elija la opcion que desea actualizar: ");
        System.out.println("1) Titulo");
        System.out.println("2) Año");
        System.out.println("3) Numero de Ejemplares");
        System.out.println("4) Alta");
        int op = input.nextInt();

        switch(op){
            case 1: 
                System.out.println("Ingrese el nuevo titulo del Libro");
                String titulo = input.next();
                li.setTitulo(titulo);
                break;
            
            case 2: 
                System.out.println("Ingrese el nuevo año del Libro");
                int anio = input.nextInt();
                li.setAnio(anio);
                break;
            
            case 3: 
                System.out.println("Ingrese el nuevo total de ejemplares");
                int tot = input.nextInt();
                li.setEjemplares(tot);
                break;
                
            case 4:
                System.out.println("1)Dar de alta, 2)Dar de baja");
                op = input.nextInt();
                boolean flag = (op == 1);
                li.setAlta(flag);
                break;
       }

        libroDAO.updateObjeto(li);
        System.out.println("Se ha actualizado correctamente");
   }
   
   public void borrarLibro(){
      
        Libro li = buscarLibro();
        libroDAO.deleteObjeto(li);
        System.out.println("Se ha borrado correctamente");
   }
   
   public boolean existsLibro(int isbn){
        Libro l = libroDAO.getObjeto(isbn);
        return (l != null);
   }
   
   public Libro buscarLibro(){
       
        int isbn;
        Libro li;
        
        do{
            System.out.println("Ingrese el isbn del libro");
            isbn = input.nextInt();

            li = libroDAO.getObjeto(isbn);

            if(li == null){
               System.out.println("No se encontro un libro con ese isbn");
            }
            
        }while(li == null);  
        
       return li;
   }
   

   public void obtenerLibros(){
       
       List<Libro> libros = libroDAO.getAll();
       Collections.sort(libros);
       
       if(!libros.isEmpty()){
           System.out.println("LIBROS");
           System.out.println("---------------------------");
           System.out.printf("%-10s%-35s%-15s\n", "ID", "NOMBRE","AÑO","EJEMPLARES","EJEMPLARES PRESTADOS","EJEMPLARES RESTANTES", "ALTA");
           
           for (Libro l : libros) {
               System.out.printf("%-10s%-35s%-15s%-10s%-10s%-10s%-10s\n", l.getIsbn(), l.getTitulo(), l.getEjemplares(), l.getEjemplaresPrestados(), l.getEjemplaresRestantes(), l.getAlta());
           }
           
       }else{
           System.out.println("No hay registros cargados");
       }
   }
   
  public void obtenerLibrosxTitulo(){
       
      System.out.println("Ingrese el titulo del libro");
      String titulo = input.next();
      
       List<Libro> libros = libroDAO.getByTitle(titulo);
       Collections.sort(libros);
       
       if(!libros.isEmpty()){
           System.out.println("LIBROS");
           System.out.println("---------------------------");
           System.out.printf("%-10s%-35s%-15s\n", "ID", "NOMBRE","AÑO","EJEMPLARES","EJEMPLARES PRESTADOS","EJEMPLARES RESTANTES", "ALTA");
           
           for (Libro l : libros) {
               System.out.printf("%-10s%-35s%-15s%-10s%-10s%-10s%-10s\n", l.getIsbn(), l.getTitulo(), l.getEjemplares(), l.getEjemplaresPrestados(), l.getEjemplaresRestantes(), l.getAlta());
               
               List<Autor> autores = l.getAutores();
               System.out.println("AUTORES");
               
               for (Autor a : autores) {
                   System.out.println(a.getNombre());
               }
               
               List<Editorial> editoriales = l.getEditoriales();
               System.out.println("EDITORIALES");
          
               for (Editorial e : editoriales) {
                   System.out.println(e.getNombre());
               }
               
           }
       }else{
           System.out.println("No hay registros cargados con ese titulo");
       }
   }
  
  public void obtenerLibrosxAutor(){
       
      System.out.println("Ingrese el autor");
      String autor = input.next();
      
       List<Libro> libros = libroDAO.getByAuthor(autor);
       Collections.sort(libros);
       
       if(!libros.isEmpty()){
           System.out.println("LIBROS");
           System.out.println("---------------------------");
           System.out.printf("%-10s%-35s%-15s\n", "ID", "NOMBRE","AÑO","EJEMPLARES","EJEMPLARES PRESTADOS","EJEMPLARES RESTANTES", "ALTA");
           
           for (Libro l : libros) {
               System.out.printf("%-10s%-35s%-15s%-10s%-10s%-10s%-10s\n", l.getIsbn(), l.getTitulo(), l.getEjemplares(), l.getEjemplaresPrestados(), l.getEjemplaresRestantes(), l.getAlta());
               
               List<Autor> autores = l.getAutores();
               System.out.println("AUTORES");
               
               for (Autor a : autores) {
                   System.out.println(a.getNombre());
               } 
           }
       }else{
           System.out.println("No hay registros cargados con ese titulo");
       }
  }
  
  public void obtenerLibrosxEditorial(){
       
      System.out.println("Ingrese la editorial");
      String editorial = input.next();
      
       List<Libro> libros = libroDAO.getByEditorial(editorial);
       Collections.sort(libros);
       
       if(!libros.isEmpty()){
           System.out.println("LIBROS");
           System.out.println("---------------------------");
           System.out.printf("%-10s%-35s%-15s\n", "ID", "NOMBRE","AÑO","EJEMPLARES","EJEMPLARES PRESTADOS","EJEMPLARES RESTANTES", "ALTA");
           
           for (Libro l : libros) {
               System.out.printf("%-10s%-35s%-15s%-10s%-10s%-10s%-10s\n", l.getIsbn(), l.getTitulo(), l.getEjemplares(), l.getEjemplaresPrestados(), l.getEjemplaresRestantes(), l.getAlta());
               
              List<Editorial> editoriales = l.getEditoriales();
              System.out.println("EDITORIALES");
          
               for (Editorial e : editoriales) {
                   System.out.println(e.getNombre());
               }
           }
       }else{
           System.out.println("No hay registros cargados con ese titulo");
       }
  }
}
