## Exercício 1 — Record básico

Crie o record `Plano` com os componentes `nome`, `mensalidade` e `limiteUsuarios` e:

1. Crie 3 instâncias: starter, pro e enterprise
2. Acesse cada componente pelos getters automáticos
3. Imprima o `toString()` automático de cada um
4. Compare dois records com os mesmos valores usando `equals()` e mostre o resultado
5. Use os records como chave em um `HashMap<Plano, List<String>>` — adicione empresas para cada plano e itere

---

## Exercício 2 — Construtor compacto com validação

Crie o record `Campanha` com `nome`, `plataforma`, `orcamento` e `receita`:

1. No construtor compacto valide:
    - `nome` não pode ser null ou blank → `IllegalArgumentException`
    - `orcamento` não pode ser negativo → `IllegalArgumentException`
    - `receita` não pode ser negativa → `IllegalArgumentException`
    - Normalize: `nome` com `.trim()`, `plataforma` com `.toUpperCase()`
2. No `main` teste:
    - Instância válida
    - Nome vazio → exceção
    - Orçamento negativo → exceção
    - Verifique a normalização

---

## Exercício 3 — Métodos customizados

Expanda o record `Campanha` do exercício anterior adicionando:

1. `calcularRoi()` → `((receita - orcamento) / orcamento) * 100`
2. `isPositiva()` → retorna `boolean` se ROI > 0
3. `classificar()` → retorna `String`:
    - ROI < 0 → `"Crítica"`
    - ROI 0–30 → `"Regular"`
    - ROI 30–70 → `"Boa"`
    - ROI > 70 → `"Excelente"`
4. `resumo()` → string formatada com todos os dados e classificação
5. Método estático `criar(String nome, String plataforma, double orcamento)` → cria com receita 0.0

No `main`, crie 4 campanhas com ROIs variados e imprima o resumo de cada uma.

---

## Exercício 4 — Record implementando interface

Crie a interface:

```java
interface Exportavel {
    String exportarCsv();
    String exportarJson();
}
```

Crie o record `RelatorioPlano` com `plano`, `totalEmpresas`, `receitaTotal`, `ticketMedio` implementando `Exportavel`:

1. `exportarCsv()` → `"plano,totalEmpresas,receitaTotal,ticketMedio"`
2. `exportarJson()` → `{"plano":"...", "totalEmpresas":..., ...}`
3. Método `resumo()` com dados formatados

No `main`:

1. Crie 3 relatórios um para cada plano
2. Chame `exportarCsv()` e `exportarJson()` em cada um
3. Use a interface como tipo: `Exportavel e = new RelatorioPlano(...)`

---

## Exercício 5 — Record com coleção imutável

Crie o record `Empresa` com `nome`, `plano` e `campanhas` (`List<String>`):

1. No construtor compacto use `List.copyOf(campanhas)` para garantir imutabilidade
2. Adicione método `totalCampanhas()`
3. Adicione método `temCampanha(String nome)` → `boolean`
4. Adicione método estático `criar(String nome, String plano)` → cria com lista vazia

No `main`:

1. Crie empresa com lista mutável e tente modificar depois — mostre a exceção
2. Crie empresa com `criar()` e imprima
3. Verifique `temCampanha()` com valores existentes e inexistentes
4. Use como chave em `Map<Empresa, Double>` mapeando empresa → receita total

---

## Exercício 6 — Desafio

Construa um sistema de relatórios do **Cerne** usando records como DTOs:

**Records:**

```java
record Campanha(String nome, String plataforma, double orcamento, double receita) {
    // construtor compacto com validações
    // calcularRoi(), classificar(), resumo()
}

record RelatorioEmpresa(
    String nomeEmpresa,
    String plano,
    List<Campanha> campanhas
) {
    // construtor compacto com List.copyOf
    // totalInvestido() → soma dos orçamentos
    // totalReceita() → soma das receitas
    // roiMedio() → média dos ROIs
    // melhorCampanha() → retorna Campanha com maior ROI
    // piorCampanha() → retorna Campanha com menor ROI
    // campanhasPorClassificacao() → Map<String, List<Campanha>>
}

record ResumoPlatforma(String plataforma, long totalCampanhas, double roiMedio) {
    // resumo() formatado
}
```

**No `main`:**

1. Crie 3 campanhas para `"Meta Ads"` e 2 para `"Google Ads"`
2. Monte um `RelatorioEmpresa` com todas elas
3. Imprima:
    - Total investido e receita total
    - ROI médio
    - Melhor e pior campanha
    - Campanhas agrupadas por classificação
4. Monte um `List<ResumoPlatforma>` agrupando campanhas por plataforma e imprima cada resumo