package Grafo;

public class GrafoDirigido extends Grafo {

	@Override
	public boolean existArista(String _v1, String _v2) {
		for(Arista a  : this.aristas) {
			if(a.getVertice1().getEtiqueta().equals(_v1) && a.getVertice2().getEtiqueta().equals(_v2)){
				return true;
			}
			else if (a.getVertice2().getEtiqueta().equals(_v1) && a.getVertice1().getEtiqueta().equals(_v2)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addArista(String _v1, String _v2, Integer _p) {
		//Compruebo que existan los vertices en el grafo
		if(this.containsVertice(_v1) && this.containsVertice(_v2)) {
			//Compruebo que no exista una arista que una estos 2 vertices
			if(!this.existArista(_v1, _v2)) {
				//Obtengo los vertices
				Vertice v1 = this.getVertice(_v1);
				Vertice v2 = this.getVertice(_v2);
				v1.addAdyacente(v2);
				this.aristas.add(new Arista(v1, v2, _p));
				numA++;
				return true;
			}
			return false;
		}
		return false;
	}
}
