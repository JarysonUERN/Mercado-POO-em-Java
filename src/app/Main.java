package app;

import pagamentos.*;

public class Main  {
    public static void main(String[] args) {
        // Testando o sistema de pagamentos
        Pagamento cartao = new PagamentoCartao(100.0, "1234 5678 9012 3456", "Nome do Titular", "30/02/2025", "123");
        PagamentoPix pix = new PagamentoPix(100.0, "234567890123456789012345678901234567890");

}
