
---

## 1. O que é Herança

A herança é um mecanismo que permite que uma classe (chamada de **classe filha** ou subclasse) herde atributos e métodos de outra classe (chamada de **classe mãe** ou superclasse). 

Isso promove o **reaproveitamento de código** e estabelece um relacionamento do tipo *"é um"* (ex: um *Gerente* **é um** *Funcionário*).

### O Problema da Duplicação

Imagine que você tem duas classes, `Funcionario` e `Gerente`. Ambas possuem o nome e o salário:

```java
// Sem herança - código duplicado
public class Funcionario {
    private String nome;
    private double salario;
    // Construtores, getters e setters...
}

public class Gerente {
    private String nome;
    private double salario;
    private String senha; // Atributo extra
    // Construtores, getters e setters...
}
```

---

## 2. Implementação de Herança em Java

Para aplicar a herança em Java, utilizamos a palavra-chave `extends`. A classe filha herda todas as características da classe mãe, podendo adicionar novas funcionalidades ou modificar as existentes.

### Superclasse (Classe Mãe)

```java
public class Funcionario {
    // Usamos 'protected' para que as classes filhas tenham acesso direto
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public void trabalhar() {
        System.out.println(nome + " está trabalhando.");
    }

    public double getSalario() {
        return salario;
    }
}
```

### Subclasse (Classe Filha)

```java
// A palavra-chave 'extends' estabelece a herança
public class Gerente extends Funcionario {
    private String senha;

    public Gerente(String nome, double salario, String senha) {
        // super() chama o construtor da classe mãe (Funcionario)
        super(nome, salario);
        this.senha = senha;
    }

    public void gerenciarEquipe() {
        System.out.println(nome + " está gerenciando a equipe.");
    }
}
```

### Utilizando os Objetos

```java
public class Main {
    public static void main(String[] args) {
        Gerente g = new Gerente("Ana", 8000.0, "senha123");

        // O gerente herda o método 'trabalhar' da classe Funcionario
        g.trabalhar(); // Imprime: Ana está trabalhando.

        // E possui seu próprio comportamento
        g.gerenciarEquipe(); // Imprime: Ana está gerenciando a equipe.
    }
}
```



> **Atenção:** Em Java, uma classe filha pode herdar de **apenas uma** classe mãe (herança simples), mas pode implementar várias interfaces.

---

## 3. A Palavra-Chave `super`

O `super` é utilizado na classe filha para referenciar a classe mãe. Ele possui duas utilizações principais:

1. **Chamar o construtor da superclasse:** Utilizado no início do construtor da classe filha para garantir a correta inicialização dos atributos herdados.
2. **Acessar métodos da superclasse:** Útil quando um método da classe filha sobrescreve um método da classe mãe, mas você ainda quer executar o comportamento original.

---
