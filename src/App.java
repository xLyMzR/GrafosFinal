import ELEMENTOS.Aresta;
import ELEMENTOS.Vertice;
import INTERFACE.IGrafo;
import REPRESENTACOES.MatrizAdj;

import javax.swing.*;
import java.awt.font.GraphicAttribute;

public class App {

    private static IGrafo grafo = new MatrizAdj(2, true);

    public static void main(String[] args) {
        Aresta e = new Aresta(1, 0);
        Aresta e2 = new Aresta(0, 1);;
//        Add arestas ao Grafo
        grafo.addAresta(e.getVerticeA(), e.getVerticeB());
        grafo.addAresta(e2.getVerticeA(), e2.getVerticeB());

        System.out.println(grafo.isVerticeIncidente(e, 1));
        grafo.getArestas().stream().map(x -> x.toString()).forEach(System.out::println);

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
