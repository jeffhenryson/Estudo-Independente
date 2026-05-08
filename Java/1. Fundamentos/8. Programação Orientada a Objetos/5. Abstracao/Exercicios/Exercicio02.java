// ## 2. Sistema de Pagamentos

// **Enunciado:** Crie uma classe abstrata `MetodoPagamento` que contenha:
// * Um método concreto `emitirComprovante()`.
// * Um método abstrato `boolean validarPagamento()`.
// * Crie as subclasses concretas `CartaoCredito` e `BoletoBancario`.
// * `CartaoCredito` deve validar o pagamento se o limite for suficiente.
// * `BoletoBancario` deve validar o pagamento se a data de vencimento não estiver expirada (para simplificar, utilize um atributo `boolean pago`).

public class Exercicio02 {
    public static void main(String[] args) {
        CartaoCredito cartao = new CartaoCredito(5000);
        BoletoBancario boleto = new BoletoBancario(true);

        if (cartao.validarPagamento()) {
            cartao.emitirComprovante();
        } else {
            System.out.println("Pagamento com cartão de crédito não validado.");
        }

        if (boleto.validarPagamento()) {
            boleto.emitirComprovante();
        } else {
            System.out.println("Pagamento com boleto bancário não validado.");
        }
    }
}

class MetodoPagamento {
    public void emitirComprovante() {
        System.out.println("Comprovante emitido.");
    }

    public boolean validarPagamento() {
        return false;
    }
}

class CartaoCredito extends MetodoPagamento {
    private double limite;

    public CartaoCredito(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean validarPagamento() {
        return limite > 0;
    }
}

class BoletoBancario extends MetodoPagamento {
    private boolean pago;

    public BoletoBancario(boolean pago) {
        this.pago = pago;
    }

    @Override
    public boolean validarPagamento() {
        return pago;
    }
}
