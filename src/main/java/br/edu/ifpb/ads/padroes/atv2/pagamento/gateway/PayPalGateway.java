package br.edu.ifpb.ads.padroes.atv2.pagamento.gateway;

import br.edu.ifpb.ads.padroes.atv2.pagamento.sdk.paypal.PayPalSdk;

/**
 * Implementação concreta de PagamentoGateway para o PayPal.
 * Delega a lógica real ao PayPalSdk (mock da API).
 *
 * O PicoContainer injeta o PayPalSdk via construtor.
 */
public class PayPalGateway implements PagamentoGateway {

    private final PayPalSdk sdk;

    public PayPalGateway(PayPalSdk sdk) {
        this.sdk = sdk;
    }

    @Override
    public boolean pagar(double valor, String descricao) {
        System.out.println("[PayPalGateway] Iniciando pagamento...");
        return sdk.enviarTransacao(valor, descricao);
    }

    @Override
    public String getNome() {
        return "PayPal";
    }
}
