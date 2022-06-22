public class ClientePessoaJuridica extends Cliente {
    String cnpj;

    public ClientePessoaJuridica(String nome, String email, String cnpj) {
        super(nome, email);
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "ClientePessoaJuridica [cnpj=" + cnpj + "]";
    }

}
