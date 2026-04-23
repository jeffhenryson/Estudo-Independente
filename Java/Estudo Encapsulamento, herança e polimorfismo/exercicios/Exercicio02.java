// ## Exercício 2 — Herança básica

// Crie a hierarquia:

// **`Veiculo`** (pai)

// - Atributos `protected`: `marca`, `modelo`, `velocidadeAtual`
// - Construtor com `marca` e `modelo`
// - Métodos: `acelerar(int km)`, `frear(int km)`, `toString()`

// **`Carro`** (filho)

// - Atributo extra: `quantidadePortas`
// - Construtor com `super` + `quantidadePortas`
// - `Override toString()`

// **`Moto`** (filho)

// - Atributo extra: `temSidecar`
// - Construtor com `super` + `temSidecar`
// - `Override toString()`

// No `main`, crie um `Carro` e uma `Moto`, acelere e freie ambos, imprima.

public class Exercicio02 {
    public static void main(String[] args) {

        car carro = new car("Toyota", "Corolla", 4);
        moto moto = new moto("Honda", "CB500", false);

        System.out.println(carro);
        System.out.println(moto);

        carro.acelerar(50);
        moto.acelerar(30);

        System.out.println(carro);
        System.out.println(moto);

        carro.frear(20);
        moto.frear(10);

        System.out.println(carro);
        System.out.println(moto);
    }
}

class veiculo {

    protected String marca;
    protected String modelo;
    protected int velocidadeAtual;

    public veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadeAtual = 0;
    }

    public void acelerar(int km) {
        velocidadeAtual += km;
    }

    public void frear(int km) {
        velocidadeAtual -= km;
        if (velocidadeAtual < 0) {
            velocidadeAtual = 0;
        }
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocidadeAtual=" + velocidadeAtual +
                '}';
    }
}

class car extends veiculo {

    private int quantidadePortas;

    public car(String marca, String modelo, int quantidadePortas) {
        super(marca, modelo);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocidadeAtual=" + velocidadeAtual +
                ", quantidadePortas=" + quantidadePortas +
                '}';
    }
}

class moto extends veiculo {

    private boolean temSidecar;

    public moto(String marca, String modelo, boolean temSidecar) {
        super(marca, modelo);
        this.temSidecar = temSidecar;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocidadeAtual=" + velocidadeAtual +
                ", temSidecar=" + temSidecar +
                '}';
    }
}