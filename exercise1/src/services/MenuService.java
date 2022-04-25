/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Sofia
 */
public class MenuService {
    LibroService libro;
    EditorialService editorial;
    AutorService autor;
    Scanner input = new Scanner(System.in, "ISO_8859_1").useDelimiter("\n").useLocale(Locale.US);
    
    public MenuService() {
        this.libro = new LibroService();
        this.editorial = new EditorialService();
        this.autor = new AutorService();
    }
    
    public void menuPrincipal(){
        int op;
        do{
            System.out.println("Elija una opcion");
            System.out.println("1) Libro");
            System.out.println("2) Autor");
            System.out.println("3) Editorial");
            System.out.println("4) Salir");
            System.out.println("Opcion: ");
            op = input.nextInt();
            
            switch(op){
                case 1:
                    menuLibro();
                    break;
                    
                case 2:
                    menuAutor();
                    break;
                    
                case 3: 
                    menuEditorial();
                    break;
                    
                case 4: 
                    System.out.println("Saliendo..Bye");
                    break;
                    
                default: System.out.println("Ingrese una opcion correcta");
                    break;
            }
        }while(op != 4);
    }
    
    public void menuLibro(){
        int op;
        do{
            System.out.println("Elija una opcion");
            System.out.println("1) Agregar Libro");
            System.out.println("2) Actualizar Libro");
            System.out.println("3) Eliminar Libro");
            System.out.println("4) Buscar Libro por ISBN");
            System.out.println("5) Buscar Libro por Titulo");
            System.out.println("6) Buscar Libro por Autor");
            System.out.println("7) Buscar Libro por Editorial");
            System.out.println("8) Obtener libros");
            System.out.println("9) Salir");
            System.out.println("Opcion: ");
            op = input.nextInt();
            
            switch(op){
                case 1:
                    libro.crearLibro();
                    break;
                    
                case 2:
                    libro.actualizarLibro();
                    break;
                    
                case 3: 
                    libro.borrarLibro();
                    break;
                    
                case 4:
                    libro.buscarLibro();
                    break;
                    
                case 5:
                    libro.obtenerLibrosxTitulo();
                    break;
                    
                case 6: 
                    libro.obtenerLibrosxAutor();
                    break;
                    
                case 7: 
                    libro.obtenerLibrosxEditorial();
                    break;
                    
                case 8: 
                    libro.obtenerLibros();
                    break;
                   
                default: System.out.println("Ingrese una opcion correcta");
                    break;
            }
        }while(op != 9);
        
    }
    
    public void menuAutor(){
         int op;
        do{
            System.out.println("Elija una opcion");
            System.out.println("1) Agregar Autor");
            System.out.println("2) Actualizar Autor");
            System.out.println("3) Eliminar Autor");
            System.out.println("4) Buscar autor por nombre");
            System.out.println("5) Buscar autor por id");
            System.out.println("6) Obtener autores");
            System.out.println("7) Salir");
            System.out.println("Opcion: ");
            op = input.nextInt();
            
            switch(op){
                case 1:
                    autor.crearAutor();
                    break;
                    
                case 2:
                    autor.actualizarAutor();
                    break;
                    
                case 3: 
                    autor.borrarAutor();
                    break;
                    
                case 4:
                    autor.obtenerAutorxNombre();
                    break;
                    
                case 5:
                    autor.obetenerAutorxId();
                    break;
                    
                case 6: 
                    autor.obtenerAutores();
                    break;
                    
                default: System.out.println("Ingrese una opcion correcta");
                    break;
            }
        }while(op != 7);
    }
    
      public void menuEditorial(){
         int op;
        do{
            System.out.println("Elija una opcion");
            System.out.println("1) Agregar Editorial");
            System.out.println("2) Actualizar Editorial");
            System.out.println("3) Eliminar Editorial");
            System.out.println("4) Buscar Editorial por nombre");
            System.out.println("5) Buscar Editorial por id");
            System.out.println("6) Obtener editoriales");
            System.out.println("7) Salir");
            System.out.println("Opcion: ");
            op = input.nextInt();
            
            switch(op){
                case 1:
                    editorial.crearEditorial();
                    break;
                    
                case 2:
                    editorial.actualizarEditorial();
                    break;
                    
                case 3: 
                    editorial.borrarEditorial();
                    break;
                    
                case 4:
                    editorial.buscarEditorialxNombre();
                    break;
                    
                case 5:
                    editorial.obetenerEditorialxId();
                    break;
                    
                case 6: 
                    editorial.obtenerEditoriales();
                    break;
                    
                default: System.out.println("Ingrese una opcion correcta");
                    break;
            }
        }while(op != 7);
    }
  
}
