// ## 1. Classe Produto com Validação de Preço

// **Enunciado:** Crie uma classe chamada `Produto` com os seguintes atributos privados: `String nome` e `double preco`. 
// * Crie um construtor que receba o nome e o preço.
// * Implemente os métodos `getters` e `setters`.
// * No `setter` do `preco`, adicione uma validação para que não seja permitido cadastrar um preço negativo. 
// Caso o valor seja menor ou igual a 0, exiba uma mensagem de erro e não altere o valor.

public class Exercicio01 {
    public static void main(String[] args) {

        Produto produto1 = new Produto("Notebook", 2500.00);
        System.out.println("Produto: " + produto1.getNome() + ", Preço: " + produto1.getPreco());

        // Tentando definir um preço negativo
        produto1.setPreco(-500.00); // Deve exibir uma mensagem de erro

        // Verificando se o preço foi alterado
        System.out.println("Produto: " + produto1.getNome() + ", Preço: " + produto1.getPreco());
    }
}

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        setPreco(preco); // Usando o setter para aplicar a validação
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
        } else {
            System.out.println("Erro: O preço deve ser maior que zero. Preço não alterado.");
        }
    }
}