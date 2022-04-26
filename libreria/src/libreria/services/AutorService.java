/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.services;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.persistencia.Autor_DAO_Impl;

/**
 *
 * @author Sofia
 */
public class AutorService {
    private Autor_DAO_Impl autorDAO;
    Scanner input = new Scanner(System.in, "ISO_8859_1").useDelimiter("\n").useLocale(Locale.US);

   public AutorService(){
       this.autorDAO = new Autor_DAO_Impl();
   } 
   
   public void crearAutor(){
       
       String nombre;
       boolean flag;
       
       do{
           System.out.println("Ingrese el nombre del autor");
           nombre = input.next();
           
           flag = existsAutor(nombre);
           
           if(nombre == null){
               System.out.println("Es obligatorio el nombre del autor");
           }else if(flag){
               System.out.println("Ya se encuentra registrada un autor con ese nombre");
           }
           
       }while(nombre == null || flag != false);        
       
       Autor autor = new Autor(nombre,Boolean.TRUE);
       
       autorDAO.saveObjeto(autor);
       System.out.println("Se ha guardado correctamente");
   }
   
   
   public void actualizarAutor(){
       
        Autor au = buscarAutor();
        System.out.println("Elija la opcion que desea actualizar: ");
        System.out.println("1) Nombre");
        System.out.println("2) Alta");
        int op = input.nextInt();

        switch(op){
            case 1: 
                System.out.println("Ingrese el nuevo nombre del autor");
                String nombre = input.next();
                au.setNombre(nombre);
                break;

            case 2:
                System.out.println("1)Dar de alta, 2)Dar de baja");
                op = input.nextInt();
                boolean flag = (op == 1);
                au.setAlta(flag);
                break;
       }

        autorDAO.updateObjeto(au);
        System.out.println("Se ha actualizado correctamente");
   }
   
   public void borrarAutor(){
      
        Autor au = buscarAutor();
        autorDAO.deleteObjeto(au);
        System.out.println("Se ha borrado correctamente");
   }
   
   public boolean existsAutor(String name){
        Autor a = autorDAO.getByName(name);
        return (a != null);
   }
   
   public Autor buscarAutor(){
       
        String nombre;
        Autor au;
        
        do{
            System.out.println("Ingrese el nombre del autor");
            nombre = input.next();

            au = autorDAO.getByName(nombre);

            if(au == null){
               System.out.println("No se encontro un autor con ese nombre");
            }else if(nombre == null){
               System.out.println("Es obligatorio el nombre del autor");
            }
            
        }while(nombre == null || au == null);  
        
       return au;
   }
   
   public Autor obetenerAutorxId(){
        Autor au;
       
        do{
            System.out.println("Ingrese el id del autor");
            int id = input.nextInt();

            au = autorDAO.getObjeto(id);

            if(au == null){
               System.out.println("No se encontro un autor con ese id");
            }
            
        }while(au == null);  
        
        return au;
   }
   
   public void obtenerAutores(){
       
       List<Autor> autores = autorDAO.getAll();
       Collections.sort(autores);
       
       if(!autores.isEmpty()){
           System.out.println("AUTORES");
           System.out.println("---------------------------");
           System.out.printf("%-10s%-35s%-15s\n", "ID", "NOMBRE", "ALTA");
           
           for (Autor a : autores) {
               System.out.printf("%-10s%-35s%-15s\n", a.getId(), a.getNombre(), a.getAlta());
           }
           
       }else{
           System.out.println("No hay registros cargados");
       }
   }
   
   public void obtenerAutorxNombre(){
       Autor au = buscarAutor();
       
        System.out.println("AUTOR");
        System.out.println("---------------------------");
        System.out.printf("%-10s%-35s%-15s\n", "ID", "NOMBRE", "ALTA");
        System.out.printf("%-10s%-35s%-15s\n", au.getId(), au.getNombre(), au.getAlta());
   }
}
