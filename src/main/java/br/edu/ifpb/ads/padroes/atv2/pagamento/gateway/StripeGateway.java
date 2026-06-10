package br.edu.ifpb.ads.padroes.atv2.pagamento.gateway;

import br.edu.ifpb.ads.padroes.atv2.pagamento.sdk.stripe.StripeSdk;

/**
 * Implementação concreta de PagamentoGateway para o Stripe.
 * Delega a lógica real ao StripeSdk (mock da API).
 *
 * O PicoContainer injeta o StripeSdk via construtor.
 */
public class StripeGateway implements PagamentoGateway {

    private final StripeSdk sdk;

    public StripeGateway(StripeSdk sdk) {
        this.sdk = sdk;
    }

    @Override
    public boolean pagar(double valor, String descricao) {
        System.out.println("[StripeGateway] Iniciando pagamento...");
        return sdk.criarPaymentIntent(valor, descricao);
    }

    @Override
    public String getNome() {
        return "Stripe";
    }
}
