// ## 1. Sistema de Pagamentos

// **Enunciado:** Crie uma classe base chamada `MetodoPagamento` com um método público chamado `processarPagamento()`.
// * Crie duas subclasses: 
//   * `CartaoCredito`
//   * `Pix`
// * Sobrescreva o método `processarPagamento()` em ambas as classes para exibir mensagens diferentes (ex: "Processando pagamento no cartão..." e "Processando pagamento via Pix...").
// * No método `main`, crie um array do tipo `MetodoPagamento` contendo instâncias das duas classes e utilize um loop para processar o pagamento de ambos.

public class Exercicio01 {
    public static void main(String[] args) {
        MetodoPagamento[] metodos = { new CartaoCredito(), new Pix() };

        for (MetodoPagamento metodo : metodos) {
            metodo.processarPagamento();
        }
    }
}

class MetodoPagamento {
    public void processarPagamento() {
        System.out.println("Processando pagamento...");
    }
}

class CartaoCredito extends MetodoPagamento {
    @Override
    public void processarPagamento() {
        System.out.println("Processando pagamento no cartão...");
    }
}

class Pix extends MetodoPagamento {
    @Override
    public void processarPagamento() {
        System.out.println("Processando pagamento via Pix...");
    }
}