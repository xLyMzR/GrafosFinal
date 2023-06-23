package ELEMENTOS;

import java.lang.reflect.Array;
import java.util.Objects;

public class Aresta {

    /**
     * Vertice A
     */
    private int verticeA;

    /**
     * Vertice B
     */
    private int verticeB;

    /**
     * Peso da aresta
     */
    private int peso;

    /**
     * Rotulo da aresta
     */
    private String rotulo;

    public Aresta(int verticeA, int verticeB){
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.peso = 0;
        this.rotulo = " ";
    }

    public Aresta(int verticeA, int verticeB, boolean direcionada){
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.peso = 0;
        this.rotulo = " ";
    }

    public Aresta(int verticeA, int verticeB, int peso){
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.peso = peso;
        this.rotulo = " ";
    }

    public Aresta(int verticeA, int verticeB, int peso, String rotulo){
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.peso = peso;
        this.rotulo = rotulo;
    }

    /**
     * Obtem o rotulo da aresta
     * @return string
     */
    public String getRotulo() {
        return rotulo;
    }

    /**
     * Obtem o peso da aresta
     * @return int
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Obtem os vertices da aresta
     * @return int
     */
    public int [] getVertices(){
        int vertices[] = new int[2];

        vertices[0] = this.verticeA;
        vertices[1] = this.verticeB;

        return vertices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aresta aresta = (Aresta) o;
        return verticeA == aresta.verticeA && verticeB == aresta.verticeB;
    }

    @Override
    public int hashCode() {
        return Objects.hash((verticeA - verticeB), peso, rotulo);
    }

    @Override
    public String toString() {
        return "Aresta{" +
                "verticeA=" + verticeA +
                ", verticeB=" + verticeB +
                ", peso=" + peso +
                ", rotulo='" + rotulo + '\'' +
                '}';
    }

    /**
     * Obtem o vertice A da aresta
     * @return int
     */
    public int getVerticeA() {
        return verticeA;
    }

    /**
     * Obtem o vertice B da aresta
     * @return int
     */
    public int getVerticeB() {
        return verticeB;
    }

    /**
     * Seta o peso da aresta
     * @param peso
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Seta o rotulo da aresta
     * @param rotulo
     */
    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }
}
