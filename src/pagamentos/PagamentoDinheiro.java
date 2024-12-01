package pagamentos;
public class PagamentoDinheiro extends Pagamento {
    private double valorRecebido;

    public PagamentoDinheiro(double valorTotal, double valorRecebido) {
        super(valorTotal);
        this.valorRecebido = valorRecebido;
    }

    @Override
    public boolean processarPagamento() {
        if (valorRecebido >= valorTotal) {
            double troco = valorRecebido - valorTotal;
            System.out.println("Pagamento em dinheiro aprovado no valor de R$" + valorTotal);
            System.out.println("Troco: R$" + troco);
            return true;
        } else {
            System.out.println("Erro: Valor recebido insuficiente. Falta R$" + (valorTotal - valorRecebido));
            return false;
        }
    }
}
