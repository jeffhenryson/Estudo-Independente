
---

## 1. O que é Encapsulamento

O encapsulamento consiste em **esconder os detalhes de implementação** de uma classe e expor apenas uma interface pública e segura para acessar e modificar esses dados. Em Java, isso é feito através de dois conceitos principais:

1. Modificadores de acesso (como `private`).
2. Métodos assessores (`getters` e `setters`).

### O Problema do Acesso Direto

Quando deixamos os atributos públicos, qualquer parte do código pode alterar os dados sem controle, o que pode gerar inconsistências:

```java
public class ContaBancaria {
    // Acesso público - qualquer um pode alterar o saldo diretamente
    public double saldo;
}

// Uso direto (Inseguro)
ContaBancaria conta = new ContaBancaria();
conta.saldo = -500.00; // Saldo negativo inválido!
```

---

## 2. Implementação Correta com Encapsulamento

Para proteger o estado do objeto, definimos os atributos como `private` e criamos métodos públicos para leitura (`get`) e alteração (`set`).

```java
public class ContaBancaria {
    // Atributo privado - não pode ser acessado de fora da classe
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        // Usa validação interna pelo construtor
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0.0;
        }
    }

    // Getter - permite apenas ler o valor
    public double getSaldo() {
        return saldo;
    }

    // Setter - permite alterar o valor com validações
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
        } else {
            System.out.println("Saque inválido ou saldo insuficiente.");
        }
    }
}
```



### Vantagens do Encapsulamento

* **Proteção dos dados:** Impede que atributos recebam valores inválidos ou fora de escopo.
* **Flexibilidade:** Permite mudar a lógica interna da classe (ex: alterar a forma como o dado é armazenado) sem quebrar outras partes do sistema que utilizam a classe.
* **Manutenção:** Facilita a localização de erros, pois os dados só podem ser modificados através dos métodos definidos.

---