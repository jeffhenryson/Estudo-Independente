// ## Exercício 2 — Construtor compacto com validação

// Crie o record `Campanha` com `nome`, `plataforma`, `orcamento` e `receita`:

// 1. No construtor compacto valide:
//     - `nome` não pode ser null ou blank → `IllegalArgumentException`
//     - `orcamento` não pode ser negativo → `IllegalArgumentException`
//     - `receita` não pode ser negativa → `IllegalArgumentException`
//     - Normalize: `nome` com `.trim()`, `plataforma` com `.toUpperCase()`
// 2. No `main` teste:
//     - Instância válida
//     - Nome vazio → exceção
//     - Orçamento negativo → exceção
//     - Verifique a normalização

public class Exercicio02 {
    public static void main(String[] args) {

        // Instância válida
        Campanha campanhaValida = new Campanha("  Black Friday  ", "facebook", 10000, 15000);
        System.out.println(campanhaValida);

        try {
            Campanha campanhaNomeVazio = new Campanha("   ", "google", 5000, 7000);
            System.out.println(campanhaNomeVazio);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Campanha campanhaOrcamentoNegativo = new Campanha("Campanha 1", "google", -1000, 7000);
            System.out.println(campanhaOrcamentoNegativo);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Campanha campanhaReceitaNegativa = new Campanha("Campanha 2", "google", 5000, -7000);
            System.out.println(campanhaReceitaNegativa);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Verificando a normalização
        Campanha campanhaNormalizada = new Campanha("  Natal  ", "instagram", 8000, 12000);
        System.out.println(campanhaNormalizada);
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
}