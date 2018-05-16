package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public abstract class Grafo {
	protected Integer numV;
	protected Integer numA;
	List<Vertice>vertices;
	List<Arista>aristas;

	public Grafo() {
		this.vertices = new ArrayList<Vertice>();
		this.aristas = new ArrayList<Arista>();
		this.numA = 0;
		this.numV = 0;
	}

	public abstract boolean existArista(String _v1, String _v2);

	//Las aristas se añaden referenciando las etiquetas de los vertices existentes en el grafo
	public abstract boolean addArista(String _v1, String _v2, Integer _p);
	
	//Agrega un vertice al grafo, (Data, etiqueta);
	public boolean addVertice(String _e) {
		//Si no existe el vertice lo agrego
		for(Vertice v : this.vertices) {
			if(v.getEtiqueta().equals(_e)) {
				return false;
			}
		}
		this.vertices.add(new Vertice(_e));
		numV++;
		return true;
	}

	//Añade una arista con el peso deffault
	public boolean addArista(String _v1, String _v2) {
		return this.addArista(_v1, _v2, 1);
	}

	//Retorna TRUE si la etiqueta esta contenida en la lista de vertices
	public boolean containsVertice(String _e) {
		for(Vertice v : this.vertices) {
			if(v.getEtiqueta().equals(_e)) {
				return true;
			}
		}
		return false;
	}

	//Retorna un vertice que contenga X etiqueta, si no existe lo crea
	protected Vertice getVertice(String _e) {
		for(Vertice v : this.vertices) {
			if(v.getEtiqueta().equals(_e)) {
				return v;
			}
		}
		return null;
	}
	
	//Comienza el rercorrido DFS desde el inicio dado
	public List<String> DFS (String _e) {
		Vertice inicio = this.getVertice(_e);
		if(inicio==null) {
			List<String>error = new ArrayList<>();
			error.add("Vertice inexistente");
			return error;
		}
		Boolean[]visitados = new Boolean[this.vertices.size()];
		for(int i=0 ; i<visitados.length ; i++) {
			visitados[i] = false;
		}
		visitados[this.vertices.indexOf(inicio)] = true;
		
		return DFS_Visitar(inicio, visitados);
	}
	
	private List<String> DFS_Visitar(Vertice _v, Boolean[] _vi){
		List<String>retorno = new ArrayList<String>();
		//Obtengo los vertices adyacentes al actual
		List<Vertice> adyacentes = _v.getAdyacentes();
		System.out.println("Adyacentes de: " + _v.getEtiqueta());
		for(Boolean b : _vi) {
			System.out.print(b + "\t");
		}
		System.out.println("\n");
		//Recorro la lista de adyacentes
		for(Vertice v : adyacentes) {
			if(!_vi[this.vertices.indexOf(v)]) {
				_vi[this.vertices.indexOf(v)] = true;
				retorno.addAll(DFS_Visitar(v, _vi));
			}
		}
		
		retorno.add(_v.getEtiqueta());
		
		return retorno;
	}
	
	//Metodo auxiliar para comenzar el recorrido BFS desde un vertice dado
	public List<String> BFS(String _e){
		Vertice inicio = this.getVertice(_e);
		if(inicio==null) {
			List<String>error = new ArrayList<>();
			error.add("Vertice inexistente");
			return error;
		}
		
		return BFS_Visitar(inicio);
	}
	
	//Comienza el recorrido BFS
	private List<String> BFS_Visitar(Vertice _v){
		List<String>retorno = new ArrayList<String>();
		Queue<Vertice>cola = new LinkedList<Vertice>();
		Boolean[]visitados = new Boolean[this.vertices.size()];
		for(int i = 0; i<visitados.length ; i++) {
			visitados[i] = false;
		}
		visitados[this.vertices.indexOf(_v)] = true;
		cola.add(_v);
		
		while(!cola.isEmpty()) {
			Vertice v_actual = cola.remove();
			retorno.add(v_actual.getEtiqueta());
			List<Vertice>adyacentes = v_actual.getAdyacentes();
			
			for(Vertice v_adyacente : adyacentes) {
				if(v_adyacente !=null && !visitados[this.vertices.indexOf(v_adyacente)]) {
					cola.add(v_adyacente);
					visitados[this.vertices.indexOf(v_adyacente)] = true;
				}
			}
		}
		
		return retorno;
		
	}

	public Integer numVertices() {
		return this.numV;
	}

	public Integer numAristas() {
		return this.numA;
	}
}
