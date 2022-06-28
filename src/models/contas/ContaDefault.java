package src.models.contas;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import src.exceptions.SaldoInsuficienteException;
import src.models.clientes.Cliente;

public class ContaDefault implements Conta {
    protected final Cliente cliente;
    protected BigDecimal saldo;
    protected final TipoConta tipoConta;

    protected ContaDefault(Cliente cliente, TipoConta tipoConta) {
        this.cliente = cliente;
        this.tipoConta = tipoConta;
        this.saldo = BigDecimal.ZERO;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    private void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public BigDecimal sacar(BigDecimal valor) {
        if (this.getSaldo().compareTo(valor) > 0) {
            this.setSaldo(this.saldo.subtract(valor));
            return this.getSaldo();
        }
        throw new SaldoInsuficienteException();
    }

    @Override
    public BigDecimal depositar(BigDecimal valor) {
        this.setSaldo(this.saldo.add(valor));
        return this.getSaldo();
    }

    @Override
    public BigDecimal transferir(BigDecimal valor, Conta recebedora) {
        if (this.getSaldo().compareTo(valor) > 0) {
            recebedora.depositar(valor);
            return this.sacar(valor);
        }
        throw new SaldoInsuficienteException();
    }

    @Override
    public String consultarSaldo() {
        return NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR")).format(this.getSaldo());
    }
}
