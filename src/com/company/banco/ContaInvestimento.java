package com.company.banco;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta{
    public ContaInvestimento() {

    }

    public void investir(BigDecimal valorInvestido) {
        if(this.tipoPessoa.equals("PF")) {
            this.saldo = this.saldo.add(valorInvestido).multiply(BigDecimal.valueOf(1.1));
        } else {
            this.saldo = this.saldo.add(valorInvestido).multiply(BigDecimal.valueOf(1.12));
        }
        System.out.println(this.titular + ", você investiu " + valorInvestido.toString() + " reais. Seu saldo atual é de " + this.saldo + " reais.");
    }
}
