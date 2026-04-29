// ## Exercício 4 — Atributos de classe vs variáveis locais

// Dado o código abaixo, responda **sem rodar**: o que será impresso e por quê?

public class Exercicio04 {
    public static void main(String[] args) {
        Produto produto = new Produto();
        produto.mostrar();
    }
}

class Produto {

    String nome;
    double preco;
    boolean disponivel;

    public void mostrar() {
        System.out.println(nome); // Null
        System.out.println(preco); // 0
        System.out.println(disponivel); // false
    }
}