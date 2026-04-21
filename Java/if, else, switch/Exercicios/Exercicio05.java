// ## Exercício 5 — switch com String

// Você está construindo o sistema de planos do **Cerne**. Dado um `String plano` com os valores possíveis `"starter"`, `"pro"` e `"enterprise"`, imprima usando switch moderno:

// - O limite de usuários
// - O limite de campanhas
// - Se tem suporte prioritário ou não

public class Exercicio05 {
    public static void main(String[] args) {
        String plano = "pro";

        switch (plano) {
            case "starter" -> {
                System.out.println("Limite de usuários: 3");
                System.out.println("Limite de campanhas: 5");
                System.out.println("Suporte prioritário: Não");
            }
            case "pro" -> {
                System.out.println("Limite de usuários: 10");
                System.out.println("Limite de campanhas: 20");
                System.out.println("Suporte prioritário: Sim");
            }
            case "enterprise" -> {
                System.out.println("Limite de usuários: Ilimitado");
                System.out.println("Limite de campanhas: Ilimitado");
                System.out.println("Suporte prioritário: Sim");
            }
            default -> System.out.println("Plano inválido");
        }
    }
}
