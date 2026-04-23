// ## Exercício 2 — Constantes

// Crie um programa que defina as seguintes constantes e as use em um cálculo:

// - `PRECO_BASE` = 100.0
// - `DESCONTO` = 0.15 (15%)
// - `TAXA_SERVICO` = 0.10 (10%)

// Calcule e imprima o preço final aplicando desconto e depois taxa de serviço.

// Fórmula: `precoFinal = (PRECO_BASE - PRECO_BASE * DESCONTO) * (1 + TAXA_SERVICO)`

public class Exercicio02 {
        public static void main(String[] args) {
        final double PRECO_BASE = 100.0;
        final double DESCONTO = 0.15;
        final double TAXA_SERVICO = 0.10;

        double precoFinal = (PRECO_BASE - PRECO_BASE * DESCONTO) * (1 + TAXA_SERVICO);
        System.out.printf("Preço final: R$ %.2f%n", precoFinal);
    }
}
