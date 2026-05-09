// ## Exercício 6 — Desafio

// Construa o sistema de processamento de pagamentos do **Cerne** usando sealed classes:

// **Hierarquia de pagamentos:**

// ```java
// sealed interface Pagamento
//     permits PagamentoCartao, PagamentoPix, PagamentoBoleto { }

// record PagamentoCartao(
//     String numero, String bandeira, int parcelas, double valor
// ) implements Pagamento {}

// record PagamentoPix(
//     String chave, String tipoChave, double valor
// ) implements Pagamento {}

// record PagamentoBoleto(
//     String codigoBarras, String vencimento, double valor
// ) implements Pagamento {}
// ```

// **Hierarquia de resultados:**

// ```java
// sealed interface ResultadoPagamento
//     permits ResultadoPagamento.Aprovado,
//             ResultadoPagamento.Reprovado,
//             ResultadoPagamento.Pendente {

//     record Aprovado(Pagamento pagamento, String transacaoId, double taxaAplicada) implements ResultadoPagamento {}
//     record Reprovado(Pagamento pagamento, String motivo, int codigo) implements ResultadoPagamento {}
//     record Pendente(Pagamento pagamento, String etapa) implements ResultadoPagamento {}
// }
// ```

// **Classe `ProcessadorPagamento`:**

// ```java
// class ProcessadorPagamento {

//     // regras por tipo:
//     // Cartao → taxa 2.99% à vista, 1.99% * parcelas se parcelado
//     // Pix → taxa 0% (isento)
//     // Boleto → taxa fixa R$ 3.50

//     ResultadoPagamento processar(Pagamento p)
//     // usa switch para calcular taxa e simular aprovação:
//     // valor > 10000 → Reprovado("Limite excedido", 402)
//     // caso contrário → Aprovado com taxa calculada

//     String formatarRecibo(ResultadoPagamento r)
//     // switch exaustivo — formato diferente por tipo de resultado

//     double calcularTaxa(Pagamento p)
//     // switch exaustivo — taxa por tipo de pagamento

//     void processarLote(List<Pagamento> pagamentos)
//     // processa todos e imprime resumo:
//     // total aprovados, reprovados, pendentes
//     // valor total aprovado
//     // taxa total cobrada
// }
// ```

// **No `main`:**

// 1. Crie pagamentos variados dos 3 tipos
// 2. Processe individualmente e imprima recibo
// 3. Crie uma lista com 8 pagamentos variados e chame `processarLote()`
// 4. Mostre o resumo final 

import java.util.List;


public class Desafio {

    public static void main(String[] args) {
        ProcessadorPagamento processador = new ProcessadorPagamento();

        Pagamento pagamento1 = new PagamentoCartao("1234-5678-9012-3456", "Visa", 1, 5000);
        Pagamento pagamento2 = new PagamentoPix("chave123", "CPF", 15000);
        Pagamento pagamento3 = new PagamentoBoleto("12345678901234567890", "2026-05-10", 200);

        System.out.println(processador.formatarRecibo(processador.processar(pagamento1)));
        System.out.println(processador.formatarRecibo(processador.processar(pagamento2)));
        System.out.println(processador.formatarRecibo(processador.processar(pagamento3)));

        List<Pagamento> pagamentos = List.of(
            pagamento1,
            pagamento2,
            pagamento3,
            new PagamentoCartao("9876-5432-1098-7654", "Mastercard", 3, 8000),
            new PagamentoPix("chave456", "Email", 500),
            new PagamentoBoleto("09876543210987654321", "2026-05-15", 10000),
            new PagamentoCartao("1111-2222-3333-4444", "Amex", 1, 12000),
            new PagamentoPix("chave789", "Telefone", 50)
        );

        processador.processarLote(pagamentos);
    }
}

class ProcessadorPagamento {

    ResultadoPagamento processar(Pagamento p) {
        double taxa = calcularTaxa(p);
        if (p instanceof PagamentoCartao cartao && cartao.valor() > 10000 ||
            p instanceof PagamentoPix pix && pix.valor() > 10000 ||
            p instanceof PagamentoBoleto boleto && boleto.valor() > 10000) {
            return new ResultadoPagamento.Reprovado(p, "Limite excedido", 402);
        }
        return new ResultadoPagamento.Aprovado(p, "TRANS123", taxa);
    }

    String formatarRecibo(ResultadoPagamento r) {
        return switch (r) {
            case ResultadoPagamento.Aprovado aprovado -> "Aprovado: " + aprovado.transacaoId() + " Taxa: " + aprovado.taxaAplicada();
            case ResultadoPagamento.Reprovado reprovado -> "Reprovado: " + reprovado.motivo();
            case ResultadoPagamento.Pendente pendente -> "Pendente: " + pendente.etapa();
        };
    }

    double calcularTaxa(Pagamento p) {
        return switch (p) {
            case PagamentoCartao cartao -> cartao.parcelas() > 1 ? cartao.valor() * 0.0199 * cartao.parcelas() : cartao.valor() * 0.0299;
            case PagamentoPix pix -> 0.0;
            case PagamentoBoleto boleto -> 3.50;
        };
    }

    void processarLote(List<Pagamento> pagamentos) {
        int aprovados = 0, reprovados = 0, pendentes = 0;
        double valorTotalAprovado = 0, taxaTotal = 0;

        for (Pagamento pagamento : pagamentos) {
            ResultadoPagamento resultado = processar(pagamento);
            System.out.println(formatarRecibo(resultado));

            if (resultado instanceof ResultadoPagamento.Aprovado aprovado) {
                aprovados++;
                valorTotalAprovado += aprovado.pagamento().valor();
                taxaTotal += aprovado.taxaAplicada();
            } else if (resultado instanceof ResultadoPagamento.Reprovado) {
                reprovados++;
            } else if (resultado instanceof ResultadoPagamento.Pendente) {
                pendentes++;
            }
        }

        System.out.println("Resumo do Lote:");
        System.out.println("Aprovados: " + aprovados);
        System.out.println("Reprovados: " + reprovados);
        System.out.println("Pendentes: " + pendentes);
        System.out.println("Valor Total Aprovado: R$" + valorTotalAprovado);
        System.out.println("Taxa Total Cobrada: R$" + taxaTotal);
    }
}

 sealed interface Pagamento
            permits PagamentoCartao, PagamentoPix, PagamentoBoleto {
    }

record PagamentoCartao(
        String numero, String bandeira, int parcelas, double valor) implements Pagamento {
}

record PagamentoPix(
        String chave, String tipoChave, double valor) implements Pagamento {
}

record PagamentoBoleto(
        String codigoBarras, String vencimento, double valor) implements Pagamento {
}

sealed interface ResultadoPagamento
            permits ResultadoPagamento.Aprovado,
            ResultadoPagamento.Reprovado,
            ResultadoPagamento.Pendente {

        record Aprovado(Pagamento pagamento, String transacaoId, double taxaAplicada) implements ResultadoPagamento {
        }

        record Reprovado(Pagamento pagamento, String motivo, int codigo) implements ResultadoPagamento {
        }

        record Pendente(Pagamento pagamento, String etapa) implements ResultadoPagamento {
        }
    }