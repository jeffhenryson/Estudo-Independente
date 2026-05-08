// ## 1. Sistema de Funcionários e Salários

// **Enunciado:** Crie uma classe abstrata chamada `Funcionario` com o atributo protegido `String nome` e o atributo protegido `double salarioBase`.
// * Crie um construtor que inicialize esses atributos.
// * Crie um método abstrato `double calcularSalario()`.
// * Crie a subclasse `FuncionarioIntegral` que implementa o método retornando o próprio `salarioBase`.
// * Crie a subclasse `FuncionarioHorista` que adiciona os atributos privados `double horasTrabalhadas` e `double valorHora`. Implemente o método `calcularSalario()` multiplicando as horas pelo valor da hora.

public class Exercicio01 {
    public static void main(String[] args) {
        FuncionarioIntegral funcionario1 = new FuncionarioIntegral("Alice", 3000);
        FuncionarioHorista funcionario2 = new FuncionarioHorista("Bob", 0, 160, 20);

        System.out.println("Salário do Funcionario Integral: R$ " + funcionario1.calcularSalario());
        System.out.println("Salário do Funcionario Horista: R$ " + funcionario2.calcularSalario());
    }
}

class Funcionario {
    protected String nome;
    protected double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public double calcularSalario() {
        return salarioBase;
    }
}

class FuncionarioIntegral extends Funcionario {
    public FuncionarioIntegral(String nome, double salarioBase) {
        super(nome, salarioBase);
    }
}

class FuncionarioHorista extends Funcionario {
    private double horasTrabalhadas;
    private double valorHora;

    public FuncionarioHorista(String nome, double salarioBase, double horasTrabalhadas, double valorHora) {
        super(nome, salarioBase);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabalhadas * valorHora;
    }
}
