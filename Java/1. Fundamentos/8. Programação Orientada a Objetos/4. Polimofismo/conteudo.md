
---

## 1. O que é Polimorfismo

O termo polimorfismo vem do grego e significa "muitas formas". Na programação orientada a objetos, ele permite que diferentes classes respondam à mesma chamada de método de maneiras diferentes.

Isso significa que você pode tratar objetos de diferentes subclasses usando uma referência da superclasse, mas cada um executará o seu próprio comportamento.

### Exemplo Prático de Polimorfismo

Imagine que temos uma classe base `Animal` e queremos que cada animal emita seu som:

```java
public class Animal {
    public void emitirSom() {
        System.out.println("O animal emite um som genérico.");
    }
}

public class Cachorro extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Au Au!");
    }
}

public class Gato extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Miau!");
    }
}
```

---

## 2. Como o Polimorfismo Funciona

O polimorfismo ocorre quando usamos uma variável do tipo da **superclasse** para armazenar uma instância da **subclasse**. 

```java
public class Main {
    public static void main(String[] args) {
        // O tipo da variável é Animal, mas a instância é Cachorro ou Gato
        Animal meuAnimal1 = new Cachorro();
        Animal meuAnimal2 = new Gato();

        meuAnimal1.emitirSom(); // Imprime: Au Au!
        meuAnimal2.emitirSom(); // Imprime: Miau!
    }
}
```

Neste exemplo:
* O compilador não sabe exatamente qual método será executado até o tempo de execução (*runtime*).
* Esse comportamento é chamado de **ligação tardia** (*late binding* ou *polimorfismo em tempo de execução*).

---

## 3. Vantagens do Polimorfismo

* **Extensibilidade:** Você pode adicionar novos tipos (como um `Passaro` que também herda de `Animal`) sem alterar o código que já usa a classe `Animal`.
* **Desacoplamento:** O código principal não precisa saber qual é a classe específica, apenas que ela é um `Animal` e sabe `emitirSom()`.

---

## Exercícios de Fixação

**Enunciado:** Vamos praticar Polimorfismo. Crie uma classe base chamada `Forma` com um método `calcularArea()`. Depois, crie duas subclasses:
* `Retangulo` (com atributos `base` e `altura`) que sobrescreve `calcularArea()`.
* `Circulo` (com atributo `raio`) que sobrescreve `calcularArea()`. 
* No método `main`, crie um array de `Forma` contendo os dois objetos e percorra-os imprimindo suas respectivas áreas.

---
