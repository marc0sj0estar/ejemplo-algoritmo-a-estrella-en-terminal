package aEstrella;

import java.util.*;

public class laberinto {
	
	int numerosConsideradosObstaculos = 3;
	int amplitudNumerosAleatorios = 10;
    
    nodo init;
    nodo goal;
    nodo[][] nodos;
    int longitudX, longitudY;
    

    public laberinto(int longitudX, int longitudY) {
    	this.longitudX = longitudX;
    	this.longitudY = longitudY;
    	
    	nodos = new nodo[longitudY][longitudX];
    	
    	Random rand = new Random();
    	
    	
    	for (int y = 0; y < longitudY; y++) {
    		for (int x = 0; x < longitudX; x++) {
    			if(rand.nextInt(amplitudNumerosAleatorios) < numerosConsideradosObstaculos)
    			{
    				nodos[y][x] = new nodo(x, y, nodo.type.OBS);
    			}else {
    				nodos[y][x] = new nodo(x, y, nodo.type.REG);
    			}

    		}
		}
    	

    }

    public void fijarInicioFin() {
    	
    	Random rand = new Random();
    	
    	boolean finColocado = false;
    	int xAleatorio;
    	int yAleatorio;
    	
    	
    	xAleatorio = rand.nextInt(longitudX);
		yAleatorio = rand.nextInt(longitudY);
		
		init = nodos[yAleatorio][xAleatorio];
		init.tipo = nodo.type.I; 
		
    	
    	while(!finColocado)	//Para no sobreescribir el incio
    	{					//(poco probable pero puede pasar)
    		xAleatorio = rand.nextInt(longitudX);
    		yAleatorio = rand.nextInt(longitudY);
    		if(nodos[yAleatorio][xAleatorio].tipo != nodo.type.I)
    		{
    			finColocado = true;
    			goal = nodos[yAleatorio][xAleatorio];
    			goal.tipo = nodo.type.G;
    		}
    	}



    }


    //Establece el vecino de cada nodo y su distancia de Manhattan de una pasada por todo el tablero
    public void fijarVecinoYH() {

    	for (int y = 0; y < longitudY; y++) {
    		for (int x = 0; x < longitudX; x++) {
    			
    			//Vecinos
    			List<nodo> listaVecinos = new ArrayList();
    			
    			if(nodos[y][x].y + 1 < longitudY && nodos[y + 1][x].tipo != nodo.type.OBS)
    			{
    				listaVecinos.add(nodos[y + 1][x]);
    			}
    			if(nodos[y][x].y - 1 >= 0 && nodos[y - 1][x].tipo != nodo.type.OBS)
    			{
    				listaVecinos.add(nodos[y - 1][x]);
    			}
    			if(nodos[y][x].x + 1 < longitudX && nodos[y][x + 1].tipo != nodo.type.OBS)
    			{
    				listaVecinos.add(nodos[y][x + 1]);
    			}
    			if(nodos[y][x].x - 1 >= 0 && nodos[y][x - 1].tipo != nodo.type.OBS)
    			{
    				listaVecinos.add(nodos[y][x - 1]);
    			}
    			
    			
    			nodos[y][x].vecinos = listaVecinos;
    			
    			//Fijamos el coste H
    			
    			for (int i = 0; i < longitudY; i++) {
    	    		for (int j = 0; j < longitudX; j++) {
    	    			
    	    			nodos[i][j].h = Math.abs(this.goal.x - i) + Math.abs(this.goal.y - j);
    	    			

    	    		}
    			}


    		}
		}

    }
    
    public String dibujar()
    {
    	String str = "";
    	for (int y = 0; y < longitudY; y++) {
    		for (int x = 0; x < longitudX; x++) {
    			
    			if(nodos[y][x].tipo == nodo.type.REG) {
    				System.out.print(" ");
    				str += " ";
    			}
    			else if(nodos[y][x].tipo == nodo.type.OBS) {
    				System.out.print("*");
    				str += "*";
    			}
    			
    			else if(nodos[y][x].tipo == nodo.type.CAMINO) {
    				System.out.print("+");
    				str += "+";
    			}
    			else if(nodos[y][x].tipo == nodo.type.I) {
    				System.out.print("I");
    				str += "I";
    			}
    			else if(nodos[y][x].tipo == nodo.type.G) {
    				System.out.print("G");
    				str += "G";
    			}
    			

    		}
    		
    		System.out.print("\n");
    		str += "\n";
    		
		}
    	return str;
    }

}