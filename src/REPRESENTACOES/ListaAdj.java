package REPRESENTACOES;

import ELEMENTOS.Aresta;
import ELEMENTOS.Vertice;
import INTERFACE.IGrafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ListaAdj implements IGrafo {

    private int numTotalVertices;
    private int numTotalArestas;
    private boolean isCompleto;
    private final boolean isDirecionado;
    private final List<List<Integer>> adjacencyList;
    private final HashMap<Integer, Vertice> mapaVertices;
    private final HashSet<Aresta> arestas;

    public ListaAdj(int i, boolean isDirecionado) {
        numTotalArestas = 0;
        numTotalVertices = 0;
        this.isDirecionado = isDirecionado;
        mapaVertices = new HashMap<>();
        arestas = new HashSet<>();
        this.adjacencyList = new ArrayList<>(i);
        inicializarVertices(i);
    }

    private void inicializarVertices(int total) {
        for (int i = 0; i < total; i++) {
            Vertice nv = new Vertice();

            mapaVertices.put(numTotalVertices, nv);

            numTotalVertices++;
            adjacencyList.add(new ArrayList<>());
        }
    }

    @Override
    public void addAresta(int v1, int v2) {
        if (v1 >= numTotalVertices || v2 >= numTotalVertices) {
            return;
        }

        Aresta nE = new Aresta(v1, v2);

        if (!isDirecionado) {
            // Adicionar a aresta em grafos não-direcionados
            Aresta nEInv = new Aresta(v2, v1);
            if (!arestas.contains(nE) && !arestas.contains(nEInv)) {
                arestas.add(nE);
                adjacencyList.get(v1).add(v2);
                adjacencyList.get(v2).add(v1);
                numTotalArestas++;
            }
        } else {
            // Adicionar a aresta em grafos direcionados
            if (!arestas.contains(nE)) {
                arestas.add(nE);
                adjacencyList.get(v1).add(v2);
                numTotalArestas++;
            }
        }
    }

    @Override
    public boolean isCompleto() {
        if (isCompleto) {
            return true;
        }
        if (isDirecionado()) {
            // Se o grafo é direcionado, verifica se todos os vértices possuem aresta de entrada e de saída
            int j = 0;
            for (Vertice v1 : mapaVertices.values()) {
                int i = 0;
                for (Vertice v2 : mapaVertices.values()) {
                    if (v1 != v2) {
                        if (!hasAresta(j, i) || !hasAresta(j, i)) {
                            return false; // Se algum par de vértices não possuir as duas arestas, o grafo não é completo
                        }
                    }
                    i++;
                }
                j++;
            }
            this.isCompleto = true;
            return true; // Se todos os pares de vértices possuírem as duas arestas, o grafo é completo
        } else {
            // Se o grafo é não-direcionado, verifica se todos os vértices possuem arestas com todos os outros vértices
            int numVertices = mapaVertices.size();
            int numArestas = arestas.size();
            int numArestasEsperadas = numVertices * (numVertices - 1) / 2;
            boolean completo = numArestas == numArestasEsperadas; // Se o número de arestas é igual ao número esperado, o grafo é completo
            this.isCompleto = completo;
            return completo;
        }
    }

    @Override
    public boolean isDirecionado() {
        return this.isDirecionado;
    }

    @Override
    public int getTotalVertices() {
        return numTotalVertices;
    }

    @Override
    public int getTotalArestas() {
        return numTotalArestas;
    }

    @Override
    public boolean hasAresta(int v1, int v2) {
        try {

            if (isDirecionado) {
                return adjacencyList.get(v1).contains(v2);
            }

            return adjacencyList.get(v1).contains(v2) || adjacencyList.get(v2).contains(v1);

        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public boolean hasVertice(int v) {
        return mapaVertices.containsKey(v);
    }

    @Override
    public void ponderarVertice(int v, int peso) {
        // verifica se o vértice existe no grafo
        if (!mapaVertices.containsKey(v)) {
            throw new IllegalArgumentException("O vértice " + v + " não existe no grafo.");
        }
        // atualiza o peso do vértice
        mapaVertices.get(v).setPeso(peso);
    }

    @Override
    public void ponderarAresta(int va, int vb, int peso) {
        // Verifica se o grafo é direcionado ou não
        Aresta arestaDireta = new Aresta(va, vb);

        if (isDirecionado()) {
            // Se o grafo é direcionado, basta atualizar o peso da aresta direta (se ela existir)
            if (arestas.contains(arestaDireta)) {
                arestas.stream().filter(a -> a.equals(arestaDireta)).findFirst().ifPresent(a -> a.setPeso(peso));
            } else {
                System.out.println("Aresta " + arestaDireta + " não encontrada no grafo!");
            }
        } else {
            // Se o grafo é não-direcionado, é preciso atualizar o peso em ambas as direções caso existir.
            Aresta arestaInversa = new Aresta(vb, va);
            boolean encontrouDireta = false;
            boolean encontrouInversa = false;
            for (Aresta a : arestas) {
                if (a.equals(arestaDireta)) {
                    a.setPeso(peso);
                    encontrouDireta = true;
                }
                if (a.equals(arestaInversa)) {
                    a.setPeso(peso);
                    encontrouInversa = true;
                }
                if (encontrouDireta && encontrouInversa) {
                    break;
                }
            }
            if (!encontrouDireta && !encontrouInversa) {
                System.out.println("Aresta " + " não encontrada no grafo!");
            }
        }
    }

    @Override
    public void rotularVertice(int v, String rotulo) {
        // verifica se o vértice existe no grafo
        if (!mapaVertices.containsKey(v)) {
            throw new IllegalArgumentException("O vértice " + v + " não existe no grafo.");
        }
        // atualiza o peso do vértice
        mapaVertices.get(v).setRotulo(rotulo);
    }

    @Override
    public void rotularAresta(int va, int vb, String rotulo) {
        // Verifica se o grafo é direcionado ou não
        Aresta arestaDireta = new Aresta(va, vb);
        if (isDirecionado()) {
            // Se o grafo é direcionado, basta atualizar o peso da aresta direta (se ela existir)
            if (arestas.contains(arestaDireta)) {
                arestas.stream().filter(a -> a.equals(arestaDireta)).findFirst().ifPresent(a -> a.setRotulo(rotulo));
            } else {
                System.out.println("Aresta " + arestaDireta + " não encontrada no grafo!");
            }
        } else {
            // Se o grafo é não-direcionado, é preciso atualizar o peso em ambas as direções caso existir.
            Aresta arestaInversa = new Aresta(vb, va);
            boolean encontrouDireta = false;
            boolean encontrouInversa = false;
            for (Aresta a : arestas) {
                if (a.equals(arestaDireta)) {
                    a.setRotulo(rotulo);
                    encontrouDireta = true;
                }
                if (a.equals(arestaInversa)) {
                    a.setRotulo(rotulo);
                    encontrouInversa = true;
                }
                if (encontrouDireta && encontrouInversa) {
                    break;
                }
            }
            if (!encontrouDireta && !encontrouInversa) {
                System.out.println("Aresta " + " não encontrada no grafo!");
            }
        }
    }

    @Override
    public void removerAresta(int va, int vB) {
        try {
            if (isDirecionado()) {
                adjacencyList.get(va).remove(vB);
                arestas.remove(new Aresta(va, vB));
                return;
            }

            adjacencyList.get(va).remove(vB);
            adjacencyList.get(vB).remove(va);

            this.arestas.remove(new Aresta(va, vB));
            numTotalArestas--;

        } catch (IndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Aresta não existe");
        }
    }

    @Override
    public boolean isVerticesAdjacentes(int v1, int v2) {
        if (this.isDirecionado) {
            return adjacencyList.get(v1).contains(v2);
        } else {
            return adjacencyList.get(v1).contains(v2) || adjacencyList.get(v2).contains(v1);
        }
    }

    @Override
    public boolean isArestasAdjacentes(Aresta a, Aresta b) {
        int v1 = a.getVerticeA();
        int v2 = a.getVerticeB();
        int w1 = b.getVerticeA();
        int w2 = b.getVerticeB();
        boolean adjV1W1 = isVerticesAdjacentes(v1, w1);
        boolean adjV1W2 = isVerticesAdjacentes(v1, w2);
        boolean adjV2W1 = isVerticesAdjacentes(v2, w1);
        boolean adjV2W2 = isVerticesAdjacentes(v2, w2);
        return (adjV1W1 && adjV2W2) || (adjV1W2 && adjV2W1);
    }

    @Override
    public boolean isVerticeIncidente(Aresta e, int v) {
        if (!this.isDirecionado) {
            System.out.println("Método disponivel somente em grafos direcionados");
            return false;
        }
        for (Aresta x : arestas) {
            if (x.equals(e)) {
                if (e.getVerticeB() == x.getVerticeB()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isRegular() {
        int grau = -1; // inicializa o grau com -1 para o primeiro vértice encontrado
        for (int i = 0; i < numTotalVertices; i++) {
            int grauAtual = 0;
            // Calcula o grau do vértice atual
            for (int j = 0; j < numTotalVertices; j++) {
                int finalI = i;
                int finalJ = j;
                grauAtual += isDirecionado() ? (int) arestas.stream().filter(a -> a.getVerticeA() == finalI && a.getVerticeB() == finalJ).count() : isVerticesAdjacentes(i, j) ? 1 : 0;
            }
            // Verifica se o grau atual é igual ao grau do primeiro vértice encontrado
            if (grau == -1) {
                grau = grauAtual;
            } else if (grau != grauAtual) {
                return false;
            }
        }
        return true;
    }

    @Override
    public HashSet<Aresta> getArestas() {
        return arestas;
    }
}
