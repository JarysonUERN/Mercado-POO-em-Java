package controller;


import clientes.Cliente;
import estoque.Estoque;
import java.util.List;
import carrinho.Carrinho;
import carrinho.ItemCarrinho;
import produto.Produto;

public class SistemaController {
    private Estoque estoque;
    private List<Cliente> clientes;

    public SistemaController(Estoque estoque, List<Cliente> clientes) {
        this.estoque = estoque;
        this.clientes = clientes;
    }

    // Métodos relacionados a Clientes
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso: " + cliente);
    }

    public Cliente buscarClientePorId(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        System.out.println("Cliente com ID " + id + " não encontrado.");
        return null;
    }

    public void exibirClientes() {
        System.out.println("\nClientes cadastrados:");
        for (Cliente cliente : clientes) {
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
        Cliente cliente = buscarClientePorId(clienteId);

        if (produto != null && cliente != null) {
            estoque.removerProduto(produtoId, 0); // Remove o produto do estoque
            cliente.adicionarCompraAoHistorico(produtoId); // Adiciona ao histórico do cliente
            System.out.println("Venda realizada com sucesso: Produto " + produto.getNome() + " vendido para " + cliente.getNome());
            return true;
        }

        System.out.println("Venda não realizada. Produto ou cliente não encontrados.");
        return false;
    }

    public void adicionarMetodoDePagamentoParaCliente(String clienteId, String metodoPagamento) {
        Cliente cliente = buscarClientePorId(clienteId);
        if (cliente != null) {
            cliente.adicionarMetodoPagamento(metodoPagamento);
            System.out.println("Método de pagamento adicionado para " + cliente.getNome());
        }
    }

    public Produto buscarProdutoPorId(String idProduto) {
        return estoque.buscarProdutoPorId(idProduto); // Assumindo que Estoque já possui este método
    }

    public void exibirHistoricoDeCompras(String clienteId) {
        Cliente cliente = buscarClientePorId(clienteId);
        if (cliente != null) {
            System.out.println("\nHistórico de compras de " + cliente.getNome() + ":");
            for (String compra : cliente.getHistoricoCompras()) {
                System.out.println("- Produto ID: " + compra);
            }
        }
    }

    public void realizarCompra(String clienteId, Carrinho carrinho, String metodoPagamento) {
    Cliente cliente = buscarClientePorId(clienteId);
    if (cliente == null) {
        System.out.println("Cliente não encontrado.");
        return;
    }

    double total = carrinho.calcularTotal();
    PagamentoController pagamentoController = new PagamentoController();
    boolean pagamentoRealizado = pagamentoController.realizarPagamento(metodoPagamento, total);

    if (pagamentoRealizado) {
        // Atualizar estoque e histórico de compras do cliente
        for (ItemCarrinho item : carrinho.getItens()) {
            estoque.removerProduto(item.getProduto().getId(), item.getQuantidade());
            cliente.adicionarCompraAoHistorico(String.valueOf(item.getProduto().getId()));
        }
        System.out.println("Compra realizada com sucesso!");
    } else {
        System.out.println("Falha no pagamento. Compra não realizada.");
    }
}
}
