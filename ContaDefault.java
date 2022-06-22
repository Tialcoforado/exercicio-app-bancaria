public class ContaDefault {
    private static Integer counterId = 0;
    Integer idConta;
    String titularConta;
    Double saldo = 0.00;
    TipoDeConta tipoDeConta;

    public ContaDefault() {
    }

    public ContaDefault(Cliente cliente, Double saldo, TipoDeConta tipoDeConta) {
        this.idConta = counterId;
        this.titularConta = cliente.getNome();
        this.saldo = saldo;
        this.tipoDeConta = tipoDeConta;
        counterId++;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta() {
        this.idConta = counterId;
        counterId++;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getTitularConta() {
        return titularConta;
    }

    public void setTitularConta(String titularConta) {
        this.titularConta = titularConta;
    }

    public TipoDeConta getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(TipoDeConta tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    @Override
    public String toString() {
        return "Conta [idConta=" + idConta + ", saldo=" + saldo + ", titularConta=" + titularConta + ", TipoDeConta= " + tipoDeConta + "]";
    }
}
