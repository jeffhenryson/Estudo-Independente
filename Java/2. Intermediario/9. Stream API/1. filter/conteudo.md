
---

## 1. O que é Stream API

Stream é uma sequência de elementos que suporta operações em cadeia para processar dados de forma declarativa. Você descreve **o que quer**, não **como fazer**:

```java
// sem Stream — imperativo (como fazer)
List<String> resultado = new ArrayList<>();
for (String campanha : campanhas) {
    if (campanha.startsWith("Meta")) {
        resultado.add(campanha);
    }
}

// com Stream — declarativo (o que fazer)
List<String> resultado = campanhas.stream()
    .filter(c -> c.startsWith("Meta"))
    .collect(Collectors.toList());
```

---

## 2. Como um Stream funciona

```
fonte → operações intermediárias → operação terminal
  ↓              ↓                        ↓
lista         filter, map             collect, count
              sorted, distinct        forEach, findFirst
```

- **Operações intermediárias** — retornam outro Stream, são lazy (só executam quando há terminal)
- **Operação terminal** — dispara o processamento e retorna resultado

```java
List<String> campanhas = Arrays.asList(
    "Meta Black Friday",
    "Google Search",
    "Meta Verão",
    "TikTok Lançamento"
);

// sem terminal — nada acontece ainda
Stream<String> stream = campanhas.stream()
    .filter(c -> c.startsWith("Meta")); // lazy — não executou ainda

// com terminal — agora executa
List<String> resultado = stream.collect(Collectors.toList()); // dispara tudo
```

---

## 3. Criando Streams

```java
// de List
List<String> lista = Arrays.asList("a", "b", "c");
Stream<String> s1 = lista.stream();

// de array
String[] array = {"a", "b", "c"};
Stream<String> s2 = Arrays.stream(array);

// de valores diretos
Stream<String> s3 = Stream.of("a", "b", "c");

// vazio
Stream<String> s4 = Stream.empty();

// infinito — com limite
Stream<Integer> s5 = Stream.iterate(0, n -> n + 1).limit(10);
// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
```

---

## 4. filter — conceito

`filter` recebe um `Predicate<T>` e mantém só os elementos que retornam `true`:

```java
// assinatura
Stream<T> filter(Predicate<T> predicate)
```

```java
List<String> campanhas = Arrays.asList(
    "Meta Black Friday",
    "Google Search",
    "Meta Verão",
    "TikTok Lançamento",
    "Meta Remarketing"
);

// filtra só as Meta
List<String> metaCampanhas = campanhas.stream()
    .filter(c -> c.startsWith("Meta"))
    .collect(Collectors.toList());

System.out.println(metaCampanhas);
// [Meta Black Friday, Meta Verão, Meta Remarketing]
```

---

## 5. filter com diferentes condições

```java
List<Double> orcamentos = Arrays.asList(500.0, 1500.0, 800.0, 3000.0, 200.0, 2500.0);

// maior que 1000
List<Double> altos = orcamentos.stream()
    .filter(o -> o > 1000)
    .collect(Collectors.toList());
// [1500.0, 3000.0, 2500.0]

// entre 500 e 2000
List<Double> medios = orcamentos.stream()
    .filter(o -> o >= 500 && o <= 2000)
    .collect(Collectors.toList());
// [500.0, 1500.0, 800.0]

// Strings — múltiplas condições
List<String> campanhas = Arrays.asList(
    "Meta Black Friday",
    "Google Search",
    "Meta Verão",
    "TikTok Lançamento",
    "Google Display"
);

// contém "Black" OU começa com "TikTok"
List<String> filtradas = campanhas.stream()
    .filter(c -> c.contains("Black") || c.startsWith("TikTok"))
    .collect(Collectors.toList());
// [Meta Black Friday, TikTok Lançamento]
```

---

## 6. filter encadeado — múltiplos filtros

```java
List<String> campanhas = Arrays.asList(
    "Meta Black Friday",
    "Google Search Branded",
    "Meta Verão 2024",
    "TikTok Lançamento",
    "Meta Remarketing",
    "Google Display"
);

// dois filter encadeados — equivale a AND
List<String> resultado = campanhas.stream()
    .filter(c -> c.startsWith("Meta"))        // só Meta
    .filter(c -> c.length() > 15)             // nome longo
    .collect(Collectors.toList());
// [Meta Black Friday, Meta Remarketing]

// equivalente com AND no mesmo filter
List<String> resultado2 = campanhas.stream()
    .filter(c -> c.startsWith("Meta") && c.length() > 15)
    .collect(Collectors.toList());
```

