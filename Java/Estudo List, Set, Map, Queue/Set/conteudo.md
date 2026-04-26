# ☕ Java — Coleções: Set

---

## 1. O que é e por que existe

`Set` é uma coleção que **não permite elementos duplicados**. Útil quando você precisa garantir unicidade:

```java
// problema com List — aceita duplicatas
List<String> tags = new ArrayList<>();
tags.add("java");
tags.add("spring");
tags.add("java"); // entra normalmente
System.out.println(tags.size()); // 3 — duplicata incluída

// Set — duplicata ignorada automaticamente
Set<String> tags = new HashSet<>();
tags.add("java");
tags.add("spring");
tags.add("java"); // ignorado silenciosamente
System.out.println(tags.size()); // 2
```

---

## 2. As três implementações

```java
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

Set<String> hash   = new HashSet<>();       // sem ordem garantida
Set<String> linked = new LinkedHashSet<>();  // mantém ordem de inserção
Set<String> tree   = new TreeSet<>();        // ordena automaticamente
```

---

## 3. HashSet

Implementação mais rápida — usa tabela hash internamente. Não garante nenhuma ordem:

```java
Set<String> plataformas = new HashSet<>();

plataformas.add("Meta Ads");
plataformas.add("Google Ads");
plataformas.add("TikTok Ads");
plataformas.add("Meta Ads"); // ignorado

System.out.println(plataformas);
// pode imprimir em qualquer ordem: [Google Ads, TikTok Ads, Meta Ads]

System.out.println(plataformas.size());         // 3
System.out.println(plataformas.contains("Meta Ads")); // true
```

---

## 4. LinkedHashSet

Mantém a **ordem de inserção** — quando a ordem importa mas duplicatas não:

```java
Set<String> historico = new LinkedHashSet<>();

historico.add("Meta Ads");
historico.add("Google Ads");
historico.add("TikTok Ads");
historico.add("Meta Ads"); // ignorado

System.out.println(historico);
// sempre: [Meta Ads, Google Ads, TikTok Ads]
```

---

## 5. TreeSet

Ordena os elementos **automaticamente** (ordem natural — alfabética para String, numérica para números):

```java
Set<String> planos = new TreeSet<>();

planos.add("pro");
planos.add("starter");
planos.add("enterprise");
planos.add("basic");

System.out.println(planos);
// sempre: [basic, enterprise, pro, starter]

// TreeSet tem métodos extras de navegação
TreeSet<Integer> numeros = new TreeSet<>();
numeros.add(10);
numeros.add(30);
numeros.add(20);
numeros.add(50);
numeros.add(40);

System.out.println(numeros.first());        // 10 — menor
System.out.println(numeros.last());         // 50 — maior
System.out.println(numeros.floor(25));      // 20 — maior elemento <= 25
System.out.println(numeros.ceiling(25));    // 30 — menor elemento >= 25
System.out.println(numeros.headSet(30));    // [10, 20] — menores que 30
System.out.println(numeros.tailSet(30));    // [30, 40, 50] — maiores ou iguais a 30
System.out.println(numeros.subSet(20, 40)); // [20, 30] — entre 20 e 39
```

---

## 6. Operações básicas — iguais nos três

```java
Set<String> set = new HashSet<>();

// adicionar — retorna boolean (true se adicionou, false se era duplicata)
boolean adicionou = set.add("java");   // true
boolean duplicata = set.add("java");   // false

// remover
set.remove("java");

// verificar
set.contains("spring");  // true ou false

// tamanho
set.size();

// vazio
set.isEmpty();

// limpar
set.clear();

// iterar — sem índice, não tem get()
for (String item : set) {
    System.out.println(item);
}
```

> ⚠️ `Set` não tem `get(índice)` — não é uma lista. Se precisar acessar por índice, use `List`.

---

## 7. Operações de conjunto — matemática de conjuntos

```java
Set<String> setA = new HashSet<>(Arrays.asList("java", "spring", "docker"));
Set<String> setB = new HashSet<>(Arrays.asList("java", "python", "docker"));

// união — todos os elementos de ambos
Set<String> uniao = new HashSet<>(setA);
uniao.addAll(setB);
System.out.println(uniao); // [java, spring, docker, python]

// interseção — só os que existem nos dois
Set<String> intersecao = new HashSet<>(setA);
intersecao.retainAll(setB);
System.out.println(intersecao); // [java, docker]

// diferença — os que estão em A mas não em B
Set<String> diferenca = new HashSet<>(setA);
diferenca.removeAll(setB);
System.out.println(diferenca); // [spring]

// verificar se é subconjunto
Set<String> sub = new HashSet<>(Arrays.asList("java", "docker"));
System.out.println(setA.containsAll(sub)); // true — sub está contido em setA
```

---

## 8. Set com objetos customizados

Por padrão, Set usa `equals()` e `hashCode()` para detectar duplicatas. Com objetos próprios você precisa sobrescrever esses métodos:

```java
public class Campanha {
    private String nome;
    private String plataforma;

    public Campanha(String nome, String plataforma) {
        this.nome = nome;
        this.plataforma = plataforma;
    }

    // sem isso, Set compara por referência de memória — dois objetos
    // com mesmo nome seriam considerados diferentes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campanha c)) return false;
        return nome.equals(c.nome) && plataforma.equals(c.plataforma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, plataforma);
    }
}
```

```java
Set<Campanha> campanhas = new HashSet<>();
campanhas.add(new Campanha("Black Friday", "Meta Ads"));
campanhas.add(new Campanha("Black Friday", "Meta Ads")); // duplicata

System.out.println(campanhas.size()); // 1 — detectou duplicata corretamente
```

---

## 9. Convertendo entre Set e List

```java
// List → Set (remove duplicatas)
List<String> comDuplicatas = new ArrayList<>();
comDuplicatas.add("java");
comDuplicatas.add("spring");
comDuplicatas.add("java");

Set<String> semDuplicatas = new HashSet<>(comDuplicatas);
System.out.println(semDuplicatas.size()); // 2

// Set → List (quando precisar de índice ou ordenação)
List<String> lista = new ArrayList<>(semDuplicatas);
Collections.sort(lista);
System.out.println(lista.get(0)); // acesso por índice agora funciona
```

---

## 10. Quando usar cada um

| Situação | Use |
|---|---|
| Só precisa de unicidade, performance máxima | `HashSet` |
| Unicidade + manter ordem de inserção | `LinkedHashSet` |
| Unicidade + ordenação automática | `TreeSet` |
| Precisa de acesso por índice | Converta para `List` |
| Operações matemáticas de conjunto | Qualquer `Set` |

---

## 11. Comparativo Python vs Java

| Python | Java |
|---|---|
| `set()` | `HashSet` |
| `set()` com `dict` ordered (3.7+) | `LinkedHashSet` |
| `sorted(set())` | `TreeSet` |
| `a \| b` (união) | `addAll()` |
| `a & b` (interseção) | `retainAll()` |
| `a - b` (diferença) | `removeAll()` |
| `a <= b` (subconjunto) | `containsAll()` |

---