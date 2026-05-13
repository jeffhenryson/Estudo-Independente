## Exercício 1 — filter básico com Strings

Dada a lista:

```java
List<String> campanhas = Arrays.asList(
    "Meta Black Friday",
    "Google Search Branded",
    "Meta Verão 2024",
    "TikTok Lançamento",
    "Google Display",
    "Meta Remarketing",
    "LinkedIn Awareness",
    "Google Shopping"
);
```

1. Filtre só as que começam com `"Meta"` → colete em lista e imprima
2. Filtre só as que contêm `"Search"` → imprima com `forEach`
3. Filtre as que têm mais de 15 caracteres → conte com `count()`
4. Filtre as que NÃO começam com `"Google"` → colete e imprima
5. Filtre as que começam com `"Google"` OU `"LinkedIn"` → colete e imprima

---

## Exercício 2 — filter com números

```java
List<Double> orcamentos = Arrays.asList(
    250.0, 1500.0, 800.0, 3000.0, 150.0,
    2500.0, 600.0, 4000.0, 900.0, 75.0
);
```

1. Filtre orçamentos acima de 1000 → colete e imprima
2. Filtre orçamentos entre 500 e 2000 (inclusive) → colete e imprima
3. Filtre orçamentos abaixo de 300 → some com `count()`
4. Verifique se algum orçamento é acima de 5000 com `anyMatch()`
5. Verifique se todos são positivos com `allMatch()`
6. Verifique se nenhum é zero com `noneMatch()`

---

## Exercício 3 — filter com objetos

```java
record Campanha(String nome, String plataforma, double orcamento, double receita) {
    double calcularRoi() {
        return ((receita - orcamento) / orcamento) * 100;
    }
}

List<Campanha> campanhas = Arrays.asList(
    new Campanha("Black Friday", "Meta Ads", 1000.0, 1800.0),
    new Campanha("Search Branded", "Google Ads", 500.0, 400.0),
    new Campanha("Verão", "Meta Ads", 800.0, 1500.0),
    new Campanha("Display", "Google Ads", 600.0, 900.0),
    new Campanha("Lançamento", "TikTok Ads", 300.0, 200.0),
    new Campanha("Remarketing", "Meta Ads", 1200.0, 2400.0),
    new Campanha("Shopping", "Google Ads", 900.0, 1100.0)
);
```

1. Filtre só campanhas da `"Meta Ads"` → colete e imprima nomes
2. Filtre campanhas com ROI positivo → conte
3. Filtre campanhas com orçamento acima de 800 E ROI positivo → colete
4. Filtre campanhas com ROI acima de 50% → imprima nome e ROI formatado
5. Encontre a primeira campanha do `"Google Ads"` com `findFirst()` → imprima

---

## Exercício 4 — filter encadeado e Predicate reutilizável

Usando as campanhas do exercício anterior:

1. Defina os seguintes `Predicate<Campanha>`:
   - `ehMeta` → plataforma é `"Meta Ads"`
   - `ehGoogle` → plataforma é `"Google Ads"`
   - `ehLucrativa` → ROI > 0
   - `orcamentoAlto` → orçamento > 900
   - `roiExcelente` → ROI > 50

2. Use composição para filtrar:
   - Meta lucrativas → `ehMeta.and(ehLucrativa)`
   - Google com orçamento alto → `ehGoogle.and(orcamentoAlto)`
   - Lucrativas com ROI excelente → `ehLucrativa.and(roiExcelente)`
   - Não são Meta → `ehMeta.negate()`
   - Meta OU Google → `ehMeta.or(ehGoogle)`

3. Para cada resultado imprima o nome das campanhas filtradas

---

## Exercício 5 — filter com terminais variados

Usando as campanhas do exercício 3:

1. `count()` → quantas campanhas têm orçamento acima de 700
2. `findFirst()` → primeira campanha com ROI negativo — trate o `Optional`
3. `anyMatch()` → existe alguma campanha do `"TikTok Ads"`?
4. `allMatch()` → todas as campanhas têm receita positiva?
5. `noneMatch()` → nenhuma campanha tem orçamento zerado?
6. Combine: existe alguma campanha Meta com ROI acima de 100%?

---

## Exercício 6 — Desafio

Construa um sistema de análise de campanhas do **Cerne** usando filter:

```java
record Campanha(
    String nome,
    String plataforma,
    String status,      // "ativa", "pausada", "encerrada"
    double orcamento,
    double receita,
    int diasAtivos
) {
    double calcularRoi() { return ((receita - orcamento) / orcamento) * 100; }
    double calcularCpd() { return orcamento / diasAtivos; } // custo por dia
}
```

Crie uma lista com pelo menos 8 campanhas variadas e implemente os seguintes relatórios **usando apenas filter + terminais**:

1. **Campanhas críticas** → status `"ativa"` E ROI < 0
2. **Campanhas para escalar** → status `"ativa"` E ROI > 50
3. **Campanhas pausadas com potencial** → status `"pausada"` E ROI > 30
4. **Análise por plataforma**:
   - Existe campanha ativa em cada plataforma? (`anyMatch` por plataforma)
   - Todas as campanhas Meta têm orçamento acima de 500? (`allMatch`)
5. **Alertas**:
   - Campanhas ativas há mais de 30 dias com ROI negativo
   - Campanhas com custo por dia acima de 100 (`calcularCpd()`)
6. **Contagens**:
   - Total de campanhas ativas
   - Total de campanhas lucrativas (ROI > 0)
   - Total de campanhas críticas (ROI < -20)

---