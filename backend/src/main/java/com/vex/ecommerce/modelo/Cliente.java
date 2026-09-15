package com.vex.ecommerce.modelo;

// Representa os dados de quem realiza uma compra no e-commerce.
public class Cliente extends Pessoa {

    private String email;
    private String telefone;
    private String endereco;

    public Cliente(String nome, String cpf, String email, String telefone, String endereco) {
        super(nome, cpf);
        setEmail(email);
        setTelefone(telefone);
        setEndereco(endereco);
    }

    // Método de negócio exigido pelo roteiro
    @Override
    public String getIdentificacao() {
        return String.format("%s (CPF: %s)", getNome(), getDocumento());
    }

    @Override
    public String getResumo() {
        return super.getResumo() + " - " + email;
    }

    public String getCpf() {
        return getDocumento();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail deve ser preenchido e conter @: " + email);
        }
        this.email = email.trim();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("Telefone é obrigatório");
        }
        this.telefone = telefone.trim();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.isBlank()) {
            throw new IllegalArgumentException("Endereço é obrigatório");
        }
        this.endereco = endereco.trim();
    }

    @Override
    public String toString() {
        return String.format("Cliente: %s | E-mail: %s", getIdentificacao(), email);
    }
}
