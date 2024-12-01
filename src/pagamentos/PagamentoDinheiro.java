package pagamentos;

public class PagamentoDinheiro extends Pagamento {
    private double dinheiroDisponivel; // Montante disponível para pagamento

    public PagamentoDinheiro(double valorTotal, double dinheiroDisponivel) {
        super(valorTotal);
        this.dinheiroDisponivel = dinheiroDisponivel;
    }

    @Override
    public boolean processarPagamento(double valor) {
        if (valor <= dinheiroDisponivel) {
            dinheiroDisponivel -= valor;
            System.out.println("Pagamento em dinheiro aprovado! Troco: R$" + (dinheiroDisponivel));
            return true;
        } else {
            System.out.println("Pagamento recusado! Dinheiro insuficiente.");
            return false;
        }
    }

    public double getDinheiroDisponivel() {
        return dinheiroDisponivel;
    }
}
