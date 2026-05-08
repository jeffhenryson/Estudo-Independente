// ## 4. Sistema de Tributação de Veículos

// **Enunciado:** Crie uma classe abstrata `Veiculo` com o atributo protegido `double valorVeiculo` e um método abstrato `double calcularIPVA()`.
// * Crie as subclasses `Carro` e `Caminhao`.
// * `Carro` deve calcular o IPVA aplicando uma taxa de $4\%$ sobre o valor do veículo.
// * `Caminhao` deve calcular o IPVA aplicando uma taxa de $1{,}5\%$ sobre o valor do veículo.
// * Imprima o valor do IPVA de instâncias de ambas as classes.

public class Exercicio04 {
    public static void main(String[] args) {
        Carro carro = new Carro(50000);
        Caminhao caminhao = new Caminhao(150000);

        System.out.println("IPVA do carro: R$ " + carro.calcularIPVA());
        System.out.println("IPVA do caminhão: R$ " + caminhao.calcularIPVA());
    }
}

class Veiculo {
    protected double valorVeiculo;

    public Veiculo(double valorVeiculo) {
        this.valorVeiculo = valorVeiculo;
    }

    public double calcularIPVA() {
        return 0;
    }
}

class Carro extends Veiculo {
    public Carro(double valorVeiculo) {
        super(valorVeiculo);
    }

    @Override
    public double calcularIPVA() {
        return valorVeiculo * 0.04;
    }
}

class Caminhao extends Veiculo {
    public Caminhao(double valorVeiculo) {
        super(valorVeiculo);
    }

    @Override
    public double calcularIPVA() {
        return valorVeiculo * 0.015;
    }
}
