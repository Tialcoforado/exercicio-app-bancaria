package src.models.clientes;
public class ClientePf extends Cliente {
    String cpf;
    public static final double taxaExtra = 0.005;
    public static final double rendimentoExtra = 0.02;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getDocumento() {
        return this.cpf;
    }

       
}