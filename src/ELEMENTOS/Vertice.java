package ELEMENTOS;

public class Vertice {

    /**
     * Rotulo do vertice
     */
    private String rotulo;

    /**
     * Peso do vertice
     */
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

    /**
     *  Obtem o peso do vertice
     * @return int
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Obtem o rotulo do vertice
     * @return
     */
    public String getRotulo() {
        return rotulo;
    }

    /**
     * Seta o peso do vertice
     * @param peso
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Seta o rotulo do vertice
     * @param rotulo
     */
    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }


}
