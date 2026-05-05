
---

## 1. Estrutura `for` Tradicional

O loop `for` é utilizado quando você sabe **exatamente quantas vezes** deseja repetir um bloco de código, ou quando precisa percorrer um intervalo de valores. 

Sua estrutura básica é composta por três partes separadas por ponto e vírgula (`;`):

```java
// Sintaxe básica
for (inicialização ; condição ; incremento) {
    // bloco de código
}
```

### Exemplo Prático

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
// Imprime: 0 1 2 3 4
```



---

## 2. As Três Partes do `for`

Para entender o funcionamento, observe o que cada parte faz a cada ciclo:

1. **Inicialização (`int i = 0`):** Executado **apenas uma vez** no início do loop. É aqui que declaramos e/ou inicializamos a variável de controle.
2. **Condição (`i < 5`):** Avaliada antes de cada iteração. Se for verdadeira, o código dentro do bloco é executado. Se for falsa, o loop termina.
3. **Incremento (`i++`):** Executado ao final de cada iteração. Geralmente altera a variável de controle (neste caso, adiciona 1 a `i`).

---

## 3. Variações e Casos de Uso

A estrutura do `for` é flexível e pode ser adaptada para diferentes necessidades:

### Contagem Regressiva

Podemos inicializar a variável com um valor maior e decrementá-la a cada passo:

```java
for (int i = 5; i > 0; i--) {
    System.out.println(i); // Imprime: 5 4 3 2 1
}
```

### Incremento Diferente

Não estamos limitados a somar 1. Podemos pular valores utilizando o operador de atribuição composta (como `+=`):

```java
for (int i = 0; i <= 10; i += 2) {
    System.out.println(i); // Imprime: 0 2 4 6 8 10
}
```

### Múltiplas Variáveis

É possível inicializar e atualizar mais de uma variável dentro do `for`, separando-as por vírgulas:

```java
for (int i = 0, j = 10; i < j; i++, j--) {
    System.out.printf("i=%d j=%d%n", i, j);
}
```

---