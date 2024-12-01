package pagamentos;
public class PagamentoCartao extends Pagamento {
    private String numeroCartao;
    private String nomeTitular;
    private String dataValidade;
    private String codigoSeguranca;

    public PagamentoCartao(double valorTotal, String numeroCartao, String nomeTitular, String dataValidade, String codigoSeguranca) {
        super(valorTotal);
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.dataValidade = dataValidade;
        this.codigoSeguranca = codigoSeguranca;
    }

    @Override
    public boolean processarPagamento() {
        // Simula a validação do cartão
        if (numeroCartao.length() == 16 && !nomeTitular.isEmpty() && !dataValidade.isEmpty() && codigoSeguranca.length() == 3) {
            System.out.println("Pagamento com cartão aprovado no valor de R$" + valorTotal);
            return true;
        } else {
            System.out.println("Erro: Dados do cartão inválidos.");
            return false;
        }
    }
}
