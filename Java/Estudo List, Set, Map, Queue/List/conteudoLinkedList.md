# ☕ Java — Coleções: LinkedList

---

## 1. O que é e por que existe

`LinkedList` é uma lista **duplamente encadeada** — cada elemento guarda referência para o anterior e o próximo:

```
[anterior | "starter" | próximo] ↔ [anterior | "pro" | próximo] ↔ [anterior | "enterprise" | próximo]
```

Diferente do `ArrayList` que internamente é um array, `LinkedList` não tem índices físicos — para acessar o elemento do meio, precisa percorrer desde o início.

```java
import java.util.LinkedList;
import java.util.List;

List<String> lista = new LinkedList<>();
```

---

## 2. Quando usar LinkedList vs ArrayList

| Operação | ArrayList | LinkedList |
|---|---|---|
| `get(índice)` | ✅ rápido — acesso direto | ❌ lento — percorre do início |
| `add()` no final | ✅ rápido | ✅ rápido |
| `add()` no meio | ❌ lento — desloca elementos | ✅ rápido — só ajusta ponteiros |
| `remove()` no meio | ❌ lento — desloca elementos | ✅ rápido — só ajusta ponteiros |
| Uso de memória | menor | maior — guarda ponteiros extras |

> Na prática: use `ArrayList` por padrão. Mude para `LinkedList` quando tiver **muitas inserções e remoções no meio** da lista.

---

## 3. LinkedList como List

Tudo que funciona no `ArrayList` funciona no `LinkedList`:

```java
LinkedList<String> campanhas = new LinkedList<>();

campanhas.add("Campanha Black Friday");
campanhas.add("Campanha Verão");
campanhas.add("Campanha Remarketing");

System.out.println(campanhas.get(0));     // "Campanha Black Friday"
System.out.println(campanhas.size());     // 3
campanhas.remove(1);
campanhas.contains("Campanha Verão");
```

---

## 4. Métodos exclusivos — manipulação nas pontas

Aqui é onde `LinkedList` brilha. Ela implementa `Deque` (double-ended queue) — permite operações eficientes em **ambas as pontas**:

```java
LinkedList<String> lista = new LinkedList<>();
lista.add("meio");

// adicionando nas pontas
lista.addFirst("primeiro");   // insere no início
lista.addLast("último");      // insere no final (igual ao add())
// [primeiro, meio, último]

// acessando sem remover
System.out.println(lista.getFirst());  // "primeiro"
System.out.println(lista.getLast());   // "último"
System.out.println(lista.peekFirst()); // "primeiro" — retorna null se vazia
System.out.println(lista.peekLast());  // "último"   — retorna null se vazia

// removendo das pontas
lista.removeFirst();   // remove e retorna "primeiro" — lança exceção se vazia
lista.removeLast();    // remove e retorna "último"
lista.pollFirst();     // remove e retorna "primeiro" — retorna null se vazia
lista.pollLast();      // remove e retorna "último"
```

> Diferença entre `get/remove` e `peek/poll`: se a lista estiver vazia, `getFirst()` e `removeFirst()` lançam exceção. `peekFirst()` e `pollFirst()` retornam `null`. Prefira `peek/poll` quando a lista pode estar vazia.

---

## 5. LinkedList como Fila (Queue — FIFO)

FIFO = First In, First Out — o primeiro que entra é o primeiro que sai. Igual uma fila de banco:

```java
Queue<String> filaTickets = new LinkedList<>();

// offer — adiciona no final da fila
filaTickets.offer("ticket-001");
filaTickets.offer("ticket-002");
filaTickets.offer("ticket-003");

// peek — olha o próximo sem remover
System.out.println(filaTickets.peek()); // "ticket-001"

// poll — remove e retorna o primeiro
System.out.println(filaTickets.poll()); // "ticket-001"
System.out.println(filaTickets.poll()); // "ticket-002"

System.out.println(filaTickets.size()); // 1

// processando toda a fila
while (!filaTickets.isEmpty()) {
    String ticket = filaTickets.poll();
    System.out.println("Processando: " + ticket);
}
```

---

## 6. LinkedList como Pilha (Stack — LIFO)

LIFO = Last In, First Out — o último que entra é o primeiro que sai. Igual uma pilha de pratos:

```java
LinkedList<String> pilha = new LinkedList<>();

// push — empilha no topo (início)
pilha.push("ação 1");
pilha.push("ação 2");
pilha.push("ação 3");
// topo → [ação 3, ação 2, ação 1]

// pop — desempilha do topo
System.out.println(pilha.pop()); // "ação 3"
System.out.println(pilha.pop()); // "ação 2"

// peek — olha o topo sem remover
System.out.println(pilha.peek()); // "ação 1"
```

Caso de uso real — histórico de ações (Ctrl+Z):

```java
LinkedList<String> historico = new LinkedList<>();

historico.push("criar campanha");
historico.push("editar orçamento");
historico.push("alterar público");

// desfazer última ação
System.out.println("Desfazendo: " + historico.pop()); // "alterar público"
System.out.println("Desfazendo: " + historico.pop()); // "editar orçamento"
```

---

## 7. Iterando

```java
LinkedList<String> lista = new LinkedList<>();
lista.add("starter");
lista.add("pro");
lista.add("enterprise");

// for-each — mais comum
for (String item : lista) {
    System.out.println(item);
}

// Iterator — útil para remover durante iteração sem erro
import java.util.Iterator;

Iterator<String> it = lista.iterator();
while (it.hasNext()) {
    String item = it.next();
    if (item.equals("pro")) {
        it.remove(); // ✅ seguro — não lança ConcurrentModificationException
    }
}

// descendingIterator — itera de trás para frente
Iterator<String> reverso = lista.descendingIterator();
while (reverso.hasNext()) {
    System.out.println(reverso.next());
}
```

---

## 8. Resumo dos métodos exclusivos

| Método | O que faz | Se vazia |
|---|---|---|
| `addFirst(e)` | Insere no início | — |
| `addLast(e)` | Insere no final | — |
| `getFirst()` | Retorna o primeiro | ❌ exceção |
| `getLast()` | Retorna o último | ❌ exceção |
| `peekFirst()` | Retorna o primeiro | ✅ null |
| `peekLast()` | Retorna o último | ✅ null |
| `removeFirst()` | Remove e retorna o primeiro | ❌ exceção |
| `removeLast()` | Remove e retorna o último | ❌ exceção |
| `pollFirst()` | Remove e retorna o primeiro | ✅ null |
| `pollLast()` | Remove e retorna o último | ✅ null |
| `push(e)` | Empilha no topo (início) | — |
| `pop()` | Desempilha do topo | ❌ exceção |
| `offer(e)` | Enfileira no final | — |
| `poll()` | Desenfileira do início | ✅ null |
| `peek()` | Olha o primeiro | ✅ null |

---

## 9. Comparativo com Python

| Python | Java |
|---|---|
| `collections.deque` | `LinkedList` |
| `deque.appendleft(x)` | `addFirst(x)` |
| `deque.append(x)` | `addLast(x)` |
| `deque.popleft()` | `pollFirst()` |
| `deque.pop()` | `pollLast()` |
| `queue.Queue` | `LinkedList` como `Queue` |

---