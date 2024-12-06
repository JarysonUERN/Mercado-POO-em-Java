package pagamentos;

import clientes.Cartao;
import clientes.ClienteBancario;

public class PagamentoCartao extends Pagamento {
    private double saldoCartao; // Saldo disponível no cartão
    private String numeroCartao;
    private String nomeTitular;
    private String validade;
    private String codigoSeguranca;
    private ClienteBancario clienteBancario; // Cliente associado ao pagamento

    /**
     *
     *
     * @param valorTotal O valor total a ser pago.
     * @param clienteBancario O cliente bancário associado ao pagamento.
     *
     * O construtor inicializa o pagamento com o valor total fornecido e usa as informações do primeiro cartão
     * do cliente bancário para realizar o pagamento. Se o cliente bancário for nulo, a lista de cartões estiver vazia,
     * ou se o cliente bancário não possuir cartões, as informações do cartão serão nulas.
     */
    public PagamentoCartao(double valorTotal, ClienteBancario clienteBancario) {
        super(valorTotal);
        this.clienteBancario = clienteBancario;
        // Assumindo que o primeiro cartão do cliente é o utilizado para o pagamento
        if (clienteBancario != null && clienteBancario.getCartoes() != null && !clienteBancario.getCartoes().isEmpty()) {
            Cartao cartao = clienteBancario.getCartoes().get(0); // Pegando o primeiro cartão da lista
            this.numeroCartao = cartao.getNumero();
            this.nomeTitular = cartao.getNomeTitular();
            this.validade = cartao.getValidade();
            this.codigoSeguranca = cartao.getCodigoSeguranca();
            this.saldoCartao = cartao.getSaldo(); // Usando o saldo do cartão
        }
    }
    public PagamentoCartao(int valorTotal, String numeroCartao, String nomeTitular, String validade, String codigoSeguranca) {
        super(valorTotal); 
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.validade = validade;
        this.codigoSeguranca = codigoSeguranca;
        this.saldoCartao = 0.0; // Inicializando o saldo como 0.0, mas você pode ajustá-lo se necessário
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

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public String getValidade() {
        return validade;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public ClienteBancario getClienteBancario() {
        return clienteBancario;
    }

    @Override
    public String toString() {
        return "PagamentoCartao{" +
                "numeroCartao='" + numeroCartao + '\'' +
                ", nomeTitular='" + nomeTitular + '\'' +
                ", validade='" + validade + '\'' +
                ", saldoCartao=" + saldoCartao +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
