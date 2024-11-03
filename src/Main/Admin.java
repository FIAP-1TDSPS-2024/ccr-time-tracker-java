package Main;

public class Admin extends Funcionario {

    public Admin(String nome, String cpf, String email, String senha) {
        super(nome, cpf, email, senha, "Admin");
    }

    public void cadastrarFuncionario(Empresa empresa, Funcionario funcionario) {
        empresa.cadastrarFuncionario(funcionario);
    }

    public void removerFuncionario(Empresa empresa, Funcionario funcionario) {
        empresa.removerFuncionario(funcionario);
    }
}
