package br.edu.ifpb.ads.padroes.atv2.pagamento.gateway;

import br.edu.ifpb.ads.padroes.atv2.pagamento.sdk.pagseguro.PagSeguroSdk;

/**
 * Implementação concreta de PagamentoGateway para o PagSeguro.
 * Delega a lógica real ao PagSeguroSdk (mock da API).
 *
 * O PicoContainer injeta o PagSeguroSdk via construtor.
 */
public class PagSeguroGateway implements PagamentoGateway {

    private final PagSeguroSdk sdk;

    public PagSeguroGateway(PagSeguroSdk sdk) {
        this.sdk = sdk;
    }

    @Override
    public boolean pagar(double valor, String descricao) {
        System.out.println("[PagSeguroGateway] Iniciando pagamento...");
        return sdk.processarCobranca(valor, descricao);
    }

    @Override
    public String getNome() {
        return "PagSeguro";
    }
}
