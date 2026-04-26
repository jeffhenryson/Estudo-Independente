# ☕ Java — Coleções: Map

---

## 1. O que é e por que existe

`Map` armazena pares de **chave-valor** — cada chave é única e mapeia para um valor:

```java
// sem Map — verboso e frágil
String[] chaves = {"starter", "pro", "enterprise"};
double[] valores = {49.90, 149.90, 499.90};
// para buscar o preço do "pro", precisa iterar o array de chaves

// com Map — direto e eficiente
Map<String, Double> precos = new HashMap<>();
precos.put("starter", 49.90);
precos.put("pro", 149.90);
precos.put("enterprise", 499.90);

System.out.println(precos.get("pro")); // 149.9 — acesso direto
```

---

## 2. As três implementações

```java
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

Map<String, Double> hash   = new HashMap<>();       // sem ordem garantida
Map<String, Double> linked = new LinkedHashMap<>();  // mantém ordem de inserção
Map<String, Double> tree   = new TreeMap<>();        // ordena por chave
```

---

## 3. HashMap

Implementação mais comum e mais rápida:

```java
Map<String, Double> precos = new HashMap<>();

// put — adiciona ou substitui
precos.put("starter", 49.90);
precos.put("pro", 149.90);
precos.put("enterprise", 499.90);
precos.put("pro", 199.90); // substitui o valor anterior

System.out.println(precos.get("pro"));        // 199.9
System.out.println(precos.get("vip"));        // null — chave inexistente

// getOrDefault — evita null
System.out.println(precos.getOrDefault("vip", 0.0)); // 0.0

// size
System.out.println(precos.size()); // 3

// containsKey e containsValue
precos.containsKey("starter");    // true
precos.containsValue(49.90);      // true

// remove
precos.remove("starter");

// isEmpty e clear
precos.isEmpty();
precos.clear();
```

---

## 4. Iterando sobre um Map

```java
Map<String, Double> precos = new HashMap<>();
precos.put("starter", 49.90);
precos.put("pro", 149.90);
precos.put("enterprise", 499.90);

// entrySet — chave e valor juntos (mais comum)
for (Map.Entry<String, Double> entry : precos.entrySet()) {
    System.out.printf("%s: R$ %.2f%n", entry.getKey(), entry.getValue());
}

// keySet — só as chaves
for (String chave : precos.keySet()) {
    System.out.println(chave);
}

// values — só os valores
for (Double valor : precos.values()) {
    System.out.println(valor);
}

// forEach com lambda
precos.forEach((chave, valor) ->
    System.out.printf("%s → R$ %.2f%n", chave, valor)
);
```

---

## 5. LinkedHashMap

Mantém a **ordem de inserção** — útil para menus, relatórios, logs:

```java
Map<String, String> etapas = new LinkedHashMap<>();
etapas.put("1", "Criar campanha");
etapas.put("2", "Definir orçamento");
etapas.put("3", "Configurar público");
etapas.put("4", "Publicar");

// sempre imprime na ordem de inserção
for (Map.Entry<String, String> e : etapas.entrySet()) {
    System.out.printf("Etapa %s: %s%n", e.getKey(), e.getValue());
}
```

---

## 6. TreeMap

Ordena **automaticamente pelas chaves**:

```java
Map<String, Double> precos = new TreeMap<>();
precos.put("pro", 149.90);
precos.put("starter", 49.90);
precos.put("enterprise", 499.90);
precos.put("basic", 29.90);

System.out.println(precos);
// {basic=29.9, enterprise=499.9, pro=149.9, starter=49.9} — ordem alfabética

// métodos extras do TreeMap
TreeMap<String, Double> treeMap = new TreeMap<>(precos);
System.out.println(treeMap.firstKey());          // "basic"
System.out.println(treeMap.lastKey());           // "starter"
System.out.println(treeMap.floorKey("pro"));     // "pro"
System.out.println(treeMap.ceilingKey("m"));     // "pro" — primeira chave >= "m"
System.out.println(treeMap.headMap("pro"));      // {basic=29.9, enterprise=499.9}
System.out.println(treeMap.tailMap("pro"));      // {pro=149.9, starter=49.9}
```

