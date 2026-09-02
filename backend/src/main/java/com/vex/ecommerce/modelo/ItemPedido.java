package com.vex.ecommerce.modelo;

public class ItemPedido {

    private Produtos produto;
    private int quantidade;
    private double precoPraticado; // Registra o preço no momento da compra

    public ItemPedido(Produtos produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoPraticado = produto.getPreco(); // Congela o preço atual do produto
    }

    // Método de negócio
    public double calcularSubtotal() {
        return precoPraticado * quantidade;
    }

    public Produtos getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoPraticado() {
        return precoPraticado;
    }

    @Override
    public String toString() {
        return String.format("%s x%d (R$ %.2f un.) -> Subtotal: R$ %.2f",
                produto.getNome(), quantidade, precoPraticado, calcularSubtotal());
    }
}