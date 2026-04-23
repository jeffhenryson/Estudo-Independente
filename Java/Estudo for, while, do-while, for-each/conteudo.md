## 1. while

```java
int i = 0;

while (i < 5) {
    System.out.println(i);
    i++;
}
// imprime: 0 1 2 3 4
```

> Execute **enquanto** a condição for verdadeira. Se a condição já começar falsa, o bloco **nunca executa**.
> 

---

## 2. do-while

A diferença: o bloco executa **pelo menos uma vez**, a condição é verificada depois:

```java
int i = 0;

do {
    System.out.println(i);
    i++;
} while (i < 5);
// imprime: 0 1 2 3 4
```

Caso clássico de uso — menu que deve aparecer pelo menos uma vez:

```java
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

## 3. for

Usado quando você sabe **quantas vezes** vai iterar:

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
// imprime: 0 1 2 3 4
```

As três partes do `for`:

```java
for (inicialização ; condição ; incremento) { }
//   int i = 0      i < 5      i++
```

Variações:

```java
// de trás para frente
for (int i = 5; i > 0; i--) {
    System.out.println(i); // 5 4 3 2 1
}

// incremento diferente
for (int i = 0; i <= 10; i += 2) {
    System.out.println(i); // 0 2 4 6 8 10
}

// múltiplas variáveis
for (int i = 0, j = 10; i < j; i++, j--) {
    System.out.printf("i=%d j=%d%n", i, j);
}
```

---

## 4. for-each

Usado para iterar sobre **arrays e coleções** sem se preocupar com índice:

```java
String[] planos = {"starter", "pro", "enterprise"};

// for tradicional
for (int i = 0; i < planos.length; i++) {
    System.out.println(planos[i]);
}

// for-each — mais limpo
for (String plano : planos) {
    System.out.println(plano);
}
```

> Lê-se: *"para cada `plano` em `planos`"* — igual ao `for x in lista` do Python.
> 

---

## 5. break e continue

```java
// break — encerra o loop imediatamente
for (int i = 0; i < 10; i++) {
    if (i == 5) break;
    System.out.println(i); // 0 1 2 3 4
}

// continue — pula para a próxima iteração
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) continue;
    System.out.println(i); // 1 3 5 7 9 (só ímpares)
}
```

---

## 6. Loop infinito intencional

```java
while (true) {
    // executa para sempre até um break
    System.out.print("Comando: ");
    String cmd = scanner.nextLine();

    if (cmd.equals("sair")) break;

    System.out.println("Executando: " + cmd);
}
```

---

## 7. Loops aninhados

```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        System.out.printf("%d x %d = %d%n", i, j, i * j);
    }
}
```

`break` e `continue` em loops aninhados afetam apenas o **loop mais interno**. Para controlar o externo use **labels** (raro, mas existe):

```java
externo:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (j == 1) break externo; // quebra o loop de fora
    }
}
```

---

## 8. Comparativo com Python

| Python | Java |
| --- | --- |
| `while cond:` | `while (cond) {}` |
| `for i in range(5):` | `for (int i = 0; i < 5; i++) {}` |
| `for x in lista:` | `for (Tipo x : lista) {}` |
| `break` | `break` |
| `continue` | `continue` |
| Não tem do-while | `do {} while (cond);` |