> Dois `filter` encadeados ou um `filter` com `&&` — o resultado é o mesmo. Use dois quando os predicados são independentes e você quer legibilidade.

---

## 7. filter com objetos

```java
record Campanha(String nome, String plataforma, double orcamento, double receita) {
    double calcularRoi() {
        return ((receita - orcamento) / orcamento) * 100;
    }
}

List<Campanha> campanhas = Arrays.asList(
    new Campanha("Black Friday", "Meta Ads", 1000.0, 1800.0),
    new Campanha("Search", "Google Ads", 500.0, 400.0),
    new Campanha("Verão", "Meta Ads", 800.0, 1500.0),
    new Campanha("Display", "Google Ads", 600.0, 900.0),
    new Campanha("Lançamento", "TikTok Ads", 300.0, 200.0)
);

// só campanhas com ROI positivo
List<Campanha> lucrativas = campanhas.stream()
    .filter(c -> c.calcularRoi() > 0)
    .collect(Collectors.toList());

// Meta Ads com orçamento acima de 500
List<Campanha> metaGrandes = campanhas.stream()
    .filter(c -> c.plataforma().equals("Meta Ads"))
    .filter(c -> c.orcamento() > 500)
    .collect(Collectors.toList());

// ROI acima de 50% em qualquer plataforma
List<Campanha> excelentes = campanhas.stream()
    .filter(c -> c.calcularRoi() > 50)
    .collect(Collectors.toList());
```

---

## 8. Terminais úteis com filter

Você vai combinar `filter` com vários terminais diferentes:

```java
List<Campanha> campanhas = Arrays.asList(
    new Campanha("Black Friday", "Meta Ads", 1000.0, 1800.0),
    new Campanha("Search", "Google Ads", 500.0, 400.0),
    new Campanha("Verão", "Meta Ads", 800.0, 1500.0),
    new Campanha("Display", "Google Ads", 600.0, 900.0)
);

// collect — coleta em lista
List<Campanha> lista = campanhas.stream()
    .filter(c -> c.orcamento() > 700)
    .collect(Collectors.toList());

// count — conta quantos passaram
long total = campanhas.stream()
    .filter(c -> c.calcularRoi() > 0)
    .count();
System.out.println("Campanhas lucrativas: " + total); // 3

// findFirst — primeiro que passar
Optional<Campanha> primeira = campanhas.stream()
    .filter(c -> c.plataforma().equals("Google Ads"))
    .findFirst();
primeira.ifPresent(c -> System.out.println("Primeira Google: " + c.nome()));

// anyMatch — algum passa?
boolean temMeta = campanhas.stream()
    .anyMatch(c -> c.plataforma().equals("Meta Ads"));
System.out.println("Tem Meta? " + temMeta); // true

// allMatch — todos passam?
boolean todosPositivos = campanhas.stream()
    .allMatch(c -> c.orcamento() > 0);
System.out.println("Todos com orçamento > 0? " + todosPositivos); // true

// noneMatch — nenhum passa?
boolean semTikTok = campanhas.stream()
    .noneMatch(c -> c.plataforma().equals("TikTok Ads"));
System.out.println("Sem TikTok? " + semTikTok); // true
```

---

## 9. filter com Predicate reutilizável

```java
// predefinindo predicados para reutilizar
Predicate<Campanha> ehMeta = c -> c.plataforma().equals("Meta Ads");
Predicate<Campanha> ehLucrativa = c -> c.calcularRoi() > 0;
Predicate<Campanha> orcamentoAlto = c -> c.orcamento() > 800;

// reutilizando e compondo
List<Campanha> metaLucrativas = campanhas.stream()
    .filter(ehMeta.and(ehLucrativa))
    .collect(Collectors.toList());

List<Campanha> lucrantivasOuAltas = campanhas.stream()
    .filter(ehLucrativa.or(orcamentoAlto))
    .collect(Collectors.toList());

List<Campanha> naoMeta = campanhas.stream()
    .filter(ehMeta.negate())
    .collect(Collectors.toList());
```

---

## 10. Stream é de uso único

```java
Stream<String> stream = campanhas.stream()
    .filter(c -> c.startsWith("Meta"));

List<String> lista1 = stream.collect(Collectors.toList()); // ✅
List<String> lista2 = stream.collect(Collectors.toList()); // ❌ IllegalStateException
// stream já foi consumido — crie um novo
```

---