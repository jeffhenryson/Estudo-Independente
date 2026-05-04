// ## Exercício 5 — Enum implementando interface

// Crie a interface:

// ```java
// interface Relatoravel {
//     String gerarRelatorio(String campanha, double orcamento, double receita);
// }
// ```

// Faça o enum `Plataforma` do exercício 3 implementar `Relatoravel`:

// - Cada constante implementa `gerarRelatorio()` com formato próprio:
//     - `META_ADS` → inclui ROI e sugestão de público
//     - `GOOGLE_ADS` → inclui ROI e CPC estimado (`orcamento / receita * 100`)
//     - `TIKTOK_ADS` → inclui ROI e taxa de engajamento simulada (`receita / orcamento * 10`)

// No `main`:

// 1. Itere todos os valores do enum
// 2. Gere relatório para cada plataforma com os mesmos dados
// 3. Use a interface como tipo: `Relatoravel r = Plataforma.META_ADS`

public class Exercicio05 {
    public static void main(String[] args) {
        String campanha = "Lançamento de Produto";
        double orcamento = 10000;
        double receita = 15000;

        for (Plataforma plataforma : Plataforma.values()) {
            Relatoravel r = plataforma;
            String relatorio = r.gerarRelatorio(campanha, orcamento, receita);
            System.out.println(relatorio);
        }
    }
}

interface Relatoravel {
    String gerarRelatorio(String campanha, double orcamento, double receita);
}

enum Plataforma implements Relatoravel {

    META_ADS {
        @Override
        public String gerarRelatorio(String campanha, double orcamento, double receita) {
            double roi = (receita - orcamento) / orcamento * 100;
            return String.format("META_ADS - Campanha: %s, ROI: %.2f%%, Sugestão de Público: Jovens adultos", campanha, roi);
        }
    },
    GOOGLE_ADS {
        @Override
        public String gerarRelatorio(String campanha, double orcamento, double receita) {
            double roi = (receita - orcamento) / orcamento * 100;
            double cpc = orcamento / receita * 100;
            return String.format("GOOGLE_ADS - Campanha: %s, ROI: %.2f%%, CPC Estimado: %.2f", campanha, roi, cpc);
        }
    },
    TIKTOK_ADS {
        @Override
        public String gerarRelatorio(String campanha, double orcamento, double receita) {
            double roi = (receita - orcamento) / orcamento * 100;
            double taxaEngajamento = receita / orcamento * 10;
            return String.format("TIKTOK_ADS - Campanha: %s, ROI: %.2f%%, Taxa de Engajamento: %.2f", campanha, roi, taxaEngajamento);
        }
    };
}