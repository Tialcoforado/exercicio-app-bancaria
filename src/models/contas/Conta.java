package src.models.contas;

import java.math.BigDecimal;

public interface Conta {
    
    BigDecimal sacar(BigDecimal valor);
    BigDecimal depositar(BigDecimal valor);
    BigDecimal transferir(BigDecimal valor);
    String consultarSaldo();
    
}
