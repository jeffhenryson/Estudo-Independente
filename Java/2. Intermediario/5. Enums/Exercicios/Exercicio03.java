// ## Exercício 3 — Enum com métodos abstratos

// Crie o enum `Plataforma` com `META_ADS`, `GOOGLE_ADS` e `TIKTOK_ADS`:

// - Atributo: `nome`
// - Método abstrato: `String otimizar(double roi)` — cada plataforma retorna sugestão diferente:
//     - `META_ADS`:
//         - ROI < 0 → `"Pausar e revisar público-alvo"`
//         - ROI 0–50 → `"Ajustar criativos e segmentação"`
//         - ROI > 50 → `"Escalar orçamento"`
//     - `GOOGLE_ADS`:
//         - ROI < 0 → `"Revisar palavras-chave negativas"`
//         - ROI 0–30 → `"Ajustar lances e qualidade do anúncio"`
//         - ROI > 30 → `"Expandir palavras-chave"`
//     - `TIKTOK_ADS`:
//         - ROI < 0 → `"Trocar criativo — formato vídeo curto"`
//         - ROI 0–40 → `"Testar novos públicos"`
//         - ROI > 40 → `"Aumentar frequência"`

// No `main`, teste cada plataforma com ROIs variados.

public class Exercicio03 {
    public static void main(String[] args) {
        
        double[] rois = {-10, 20, 60}; // Exemplo de ROIs
        for (Plataforma plataforma : Plataforma.values()) {
            System.out.println("Plataforma: " + plataforma.getNome());
            for (double roi : rois) {
                System.out.printf("ROI: %.2f%% → Sugestão: %s%n", roi, plataforma.otimizar(roi));
            }
            System.out.println("-----------------------------");
        }
    }
}

enum Plataforma {
    META_ADS("Meta Ads") {
        @Override
        public String otimizar(double roi) {
            if (roi < 0) return "Pausar e revisar público-alvo";
            else if (roi <= 50) return "Ajustar criativos e segmentação";
            else return "Escalar orçamento";
        }
    },
    GOOGLE_ADS("Google Ads") {
        @Override
        public String otimizar(double roi) {
            if (roi < 0) return "Revisar palavras-chave negativas";
            else if (roi <= 30) return "Ajustar lances e qualidade do anúncio";
            else return "Expandir palavras-chave";
        }
    },
    TIKTOK_ADS("TikTok Ads") {
        @Override
        public String otimizar(double roi) {
            if (roi < 0) return "Trocar criativo — formato vídeo curto";
            else if (roi <= 40) return "Testar novos públicos";
            else return "Aumentar frequência";
        }
    };

    private String nome;

    private Plataforma(String nome) {
        this.nome = nome;
    }

    public abstract String otimizar(double roi);

    public String getNome() {
        return nome;
    }
}