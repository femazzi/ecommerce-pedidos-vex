package com.vex.ecommerce.modelo.pagamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Boleto extends FormaPagamento {

    private String codigoDeBarras;
    private LocalDate dataDeVencimento;

    public Boleto(BigDecimal valor, String codigoDeBarras, LocalDate dataDeVencimento) {
        super(valor);
        setCodigoDeBarras(codigoDeBarras);
        setDataDeVencimento(dataDeVencimento);
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    private void setCodigoDeBarras(String codigoDeBarras) {
        if (codigoDeBarras == null || codigoDeBarras.isBlank()) {
            throw new IllegalArgumentException("Código de barras do boleto é obrigatório");
        }
        this.codigoDeBarras = codigoDeBarras.trim();
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    private void setDataDeVencimento(LocalDate dataDeVencimento) {
        if (dataDeVencimento == null) {
            throw new IllegalArgumentException("Data de vencimento do boleto é obrigatória");
        }
        if (dataDeVencimento.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "Data de vencimento não pode estar no passado: " + dataDeVencimento);
        }
        this.dataDeVencimento = dataDeVencimento;
    }

    @Override
    public boolean processar() {
        if (dataDeVencimento.isBefore(LocalDate.now())) {
            return false;
        }
        registrarPagamento();
        return true;
    }

    @Override
    public String getResumo() {
        return super.getResumo() + " (vencimento " + dataDeVencimento + ")";
    }
}
