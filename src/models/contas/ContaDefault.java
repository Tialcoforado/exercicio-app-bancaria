package src.models.contas;
import java.math.BigDecimal;

import src.models.clientes.Cliente;

public class ContaDefault implements Conta {
    protected final Cliente cliente;
    protected BigDecimal saldo;
    protected final TipoConta tipoConta;
    
    protected ContaDefault(Cliente cliente, TipoConta tipoConta){
        this.cliente = cliente;
        this.tipoConta = tipoConta;
        this.saldo = BigDecimal.ZERO;
    }

    @Override
    public BigDecimal sacar(BigDecimal valor) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public BigDecimal depositar(BigDecimal valor) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public BigDecimal transferir(BigDecimal valor) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String consultarSaldo() {
        // TODO Auto-generated method stub
        return null;
    }
}
