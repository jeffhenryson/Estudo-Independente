# Exercícios — Queue

---

## Exercício 1 — Queue básica com ArrayDeque

Simule uma fila de envio de emails do **Cerne**:

1. Crie uma `Queue<String>` usando `ArrayDeque`
2. Adicione 5 emails com `offer()`
3. Imprima o próximo sem remover com `peek()`
4. Processe todos com `poll()` dentro de um `while`
5. Após esvaziar, chame `peek()` e `poll()` e imprima os resultados
6. Mostre com comentários por que `poll()` é mais seguro que `remove()`

---

## Exercício 2 — Diferença entre add/remove e offer/poll

Dado o código abaixo, responda sem rodar o que acontece em cada linha e por quê:

```java
Queue<String> fila = new ArrayDeque<>();
fila.offer("a");
fila.offer("b");

System.out.println(fila.poll());     // ?
System.out.println(fila.poll());     // ?
System.out.println(fila.poll());     // ?
System.out.println(fila.peek());     // ?

Queue<String> fila2 = new ArrayDeque<>();
fila2.add("x");
System.out.println(fila2.remove());  // ?
System.out.println(fila2.remove());  // ? — o que acontece aqui?
```

---

## Exercício 3 — PriorityQueue com números

1. Crie uma `PriorityQueue<Integer>` padrão
2. Adicione os valores: `50, 10, 80, 30, 20, 70`
3. Imprima o menor sem remover com `peek()`
4. Remova e imprima todos com `poll()` — observe a ordem
5. Crie uma segunda `PriorityQueue` com `Comparator.reverseOrder()`
6. Adicione os mesmos valores e remova todos — observe a ordem reversa

---

## Exercício 4 — PriorityQueue com objetos

Crie um sistema de atendimento de suporte do **Cerne** com prioridade:

```java
class Ticket {
    String id;
    String cliente;
    int prioridade; // 1 = crítico, 2 = alto, 3 = normal
}
```

1. Crie uma `PriorityQueue<Ticket>` ordenada por `prioridade`
2. Adicione 5 tickets com prioridades variadas fora de ordem
3. Processe todos com `poll()` e imprima na ordem de atendimento:
```
Atendendo: ticket-002 | Cliente: Cerne | Prioridade: 1 (crítico)
Atendendo: ticket-005 | Cliente: Ana   | Prioridade: 1 (crítico)
Atendendo: ticket-001 | Cliente: Jeff  | Prioridade: 2 (alto)
...
```
4. Use um método `classificar(int prioridade)` que retorna `"crítico"`, `"alto"` ou `"normal"`

---

## Exercício 5 — ArrayDeque como Deque

Implemente um histórico de navegação de páginas do sistema **Cerne**:

1. Crie um `Deque<String>` usando `ArrayDeque`
2. Simule a navegação adicionando páginas com `offerLast()`:
   - `"Dashboard"` → `"Campanhas"` → `"Nova Campanha"` → `"Revisão"` → `"Publicar"`
3. Imprima a página atual com `peekLast()`
4. Implemente voltar — remove a página atual com `pollLast()` e imprime onde está agora
5. Volte 2 vezes e imprima a página atual após cada volta
6. Adicione uma nova página e imprima o histórico completo iterando do início ao fim

---

## Exercício 6 — Desafio

Construa um sistema de processamento de campanhas do **Cerne** com múltiplas filas:

**Estrutura:**
```java
class Campanha {
    String nome;
    String plataforma;
    int prioridade;      // 1 = urgente, 2 = normal, 3 = baixa
    String status;       // "aguardando", "processando", "concluída", "erro"
}
```

**Filas:**
- `PriorityQueue<Campanha>` → fila de entrada ordenada por prioridade
- `Queue<Campanha>` → fila de processamento (ArrayDeque)
- `Deque<Campanha>` → histórico de concluídas (últimas 5)

**Menu `do-while`:**
1. Submeter campanha → lê dados, adiciona na `PriorityQueue`
2. Iniciar processamento → move a próxima da `PriorityQueue` para a fila de processamento
3. Concluir campanha → remove da fila de processamento, adiciona no histórico
   - Histórico mantém só as últimas 5 — se passar de 5, remove a mais antiga com `pollFirst()`
4. Ver próxima da fila de entrada → `peek()` na `PriorityQueue`
5. Ver histórico de concluídas → itera o `Deque` do mais recente ao mais antigo com `descendingIterator()`
6. Estatísticas:
   - Total na fila de entrada
   - Total em processamento
   - Total no histórico
0. Sair

---