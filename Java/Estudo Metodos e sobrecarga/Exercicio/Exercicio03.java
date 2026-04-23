// ## Exercício 3 — Sobrecarga

// Crie um método sobrecarregado `calcularDesconto` com as seguintes versões:

// 1. `calcularDesconto(double preco)` → aplica desconto fixo de 10%
// 2. `calcularDesconto(double preco, double percentual)` → aplica percentual informado
// 3. `calcularDesconto(double preco, double percentual, String cupom)` → se o cupom for `"CERNE20"`, aplica mais 20% em cima do desconto já aplicado

// Teste as três versões no `main` e imprima os resultados com `printf`.

public class Exercicio03 {
    
    public static void main(String[] args) {

        double preco1 = 100.0;
        double preco2 = 200.0;
        double preco3 = 300.0;

        double desconto1 = calcularDesconto(preco1);
        double desconto2 = calcularDesconto(preco2, 15.0);
        double desconto3 = calcularDesconto(preco3, 10.0, "CERNE20");

        System.out.printf("Preço original: %.2f, Preço com desconto fixo: %.2f%n", preco1, desconto1);
        System.out.printf("Preço original: %.2f, Preço com desconto percentual: %.2f%n", preco2, desconto2);
        System.out.printf("Preço original: %.2f, Preço com desconto percentual e cupom: %.2f%n", preco3, desconto3);
    }

    // Versão 1: Desconto fixo de 10%
    public static double calcularDesconto(double preco) {
        return preco * 0.90; 
    }

    // Versão 2: Desconto percentual informado
    public static double calcularDesconto(double preco, double percentual) {
        return preco * (1 - percentual / 100); // explicando a linha: o percentual é dividido por 100 para converter de porcentagem para decimal, e subtraído de 1 para calcular a fração do preço que será cobrada após o desconto. Por exemplo, se o percentual for 15, a expressão se torna 1 - 0.15 = 0.85, o que significa que o cliente pagará 85% do preço original.
    }

    // Versão 3: Desconto percentual e cupom
    public static double calcularDesconto(double preco, double percentual, String cupom) {
        double precoComDesconto = calcularDesconto(preco, percentual); // Aplica o percentual primeiro
        if (cupom.equals("CERNE20")) {
            return precoComDesconto * 0.80; // Aplica mais 20% de desconto
        }
        return precoComDesconto; // Retorna o preço com o percentual aplicado se o cupom não for válido
    }

}
