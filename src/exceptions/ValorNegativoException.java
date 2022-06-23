package src.exceptions;

public class ValorNegativoException extends Exception {

    public ValorNegativoException() {
        super(String.format("O valor informado é negativo e por isso nao foi possivel concluir a operação"));
    }

}
