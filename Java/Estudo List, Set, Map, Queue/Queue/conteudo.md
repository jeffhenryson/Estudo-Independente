# ☕ Java — Coleções: Queue

---

## 1. O que é e por que existe

`Queue` é uma fila — segue o princípio **FIFO** (First In, First Out): o primeiro que entra é o primeiro que sai. Igual uma fila de banco, fila de impressão, fila de emails para envio:

```java
// sem Queue — gerenciando fila na mão com List
List<String> fila = new ArrayList<>();
fila.add("ticket-001");
fila.add("ticket-002");
String proximo = fila.get(0); // pega o primeiro
fila.remove(0);               // remove manualmente — verboso e frágil

// com Queue — semântica clara e correta
Queue<String> fila = new LinkedList<>();
fila.offer("ticket-001");
fila.offer("ticket-002");
String proximo = fila.poll(); // pega e remove o primeiro — direto
```

---

## 2. Hierarquia de Queue em Java

```
Queue
├── LinkedList        — fila simples, propósito geral
├── PriorityQueue     — fila com prioridade (menor elemento primeiro)
├── ArrayDeque        — fila dupla, mais eficiente que LinkedList
└── Deque (interface)
    ├── ArrayDeque    — implementação preferida de Deque
    └── LinkedList    — também implementa Deque
```

---

## 3. Métodos da interface Queue

Cada operação tem duas versões — uma que lança exceção e uma que retorna valor especial:

| Operação | Lança exceção | Retorna null/false |
|---|---|---|
| Inserir | `add(e)` | `offer(e)` |
| Remover | `remove()` | `poll()` |
| Examinar | `element()` | `peek()` |

> Prefira sempre `offer`, `poll` e `peek` — mais seguro quando a fila pode estar vazia.

```java
Queue<String> fila = new LinkedList<>();

// inserir
fila.offer("ticket-001");
fila.offer("ticket-002");
fila.offer("ticket-003");

// examinar sem remover
System.out.println(fila.peek());    // "ticket-001"
System.out.println(fila.size());    // 3

// remover e retornar
System.out.println(fila.poll());    // "ticket-001"
System.out.println(fila.poll());    // "ticket-002"
System.out.println(fila.size());    // 1

// fila vazia
fila.poll();                        // "ticket-003"
System.out.println(fila.poll());    // null — seguro
System.out.println(fila.peek());    // null — seguro
// fila.remove()  ← ❌ lançaria NoSuchElementException
```

---

## 4. LinkedList como Queue

Você já viu isso — `LinkedList` implementa `Queue`:

```java
Queue<String> filaEmails = new LinkedList<>();

filaEmails.offer("email-001@cliente.com");
filaEmails.offer("email-002@cliente.com");
filaEmails.offer("email-003@cliente.com");

// processar todos
while (!filaEmails.isEmpty()) {
    String email = filaEmails.poll();
    System.out.println("Enviando email para: " + email);
}
```

---

## 5. ArrayDeque — implementação preferida

`ArrayDeque` é mais eficiente que `LinkedList` para filas e pilhas — sem overhead de ponteiros:

```java
import java.util.ArrayDeque;
import java.util.Deque;

// como Queue (FIFO)
Queue<String> fila = new ArrayDeque<>();
fila.offer("primeiro");
fila.offer("segundo");
fila.offer("terceiro");
System.out.println(fila.poll()); // "primeiro"

// como Deque (fila dupla — add/remove nas duas pontas)
Deque<String> deque = new ArrayDeque<>();
deque.offerFirst("inicio");
deque.offerLast("fim");
deque.offerFirst("novo-inicio");

System.out.println(deque.pollFirst()); // "novo-inicio"
System.out.println(deque.pollLast());  // "fim"

// como Pilha (LIFO)
Deque<String> pilha = new ArrayDeque<>();
pilha.push("ação 1"); // addFirst
pilha.push("ação 2");
pilha.push("ação 3");
System.out.println(pilha.pop()); // "ação 3" — removeFirst
```

> Regra prática: prefira `ArrayDeque` a `LinkedList` quando usar como fila ou pilha — é mais eficiente. Use `LinkedList` quando precisar de acesso por índice junto com operações de fila.

---

## 6. PriorityQueue — fila com prioridade

Não segue FIFO — o elemento com **menor valor** sai primeiro (por padrão):

