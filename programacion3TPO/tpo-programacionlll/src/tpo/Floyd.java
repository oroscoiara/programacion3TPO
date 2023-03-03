package tpo;

public class Floyd {

	public static void main(String[] args) {
	
	 //Creo un grafo de 6x6
     int grafo[][] = { { 0, 24, INF, INF, INF, 28 },
                       { 24, 0, 11, INF, INF, INF },
                       { INF, 11, 0, 13, INF, INF },
                       { INF, INF, 13, 0, 20, 12 },
                       { INF, INF, INF, 20, 0, 15 },
                       { 28, INF, INF, 12, 15, 0 },
                       };
     
     Floyd algoritmoFloyd = new Floyd();

     algoritmoFloyd.floydW(grafo);
 	}
	
	final static int INF = 99999, V = 6;

	void floydW(int M[][])
    {
		   		         
        int i, j, k;
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
   
                for (j = 0; j < V; j++) {
                    // Si K está en el medio del camino más corto desde i a j, actualizamos el valor en M[i][j]
                    if (M[i][k] + M[k][j] < M[i][j])
                        M[i][j] = M[i][k] + M[k][j];
                }
            }
        }
 
        // Matriz resultante
        imprimirMatriz(M);
    }
 
    void imprimirMatriz(int M[][])
    {
        System.out.println("***Algoritmo de Floyd***");
		System.out.println("Resultado al aplicar el algoritmo: ");

        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (M[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(M[i][j] + "  ");
            }
            System.out.println();
        }
    }
}