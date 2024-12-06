package controller;

import clientes.Cliente;
import clientes.GerenciadorClientes;

public class ClienteController {
    private GerenciadorClientes gerenciadorClientes;

    public ClienteController() {
        this.gerenciadorClientes = new GerenciadorClientes();
    }

    // Cadastrar cliente
    public void cadastrarCliente(String id, String nome, String email, String banco, String tipoPix, String chavePix, String dadosBancarios) {
        Cliente cliente = new Cliente(id, nome, email, tipoPix, chavePix, banco, dadosBancarios);
        gerenciadorClientes.cadastrarCliente(cliente);
    }

    // Buscar cliente por ID
    public Cliente buscarClientePorId(String id) {
        return gerenciadorClientes.buscarClientePorId(id);
    }

    // Exibir todos os clientes
    public void exibirClientes() {
        gerenciadorClientes.exibirClientes();
    }

    // Adicionar método de pagamento a um cliente
    public void adicionarMetodoPagamento(String idCliente, String metodo) {
        Cliente cliente = gerenciadorClientes.buscarClientePorId(idCliente);
        if (cliente != null) {
            cliente.adicionarMetodoPagamento(metodo);
            gerenciadorClientes.salvarClientes(); // Salvar as alterações
            System.out.println("Método de pagamento " + metodo + " adicionado ao cliente " + idCliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // Adicionar compra ao histórico de um cliente
    public void adicionarCompraAoHistorico(String idCliente, String produtoId) {
        Cliente cliente = gerenciadorClientes.buscarClientePorId(idCliente);
        if (cliente != null) {
            cliente.adicionarCompraAoHistorico(produtoId);
            gerenciadorClientes.salvarClientes(); // Salvar as alterações
            System.out.println("Compra do produto " + produtoId + " adicionada ao histórico do cliente " + idCliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
