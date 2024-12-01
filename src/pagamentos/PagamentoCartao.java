package pagamentos;

public class PagamentoCartao extends Pagamento {
    private double saldoCartao; // Saldo disponível no cartão
    private String numeroCartao;
    private String nomeTitular;
    private String validade;
    private String codigoSeguranca;

    public PagamentoCartao(int valorTotal, String numeroCartao, String nomeTitular, String validade, String codigoSeguranca) {
        super(valorTotal);
        this.saldoCartao = saldoCartao;
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.validade = validade;
        this.codigoSeguranca = codigoSeguranca;
    }

    @Override
    public boolean processarPagamento(double valor) {
        if (valor <= saldoCartao) {
            saldoCartao -= valor;
            System.out.println("Pagamento aprovado no cartão! Saldo restante: R$" + saldoCartao);
            return true;
        } else {
            System.out.println("Pagamento recusado! Saldo insuficiente no cartão.");
            return false;
        }
    }

    public double getSaldoCartao() {
        return saldoCartao;
    }
}
