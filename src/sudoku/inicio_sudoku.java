/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Esta clase es la clase principal donde se inicia el sudoku
 * @author Poniente
 */
public class inicio_sudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sudoku su = new Sudoku();
        Scanner input = new Scanner(System.in);
        System.out.println(su.toString());
        try{
            while(true){
                System.out.println("introduce una fila");
                int fila = input.nextInt();
                System.out.println("introduce una columna");
                int columna = input.nextInt();
                System.out.println("introduce el numero que deseas introducir");
                int elemento = input.nextInt();
                su.modificarElemento(fila, columna, elemento);
                System.out.println(su.toString());
            }
        } catch (SudokuException ex) {
            Logger.getLogger(inicio_sudoku.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
