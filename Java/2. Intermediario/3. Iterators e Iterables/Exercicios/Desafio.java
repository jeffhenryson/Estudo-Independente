// ## Exercício 6 — Desafio

// Construa um sistema de pipeline de processamento de campanhas do **Cerne** usando `Iterable` customizado:

// **Classe `Campanha`:**

// - Atributos: `nome`, `plataforma`, `orcamento`, `status` (`"pendente"`, `"aprovada"`, `"rejeitada"`)
// - Construtor + getters + toString

// **Classe `PipelineAprovacao` implements `Iterable<Campanha>`:**

// - Armazena campanhas em `List<Campanha>` internamente
// - Método `submeter(Campanha c)` → adiciona com status `"pendente"`
// - Método `total()`, `totalPorStatus(String status)`
// - Implementa `Iterable<Campanha>` — itera só sobre as `"pendente"`

// **Classe `ProcessadorCampanhas`:**

// - Método estático `processar(PipelineAprovacao pipeline)`:
//     - Usa `Iterator` explícito obtido do pipeline
//     - Para cada campanha pendente:
//         - Orçamento >= 1000 → aprova (`status = "aprovada"`)
//         - Orçamento < 1000 → rejeita (`status = "rejeitada"`)
//     - Usa `it.remove()` para remover da fila de pendentes após processar

// No `main`:

// 1. Crie 5 campanhas com orçamentos variados e submeta
// 2. Imprima estatísticas antes de processar
// 3. Chame `ProcessadorCampanhas.processar(pipeline)`
// 4. Imprima estatísticas depois
// 5. Confirme que não há mais pendentes iterando o pipeline

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Desafio {
    public static void main(String[] args) {

        PipelineAprovacao pipeline = new PipelineAprovacao();

        pipeline.submeter(new Campanha("Campanha A", "Google Ads", 1500));
        pipeline.submeter(new Campanha("Campanha B", "Facebook Ads", 800));
        pipeline.submeter(new Campanha("Campanha C", "Instagram Ads", 1200));
        pipeline.submeter(new Campanha("Campanha D", "LinkedIn Ads", 500));
        pipeline.submeter(new Campanha("Campanha E", "Twitter Ads", 2000));

        System.out.println("Antes de processar:");
        System.out.println("Total de campanhas: " + pipeline.total());
        System.out.println("Pendentes: " + pipeline.totalPorStatus("pendente"));
        System.out.println("Aprovadas: " + pipeline.totalPorStatus("aprovada"));
        System.out.println("Rejeitadas: " + pipeline.totalPorStatus("rejeitada"));

        ProcessadorCampanhas.processar(pipeline);

        System.out.println("\nDepois de processar:");
        System.out.println("Total de campanhas: " + pipeline.total());
        System.out.println("Pendentes: " + pipeline.totalPorStatus("pendente"));
        System.out.println("Aprovadas: " + pipeline.totalPorStatus("aprovada"));
        System.out.println("Rejeitadas: " + pipeline.totalPorStatus("rejeitada"));
    }
}

class Campanha {

    private String nome;
    private String plataforma;
    private double orcamento;
    private String status;

    public Campanha(String nome, String plataforma, double orcamento) {
        this.nome = nome;
        this.plataforma = plataforma;
        this.orcamento = orcamento;
        this.status = "pendente";
    }

    public String getNome() {
        return nome;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Campanha{" +
                "nome='" + nome + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", orcamento=" + orcamento +
                ", status='" + status + '\'' +
                '}';
    }
}

class PipelineAprovacao implements Iterable<Campanha> {

    private List<Campanha> campanhas;

    public PipelineAprovacao() {
        this.campanhas = new ArrayList<>();
    }

    public void submeter(Campanha c) {
        campanhas.add(c);
    }

    public int total() {
        return campanhas.size();
    }

    public int totalPorStatus(String status) {
        int count = 0;
        for (Campanha c : campanhas) {
            if (c.getStatus().equals(status)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Iterator<Campanha> iterator() {
        return new Iterator<Campanha>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                while (index < campanhas.size()) {
                    if (campanhas.get(index).getStatus().equals("pendente")) {
                        return true;
                    }
                    index++;
                }
                return false;
            }

            @Override
            public Campanha next() {
                return campanhas.get(index++);
            }

            @Override
            public void remove() {
                if (index > 0) {
                    campanhas.remove(index - 1);
                    index--;
                }
            }
        };
    }
}

class ProcessadorCampanhas {
    public static void processar(PipelineAprovacao pipeline) {
        Iterator<Campanha> it = pipeline.iterator();
        while (it.hasNext()) {
            Campanha c = it.next();
            if (c.getOrcamento() >= 1000) {
                c.setStatus("aprovada");
            } else {
                c.setStatus("rejeitada");
            }
            it.remove();
        }
    }
}