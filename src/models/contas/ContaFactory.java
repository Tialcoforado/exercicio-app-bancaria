package src.models.contas;

import src.models.clientes.Cliente;

public class ContaFactory {
    private ContaFactory() {
        super();
    }

    public static Conta create(Cliente cliente, TipoConta tipoConta) {
        switch (tipoConta) {
            case CONTA_POUPANCA:
                return createContaPoupanca(cliente);
            case CONTA_CORRENTE:
                return createContaCorrente(cliente);
            case CONTA_INVESTIMENTO:
                return createContaInvestimento(cliente);
            default:
                throw new IllegalArgumentException("Opção inválida");
        }
    }

    private static Conta createContaInvestimento(Cliente cliente) {
        return new ContaInvestimento(cliente);
    }

    private static Conta createContaCorrente(Cliente cliente) {
        return new ContaCorrente(cliente);
    }

    private static Conta createContaPoupanca(Cliente cliente) {
        return new ContaPoupanca(cliente);
    };
}
