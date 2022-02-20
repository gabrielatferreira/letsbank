package com.company.banco;

import java.math.BigDecimal;

public abstract class Conta {

    protected String titular;
    protected String tipoPessoa;
    protected int agencia;
    protected int numeroConta;
    protected BigDecimal saldo;

    public Conta() {
    }

    public String getTitular() { return titular; }

    public void setTitular(String titular) { this.titular = titular; }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getSaldo() { return saldo; }

    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }

    public void consultarSaldo() {
        System.out.println(this.titular + ", o seu saldo é " + this.saldo + ".");
    }

    public void sacar(BigDecimal valorSacado) {
        BigDecimal taxaSaque = BigDecimal.ZERO;
        if(this.tipoPessoa.equals("PJ")) {
            taxaSaque = valorSacado.multiply(BigDecimal.valueOf(0.005));
        }
        this.saldo = this.saldo.subtract(valorSacado).subtract(taxaSaque);
        System.out.println(this.titular + ", você sacou " + valorSacado.toString()
                + " reais. Foi descontado 0,5% por essa operação no valor de "
                + taxaSaque + ". Seu saldo atual é de " + this.saldo + " reais.");
    }

    public void depositar(BigDecimal valorDepositado) {
        this.saldo = this.saldo.add(valorDepositado);
        System.out.println(this.titular + ", você depositou " + valorDepositado.toString() + " reais. Seu saldo atual é de " + this.saldo + " reais.");
    }

    public void transferir(Conta contaDestino, BigDecimal valorTransferido) {
        System.out.println("Você está fazendo uma transferência:");
        this.sacar(valorTransferido);
        contaDestino.depositar(valorTransferido);
    }
}