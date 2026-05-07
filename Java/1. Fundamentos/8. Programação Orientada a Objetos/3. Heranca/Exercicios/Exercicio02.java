// ## 2. Funcionário e Subclasses

// **Enunciado:** Crie uma classe base chamada `Funcionario` com os atributos `String nome` e `double salario`.
// * Crie um método `calcularBonus()` que retorna `0.10 * salario` (10% de bônus).
// * Crie duas subclasses:
//   * `Gerente`, que adiciona o atributo `String departamento`.
//   * `Desenvolvedor`, que adiciona o atributo `String linguagem`.
// * Sobrescreva o método `calcularBonus()` na classe `Gerente` para retornar `0.20 * salario` (20% de bônus).

public class Exercicio02 {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Alice", 5000);
        Gerente gerente = new Gerente("Bob", 8000, "Vendas");
        Desenvolvedor desenvolvedor = new Desenvolvedor("Charlie", 6000, "Java");

        System.out.println(funcionario.nome + " - Bônus: " + funcionario.calcularBonus());
        System.out.println(gerente.nome + " - Bônus: " + gerente.calcularBonus());
        System.out.println(desenvolvedor.nome + " - Bônus: " + desenvolvedor.calcularBonus());
    }
}

class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double calcularBonus() {
        return 0.10 * salario; // Bônus padrão de 10%
    }
}

class Gerente extends Funcionario {
    private String departamento;

    public Gerente(String nome, double salario, String departamento) {
        super(nome, salario);
        this.departamento = departamento;
    }

    @Override
    public double calcularBonus() {
        return 0.20 * salario; // Bônus de 20% para gerentes
    }
}

class Desenvolvedor extends Funcionario {
    private String linguagem;

    public Desenvolvedor(String nome, double salario, String linguagem) {
        super(nome, salario);
        this.linguagem = linguagem;
    }
}