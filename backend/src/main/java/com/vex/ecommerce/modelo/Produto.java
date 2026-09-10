//* Esta classe representa os produtos disponíveis no e-commerce. Ela contém informações sobre cada produto, como nome, descrição, preço e quantidade em estoque. A classe também pode incluir métodos para manipular os produtos, como adicionar novos produtos, atualizar informações existentes e remover produtos do catálogo.

package com.vex.ecommerce.modelo;

public class Produto {

    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeEmEstoque;
    private boolean ativo;

    // Construtor
    public Produto(String codigo, String nome, double preco, int quantidadeEmEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.ativo = true; // Todo produto nasce ativo por regra de negócio
    }

    // Métodos de negócio
    public boolean temEstoqueDisponivel(int quantidadeDesejada) {
        return ativo && quantidadeEmEstoque >= quantidadeDesejada;
    }

    public void baixarEstoque(int quantidade) {
        if (temEstoqueDisponivel(quantidade)) {
            this.quantidadeEmEstoque -= quantidade;
        }
    }

    // Getters e Setters (sem setter para o atributo 'codigo')
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do produto é obrigatório");
        }
        this.nome = nome.trim();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao == null ? "" : descricao.trim();
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo: " + preco);
        }
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if (quantidadeEmEstoque < 0) {
            throw new IllegalArgumentException(
                    "Estoque não pode ser negativo: " + quantidadeEmEstoque);
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - R$ %.2f (%d em estoque)", codigo, nome, preco, quantidadeEmEstoque);
    }
}
