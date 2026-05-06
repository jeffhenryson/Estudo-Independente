// ## 2. Conta Bancária com Limite de Saque

// **Enunciado:** Crie uma classe chamada `ContaBancaria` com os atributos privados: `String numeroConta`, `double saldo` e `double limiteSaque`.
// * O `saldo` só pode ser alterado através dos métodos `depositar` e `sacar`.
// * O `limiteSaque` deve poder ser alterado através de um `setter`, mas deve ser sempre um valor positivo maior que zero.
// * No método `sacar(double valor)`, valide se o valor solicitado é menor ou igual ao saldo somado ao limite.

public class Exercicio02 {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("12345-6", 1000.00, 500.00);
        System.out.println("Número da Conta: " + conta.getNumeroConta() + ", Saldo: " + conta.getSaldo() + ", Limite de Saque: " + conta.getLimiteSaque());

        // Testando o saque dentro do limite
        conta.sacar(1200.00); // Deve ser permitido

        // Testando o saque que excede o limite
        conta.sacar(400.00); // Deve exibir uma mensagem de erro

        // Testando a alteração do limite de saque
        conta.setLimiteSaque(300.00); // Deve ser permitido
        System.out.println("Novo Limite de Saque: " + conta.getLimiteSaque());

        // Testando o saque com o novo limite
        conta.sacar(400.00); // Deve exibir uma mensagem de erro
    }
}

class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private double limiteSaque;

    public ContaBancaria(String numeroConta, double saldo, double limiteSaque) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        setLimiteSaque(limiteSaque); // Usando o setter para aplicar a validação
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(double limiteSaque) {
        if (limiteSaque > 0) {
            this.limiteSaque = limiteSaque;
        } else {
            System.out.println("Erro: O limite de saque deve ser maior que zero. Limite não alterado.");
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de " + valor + " realizado. Novo saldo: " + this.saldo);
        } else {
            System.out.println("Erro: O valor do depósito deve ser maior que zero.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= (saldo + limiteSaque)) {
            this.saldo -= valor;
            System.out.println("Saque de " + valor + " realizado. Novo saldo: " + this.saldo);
        } else {
            System.out.println("Erro: Saldo insuficiente ou valor de saque excede o limite.");
        }
    }
}