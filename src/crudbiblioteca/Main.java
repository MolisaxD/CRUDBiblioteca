/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crudbiblioteca;

import control.LivroController;
import dao.DBConnection;

/**
 *
 * @author mborges
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        DBConnection.getConnection();

        LivroController lc = new LivroController();
        lc.listarLivros();
    }
    
}
