package src.models.clientes;

public class ClientePj extends Cliente {
    private String cnpj;
    public static final double TAXA_EXTRA = 1.005;
    public static final double RENDIMENTO_EXTRA = 1.02;

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
