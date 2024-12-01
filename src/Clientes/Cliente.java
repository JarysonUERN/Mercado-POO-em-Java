package Clientes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
     private String id;
    private String nome;
    private String email;
    private List<String> metodosPagamento; // Exemplo: ["Cartão", "Dinheiro"]
    private List<String> historicoCompras; // Lista de IDs de produtos comprados

    public Cliente(String id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.metodosPagamento = new ArrayList<>();
        this.historicoCompras = new ArrayList<>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getMetodosPagamento() {
        return metodosPagamento;
    }

    public List<String> getHistoricoCompras() {
        return historicoCompras;
    }

    public void adicionarMetodoPagamento(String metodo) {
        metodosPagamento.add(metodo);
    }

    public void adicionarCompraAoHistorico(String produtoId) {
        historicoCompras.add(produtoId);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
