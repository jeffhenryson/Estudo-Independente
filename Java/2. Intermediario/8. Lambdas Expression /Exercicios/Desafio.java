// ## Exercício 6 — Desafio

// Construa um pipeline de processamento de campanhas do **Cerne** usando lambdas em todo o fluxo:

// **Functional interfaces customizadas:**

// ```java
// @FunctionalInterface
// interface ProcessadorCampanha {
//     Campanha processar(Campanha c);
// }

// @FunctionalInterface
// interface ValidadorCampanha {
//     boolean validar(Campanha c);
// }

// @FunctionalInterface
// interface FormatadorRelatorio {
//     String formatar(Campanha c);
// }
// ```

// **Record:**
// ```java
// record Campanha(String nome, String plataforma, double orcamento, double receita) {
//     double calcularRoi() { return ((receita - orcamento) / orcamento) * 100; }
// }
// ```

// **Classe `Pipeline`:**
// ```java
// class Pipeline {
//     static List<Campanha> filtrar(List<Campanha> campanhas, ValidadorCampanha v) { ... }
//     static List<Campanha> transformar(List<Campanha> campanhas, ProcessadorCampanha p) { ... }
//     static void relatorio(List<Campanha> campanhas, FormatadorRelatorio f) { ... }
// }
// ```

// **No `main`:**
// 1. Crie uma lista com 6 campanhas variadas
// 2. Use `filtrar()` com lambda para manter só as com orçamento > 500
// 3. Use `transformar()` com lambda para aplicar 10% de desconto no orçamento de todas
// 4. Use `relatorio()` com lambda para imprimir cada campanha no formato:
// ```
// [META ADS] Black Friday | ROI: 75,5% | Orçamento: R$ 900,00
// ```
// 5. Encadeie as operações:
// ```java
// Pipeline.relatorio(
//     Pipeline.transformar(
//         Pipeline.filtrar(campanhas, c -> c.orcamento() > 500),
//         c -> new Campanha(c.nome(), c.plataforma(), c.orcamento() * 0.9, c.receita())
//     ),
//     c -> String.format("[%s] %s | ROI: %.1f%%", c.plataforma().toUpperCase(), c.nome(), c.calcularRoi())
// );
// ```

import java.util.ArrayList;
import java.util.List;

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

record Campanha(String nome, String plataforma, double orcamento, double receita) {
    double calcularRoi() {
        return ((receita - orcamento) / orcamento) * 100;
    }
}

class Pipeline {
    static List<Campanha> filtrar(List<Campanha> campanhas, ValidadorCampanha v) {
        List<Campanha> resultado = new ArrayList<>();
        for (Campanha c : campanhas) {
            if (v.validar(c)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    static List<Campanha> transformar(List<Campanha> campanhas, ProcessadorCampanha p) {
        List<Campanha> resultado = new ArrayList<>();
        for (Campanha c : campanhas) {
            resultado.add(p.processar(c));
        }
        return resultado;
    }

    static void relatorio(List<Campanha> campanhas, FormatadorRelatorio f) {
        for (Campanha c : campanhas) {
            System.out.println(f.formatar(c));
        }
    }
}

public class Desafio {
    public static void main(String[] args) {
        List<Campanha> campanhas = List.of(
            new Campanha("Black Friday", "Meta Ads", 1000, 1750),
            new Campanha("Natal", "Google Ads", 800, 1200),
            new Campanha("Ano Novo", "Meta Ads", 400, 600),
            new Campanha("Carnaval", "LinkedIn", 600, 900),
            new Campanha("Páscoa", "Google Ads", 300, 500),
            new Campanha("Dia das Mães", "Meta Ads", 1200, 2000)
        );

        Pipeline.relatorio(
            Pipeline.transformar(
                Pipeline.filtrar(campanhas, c -> c.orcamento() > 500),
                c -> new Campanha(c.nome(), c.plataforma(), c.orcamento() * 0.9, c.receita())
            ),
            c -> String.format("[%s] %s | ROI: %.1f%% | Orçamento: R$ %.2f", 
                c.plataforma().toUpperCase(), c.nome(), c.calcularRoi(), c.orcamento())
        );
    }
}
