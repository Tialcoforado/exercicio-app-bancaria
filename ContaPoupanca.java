import src.models.contas.TipoConta;

public class ContaPoupanca extends ContaDefault {
    private static Integer counterId = 0;
    Integer idConta;
    String titularConta;
    Double saldo = 0.00;
    TipoConta tipoDeConta;

    public ContaPoupanca() {
    }

    public ContaPoupanca(ContaDefault conta, Double saldo) {
        this.idConta = counterId;
        this.titularConta = conta.getTitularConta();
        this.saldo = saldo;
        this.tipoDeConta = TipoConta.ContaPoupanca;
        counterId++;
    }

    public static Integer getCounterId() {
        return counterId;
    }

    public static void setCounterId(Integer counterId) {
        ContaPoupanca.counterId = counterId;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public String getTitularConta() {
        return titularConta;
    }

    public void setTitularConta(String titularConta) {
        this.titularConta = titularConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaPoupanca [idConta=" + idConta + ", saldo=" + saldo + ", titularConta=" + titularConta
                + ", TipoDeConta= " + tipoDeConta + "]";
    }
}
