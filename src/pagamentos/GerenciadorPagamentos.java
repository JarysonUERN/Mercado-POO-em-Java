package pagamentos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorPagamentos {
    private List<Pagamento> pagamentos; // Lista de pagamentos
    private static final String FILE_PATH = "Jsons-Data/clientesBancarios.json"; // Caminho para o arquivo JSON de pagamentos

    public GerenciadorPagamentos() {
        this.pagamentos = carregarPagamentos();
    }

    // Carregar pagamentos do arquivo JSON
    private List<Pagamento> carregarPagamentos() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILE_PATH);

        if (file.exists()) {
            try {
                return mapper.readValue(file, new TypeReference<List<Pagamento>>() {});
            } catch (IOException e) {
                System.err.println("Erro ao carregar os pagamentos: " + e.getMessage());
            }
        }

        return new ArrayList<>();
    }

    // Salvar os pagamentos no arquivo JSON
    private void salvarPagamentos() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), pagamentos);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os pagamentos: " + e.getMessage());
        }
    }

    // Adicionar pagamento à lista
    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
        salvarPagamentos();
        System.out.println("Pagamento adicionado: " + pagamento);
    }

    // Remover pagamento (pode ser por ID ou por outro critério)
    public boolean removerPagamento(String idPagamento) {
        Pagamento pagamento = buscarPagamentoPorId(idPagamento);
        if (pagamento != null) {
            pagamentos.remove(pagamento);
            salvarPagamentos();
            System.out.println("Pagamento removido: " + pagamento);
            return true;
        }
        System.out.println("Pagamento com ID " + idPagamento + " não encontrado.");
        return false;
    }

    // Buscar pagamento por ID
    public Pagamento buscarPagamentoPorId(String idPagamento) {
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getId().equals(idPagamento)) {
                return pagamento;
            }
        }
        System.out.println("Pagamento com ID " + idPagamento + " não encontrado.");
        return null;
    }

    // Exibir todos os pagamentos
    public void exibirPagamentos() {
        System.out.println("\nPagamentos realizados:");
        for (Pagamento pagamento : pagamentos) {
            System.out.println(pagamento);
        }
    }
}
