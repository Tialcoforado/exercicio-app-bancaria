package src.models.service;

import java.util.ArrayList;
import java.util.List;

import src.models.clientes.Cliente;
import src.models.contas.Conta;
import src.models.contas.ContaFactory;
import src.models.contas.TipoConta;

public class Banco {

    private final List<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public Banco(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public Conta abrirConta(Cliente cliente, TipoConta tipoConta) {
        return ContaFactory.create(cliente, tipoConta);
    }
}
