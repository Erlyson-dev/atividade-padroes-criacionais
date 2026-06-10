package br.edu.ifpb.ads.padroes.atv2.pagamento.service;

import br.edu.ifpb.ads.padroes.atv2.pagamento.gateway.PagamentoGateway;

/**
 * Serviço de pagamentos do e-commerce.
 *
 * Depende exclusivamente da abstração PagamentoGateway — nunca de
 * PayPalGateway, StripeGateway ou PagSeguroGateway diretamente.
 *
 * O gateway concreto é injetado via construtor pelo container de DI
 * (PicoContainer), aplicando o princípio da Inversão de Dependência.
 *
 * Para suportar um novo gateway (ex.: Pix), basta criar a implementação
 * de PagamentoGateway e reconfiguraro container — esta classe não muda.
 */
public class PagamentoService {

    private final PagamentoGateway gateway;

    // Injeção de Dependência via construtor — PicoContainer resolve automaticamente
    public PagamentoService(PagamentoGateway gateway) {
        this.gateway = gateway;
    }

    /**
     * Processa um pagamento utilizando o gateway configurado.
     */
    public void pagar(double valor, String descricao) {
        System.out.printf("%n>>> PagamentoService: processando R$ %.2f via %s%n",
                valor, gateway.getNome());

        boolean aprovado = gateway.pagar(valor, descricao);

        if (aprovado) {
            System.out.printf("✔ Pagamento de R$ %.2f APROVADO pelo %s.%n", valor, gateway.getNome());
        } else {
            System.out.printf("✘ Pagamento de R$ %.2f RECUSADO pelo %s.%n", valor, gateway.getNome());
        }
    }
}
