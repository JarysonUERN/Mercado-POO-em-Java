package Clientes;

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

    protected String getClienteId() {
        return clienteId;
    }

    protected String getPlataformaBancaria() {
        return plataformaBancaria;
    }

    protected List<Cartao> getCartoes() {
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


    public class CartaoOperacao{
        this.cartao.get.pagamento;



    }
