/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import java.util.Random;

/**
 *Esta es la clase sudoku 
 * @author Poniente
 */

public class Sudoku 
{
    // Variables privadas de la clase
    //array donde se almacenaran los numeros del sudoku
    private ArrayList<ArrayList<Integer>> numeros_sudoku;
    
    /**
     * contructor de la clase sudoku
     */
    public Sudoku() 
    {
        inicializar();
    }

    /**
     * Esta clase crea un sudoku de manera aleatoria 
     */
    public void inicializar() 
    {
        ArrayList<ArrayList<Integer>> solucion = new ArrayList();
        ArrayList<Integer> numeros = new ArrayList();
        Random aleatorio = new Random();
        boolean cent = true;
        int contador = 0;
        /*
        *creamos todos los espacios del sudoku para posteriormente introducir
        *numeros aleatorios 
        */
        for (int i = 0; i < 27 ; i++) {
            ArrayList<Integer> insercion = new ArrayList();
            for (int j = 0; j < 3; j++) {
                insercion.add(0);
            }
            solucion.add(insercion);
        }
        /*
        *añadimos los numeros generados de manera aleatorioa al sudoku y 
        *cumpliendo las normas de no repetir numeros donde corresponda
        *.set(aleatorio.nextInt(solucion.size()-1),numeros.get(i));
        */
        for (int i = 0; i < 31 ; i++) {
            /*
            *cogemos una fila aleatorioa y generamos un numero aleatorio 
            *para insertar
            */
            cent = true;
            while(cent){
                int num_fila = aleatorio.nextInt(3);
                int num_columna = aleatorio.nextInt(solucion.size()-1);
                int num_insertar = aleatorio.nextInt(9)+1;
                if(!comprobarFila(num_columna,num_insertar)){
                    if (!comprobarColumna(num_columna,num_insertar)) {
                        if (!comprobarCuadrante(num_fila, num_columna,num_insertar)) {
                            solucion.get(num_columna).set(num_fila, num_insertar);
                            cent = false;
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString()
    {
        String resultadoFinal = "";

        return resultadoFinal;
    }

    public void modificarElemento(int fila, int columna, int elemento) throws SudokuException 
    {
        
    }
    
    public void vaciarElemento(int fila, int columna)
    {
        
    }

    private boolean comprobarFila(int fila, int elemento) 
    {
        boolean resultado = true;

        return resultado;
    }

    private boolean comprobarColumna(int columna, int elemento) 
    {
        boolean resultado = true;

        return resultado;
    }

    private boolean comprobarCuadrante(int fila, int columna, int elemento) 
    {
        boolean resultado = true;
        
        return resultado;
    }

    private boolean puedoInsertar(int fila, int columna, int elemento) 
    {
        boolean resultado = false;

        return resultado; 
    } 
} 
