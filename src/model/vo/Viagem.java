package model.vo;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDateTime;

public class Viagem {

    private int id_viagem;
    private Estacao estacaoOrigem;
    private Estacao estacaoDestino;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public Viagem(int id_viagem, Estacao estacaoOrigem, Estacao estacaoDestino) {
        this.id_viagem = id_viagem;
        this.estacaoOrigem = estacaoOrigem;
        this.estacaoDestino = estacaoDestino;
    }

    public int getId_viagem() {
        return id_viagem;
    }

    public Estacao getEstacaoOrigem() {
        return estacaoOrigem;
    }

    public Estacao getEstacaoDestino() {
        return estacaoDestino;
    }

    public Estacao getestacaoOrigem() {
        return estacaoOrigem;
    }

    public Estacao getestacaoDestino() {
        return estacaoDestino;
    }

    public void setEstacaoOrigem(Estacao estacaoOrigem) {
        this.estacaoOrigem = estacaoOrigem;
    }

    public void setEstacaoDestino(Estacao estacaoDestino) {
        this.estacaoDestino = estacaoDestino;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
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
