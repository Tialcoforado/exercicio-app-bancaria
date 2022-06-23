import src.exceptions.ValorNegativoException;
import src.models.contas.TipoConta;

public class Deprecated_Aplicacao {
    public static void main(String[] args) throws Exception {
        
        // Abre o programa criando o banco que vai ser o depositario das contas
        Deprecated_Banco myBank = new Deprecated_Banco();
        TestaAberturaContaCorrenteSucesso_200(myBank);
        
        // assinala contas a uma variavel para ficar mais legível
        Deprecated_ContaDefault contaDoJose = myBank.getConta(0);
        Deprecated_ContaDefault contaDoPedro = myBank.getConta(1);
        Deprecated_ContaDefault contaDaMaria = myBank.getConta(2);
        
        TestaDepositoSucesso_200(myBank);
        TesteConsultaSaldo(myBank);
        TestaTransferenciaSucesso_200(myBank, contaDoJose, contaDoPedro);
        TestarInvestirSucesso_200(myBank, contaDaMaria);
        TesteSacarSucesso_200(myBank, contaDoJose, contaDoPedro, contaDaMaria);
        
        TesteConsultaSaldo(myBank);
    }
    

    // Consulta saldos
    private static void TesteConsultaSaldo(Deprecated_Banco myBank) {
        System.out.println(myBank.consultarSaldo(0));
        System.out.println(myBank.consultarSaldo(1));
        System.out.println(myBank.consultarSaldo(2));
    }
    
    // Realiza o saque em contas
    private static void TesteSacarSucesso_200(Deprecated_Banco myBank, Deprecated_ContaDefault contaDoJose, Deprecated_ContaDefault contaDoPedro, Deprecated_ContaDefault contaDaMaria)
            throws ValorNegativoException {
        myBank.sacar(contaDoJose, 50.00);
        myBank.sacar(contaDoPedro, 100.00);
        myBank.sacar(contaDaMaria, 200.00);
    }

    // Faz investimento em conta investimento
    private static void TestarInvestirSucesso_200(Deprecated_Banco myBank, Deprecated_ContaDefault contaDaMaria) {
        myBank.investir(myBank.getConta(0), 100.00);
        myBank.investir(myBank.getConta(1), 200.00);
        myBank.investir(contaDaMaria, 300.00);
        System.out.println(myBank.getContaInvestimento(0));
    }

    // Abre contas correntes
    private static void TestaAberturaContaCorrenteSucesso_200(Deprecated_Banco myBank) {
        myBank.abrirConta("jose", "jose@email.com", TipoConta.ContaCorrente);
        myBank.abrirConta("Pedro", "pedro@email.com", TipoConta.ContaCorrente);
        myBank.abrirConta("Maria", "maria@email.com", TipoConta.ContaCorrente);
    }

    // Faz os primeiros depositos
    private static void TestaDepositoSucesso_200(Deprecated_Banco myBank) throws Exception {
        myBank.depositar(0, 200.00);
        myBank.depositar(1, 400.00);
        myBank.depositar(2, 600.00);
    }

    // Faz a transferencia entre contas
    private static void TestaTransferenciaSucesso_200(Deprecated_Banco myBank, Deprecated_ContaDefault contaDoJose, Deprecated_ContaDefault contaDoPedro) {
        System.out.println(contaDoJose);
        System.out.println(contaDoPedro);
        myBank.transferir(contaDoJose, contaDoPedro, 100.00);
        System.out.println(contaDoJose);
        System.out.println(contaDoPedro);
    }
}