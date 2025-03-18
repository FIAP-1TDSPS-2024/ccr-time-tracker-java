package model.vo;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.List;

public class Viagem {

    private int id_viagem;
    private Estacao estacaoOrigem;
    private Estacao estacaoDestino;
    private Date dataInicio;
    private Date dataFim;
    private Linha linha;
    private Trem trem;


    public Viagem(int id_viagem, Estacao estacaoOrigem, Estacao estacaoDestino, Linha linha, Trem trem) {
        this.id_viagem = id_viagem;
        this.estacaoOrigem = estacaoOrigem;
        this.estacaoDestino = estacaoDestino;
        this.linha = linha;
        this.trem = trem;
    }

    public Linha getLinha() {
        return linha;
    }

    public Trem getTrem() {
        return trem;
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
        this.dataInicio = Date.valueOf(LocalDate.now());
    }

    public void finalizarPercurso() {
        System.out.println("Finalizando percurso de " + estacaoOrigem.getNome() + " até " + estacaoDestino.getNome());
        this.dataFim = Date.valueOf(LocalDate.now());
    }

    public void imprimirTempoDePercurso() {
        Duration duracao = Duration.between((Temporal) dataInicio, (Temporal) dataFim);
        long duracaoEmSegundos = duracao.getSeconds();
        System.out.println("Tempo de percurso: " + duracaoEmSegundos + " segundos");
    }

}
