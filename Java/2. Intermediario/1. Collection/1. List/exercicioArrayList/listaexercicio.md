## Exercício 1 — Operações básicas

Crie um `List<String>` de nomes de campanhas e:

1. Adicione 5 campanhas
2. Imprima todas com índice usando for tradicional
3. Substitua a campanha do índice 2 com `set()`
4. Adicione uma nova campanha no índice 1 com `add(índice, valor)`
5. Imprima o tamanho antes e depois de cada operação
6. Imprima o primeiro e o último elemento

---

## Exercício 2 — Busca e verificação

Dado o código abaixo, complete os métodos:

```java
List<String> planos = new ArrayList<>();
planos.add("starter");
planos.add("pro");
planos.add("enterprise");
planos.add("pro"); // duplicata intencional
```

1. Verifique se `"pro"` existe na lista
2. Encontre o índice da **primeira** ocorrência de `"pro"`
3. Encontre o índice da **última** ocorrência de `"pro"`
4. Verifique se `"vip"` existe
5. Verifique se a lista está vazia
6. Imprima o resultado de cada verificação com uma mensagem clara

---

## Exercício 3 — Remoção

```java
List<String> emails = new ArrayList<>();
emails.add("jeff@cerne.com");
emails.add("ana@cerne.com");
emails.add("trial@temp.com");
emails.add("bob@cerne.com");
emails.add("spam@temp.com");
emails.add("carlos@cerne.com");
```

1. Remova o email do índice 0
2. Remova `"trial@temp.com"` por valor
3. Use `removeIf()` para remover todos que terminam com `"@temp.com"`
4. Imprima a lista após cada remoção
5. Limpe a lista com `clear()` e confirme que está vazia
---

## Exercício 4 — Ordenação

```java
List<String> nomes = new ArrayList<>();
nsomes.add("Carlos");
nomes.add("Ana");
nomes.add("Bruno");
nomes.add("Amanda");
nomes.add("Diego");

List<Double> precos = new ArrayList<>();
precos.add(299.90);
precos.add(49.90);
precos.add(149.90);
precos.add(499.90);
precos.add(99.90);
```

1. Ordene `nomes` em ordem alfabética e imprima
2. Ordene `nomes` em ordem reversa e imprima
3. Ordene `precos` em ordem crescente e imprima
4. Ordene `precos` em ordem decrescente e imprima

---

## Exercício 5 — Conversão

1. Crie um array `String[]` com 4 plataformas de anúncio
2. Converta para `ArrayList` usando `Arrays.asList()`
3. Imprima a lista
4. Extraia um `subList()` com os 2 primeiros elementos
5. Converta o ArrayList de volta para array com `toArray()`
6. Imprima o array final com `Arrays.toString()`

---

## Exercício 6 — Desafio

Construa um gerenciador de campanhas do **Cerne** usando tudo do ArrayList:

1. Crie um `List<String>` de campanhas ativas
2. Menu `do-while` com as opções:
   - `1 - Adicionar campanha` → lê o nome e adiciona
   - `2 - Listar campanhas` → exibe todas com índice
   - `3 - Remover campanha` → lê o índice e remove
   - `4 - Buscar campanha` → lê o nome e informa se existe e em qual índice
   - `5 - Ordenar campanhas` → ordena alfabeticamente e exibe
   - `0 - Sair`
3. Bloqueie remoção se a lista estiver vazia
4. Bloqueie adição de campanha com nome já existente usando `contains()`
5. Use `removeIf()` em vez de `remove()` na opção de remoção por índice

---