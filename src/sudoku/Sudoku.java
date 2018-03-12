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
    private ArrayList<ArrayList<Integer>> sudoku;
    
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
        sudoku = new ArrayList();
        ArrayList<Integer> lista;
        Random aleatorio = new Random();
        boolean cent = true;
        int contador = 0;
        /*
        *creamos todos los espacios del sudoku para posteriormente introducir
        *numeros aleatorios 
        */
        for (int i = 0; i < 9 ; i++) {
            lista = new ArrayList();
            for (int j = 0; j < 9; j++) {
                lista.add(0);
            }
            sudoku.add(lista);
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
                int num_fila = aleatorio.nextInt(9);
                int num_columna = aleatorio.nextInt(9);
                int num_insertar = aleatorio.nextInt(9)+1;
                if (puedoInsertar(num_fila, num_columna, num_insertar)) {
                    sudoku.get(num_fila).set(num_columna, num_insertar);
                    cent = false;
                }
            }
        }
    }

    @Override
    public String toString()
    {
        String resultadoFinal = "+-------------------------+\n";

        for (int i = 0; i < sudoku.size(); i++) {
            for (int j = 0; j < sudoku.get(i).size(); j++) {
                resultadoFinal += "|"+sudoku.get(i).get(j)+"|";
            }
            resultadoFinal += "\n+-------------------------+\n";
        }
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
        boolean solucion = true;
        for (int i = 0; i < 9; i++) {
            if (this.sudoku.get(fila).get(i) == elemento) {
                solucion = false;
            }
        }
        return solucion;
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

    /**
     * se comprueba si un numero puede insertarse
     * @param fila la fila del sudoku donde se quiere insertar el numero
     * @param columna ela columna donde se quiere insertar el numero
     * @param elemento el numero a insertar
     * @return retorna si se puede insertar o no el numero
     */
    private boolean puedoInsertar(int fila, int columna, int elemento) 
    {
        boolean resultado = true;
        if (!comprobarFila(fila, elemento) || !comprobarColumna(columna, elemento) || !comprobarCuadrante(fila, columna, elemento)) {
            resultado = false;
        }
        return resultado; 
    } 
} 
