package INTERFACE;

import ELEMENTOS.Aresta;

import java.util.HashSet;

public interface IGrafo {

     void addAresta(int v1, int v2);

     boolean isCompleto();
     boolean isDirecionado();

     int getTotalVertices();
     int getTotalArestas();
     public boolean hasAresta(int v1, int v2);
     boolean hasVertice(int v);

     void ponderarVertice(int v, int peso);
     void ponderarAresta(int va, int vb, int peso);

     void rotularVertice(int v, String rotulo);

     void rotularAresta(int a, int b, String rotulo);

     void removerAresta(int va, int vB);

     boolean isVerticesAdjacentes(int v1, int v2);
     boolean isArestasAdjacentes(Aresta a, Aresta b);

     public boolean isVerticeIncidente(Aresta e, int v);
     public boolean isRegular();
     public HashSet<Aresta> getArestas();
}
