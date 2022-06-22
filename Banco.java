import java.util.ArrayList;
import java.util.List;

import src.models.clientes.Cliente;
import src.models.contas.TipoConta;

public class Banco implements Operacoes {
    List<ContaDefault> contas = new ArrayList<>();
    List<ContaInvestimento> contasInvestimento = new ArrayList<>();
    List<Lancamentos> lancamentos = new ArrayList<>();

    public List<ContaDefault> getContas() {
        return contas;
    }

    public ContaDefault getConta(Integer idConta) {
        ContaDefault conta = contas.get(idConta);
        return conta;
    }

    public ContaDefault getContaInvestimento(Integer idConta) {
        ContaInvestimento contaInvestimento = contasInvestimento.get(idConta);
        return contaInvestimento;
    }

    public void setContas(List<ContaDefault> contas) {
        this.contas = contas;
    }

    public List<Lancamentos> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamentos> lancamentos) {
        this.lancamentos = lancamentos;
    }

    // Abrir conta
    @Override
    public List<ContaDefault> abrirConta(String nome, String email, TipoConta tipoDeConta) {
        Cliente cliente = new Cliente(nome, email);
        ContaDefault novaConta = new ContaDefault(cliente, 0.00, TipoConta.ContaCorrente);
        contas.add(novaConta);
        return contas;
    }

    // Depositar
    @Override
    public void depositar(Integer idConta, Double valor) throws Exception {
        if (valor < 0) {
            throw new ValorNegativoException();
        }
        ContaDefault contaDestino = contas.get(idConta);
        Double saldoAtual = contaDestino.getSaldo();
        contaDestino.setSaldo(saldoAtual + valor);
    }

    // Transferir recursos entre contas
    public List<Lancamentos> transferir(ContaDefault contaOrigem, ContaDefault contaDestino, Double valor) {
        // TODO validacoes, contaOrigem e contaDestino não podem ser iguais
        // Valor da transferencia tem que ser maior que zero
        if (contaOrigem != contaDestino & valor > 0) {
            ContaDefault contaDebitada = contaOrigem;
            ContaDefault contaCreditada = contaDestino;
            contaDebitada.setSaldo(contaDebitada.getSaldo() - valor);
            contaCreditada.setSaldo(contaCreditada.getSaldo() + valor);
        }
        // Se cliente Pj Cobrar mais 0.5 de taxa
        if (contaOrigem.tipoDeConta == TipoConta.ContaCorrentePj) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - (valor * 0.5));
        }
            return lancamentos;
    }

    public List<ContaInvestimento> investir(ContaDefault conta, Double valor) {
        ContaInvestimento contaInvest = new ContaInvestimento(conta, valor);
        contasInvestimento.add(contaInvest);
        // Se cliente Pj Cobrar mais 0.5 de taxa
        if (contaInvest.tipoDeConta == TipoConta.ContaCorrentePj) {
            contaInvest.setSaldo(contaInvest.getSaldo() + (valor * 0.02));
        }
        return contasInvestimento;
    };

    @Override
    public List<Lancamentos> sacar(ContaDefault contaOrigem, Double valor) throws ValorNegativoException {
        if (valor < 0) {
            throw new ValorNegativoException();
        }
        ContaDefault contaDebitada = contaOrigem;
        contaDebitada.setSaldo(contaDebitada.getSaldo() - valor);
        // Se cliente Pj Cobrar mais 0.5 de taxa
        if (contaDebitada.tipoDeConta == TipoConta.ContaCorrentePj) {
            contaDebitada.setSaldo(contaDebitada.getSaldo() - (valor * 0.5));
        }
        return lancamentos;
    }


    @Override
    public Double consultarSaldo(Integer idConta) {
        ContaDefault contaConsultada = getConta(idConta);
        Double saldo = contaConsultada.getSaldo();
        return saldo;
    }

    @Override
    public String toString() {
        return "Banco [contas=" + contas + ", lancamentos=" + lancamentos + "]";
    }

}
