package tpo;

import apis.ConjuntoTDA;
import apis.GrafoTDA;
import impl.ConjuntoLD;
import impl.Nodo;

public class GrafoDinamico implements GrafoTDA {
	
	NodoGrafo nodo;
	int cantidad;
	
	public void agregarVertice(int v) {
		if (this.encontrarNodo(v) == null) {

			NodoGrafo aux = new NodoGrafo();
			aux.valor = v;
			aux.lista = null;
			aux.sigNodo = nodo;
			aux.visitado = false;
			aux.marcado = false;
			nodo = aux;
			cantidad++;
		}

	}

	public void agregarArista(int v1, int v2, int peso) {
		if (this.encontrarNodo(v1) != null && this.encontrarNodo(v2) != null) {
			NodoArista aux = new NodoArista();
			aux.origen = v1;
			aux.peso = peso;
			aux.visitado = false;
			aux.nodoDestino = this.encontrarNodo(v2);
			aux.sigArista = encontrarNodo(v1).lista;
			encontrarNodo(v1).lista = aux;
		} else {
			System.out.println("Alguno de esos nodos no existe");
		}
	}

	public void mostrarGrafo() {
		NodoGrafo aux = nodo;
		NodoArista arista;
		while (aux != null) {
			System.out.print(" Nodo Origen: " + aux.valor + " -> ");
			arista = aux.lista;
			while (arista != null) {

				System.out.print("Peso de la arista: " + arista.peso + " -> " + "Para el Nodo Destino: " + arista.nodoDestino.valor + "\t");
				arista = arista.sigArista;
			}
			System.out.println();
			aux = aux.sigNodo;
		}
	}

	
	
	public NodoGrafo encontrarNodo(int v) {
		NodoGrafo aux = nodo;
		while (aux != null) {
			if (aux.valor == v) {
				return aux;
			}
			aux = aux.sigNodo;
		}
		return null;
	}

	@Override
	public void eliminarArista(int arg0, int arg1) {		
	}

	@Override
	public void eliminarVertice(int arg0) {		
	}

	@Override
	public boolean existeArista(int arg0, int arg1) {
		return false;
	}

	@Override
	public void inicializarGrafo() {		
	}

	@Override
	public int pesoArista(int arg0, int arg1) {
		return 0;
	}

	@Override
	public ConjuntoTDA vertices() {
		return null;
	}
}