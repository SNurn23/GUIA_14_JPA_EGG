/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import libreria.services.MenuService;

/**
 *
 * @author Sofia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MenuService menu  = new MenuService();
        
        menu.menuPrincipal();
    }
    
}
