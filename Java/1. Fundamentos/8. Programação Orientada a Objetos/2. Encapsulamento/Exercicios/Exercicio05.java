// ## 5. Classe Retângulo com Área e Perímetro

// **Enunciado:** Crie uma classe `Retangulo` com os atributos privados `double largura` e `double altura`.
// * Crie um construtor para inicializar ambos os lados com valores válidos (maior que 0).
// * Crie `getters` e `setters` que impeçam valores menores ou iguais a zero.
// * Crie métodos públicos que retornem a `calcularArea()` e o `calcularPerimetro()`.

public class Exercicio05 {
    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo(5.0, 3.0);
        System.out.println("Área: " + retangulo.calcularArea());
        System.out.println("Perímetro: " + retangulo.calcularPerimetro());
    }
}

class Retangulo {
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        setLargura(largura); // Usando os setters para aplicar a validação
        setAltura(altura);
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        if (largura > 0) {
            this.largura = largura;
        } else {
            System.out.println("Erro: A largura deve ser maior que zero. Largura não alterada.");
        }
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            System.out.println("Erro: A altura deve ser maior que zero. Altura não alterada.");
        }
    }

    public double calcularArea() {
        return this.largura * this.altura;
    }

    public double calcularPerimetro() {
        return 2 * (this.largura + this.altura);
    }
}
