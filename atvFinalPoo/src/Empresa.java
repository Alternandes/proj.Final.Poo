import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class Empresa {
    private List<Funcionario> funcionarios;

    public Empresa() {
        funcionarios = new ArrayList<>();
    }

    public void cadastrarFuncionario() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do funcionário:"));
        String nome = JOptionPane.showInputDialog("Digite o nome do funcionário:");
        String cargo = JOptionPane.showInputDialog("Digite o cargo do funcionário:");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do funcionário:"));

        Funcionario funcionario = new Funcionario(codigo, nome, cargo, salario);

        int quantidadeDependentes = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de dependentes do funcionário:"));

        for (int i = 0; i < quantidadeDependentes; i++) {
            String nomeDependente = JOptionPane.showInputDialog("Digite o nome do dependente " + (i + 1) + " do funcionário:");
            Dependente dependente = new Dependente(nomeDependente);
            funcionario.adicionarDependente(dependente);
        }

        funcionarios.add(funcionario);

        JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
    }

    public void mostrarBonusMensal() {
        StringBuilder mensagem = new StringBuilder();

        for (Funcionario funcionario : funcionarios) {
            double bonus = funcionario.getBonusMensal();

            mensagem.append("Nome: ").append(funcionario.getNome())
                    .append(", Dependentes: ").append(funcionario.getDependentes().size())
                    .append(", Bônus: ").append(bonus).append("\n");
        }

        try {
            FileWriter fileWriter = new FileWriter("bonus_mensal.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(mensagem.toString());
            printWriter.close();
            JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso: bonus_mensal.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar arquivo de texto: " + e.getMessage());
        }
    }

    public void excluirFuncionario() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do funcionário para excluir:"));

        Funcionario funcionarioExcluir = null;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCodigo() == codigo) {
                funcionarioExcluir = funcionario;
                break;
            }
        }

        if (funcionarioExcluir != null) {
            funcionarios.remove(funcionarioExcluir);
            JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário Inexistente");
        }
    }

    public void alterarSalarioFuncionario() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do funcionário para alterar o salário:"));

        Funcionario funcionarioAlterar = null;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCodigo() == codigo) {
                funcionarioAlterar = funcionario;
                break;
            }
        }

        if (funcionarioAlterar != null) {
            double salarioAtual = funcionarioAlterar.getSalario();
            double novoSalario = Double.parseDouble(JOptionPane.showInputDialog("Salário atual: " + salarioAtual + "\nDigite o novo salário:"));
            funcionarioAlterar.setSalario(novoSalario);
            JOptionPane.showMessageDialog(null, "Salário alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário Inexistente");
        }
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