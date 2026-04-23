## Introdução

Array em Java é uma estrutura de **tamanho fixo** que armazena elementos do **mesmo tipo**.

```java
// declaração e inicialização
int[] numeros = new int[5];       // array de 5 inteiros, todos zerados
String[] nomes = new String[3];   // array de 3 Strings, todas null

// declaração com valores
int[] notas = {7, 8, 9, 10, 6};
String[] planos = {"starter", "pro", "enterprise"};
```

> Diferente de Python, arrays em Java têm **tamanho fixo** — não dá para adicionar ou remover elementos depois de criado. Para isso existem as **Collections** (veremos mais à frente).
> 

---

## Acessando e modificando elementos

```java
int[] notas = {7, 8, 9, 10, 6};

System.out.println(notas[0]);  // 7 — índice começa em 0
System.out.println(notas[4]);  // 6 — último elemento

notas[0] = 10;                 // modifica o primeiro elemento
System.out.println(notas[0]);  // 10

// tamanho do array
System.out.println(notas.length); // 5 ← propriedade, não método (sem parênteses)
```

> ⚠️ Acessar um índice fora do range lança `ArrayIndexOutOfBoundsException`.
> 

---

## Percorrendo arrays

```java
int[] notas = {7, 8, 9, 10, 6};

// for tradicional — útil quando precisa do índice
for (int i = 0; i < notas.length; i++) {
    System.out.println("nota[" + i + "] = " + notas[i]);
}

// for-each — mais limpo quando não precisa do índice
for (int nota : notas) {
    System.out.println(nota);
}
```

---

## Arrays multidimensionais

```java
// matriz 3x3
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

System.out.println(matriz[1][2]); // 6 — linha 1, coluna 2

// percorrendo
for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        System.out.printf("%d ", matriz[i][j]);
    }
    System.out.println();
}
```

---

## Classe Arrays (utilitários)

```java
import java.util.Arrays;

int[] nums = {5, 2, 8, 1, 9};

Arrays.sort(nums);                        // ordena in-place
System.out.println(Arrays.toString(nums)); // [1, 2, 5, 8, 9]

int[] copia = Arrays.copyOf(nums, nums.length);    // cópia total
int[] parte = Arrays.copyOfRange(nums, 1, 4);      // cópia parcial [2, 5, 8]

Arrays.fill(nums, 0);                     // preenche tudo com 0
System.out.println(Arrays.toString(nums)); // [0, 0, 0, 0, 0]
```

---

## Strings

String em Java é um **objeto imutável** — qualquer operação gera uma nova String.

```java
String nome = "Jeff";
String sobrenome = "Costa";

// concatenação
String completo = nome + " " + sobrenome;      // "Jeff Costa"
String completo2 = nome.concat(" ").concat(sobrenome); // mesmo resultado

// tamanho
System.out.println(nome.length()); // 4 ← método (com parênteses, diferente de array)

// acesso a caractere
System.out.println(nome.charAt(0)); // 'J'

// substring
String texto = "Cerne Analytics";
System.out.println(texto.substring(6));     // "Analytics"
System.out.println(texto.substring(0, 5));  // "Cerne"
```

---

## Métodos úteis de String

```java
String s = "  Cerne Analytics  ";

s.toUpperCase()           // "  CERNE ANALYTICS  "
s.toLowerCase()           // "  cerne analytics  "
s.trim()                  // "Cerne Analytics" — remove espaços das pontas
s.strip()                 // igual trim(), mas suporta unicode (Java 11+)
s.replace("Cerne", "Nova")// "  Nova Analytics  "
s.contains("Analytics")   // true
s.startsWith("  Cerne")   // true
s.endsWith("tics  ")      // true
s.isEmpty()               // false
s.isBlank()               // false (Java 11+) — verifica espaços também
s.indexOf("Ana")          // índice da primeira ocorrência, -1 se não achar

// split — divide em array
String csv = "nome,email,plano";
String[] partes = csv.split(",");
// partes = ["nome", "email", "plano"]

// verificar igualdade
s.equals("outro")         // false
s.equalsIgnoreCase("CERNE ANALYTICS") // true após trim
```

---

## String.format e formatted (Java 15+)

Alternativa ao `printf` para quando você quer a String formatada em uma variável:

```java
String nome = "Jeff";
int idade = 28;

// String.format
String msg = String.format("Olá, %s! Você tem %d anos.", nome, idade);

// .formatted() — Java 15+
String msg2 = "Olá, %s! Você tem %d anos.".formatted(nome, idade);

System.out.println(msg);  // Olá, Jeff! Você tem 28 anos.
```

---

## StringBuilder — quando performance importa

Como String é imutável, concatenar em loop é custoso:

```java
// ❌ ruim em loop — cria novo objeto a cada iteração
String resultado = "";
for (int i = 0; i < 1000; i++) {
    resultado += i; // gera 1000 objetos String na memória
}

// ✅ StringBuilder — mutável, eficiente
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);
}
String resultado = sb.toString();
```

Métodos do StringBuilder:

```java
StringBuilder sb = new StringBuilder("Cerne");

sb.append(" Analytics");     // "Cerne Analytics"
sb.insert(5, " Tech");       // "Cerne Tech Analytics"
sb.delete(5, 10);            // remove " Tech"
sb.reverse();                // "scylanA enreC"
sb.toString();               // converte para String
```