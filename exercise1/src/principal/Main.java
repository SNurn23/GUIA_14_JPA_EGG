/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import services.MenuService;

/**
 *
 * @author Sofia
 */
public class Main {

    public static void main(String[] args) {
        MenuService menu  = new MenuService();
        
        menu.menuPrincipal();
    }
    
}
