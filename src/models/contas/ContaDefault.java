package src.models.contas;
import java.math.BigDecimal;

import src.models.clientes.Cliente;

public class ContaDefault {
    protected final Cliente cliente;
    protected BigDecimal saldo;
    protected final TipoConta tipoConta;
}
