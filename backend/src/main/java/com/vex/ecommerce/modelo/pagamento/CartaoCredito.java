package com.vex.ecommerce.modelo.pagamento;

import java.math.BigDecimal;

public class CartaoCredito extends FormaPagamento {

    private String numeroMascarado;
    private String bandeira;
    private int quantidadeDeParcelas;

    public CartaoCredito(
            BigDecimal valor,
            String numeroMascarado,
            String bandeira,
            int quantidadeDeParcelas) {
        super(valor);
        setNumeroMascarado(numeroMascarado);
        setBandeira(bandeira);
        setQuantidadeDeParcelas(quantidadeDeParcelas);
    }

    public String getNumeroMascarado() {
        return numeroMascarado;
    }

    private void setNumeroMascarado(String numeroMascarado) {
        if (numeroMascarado == null || numeroMascarado.isBlank()) {
            throw new IllegalArgumentException("Número mascarado do cartão é obrigatório");
        }
        this.numeroMascarado = numeroMascarado.trim();
    }

    public String getBandeira() {
        return bandeira;
    }

    private void setBandeira(String bandeira) {
        if (bandeira == null || bandeira.isBlank()) {
            throw new IllegalArgumentException("Bandeira do cartão é obrigatória");
        }
        this.bandeira = bandeira.trim();
    }

    public int getQuantidadeDeParcelas() {
        return quantidadeDeParcelas;
    }

    private void setQuantidadeDeParcelas(int quantidadeDeParcelas) {
        if (quantidadeDeParcelas <= 0 || quantidadeDeParcelas > 12) {
            throw new IllegalArgumentException(
                    "Quantidade de parcelas deve estar entre 1 e 12: " + quantidadeDeParcelas);
        }
        this.quantidadeDeParcelas = quantidadeDeParcelas;
    }

    @Override
    public boolean processar() {
        registrarPagamento();
        return true;
    }

    @Override
    public String getResumo() {
        return super.getResumo() + String.format(
                " (%s %s em %dx)", bandeira, numeroMascarado, quantidadeDeParcelas);
    }
}
