package src.models.clientes;
public class ClientePj extends Cliente {
    private String cnpj;
    public static final double taxaExtra = 0.005;
    public static final double rendimentoExtra = 0.02;

    

    @Override
    public String getDocumento() {
        return this.cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
}
