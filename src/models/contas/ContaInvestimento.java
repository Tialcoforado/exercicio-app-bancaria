package src.models.contas;

import java.math.BigDecimal;

import src.models.clientes.Cliente;
import src.models.clientes.ClientePj;

public class ContaInvestimento extends ContaDefault {

    protected ContaInvestimento(Cliente cliente) {
        super(cliente, TipoConta.CONTA_INVESTIMENTO);
    }

    @Override
    public String consultarSaldo() {
        return "[Conta Investimento] Cliente: " + cliente.getNome() + ", Saldo: " + super.consultarSaldo();
    }

    @Override
    public BigDecimal getSaldo() {
        if (this.cliente instanceof ClientePj) {
            return super.getSaldo().multiply(BigDecimal.valueOf(ClientePj.RENDIMENTO_EXTRA));
        }
        return super.getSaldo();
    }

    public BigDecimal investir(BigDecimal valor) {
        return super.depositar(valor);
    }
}