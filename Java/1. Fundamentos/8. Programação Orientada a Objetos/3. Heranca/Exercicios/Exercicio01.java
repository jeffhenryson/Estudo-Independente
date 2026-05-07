// ## 1. Sistema de Veículos

// **Enunciado:** Crie uma classe chamada `Veiculo` com os atributos protegidos `marca`, `modelo` e `ano`.
// * Crie um construtor e um método chamado `exibirDetalhes()` que imprima essas informações.
// * Crie uma subclasse chamada `Carro` que herda de `Veiculo` e adiciona o atributo privado `int numeroDePortas`.
// * Crie um construtor na classe `Carro` utilizando a palavra `super` para inicializar a classe mãe, e adicione um método que exiba as portas do carro.

public class Exercicio01 {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla", 2020, 4);
        carro.exibirDetalhes();
        carro.exibirNumeroDePortas();
    }
}

class Carro extends Veiculo {
    private int numeroDePortas;

    public Carro(String marca, String modelo, int ano, int numeroDePortas) {
        super(marca, modelo, ano);
        this.numeroDePortas = numeroDePortas;
    }

    public void exibirNumeroDePortas() {
        System.out.println("Número de portas: " + this.numeroDePortas);
    }
}

class Veiculo {
    protected String marca;
    protected String modelo;
    protected int ano;

    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void exibirDetalhes() {
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Ano: " + this.ano);
    }
}
