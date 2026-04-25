## 1. Por que Coleções?

Arrays têm tamanho fixo. Coleções resolvem isso:

```java
int[] array = new int[5]; // fixo — sempre 5
List<String> lista = new ArrayList<>(); // dinâmico — cresce conforme necessário
```

Todas as coleções fazem parte do **Java Collections Framework** e estão em `java.util`.

---

## 2. Hierarquia

```
Collection
├── List       → ordenada, permite duplicatas
│   ├── ArrayList
│   └── LinkedList
├── Set        → sem duplicatas, sem ordem garantida
│   ├── HashSet
│   ├── LinkedHashSet  (mantém ordem de inserção)
│   └── TreeSet        (ordenado naturalmente)
└── Queue      → fila, FIFO
    ├── LinkedList
    └── PriorityQueue

Map            → chave-valor (não estende Collection)
├── HashMap
├── LinkedHashMap
└── TreeMap
```

---

## 3. List — ArrayList

```java
import java.util.ArrayList;
import java.util.List;

List<String> planos = new ArrayList<>();

// adicionar
planos.add("starter");
planos.add("pro");
planos.add("enterprise");
planos.add(1, "basic"); // insere no índice 1

// acessar
System.out.println(planos.get(0));    // "starter"
System.out.println(planos.size());    // 4

// remover
planos.remove("basic");               // por valor
planos.remove(0);                     // por índice

// verificar
planos.contains("pro");               // true
planos.isEmpty();                     // false
planos.indexOf("pro");                // índice do elemento

// iterar
for (String plano : planos) {
    System.out.println(plano);
}

// ordenar
import java.util.Collections;
Collections.sort(planos);             // alfabético
```

---

## 4. List — LinkedList

Melhor para inserções/remoções frequentes no meio da lista:

```java
import java.util.LinkedList;

LinkedList<String> fila = new LinkedList<>();
fila.addFirst("primeiro");
fila.addLast("último");
fila.removeFirst();
fila.removeLast();
System.out.println(fila.peekFirst()); // olha sem remover
```

| | ArrayList | LinkedList |
|---|---|---|
| Acesso por índice | ✅ rápido | ❌ lento |
| Inserção no meio | ❌ lento | ✅ rápido |
| Uso de memória | menor | maior |
| Uso mais comum | leitura | fila/pilha |

---

## 5. Set — sem duplicatas

```java
import java.util.HashSet;
import java.util.Set;

Set<String> tags = new HashSet<>();
tags.add("java");
tags.add("spring");
tags.add("java");      // ignorado — duplicata
tags.add("postgresql");

System.out.println(tags.size());       // 3
System.out.println(tags.contains("java")); // true

// LinkedHashSet — mantém ordem de inserção
Set<String> ordenado = new LinkedHashSet<>();
ordenado.add("c");
ordenado.add("a");
ordenado.add("b");
System.out.println(ordenado); // [c, a, b]

// TreeSet — ordena automaticamente
Set<String> arvore = new TreeSet<>();
arvore.add("c");
arvore.add("a");
arvore.add("b");
System.out.println(arvore); // [a, b, c]
```

---

## 6. Map — chave-valor

```java
import java.util.HashMap;
import java.util.Map;

Map<String, Double> precos = new HashMap<>();

// adicionar
precos.put("starter", 49.90);
precos.put("pro", 149.90);
precos.put("enterprise", 499.90);

// acessar
System.out.println(precos.get("pro"));           // 149.9
System.out.println(precos.getOrDefault("vip", 0.0)); // 0.0 se não existir

// verificar
precos.containsKey("starter");    // true
precos.containsValue(149.90);     // true

// remover
precos.remove("starter");

// iterar
for (Map.Entry<String, Double> entry : precos.entrySet()) {
    System.out.printf("%s: R$ %.2f%n", entry.getKey(), entry.getValue());
}

// só chaves
for (String chave : precos.keySet()) {
    System.out.println(chave);
}

// só valores
for (Double valor : precos.values()) {
    System.out.println(valor);
}
```

---

## 7. Queue — fila FIFO

```java
import java.util.LinkedList;
import java.util.Queue;

Queue<String> filaSuporte = new LinkedList<>();

filaSuporte.offer("ticket-001"); // adiciona no fim
filaSuporte.offer("ticket-002");
filaSuporte.offer("ticket-003");

System.out.println(filaSuporte.peek());  // olha o primeiro sem remover
System.out.println(filaSuporte.poll());  // remove e retorna o primeiro
System.out.println(filaSuporte.size());  // 2
```

---

## 8. Qual usar em cada situação

| Situação | Use |
|---|---|
| Lista ordenada com duplicatas | `ArrayList` |
| Inserções/remoções frequentes | `LinkedList` |
| Sem duplicatas, sem ordem | `HashSet` |
| Sem duplicatas, ordem de inserção | `LinkedHashSet` |
| Sem duplicatas, ordenado | `TreeSet` |
| Chave-valor, sem ordem | `HashMap` |
| Chave-valor, ordem de inserção | `LinkedHashMap` |
| Chave-valor, ordenado por chave | `TreeMap` |
| Fila FIFO | `Queue` / `LinkedList` |

---

## 9. Comparativo Python vs Java

| Python | Java |
|---|---|
| `list` | `ArrayList` |
| `set` | `HashSet` |
| `dict` | `HashMap` |
| `deque` | `LinkedList` como Queue |
| `lista.append(x)` | `lista.add(x)` |
| `lista[0]` | `lista.get(0)` |
| `len(lista)` | `lista.size()` |
| `x in lista` | `lista.contains(x)` |
| `dict[chave]` | `map.get(chave)` |

