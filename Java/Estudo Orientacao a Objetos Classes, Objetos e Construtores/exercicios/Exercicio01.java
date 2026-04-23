// ## Exercício 1 — Classe básica

// Crie uma classe `Produto` com:

// - Atributos: `nome`, `preco`, `estoque`
// - Um construtor completo
// - Um método `aplicarDesconto(double percentual)` que reduz o preço
// - Um método `toString()` que retorna:

// ```
// Produto{nome=Plano Pro, preco=149,90, estoque=100}
// ```

// No `main`, crie 3 produtos, aplique descontos diferentes e imprima cada um.

public class Exercicio01 {
    public static void main(String[] args) {
        product produto1 = new product("Plano Pro", 149.90, 100);
        product produto2 = new product("Plano Básico", 99.90, 200);
        product produto3 = new product("Plano Premium", 199.90, 50);

        produto1.aplicarDesconto(10); // Desconto de 10%
        produto2.aplicarDesconto(20); // Desconto de 20%
        produto3.aplicarDesconto(15); // Desconto de 15%

        System.out.println(produto1);
        System.out.println(produto2);
        System.out.println(produto3);
    }
}

class product{

    String nome;
    double preco;
    int estoque;

    // Construtor completo
    public product(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    // Método para aplicar desconto
    public void aplicarDesconto(double percentual) {
        this.preco -= this.preco * percentual / 100;
    }

    // Método toString
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                '}';
    }
}
