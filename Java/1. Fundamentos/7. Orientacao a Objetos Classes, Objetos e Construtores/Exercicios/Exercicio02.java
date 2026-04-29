// ## Exercício 2 — Sobrecarga de construtores

// Crie uma classe `Campanha` (contexto de marketing digital) com:

// - Atributos: `nome`, `orcamento`, `plataforma`, `ativa`
// - 3 construtores sobrecarregados:
//     1. Completo: todos os atributos
//     2. Sem `plataforma` → padrão `"Meta Ads"`
//     3. Só `nome` → plataforma `"Meta Ads"`, orcamento `0.0`, ativa `false`
// - Cada construtor deve chamar o anterior com `this(...)`
// - Método `toString()` com todos os atributos

// Crie uma instância de cada construtor no `main` e imprima.

public class Exercicio02 {
    public static void main(String[] args) {
        Campanha campanhaCompleta = new Campanha("Lançamento Produto", 5000.0, "Google Ads", true);
        Campanha campanhaSemPlataforma = new Campanha("Promoção Verão", 3000.0, true);
        Campanha campanhaSoNome = new Campanha("Campanha Teste");

        System.out.println(campanhaCompleta);
        System.out.println(campanhaSemPlataforma);
        System.out.println(campanhaSoNome);
    }
}

class Campanha{

    String nome;
    double orcamento;
    String plataforma;
    boolean ativa;

    // Construtor completo
    public Campanha(String nome, double orcamento, String plataforma, boolean ativa) {
        this.nome = nome;
        this.orcamento = orcamento;
        this.plataforma = plataforma;
        this.ativa = ativa;
    }

    // Construtor sem plataforma
    public Campanha(String nome, double orcamento, boolean ativa) {
        this(nome, orcamento, "Meta Ads", ativa);
    }

    // Construtor só com nome
    public Campanha(String nome) {
        this(nome, 0.0, "Meta Ads", false);
    }

    // Método toString
    @Override
    public String toString() {
        return "Campanha{" +
                "nome='" + nome + '\'' +
                ", orcamento=" + orcamento +
                ", plataforma='" + plataforma + '\'' +
                ", ativa=" + ativa +
                '}';
    }
}
