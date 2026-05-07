// ## 3. Funcionários e Comissão

// **Enunciado:** Crie uma classe base `Funcionario` com o método `calcularSalario()` que retorna o salário fixo.
// * Crie subclasses `Vendedor` e `Gerente`:
//   * `Vendedor` deve adicionar o atributo `comissao` e sobrescrever o método para adicionar a comissão ao salário base.
//   * `Gerente` deve adicionar o atributo `bonus` e sobrescrever o método adicionando o bônus ao salário base.
// * Utilize o polimorfismo para calcular e imprimir o salário de vários tipos de funcionários.

public class Exercicio03 {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario(3000);
        Vendedor vendedor1 = new Vendedor(2500, 500);
        Gerente gerente1 = new Gerente(4000, 1000);

        System.out.println("Salário do Funcionário: R$ " + funcionario1.calcularSalario());
        System.out.println("Salário do Vendedor: R$ " + vendedor1.calcularSalario());
        System.out.println("Salário do Gerente: R$ " + gerente1.calcularSalario());
    }
}

class Funcionario {
    protected double salarioBase;

    public Funcionario(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double calcularSalario() {
        return this.salarioBase;
    }
}

class Vendedor extends Funcionario {
    private double comissao;

    public Vendedor(double salarioBase, double comissao) {
        super(salarioBase);
        this.comissao = comissao;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + this.comissao;
    }
}

class Gerente extends Funcionario {
    private double bonus;

    public Gerente(double salarioBase, double bonus) {
        super(salarioBase);
        this.bonus = bonus;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + this.bonus;
    }
}
