// ## 2. Tributação de Produtos

// **Enunciado:** Crie uma classe chamada `Produto` com um método `calcularImposto()` que retorna um valor padrão (por exemplo, 10% do preço).
// * Crie duas subclasses:
//   * `Eletronico`
//   * `Alimento`
// * Sobrescreva o método `calcularImposto()` em cada subclasse:
//   * Para `Eletronico`, o imposto deve ser de 30%.
//   * Para `Alimento`, o imposto deve ser isento (0%).
// * No `main`, crie uma lista de produtos de diferentes tipos e exiba o imposto de cada um.

public class Exercicio02 {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Produto Genérico", 100.0);
        Eletronico produto2 = new Eletronico("Smartphone", 1000.0);
        Alimento produto3 = new Alimento("Pão", 5.0);

        System.out.println("Imposto do " + produto1.nome + ": " + produto1.calcularImposto());
        System.out.println("Imposto do " + produto2.nome + ": " + produto2.calcularImposto());
        System.out.println("Imposto do " + produto3.nome + ": " + produto3.calcularImposto());
    }
}

class Produto {
    protected String nome;
    protected double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public double calcularImposto() {
        return this.preco * 0.10; // Imposto padrão de 10%
    }
}

class Eletronico extends Produto {
    public Eletronico(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularImposto() {
        return this.preco * 0.30; // Imposto de 30% para eletrônicos
    }
}

class Alimento extends Produto {
    public Alimento(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularImposto() {
        return 0; // Isento de imposto para alimentos
    }
}
