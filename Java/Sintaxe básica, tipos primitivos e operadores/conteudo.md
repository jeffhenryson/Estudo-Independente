Em Python você simplesmente escreve código no arquivo e executa. Java exige uma estrutura:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

Pontos importantes:

- Todo código executável fica dentro de uma **classe**
- O ponto de entrada é sempre o método `main`
- O nome do arquivo **deve** ser igual ao nome da classe (`Main.java`)
- Toda instrução termina com `;`

Java é **fortemente e estaticamente tipado** — você declara o tipo da variável explicitamente. São 8 tipos primitivos:

| Tipo | Tamanho | Exemplo | Equivalente Python |
| --- | --- | --- | --- |
| `byte` | 8 bits | `-128` a `127` | `int` (limitado) |
| `short` | 16 bits | `-32768` a `32767` | `int` (limitado) |
| `int` | 32 bits | `-2³¹` a `2³¹-1` | `int` |
| `long` | 64 bits | `-2⁶³` a `2⁶³-1` | `int` (grande) |
| `float` | 32 bits | `3.14f` | `float` (menos preciso) |
| `double` | 64 bits | `3.14` | `float` |
| `char` | 16 bits | `'A'` | `str` de 1 caractere |
| `boolean` | 1 bit | `true` / `false` | `bool` |

```java
int idade = 28;
double salario = 4500.75;
float altura = 1.75f;   // note o 'f' no final
long populacao = 8000000000L;  // note o 'L' no final
char letra = 'J';
boolean ativo = true;
```

> **Atenção:** `float` precisa do sufixo `f`, `long` precisa do sufixo `L`. Sem eles, Java interpreta como `double` e `int` respectivamente, gerando erro de compilação.
> 

Além dos primitivos, tudo mais em Java é **objeto**:

```java
String nome = "Jeff";
String vazio = null;  // referência pode ser null, primitivo não pode
```

`String` é o mais comum. Diferente de Python, Strings em Java são **imutáveis** e usam **aspas duplas** obrigatoriamente (`char` usa aspas simples). No Java moderno permite omitir o tipo quando ele pode ser inferido:

```java
var nome = "Jeff";       // inferido como String
var idade = 28;          // inferido como int
var salario = 4500.75;   // inferido como double
```

Mas `var` só funciona em **variáveis locais** (dentro de métodos). Não substitui declarações em atributos de classe.

---

### Aritméticos

```java
int a = 10, b = 3;

System.out.println(a + b);   // 13
System.out.println(a - b);   // 7
System.out.println(a * b);   // 30
System.out.println(a / b);   // 3  ← divisão inteira!
System.out.println(a % b);   // 1  ← módulo/resto

double resultado = (double) a / b;  // 3.333... ← cast necessário
```

> Diferente de Python, `/` entre dois `int` em Java faz **divisão inteira**. Para obter decimal, pelo menos um dos operandos precisa ser `double`.
> 

### Relacionais

```java
a == b   // false
a != b   // true
a > b    // true
a < b    // false
a >= b   // true
a <= b   // false
```

### Lógicos

```java
true && false   // false  (AND)
true || false   // true   (OR)
!true           // false  (NOT)
```

### Atribuição composta

```java
int x = 10;
x += 5;   // x = 15
x -= 3;   // x = 12
x *= 2;   // x = 24
x /= 4;   // x = 6
x %= 4;   // x = 2
```

### Incremento e decremento

```java
int i = 5;
i++;   // pós-incremento: usa i (5), depois incrementa → i = 6
++i;   // pré-incremento: incrementa primeiro → i = 7
i--;   // pós-decremento
--i;   // pré-decremento
```

### Operador ternário

```java
int idade = 20;
String status = (idade >= 18) ? "maior" : "menor";
// equivale ao: "maior" if idade >= 18 else "menor" do Python
```

---

## Casting (conversão de tipos)

```java
// Widening (implícito — sem perda de dado)
int i = 42;
double d = i;   // int → double, automático

// Narrowing (explícito — pode perder dado)
double pi = 3.14159;
int truncado = (int) pi;   // 3 — a parte decimal é descartada

// String para número
int parsed = Integer.parseInt("42");
double parsedD = Double.parseDouble("3.14");

// Número para String
String s = String.valueOf(42);
String s2 = Integer.toString(42);
```

---

## Saída e entrada básica

```java
// Saída
System.out.println("com quebra de linha");
System.out.print("sem quebra de linha");
System.out.printf("Olá, %s! Você tem %d anos.%n", "Jeff", 28);

// Entrada (via Scanner)
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
System.out.print("Digite seu nome: ");
String nome = scanner.nextLine();
System.out.print("Digite sua idade: ");
int idade = scanner.nextInt();
```

---

## **Formatadores do printf mais comuns:**

| Formatador | Tipo |
| --- | --- |
| `%s` | String |
| `%d` | int, long |
| `%f` / `%.2f` | float, double |
| `%c` | char |
| `%b` | boolean |
| `%n` | quebra de linha |