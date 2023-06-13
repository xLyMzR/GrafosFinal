import ELEMENTOS.Aresta;
import INTERFACE.IGrafo;
import REPRESENTACOES.exportarGrafoCSV;
import REPRESENTACOES.ListaAdj;
import REPRESENTACOES.MatrizAdj;

public class App {

    private static final MatrizAdj grafoMatriz = new MatrizAdj(4, true);
    private static final ListaAdj grafoLista = new ListaAdj(4, true);

    private static void PopularGrafo() {
        for (int i = 0; i < grafoLista.getTotalVertices(); i++) {
            for (int j = 1; j < grafoLista.getTotalVertices(); j++) {
                if (i != j) {
                    grafoMatriz.addAresta(i, j);
                    grafoMatriz.addAresta(j, i);

                    grafoLista.addAresta(i, j);
                    grafoLista.addAresta(j, i);
                }
            }
        }
    }

    public static void main(String[] args) {

        PopularGrafo();
        //SeiLa();

        String arquivoListaCSV = "grafoLista.csv";
        String arquivoMatrizCSV = "grafoMatriz.csv";

        exportarGrafoCSV.exportarListaCSV(grafoLista, arquivoListaCSV);
        exportarGrafoCSV.exportarMatrizCSV(grafoMatriz, arquivoMatrizCSV);

        System.out.println("Grafo salvo em " + arquivoListaCSV);
    }

    private static void SeiLa(){
         /*System.out.println(grafoMatriz.isVerticeIncidente(e, 1));
        grafoMatriz.getArestas().stream().map(x -> x.toString()).forEach(System.out::println);*/

        //Buscar aresta / Adjacencia de vertices
        //   System.out.println(grafoMatriz.isVerticesAdjacentes(2 ,1));
        //ystem.out.println(grafoMatriz.isArestasAdjacentes(e, e2));
        System.out.println(grafoLista.isCompleto());
        // grafoMatriz.addAresta(e3.getVerticeA(), e3.getVerticeB());
        // System.out.println("Add aresta 3, Completo?: "+grafoMatriz.isCompleto());
        grafoLista.ponderarAresta(0, 1, 5);
        // grafoMatriz.ponderarAresta(1, 0,10);
        grafoLista.getArestas().stream().map(Aresta::toString).forEach(System.out::println);
        System.out.println(grafoLista.isVerticesAdjacentes(0, 1));// -saida false
        //System.out.println(grafoMatriz.isRegular());
        grafoLista.ponderarAresta(0, 1, 10);
        grafoLista.getArestas().stream().map(Aresta::toString).forEach(System.out::println);
        grafoLista.rotularAresta(0, 1, "teste");
        grafoLista.rotularAresta(1, 0, "teste2");
        System.out.println(grafoLista.getArestas().isEmpty());
        grafoLista.getArestas().stream().map(Aresta::toString).forEach(System.out::println);
        grafoLista.removerAresta(0, 1);
        grafoLista.rotularAresta(1, 0, "Novo rotulo");
        System.out.println("Remoção da aresta 0,1: ");
        grafoLista.getArestas().stream().map(Aresta::toString).forEach(System.out::println);
    }
}
