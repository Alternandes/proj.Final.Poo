import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private int codigo;
    private String nome;
    private String cargo;
    private double salario;
    private List<Dependente> dependentes;

    public Funcionario(int codigo, String nome, String cargo, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.dependentes = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void adicionarDependente(Dependente dependente) {
        dependentes.add(dependente);
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public double getBonusMensal() {
        return dependentes.size() * 0.02 * salario;
    }
}