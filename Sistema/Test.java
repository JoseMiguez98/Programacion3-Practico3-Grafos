package Sistema;
import java.util.List;

import Grafo.Grafo;
import Grafo.GrafoDirigido;
import Grafo.GrafoNoDirigido;

public class Test {

	public static void main(String[] args) {
		Grafo grafo = new GrafoDirigido();
		
		grafo.addVertice("0");
		grafo.addVertice("1");
		grafo.addVertice("2");
		grafo.addVertice("3");
		grafo.addVertice("4");
		grafo.addVertice("5");
		grafo.addVertice("6");
		grafo.addVertice("7");
		grafo.addVertice("8");
		

		grafo.addArista("0", "2");
		grafo.addArista("0", "3");
		grafo.addArista("0", "8");
		grafo.addArista("8", "1");
		grafo.addArista("1", "4");
		grafo.addArista("8", "4");
		grafo.addArista("8", "5");
		grafo.addArista("5", "7");
		grafo.addArista("4", "7");
		grafo.addArista("2", "6");
		
		List<String>dfs = grafo.BFS("0");
		
		for(String s : dfs) {
			System.out.print(s + "\t");
		}
	}
}
