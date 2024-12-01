package pagamentos;

public abstract class Pagamento {
    protected double valorTotal;

    public Pagamento(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    // Método abstrato a ser implementado pelos tipos de pagamento
    public abstract boolean processarPagamento(double valor);
    
    public double getValorTotal() {
        return valorTotal;
    }
}
