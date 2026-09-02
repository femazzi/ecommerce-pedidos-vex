package com.vex.ecommerce.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String numero;
    private Clientes cliente;
    private LocalDateTime data;
    private List<ItemPedido> itens;

    public Pedido(String numero, Clientes cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.data = LocalDateTime.now();
        this.itens = new ArrayList<>();
    }

    // Métodos de negócio
    public void adicionarItem(ItemPedido item) {
        if (item.getProduto().temEstoqueDisponivel(item.getQuantidade())) {
            item.getProduto().baixarEstoque(item.getQuantidade());
            this.itens.add(item);
        } else {
            System.out.println("Erro: Estoque insuficiente para o produto " + item.getProduto().getNome());
        }
    }

    public double calcularValorTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    // Getters
    public String getNumero() {
        return numero;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("=== PEDIDO Nº %s ===\n", numero));
        sb.append(String.format("Data: %s\n", data.format(fmt)));
        sb.append(String.format("Cliente: %s\n", cliente.getIdentificacao()));
        sb.append("Itens:\n");
        for (ItemPedido item : itens) {
            sb.append(" - ").append(item.toString()).append("\n");
        }
        sb.append(String.format("TOTAL: R$ %.2f", calcularValorTotal()));
        return sb.toString();
    }
}