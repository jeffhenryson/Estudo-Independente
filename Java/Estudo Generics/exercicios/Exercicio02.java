// ## Exercício 2 — Múltiplos parâmetros de tipo

// Crie uma classe `Resultado<T, E>` que representa o resultado de uma operação:

// - Atributos: `T valor` (resultado em caso de sucesso) e `E erro` (em caso de falha)
// - Construtor privado — crie dois factory methods estáticos:
//   - `sucesso(T valor)` → cria resultado com valor, erro null
//   - `falha(E erro)` → cria resultado com erro, valor null
// - Métodos: `isSucesso()`, `getValor()`, `getErro()`, `toString()`

// No `main`:
// ```java
// Resultado<String, String> r1 = Resultado.sucesso("Campanha criada com sucesso");
// Resultado<String, String> r2 = Resultado.falha("Orçamento insuficiente");

// Resultado<Double, String> r3 = Resultado.sucesso(149.90);
// Resultado<Double, String> r4 = Resultado.falha("Plano não encontrado");
// ```

public class Exercicio02 {
    public static void main(String[] args) {
        Resultado<String, String> r1 = Resultado.sucesso("Campanha criada com sucesso");
        Resultado<String, String> r2 = Resultado.falha("Orçamento insuficiente");
        Resultado<Double, String> r3 = Resultado.sucesso(149.90);
        Resultado<Double, String> r4 = Resultado.falha("Plano não encontrado");

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
    }
}

class Resultado<T, E> {

    private T valor;
    private E erro;

    private Resultado(T valor, E erro) {
        this.valor = valor;
        this.erro = erro;
    }

    // Factory methods
    public static <T, E> Resultado<T, E> sucesso(T valor) {
        return new Resultado<>(valor, null);
    }

    public static <T, E> Resultado<T, E> falha(E erro) {
        return new Resultado<>(null, erro);
    }

    public boolean isSucesso() {
        return valor != null;
    }

    public T getValor() {
        return valor;
    }

    public E getErro() {
        return erro;
    }

    @Override
    public String toString() {
        if (isSucesso()) {
            return "Sucesso: " + valor;
        } else {
            return "Falha: " + erro;
        }
    }
}