import src.models.clientes.Cliente;
import src.models.clientes.ClientePj;
import src.models.contas.ContaDefault;
import src.models.contas.TipoConta;

public class ContaPoupanca extends ContaDefault {

    protected ContaPoupanca(Cliente cliente) {
        super(cliente, TipoConta.contaPoupanca);
        if (cliente instanceof ClientePj) {
            throw new IllegalArgumentException("Cliente pj não pode abrir conta poupança");
        }
    }

    @Override
    public String consultarSaldo() {
        return "[Conta Poupança] Cliente: " + cliente.getNome() + ", Saldo: " + super.consultarSaldo();
    }
}