// ## Exercício 4 — Switch exaustivo

// Dado o sealed abaixo, implemente os métodos usando switch **sem `default`**:

// ```java
// sealed interface StatusPagamento
//     permits StatusPagamento.Aprovado,
//             StatusPagamento.Reprovado,
//             StatusPagamento.Cancelado,
//             StatusPagamento.Estornado {

//     record Aprovado(String transacaoId, double valor) implements StatusPagamento {}
//     record Reprovado(String motivo, int tentativas) implements StatusPagamento {}
//     record Cancelado(String motivo) implements StatusPagamento {}
//     record Estornado(String transacaoId, double valor, String motivo) implements StatusPagamento {}
// }
// ```

// Implemente:

// 1. `String descricao(StatusPagamento s)` → mensagem humana para cada status
// 2. `boolean requerAcao(StatusPagamento s)` → true se precisa de intervenção
// 3. `double valorEnvolvido(StatusPagamento s)` → valor ou 0.0 se não aplicável
// 4. Demonstre que adicionar um novo tipo ao `permits` quebraria os switches — comente

public class Exercicio04 {
    
    sealed interface StatusPagamento
        permits StatusPagamento.Aprovado,
        StatusPagamento.Reprovado,
        StatusPagamento.Cancelado,
        StatusPagamento.Estornado {

    record Aprovado(String transacaoId, double valor) implements StatusPagamento {
    }

    record Reprovado(String motivo, int tentativas) implements StatusPagamento {
    }

    record Cancelado(String motivo) implements StatusPagamento {
    }

    record Estornado(String transacaoId, double valor, String motivo) implements StatusPagamento {
    }
}
    public static void main(String[] args) {

        StatusPagamento aprovado = new StatusPagamento.Aprovado("12345", 250.75);
        StatusPagamento reprovado = new StatusPagamento.Reprovado("Cartão recusado", 3);
        StatusPagamento cancelado = new StatusPagamento.Cancelado("Pedido do cliente");
        StatusPagamento estornado = new StatusPagamento.Estornado("67890", 150.50, "Produto com defeito");

        System.out.println("Descrição:");
        System.out.println(descricao(aprovado));
        System.out.println(descricao(reprovado));
        System.out.println(descricao(cancelado));
        System.out.println(descricao(estornado));

        System.out.println("\nRequer ação:");
        System.out.println("Aprovado: " + requerAcao(aprovado));
        System.out.println("Reprovado: " + requerAcao(reprovado));
        System.out.println("Cancelado: " + requerAcao(cancelado));
        System.out.println("Estornado: " + requerAcao(estornado));

        System.out.println("\nValor envolvido:");
        System.out.println("Aprovado: " + valorEnvolvido(aprovado));
        System.out.println("Reprovado: " + valorEnvolvido(reprovado));
        System.out.println("Cancelado: " + valorEnvolvido(cancelado));
        System.out.println("Estornado: " + valorEnvolvido(estornado));
    }

    public static String descricao(StatusPagamento s) {
        return switch (s) {
            case StatusPagamento.Aprovado a ->
                "Pagamento aprovado: Transação " + a.transacaoId() + ", Valor: " + a.valor();
            case StatusPagamento.Reprovado r ->
                "Pagamento reprovado: Motivo " + r.motivo() + ", Tentativas: " + r.tentativas();
            case StatusPagamento.Cancelado c -> "Pagamento cancelado: Motivo " + c.motivo();
            case StatusPagamento.Estornado e -> "Pagamento estornado: Transação " + e.transacaoId() + ", Valor: "
                    + e.valor() + ", Motivo: " + e.motivo();
        };
    }

    public static boolean requerAcao(StatusPagamento s) {
        return switch (s) {
            case StatusPagamento.Aprovado a -> false;
            case StatusPagamento.Reprovado r -> true;
            case StatusPagamento.Cancelado c -> false;
            case StatusPagamento.Estornado e -> true;
        };
    }

    public static double valorEnvolvido(StatusPagamento s) {
        return switch (s) {
            case StatusPagamento.Aprovado a -> a.valor();
            case StatusPagamento.Reprovado r -> 0.0;
            case StatusPagamento.Cancelado c -> 0.0;
            case StatusPagamento.Estornado e -> e.valor();
        };
    }
}


