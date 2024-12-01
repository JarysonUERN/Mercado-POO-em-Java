package pagamentos;

import java.util.List;

public class PagamentoPix extends Pagamento {
    private String chavePix;

    public PagamentoPix(double valorTotal, String chavePix) {
        super(valorTotal);
        this.chavePix = chavePix;
    }

    @Override
    public boolean processarPagamento() {
        if (chavePix != null && !chavePix.isEmpty()) {
            System.out.println("Pagamento via Pix aprovado no valor de R$" + valorTotal);
            System.out.println("Chave utilizada: " + chavePix);
            return true;
        } else {
            System.out.println("Erro: Chave Pix inválida.");
            return false;
        }
    }
}
