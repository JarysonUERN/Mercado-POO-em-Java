package estoque;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import produto.Produto;

public class Estoque {
    private List<Produto> produtos;
    private static final String FILE_PATH = "Jsons-Data/estoque.json";

    // Instância única da classe Estoque
    private static Estoque instancia;

    // Construtor privado para impedir a criação direta de instâncias
    private Estoque() {
        this.produtos = carregarEstoque();
    }

    // Método estático para acessar a instância única
    public static synchronized Estoque getInstancia() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
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

    public boolean removerProduto(String idProduto, int quantidade) {
        Produto produto = buscarProdutoPorId(idProduto);
        if (produto != null) {
            if (produto.getQuantidade() >= quantidade) {
                produto.setQuantidade(produto.getQuantidade() - quantidade);
                salvarEstoque();
                System.out.println("Quantidade removida do produto: " + produto);
                return true;
            } else {
                System.out.println("Estoque insuficiente para o produto: " + produto);
                return false;
            }
        }
        return false;
    }

    public Produto buscarProdutoPorId(String idProduto) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(idProduto)) {
                return produto;
            }
        }
        System.out.println("Produto com ID " + idProduto + " não encontrado no estoque.");
        return null;
    }

    public void exibirEstoque() {
        System.out.println("\nProdutos disponíveis no estoque:");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
