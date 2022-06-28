package src.models.contas;

import src.models.clientes.Cliente;
import src.models.clientes.ClientePj;

public class ContaPoupanca extends ContaDefault {

    protected ContaPoupanca(Cliente cliente) {
        super(cliente, TipoConta.CONTA_POUPANCA);
        if (cliente instanceof ClientePj) {
            throw new IllegalArgumentException("Cliente PJ não pode abrir conta poupança");
        }
    }

    @Override
    public String consultarSaldo() {
        return "[Conta Poupança] Cliente: " + cliente.getNome() + "Saldo: " + super.consultarSaldo();
    }

}
