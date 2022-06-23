import java.util.List;

import src.exceptions.ValorNegativoException;
import src.models.contas.ContaInvestimento;
import src.models.contas.TipoConta;

public interface Operacoes {

    public List<Deprecated_ContaDefault> abrirConta(String nome, String email, TipoConta tipoDeConta);
    
    public void depositar(Integer idConta, Double valor) throws Exception;
    
    public List<Lancamentos> transferir(Deprecated_ContaDefault contaOrigem, Deprecated_ContaDefault contaDestino, Double valor);
    
    public List<ContaInvestimento> investir(Deprecated_ContaDefault conta, Double valor) throws ValorNegativoException;
    
    public List<Lancamentos> sacar(Deprecated_ContaDefault contaOrigem, Double valor) throws ValorNegativoException;

    public Double consultarSaldo(Integer idConta);
}