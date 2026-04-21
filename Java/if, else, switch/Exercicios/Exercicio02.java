// ## Exercício 2 — Comparação de Strings

// Corrija o código abaixo e explique o que estava errado:

// public class Main {
//     public static void main(String[] args) {
//         String plano = new String("pro");

//         if (plano == "pro") {
//             System.out.println("Plano Pro ativo");
//         } else {
//             System.out.println("Plano não reconhecido");
//         }
//     }
// }

public class Exercicio02 {
    public static void main(String[] args) {
        String plano = new String("pro");

        if (plano.equals("pro")) {
            System.out.println("Plano Pro ativo");
        } else {
            System.out.println("Plano não reconhecido");
        }
    }
}