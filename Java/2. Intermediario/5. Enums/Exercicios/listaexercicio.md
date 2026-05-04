## Exercício 1 — Enum básico

Crie um enum `DiaSemana` com os 7 dias e:

1. Imprima todos os valores com `values()` e seus `ordinal()`
2. Converta a String `"QUARTA"` para enum com `valueOf()`
3. Tente converter `"quarta"` e trate o `IllegalArgumentException`
4. Use switch moderno para classificar o dia como `"Dia útil"` ou `"Fim de semana"`
5. Imprima o `name()` e `ordinal()` de cada dia

---

## Exercício 2 — Enum com atributos e métodos

Crie o enum `Plano` completo do **Cerne**:

- Constantes: `STARTER`, `PRO`, `ENTERPRISE`
- Atributos: `nome`, `mensalidade`, `limiteUsuarios`, `limiteCampanhas`
- Métodos:
    - `calcularAnual()` → mensalidade * 12
    - `calcularComDesconto(double percentual)` → mensalidade com desconto
    - `resumo()` → string formatada com todos os dados
    - `podeAdicionarUsuario(int totalAtual)` → boolean

No `main`:

1. Imprima o resumo de todos os planos
2. Calcule o valor anual de cada plano
3. Aplique 15% de desconto no `PRO` e imprima
4. Verifique se cada plano pode adicionar usuário dado um total atual

---

## Exercício 3 — Enum com métodos abstratos

Crie o enum `Plataforma` com `META_ADS`, `GOOGLE_ADS` e `TIKTOK_ADS`:

- Atributo: `nome`
- Método abstrato: `String otimizar(double roi)` — cada plataforma retorna sugestão diferente:
    - `META_ADS`:
        - ROI < 0 → `"Pausar e revisar público-alvo"`
        - ROI 0–50 → `"Ajustar criativos e segmentação"`
        - ROI > 50 → `"Escalar orçamento"`
    - `GOOGLE_ADS`:
        - ROI < 0 → `"Revisar palavras-chave negativas"`
        - ROI 0–30 → `"Ajustar lances e qualidade do anúncio"`
        - ROI > 30 → `"Expandir palavras-chave"`
    - `TIKTOK_ADS`:
        - ROI < 0 → `"Trocar criativo — formato vídeo curto"`
        - ROI 0–40 → `"Testar novos públicos"`
        - ROI > 40 → `"Aumentar frequência"`

No `main`, teste cada plataforma com ROIs variados.

---

## Exercício 4 — EnumSet e EnumMap

Usando o enum `Plano` do exercício 2:

1. Crie um `EnumSet` com todos os planos usando `allOf()`
2. Crie um `EnumSet` só com `STARTER` e `PRO` usando `of()`
3. Crie um `EnumSet` com o complemento — só `ENTERPRISE`
4. Verifique se `PRO` está no set de starter+pro
5. Crie um `EnumMap<Plano, List<String>>` mapeando plano → lista de empresas
6. Adicione 2 empresas para cada plano
7. Itere o `EnumMap` e imprima plano + empresas formatado

---

## Exercício 5 — Enum implementando interface

Crie a interface:

```java
interface Relatoravel {
    String gerarRelatorio(String campanha, double orcamento, double receita);
}
```

Faça o enum `Plataforma` do exercício 3 implementar `Relatoravel`:

- Cada constante implementa `gerarRelatorio()` com formato próprio:
    - `META_ADS` → inclui ROI e sugestão de público
    - `GOOGLE_ADS` → inclui ROI e CPC estimado (`orcamento / receita * 100`)
    - `TIKTOK_ADS` → inclui ROI e taxa de engajamento simulada (`receita / orcamento * 10`)

No `main`:

1. Itere todos os valores do enum
2. Gere relatório para cada plataforma com os mesmos dados
3. Use a interface como tipo: `Relatoravel r = Plataforma.META_ADS`

---

## Exercício 6 — Desafio

Construa um sistema de gestão de campanhas do **Cerne** usando enums em todo o domínio:

**Enums necessários:**

```java
enum Plano { STARTER, PRO, ENTERPRISE }
// com: mensalidade, limiteUsuarios, limiteCampanhas, calcularAnual()

enum Plataforma { META_ADS, GOOGLE_ADS, TIKTOK_ADS }
// com: nome, taxaMinima (double), otimizar(double roi)

enum StatusCampanha { RASCUNHO, AGUARDANDO_APROVACAO, ATIVA, PAUSADA, ENCERRADA }
// com: descricao, podePausar(), podeAtivar()
```

**Classes:**

```java
class Campanha {
    String nome;
    Plataforma plataforma;
    StatusCampanha status;
    double orcamento;
    double receita;

    double calcularRoi()
    void avancarStatus()  // RASCUNHO → AGUARDANDO → ATIVA → ENCERRADA
    void pausar()         // só se status for ATIVA
    String resumo()
}

class Empresa {
    String nome;
    Plano plano;
    List<Campanha> campanhas;

    void adicionarCampanha(Campanha c)  // respeita limiteCampanhas do plano
    void listarCampanhas()
    void resumoFinanceiro()             // total investido, total receita, ROI médio
}
```

**No `main`:**

1. Crie 2 empresas com planos diferentes
2. Adicione campanhas em plataformas variadas
3. Avance os status das campanhas
4. Tente ultrapassar o limite de campanhas do plano
5. Chame `otimizar()` em cada campanha ativa
6. Imprima o resumo financeiro de cada empresa
7. Use `EnumMap<Plataforma, Long>` para contar campanhas por plataforma

---