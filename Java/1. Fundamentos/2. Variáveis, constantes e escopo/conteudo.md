Em Java, uma variável tem três momentos:

```java
int idade;          // 1. declaração
idade = 28;         // 2. atribuição
System.out.println(idade); // 3. uso
```

Ou tudo junto:

```java
int idade = 28;     // declaração + atribuição (inicialização)
```

> **Importante:** Java **não permite usar** uma variável local não inicializada. O compilador acusa erro.
> 

```java
int x;
System.out.println(x); // ❌ erro de compilação: variable x might not have been initialized
```

---

Em Python você não tem constante real, só convenção (`NOME_MAIUSCULO`). Em Java existe a palavra-chave `final`:

```java
final double PI = 3.14159;
final int MAX_TENTATIVAS = 3;

PI = 3.0; // ❌ erro de compilação — não pode reatribuir
```

Convenção de nomenclatura para constantes em Java: **SNAKE_CASE maiúsculo**.

```java
final String BASE_URL = "https://api.cerne.com";
final int TIMEOUT_SEGUNDOS = 30;
```

---

Escopo define **onde** uma variável existe e pode ser acessada. Em Java o escopo é delimitado por **chaves `{}`**.

### Escopo de bloco

```java
public static void main(String[] args) {

    int x = 10; // existe aqui dentro

    if (x > 5) {
        int y = 20; // existe só dentro do if
        System.out.println(x); // ✅ x ainda existe aqui
        System.out.println(y); // ✅ y existe aqui
    }

    System.out.println(x); // ✅ x ainda existe
    System.out.println(y); // ❌ erro — y não existe fora do if
}
```

### Escopo de método

```java
public static void metodoA() {
    int valor = 42;
}

public static void metodoB() {
    System.out.println(valor); // ❌ erro — valor não existe aqui
}
```

### Escopo de classe (atributos)

Quando a variável é declarada **dentro da classe mas fora dos métodos**, ela pertence ao objeto inteiro:

```java
public class Pessoa {
    String nome = "Jeff";  // atributo — escopo de classe
    int idade = 28;        // atributo — escopo de classe

    public void apresentar() {
        System.out.println(nome);  // ✅ acessível em qualquer método da classe
    }

    public void aniversario() {
        idade++;           // ✅ acessível aqui também
    }
}
```

---

## Variáveis locais vs atributos de classe

| Característica | Variável local | Atributo de classe |
| --- | --- | --- |
| Onde é declarada | Dentro de um método | Dentro da classe, fora dos métodos |
| Escopo | Só dentro do método/bloco | Toda a classe |
| Valor padrão | ❌ nenhum (precisa inicializar) | ✅ Java inicializa automaticamente |
| `final` | Pode usar | Pode usar |

Valores padrão dos atributos de classe:

| Tipo | Valor padrão |
| --- | --- |
| `int`, `long`, `short`, `byte` | `0` |
| `double`, `float` | `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` |
| Objetos (`String`, etc.) | `null` |

```java
public class Exemplo {
    int numero;       // automaticamente 0
    boolean ativo;    // automaticamente false
    String texto;     // automaticamente null

    public void mostrar() {
        System.out.println(numero); // 0
        System.out.println(ativo);  // false
        System.out.println(texto);  // null
    }
}
```

---

## Shadowing (sombreamento)

Quando uma variável local tem o **mesmo nome** que um atributo de classe:

```java
public class Pessoa {
    String nome = "Jeff"; // atributo

    public void teste() {
        String nome = "Carlos"; // variável local — shadowing!
        System.out.println(nome);      // "Carlos" — local tem prioridade
        System.out.println(this.nome); // "Jeff" — this acessa o atributo
    }
}
```

`this` referencia o objeto atual — é como o `self` do Python.

---

## `var` e escopo

`var` segue as mesmas regras de escopo — e só funciona em variáveis **locais**:

```java
public class Exemplo {
    var nome = "Jeff"; // ❌ erro — var não pode ser atributo de classe

    public void metodo() {
        var nome = "Jeff"; // ✅ funciona como variável local
    }
}
```

---

## Boas práticas de nomenclatura

| O que é | Convenção | Exemplo |
| --- | --- | --- |
| Variável | camelCase | `nomeUsuario`, `idadePessoa` |
| Constante | UPPER_SNAKE_CASE | `MAX_TENTATIVAS`, `BASE_URL` |
| Método | camelCase | `calcularSalario()` |
| Classe | PascalCase | `PessoaFisica`, `ContaBancaria` |
| Pacote | lowercase | `com.cerne.analytics` |

---