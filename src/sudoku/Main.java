/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Scanner;
/**
 *
 * @author Manuel Muñoz Rodríguez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        Scanner teclado= new Scanner(System.in);
        Sudoku s=new Sudoku();
        
        System.out.println("");
        
        int respuesta=0;
        
        
        /**
         * Excepciones que puede tener
         */
        try
        {
            /**
             * Menú del sudoku
             */
            do
            {
                System.out.println("------------------------------------------------------------------------------------------------");
                System.out.println("1. Iniciar/Reiniciar sudoku → Iniciará o reiniciará el sudoku con el que se está \n" +
                "jugando.\n\n" +
                "2. Realizar movimiento → Pedirá las coordenadas de la casilla en la que se \n\n" +
                "quiere poner un número y en el caso de que el número sea válido para esa\n" +
                "casilla se guardará, también habrá que comprobar que en esa casilla no\n" +
                "haya ningún número previamente. \n\n" +
                "3. Vaciar casilla → Pedirá las coordenadas de la casilla de la que se quiere\n" +
                "borrar un número ya existente. \n\n" +
                "4. Mostrar sudoku → Mostrará el sudoku por la pantalla.\n\n" +
                "5. Terminar → Termina la partida.");
                System.out.println("------------------------------------------------------------------------------------------------");
                respuesta=teclado.nextInt();

                /**
                 * Inicio el sudoku
                 */
                if(respuesta==1)
                {
                    s.inicializar();
                }

                /**
                 * Realizo un movimiento
                 */
                else if(respuesta==2)
                {
                    System.out.println("Dime las coordenadas de la casilla en la que quieres poner el número:");
                    System.out.println("Fila: ");
                    int fila=teclado.nextInt();
                    System.out.println("Columna:");
                    int columna=teclado.nextInt();
                    System.out.println("Dime el elemento que quieres insertar:");
                    int elemento=teclado.nextInt();

                    s.modificarElemento(fila, columna, elemento);
                }

                /**
                 * Pongo un elemento vacío
                 */
                else if(respuesta==3)
                {
                    System.out.println("Dime las coordenadas de la casilla que quieres vaciar:");
                    System.out.println("Fila: ");
                    int fila=teclado.nextInt();
                    System.out.println("Columna:");
                    int columna=teclado.nextInt();

                    s.vaciarElemento(fila, columna);
                }

                /**
                 * Muestro el sudoku por pantalla
                 */
                else if(respuesta==4)
                {
                    System.out.println(s.toString());
                }




            }while(respuesta<1 || respuesta>5 || respuesta!=5);

            /**
             * Muestro un mensaje de que he terminado
             */
            if(respuesta==5)
            {
                System.out.println("Has terminado el sudoku");

            }
        }
        catch(Exception error)
        {
            System.out.println("Error--> "+error.toString());
        }
        
        
    }
    
}
