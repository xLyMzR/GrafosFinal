package ELEMENTOS;

import java.lang.reflect.Array;
import java.util.Objects;

public class Aresta {
    private int verticeA;
    private int verticeB;
    private int peso;
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

    public String getRotulo() {
        return rotulo;
    }

    public int getPeso() {
        return peso;
    }
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

    public int getVerticeA() {
        return verticeA;
    }

    public int getVerticeB() {
        return verticeB;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }
}
