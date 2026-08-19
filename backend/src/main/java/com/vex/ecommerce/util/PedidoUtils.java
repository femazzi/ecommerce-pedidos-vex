package com.vex.ecommerce.util;


import java.time.Year;
import java.util.Random;

/**
 * Classe utilitária responsável pelos cálculos e formatações
 * utilizados no sistema de pedidos.
 */
public final class PedidoUtils {

    // =========================
    // CONSTANTES
    // =========================

    private static final Random RANDOM = new Random();

    private static final String PREFIXO_PEDIDO = "PED";
    private static final int LIMITE_NUMERO_PEDIDO = 100000;

    private static final double FRETE_POR_KG = 7.50;
    private static final double FRETE_MINIMO = 12.00;
    private static final double VALOR_MINIMO_FRETE_GRATIS = 300.00;

    private static final double TAXA_DESCONTO = 0.10;
    private static final double TETO_DESCONTO = 100.00;

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
}