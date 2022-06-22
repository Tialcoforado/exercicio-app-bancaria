import java.time.LocalDateTime;

public class Lancamentos {
    String tipoLancamento;
    Double valor;
    LocalDateTime lancamentoDateTime;

    public Lancamentos(String tipoLancamento, Double valor, LocalDateTime lancamentoDateTime) {
        this.tipoLancamento = tipoLancamento;
        this.valor = valor;
        this.lancamentoDateTime = lancamentoDateTime;
    }

    public String getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getLancamentoDateTime() {
        return lancamentoDateTime;
    }

    public void setLancamentoDateTime(LocalDateTime lancamentoDateTime) {
        this.lancamentoDateTime = lancamentoDateTime;
    }

    @Override
    public String toString() {
        return "Lancamentos [lancamentoDateTime=" + lancamentoDateTime + ", tipoLancamento=" + tipoLancamento
                + ", valor=" + valor + "]";
    }
}
