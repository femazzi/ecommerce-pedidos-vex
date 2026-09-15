package com.vex.ecommerce;

import com.vex.ecommerce.modelo.Cliente;
import com.vex.ecommerce.modelo.ItemPedido;
import com.vex.ecommerce.modelo.Pedido;
import com.vex.ecommerce.modelo.Produto;
import com.vex.ecommerce.util.PedidoUtils; // Se tiver a classe da Aula 03

import java.math.BigDecimal;

public class Aplicacao {

    public static void main(String[] args) {
        System.out.println("=== TESTE DO MODELO DE DOMÍNIO (AULA 04) ===\n");

        // 1. Criando produtos
        Produto teclado = new Produto(
                "TEC-001", "Teclado Mecânico RGB", new BigDecimal("150.00"), 10);
        Produto monitor = new Produto(
                "MON-002", "Monitor 24\"", new BigDecimal("899.90"), 5);

        // 2. Criando cliente
        Cliente cliente = new Cliente(
                "Maria Silva", 
                "123.456.789-00", 
                "maria@email.com", 
                "(16) 99999-8888", 
                "Rua das Flores, 123 - São Carlos/SP"
        );

        // 3. Criando pedido (usando PedidoUtils se disponível, ou uma String manual)
        String numeroPedido = PedidoUtils.gerarNumeroDoPedido(); // ou "PED-2026-001"
        Pedido pedido = new Pedido(numeroPedido, cliente);

        // 4. Criando itens e adicionando ao pedido
        ItemPedido item1 = new ItemPedido(teclado, 2);
        ItemPedido item2 = new ItemPedido(monitor, 1);

        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        // 5. Imprimindo o pedido completo (chama o toString do Pedido)
        System.out.println(pedido);

        // 6. Verificando o abatimento de estoque
        System.out.println("\n--- Estoque Atualizado após a compra ---");
        System.out.println(teclado);
        System.out.println(monitor);
    }
}
