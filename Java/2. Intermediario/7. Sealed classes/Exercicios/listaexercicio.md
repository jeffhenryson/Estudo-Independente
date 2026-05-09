### Exercício

## Exercício 1 — Sealed class básica

Crie a hierarquia selada:

```java
sealed class FormaPagamento permits Cartao, Boleto, Pix { }
```

- `Cartao` → `final`, atributos: `numero`, `bandeira`, `parcelas`
- `Boleto` → `final`, atributos: `codigoBarras`, `vencimento`
- `Pix` → `final`, atributos: `chave`, `tipochave` (`"CPF"`, `"EMAIL"`, `"TELEFONE"`)

No `main`:

1. Crie uma instância de cada tipo
2. Use `switch` com pattern matching para processar cada pagamento e imprimir uma mensagem específica
3. Mostre que adicionar uma classe fora do `permits` gera erro — coloque como comentário explicando

---

## Exercício 2 — Sealed interface + records

Crie a sealed interface `ResultadoOperacao` com os records internos:

```java
sealed interface ResultadoOperacao
    permits ResultadoOperacao.Sucesso,
            ResultadoOperacao.Falha,
            ResultadoOperacao.Pendente { }
```

- `Sucesso` → `mensagem`, `dados` (String)
- `Falha` → `mensagem`, `codigo` (int), `detalhe`
- `Pendente` → `mensagem`, `estimativaSecs` (int)

Crie um método `processar(ResultadoOperacao r)` que usa switch exaustivo e retorna uma String formatada diferente para cada caso.

No `main`, crie um de cada e processe todos — mostre que não precisa de `default`.

---

## Exercício 3 — Sealed com modificadores

Crie a hierarquia de campanhas:

```java
sealed class Campanha permits CampanhaDigital, CampanhaTradicional { }

// sealed — controla quem estende
sealed class CampanhaDigital extends Campanha
    permits CampanhaMetaAds, CampanhaGoogleAds { }

// non-sealed — abre a hierarquia
non-sealed class CampanhaTradicional extends Campanha { }

final class CampanhaMetaAds extends CampanhaDigital { }
final class CampanhaGoogleAds extends CampanhaDigital { }
```

1. Adicione atributos relevantes em cada classe
2. Crie uma subclasse de `CampanhaTradicional` — mostre que funciona pois é `non-sealed`
3. Tente criar subclasse de `CampanhaMetaAds` — mostre o erro com comentário
4. Use switch com pattern matching para calcular ROI mínimo esperado por tipo

---

## Exercício 4 — Switch exaustivo

Dado o sealed abaixo, implemente os métodos usando switch **sem `default`**:

```java
sealed interface StatusPagamento
    permits StatusPagamento.Aprovado,
            StatusPagamento.Reprovado,
            StatusPagamento.Cancelado,
            StatusPagamento.Estornado {

    record Aprovado(String transacaoId, double valor) implements StatusPagamento {}
    record Reprovado(String motivo, int tentativas) implements StatusPagamento {}
    record Cancelado(String motivo) implements StatusPagamento {}
    record Estornado(String transacaoId, double valor, String motivo) implements StatusPagamento {}
}
```

Implemente:

1. `String descricao(StatusPagamento s)` → mensagem humana para cada status
2. `boolean requerAcao(StatusPagamento s)` → true se precisa de intervenção
3. `double valorEnvolvido(StatusPagamento s)` → valor ou 0.0 se não aplicável
4. Demonstre que adicionar um novo tipo ao `permits` quebraria os switches — comente

---

## Exercício 5 — Hierarquia em camadas

Construa o sistema de eventos do **Cerne**:

```java
sealed interface Evento
    permits EventoCampanha, EventoUsuario { }

sealed interface EventoCampanha extends Evento
    permits EventoCampanha.Criada,
            EventoCampanha.Ativada,
            EventoCampanha.Pausada,
            EventoCampanha.Encerrada { }

sealed interface EventoUsuario extends Evento
    permits EventoUsuario.Login,
            EventoUsuario.Logout,
            EventoUsuario.AcessoNegado { }
```

1. Implemente todos os records internos com atributos relevantes
2. Crie um método `String log(Evento e)` com switch exaustivo em dois níveis
3. Crie um método `boolean ehCritico(Evento e)` — críticos: `AcessoNegado`, `Encerrada` com ROI < 0
4. No `main`, crie uma lista `List<Evento>`, popule com vários tipos e processe todos

---

## Exercício 6 — Desafio

Construa o sistema de processamento de pagamentos do **Cerne** usando sealed classes:

**Hierarquia de pagamentos:**

```java
sealed interface Pagamento
    permits PagamentoCartao, PagamentoPix, PagamentoBoleto { }

record PagamentoCartao(
    String numero, String bandeira, int parcelas, double valor
) implements Pagamento {}

record PagamentoPix(
    String chave, String tipoChave, double valor
) implements Pagamento {}

record PagamentoBoleto(
    String codigoBarras, String vencimento, double valor
) implements Pagamento {}
```

**Hierarquia de resultados:**

```java
sealed interface ResultadoPagamento
    permits ResultadoPagamento.Aprovado,
            ResultadoPagamento.Reprovado,
            ResultadoPagamento.Pendente {

    record Aprovado(Pagamento pagamento, String transacaoId, double taxaAplicada) implements ResultadoPagamento {}
    record Reprovado(Pagamento pagamento, String motivo, int codigo) implements ResultadoPagamento {}
    record Pendente(Pagamento pagamento, String etapa) implements ResultadoPagamento {}
}
```

**Classe `ProcessadorPagamento`:**

```java
class ProcessadorPagamento {

    // regras por tipo:
    // Cartao → taxa 2.99% à vista, 1.99% * parcelas se parcelado
    // Pix → taxa 0% (isento)
    // Boleto → taxa fixa R$ 3.50

    ResultadoPagamento processar(Pagamento p)
    // usa switch para calcular taxa e simular aprovação:
    // valor > 10000 → Reprovado("Limite excedido", 402)
    // caso contrário → Aprovado com taxa calculada

    String formatarRecibo(ResultadoPagamento r)
    // switch exaustivo — formato diferente por tipo de resultado

    double calcularTaxa(Pagamento p)
    // switch exaustivo — taxa por tipo de pagamento

    void processarLote(List<Pagamento> pagamentos)
    // processa todos e imprime resumo:
    // total aprovados, reprovados, pendentes
    // valor total aprovado
    // taxa total cobrada
}
```

**No `main`:**

1. Crie pagamentos variados dos 3 tipos
2. Processe individualmente e imprima recibo
3. Crie uma lista com 8 pagamentos variados e chame `processarLote()`
4. Mostre o resumo final

---