package Sistema;
import java.util.List;

import Grafo.Grafo;
import Grafo.GrafoDirigido;
import Grafo.GrafoNoDirigido;

public class Test {

	public static void main(String[] args) {
		GrafoDirigido grafo = new GrafoDirigido();
		
		grafo.addVertice("A");
		grafo.addVertice("B");
		grafo.addVertice("C");
		grafo.addVertice("D");
		grafo.addVertice("E");
		grafo.addVertice("F");
//		grafo.addVertice("G");
//		grafo.addVertice("H");
//		grafo.addVertice("I");
		

		grafo.addArista("A", "B");
		grafo.addArista("B", "C");
		grafo.addArista("A", "C");
//		grafo.addArista("D", "E");
//		grafo.addArista("D", "F");

//		grafo.addArista("F", "E");
//		grafo.addArista("8", "5");
//		grafo.addArista("5", "7");
//		grafo.addArista("4", "7");
//		grafo.addArista("2", "6");
		
		System.out.println(grafo.tieneCiclo("A"));
	}
}
