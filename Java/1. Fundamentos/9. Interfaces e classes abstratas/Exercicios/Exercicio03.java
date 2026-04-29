// ## Exercício 3 — Múltiplas interfaces

// Crie as interfaces:

// ```java
// interface Ativavel {
//     void ativar();
//     void desativar();
//     boolean isAtivo();
// }

// interface Auditavel {
//     String getUltimaAlteracao();
//     void registrarAlteracao(String descricao);
// }
// ```

// Crie a classe `Campanha` que implementa ambas:

// - Atributos: `nome`, `plataforma`, `ativo`, `ultimaAlteracao`
// - Implemente todos os métodos das duas interfaces
// - `registrarAlteracao()` atualiza `ultimaAlteracao` com a descrição recebida

// No `main`:

// 1. Crie uma campanha, ative, registre alterações, desative
// 2. Imprima o status e a última alteração em cada etapa

public class Exercicio03 {
    public static void main(String[] args) {
        Campanha campanha = new Campanha("Promoção de Verão", "Instagram");

        System.out.println("Status inicial: " + (campanha.isAtivo() ? "Ativa" : "Inativa"));
        System.out.println("Última alteração: " + campanha.getUltimaAlteracao());

        campanha.ativar();
        System.out.println("\nApós ativar:");
        System.out.println("Status: " + (campanha.isAtivo() ? "Ativa" : "Inativa"));
        System.out.println("Última alteração: " + campanha.getUltimaAlteracao());

        campanha.registrarAlteracao("Ajuste na segmentação.");
        System.out.println("\nApós registrar ajuste:");
        System.out.println("Status: " + (campanha.isAtivo() ? "Ativa" : "Inativa"));
        System.out.println("Última alteração: " + campanha.getUltimaAlteracao());

        campanha.desativar();
        System.out.println("\nApós desativar:");
        System.out.println("Status: " + (campanha.isAtivo() ? "Ativa" : "Inativa"));
        System.out.println("Última alteração: " + campanha.getUltimaAlteracao());
    }
}

interface Ativavel {
    void ativar();
    void desativar();
    boolean isAtivo();
}

interface Auditavel {
    String getUltimaAlteracao();
    void registrarAlteracao(String descricao);
}

class Campanha implements Ativavel, Auditavel {
    private String nome;
    private String plataforma;
    private boolean ativo;
    private String ultimaAlteracao;

    public Campanha(String nome, String plataforma) {
        this.nome = nome;
        this.plataforma = plataforma;
        this.ativo = false;
        this.ultimaAlteracao = "Nenhuma alteração registrada.";
    }

    @Override
    public void ativar() {
        this.ativo = true;
        registrarAlteracao("Campanha ativada.");
    }

    @Override
    public void desativar() {
        this.ativo = false;
        registrarAlteracao("Campanha desativada.");
    }

    @Override
    public boolean isAtivo() {
        return this.ativo;
    }

    @Override
    public String getUltimaAlteracao() {
        return this.ultimaAlteracao;
    }

    @Override
    public void registrarAlteracao(String descricao) {
        this.ultimaAlteracao = descricao + " (Data: " + java.time.LocalDateTime.now() + ")";
    }
}