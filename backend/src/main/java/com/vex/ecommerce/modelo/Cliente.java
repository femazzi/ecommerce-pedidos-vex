package com.vex.ecommerce.modelo;

// Representa os dados de quem realiza uma compra no e-commerce.
public class Cliente {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;

    public Cliente(String nome, String cpf, String email, String telefone, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Método de negócio exigido pelo roteiro
    public String getIdentificacao() {
        return String.format("%s (CPF: %s)", nome, cpf);
    }

    // Getters e Setters (sem setter para o CPF)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return String.format("Cliente: %s | E-mail: %s", getIdentificacao(), email);
    }
}
