// Exercícios — Métodos e Sobrecarga

// Exercício 1 — Métodos básicos
// Crie os seguintes métodos e teste todos no main:

// saudar(String nome) → imprime "Olá, [nome]!"
// ehMaiorDeIdade(int idade) → retorna boolean
// calcularAreaRetangulo(double largura, double altura) → retorna double
// repetirTexto(String texto, int vezes) → retorna a String repetida

// ex: repetirTexto("Java", 3) → "JavaJavaJava"

public class Exercicio01 {

    public static void main(String[] args) {

        // Testando o método saudar
        saudar("Alice");
        int idade = 20;
        System.out.println("É maior de idade? " + ehMaiorDeIdade(idade));

        // Testando o método calcularAreaRetangulo
        double area = calcularAreaRetangulo(5.0, 3.0);
        System.out.println("Área do retângulo: " + area);

        // Testando o método repetirTexto
        String textoRepetido = repetirTexto("Java", 3);
        System.out.println("Texto repetido: " + textoRepetido);

    }

    public static void saudar(String nome) {
        System.out.println("Olá, " + nome + "!");
    }

    public static boolean ehMaiorDeIdade(int idade) {
        return idade >= 18;
    }

    public static double calcularAreaRetangulo(double largura, double altura) {
        return largura * altura;
    }

    public static String repetirTexto(String texto, int vezes) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < vezes; i++) {
            resultado.append(texto);
        }
        return resultado.toString();
    }
}
