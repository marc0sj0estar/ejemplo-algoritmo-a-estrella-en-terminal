# ejemplo-algoritmo-a-estrella-en-terminal
Este código genera un laberinto en la terminal e intenta obtener un camino entre dos puntos (Un punto inicial "I" y un punto final "G") usando el algoritmo A*.
Cuando consigue obtener un camino lo marcará y mostrará en la terminal.

### Leyenda
| Símbolo  | Significado |
| :---:    | :---  |
| I        | Punto inicial |
| G        | Punto final |
| *        | Obstáculo |
| +        | Camino |

## Como usar 
1. Colocar el paquete en un entorno de desarrollo que pueda iniciar java (Por ejemplo en la carpeta src de eclipse).
2. Ejecutar el archivo main.
3. Cuando se ejecuta el archivo se mostrará por la terminal el resultado.

## Como variar los parametros
Para cambiar el tamaño del laberinto en el archivo Aestrella en la linea 8:

```
int tamX = 60;
int tamY = 80;
```

La cantidad de obstaculos esta generada usando un generador de números aleatorios.
Para cambiarlo se debe cambiar la amplitud de números generados y la cantidad de estos números que se consideran obstaculos en el script obstaculos:

```
int numerosConsideradosObstaculos = 3;
int amplitudNumerosAleatorios = 9;
```

Por predeterminado 3 de cada 9 casillas serán obstaculos.

> [!CAUTION]
> Si se colocan demasiados obstaculos es posible de que no exista camino entre los dos puntos (Suele  ocurrir cuando hay mas de 30% de obstaculos).
> 
> En el caso de que esto ocurra aparecera el mensaje "ERROR: No existe una ruta entre I y G" y se debera ejecutar de nuevo el programa.

## Ejemplos de resultados


### Laberinto de tamaño 80 x 20 y un 20% de obstaculos
```
    *    *   *                 *       *   *                        **** * *  * 
 *                *      ***            *  *               *           **    *  
   I* *     *            * *    *    **   *  ****   * * *        *    **        
   +          *              * *  ***  **     *  * *    ***               * *   
*  +++++++++  *  **     ***   **   *  *        **   **     **               *  *
* *  * * **++++++++++++++++++++++++++      * *   * *   **  *        *   ***    *
          *         *      *     ***++++++     *  * *   * ** *    *  * *  *     
         *      *    *   *  *  *     * **+     *       * *  *        *    *   * 
  *  *    *  ***   *       * *  *      * +      *    *                      * * 
* *       *  *                 * *   * * +++ *   ** *       **   *   **  *      
   *         *      *   *    *    *      **+  ****    * *         *  **  *  *  *
              *   **                  *  **+   ** ** **    * *  *               
    *     *   *       **    **  ***    *  *+++++++        * *   * *             
*   *           *   *        * *     *   **     *++ * ** *          *    *     *
  *  **           *   *     *      * *      ***  *+    *          *  *  *       
**    *     *               *       *        *** *++++++G*                   ** 
   *   *               * **  *   *      **      *  ***             *     * *    
   *  *      *  *    * *    * * *    *   *   *   *    * *    *  **   *  *       
*         ****       *  *          *  *    *  *    *    *         *     **  *   
  *   *  *   *    *  *  * *  *   * *           * *     ** *  ** * * *     *    *

```
### Laberinto de tamaño 100 x 30 con un 30% de obstaculos
```
  * *   ***   *   *****     * **   *         **           * *  *   **  **     *    *   ****       **
   *       *       * *     *  *     *   *           *   **    *       *        *          *  *  *   
* **  *   *  ***  *           **    *++++++++++++*  ** *       ** **  *        **      * *      *** 
***   * ** * *  ***  * **** **      *+**** *   *+ *  ***     *  *   ****        **     *   *        
***     ** *   *      *        *     +  *     *++ * *  *****  **   *** *   *  *  * *  *   * *      *
  * *   **  *  * ***  **    **   **+++*      **+*   *   **  *    * ** ** *  *     *** * **     *    
*     * *   * *   *  *    *        +**   *  *  +** *                    ***  *        *        *    
  *  *        *  *           ** *  +** *   *   + **+++* **     *      *** *  ** *     **** **   *   
    *     ** *    * *  *   * * *   + ** * * ** +++++*+    *   ***       **  *    *    * *    *  *   
    **         *  *  * * **  *  *  +***** ** *  * ** +  **  * **  **    ** *      *   * *  * **  *  
  **    **      *  ** * *  *  *    +*   **   *   **  +**   **  * *    *    *    * * *               
    * *    *  *    * ** * ** *++++++* * ** **  ** *  +  * *      **       *  *     * ** **          
 *    *  * * *      *    * ** +* * * **    *  * *    ++      * *  ****        * ** *    *       *   
*  *        *** *         *   +**    * *  *    * ** **+ *   *  * *    ***    * ** *    *   *** *    
 **   *    * *  ** *   **    G+ *   *    ** *** *     + *  *  *  *      *    *    *   * *  * *  *   
 *         *   ***       * *      ** *   ***   *      ++  ****       ***  *  *      * *      * **** 
 ***   *     *          * **   * ***    ***    ********++  *      **    **  *      *  ***        *  
 *  **  ****   *   ** *   *  *    *     *  *   ** *  * *+  ***      *      *   *     *  *  * * *   *
 *   **  *    ** *** *****     **   *  * * *  **  *     ++++++        * * ** **     **    *        *
  *      *    **     * * *   *       * *   *  ** *      *   *+++++      ** ** +++ * *         * ** *
 *  * *   *      *   **         * * *   *        * **  *    *   *++++++++++* ++*+++++*   *      ****
*   *  **   **   *     *       *   *  ***           *  *     *  * *  *  **++++**  **++++ *    **    
     *     * **  * *   ** *             *** *  * *  *   * *   * ** *  *   ***   ***** *++ *   * *  *
       ** * *  * * ** ** *   *    * *     ** ***     *         **  **        * *      **+   *  **   
*             **        ** *  *     **  *  * * *  *  *    *       * ** *  ******  *   * +    * ** * 
 *    **        * *  **  **  *  **      * *      *  *  *   *    *    **       * * *  ** +++    **   
   *     **     *   *   *   *  *  *  * *  *** *            *   * *  ***    *  **   *     *++++***   
* *   ***   *     *      **   **  *     ***          ** ******        * *        *   ** *   *I  **  
* * *   *   *      * * **          **    *** **   ***   ***   ***** * * *       * *   *    *        
   * **  *     *    **  ** *  * **   *      * ***   *   *    *        *    * * * * *     ***    * * 
```
