import java.util.List;

public interface Operacoes {

    public List<Conta> abrirConta(String nome, String email, TipoDeConta tipoDeConta);
    
    public void depositar(Integer idConta, Double valor) throws Exception;
    
    public List<Lancamentos> transferir(Conta contaOrigem, Conta contaDestino, Double valor);
    
    public List<ContaInvestimento> investir(Conta conta, Double valor) throws ValorNegativoException;
    
    public List<Lancamentos> sacar(Conta contaOrigem, Double valor) throws ValorNegativoException;

    public Double consultarSaldo(Integer idConta);
}