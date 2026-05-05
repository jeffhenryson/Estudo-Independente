## 1. `while`

O loop `while` é utilizado para executar um bloco de código repetidamente enquanto uma determinada condição booleana for verdadeira. É particularmente útil quando você **não sabe de antemão** quantas vezes a repetição vai acontecer.

```java
int i = 0;

while (i < 5) {
    System.out.println(i);
    i++;
}
// Imprime: 0 1 2 3 4
```

<a href="https://ibb.co/TDsY5Stg"><img src="https://i.ibb.co/gbxmCpJR/while.jpg" alt="while" border="0"></a>

> **Atenção:** A condição é avaliada **antes** de o bloco ser executado. Se a condição já começar falsa, o bloco **nunca será executado**.

---

## 2. `do-while`

A principal diferença entre o `do-while` e o `while` tradicional é que, no `do-while`, o bloco de código é executado **pelo menos uma vez**, pois a condição é verificada apenas ao final do ciclo.

```java
int i = 0;

do {
    System.out.println(i);
    i++;
} while (i < 5);
// Imprime: 0 1 2 3 4
```

### Caso Clássico de Uso

O `do-while` é excelente para cenários onde uma ação deve ocorrer antes de se fazer a verificação, como em um menu de terminal:

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
int opcao;

do {
    System.out.println("1 - Ver relatório");
    System.out.println("2 - Exportar");
    System.out.println("0 - Sair");
    System.out.print("Escolha: ");
    opcao = scanner.nextInt();
} while (opcao != 0);

System.out.println("Encerrando...");
```

---

## 3. `for-each`

O `for-each` (também chamado de *enhanced for*) é usado para iterar sobre **arrays e coleções** de forma limpa, sem precisar gerenciar índices manualmente.

```java
String[] planos = {"starter", "pro", "enterprise"};

// Maneira tradicional (com índices)
for (int i = 0; i < planos.length; i++) {
    System.out.println(planos[i]);
}

// Maneira moderna (for-each)
for (String plano : planos) {
    System.out.println(plano);
}
```

> **Dica de Leitura:** Lê-se *"para cada `plano` dentro da coleção `planos`"*, sendo equivalente ao `for x in lista` do Python.

---

## 4. Controle de Fluxo: `break` e `continue`

Podemos alterar o fluxo de repetição dos loops utilizando estas duas instruções:

* **`break`:** Encerra o loop completamente, independentemente da condição.
* **`continue`:** Interrompe apenas a iteração atual e avança para a próxima repetição do ciclo.

```java
// Exemplo com break
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break; // Para o loop no 5
    }
    System.out.println(i); // Imprime: 0 1 2 3 4
}

// Exemplo com continue
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) {
        continue; // Pula os números pares
    }
    System.out.println(i); // Imprime: 1 3 5 7 9
}
```

---

## 5. Loops Aninhados e Labels

Você pode colocar um loop dentro de outro. Por padrão, o `break` ou `continue` dentro de um loop aninhado afeta apenas o loop mais interno. 

```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        System.out.printf("%d x %d = %d%n", i, j, i * j);
    }
}
```

Caso você precise parar o loop de fora a partir de dentro, utilizamos um **rótulo (label)**:

```java
externo:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (j == 1) {
            break externo; // Quebra o loop externo inteiro
        }
    }
}
```

---