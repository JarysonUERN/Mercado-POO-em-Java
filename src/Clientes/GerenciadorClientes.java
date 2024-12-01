package Clientes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorClientes {
    private List<Cliente> clientes;
    private static final String FILE_PATH = "Jsons-Controller/clientescontrolador.json"; // Caminho para o arquivo JSON

    public GerenciadorClientes() {
        this.clientes = carregarClientes();
    }

    private List<Cliente> carregarClientes() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILE_PATH);

        if (file.exists()) {
            try {
                return mapper.readValue(file, new TypeReference<List<Cliente>>() {});
            } catch (IOException e) {
                System.err.println("Erro ao carregar os clientes: " + e.getMessage());
            }
        }

        return new ArrayList<>();
    }

    private void salvarClientes() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), clientes);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os clientes: " + e.getMessage());
        }
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        salvarClientes();
        System.out.println("Cliente cadastrado: " + cliente);
    }

    public Cliente buscarClientePorId(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public void exibirClientes() {
        System.out.println("\nClientes cadastrados:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}
