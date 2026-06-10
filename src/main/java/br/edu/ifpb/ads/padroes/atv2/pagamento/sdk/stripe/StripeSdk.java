package br.edu.ifpb.ads.padroes.atv2.pagamento.sdk.stripe;

/**
 * Mock do Stripe SDK — simula chamadas à API real do Stripe.
 */
public class StripeSdk {

    public StripeSdk() {
        System.out.println("[Stripe SDK] Inicializado (test mode).");
    }

    /**
     * Simula a criação de um PaymentIntent na API do Stripe.
     */
    public boolean criarPaymentIntent(double valor, String descricao) {
        // Stripe trabalha com centavos internamente
        long valorCentavos = Math.round(valor * 100);
        System.out.printf("[Stripe SDK] POST /v1/payment_intents — amount: %d (centavos) | description: %s%n",
                valorCentavos, descricao);
        // Simula aprovação para valores positivos
        boolean aprovado = valor > 0;
        System.out.println("[Stripe SDK] status: " + (aprovado ? "succeeded" : "failed"));
        return aprovado;
    }
}
