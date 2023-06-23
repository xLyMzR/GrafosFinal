package INTERFACE;

import ELEMENTOS.Aresta;

import java.util.HashSet;
import java.util.List;

public interface IGrafo {

     /**
      * Adiciona uma arasta no grafo
      * @param v1 Grafo 1
      * @param v2 Grafo 2
      */
     void addAresta(int v1, int v2);

     /**
      * Verifica se o grafo e completo
      * @return bool
      */
     boolean isCompleto();

     /**
      * Verifica se o grafo e direcionado
      * @return bool
      */
     boolean isDirecionado();

     /**
      * Obtem o numero total de vertice do grafo
      * @return numero de vertice
      */
     int getTotalVertices();

     /**
      * Obtem o numero total de arestas do grafo
      * @return
      */
     int getTotalArestas();

     /**
      * Verifica se existe uma arestas conectando um vertice a outro
      * @param v1 Vertice 1
      * @param v2 Vertice 2
      * @return bool
      */
     public boolean hasAresta(int v1, int v2);

     /**
      * Verifica se existe um vertice
      * @param v vertice
      * @return bool
      */
     boolean hasVertice(int v);

     /**
      * Pondera um vertice com um peso especifico
      * @param v Vertice
      * @param peso Peso
      */
     void ponderarVertice(int v, int peso);

     /**
      * Pondera uma aresta com um peso especifico
      * @param va
      * @param vb
      * @param peso
      */
     void ponderarAresta(int va, int vb, int peso);

     /**
      * Rotula um vertice
      * @param v Vertice
      * @param rotulo Rotulo
      */
     void rotularVertice(int v, String rotulo);

     /**
      *Rotula uma aresta
      * @param a Vertice 1
      * @param b Vertice 2
      * @param rotulo Rotulo
      */
     void rotularAresta(int a, int b, String rotulo);

     /**
      * Remove uma aresta especifica
      * @param va Vertice 1
      * @param vB Vertice 2
      */
     void removerAresta(int va, int vB);

     /**
      * Verifica se um vertice e adjacente a outro
      * @param v1 Vertice 1
      * @param v2 Vertice 2
      * @return bool
      */
     boolean isVerticesAdjacentes(int v1, int v2);

     /**
      *Verifica se uma aresta e adjacente a outra
      * @param a Aresta 1
      * @param b Aresta 2
      * @return
      */
     boolean isArestasAdjacentes(Aresta a, Aresta b);

     /**
      * Verifica se um vertice e incidente
      * @param e Aresta
      * @param v Vertice
      * @return
      */
     public boolean isVerticeIncidente(Aresta e, int v);

     /**
      * Verifica se o grafo e regular
      * @return
      */
     public boolean isRegular();

     /**
      * Obtem as arestas do grafo
      * @return Hashset com arestas
      */
     public HashSet<Aresta> getArestas();
}
