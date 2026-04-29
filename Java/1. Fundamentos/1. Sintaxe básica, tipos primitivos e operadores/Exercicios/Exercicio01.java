// ## Exercício 1 — Tipos e declarações

// Declare as seguintes variáveis com os tipos mais adequados em Java:

// - Seu nome: Str (String)
// - Sua idade: int (Inteiro)
// - Sua altura em metros: double
// - Se você é desenvolvedor ou não: Boolean
// - A inicial do seu primeiro nome: Char
// - O número de habitantes do Brasil (estimativa: 215 milhões): Float

// Depois imprima todas elas com `System.out.println`.

public class Exercicio01 {
    public static void main(String[] args) {
        String nome = "Jeff";
        int idade = 28;
        double altura = 1.75;
        boolean isDeveloper = true;
        char firstLetter = 'J';
        long population = 215_000_000L;

        system.out.println("Nome: " + nome);
        system.out.println("Idade: " + idade);
        system.out.println("Altura: " + altura);
        system.out.println("É desenvolvedor? " + isDeveloper);
        system.out.println("Primeira letra do nome: " + firstLetter);
        system.out.println("População do Brasil: " + population);
    }
}