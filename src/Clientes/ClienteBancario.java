package Clientes;

import java.util.List;

public class ClienteBancario {
    private String clienteId; // Referência ao id do cliente no clientescontrolador.json
    private String plataformaBancaria;
    private List<Cartao> cartoes;

    public ClienteBancario(String clienteId, String plataformaBancaria, List<Cartao> cartoes) {
        this.clienteId = clienteId;
        this.plataformaBancaria = plataformaBancaria;
        this.cartoes = cartoes;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getPlataformaBancaria() {
        return plataformaBancaria;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    @Override
    public String toString() {
        return "ClienteBancario{" +
                "clienteId='" + clienteId + '\'' +
                ", plataformaBancaria='" + plataformaBancaria + '\'' +
                ", cartoes=" + cartoes +
                '}';
    }
}

class Cartao {
    private String numeroCartao;
    private String bandeira;
    private String validade;
    private String nomeTitular;

    public Cartao(String numeroCartao, String bandeira, String validade, String nomeTitular) {
        this.numeroCartao = numeroCartao;
        this.bandeira = bandeira;
        this.validade = validade;
        this.nomeTitular = nomeTitular;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public String getValidade() {
        return validade;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "numeroCartao='" + numeroCartao + '\'' +
                ", bandeira='" + bandeira + '\'' +
                ", validade='" + validade + '\'' +
                ", nomeTitular='" + nomeTitular + '\'' +
                '}';
    }
}
