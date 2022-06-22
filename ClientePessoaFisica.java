public class ClientePessoaFisica extends Cliente {
    String cpf;

    public ClientePessoaFisica(String nome, String email, String cpf) {
        super(nome, email);
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return super.toString() + "ClientePessoaFisica [cpf=" + cpf + "]";
    }
       
}