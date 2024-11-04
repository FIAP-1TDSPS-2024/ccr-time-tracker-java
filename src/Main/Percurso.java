package Main;

import java.time.Duration;
import java.time.LocalDateTime;

public class Percurso {

    private Estacao estacaoOrigem;
    private Estacao estacaoDestino;
    private Linha linha;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public Percurso(Estacao estacaoOrigem, Estacao estacaoDestino, Linha linha) {
        this.estacaoOrigem = estacaoOrigem;
        this.estacaoDestino = estacaoDestino;
        this.linha = linha;
    }

    public Estacao getestacaoOrigem() {
        return estacaoOrigem;
    }

    public Estacao getestacaoDestino() {
        return estacaoDestino;
    }

    public Linha getLinha() {
        return linha;
    }

    public void setestacaoOrigem(Estacao estacaoOrigem) {
        this.estacaoOrigem = estacaoOrigem;
    }

    public void setEstacaoDestino(Estacao estacaoDestino) {
        this.estacaoDestino = estacaoDestino;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void iniciarPercurso() {
        System.out.println("Iniciando percurso de " + estacaoOrigem.getNome() + " até " + estacaoDestino.getNome());
        this.dataInicio = LocalDateTime.now();
    }

    public void finalizarPercurso() {
        System.out.println("Finalizando percurso de " + estacaoOrigem.getNome() + " até " + estacaoDestino.getNome());
        this.dataFim = LocalDateTime.now();
    }

    public void imprimirTempoDePercurso() {
        Duration duracao = Duration.between(dataInicio, dataFim);
        long duracaoEmSegundos = duracao.getSeconds();
        System.out.println("Tempo de percurso: " + duracaoEmSegundos + " segundos");
    }

}
