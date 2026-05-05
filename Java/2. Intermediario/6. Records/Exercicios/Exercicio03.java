// ## Exercício 3 — Métodos customizados

// Expanda o record `Campanha` do exercício anterior adicionando:

// 1. `calcularRoi()` → `((receita - orcamento) / orcamento) * 100`
// 2. `isPositiva()` → retorna `boolean` se ROI > 0
// 3. `classificar()` → retorna `String`:
//     - ROI < 0 → `"Crítica"`
//     - ROI 0–30 → `"Regular"`
//     - ROI 30–70 → `"Boa"`
//     - ROI > 70 → `"Excelente"`
// 4. `resumo()` → string formatada com todos os dados e classificação
// 5. Método estático `criar(String nome, String plataforma, double orcamento)` → cria com receita 0.0

// No `main`, crie 4 campanhas com ROIs variados e imprima o resumo de cada uma.

public class Exercicio03 {
    public static void main(String[] args) {

        Campanha c1 = new Campanha("Campanha A", "Google Ads", 1000, 1500);
        Campanha c2 = new Campanha("Campanha B", "Facebook Ads", 2000, 1800);
        Campanha c3 = new Campanha("Campanha C", "Instagram Ads", 500, 700);
        Campanha c4 = new Campanha("Campanha D", "LinkedIn Ads", 3000, 2500);

        System.out.println(c1.resumo());
        System.out.println(c2.resumo());
        System.out.println(c3.resumo());
        System.out.println(c4.resumo());

        // Testando o método estático criar
        Campanha c5 = Campanha.criar("Campanha E", "Twitter Ads", 1500);
        System.out.println(c5.resumo());    


        // classificar()
        System.out.println("Classificação de " + c1.nome() + ": " + c1.classificar());

        // isPositiva()
        System.out.println("A campanha " + c2.nome() + " é positiva? " + c2.isPositiva());

        // calcularRoi()
        System.out.println("ROI da " + c3.nome() + ": " + c3.calcularRoi() + "%");
    }
}

record Campanha (String nome, String plataforma, double orcamento, double receita) {
    public Campanha {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser null ou blank");
        }
        if (orcamento < 0) {
            throw new IllegalArgumentException("Orçamento não pode ser negativo");
        }
        if (receita < 0) {
            throw new IllegalArgumentException("Receita não pode ser negativa");
        }
        nome = nome.trim();
        plataforma = plataforma.toUpperCase();
    }

    public static Campanha criar(String nome, String plataforma, double orcamento) {
        return new Campanha(nome, plataforma, orcamento, 0.0);
    }

    public double calcularRoi() {
        if (orcamento == 0) {
            return 0; // Evita divisão por zero
        }
        return ((receita - orcamento) / orcamento) * 100;
    }

    public boolean isPositiva() {
        return calcularRoi() > 0;
    }

    public String classificar() {
        double roi = calcularRoi();
        if (roi < 0) {
            return "Crítica";
        } else if (roi <= 30) {
            return "Regular";
        } else if (roi <= 70) {
            return "Boa";
        } else {
            return "Excelente";
        }
    }

    public String resumo() {
        return String.format("Campanha: %s | Plataforma: %s | Orçamento: %.2f | Receita: %.2f | ROI: %.2f%% | Classificação: %s",
                nome, plataforma, orcamento, receita, calcularRoi(), classificar());
    }
}
