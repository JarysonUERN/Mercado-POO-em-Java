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


        public class LCartao {
             public Cartao(String numero, String nomeTitular, String validade, String codigoSeguranca, double saldo) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.validade = validade;
        this.codigoSeguranca = codigoSeguranca;
        this.saldo = saldo;
    }

    // Getters e Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // toString
    @Override
    public String toString() {
        return "Cartao{" +
                "numero='" + numero + '\'' +
                ", nomeTitular='" + nomeTitular + '\'' +
                ", validade='" + validade + '\'' +
                ", saldo=" + saldo +
                '}';
    }




}
