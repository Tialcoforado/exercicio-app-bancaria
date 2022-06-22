package src.models.clientes;
public class ClientePj extends Cliente {
    private String cnpj;

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