---

## 7. Métodos úteis modernos

```java
Map<String, Integer> contagem = new HashMap<>();

// putIfAbsent — só adiciona se a chave não existir
contagem.putIfAbsent("Meta Ads", 0);
contagem.putIfAbsent("Meta Ads", 99); // ignorado — já existe

// getOrDefault — valor padrão se chave não existir
int total = contagem.getOrDefault("Google Ads", 0);

// computeIfAbsent — cria valor se não existir
contagem.computeIfAbsent("TikTok Ads", k -> 0);

// merge — combina valor existente com novo
contagem.merge("Meta Ads", 1, Integer::sum); // soma 1 ao valor atual
contagem.merge("Meta Ads", 1, Integer::sum); // soma mais 1
System.out.println(contagem.get("Meta Ads")); // 2

// replace — substitui só se a chave existir
contagem.replace("Meta Ads", 10);
```

---

## 8. Map com valor sendo coleção

Padrão muito comum — agrupar dados:

```java
// Map<plataforma, List<campanhas>>
Map<String, List<String>> campanhasPorPlataforma = new HashMap<>();

// adicionando campanhas por plataforma
String plataforma = "Meta Ads";
String campanha = "Black Friday";

// sem computeIfAbsent — verboso
if (!campanhasPorPlataforma.containsKey(plataforma)) {
    campanhasPorPlataforma.put(plataforma, new ArrayList<>());
}
campanhasPorPlataforma.get(plataforma).add(campanha);

// com computeIfAbsent — elegante
campanhasPorPlataforma
    .computeIfAbsent(plataforma, k -> new ArrayList<>())
    .add(campanha);

// adicionando mais
campanhasPorPlataforma.computeIfAbsent("Meta Ads", k -> new ArrayList<>()).add("Verão");
campanhasPorPlataforma.computeIfAbsent("Google Ads", k -> new ArrayList<>()).add("Search");
campanhasPorPlataforma.computeIfAbsent("Google Ads", k -> new ArrayList<>()).add("Display");

// imprimindo
for (Map.Entry<String, List<String>> entry : campanhasPorPlataforma.entrySet()) {
    System.out.printf("%s (%d):%n", entry.getKey(), entry.getValue().size());
    for (String c : entry.getValue()) {
        System.out.println("  - " + c);
    }
}
```

---

## 9. Contando ocorrências — padrão clássico

```java
String[] plataformas = {
    "Meta Ads", "Google Ads", "Meta Ads",
    "TikTok Ads", "Google Ads", "Meta Ads"
};

Map<String, Integer> contagem = new HashMap<>();

for (String p : plataformas) {
    contagem.merge(p, 1, Integer::sum);
}

// {Meta Ads=3, Google Ads=2, TikTok Ads=1}
contagem.forEach((k, v) ->
    System.out.printf("%s: %d vezes%n", k, v)
);
```

---

## 10. Quando usar cada um

| Situação | Use |
|---|---|
| Busca rápida por chave | `HashMap` |
| Manter ordem de inserção | `LinkedHashMap` |
| Chaves ordenadas automaticamente | `TreeMap` |
| Agrupar dados por categoria | `Map<K, List<V>>` |
| Contar ocorrências | `Map<K, Integer>` + `merge()` |

---

## 11. Comparativo Python vs Java

| Python | Java |
|---|---|
| `dict` | `HashMap` |
| `dict` (Python 3.7+ mantém ordem) | `LinkedHashMap` |
| `sorted(dict)` | `TreeMap` |
| `d["chave"]` | `map.get("chave")` |
| `d["chave"] = valor` | `map.put("chave", valor)` |
| `"chave" in d` | `map.containsKey("chave")` |
| `d.get("chave", padrão)` | `map.getOrDefault("chave", padrão)` |
| `d.items()` | `map.entrySet()` |
| `d.keys()` | `map.keySet()` |
| `d.values()` | `map.values()` |
| `Counter(lista)` | `Map` + `merge()` |

---