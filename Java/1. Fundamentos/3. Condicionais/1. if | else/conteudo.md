## 1. Estruturas Condicionais (`if`, `else if`, `else`)

Em Java, as estruturas condicionais permitem que o fluxo de execução do programa seja desviado com base em valores ou resultados de expressões lógicas. Diferente de linguagens como o Python, o Java utiliza chaves `{}` para delimitar blocos de código e exige parênteses `()` ao redor da condição.

```java
int idade = 18;

if (idade >= 18) {
    System.out.println("Maior de idade");
} else if (idade >= 16) {
    System.out.println("Menor, mas pode votar");
} else {
    System.out.println("Menor de idade");
}
```

> **Boas Práticas:** Mesmo que as chaves `{}` sejam opcionais quando o bloco possui apenas uma linha de instrução, adote a prática de **sempre** utilizá-las. Isso previne erros lógicos difíceis de rastrear no futuro.

---

## 2. Comparação de Valores e Strings

A comparação de dados em Java varia de acordo com o tipo de dado utilizado:

* **Tipos Primitivos (como `int`, `double`, `boolean`, `char`):** Utilize o operador `==`.
* **Objetos (como a classe `String`):** **Nunca** utilize `==` para comparar o conteúdo de dois textos. Em Java, o operador `==` compara o *endereço de memória* (referência), e não o texto em si.

Para comparar strings, utilize sempre o método `.equals()` ou `.equalsIgnoreCase()` para ignorar letras maiúsculas e minúsculas:

```java
// Comparação de primitivos — use ==
int idade = 5;
if (idade == 5) { 
    System.out.println("Igual a 5"); 
}

// Comparação de Strings — use .equals()
String status = "ativo";
if (status.equals("ativo")) { 
    System.out.println("O status é ativo"); 
}

// Ignorando maiúsculas e minúsculas
if (status.equalsIgnoreCase("ATIVO")) { 
    System.out.println("O status é ativo (ignora maiúsculas)"); 
}
```

### O Perigo do `==` com Strings

O exemplo a seguir ilustra a diferença entre comparar a referência e o conteúdo de dois objetos `String` criados na memória:

```java
String a = new String("ativo");
String b = new String("ativo");

System.out.println(a == b);       // false (apontam para locais diferentes na memória)
System.out.println(a.equals(b));  // true  (os textos são idênticos)
```

---

## 3. Operador Ternário

O operador ternário (`? :`) é uma forma concisa de escrever uma condicional simples que retorna um valor. Ele é composto por três partes: a condição, o resultado se verdadeiro, e o resultado se falso.

```java
// Sintaxe básica: (condição) ? valor_se_verdadeiro : valor_se_falso
String resultado = (nota >= 7) ? "Aprovado" : "Reprovado";
```

> **Atenção:** O uso de ternários aninhados (um dentro do outro) prejudica a legibilidade do código. Utilize-os com moderação e apenas para casos muito simples.

```java
// Ternário aninhado — pode ser difícil de ler
String faixa = (nota >= 9) ? "Ótimo" : (nota >= 7) ? "Bom" : "Ruim";
```

---

## 4. Pattern Matching no `if` (Java 16+)

A partir do Java 16, a linguagem introduziu o *Pattern Matching* (casamento de padrões) para o operador `instanceof`. Essa melhoria elimina a necessidade de fazer a conversão explícita de tipos (*cast*).

```java
Object valor = "Cerne";

// Código antigo (antes do Java 16)
if (valor instanceof String) {
    String s = (String) valor;
    System.out.println(s.toUpperCase());
}

// Código moderno com Pattern Matching
if (valor instanceof String s) {
    System.out.println(s.toUpperCase()); // A variável 's' já está pronta e tipada
}
```

---