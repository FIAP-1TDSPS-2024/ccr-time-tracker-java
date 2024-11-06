package Main;

public class Admin extends Funcionario {

    private Empresa empresa;

    public Admin(String nome, String cpf, String email, String senha, Empresa empresa) {
        super(nome, cpf, email, senha, "Admin");
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        this.empresa.cadastrarFuncionario(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        this.empresa.removerFuncionario(funcionario);
    }

    public void promoteFuncionario(Funcionario funcionario, String cargo) {
        this.empresa.promoteFuncionario(funcionario, cargo);
    }

}
