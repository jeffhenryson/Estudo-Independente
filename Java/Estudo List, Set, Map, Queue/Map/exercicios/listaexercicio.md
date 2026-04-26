# Exercícios — Map

---

## Exercício 1 — HashMap básico

Crie um `HashMap<String, Double>` com os planos do **Cerne** e:

1. Adicione `starter`, `pro` e `enterprise` com seus preços
2. Imprima todos com `entrySet()` formatado com `printf`
3. Busque o preço de `"pro"` com `get()`
4. Tente buscar `"vip"` com `get()` e depois com `getOrDefault()`
5. Atualize o preço do `"pro"` com `put()` e confirme
6. Verifique se a chave `"starter"` existe com `containsKey()`
7. Verifique se o valor `499.90` existe com `containsValue()`
8. Remova `"starter"` e imprima o mapa final

---

## Exercício 2 — LinkedHashMap e TreeMap

Use os mesmos dados do exercício anterior nos dois tipos:

```java
// dados:
// "pro" → 149.90
// "starter" → 49.90
// "enterprise" → 499.90
// "basic" → 29.90
```

1. Insira em `LinkedHashMap` e imprima — observe a ordem de inserção
2. Insira em `TreeMap` e imprima — observe a ordenação por chave
3. No `TreeMap`, use `firstKey()` e `lastKey()`
4. Use `headMap()` para listar planos que vêm antes de `"pro"` alfabeticamente
5. Use `tailMap()` para listar planos a partir de `"pro"`
6. Explique com comentários a diferença de cada um

---

## Exercício 3 — Métodos modernos

Dado o mapa de contagem de campanhas por plataforma:

```java
Map<String, Integer> contagem = new HashMap<>();
```

1. Use `putIfAbsent()` para inicializar `"Meta Ads"`, `"Google Ads"` e `"TikTok Ads"` com 0
2. Tente usar `putIfAbsent()` novamente com `"Meta Ads"` → 99 e confirme que não mudou
3. Use `merge()` para incrementar a contagem — simule que chegaram:
   - 3 campanhas de `"Meta Ads"`
   - 2 de `"Google Ads"`
   - 1 de `"TikTok Ads"`
4. Use `replace()` para zerar `"TikTok Ads"`
5. Imprima o mapa final com `forEach` e lambda

---

## Exercício 4 — Contando ocorrências

Dado o array de plataformas usadas em campanhas:

```java
String[] registros = {
    "Meta Ads", "Google Ads", "Meta Ads", "TikTok Ads",
    "Google Ads", "Meta Ads", "LinkedIn Ads", "Google Ads",
    "Meta Ads", "TikTok Ads"
};
```

1. Use `merge()` para contar quantas vezes cada plataforma aparece
2. Imprima o resultado ordenado por plataforma — dica: use `TreeMap`
3. Encontre a plataforma com maior número de campanhas
4. Calcule o total de registros somando todos os valores

---

## Exercício 5 — Map com List como valor

Construa um agrupador de campanhas por plataforma:

1. Use `Map<String, List<String>>` para agrupar campanhas
2. Adicione pelo menos 3 campanhas para cada plataforma:
   - `"Meta Ads"`, `"Google Ads"`, `"TikTok Ads"`
3. Use `computeIfAbsent()` para criar a lista automaticamente se não existir
4. Imprima no formato:
```
Meta Ads (3 campanhas):
  - Black Friday
  - Verão
  - Remarketing
```
5. Imprima o total geral de campanhas somando o tamanho de todas as listas
6. Encontre a plataforma com mais campanhas

---

## Exercício 6 — Desafio

Construa um sistema de relatório de performance de campanhas do **Cerne**:

**Estrutura:**
- `Map<String, Double>` → campanha e seu ROI
- `Map<String, List<String>>` → plataforma e suas campanhas
- `Map<String, String>` → campanha e sua plataforma (índice reverso)

**Menu `do-while`:**
1. Cadastrar campanha → lê nome, plataforma e ROI
   - Adiciona nos três maps
   - Bloqueia cadastro duplicado com `containsKey()`
2. Buscar campanha → lê nome e exibe plataforma e ROI
   - Usa `getOrDefault()` para tratar campanha inexistente
3. Listar por plataforma → exibe o `Map<String, List<String>>` completo formatado
4. Relatório de performance → percorre o map de ROI e classifica:
   - ROI < 0 → `"Crítico"`
   - ROI 0–50 → `"Regular"`
   - ROI > 50 → `"Ótimo"`
5. Estatísticas gerais:
   - Total de campanhas cadastradas
   - Campanha com maior ROI
   - Campanha com menor ROI
   - ROI médio geral
0. Sair

---