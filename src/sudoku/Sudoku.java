/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Manuel Muñoz Rodríguez
 */
public class Sudoku 
{
    private ArrayList<ArrayList<Integer>> array;
    private Random aleatorio;
    // Variables privadas de la clase

    /**
     * constructor por defecto del sudoku
     */
    public Sudoku() 
    {
        array= new ArrayList<>();
        
        
    }

    /**
     * Constructor del tablero
     * @throws SudokuException lanza una excepción si falla algo al llamar al método modificarElemento 
     */
    public void inicializar() throws SudokuException 
    {
        array= new ArrayList<>();
        for (int i = 0; i < 9; i++) 
        {
            ArrayList<Integer> a=new ArrayList<>();
            for (int j = 0; j < 9; j++) 
            {
                a.add(0);
            }
            
            array.add(a);
        }
        
        aleatorio=new Random();
        
        int contador=0;
        while(contador<24)
        {
            int numero_ale=aleatorio.nextInt(9-1)+1;
            int posicionx=aleatorio.nextInt(9-1)+1;
            int posiciony=aleatorio.nextInt(9-1)+1;
            if(puedoInsertar(posicionx, posiciony, numero_ale)==true)
            {
                modificarElemento(posicionx, posiciony, numero_ale);
            }
            contador++;
        }
        
    }

    /**
     * Muestra el tablero del sudoku
     * @return el tablero del sudoku
     */
    @Override
    public String toString()
    {
        String resultadoFinal = "";
        for (int i = 0; i < array.size(); i++) 
        {
            
            for (int j = 0; j < 9; j++) {
                
                int n=array.get(i).get(j);
                resultadoFinal+=n+" ";
            }
            resultadoFinal+="\n";
            
        }

        return resultadoFinal;
    }

    /**
     * modifica un elemento del tablero por el que le pasemos nosotros en la posición que nosotros le pasemos
     * @param fila donde queremos insertar el elemento
     * @param columna donde queremos insertar el elemento
     * @param elemento número que queremos insertar en el tablero
     * @throws SudokuException 
     */
    public void modificarElemento(int fila, int columna, int elemento) throws SudokuException  
    {
        if(puedoInsertar(fila, columna, elemento)==true)
        {
            
            array.get(fila-1).set(columna-1, elemento);
            
            
        }
        else
        {
            System.out.println("Error no se puede insertar el número.");
        }
         
    }
    
    /**
     * Pone un elemento vacío
     * @param fila donde está el elemento que queremos que este vacío
     * @param columna donde está el elemento que queremos que este vacío
     */
    public void vaciarElemento(int fila, int columna)
    {
        array.get(fila-1).set(columna-1, 0);
    }

    /**
     * Comprueba que él elemento que introducimos no esté repetido en la misma fila
     * @param fila fila donde introducimos el elemento
     * @param elemento elemento que queremos introducir
     * @return true si se puede introducir y false si no se puede introdudcir
     */
    private boolean comprobarFila(int fila, int elemento) 
    {
        boolean error=true;
        for (int i = 0; i < array.size(); i++) 
        {
            if(array.get(fila-1).get(i)==elemento)
            {
                error=false;
            }
            
        }
        return error;
    }

    /**
     * Comprueba que él elemento que introducimos no esté repetido en la misma columna
     * @param columna donde se encuentra el número que queremos introducir
     * @param elemento que queremos introducir en el tablero
     * @return true si se puede introducir y false si no se puede introdudcir
     */
    private boolean comprobarColumna(int columna, int elemento) 
    {
        boolean error=true;
        for (int i = 0; i < array.size(); i++) 
        {
            for (int j = 0; j < array.size(); j++) 
            {
                if(array.get(i).get(columna-1)==elemento)
                {
                    error=false;
                }
                
            }
            
        }
        
        return error;
    }

    /**
     * Comprueba que en el cuadrante de 3x3 que vamos a introducir el número no esté repetido
     * @param fila donde se encuentra el número
     * @param columna donde se encuentra el número
     * @param elemento que queremos introducir
     * @return true si se puede introducir y false si no se puede introdudcir
     */
    private boolean comprobarCuadrante(int fila, int columna, int elemento) 
    {
        boolean error=true;
        int valorx = 0, valory = 0, terminax = 0, terminay = 0;
        
        int n_cuadrante=0;
        
        if (fila >= 0 && fila <= 2)
        {
            valorx = 0;
            terminax = 2;
           
        }
        else if (fila >= 3 && fila <= 5)
        {
            valorx = 3;
            terminax = 5;
            
        }
        else if (fila >= 6 && fila <= 8)
        {
            valorx = 6;
            terminax = 8;
            
        }
        
        
        if (columna >= 0 && columna <=2)
        {
           valory = 0;
           terminay = 2;
        }
        else if (columna >= 3 && columna <=5)
        {
           valory = 3;
           terminay = 5;
        }
        else if (columna >= 6 && columna <= 8)
        {
           valory = 6;
           terminay = 8;
        }
        
        for (int i = valorx ; i <= terminax; i++)
        {
            for (int j = valory; j <= terminay; j++)
            {
                if (array.get(i).get(j) == elemento)
                {
                    
                    error = false;
                    
                }
                      
            }
        }
        
        
        
        return error;
    }

    /**
     * Comprueba los metodos comprobarFila, comprobarColumna y comprobarCuadrante para ver si podemos insertar el núemro
     * @param fila donde se encuentra el elemento
     * @param columna donde se encuentra el elemento
     * @param elemento que queremos insertar
     * @return true si se puede insertar y false si no se puede insertar
     */
    private boolean puedoInsertar(int fila, int columna, int elemento) 
    {
        boolean resultado = false;
        if(comprobarFila(fila, elemento)==true && comprobarColumna(columna, elemento)==true && comprobarCuadrante(fila, columna, elemento)==true)
        {
            resultado=true;
        }
        return resultado; 
    } 
} 
