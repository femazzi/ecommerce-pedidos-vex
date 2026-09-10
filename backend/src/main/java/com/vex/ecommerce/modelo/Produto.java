//* Esta classe representa os produtos disponíveis no e-commerce. Ela contém informações sobre cada produto, como nome, descrição, preço e quantidade em estoque. A classe também pode incluir métodos para manipular os produtos, como adicionar novos produtos, atualizar informações existentes e remover produtos do catálogo.

package com.vex.ecommerce.modelo;

import java.math.BigDecimal;

public class Produto {

    private String codigo;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private int quantidadeEmEstoque;
    private boolean ativo;

    // Construtor
    public Produto(String codigo, String nome, BigDecimal preco, int quantidadeEmEstoque) {
        setCodigo(codigo);
        setNome(nome);
        setDescricao(null);
        setPreco(preco);
        setQuantidadeEmEstoque(quantidadeEmEstoque);
        this.ativo = true; // Todo produto nasce ativo por regra de negócio
    }

    private void setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código do produto é obrigatório");
        }
        this.codigo = codigo.trim();
    }

    // Métodos de negócio
    public boolean temEstoqueDisponivel(int quantidadeDesejada) {
        if (quantidadeDesejada <= 0) {
            throw new IllegalArgumentException(
                    "Quantidade desejada deve ser positiva: " + quantidadeDesejada);
        }
        return ativo && quantidadeEmEstoque >= quantidadeDesejada;
    }

    public void baixarEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva: " + quantidade);
        }
        if (!ativo) {
            throw new IllegalStateException("Não é possível baixar estoque de produto inativo");
        }
        if (quantidade > quantidadeEmEstoque) {
            throw new IllegalArgumentException(
                    "Estoque insuficiente. Disponível: " + quantidadeEmEstoque
                            + ", solicitado: " + quantidade);
        }
        this.quantidadeEmEstoque -= quantidade;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        if (preco == null) {
            throw new IllegalArgumentException("Preço é obrigatório");
        }
        if (preco.compareTo(BigDecimal.ZERO) < 0) {
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
