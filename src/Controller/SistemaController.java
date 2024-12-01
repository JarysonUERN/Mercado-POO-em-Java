package Controller;


import Clientes.Clientes;
import Estoque.Estoque;
import produto.Produto;
import java.util.List;

public class SistemaController {
    private Estoque estoque;
    private List<Clientes> clientes;

    public SistemaController(Estoque estoque, List<Clientes> clientes) {
        this.estoque = estoque;
        this.clientes = clientes;
    }

    // Métodos relacionados a Clientes
    public void cadastrarCliente(Clientes cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso: " + cliente);
    }

    public Clientes buscarClientePorId(String id) {
        for (Clientes cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        System.out.println("Cliente com ID " + id + " não encontrado.");
        return null;
    }

    public void exibirClientes() {
        System.out.println("\nClientes cadastrados:");
        for (Clientes cliente : clientes) {
            System.out.println(cliente);
        }
    }

    // Métodos relacionados ao Estoque
    public void adicionarProdutoAoEstoque(Produto produto) {
        estoque.adicionarProduto(produto);
        System.out.println("Produto adicionado ao estoque: " + produto);
    }

    public void exibirEstoque() {
        estoque.exibirEstoque();
    }

    public boolean venderProduto(String produtoId, String clienteId) {
        Produto produto = estoque.buscarProdutoPorId(produtoId);
        Clientes cliente = buscarClientePorId(clienteId);

        if (produto != null && cliente != null) {
            estoque.removerProduto(produtoId); // Remove o produto do estoque
            cliente.adicionarCompraAoHistorico(produtoId); // Adiciona ao histórico do cliente
            System.out.println("Venda realizada com sucesso: Produto " + produto.getNome() + " vendido para " + cliente.getNome());
            return true;
        }

        System.out.println("Venda não realizada. Produto ou cliente não encontrados.");
        return false;
    }

    // Métodos de controle adicionais
    public void adicionarMetodoDePagamentoParaCliente(String clienteId, String metodoPagamento) {
        Clientes cliente = buscarClientePorId(clienteId);
        if (cliente != null) {
            cliente.adicionarMetodoPagamento(metodoPagamento);
            System.out.println("Método de pagamento adicionado para " + cliente.getNome());
        }
    }

    public void exibirHistoricoDeCompras(String clienteId) {
        Clientes cliente = buscarClientePorId(clienteId);
        if (cliente != null) {
            System.out.println("\nHistórico de compras de " + cliente.getNome() + ":");
            for (String compra : cliente.getHistoricoCompras()) {
                System.out.println("- Produto ID: " + compra);
            }
        }
    }
}
