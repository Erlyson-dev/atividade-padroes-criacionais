package br.edu.ifpb.ads.padroes.atv2.pagamento;

import br.edu.ifpb.ads.padroes.atv2.pagamento.gateway.PagamentoGateway;
import br.edu.ifpb.ads.padroes.atv2.pagamento.gateway.PayPalGateway;
import br.edu.ifpb.ads.padroes.atv2.pagamento.gateway.StripeGateway;
import br.edu.ifpb.ads.padroes.atv2.pagamento.gateway.PagSeguroGateway;
import br.edu.ifpb.ads.padroes.atv2.pagamento.sdk.paypal.PayPalSdk;
import br.edu.ifpb.ads.padroes.atv2.pagamento.sdk.stripe.StripeSdk;
import br.edu.ifpb.ads.padroes.atv2.pagamento.sdk.pagseguro.PagSeguroSdk;
import br.edu.ifpb.ads.padroes.atv2.pagamento.service.PagamentoService;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

/**
 * Ponto de entrada da atv2.
 *
 * Demonstra o uso de PicoContainer para injeção de dependência:
 *  1. Obtém PagamentoService configurado com PayPal → chama pagar()
 *  2. Obtém PagamentoService configurado com Stripe  → chama pagar()
 *  3. Obtém PagamentoService configurado com PagSeguro → chama pagar()
 */
public class Main {

    public static void main(String[] args) {

        // ── 1. PayPal ──────────────────────────────────────────────────────────
        System.out.println("========== CONFIGURAÇÃO: PayPal ==========");
        MutablePicoContainer paypalContainer = new DefaultPicoContainer();
        paypalContainer.addComponent(PayPalSdk.class);
        paypalContainer.addComponent(PagamentoGateway.class, PayPalGateway.class);
        paypalContainer.addComponent(PagamentoService.class);

        PagamentoService servicePayPal = paypalContainer.getComponent(PagamentoService.class);
        servicePayPal.pagar(299.90, "Pedido #1001 - Tênis Esportivo");
        servicePayPal.pagar(15_000.00, "Pedido #1002 - Notebook Gamer");

        // ── 2. Stripe ──────────────────────────────────────────────────────────
        System.out.println("\n========== CONFIGURAÇÃO: Stripe ==========");
        MutablePicoContainer stripeContainer = new DefaultPicoContainer();
        stripeContainer.addComponent(StripeSdk.class);
        stripeContainer.addComponent(PagamentoGateway.class, StripeGateway.class);
        stripeContainer.addComponent(PagamentoService.class);

        PagamentoService serviceStripe = stripeContainer.getComponent(PagamentoService.class);
        serviceStripe.pagar(149.99, "Pedido #1003 - Curso Online");

        // ── 3. PagSeguro ───────────────────────────────────────────────────────
        System.out.println("\n========== CONFIGURAÇÃO: PagSeguro ==========");
        MutablePicoContainer pagSeguroContainer = new DefaultPicoContainer();
        pagSeguroContainer.addComponent(PagSeguroSdk.class);
        pagSeguroContainer.addComponent(PagamentoGateway.class, PagSeguroGateway.class);
        pagSeguroContainer.addComponent(PagamentoService.class);

        PagamentoService servicePagSeguro = pagSeguroContainer.getComponent(PagamentoService.class);
        servicePagSeguro.pagar(89.00, "Pedido #1004 - Livro Técnico");
        servicePagSeguro.pagar(7_500.00, "Pedido #1005 - Smartphone");
    }
}
