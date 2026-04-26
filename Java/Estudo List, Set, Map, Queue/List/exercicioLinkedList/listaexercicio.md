# Exercícios — LinkedList

---

## Exercício 1 — Operações nas pontas

Crie uma `LinkedList<String>` de tarefas e:

1. Adicione 3 tarefas normalmente com `add()`
2. Adicione uma tarefa urgente no início com `addFirst()`
3. Adicione uma tarefa de baixa prioridade no final com `addLast()`
4. Imprima o primeiro e o último com `peekFirst()` e `peekLast()`
5. Remova o primeiro com `pollFirst()` e o último com `pollLast()`
6. Imprima a lista após as remoções

---

## Exercício 2 — Fila (FIFO)

Simule uma fila de atendimento de suporte do **Cerne**:

1. Crie uma `Queue<String>` usando `LinkedList`
2. Adicione 5 tickets com `offer()`
3. Imprima o próximo ticket sem remover com `peek()`
4. Processe todos os tickets com `poll()` dentro de um `while`
5. Após esvaziar, tente chamar `peek()` e `poll()` e imprima o resultado
6. Mostre por que `poll()` é mais seguro que `remove()` quando a fila está vazia

---

## Exercício 3 — Pilha (LIFO)

Implemente um histórico de ações de uma campanha usando pilha:

1. Crie uma `LinkedList<String>` funcionando como pilha
2. Registre 5 ações com `push()`:
   - `"Criou campanha"`
   - `"Definiu orçamento R$ 1000"`
   - `"Adicionou público-alvo"`
   - `"Ativou campanha"`
   - `"Alterou orçamento R$ 1500"`
3. Imprima a ação no topo com `peek()`
4. Implemente um loop que desfaz ações com `pop()` até a pilha esvaziar
5. Imprima cada ação desfeita no formato: `"Desfazendo: [ação]"`

---

## Exercício 4 — Iterator

Dada a lista abaixo, use `Iterator` para:

```java
LinkedList<String> emails = new LinkedList<>();
emails.add("jeff@cerne.com");
emails.add("spam@temp.com");
emails.add("ana@cerne.com");
emails.add("lixo@temp.com");
emails.add("bob@cerne.com");
```

1. Itere com `Iterator` e imprima todos os emails
2. Use `it.remove()` para remover os que terminam com `"@temp.com"` durante a iteração
3. Imprima a lista final
4. Use `descendingIterator()` para imprimir os emails de trás para frente

---

## Exercício 5 — ArrayList vs LinkedList

Responda sem rodar e explique o porquê:

```java
// Cenário A
LinkedList<String> lista = new LinkedList<>();
lista.add("a");
lista.add("b");
lista.add("c");

lista.addFirst("z");
System.out.println(lista.getFirst());
System.out.println(lista.get(2));
lista.removeLast();
System.out.println(lista);

// Cenário B — qual estrutura é mais adequada e por quê?
// 1. Uma lista de produtos exibida em uma tabela paginada (muito get por índice)
// 2. Uma fila de emails para envio em massa (muito add no final, remove no início)
// 3. Um histórico de navegação com botão voltar (último a entrar, primeiro a sair)
```

---

## Exercício 6 — Desafio

Construa um sistema de gerenciamento de campanhas do **Cerne** com duas filas:

**Estrutura:**
- `Queue<String>` → fila de campanhas aguardando aprovação
- `LinkedList<String>` → campanhas aprovadas (funciona como histórico/pilha)

**Menu `do-while`:**
1. Submeter campanha para aprovação → adiciona na fila com `offer()`
2. Aprovar próxima campanha → remove da fila com `poll()` e empilha no histórico com `push()`
3. Ver próxima campanha para aprovação → `peek()` na fila
4. Desfazer última aprovação → `pop()` do histórico e devolve para o início da fila com `addFirst()`
5. Listar fila de aprovação → itera e imprime todas sem remover
6. Listar histórico de aprovadas → itera e imprime todas
0. Sair

**Regras:**
- Opção 2 bloqueia se a fila estiver vazia
- Opção 4 bloqueia se o histórico estiver vazio
- Opção 3 informa se não há campanhas aguardando

---