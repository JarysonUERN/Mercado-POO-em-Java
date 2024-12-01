package Clientes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String id;                  // Identificador único do cliente
    private String nome;                // Nome do cliente
    private String email;               // E-mail do cliente
    private List<String> metodosPagamento;  // Métodos de pagamento (ex: Cartão, Dinheiro)
    private List<String> historicoCompras;  // Histórico de compras (IDs dos produtos)
    
    // Dados bancários
    private String banco;               // Banco do cliente (ex: Nubank, PicPay, etc.)
    private String tipoPix;             // Tipo de chave Pix (ex: CPF, e-mail, telefone, etc.)
    private String chavePix;            // Chave Pix do cliente (ex: CPF, e-mail, telefone, etc.)
    private String dadosBancarios;      // Informações adicionais do banco (ex: número da conta, agência, etc.)

    public Cliente(String id, String nome, String email, String banco, String tipoPix, String chavePix, String dadosBancarios) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.metodosPagamento = new ArrayList<>();
        this.historicoCompras = new ArrayList<>();
        this.banco = banco;
        this.tipoPix = tipoPix;
        this.chavePix = chavePix;
        this.dadosBancarios = dadosBancarios;
    }

    // Getters e Setters
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

    public String getBanco() {
        return banco;
    }

    public String getTipoPix() {
        return tipoPix;
    }

    public String getChavePix() {
        return chavePix;
    }

    public String getDadosBancarios() {
        return dadosBancarios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public void setTipoPix(String tipoPix) {
        this.tipoPix = tipoPix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public void setDadosBancarios(String dadosBancarios) {
        this.dadosBancarios = dadosBancarios;
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
                ", banco='" + banco + '\'' +
                ", tipoPix='" + tipoPix + '\'' +
                ", chavePix='" + chavePix + '\'' +
                ", dadosBancarios='" + dadosBancarios + '\'' +
                '}';
    }
}
