
// ## 1. Contagem Regressiva com `while`

// **Enunciado:** Escreva um programa em Java que utilize um loop `while` para fazer uma contagem regressiva de 10 até 1. Imprima cada número no console e, ao final do loop, imprima a mensagem `"Fim da contagem!"`.

public class Exercicio01 {
    public static void main(String[] args) {
        int contador = 10;

        while (contador >= 1) {
            System.out.println(contador);
            contador--;
        }

        System.out.println("Fim da contagem!");
    }
}
