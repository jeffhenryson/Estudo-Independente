// ## Exercício 2 — Diferença entre add/remove e offer/poll

// Dado o código abaixo, responda sem rodar o que acontece em cada linha e por quê:

// ```java
// Queue<String> fila = new ArrayDeque<>();
// fila.offer("a");
// fila.offer("b");

// System.out.println(fila.poll());     // ?
// System.out.println(fila.poll());     // ?
// System.out.println(fila.poll());     // ?
// System.out.println(fila.peek());     // ?

// Queue<String> fila2 = new ArrayDeque<>();
// fila2.add("x");
// System.out.println(fila2.remove());  // ?
// System.out.println(fila2.remove());  // ? — o que acontece aqui?
// ```

// **Resposta:**
// No código acima, temos duas filas (`fila` e `fila2`) utilizando a implementação `ArrayDeque`.
// Vamos analisar o que acontece em cada linha:

// 1. `fila.offer("a");` - Adiciona o elemento "a" à fila. Retorna `true`.
// 2. `fila.offer("b");` - Adiciona o elemento "b" à fila. Retorna `true`.
// 3. `System.out.println(fila.poll());` - Remove e retorna o primeiro elemento da fila,
//  que é "a". Imprime "a".
// 4. `System.out.println(fila.poll());` - Remove e retorna o próximo elemento da fila,
//  que é "b". Imprime "b".
// 5. `System.out.println(fila.poll());` - Tenta remover um elemento da fila, mas a fila
//  está vazia. Retorna `null`. Imprime "null".
// 6. `System.out.println(fila.peek());` - Tenta acessar o primeiro elemento da fila sem
//  removê-lo, mas a fila está vazia. Retorna `null`. Imprime "null".
// 7. `fila2.add("x");` - Adiciona o elemento "x" à fila2. Retorna `true`.
// 8. `System.out.println(fila2.remove());` - Remove e retorna o primeiro elemento da fila2,
//  que é "x". Imprime "x".
// 9. `System.out.println(fila2.remove());` - Tenta remover um elemento da fila2, mas a fila
// está vazia. Lança uma `NoSuchElementException` porque o método `remove()` não permite
// remover de uma fila vazia, ao contrário do método `poll()`, que retorna `null` em vez
// de lançar uma exceção. Portanto, o programa irá lançar uma exceção e não imprimirá nada
// para esta linha.
