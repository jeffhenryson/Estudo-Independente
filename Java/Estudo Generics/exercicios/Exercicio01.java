// ## Exercício 1 — Classe genérica básica

// Crie uma classe `Caixa<T>` com:

// 1. Atributo privado `conteudo` do tipo `T`
// 2. Método `guardar(T item)` — armazena o conteúdo
// 3. Método `pegar()` — retorna o conteúdo
// 4. Método `estaVazia()` — retorna `true` se conteúdo for `null`
// 5. Método `toString()` — retorna `"Caixa[conteudo=X]"`

// No `main`, crie instâncias de `Caixa` com:
// - `String`
// - `Integer`
// - `Double`
// - Uma classe própria `Campanha` com `nome` e `plataforma`

public class Exercicio01 {
    public static void main(String[] args) {
        Caixa<String> caixaString = new Caixa<>();
        caixaString.guardar("Olá, Mundo!");
        System.out.println(caixaString);

        Caixa<Integer> caixaInteger = new Caixa<>();
        caixaInteger.guardar(42);
        System.out.println(caixaInteger);

        Caixa<Double> caixaDouble = new Caixa<>();
        caixaDouble.guardar(3.14);
        System.out.println(caixaDouble);

        Caixa<Campanha> caixaCampanha = new Caixa<>();
        Campanha campanha = new Campanha("Promoção de Verão", "Instagram");
        caixaCampanha.guardar(campanha);
        System.out.println(caixaCampanha);
    }
}

class Campanha {
    private String nome;
    private String plataforma;

    public Campanha(String nome, String plataforma) {
        this.nome = nome;
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return "Campanha[nome=" + nome + ", plataforma=" + plataforma + "]";
    }
}

class Caixa<T> {

    private T conteudo;

    public void guardar(T item) {
        this.conteudo = item;
    }

    public T pegar() {
        return this.conteudo;
    }

    public boolean estaVazia() {
        return this.conteudo == null;
    }

    @Override
    public String toString() {
        return "Caixa[conteudo=" + conteudo + "]";
    }
}
