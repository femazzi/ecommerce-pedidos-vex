package com.vex.ecommerce.util;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Random;

public final class PedidoUtils {

    // =========================
    // CONSTANTES
    // =========================

    private static final Random RANDOM = new Random();

    private static final String PREFIXO_PEDIDO = "PED";
    private static final int LIMITE_NUMERO_PEDIDO = 100000;

    private static final BigDecimal VALOR_POR_QUILO = new BigDecimal("7.50");
    private static final BigDecimal FRETE_MINIMO = new BigDecimal("12.00");
    private static final BigDecimal VALOR_FRETE_GRATIS = new BigDecimal("300.00");

    private static final BigDecimal TAXA_DESCONTO = new BigDecimal("0.10");
    private static final BigDecimal DESCONTO_MAXIMO = new BigDecimal("100.00");

    private PedidoUtils() {
    }

    /**
     * Gera um número de pedido no formato PED-AAAA-NNNNN.
     *
     * @return número do pedido formatado.
     */
    public static String gerarNumeroDoPedido() {
        int anoAtual = Year.now().getValue();
        int numeroAleatorio = RANDOM.nextInt(LIMITE_NUMERO_PEDIDO);

        return String.format("%s-%04d-%05d", PREFIXO_PEDIDO, anoAtual, numeroAleatorio);
    }

    /**
     * Calcula o subtotal do pedido.
     *
     * @param precos preços dos produtos.
     * @param quantidades quantidades dos produtos.
     * @return subtotal do pedido.
     */
    public static BigDecimal calcularSubtotal(BigDecimal[] precos, int[] quantidades) {
        BigDecimal subtotal = BigDecimal.ZERO;

        for (int i = 0; i < precos.length; i++) {
            subtotal = subtotal.add(precos[i].multiply(BigDecimal.valueOf(quantidades[i])));
        }

        return subtotal;
    }

    /**
     * Calcula o valor do frete.
     *
     * @param peso peso total do pedido.
     * @param valorPedido valor total do pedido.
     * @return valor do frete.
     */
    public static BigDecimal calcularFrete(double peso, BigDecimal valorPedido) {
        if (peso < 0 || valorPedido == null || valorPedido.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.ZERO;
        }

        if (valorPedido.compareTo(VALOR_FRETE_GRATIS) >= 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal frete = VALOR_POR_QUILO.multiply(
                BigDecimal.valueOf((long) Math.ceil(peso)));

        return frete.max(FRETE_MINIMO);
    }


    /**
     * Calcula o desconto do pedido.
     *
     * @param valorPedido valor do pedido.
     * @return valor do desconto.
     */
    public static BigDecimal calcularDesconto(BigDecimal valorPedido) {
        if (valorPedido == null || valorPedido.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal desconto = valorPedido.multiply(TAXA_DESCONTO);

        return desconto.min(DESCONTO_MAXIMO);
    }

    /**
     * Formata uma linha do recibo.
     *
     * @param produto nome do produto.
     * @param quantidade quantidade comprada.
     * @param preco preço unitário.
     * @return linha formatada.
     */
    public static String formatarLinhaDoRecibo(String produto, int quantidade, BigDecimal preco) {
        BigDecimal total = preco.multiply(BigDecimal.valueOf(quantidade));

        return String.format("%-20s %3d x R$ %7.2f = R$ %7.2f", produto, quantidade, preco, total);
    }

}
