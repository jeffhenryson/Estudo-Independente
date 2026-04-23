// ## Exercício 3 — Escopo

// Aponte os erros de escopo no código abaixo e corrija:

// public class Main {
//     public static void main(String[] args) {
//         int x = 10;
//         if (x > 5) {
//             int resultado = x * 2;
//         }
//         System.out.println(resultado);
//         for (int i = 0; i < 3; i++) {
//             int mensagem = "repetindo";
//         }
//         System.out.println(i);
//         System.out.println(mensagem);
//     }
// }

public class Exercicio03 {
        public static void main(String[] args) {
        int x = 10;
        if (x > 5) {
            int resultado = x * 2;
            System.out.println(resultado);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            String mensagem = "incrementando..";
            System.out.println(mensagem); 
        }
    }
}
