// ## 5. Veículos e Multas

// **Enunciado:** Crie uma classe `Veiculo` com um método `calcularMulta(double velocidade)` que calcula uma multa genérica caso a velocidade ultrapasse o limite de 80 km/h.
// * Crie as subclasses `Carro` e `Moto`:
//   * `Carro` deve ter um cálculo de multa diferenciado (ex: valor fixo + valor por km ultrapassado).
//   * `Moto` deve ter um cálculo com desconto na multa.
// * Demonstre o polimorfismo ao testar o método com diferentes instâncias.

public class Exercicio05 {
    public static void main(String[] args) {
        Veiculo veiculo1 = new Veiculo();
        Carro carro1 = new Carro();
        Moto moto1 = new Moto();

        double velocidadeTeste = 100; // Velocidade de teste

        System.out.println("Multa para Veículo: R$ " + veiculo1.calcularMulta(velocidadeTeste));
        System.out.println("Multa para Carro: R$ " + carro1.calcularMulta(velocidadeTeste));
        System.out.println("Multa para Moto: R$ " + moto1.calcularMulta(velocidadeTeste));
    }   
}

class Veiculo {
    public double calcularMulta(double velocidade) {
        if (velocidade > 80) {
            return (velocidade - 80) * 5; // Multa genérica: R$ 5 por km/h acima do limite
        }
        return 0;
    }
}

class Carro extends Veiculo {
    @Override
    public double calcularMulta(double velocidade) {
        if (velocidade > 80) {
            return 50 + (velocidade - 80) * 5; // Multa: R$ 50 fixo + R$ 5 por km/h acima do limite
        }
        return 0;
    }
}

class Moto extends Veiculo {
    @Override
    public double calcularMulta(double velocidade) {
        if (velocidade > 80) {
            return (velocidade - 80) * 5 * 0.8; // Multa com desconto de 20%
        }
        return 0;
    }
}
