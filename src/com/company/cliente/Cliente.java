package com.company.cliente;

import com.company.banco.Conta;
import java.util.List;

public class Cliente {

    protected String titular;
    protected String numeroDocumento;
    protected List<Conta> contas;

    public Cliente() {

    }

    public String getTitular() { return titular; }

    public void setTitular(String nome) { this.titular = nome; }

    public String getNumeroDocumento() { return numeroDocumento; }

    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }

    public List<Conta> getContas() { return contas; }

    public void setContas(List<Conta> contas) { this.contas = contas; }
}
