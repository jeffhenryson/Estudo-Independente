// ## 5. Exibição de Ímpares com `continue`

// **Enunciado:** Escreva um programa que utilize um loop `while` onde uma variável `contador` começa em 1 e vai até 20. Utilize a estrutura condicional dentro do loop com o comando `continue` para pular a impressão dos números que são pares, exibindo no console apenas os números ímpares.

public class Exercicio05 {
    public static void main(String[] args) {
        int contador = 1;
        while (contador <= 20) {
            if (contador % 2 == 0) {
                contador++;
                continue;
            }
            System.out.print(contador + " ");
            contador++;
        }
    }
}
