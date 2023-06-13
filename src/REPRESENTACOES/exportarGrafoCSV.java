package REPRESENTACOES;

import ELEMENTOS.Aresta;
import INTERFACE.IGrafo;

import java.io.FileWriter;
import java.io.IOException;

public class exportarGrafoCSV {


    public static void exportarParaCSV(IGrafo grafo){
        grafo :

    }

    public static void exportarListaCSV(ListaAdj grafo, String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            // Escrever cabeçalho do arquivo CSV
            writer.append("Vértice;Aresta\n");

            // Escrever os dados do grafo
            for (int i = 0; i < grafo.getTotalVertices(); i++) {
                for (int j : grafo.adjacencyList.get(i)) {
                    writer.append(String.valueOf(i)).append(';').append(String.valueOf(j)).append('\n');
                }
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exportarMatrizCSV(MatrizAdj grafo, String nomeArquivo) throws IOException {
        FileWriter writer = new FileWriter(nomeArquivo);
        writer.append("Vértices,");
        for (int i = 0; i < grafo.getTotalVertices(); i++) {
            writer.append("V" + i + ",");
        }
        writer.append("\n");

        writer.append("Arestas,");
        for (int i = 0; i < grafo.getTotalVertices(); i++) {
            writer.append(",");
        }
        writer.append("\n");

        for (int i = 0; i < grafo.getTotalVertices(); i++) {
            writer.append("V" + i + ",");
            for (int j = 0; j < grafo.getTotalVertices(); j++) {
                writer.append(grafo.hasAresta(i, j) ? "1," : "0,");
            }
            writer.append("\n");
        }

        writer.flush();
        writer.close();
        System.out.println("Grafo salvo em " + nomeArquivo + " com sucesso!");
    }
}