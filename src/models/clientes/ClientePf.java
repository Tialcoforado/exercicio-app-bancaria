package src.models.clientes;
public class ClientePf extends Cliente {
    String cpf;

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