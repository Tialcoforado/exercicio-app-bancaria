import java.util.ArrayList;
import java.util.List;

public class Banco implements Operacoes {
    List<Conta> contas = new ArrayList<>();
    List<ContaInvestimento> contasInvestimento = new ArrayList<>();
    List<Lancamentos> lancamentos = new ArrayList<>();

    public List<Conta> getContas() {
        return contas;
    }

    public Conta getConta(Integer idConta) {
        Conta conta = contas.get(idConta);
        return conta;
    }

    public Conta getContaInvestimento(Integer idConta) {
        ContaInvestimento contaInvestimento = contasInvestimento.get(idConta);
        return contaInvestimento;
    }

    public void setContas(List<Conta> contas) {
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
    public List<Conta> abrirConta(String nome, String email, TipoDeConta tipoDeConta) {
        Cliente cliente = new Cliente(nome, email);
        Conta novaConta = new Conta(cliente, 0.00, TipoDeConta.ContaCorrente);
        contas.add(novaConta);
        return contas;
    }

    // Depositar
    @Override
    public void depositar(Integer idConta, Double valor) throws Exception {
        if (valor < 0) {
            throw new ValorNegativoException();
        }
        Conta contaDestino = contas.get(idConta);
        Double saldoAtual = contaDestino.getSaldo();
        contaDestino.setSaldo(saldoAtual + valor);
    }

    // Transferir recursos entre contas
    public List<Lancamentos> transferir(Conta contaOrigem, Conta contaDestino, Double valor) {
        // TODO validacoes, contaOrigem e contaDestino não podem ser iguais
        // Valor da transferencia tem que ser maior que zero
        if (contaOrigem != contaDestino & valor > 0) {
            Conta contaDebitada = contaOrigem;
            Conta contaCreditada = contaDestino;
            contaDebitada.setSaldo(contaDebitada.getSaldo() - valor);
            contaCreditada.setSaldo(contaCreditada.getSaldo() + valor);
        }
        // Se cliente Pj Cobrar mais 0.5 de taxa
        if (contaOrigem.tipoDeConta == TipoDeConta.ContaCorrentePj) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - (valor * 0.5));
        }
            return lancamentos;
    }

    public List<ContaInvestimento> investir(Conta conta, Double valor) {
        ContaInvestimento contaInvest = new ContaInvestimento(conta, valor);
        contasInvestimento.add(contaInvest);
        // Se cliente Pj Cobrar mais 0.5 de taxa
        if (contaInvest.tipoDeConta == TipoDeConta.ContaCorrentePj) {
            contaInvest.setSaldo(contaInvest.getSaldo() + (valor * 0.02));
        }
        return contasInvestimento;
    };

    @Override
    public List<Lancamentos> sacar(Conta contaOrigem, Double valor) throws ValorNegativoException {
        if (valor < 0) {
            throw new ValorNegativoException();
        }
        Conta contaDebitada = contaOrigem;
        contaDebitada.setSaldo(contaDebitada.getSaldo() - valor);
        // Se cliente Pj Cobrar mais 0.5 de taxa
        if (contaDebitada.tipoDeConta == TipoDeConta.ContaCorrentePj) {
            contaDebitada.setSaldo(contaDebitada.getSaldo() - (valor * 0.5));
        }
        return lancamentos;
    }


    @Override
    public Double consultarSaldo(Integer idConta) {
        Conta contaConsultada = getConta(idConta);
        Double saldo = contaConsultada.getSaldo();
        return saldo;
    }

    @Override
    public String toString() {
        return "Banco [contas=" + contas + ", lancamentos=" + lancamentos + "]";
    }

}
