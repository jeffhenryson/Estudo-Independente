## Exercício 1 — Iterator básico

Dada a lista abaixo, use `Iterator` explicitamente (sem `for-each`):

```java
List<String> campanhas = new ArrayList<>(Arrays.asList(
    "Meta Black Friday",
    "Google Remarketing",
    "Meta Verão",
    "TikTok Lançamento",
    "Meta Natal",
    "Google Search"
));
```

1. Itere com `Iterator` e imprima todas as campanhas
2. Use um segundo `Iterator` para remover todas que começam com `"Google"`
3. Imprima a lista final
4. Mostre com comentário por que `it.remove()` é seguro e `lista.remove()` dentro do loop não é

---

## Exercício 2 — ListIterator

Dada a lista de preços:

```java
List<Double> precos = new ArrayList<>(Arrays.asList(
    49.90, 149.90, 299.90, 499.90, 99.90
));
```

1. Use `ListIterator` para imprimir todos os preços com seu índice indo para frente
2. Sem criar novo iterator, volte para trás com `hasPrevious()` e imprima novamente
3. Use `set()` para aplicar 15% de desconto em todos os preços durante a iteração
4. Use `add()` para inserir o preço `199.90` após o elemento `149.90`
5. Imprima a lista final

---

## Exercício 3 — Criando classe Iterable

Crie uma classe `PipelineCampanhas` que:

- Internamente armazena campanhas em um `array` de `String` com capacidade fixa
- Tem método `adicionar(String campanha)`
- Tem método `tamanho()`
- Implementa `Iterable<String>` — o `for-each` deve funcionar nela
- O `Iterator` interno deve respeitar o tamanho real (não a capacidade do array)

No `main`:

```java
PipelineCampanhas pipeline = new PipelineCampanhas(10);
pipeline.adicionar("Black Friday");
pipeline.adicionar("Verão");
pipeline.adicionar("Remarketing");

for (String c : pipeline) {
    System.out.println(c);
}
```

---

## Exercício 4 — Iterator com filtro

Crie uma classe `IteratorPorPlataforma` que implementa `Iterator<String>` e filtra campanhas por plataforma:

```java
List<String> campanhas = Arrays.asList(
    "Meta | Black Friday",
    "Google | Search Branded",
    "Meta | Verão",
    "TikTok | Lançamento",
    "Meta | Natal",
    "Google | Display",
    "Meta | Remarketing"
);
```

1. O construtor recebe a lista e a plataforma a filtrar (`"Meta"`, `"Google"`, etc.)
2. `hasNext()` avança internamente até achar o próximo que contém a plataforma
3. `next()` retorna o elemento e avança o cursor

No `main`:

```java
Iterator<String> metaIt = new IteratorPorPlataforma(campanhas, "Meta");
while (metaIt.hasNext()) {
    System.out.println(metaIt.next());
}

Iterator<String> googleIt = new IteratorPorPlataforma(campanhas, "Google");
while (googleIt.hasNext()) {
    System.out.println(googleIt.next());
}
```

---

## Exercício 5 — Iterable vs Iterator na prática

Responda sem rodar e explique:

```java
List<String> lista = new ArrayList<>(Arrays.asList("a", "b", "c"));

// Bloco 1
for (String s : lista) { System.out.print(s); }
System.out.println();
for (String s : lista) { System.out.print(s); }
System.out.println();

// Bloco 2
Iterator<String> it = lista.iterator();
while (it.hasNext()) { System.out.print(it.next()); }
System.out.println();
while (it.hasNext()) { System.out.print(it.next()); }
System.out.println();

// Bloco 3
Iterator<String> it2 = lista.iterator();
System.out.println(it2.next());
System.out.println(it2.next());
it2.remove();
System.out.println(lista);
```

O que cada bloco imprime e por quê?

---

## Exercício 6 — Desafio

Construa um sistema de pipeline de processamento de campanhas do **Cerne** usando `Iterable` customizado:

**Classe `Campanha`:**

- Atributos: `nome`, `plataforma`, `orcamento`, `status` (`"pendente"`, `"aprovada"`, `"rejeitada"`)
- Construtor + getters + toString

**Classe `PipelineAprovacao` implements `Iterable<Campanha>`:**

- Armazena campanhas em `List<Campanha>` internamente
- Método `submeter(Campanha c)` → adiciona com status `"pendente"`
- Método `total()`, `totalPorStatus(String status)`
- Implementa `Iterable<Campanha>` — itera só sobre as `"pendente"`

**Classe `ProcessadorCampanhas`:**

- Método estático `processar(PipelineAprovacao pipeline)`:
    - Usa `Iterator` explícito obtido do pipeline
    - Para cada campanha pendente:
        - Orçamento >= 1000 → aprova (`status = "aprovada"`)
        - Orçamento < 1000 → rejeita (`status = "rejeitada"`)
    - Usa `it.remove()` para remover da fila de pendentes após processar

No `main`:

1. Crie 5 campanhas com orçamentos variados e submeta
2. Imprima estatísticas antes de processar
3. Chame `ProcessadorCampanhas.processar(pipeline)`
4. Imprima estatísticas depois
5. Confirme que não há mais pendentes iterando o pipeline

---