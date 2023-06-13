
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        while (true) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção:\n" +
                    "1. Cadastrar funcionário\n" +
                    "2. Mostrar bônus mensal de cada funcionário\n" +
                    "3. Excluir funcionário\n" +
                    "4. Alterar salário de um funcionário\n" +
                    "5. Monstrar funcionarios\n"+
                    "0. Sair"));

            switch (opcao) {
                case 1:
                    empresa.cadastrarFuncionario();
                    break;
                case 2:
                    empresa.mostrarBonusMensal();
                    break;
                case 3:
                    empresa.excluirFuncionario();
                    break;
                case 4:
                    empresa.alterarSalarioFuncionario();
                    break;
                case 5:
                    empresa.mostrarTodosFuncionarios();
                    break;
                case 0:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }
}
