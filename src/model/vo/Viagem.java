package model.vo;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.List;

public class Viagem {

    private int id_viagem;
    private Estacao estacaoOrigem;
    private Estacao estacaoDestino;
    private Timestamp dataInicio;
    private Timestamp dataFim;
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

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public Timestamp getDataFim() {
        return dataFim;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Timestamp dataFim) {
        this.dataFim = dataFim;
    }
}
