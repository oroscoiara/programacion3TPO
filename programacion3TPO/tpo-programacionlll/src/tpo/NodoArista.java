package tpo;

//La interfaz Comparable permite comparar dos aristas y decidir cual tiene mayor peso
public class NodoArista implements Comparable<NodoArista> {
		NodoArista sigArista;
		int peso;
		NodoGrafo nodoDestino;
		boolean visitado;
		int origen;

		public int compareTo(NodoArista aux) {
			if (this.peso < aux.peso) {
				return -1;
			} else if (this.peso > aux.peso) {
				return 1;
			} else {
				return 0;
			}
		}
}

