package pagamentos;

public class PagamentoPix extends Pagamento {
    private String chavePix;

    public PagamentoPix(double valorTotal, String chavePix) {
        super(valorTotal);
        this.chavePix = chavePix;
    }

    @Override
    public boolean processarPagamento(double valor) {
        if (chavePix != null && !chavePix.isEmpty()) {
            System.out.println("Pagamento via Pix aprovado no valor de R$" + valor);
            System.out.println("Chave utilizada: " + chavePix);
            return true;
        } else {
            System.out.println("Erro: Chave Pix inválida.");
            return false;
        }
    }

    // Getter para a chave Pix
    public String getChavePix() {
        return chavePix;
    }

    // Setter para atualizar a chave Pix (se necessário)
    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
}
