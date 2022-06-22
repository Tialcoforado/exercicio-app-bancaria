import java.util.List;

import src.models.contas.TipoConta;

public interface Operacoes {

    public List<ContaDefault> abrirConta(String nome, String email, TipoConta tipoDeConta);
    
    public void depositar(Integer idConta, Double valor) throws Exception;
    
    public List<Lancamentos> transferir(ContaDefault contaOrigem, ContaDefault contaDestino, Double valor);
    
    public List<ContaInvestimento> investir(ContaDefault conta, Double valor) throws ValorNegativoException;
    
    public List<Lancamentos> sacar(ContaDefault contaOrigem, Double valor) throws ValorNegativoException;

    public Double consultarSaldo(Integer idConta);
}