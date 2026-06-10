package br.edu.ifpb.ads.padroes.atv2.pagamento.gateway;

/**
 * Abstração central do sistema de pagamentos.
 *
 * PagamentoService depende exclusivamente desta interface,
 * nunca de implementações concretas — princípio da Inversão de Dependência.
 *
 * Para adicionar um novo gateway (ex.: Pix), basta criar uma nova classe
 * que implemente esta interface e registrá-la no container de DI,
 * sem tocar em PagamentoService.
 */
public interface PagamentoGateway {

    /**
     * Processa um pagamento no gateway correspondente.
     *
     * @param valor    valor em reais a ser cobrado
     * @param descricao descrição do pagamento
     * @return true se o pagamento foi aprovado, false caso contrário
     */
    boolean pagar(double valor, String descricao);

    /**
     * Retorna o nome do gateway para fins de log e identificação.
     */
    String getNome();
}
