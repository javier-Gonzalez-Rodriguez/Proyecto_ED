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
        int fila, columna, elemento;
        Sudoku su = new Sudoku();;
        Scanner input = new Scanner(System.in);
        boolean cent = true;
        
        while (cent) {
            System.out.println("1. iniciar/reiniciar sudoku\n"
                    + "2. realizar movimiento\n"
                    + "3. vaciar casilla\n"
                    + "4. mostrar sudoku\n"
                    + "5. salir");
            int opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    su.inicializar();
                    break;
                case 2:
                    System.out.println("introduce una fila");
                    fila = input.nextInt();
                    System.out.println("introduce una columna");
                    columna = input.nextInt();
                    System.out.println("introduce el numero que deseas introducir");
                    elemento = input.nextInt();
                    try {
                        su.modificarElemento(fila, columna, elemento);
                    } catch (SudokuException ex) {
                        System.err.println(ex.toString());
                    }

                    break;
                case 3:
                    System.out.println("introduce una fila");
                    fila = input.nextInt();
                    System.out.println("introduce una columna");
                    columna = input.nextInt();
                    su.vaciarElemento(fila, columna);
                    break;
                case 4:
                    System.out.println(su.toString());
                    break;
                case 5:
                    cent = false;
                    break;
            }
        }

    }
    
}
