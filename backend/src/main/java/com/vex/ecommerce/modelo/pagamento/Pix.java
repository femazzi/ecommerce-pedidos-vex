package com.vex.ecommerce.modelo.pagamento;

import java.math.BigDecimal;

public class Pix extends FormaPagamento {

    private String chave;

    public Pix(BigDecimal valor, String chave) {
        super(valor);
        setChave(chave);
    }

    public String getChave() {
        return chave;
    }

    private void setChave(String chave) {
        if (chave == null || chave.isBlank()) {
            throw new IllegalArgumentException("Chave Pix é obrigatória");
        }
        this.chave = chave.trim();
    }

    @Override
    public boolean processar() {
        registrarPagamento();
        return true;
    }

    @Override
    public String getResumo() {
        return super.getResumo() + " (chave " + chave + ")";
    }
}
