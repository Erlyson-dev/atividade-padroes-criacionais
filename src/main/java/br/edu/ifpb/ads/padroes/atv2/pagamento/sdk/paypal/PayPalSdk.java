package br.edu.ifpb.ads.padroes.atv2.pagamento.sdk.paypal;

/**
 * Mock do PayPal SDK — simula chamadas à API real do PayPal.
 */
public class PayPalSdk {

    public PayPalSdk() {
        System.out.println("[PayPal SDK] Inicializado (modo sandbox).");
    }

    /**
     * Simula o envio de uma transação para a API do PayPal.
     */
    public boolean enviarTransacao(double valor, String descricao) {
        System.out.printf("[PayPal SDK] POST /v2/checkout/orders — valor: R$ %.2f | descrição: %s%n",
                valor, descricao);
        // Simula aprovação para valores até R$ 10.000
        boolean aprovado = valor <= 10_000;
        System.out.println("[PayPal SDK] Resposta: " + (aprovado ? "APPROVED" : "DECLINED"));
        return aprovado;
    }
}
