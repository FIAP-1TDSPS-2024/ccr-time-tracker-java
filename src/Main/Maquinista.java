package Main;

public class Maquinista extends Funcionario {
    private Trem trem;

    public Maquinista(String nome, String cpf, String email, String senha) {
        super(nome, cpf, email, senha, "Maquinista");
    }

    public Trem getTrem() {
        return trem;
    }

    public void setTrem(Trem trem) {
        this.trem = trem;
    }

    public void andar() {
        System.out.println("Dirigindo trem " + trem.getNome());
    }

    public void estacionar() {
        System.out.println("Estacionando trem " + trem.getNome());
    }

    public void abrirPortas() {
        System.out.println("Abrindo portas do trem " + trem.getNome());
    }

    public void fecharPortas() {
        System.out.println("Fechando portas do trem " + trem.getNome());
    }
}
