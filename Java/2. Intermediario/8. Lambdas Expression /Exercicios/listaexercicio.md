## Exercício 1 — Sintaxe básica

Crie a functional interface `Transformador<T>`:

```java
@FunctionalInterface
interface Transformador<T> {
    T transformar(T valor);
}
```

No `main`, crie as seguintes instâncias usando lambda:

1. `Transformador<String>` que converte para maiúsculas
2. `Transformador<String>` que remove espaços das pontas
3. `Transformador<String>` que inverte a string
4. `Transformador<Integer>` que dobra o número
5. `Transformador<Double>` que arredonda para 2 casas decimais

Aplique cada transformador a um valor e imprima o resultado.

---

## Exercício 2 — Lambdas com coleções

Dada a lista:

```java
List<String> campanhas = new ArrayList<>(Arrays.asList(
    "  Meta Black Friday  ",
    "Google Search Branded",
    "meta verão",
    "TikTok Lançamento",
    "GOOGLE Display",
    "Meta Remarketing",
    "linkedin awareness"
));
```

Use lambdas para:

1. Remover campanhas que contêm `"Google"` (qualquer case) com `removeIf()`
2. Normalizar todas as restantes: `trim()` + capitalizar primeira letra com `forEach()`
3. Ordenar alfabeticamente com `sort()`
4. Ordenar por tamanho do nome (menor para maior)
5. Imprima a lista após cada operação

---

## Exercício 3 — Lambda como parâmetro

Crie a functional interface:

```java
@FunctionalInterface
interface FiltroRelatorio {
    boolean aceitar(String campanha, double roi, String plataforma);
}
```

Crie o método:
```java
static List<String> filtrarCampanhas(
    List<String> nomes,
    List<Double> rois,
    List<String> plataformas,
    FiltroRelatorio filtro
)
```

No `main`, chame o método com os seguintes filtros via lambda:
1. Só campanhas com ROI > 50
2. Só campanhas da plataforma `"Meta Ads"`
3. Campanhas com ROI positivo E plataforma `"Google Ads"`
4. Campanhas cujo nome contém `"Black"`

---

## Exercício 4 — Retornando lambdas

Crie uma fábrica de validadores:

```java
@FunctionalInterface
interface Validador {
    boolean validar(String valor);
}

class ValidadorFactory {
    static Validador tamanhoMinimo(int min) { ... }
    static Validador tamanhoMaximo(int max) { ... }
    static Validador contem(String trecho) { ... }
    static Validador naoContem(String trecho) { ... }
    static Validador regex(String padrao) { ... }
}
```

No `main`:
1. Crie um validador de email: tamanho mínimo 6 + contém `"@"` + contém `"."`
2. Crie um validador de senha: mínimo 8 + não contém `"123"` + regex `".*\\d.*"`
3. Crie um validador de nome de campanha: mínimo 3 + máximo 50 + não contém caracteres especiais
4. Teste cada validador com valores válidos e inválidos

---

## Exercício 5 — Composição com Predicate

Use `Predicate` da `java.util.function` para construir filtros compostos:

```java
List<String> emails = Arrays.asList(
    "jeff@cerne.com",
    "ana@cerne.com.br",
    "spam@temp.com",
    "invalido",
    "bob@empresa.org",
    "",
    "admin@cerne.com"
);
```

1. Crie predicados individuais:
   - `temArroba` → contém `"@"`
   - `temPonto` → contém `"."`
   - `naoEhVazio` → não é blank
   - `ehCerne` → termina com `"@cerne.com"` ou `"@cerne.com.br"`
   - `tamanhoValido` → entre 6 e 100 caracteres

2. Componha com `and()`, `or()`, `negate()`:
   - `emailValido` → temArroba AND temPonto AND naoEhVazio AND tamanhoValido
   - `emailCerneValido` → emailValido AND ehCerne
   - `emailExterno` → emailValido AND ehCerne.negate()

3. Filtre a lista com cada predicado composto e imprima os resultados

---

## Exercício 6 — Desafio

Construa um pipeline de processamento de campanhas do **Cerne** usando lambdas em todo o fluxo:

**Functional interfaces customizadas:**

```java
@FunctionalInterface
interface ProcessadorCampanha {
    Campanha processar(Campanha c);
}

@FunctionalInterface
interface ValidadorCampanha {
    boolean validar(Campanha c);
}

@FunctionalInterface
interface FormatadorRelatorio {
    String formatar(Campanha c);
}
```

**Record:**
```java
record Campanha(String nome, String plataforma, double orcamento, double receita) {
    double calcularRoi() { return ((receita - orcamento) / orcamento) * 100; }
}
```

**Classe `Pipeline`:**
```java
class Pipeline {
    static List<Campanha> filtrar(List<Campanha> campanhas, ValidadorCampanha v) { ... }
    static List<Campanha> transformar(List<Campanha> campanhas, ProcessadorCampanha p) { ... }
    static void relatorio(List<Campanha> campanhas, FormatadorRelatorio f) { ... }
}
```

**No `main`:**
1. Crie uma lista com 6 campanhas variadas
2. Use `filtrar()` com lambda para manter só as com orçamento > 500
3. Use `transformar()` com lambda para aplicar 10% de desconto no orçamento de todas
4. Use `relatorio()` com lambda para imprimir cada campanha no formato:
```
[META ADS] Black Friday | ROI: 75,5% | Orçamento: R$ 900,00
```
5. Encadeie as operações:
```java
Pipeline.relatorio(
    Pipeline.transformar(
        Pipeline.filtrar(campanhas, c -> c.orcamento() > 500),
        c -> new Campanha(c.nome(), c.plataforma(), c.orcamento() * 0.9, c.receita())
    ),
    c -> String.format("[%s] %s | ROI: %.1f%%", c.plataforma().toUpperCase(), c.nome(), c.calcularRoi())
);
```

---