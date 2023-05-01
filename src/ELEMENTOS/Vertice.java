package ELEMENTOS;

public class Vertice {
    private String rotulo;
    private int peso;

    public Vertice(){
        this.peso = 0;
        this.rotulo ="";
    }
    public Vertice(int peso){
        this.peso = peso;
    }
    public Vertice(int peso, String rotulo){
        this.peso = peso;
        this.rotulo = rotulo;
    }

    public int getPeso() {
        return peso;
    }

    public String getRotulo() {
        return rotulo;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }


}
