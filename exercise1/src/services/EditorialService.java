/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entidades.Editorial;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import persistencia.Editorial_Dao_Impl;

/**
 *
 * @author Sofia
 */
public class EditorialService {
    
    private Editorial_Dao_Impl editorialDAO;
    Scanner input = new Scanner(System.in, "ISO_8859_1").useDelimiter("\n").useLocale(Locale.US);

   public EditorialService(){
       this.editorialDAO = new Editorial_Dao_Impl();
   } 
   
   public void crearEditorial(){
       
       String nombre;
       boolean flag;
       
       do{
           System.out.println("Ingrese el nombre de la editorial");
           nombre = input.next();
           
           flag = existsEditorial(nombre);
           
           if(nombre == null){
               System.out.println("Es obligatorio el nombre de la editorial");
           }else if(flag){
               System.out.println("Ya se encuentra registrada una editorial con ese nombre");
           }
           
       }while(nombre == null || flag != false);        
       
       Editorial editorial = new Editorial(nombre,Boolean.TRUE);
       
       editorialDAO.saveObjeto(editorial);
       System.out.println("Se ha guardado correctamente");
   }
   
   
   public void actualizarEditorial(){
       
       Editorial ed = buscarEditorialxNombre();
        System.out.println("Elija la opcion que desea actualizar: ");
        System.out.println("1) Nombre");
        System.out.println("2) Alta");
        int op = input.nextInt();

        switch(op){
            case 1: 
                System.out.println("Ingrese el nuevo nombre de la editorial");
                String nombre = input.next();
                ed.setNombre(nombre);
                break;

            case 2:
                System.out.println("1)Dar de alta, 2)Dar de baja");
                op = input.nextInt();
                boolean flag = (op == 1);
                ed.setAlta(flag);
                break;
       }

        editorialDAO.updateObjeto(ed);
        System.out.println("Se ha actualizado correctamente");
   }
   
   public void borrarEditorial(){
      
        Editorial ed = buscarEditorialxNombre();
        editorialDAO.deleteObjeto(ed);
        System.out.println("Se ha borrado correctamente");
   }
   
   public boolean existsEditorial(String name){
        Editorial e = editorialDAO.getByName(name);
        return (e != null);
   }
   
   public Editorial buscarEditorialxNombre(){
       
        String nombre;
        Editorial ed;
        
        do{
            System.out.println("Ingrese el nombre de la editorial");
            nombre = input.next();

            ed = editorialDAO.getByName(nombre);

            if(ed == null){
               System.out.println("No se encontro una editorial con ese nombre");
            }else if(nombre == null){
               System.out.println("Es obligatorio el nombre de la editorial");
            }
            
        }while(nombre == null || ed == null);  
        
       return ed;
   }
   
   public Editorial obetenerEditorialxId(){
        Editorial ed;
       
        do{
            System.out.println("Ingrese el id de la editorial");
            int id = input.nextInt();

            ed = editorialDAO.getObjeto(id);

            if(ed == null){
               System.out.println("No se encontro una editorial con ese id");
            }
            
        }while(ed == null);  
        
        return ed;
   }
   
   public void obtenerEditoriales(){
       
       List<Editorial> editoriales = editorialDAO.getAll();
       Collections.sort(editoriales);
       
       if(!editoriales.isEmpty()){
           System.out.println("EDITORIALES");
           System.out.println("---------------------------");
           System.out.printf("%-10s%-35s%-15s\n", "ID", "NOMBRE", "ALTA");
           
           for (Editorial e : editoriales) {
               System.out.printf("%-10s%-35s%-15s\n", e.getId(), e.getNombre(), e.getAlta());
           }
           
       }else{
           System.out.println("No hay registros cargados");
       }
   }
   
}
