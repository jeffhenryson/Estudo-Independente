// ## Exercício 5 — Encapsulamento + Herança + Polimorfismo juntos

// Crie a hierarquia:

// **`Funcionario`** (pai)

// - Atributos `private`: `nome`, `salarioBase`
// - Construtor + getters
// - Método `calcularSalario()` → retorna `salarioBase`
// - Método `toString()`

// **`Desenvolvedor`** (filho)

// - Atributo extra: `bonusPorProjeto`
// - `@Override calcularSalario()` → `salarioBase + bonusPorProjeto`

// **`Gerente`** (filho)

// - Atributo extra: `percentualBonus`
// - `@Override calcularSalario()` → `salarioBase * (1 + percentualBonus)`

// **`Estagiario`** (filho)

// - Atributo extra: `bolsaAuxilio`
// - `@Override calcularSalario()` → só retorna `bolsaAuxilio` (não tem salarioBase)

// No `main`:

// 1. Crie um array `Funcionario[]` com um de cada tipo
// 2. Calcule e imprima o salário de cada um via polimorfismo
// 3. Some a folha de pagamento total iterando o array

public class Exercicio05 {
    public static void main(String[] args) {

        // Criando um array de Funcionario com diferentes tipos de funcionários
        Funcionario[] funcionarios = {
            new Desenvolvedor("Alice", 5000, 1000),
            new Gerente("Bob", 8000, 0.2),
            new Estagiario("Charlie", 0, 1500)
        };

        double folhaPagamentoTotal = 0;

        // Iterando sobre o array e calculando o salário de cada funcionário via polimorfismo
        for (Funcionario funcionario : funcionarios) {
            double salario = funcionario.calcularSalario();
            System.out.println(funcionario + ", Salário: " + salario);
            folhaPagamentoTotal += salario;
        }

        System.out.println("Folha de Pagamento Total: " + folhaPagamentoTotal);

    }
}

class Funcionario {

    private String nome;
    private double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double calcularSalario() {
        return salarioBase;
    }

    @Override
    public String toString() {
        return "Funcionario: " + nome + ", Salário Base: " + salarioBase;
    }
}

class Desenvolvedor extends Funcionario {

    private double bonusPorProjeto;

    public Desenvolvedor(String nome, double salarioBase, double bonusPorProjeto) {
        super(nome, salarioBase);
        this.bonusPorProjeto = bonusPorProjeto;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + bonusPorProjeto;
    }
}

class Gerente extends Funcionario {

    private double percentualBonus;

    public Gerente(String nome, double salarioBase, double percentualBonus) {
        super(nome, salarioBase);
        this.percentualBonus = percentualBonus;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() * (1 + percentualBonus);
    }
}

class Estagiario extends Funcionario {

    private double bolsaAuxilio;

    public Estagiario(String nome, double salarioBase, double bolsaAuxilio) {
        super(nome, salarioBase);
        this.bolsaAuxilio = bolsaAuxilio;
    }

    @Override
    public double calcularSalario() {
        return bolsaAuxilio;
    }
}
