// ## Exercício 5 — StringBuilder

// Crie um gerador de relatório usando `StringBuilder`:

// 1. Receba um array de produtos e preços:

// ```java
// String[] produtos = {"Plano Starter", "Plano Pro", "Plano Enterprise"};
// double[] precos = {49.90, 149.90, 499.90};
// ```

// 1. Monte um relatório formatado assim:

// ```
// ===== Relatório de Planos =====
// 1. Plano Starter       R$ 49,90
// 2. Plano Pro           R$ 149,90
// 3. Plano Enterprise    R$ 499,90
// ================================
// Total: R$ 699,70
// ```

// 1. Use `StringBuilder` para montar a String e `printf` para imprimir no final

// import java.lang.StringBuilder;

public class Exercicio05 {
    public static void main(String[] args) {
        String[] produtos = {"Plano Starter", "Plano Pro", "Plano Enterprise"};
        double[] precos = {49.90, 149.90, 499.90};

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("===== Relatório de Planos =====\n");

        double total = 0;
        for (int i = 0; i < produtos.length; i++) {
            relatorio.append(String.format("%d. %-20s R$ %.2f\n", i + 1, produtos[i], precos[i]));
            total += precos[i];
        }

        relatorio.append("===============================\n");
        relatorio.append(String.format("Total: R$ %.2f", total));

        System.out.println(relatorio.toString());
    }
}
