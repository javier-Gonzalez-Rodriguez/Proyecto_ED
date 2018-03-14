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

    /**
     * formateamos el array para mostrarlo por pantalla
     * @return retorna el array formateado
     */
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

    /**
     * intentamos insertar un numero en una posicion del sudoku
     * @param fila fila donde se insertara el numero
     * @param columna columna donde se insertara el numero 
     * @param elemento numero a insertar
     * @throws SudokuException exception para controlar el numero que se va a insertar
     */
    public void modificarElemento(int fila, int columna, int elemento) throws SudokuException 
    {
        if (elemento > 0 || elemento<10) {
            if (puedoInsertar(fila, columna, elemento)) {
                sudoku.get(fila).set(columna, elemento);
            }
        }
        else{
            throw new SudokuException("numero no valido");
        }
    }
    
    /**
     * eliminamos un elemento
     * @param fila fila que se va a vaciar
     * @param columna columna que se va a vaciar
     */
    public void vaciarElemento(int fila, int columna)
    {
        sudoku.get(fila).set(columna, 0);
    }
    
    /**
     * compruebo la fila donde se va a insertar el numero
     * @param fila fila de la insercion 
     * @param elemento numero a insertar
     * @return si se puede en esta fila o no insertar el elemento
     */
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
    
    /**
     * comprueba la columna del sudoku
     * @param columna numero de la columna
     * @param elemento numero a insertar
     * @return devuelve si se puede insertar en esa columna o no
     */
    private boolean comprobarColumna(int columna, int elemento) 
    {
        boolean resultado = true;
        for(int i = 0; i < sudoku.size(); i++){
            if (sudoku.get(i).get(columna) == elemento) {
                    resultado = false;
            }
        }
        return resultado;
    }

    /**
     * comprobamos el cuadrante al que va a pertenecer el numero
     * @param fila fila donde se insertara el numero
     * @param columna columna donde se insertara el numero
     * @param elemento numero que se quiere insertar
     * @return nos devuelve si se puede o no insertar el numero
     */
    private boolean comprobarCuadrante(int fila, int columna, int elemento) 
    {
        boolean resultado = true;
        if (fila==0 || fila<3) {
            if (columna==0 || columna<3) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (sudoku.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
            if (columna >= 3 && columna < 6) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 3; j < 6; j++) {
                        if (sudoku.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
            if (columna >= 6 && columna < 9) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 3; j < 6; j++) {
                        if (sudoku.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
        }
        if (fila >= 3 && fila <5) {
            if (columna==0 || columna<3) {
                for (int i = 3; i < 6; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (sudoku.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
            if (columna >= 3 && columna < 6) {
                for (int i = 3; i < 6; i++) {
                    for (int j = 3; j < 6; j++) {
                        if (sudoku.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
            if (columna >= 6 && columna < 9) {
                for (int i = 3; i < 6; i++) {
                    for (int j = 3; j < 6; j++) {
                        if (sudoku.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
        }
        if (fila >=5 && fila<8) {
            if (columna==0 || columna<3) {
                for (int i = 5; i < 8; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (sudoku.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
            if (columna >= 3 && columna < 6) {
                for (int i = 5; i < 8; i++) {
                    for (int j = 3; j < 6; j++) {
                        if (sudoku.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
            if (columna >= 6 && columna < 9) {
                for (int i = 5; i < 8; i++) {
                    for (int j = 3; j < 6; j++) {
                        if (sudoku.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
        }
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
