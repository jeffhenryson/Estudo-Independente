// public ## Exercício 6 — Desafio

// Crie um sistema de cálculo de planos do **Cerne** com os seguintes métodos:

// 1. `calcularMensalidade(String plano)` → retorna o valor base usando switch:
//     - `"starter"` → 49.90
//     - `"pro"` → 149.90
//     - `"enterprise"` → 499.90
//     - qualquer outro → 0.0
// 2. `calcularMensalidade(String plano, int meses)` → retorna o total para N meses (sobrecarga)
// 3. `calcularMensalidade(String plano, int meses, String cupom)` → aplica 15% de desconto se cupom for `"CERNE15"` (sobrecarga)
// 4. `resumoContrato(String empresa, String plano, int meses, String cupom)` → usa os métodos acima e imprime:

// ```
// ===== Contrato Cerne =====
// Empresa: Cerne Analytics
// Plano: pro
// Duração: 12 meses
// Mensalidade: R$ 149,90
// Total sem desconto: R$ 1.798,80
// Cupom aplicado: CERNE15
// Total com desconto: R$ 1.529,00 (aproximado)
// ==========================
// ```

// 1. No `main`, use `Scanner` para ler os dados e chame `resumoContrato` {
    
// }

import java.util.Scanner;

public class Exercicio06 {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Exercicio06 exercicio = new Exercicio06();

        System.out.print("Digite o nome da empresa: ");
        String empresa = exercicio.scanner.nextLine();

        System.out.print("Digite o plano (starter/pro/enterprise): ");
        String plano = exercicio.scanner.nextLine();

        System.out.print("Digite a duração em meses: ");
        int meses = exercicio.scanner.nextInt();
        exercicio.scanner.nextLine();

        System.out.print("Digite o cupom (ou deixe vazio): ");
        String cupom = exercicio.scanner.nextLine();

        exercicio.resumoContrato(empresa, plano, meses, cupom);
    }

    // Método para calcular a mensalidade com base no plano
    public double calcularMensalidade(String plano) {
        switch (plano.toLowerCase()) {
            case "starter":
                return 49.90;
            case "pro":
                return 149.90;
            case "enterprise":
                return 499.90;
            default:
                return 0.0;
        }
    }

    // Sobrecarga para calcular o total para N meses
    public double calcularMensalidade(String plano, int meses) {
        return calcularMensalidade(plano) * meses;
    }

    // Sobrecarga para aplicar desconto com cupom
    public double calcularMensalidade(String plano, int meses, String cupom) {
        double total = calcularMensalidade(plano, meses);
        if ("CERNE15".equalsIgnoreCase(cupom)) {
            total *= 0.85; // Aplica 15% de desconto
        }
        return total;
    }

    // Método para imprimir o resumo do contrato
    public void resumoContrato(String empresa, String plano, int meses, String cupom) {
        
        double mensalidade = calcularMensalidade(plano);
        double totalSemDesconto = calcularMensalidade(plano, meses);
        double totalComDesconto = calcularMensalidade(plano, meses, cupom);

        System.out.println("===== Contrato Cerne =====");
        System.out.println("Empresa: " + empresa);
        System.out.println("Plano: " + plano);
        System.out.println("Duração: " + meses + " meses");
        System.out.printf("Mensalidade: R$ %.2f%n", mensalidade);
        System.out.printf("Total sem desconto: R$ %.2f%n", totalSemDesconto);
        System.out.println("Cupom aplicado: " + cupom);
        System.out.printf("Total com desconto: R$ %.2f%n", totalComDesconto);
        System.out.println("==========================");
    }

}