package src.exceptions;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException() {
        super(String.format("O valor informado é negativo e por isso nao foi possivel concluir a operação"));
    }
}
