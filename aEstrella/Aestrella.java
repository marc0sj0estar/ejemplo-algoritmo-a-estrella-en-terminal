package aEstrella;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Aestrella {
	int tamX = 100;
	int tamY = 30;
    laberinto lab;
    List<nodo> abiertos = new ArrayList<>();
    List<nodo> cerrados = new ArrayList<>();
    nodo current;
    int seHaAlcanzadoG = -1;
    public Aestrella(){

        lab = new laberinto(tamX, tamY);

        lab.fijarInicioFin();
        
        
        lab.fijarVecinoYH();

        lab.init.g = 0 ;
        lab.init.f = lab.init.g + lab.init.h;
        lab.init.visto = true;
        
        abiertos.add(lab.init);

        
        
        
        while(!abiertos.isEmpty()) {

            nodo current = obtenerMenorNodo();
            
            if(current.tipo == nodo.type.G) {
            	//Consigue alcanzar la meta
            	CambiarNodosCamino(current);
            	seHaAlcanzadoG = 1;
            }
            
            abiertos.remove(current);
            cerrados.add(current);
            
            for (nodo nodoVecino : current.vecinos) {
				if(cerrados.contains(nodoVecino)) 
				{
					continue;
				}
				
				int gSiguiente = current.g + 1;
				if(!abiertos.contains(nodoVecino) || gSiguiente<current.g)
				{
					nodoVecino.padre = current;
					nodoVecino.g = gSiguiente;
					nodoVecino.f = nodoVecino.g + nodoVecino.h;
					if(!abiertos.contains(nodoVecino))
					{
						abiertos.add(nodoVecino);
					}
					
				}
				
			}

        }
        
        if(seHaAlcanzadoG == -1)
        {
        	System.out.println("ERROR: No existe una ruta entre I y G");
        }
        String str = lab.dibujar();
        GuardarArchivo(str);

    }

    private nodo obtenerMenorNodo() {

        nodo menor = abiertos.get(0);

        for(int i = 1; i< abiertos.size(); i++){
        	
            if(abiertos.get(i).f < menor.f) {
                menor = abiertos.get(i);
            }
        }
        return menor;
    }
    
    private void CambiarNodosCamino(nodo nodoCamino)
    {
    	if(nodoCamino != null)
    	{
    		if(nodoCamino.tipo!= nodo.type.I && nodoCamino.tipo != nodo.type.G)
    		{
    			nodoCamino.tipo = nodo.type.CAMINO;
    		}
    		CambiarNodosCamino(nodoCamino.padre);    		
    	}
    }
    
    private void GuardarArchivo(String str)
    {

  
    	try {
    	      FileWriter myWriter = new FileWriter("salida.txt");
    	      myWriter.write(str);
    	      myWriter.close();
    	    } catch (IOException e) {
    	      System.out.println("No se puede crear salida.txt");
    	      e.printStackTrace();
    	    }
    	    

    }


}