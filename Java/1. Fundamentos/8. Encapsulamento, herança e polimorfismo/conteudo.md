## PARTE 1 — Encapsulamento

### 1. O problema sem encapsulamento

```java
public class ContaBancaria {
    double saldo;
}

ContaBancaria conta = new ContaBancaria();
conta.saldo = -5000; // ❌ ninguém deveria poder fazer isso diretamente
```

Encapsulamento protege os dados internos do objeto, controlando o acesso através de métodos.

---

### 2. Modificadores de acesso

| Modificador | Mesma classe | Mesmo pacote | Subclasse | Qualquer lugar |
|---|---|---|---|---|
| `private` | ✅ | ❌ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| *(sem modificador)* | ✅ | ✅ | ❌ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

---

### 3. Getters e Setters

A convenção é deixar atributos `private` e expor acesso via métodos:

```java
public class ContaBancaria {

    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // getter — só leitura
    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // setter com validação — controla a escrita
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito");
            return;
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            System.out.println("Saque inválido");
            return;
        }
        saldo -= valor;
    }
}
```

```java
ContaBancaria conta = new ContaBancaria("Jeff", 1000.0);
conta.saldo = -5000;          // ❌ erro de compilação — private
conta.depositar(500);         // ✅ passa pela validação
System.out.println(conta.getSaldo()); // 1500.0
```

---

## PARTE 2 — Herança

---

### 1. Conceito

Herança permite que uma classe **herde atributos e métodos** de outra, evitando repetição de código:

```java
// classe pai (superclasse)
public class Conta {
    protected String titular;
    protected double saldo;

    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) saldo += valor;
    }
    
    public void sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            System.out.println("Saque inválido");
            return;
        }
        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public String toString() {
        return String.format("Conta{titular=%s, saldo=%.2f}", titular, saldo);
    }
}
```

```java
// classe filha (subclasse)
public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String titular, double saldo, double limite) {
        super(titular, saldo); // ← chama o construtor do pai
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }
}
```

```java
// classe filha diferente
public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(String titular, double saldo, double taxaRendimento) {
        super(titular, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    public void renderJuros() {
        saldo += saldo * taxaRendimento;
    }
}
```

---

### 2. `super`

`super` acessa membros da classe pai:

```java
public class ContaCorrente extends Conta {

    public ContaCorrente(String titular, double saldo, double limite) {
        super(titular, saldo); // construtor do pai — deve ser primeira linha
        this.limite = limite;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", limite=%.2f", limite);
        //     ↑ chama o toString() do pai e adiciona mais info
    }
}
```

---

### 3. `@Override`

Indica que você está **sobrescrevendo** um método do pai:

```java
public class ContaCorrente extends Conta {

    private double limite;

    @Override
    public void sacar(double valor) {
        if (valor <= 0 || valor > saldo + limite) {
            System.out.println("Saque inválido");
            return;
        }
        saldo -= valor; // pode usar saldo negativamente até o limite
    }
}
```

> `@Override` não é obrigatório mas é **boa prática** — o compilador avisa se você errar o nome do método.

---

### 4. Herança e construtores

O construtor do pai **nunca é herdado automaticamente**. A subclasse deve chamar `super(...)` explicitamente:

```java
public class ContaPoupanca extends Conta {

    private double taxa;

    public ContaPoupanca(String titular, double saldo, double taxa) {
        super(titular, saldo); // obrigatório — e sempre primeira linha
        this.taxa = taxa;
    }
}
```

---

### 5. `final` em classes e métodos

```java
// classe final — não pode ser herdada
public final class Cpf { ... }

// método final — não pode ser sobrescrito
public final void validar() { ... }
```

---

## PARTE 3 — Polimorfismo

---

### 1. Conceito

Polimorfismo permite tratar objetos de tipos diferentes de forma uniforme através de uma referência comum:

```java
Conta c1 = new ContaCorrente("Jeff", 1000.0, 500.0);
Conta c2 = new ContaPoupanca("Ana", 2000.0, 0.05);

// mesma chamada, comportamentos diferentes
c1.toString(); // versão da ContaCorrente
c2.toString(); // versão da Conta (se não sobrescreveu)
```

---

### 2. Array polimórfico

```java
Conta[] contas = {
    new ContaCorrente("Jeff", 1000.0, 500.0),
    new ContaPoupanca("Ana", 2000.0, 0.05),
    new Conta("Carlos", 500.0)
};

for (Conta c : contas) {
    c.depositar(100); // chama o método correto de cada tipo
    System.out.println(c.getSaldo());
}
```

---

### 3. `instanceof` e cast

```java
for (Conta c : contas) {
    System.out.println(c.getTitular());

    if (c instanceof ContaPoupanca cp) { // Java 16+ pattern matching
        cp.renderJuros(); // método exclusivo de ContaPoupanca
    }

    if (c instanceof ContaCorrente cc) {
        System.out.println("Limite: " + cc.getLimite());
    }
}
```

---

### 4. Polimorfismo em métodos

```java
public static void exibirSaldo(Conta conta) {
    // aceita qualquer subtipo de Conta
    System.out.printf("%s: R$ %.2f%n", conta.getTitular(), conta.getSaldo());
}

exibirSaldo(new ContaCorrente("Jeff", 1000.0, 500.0));  // ✅
exibirSaldo(new ContaPoupanca("Ana", 2000.0, 0.05));    // ✅
exibirSaldo(new Conta("Carlos", 500.0));                // ✅
```

---

### 5. Os três pilares — resumo visual

```
Encapsulamento           Herança                  Polimorfismo
─────────────────        ─────────────────        ─────────────────
Protege os dados         Reutiliza código         Trata tipos diferentes
                                                  de forma uniforme
private saldo            Conta                    Conta c = new
getSaldo()              ├── ContaCorrente          ContaCorrente(...)
depositar()             └── ContaPoupanca         c.depositar(100)
                                                  → comportamento correto
```

---