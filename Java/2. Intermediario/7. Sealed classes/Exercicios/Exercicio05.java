// ## Exercício 5 — Hierarquia em camadas

// Construa o sistema de eventos do **Cerne**:

// ```java
// sealed interface Evento
//     permits EventoCampanha, EventoUsuario { }

// sealed interface EventoCampanha extends Evento
//     permits EventoCampanha.Criada,
//             EventoCampanha.Ativada,
//             EventoCampanha.Pausada,
//             EventoCampanha.Encerrada { }

// sealed interface EventoUsuario extends Evento
//     permits EventoUsuario.Login,
//             EventoUsuario.Logout,
//             EventoUsuario.AcessoNegado { }
// ```

// 1. Implemente todos os records internos com atributos relevantes
// 2. Crie um método `String log(Evento e)` com switch exaustivo em dois níveis
// 3. Crie um método `boolean ehCritico(Evento e)` — críticos: `AcessoNegado`, `Encerrada` com ROI < 0
// 4. No `main`, crie uma lista `List<Evento>`, popule com vários tipos e processe todos

import java.util.List;

public class Exercicio05 {

    sealed interface Evento permits EventoCampanha, EventoUsuario {}

    sealed interface EventoCampanha extends Evento
        permits EventoCampanha.Criada, EventoCampanha.Ativada, EventoCampanha.Pausada, EventoCampanha.Encerrada {

        record Criada(String nome, double orcamento) implements EventoCampanha {}
        record Ativada(String nome, double roi) implements EventoCampanha {}
        record Pausada(String nome, String motivo) implements EventoCampanha {}
        record Encerrada(String nome, double roi) implements EventoCampanha {}
    }

    sealed interface EventoUsuario extends Evento
        permits EventoUsuario.Login, EventoUsuario.Logout, EventoUsuario.AcessoNegado {

        record Login(String usuario) implements EventoUsuario {}
        record Logout(String usuario) implements EventoUsuario {}
        record AcessoNegado(String usuario, String motivo) implements EventoUsuario {}
    }

    public static String log(Evento e) {
        return switch (e) {
            case EventoCampanha c -> switch (c) {
                case EventoCampanha.Criada criada -> "Campanha criada: " + criada.nome() + ", Orçamento: " + criada.orcamento();
                case EventoCampanha.Ativada ativada -> "Campanha ativada: " + ativada.nome() + ", ROI: " + ativada.roi();
                case EventoCampanha.Pausada pausada -> "Campanha pausada: " + pausada.nome() + ", Motivo: " + pausada.motivo();
                case EventoCampanha.Encerrada encerrada -> "Campanha encerrada: " + encerrada.nome() + ", ROI: " + encerrada.roi();
            };
            case EventoUsuario u -> switch (u) {
                case EventoUsuario.Login login -> "Usuário logado: " + login.usuario();
                case EventoUsuario.Logout logout -> "Usuário deslogado: " + logout.usuario();
                case EventoUsuario.AcessoNegado acessoNegado -> "Acesso negado: " + acessoNegado.usuario() + ", Motivo: " + acessoNegado.motivo();
            };
        };
    }

    public static boolean ehCritico(Evento e) {
        return switch (e) {
            case EventoCampanha.Encerrada encerrada -> encerrada.roi() < 0;
            case EventoUsuario.AcessoNegado acessoNegado -> true;            default -> false;
        };
    }

    public static void main(String[] args) {

        List<Evento> eventos = List.of(
            new EventoCampanha.Criada("Campanha A", 10000),
            new EventoCampanha.Ativada("Campanha B", 1.5),
            new EventoCampanha.Pausada("Campanha C", "Revisão de orçamento"),
            new EventoCampanha.Encerrada("Campanha D", -0.5),
            new EventoUsuario.Login("usuario1"),
            new EventoUsuario.Logout("usuario2"),
            new EventoUsuario.AcessoNegado("usuario3", "Senha incorreta")
        );

        for (Evento evento : eventos) {
            System.out.println(log(evento));
            System.out.println("Crítico: " + ehCritico(evento));
        }
    }
}