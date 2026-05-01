// ## Exercício 3 — Criando classe Iterable

// Crie uma classe `PipelineCampanhas` que:

// - Internamente armazena campanhas em um `array` de `String` com capacidade fixa
// - Tem método `adicionar(String campanha)`
// - Tem método `tamanho()`
// - Implementa `Iterable<String>` — o `for-each` deve funcionar nela
// - O `Iterator` interno deve respeitar o tamanho real (não a capacidade do array)

// No `main`:

// ```java
// PipelineCampanhas pipeline = new PipelineCampanhas(10);
// pipeline.adicionar("Black Friday");
// pipeline.adicionar("Verão");
// pipeline.adicionar("Remarketing");

// for (String c : pipeline) {
//     System.out.println(c);
// }
// ```

public class Exercicio03 {
    public static void main(String[] args) {
        PipelineCampanhas pipeline = new PipelineCampanhas(10);
        pipeline.adicionar("Black Friday");
        pipeline.adicionar("Verão");
        pipeline.adicionar("Remarketing");

        for (String c : pipeline) {
            System.out.println(c);
        }
    }
}

class PipelineCampanhas implements Iterable<String> {

    private String[] campanhas;
    private int tamanho;

    public PipelineCampanhas(int capacidade) {
        this.campanhas = new String[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(String campanha) {
        if (tamanho < campanhas.length) {
            campanhas[tamanho] = campanha;
            tamanho++;
        } else {
            System.out.println("Capacidade máxima atingida. Não é possível adicionar mais campanhas.");
        }
    }

    public int tamanho() {
        return tamanho;
    }

    @Override
    public java.util.Iterator<String> iterator() {
        return new java.util.Iterator<String>() {
            private int index = 0;

            // O método hasNext() verifica se ainda há elementos para iterar, comparando o 
            // índice atual com o tamanho real da lista de campanhas.
            @Override
            public boolean hasNext() {
                return index < tamanho;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                return campanhas[index++];
            }
        };
    }
}