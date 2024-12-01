package Clientes;

public class Cartao{
    private String numero;           // Número do cartão
    private String nomeTitular;      // Nome do titular do cartão
    private String validade;         // Validade do cartão (MM/AAAA)
    private String codigoSeguranca;  // Código de segurança (CVV)
    private double saldo;            // Saldo disponível no cartão

    // Construtor
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
