import javax.swing.*;
import java.util.List;

public class mostrarFuncionarios {
    private List<Funcionario> funcionarios;

    public mostrarFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void mostrarTodosFuncionarios() {
        StringBuilder mensagem = new StringBuilder("Funcionários cadastrados:\n");

        for (Funcionario funcionario : funcionarios) {
            mensagem.append("Código: ").append(funcionario.getCodigo())
                    .append(", Nome: ").append(funcionario.getNome())
                    .append(", Cargo: ").append(funcionario.getCargo())
                    .append(", Salário: ").append(funcionario.getSalario())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null, mensagem.toString());
    }
}
