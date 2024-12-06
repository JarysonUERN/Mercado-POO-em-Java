package clientes;

import java.util.List;

public class ClienteBancario {
    private String clienteId; // Referência ao id do cliente no clientescontrolador.json
    private String plataformaBancaria;
    private List<Cartao> cartoes;

    protected  ClienteBancario(String clienteId, String plataformaBancaria, List<Cartao> cartoes) {
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