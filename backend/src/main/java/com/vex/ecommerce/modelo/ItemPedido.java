package com.vex.ecommerce.modelo;

public class ItemPedido {

    private Produto produto;
    private int quantidade;
    private double precoPraticado; // Registra o preço no momento da compra

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

    private void setPrecoPraticado(double precoPraticado) {
        if (precoPraticado < 0) {
            throw new IllegalArgumentException(
                    "Preço praticado não pode ser negativo: " + precoPraticado);
        }
        this.precoPraticado = precoPraticado;
    }

    // Método de negócio
    public double calcularSubtotal() {
        return precoPraticado * quantidade;
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

    public double getPrecoPraticado() {
        return precoPraticado;
    }

    @Override
    public String toString() {
        return String.format("%s x%d (R$ %.2f un.) -> Subtotal: R$ %.2f",
                produto.getNome(), quantidade, precoPraticado, calcularSubtotal());
    }
}
