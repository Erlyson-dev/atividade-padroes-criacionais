package br.edu.ifpb.ads.padroes.atv2.pagamento.sdk.pagseguro;

/**
 * Mock do PagSeguro SDK — simula chamadas à API real do PagSeguro.
 */
public class PagSeguroSdk {

    public PagSeguroSdk() {
        System.out.println("[PagSeguro SDK] Inicializado (ambiente de homologação).");
    }

    /**
     * Simula a criação de um pedido de cobrança na API do PagSeguro.
     */
    public boolean processarCobranca(double valor, String descricao) {
        System.out.printf("[PagSeguro SDK] POST /charges — valor: R$ %.2f | descricao: %s%n",
                valor, descricao);
        // Simula recusa para valores acima de R$ 5.000 (limite hipotético)
        boolean aprovado = valor <= 5_000;
        System.out.println("[PagSeguro SDK] codigo_status: " + (aprovado ? "PAID" : "DECLINED"));
        return aprovado;
    }
}
