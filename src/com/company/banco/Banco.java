package com.company.banco;

import com.company.cliente.Cliente;
import com.company.cliente.ClientePessoaFisica;

import java.util.ArrayList;

public class Banco {

    protected int tamanhoCnpj = 14;

    public boolean contaPodeSerAbertaPeloCliente(String numeroDocumento, Conta conta) {
        if (numeroDocumento.length() == tamanhoCnpj && conta instanceof ContaPoupanca) {
            System.out.println("Pessoa Jurídica não pode abrir conta poupança.");
            return false;
        } else {
            return true;
        }
    }

    public Conta abrirConta(Cliente cliente, Conta conta) {
        if (contaPodeSerAbertaPeloCliente(cliente.getNumeroDocumento(), conta)) {
            conta.setTitular(cliente.getTitular());
            if(cliente.getContas() == null) {
                cliente.setContas(new ArrayList<>());
            }
            if(cliente instanceof ClientePessoaFisica) {
                conta.setTipoPessoa("PF");
            } else {
                conta.setTipoPessoa("PJ");
            }
            cliente.getContas().add(conta);
            System.out.println(cliente.getTitular() + ", portador(a) do documento número " + cliente.getNumeroDocumento()
                    + " a sua conta foi criada com sucesso, com saldo de " + conta.getSaldo() + " reais. A agência e o número da conta são: "
                    + conta.getAgencia() + " e " + conta.getNumeroConta() + ".");
        } else {
            System.out.println("Não foi possível abrir a sua conta.");
            return null;
        }
        return conta;
    }
}
