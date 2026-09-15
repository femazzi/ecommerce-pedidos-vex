package com.vex.ecommerce.modelo;

import java.math.BigDecimal;

public class ItemPedido {

    private Produto produto;
    private int quantidade;
    private BigDecimal precoPraticado; // Registra o preço no momento da compra

    public ItemPedido(Produto produto, int quantidade) {
        setProduto(produto);
        setQuantidade(quantidade);
        setPrecoPraticado(produto.getPreco()); // Congela o preço atual do produto
    }

    private void setProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto do item é obrigatório");
        }
        this.produto = produto;
    }

    private void setPrecoPraticado(BigDecimal precoPraticado) {
        if (precoPraticado == null) {
            throw new IllegalArgumentException("Preço praticado é obrigatório");
        }
        if (precoPraticado.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "Preço praticado não pode ser negativo: " + precoPraticado);
        }
        this.precoPraticado = precoPraticado;
    }

    // Método de negócio
    public BigDecimal calcularSubtotal() {
        return precoPraticado.multiply(BigDecimal.valueOf(quantidade));
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    private void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade do item deve ser positiva: " + quantidade);
        }
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoPraticado() {
        return precoPraticado;
    }

    @Override
    public String toString() {
        return String.format("%s x%d (R$ %.2f un.) -> Subtotal: R$ %.2f",
                produto.getNome(), quantidade, precoPraticado, calcularSubtotal());
    }
}
