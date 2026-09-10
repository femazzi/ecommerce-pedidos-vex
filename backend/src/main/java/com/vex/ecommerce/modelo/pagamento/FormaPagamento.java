package com.vex.ecommerce.modelo.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class FormaPagamento {

    private BigDecimal valor;
    private LocalDateTime dataDoPagamento;

    protected FormaPagamento(BigDecimal valor) {
        setValor(valor);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor do pagamento deve ser positivo: " + valor);
        }
        this.valor = valor;
    }

    public LocalDateTime getDataDoPagamento() {
        return dataDoPagamento;
    }

    protected void registrarPagamento() {
        this.dataDoPagamento = LocalDateTime.now();
    }

    public abstract boolean processar();

    public String getResumo() {
        return String.format("%s no valor de R$ %.2f", getClass().getSimpleName(), valor);
    }
}
