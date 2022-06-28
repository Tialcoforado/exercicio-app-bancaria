package src.models.contas;

import java.math.BigDecimal;

import src.models.clientes.Cliente;
import src.models.clientes.ClientePj;

public class ContaCorrente extends ContaDefault {

    protected ContaCorrente(Cliente cliente) {
        super(cliente, TipoConta.CONTA_CORRENTE);
    }

    @Override
    public String consultarSaldo() {
        return new StringBuilder("[Conta Corrente] Cliente: ").append(cliente.getNome()).append(", Saldo: ")
                .append(super.consultarSaldo()).toString();
    }

    @Override
    public BigDecimal sacar(BigDecimal valor) {
        if (cliente instanceof ClientePj) {
            return super.sacar(getValorAcrescidoDeTaxaExtra(valor));
        }
        return super.sacar(valor);
    }

    @Override
    public BigDecimal transferir(BigDecimal valor, Conta recebedora) {
        if (cliente instanceof ClientePj){
            return super.transferir(getValorAcrescidoDeTaxaExtra(valor), recebedora);
        }
        return super.transferir(valor, recebedora);
    }

    private BigDecimal getValorAcrescidoDeTaxaExtra(BigDecimal valor) {
        return valor.multiply(BigDecimal.valueOf(ClientePj.TAXA_EXTRA));
    }
}
