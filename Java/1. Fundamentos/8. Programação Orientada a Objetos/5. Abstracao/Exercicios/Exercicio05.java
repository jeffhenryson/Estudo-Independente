// ## 5. Sistema de Entrega de Pedidos

// **Enunciado:** Crie uma classe abstrata `ServicoEntrega` com um construtor que recebe `String enderecoDestino` e `double pesoKg`.
// * Crie um método abstrato `double calcularFrete()`.
// * Crie as subclasses `FreteExpresso` e `FreteEconomico`.
// * No `FreteExpresso`, o cálculo é feito cobrando `pesoKg * 5.0 + 20.0` (taxa de urgência).
// * No `FreteEconomico`, o cálculo é feito cobrando `pesoKg * 2.0`.
// * Teste a abstração calculando o frete de diferentes pedidos.

public class Exercicio05 {
    public static void main(String[] args) {
        FreteExpresso freteExpresso = new FreteExpresso("Rua A, 123", 10);
        FreteEconomico freteEconomico = new FreteEconomico("Rua B, 456", 10);

        System.out.println("Frete Expresso: R$ " + freteExpresso.calcularFrete());
        System.out.println("Frete Econômico: R$ " + freteEconomico.calcularFrete());
    }
}

class ServicoEntrega {
    protected String enderecoDestino;
    protected double pesoKg;

    public ServicoEntrega(String enderecoDestino, double pesoKg) {
        this.enderecoDestino = enderecoDestino;
        this.pesoKg = pesoKg;
    }

    public double calcularFrete() {
        return 0;
    }
}

class FreteExpresso extends ServicoEntrega {
    public FreteExpresso(String enderecoDestino, double pesoKg) {
        super(enderecoDestino, pesoKg);
    }

    @Override
    public double calcularFrete() {
        return pesoKg * 5.0 + 20.0;
    }
}

class FreteEconomico extends ServicoEntrega {
    public FreteEconomico(String enderecoDestino, double pesoKg) {
        super(enderecoDestino, pesoKg);
    }

    @Override
    public double calcularFrete() {
        return pesoKg * 2.0;
    }
}
