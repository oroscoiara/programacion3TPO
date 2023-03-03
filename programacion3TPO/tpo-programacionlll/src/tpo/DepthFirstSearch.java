package tpo;

import java.util.ArrayList;

public class DepthFirstSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrafoDinamico grafo = new GrafoDinamico();

		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);


		grafo.agregarArista(1, 2, 0);
		grafo.agregarArista(2, 4, 0);
		grafo.agregarArista(4, 3, 0);
		grafo.agregarArista(3, 1, 0);
		grafo.agregarArista(1, 4, 0);
		grafo.agregarArista(5, 4, 0);


		NodoGrafo origen = grafo.encontrarNodo(1);
		
		System.out.println("***Algoritmo de DFS***" );
		System.out.println("Nodo seleccionado como origen: " + origen.valor);
		System.out.println("Resultado al aplicar el algoritmo: ");
		ArrayList<Integer> resultado = dfsGrafo(grafo, origen);

		for (int i = resultado.size() - 1; i >= 0; i--) {
			if (i != 0) {
				System.out.print(resultado.get(i) + " -> ");
			} else {
				System.out.print(resultado.get(i));
			}
		}

	}
	

		public static ArrayList<Integer> dfsGrafo(GrafoDinamico grafo, NodoGrafo origen) {
			ArrayList<Integer> nodos = new ArrayList<Integer>();

			visitarNodo(origen, nodos);
			return nodos;
		}

		public static void visitarNodo(NodoGrafo nodo, ArrayList<Integer> lista) {
			nodo.visitado = true;
			NodoArista aux = nodo.lista;

			while (aux != null) {
				if (!aux.nodoDestino.visitado) {
					visitarNodo(aux.nodoDestino, lista);
				} else {
					aux = aux.sigArista;
				}
			}

			lista.add(nodo.valor);
	}

}
