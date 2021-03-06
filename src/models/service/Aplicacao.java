package src.models.service;

import java.math.BigDecimal;

import src.models.clientes.ClientePf;
import src.models.clientes.ClientePj;
import src.models.contas.ContaInvestimento;
import src.models.contas.TipoConta;

public class Aplicacao {
    private final Banco banco;

    public Aplicacao() {
        this.banco = new Banco();
    }

    public static void main(String[] args) {
        new Aplicacao().init();
    }

    private void init() {
        // abrir conta, sacar, depositar, transferir, investir, consultar saldo
        var clientePf = new ClientePf();
        clientePf.setCpf("021.341.652.88");
        clientePf.setNome("Tiago Coutinho");
        clientePf.setEmail("tiago@email.com");
        var contaCorrentePf = this.banco.abrirConta(clientePf, TipoConta.CONTA_CORRENTE);
        contaCorrentePf.depositar(BigDecimal.valueOf(1000));
        contaCorrentePf.sacar(BigDecimal.valueOf(900));

        var clientePj = new ClientePj();
        clientePj.setNome("Supernova Desenv");
        clientePj.setCnpj("89.454.123/0001-00");
        clientePj.setEmail("supernova@email.com");
        var contaCorrentePj = this.banco.abrirConta(clientePj, TipoConta.CONTA_CORRENTE);
        contaCorrentePj.depositar(BigDecimal.valueOf(10000));
        contaCorrentePj.sacar(BigDecimal.valueOf(9000));

        System.out.println(contaCorrentePf.consultarSaldo());
        System.out.println(contaCorrentePj.consultarSaldo());

        try {
            banco.abrirConta(clientePj, TipoConta.CONTA_POUPANCA);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        var contaPoupancaPf = banco.abrirConta(clientePf, TipoConta.CONTA_POUPANCA);
        contaPoupancaPf.depositar(BigDecimal.valueOf(1000L));
        System.out.println(contaPoupancaPf.consultarSaldo());

        var contaInvestimentoPf = (ContaInvestimento) banco.abrirConta(clientePf, TipoConta.CONTA_INVESTIMENTO);
        contaInvestimentoPf.depositar(BigDecimal.valueOf(1000L));
        System.out.println(contaInvestimentoPf.consultarSaldo());

        var contaInvestimentoPj = (ContaInvestimento) banco.abrirConta(clientePj, TipoConta.CONTA_INVESTIMENTO);
        contaInvestimentoPj.investir(BigDecimal.valueOf(1000L));
        System.out.println(contaInvestimentoPj.consultarSaldo());
    }
}
