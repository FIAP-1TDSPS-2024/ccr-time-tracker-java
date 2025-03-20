package model.bo;

import model.vo.Viagem;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public class ViagemBO {

    private Viagem viagem;
    private FuncionarioBO funcionario;

    public ViagemBO(Viagem viagem, FuncionarioBO funcionario) {
        this.viagem = viagem;
        this.funcionario = funcionario;
    }

    public void iniciarPercurso() {
        System.out.println("Iniciando percurso de " + viagem.getEstacaoOrigem().getNome() + " até " + viagem.getEstacaoDestino().getNome());
        viagem.setDataInicio(new Timestamp(System.currentTimeMillis()));

    }

    public void finalizarPercurso() {
        System.out.println("Finalizando percurso de " + viagem.getEstacaoOrigem().getNome() + " até " + viagem.getEstacaoDestino().getNome());
        viagem.setDataFim(new Timestamp(System.currentTimeMillis()));
    }

    public void imprimirTempoDePercurso() {
        LocalDateTime inicio = viagem.getDataInicio().toLocalDateTime();
        LocalDateTime fim = viagem.getDataFim().toLocalDateTime();
        Duration duracao = Duration.between(inicio, fim);

        long duracaoEmSegundos = duracao.getSeconds();
        System.out.println("Tempo de percurso: " + duracaoEmSegundos + " segundos");
    }
}
