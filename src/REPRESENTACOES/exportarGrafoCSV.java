package REPRESENTACOES;

import ELEMENTOS.Aresta;
import INTERFACE.IGrafo;

import java.io.FileWriter;
import java.io.IOException;

public class exportarGrafoCSV {

    /**
     * Exporta o grafo em lista de adjacencia recebido como parametro para arquivo CSV
     * @param grafo
     * @param nomeArquivo
     */
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

    /**
     * Exporta o grafo em matriz de adjacencia recebido como parametro para arquivo CSV
     * @param grafo
     * @param nomeArquivo
     */
    public static void exportarMatrizCSV(MatrizAdj grafo, String nomeArquivo) {
        try {
            FileWriter writer = new FileWriter(nomeArquivo);

            // Escrever os cabeçalhos das colunas

            writer.append(" X|");
            for (int i = 0; i < grafo.getTotalVertices(); i++) {
                writer.append("V" + i + "|");
            }
            writer.append("\n");

            // Escrever as linhas do grafo
            for (int i = 0; i < grafo.getTotalVertices(); i++) {
                writer.append("V" + i + "|");
                for (int j = 0; j < grafo.getTotalVertices(); j++) {
                    writer.append(grafo.hasAresta(i, j) ? " 1|" : " 0|");
                }
                writer.append("\n");
            }

            writer.flush();
            writer.close();
            System.out.println("Grafo salvo em " + nomeArquivo + " com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo CSV.");
            e.printStackTrace();
        }
    }
}