package pagamentos;

public abstract class Pagamento {
    protected double valorTotal;

    public Pagamento(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    // Método abstrato a ser implementado pelos tipos de pagamento
    public abstract boolean processarPagamento();

    public double getValorTotal() {
        return valorTotal;
    }
}
