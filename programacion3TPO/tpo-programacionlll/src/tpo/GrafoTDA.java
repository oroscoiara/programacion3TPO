package tpo;

public interface GrafoTDA {

	public void agregarVertice(int v);
	public void agregarArista(int v1, int v2, int peso);
	public int pesoArista(int v1, int v2);
	public void mostrarGrafo();
	public void eliminarArista(int v1, int v2);
	public void inicializarGrafo();
	public int[] adyacentes(int v);
	public int [] vertices();
	public boolean pertenece(int x);
	public int[] dephtFirstSearch();	
}
