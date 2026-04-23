// ## Exercício 1 — Classe abstrata básica

// Crie a hierarquia:

// **`Forma`** (abstrata)

// - Atributos `protected`: `cor`
// - Construtor com `cor`
// - Métodos abstratos: `calcularArea()`, `calcularPerimetro()`
// - Método concreto: `descricao()` → imprime cor, área e perímetro formatados

// **`Circulo`** (filho)

// - Atributo extra: `raio`
// - Implemente os dois métodos abstratos
// - Use `Math.PI` para o cálculo

// **`Retangulo`** (filho)

// - Atributos extras: `largura`, `altura`
// - Implemente os dois métodos abstratos

// **`Triangulo`** (filho)

// - Atributos extras: `ladoA`, `ladoB`, `ladoC`
// - Perímetro: soma dos lados
// - Área: fórmula de Heron → `Math.sqrt(s * (s-a) * (s-b) * (s-c))` onde `s = (a+b+c)/2`

// No `main`, crie um de cada, chame `descricao()` via polimorfismo com array `Forma[]`.

public class Exercicio01 {
    public static void main(String[] args) {
        Forma[] formas = new Forma[3];
        formas[0] = new Circulo("Vermelho", 5);
        formas[1] = new Retangulo("Azul", 4, 6);
        formas[2] = new Triangulo("Verde", 3, 4, 5);

        for (Forma forma : formas) {
            forma.descricao();
            System.out.println();
        }
    }
}

abstract class Forma {

    protected String cor;

    public Forma(String cor) {
        this.cor = cor;
    }

    public abstract double calcularArea();

    public abstract double calcularPerimetro();

    public void descricao() {
        System.out.println("Cor: " + cor);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
    }
}

class Circulo extends Forma {

    private double raio;

    public Circulo(String cor, double raio) {
        super(cor);
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(raio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
}

class Retangulo extends Forma {

    private double largura;
    private double altura;

    public Retangulo(String cor, double largura, double altura) {
        super(cor);
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (largura + altura);
    }
}

class Triangulo extends Forma {

    private double ladoA;
    private double ladoB;
    private double ladoC;

    public Triangulo(String cor, double ladoA, double ladoB, double ladoC) {
        super(cor);
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    @Override
    public double calcularArea() {
        double s = (ladoA + ladoB + ladoC) / 2;
        return Math.sqrt(s * (s - ladoA) * (s - ladoB) * (s - ladoC));
    }

    @Override
    public double calcularPerimetro() {
        return ladoA + ladoB + ladoC;
    }
}