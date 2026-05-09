// ## Exercício 2 — Sealed interface + records

// Crie a sealed interface `ResultadoOperacao` com os records internos:

// ```java
// sealed interface ResultadoOperacao
//     permits ResultadoOperacao.Sucesso,
//             ResultadoOperacao.Falha,
//             ResultadoOperacao.Pendente { }
// ```

// - `Sucesso` → `mensagem`, `dados` (String)
// - `Falha` → `mensagem`, `codigo` (int), `detalhe`
// - `Pendente` → `mensagem`, `estimativaSecs` (int)

// Crie um método `processar(ResultadoOperacao r)` que usa switch exaustivo e retorna uma String formatada diferente para cada caso.

// No `main`, crie um de cada e processe todos — mostre que não precisa de `default`.

public class Exercicio02 {
    public static void main(String[] args) {
        ResultadoOperacao r1 = new ResultadoOperacao.Sucesso("Operação concluída", "Dados importantes");
        ResultadoOperacao r2 = new ResultadoOperacao.Falha("Erro ao processar", 404, "Recurso não encontrado");
        ResultadoOperacao r3 = new ResultadoOperacao.Pendente("Processamento em andamento", 120);

        System.out.println(processar(r1));
        System.out.println(processar(r2));
        System.out.println(processar(r3));
    }

    public static String processar(ResultadoOperacao r) {
        return switch (r) {
            case ResultadoOperacao.Sucesso s -> "Sucesso: " + s.mensagem() + " - " + s.dados();
            case ResultadoOperacao.Falha f -> "Falha: " + f.mensagem() + " (Código: " + f.codigo() + ") - " + f.detalhe();
            case ResultadoOperacao.Pendente p -> "Pendente: " + p.mensagem() + " (Estimativa: " + p.estimativaSecs() + " segundos)";
        };
    }
}

sealed interface ResultadoOperacao permits ResultadoOperacao.Sucesso, ResultadoOperacao.Falha, ResultadoOperacao.Pendente {
    record Sucesso(String mensagem, String dados) implements ResultadoOperacao { }
    record Falha(String mensagem, int codigo, String detalhe) implements ResultadoOperacao { }
    record Pendente(String mensagem, int estimativaSecs) implements ResultadoOperacao { }
}

