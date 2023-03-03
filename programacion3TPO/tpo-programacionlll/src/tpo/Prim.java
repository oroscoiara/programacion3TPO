package tpo;

import java.util.*;


public class Prim {
	
	public static void main(String[] args) {
		
		//Creación de grafo con sus nodos y aristas
		GrafoDinamico grafo = new GrafoDinamico();

		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		
		grafo.agregarArista(1, 2, 6);
		grafo.agregarArista(2, 1, 6);
		
		grafo.agregarArista(1, 4, 5); 
		grafo.agregarArista(4, 1, 5);		
		
		grafo.agregarArista(1, 3, 1);
		grafo.agregarArista(3, 1, 1);
		
		grafo.agregarArista(2, 3, 5);
		grafo.agregarArista(3, 2, 5);
		
		grafo.agregarArista(2, 5, 3);
		grafo.agregarArista(5, 2, 3);
		
		grafo.agregarArista(5, 6, 6);
		grafo.agregarArista(6, 5, 6);
		
		grafo.agregarArista(3, 4, 5);
		grafo.agregarArista(4, 3, 5);
		
		grafo.agregarArista(3, 6, 4); 
		grafo.agregarArista(6, 3, 4);
		
		grafo.agregarArista(3, 5, 6); 
		grafo.agregarArista(5, 3, 5);
		
		grafo.agregarArista(4, 6, 2);
		grafo.agregarArista(6, 4, 2);
		
		//Imprimimos el grafo resultante
		System.out.println("***Algoritmo de Prim***" );
		NodoGrafo origen = grafo.encontrarNodo(2);
		System.out.println("Nodo seleccionado como origen: " + origen.valor);
		System.out.println("Resultado al aplicar el algoritmo: ");
		prim(origen).mostrarGrafo();
	}
	
	//Escoger la posición de la arista con el menor costo
	public static int menorArista(ArrayList<NodoArista> array ) {
		int menor = 100;
		int posicion = -1;
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i).peso < menor && !array.get(i).nodoDestino.visitado) {
				menor = array.get(i).peso ; 
				posicion = i;
			}
		}
		return posicion;	
	}
	
	public static GrafoDinamico prim(NodoGrafo nodo) {
		//Enlisto aristas y nodos.
		ArrayList<NodoArista> aristas = new ArrayList<NodoArista>(); 
		ArrayList<NodoGrafo> nodos = new ArrayList<NodoGrafo>();
			
		NodoGrafo auxNodo = nodo;
		NodoArista aux; 
		auxNodo.visitado = true;
		GrafoDinamico grafo = new GrafoDinamico();
		int indice = 0;
		grafo.agregarVertice(nodo.valor);	
		nodos.add(nodo);
		
		while(!nodos.isEmpty()){
				aux = auxNodo.lista;
				while(aux != null) {
					if(!aux.visitado) {
						aristas.add(aux);
						aux.visitado = true;
					}
					aux = aux.sigArista;
				}
				
				indice = menorArista(aristas);
				if(indice != -1) {
					aux = aristas.get(indice);
					grafo.agregarVertice(aux.nodoDestino.valor);
					aux.nodoDestino.visitado = true;
					grafo.agregarArista(aux.origen, aux.nodoDestino.valor, aux.peso);			
					aristas.remove(indice);
					nodos.add(aux.nodoDestino);
					auxNodo = aux.nodoDestino;
				}else {
					return grafo;
				}
				
			}
			return grafo;
		}


}