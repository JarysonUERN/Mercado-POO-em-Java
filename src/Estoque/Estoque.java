package Estoque;
import com.fasterxml.jackson.databind.ObjectMapper.*;

import produto.Produto;

import com.fasterxml.jackson.core.type.TypeReference.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;
    private static final String FILE_PATH = "Jsons-Controller/estoque.json"; // Caminho relativo para o arquivo JSON

    public Estoque() {
        this.produtos = carregarEstoque();
    }

    private List<Produto> carregarEstoque() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILE_PATH);

        if (file.exists()) {
            try {
                return mapper.readValue(file, new TypeReference<List<Produto>>() {});
            } catch (IOException e) {
                System.err.println("Erro ao carregar o estoque: " + e.getMessage());
            }
        }

        return new ArrayList<>();
    }

    private void salvarEstoque() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), produtos);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o estoque: " + e.getMessage());
        }
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        salvarEstoque();
        System.out.println("Produto adicionado ao estoque: " + produto);
    }

    public void exibirEstoque() {
        System.out.println("\nProdutos disponíveis no estoque:");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