```java
import java.util.PriorityQueue;

// números — menor sai primeiro
Queue<Integer> pq = new PriorityQueue<>();
pq.offer(30);
pq.offer(10);
pq.offer(20);
pq.offer(5);

System.out.println(pq.poll()); // 5  — menor
System.out.println(pq.poll()); // 10
System.out.println(pq.poll()); // 20
System.out.println(pq.poll()); // 30
```

Ordem reversa — maior sai primeiro:

```java
Queue<Integer> pqReversa = new PriorityQueue<>(Comparator.reverseOrder());
pqReversa.offer(30);
pqReversa.offer(10);
pqReversa.offer(20);

System.out.println(pqReversa.poll()); // 30 — maior
System.out.println(pqReversa.poll()); // 20
System.out.println(pqReversa.poll()); // 10
```

Com objetos customizados — você define a prioridade:

```java
public class Ticket {
    String id;
    int prioridade; // 1 = alta, 3 = baixa

    public Ticket(String id, int prioridade) {
        this.id = id;
        this.prioridade = prioridade;
    }
}

// menor número de prioridade = maior urgência = sai primeiro
Queue<Ticket> fila = new PriorityQueue<>(
    Comparator.comparingInt(t -> t.prioridade)
);

fila.offer(new Ticket("ticket-003", 3));
fila.offer(new Ticket("ticket-001", 1));
fila.offer(new Ticket("ticket-002", 2));

while (!fila.isEmpty()) {
    Ticket t = fila.poll();
    System.out.printf("Processando %s (prioridade %d)%n", t.id, t.prioridade);
}
// Processando ticket-001 (prioridade 1)
// Processando ticket-002 (prioridade 2)
// Processando ticket-003 (prioridade 3)
```

---

## 7. Casos de uso reais

```java
// 1. Fila de envio de emails em massa
Queue<String> filaEmail = new ArrayDeque<>();

// 2. Fila de processamento de webhooks (Meta Ads → seu sistema)
Queue<String> webhooks = new LinkedList<>();

// 3. Fila de tickets de suporte com prioridade
Queue<Ticket> suporte = new PriorityQueue<>(
    Comparator.comparingInt(t -> t.prioridade)
);

// 4. Histórico de navegação — Deque como pilha
Deque<String> historico = new ArrayDeque<>();

// 5. Buffer de dados para processar em lote
Queue<String> buffer = new ArrayDeque<>();
```

---

## 8. Iterando sobre Queue

```java
Queue<String> fila = new LinkedList<>();
fila.offer("a");
fila.offer("b");
fila.offer("c");

// for-each — não remove os elementos
for (String item : fila) {
    System.out.println(item);
}
System.out.println(fila.size()); // ainda 3

// processando e removendo tudo
while (!fila.isEmpty()) {
    System.out.println(fila.poll()); // remove enquanto processa
}
System.out.println(fila.size()); // 0
```

---

## 9. Comparativo — qual Queue usar

| Situação | Use |
|---|---|
| Fila simples propósito geral | `ArrayDeque` como `Queue` |
| Fila + acesso por índice | `LinkedList` |
| Fila com prioridade | `PriorityQueue` |
| Pilha (LIFO) | `ArrayDeque` como `Deque` |
| Fila dupla (add/remove nas duas pontas) | `ArrayDeque` como `Deque` |

---

## 10. Resumo dos métodos

| Método | Queue | Deque (frente) | Deque (fundo) |
|---|---|---|---|
| Inserir | `offer(e)` | `offerFirst(e)` | `offerLast(e)` |
| Remover | `poll()` | `pollFirst()` | `pollLast()` |
| Examinar | `peek()` | `peekFirst()` | `peekLast()` |
| Pilha inserir | — | `push(e)` | — |
| Pilha remover | — | `pop()` | — |

---

## 11. Comparativo Python vs Java

| Python | Java |
|---|---|
| `queue.Queue` | `LinkedList` ou `ArrayDeque` como `Queue` |
| `collections.deque` | `ArrayDeque` como `Deque` |
| `heapq` | `PriorityQueue` |
| `deque.append(x)` | `offer(x)` / `offerLast(x)` |
| `deque.popleft()` | `poll()` / `pollFirst()` |
| `deque.appendleft(x)` | `offerFirst(x)` |
| `deque.pop()` | `pollLast()` |

---