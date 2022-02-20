package com.company;

import com.company.banco.*;
import com.company.cliente.Cliente;
import com.company.cliente.ClientePessoaFisica;
import com.company.cliente.ClientePessoaJuridica;

import java.math.BigDecimal;

public class Aplicacao {

    public static void main(String[] args){

        Banco banco = new Banco();

        Cliente clienteGabriela = new ClientePessoaFisica();
        clienteGabriela.setTitular("Gabriela");
        clienteGabriela.setNumeroDocumento("12345678911");

        Conta contaCorrenteGabriela = new ContaCorrente();
        contaCorrenteGabriela.setAgencia(123);
        contaCorrenteGabriela.setNumeroConta(7687);
        contaCorrenteGabriela.setSaldo(BigDecimal.valueOf(1000));

        Conta contaAbertaGabriela = banco.abrirConta(clienteGabriela, contaCorrenteGabriela);
        contaAbertaGabriela.consultarSaldo();
        contaAbertaGabriela.sacar(BigDecimal.valueOf(50));
        contaAbertaGabriela.depositar(BigDecimal.valueOf(100));

        Conta contaInvestimentoGabriela = new ContaInvestimento();
        contaInvestimentoGabriela.setAgencia(456);
        contaInvestimentoGabriela.setNumeroConta(8907);
        contaInvestimentoGabriela.setSaldo(BigDecimal.valueOf(0));

        ContaInvestimento contaAbertaGabrielaInv = (ContaInvestimento) banco.abrirConta(clienteGabriela, contaInvestimentoGabriela);
        contaAbertaGabrielaInv.consultarSaldo();
        contaAbertaGabrielaInv.investir(BigDecimal.valueOf(100));

        Cliente clienteJesse = new ClientePessoaFisica();
        clienteJesse.setTitular("Jesse");
        clienteJesse.setNumeroDocumento("21345678911");

        Conta contaPoupancaJesse = new ContaPoupanca();
        contaPoupancaJesse.setAgencia(321);
        contaPoupancaJesse.setNumeroConta(5674);
        contaPoupancaJesse.setSaldo(BigDecimal.valueOf(500));

        Conta contaAbertaJesse = banco.abrirConta(clienteJesse, contaPoupancaJesse);
        contaAbertaJesse.consultarSaldo();
        contaAbertaJesse.sacar(BigDecimal.valueOf(50));
        contaAbertaJesse.depositar(BigDecimal.valueOf(100));

        contaAbertaGabriela.transferir(contaAbertaJesse, BigDecimal.valueOf(20));

        //PJ
        Cliente clienteEmpresa = new ClientePessoaJuridica();
        clienteEmpresa.setTitular("Empresa");
        clienteEmpresa.setNumeroDocumento("12345678910014");

        ContaInvestimento contaInvestimentoEmpresa = new ContaInvestimento();
        contaInvestimentoEmpresa.setAgencia(555);
        contaInvestimentoEmpresa.setNumeroConta(9211);
        contaInvestimentoEmpresa.setSaldo(BigDecimal.valueOf(0));

        ContaInvestimento contaAbertaEmpresaInv = (ContaInvestimento) banco.abrirConta(clienteEmpresa, contaInvestimentoEmpresa);
        contaAbertaEmpresaInv.consultarSaldo();
        contaAbertaEmpresaInv.investir(BigDecimal.valueOf(1000));
        contaAbertaEmpresaInv.sacar(BigDecimal.valueOf(100));
        contaAbertaEmpresaInv.transferir(contaAbertaJesse, BigDecimal.valueOf(10));

        ContaPoupanca contaPoupancaEmpresa = new ContaPoupanca();
        contaPoupancaEmpresa.setAgencia(444);
        contaPoupancaEmpresa.setNumeroConta(3245);
        contaPoupancaEmpresa.setSaldo(BigDecimal.valueOf(10_000));

        Conta contaAbertaEmpresa = banco.abrirConta(clienteEmpresa, contaPoupancaEmpresa);
        contaAbertaEmpresa.consultarSaldo();

    }
}
