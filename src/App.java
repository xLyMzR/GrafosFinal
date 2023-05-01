import ELEMENTOS.Aresta;
import ELEMENTOS.Vertice;
import INTERFACE.IGrafo;
import REPRESENTACOES.MatrizAdj;

import javax.swing.*;
import java.awt.font.GraphicAttribute;

public class App {

    private static final IGrafo grafo = new MatrizAdj(3, true);

    public static void main(String[] args) {

        for(int i =0; i<grafo.getTotalVertices(); i++){
            for(int j =1; j<grafo.getTotalVertices(); j++){
                if(i!=j) {
                    grafo.addAresta(i, j);
                    grafo.addAresta(j, i);
                }
                }

        }

        /*System.out.println(grafo.isVerticeIncidente(e, 1));
        grafo.getArestas().stream().map(x -> x.toString()).forEach(System.out::println);*/

        //Buscar aresta / Adjacencia de vertices
     //   System.out.println(grafo.isVerticesAdjacentes(2 ,1));
        //ystem.out.println(grafo.isArestasAdjacentes(e, e2));
        System.out.println(grafo.isCompleto());
       // grafo.addAresta(e3.getVerticeA(), e3.getVerticeB());
       // System.out.println("Add aresta 3, Completo?: "+grafo.isCompleto());
        grafo.ponderarAresta(0, 1, 5);
       // grafo.ponderarAresta(1, 0,10);
        grafo.getArestas().stream().map(Aresta::toString).forEach(System.out::println);
        System.out.println(grafo.isVerticesAdjacentes(0, 1));// -saida false
        //System.out.println(grafo.isRegular());
        grafo.ponderarAresta(0, 1, 10);
        grafo.getArestas().stream().map(Aresta::toString).forEach(System.out::println);
        grafo.rotularAresta(0, 1, "teste");
        grafo.rotularAresta(1, 0 , "teste2");
        System.out.println(grafo.getArestas().isEmpty());
        grafo.getArestas().stream().map(Aresta::toString).forEach(System.out::println);
        grafo.removerAresta(0,1);
        grafo.rotularAresta(1,0, "Novo rotulo");
        System.out.println("Remoção da aresta 0,1: ");
        grafo.getArestas().stream().map(Aresta::toString).forEach(System.out::println);

    }
}
