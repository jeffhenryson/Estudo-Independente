## 1. O que é e por que existe

Sealed class permite **controlar quais classes podem herdar** de uma classe ou interface. Antes, qualquer classe podia herdar de qualquer outra:

```java
// antes — qualquer um pode estender
public abstract class Campanha { }

public class CampanhaMetaAds extends Campanha { }      // ✅
public class CampanhaGoogleAds extends Campanha { }    // ✅
public class CampanhaAleatoria extends Campanha { }    // ✅ — mas não deveria
public class QualquerCoisa extends Campanha { }        // ✅ — problema
```

Com sealed, você define exatamente quem pode herdar:

```java
public sealed class Campanha
    permits CampanhaMetaAds, CampanhaGoogleAds, CampanhaTikTokAds { }

public class CampanhaAleatoria extends Campanha { } // ❌ erro de compilação
```

---

## 2. Modificadores das subclasses

Cada classe que aparece no `permits` deve declarar um dos três modificadores:

```java
public sealed class Campanha permits CampanhaMetaAds, CampanhaGoogleAds, CampanhaTikTokAds {
    protected String nome;
    protected double orcamento;
}

// final — não pode ser mais estendida
public final class CampanhaMetaAds extends Campanha {
    private String publicoAlvo;
}

// sealed — pode ser estendida mas controla quem 
public sealed class CampanhaGoogleAds extends Campanha
    permits GoogleSearch, GoogleDisplay, GoogleShopping {
    private String[] palavrasChave;
}

// non-sealed — abre a hierarquia novamente (qualquer um pode estender)
public non-sealed class CampanhaTikTokAds extends Campanha {
    private String formatoVideo;
}
```

---

## 3. Sealed interfaces

Funciona igualmente com interfaces:

```java
public sealed interface Notificacao
    permits NotificacaoEmail, NotificacaoSms, NotificacaoPush {
    String getMensagem();
    String getDestinatario();
}

public record NotificacaoEmail(String mensagem, String email) implements Notificacao {
    @Override public String getMensagem() { return mensagem; }
    @Override public String getDestinatario() { return email; }
}

public record NotificacaoSms(String mensagem, String telefone) implements Notificacao {
    @Override public String getMensagem() { return mensagem; }
    @Override public String getDestinatario() { return telefone; }
}

public record NotificacaoPush(String mensagem, String dispositivo) implements Notificacao {
    @Override public String getMensagem() { return mensagem; }
    @Override public String getDestinatario() { return dispositivo; }
}
```

---

## 4. O poder real — switch com pattern matching (Java 21)

O maior benefício de sealed classes é que o compilador **sabe todos os subtipos possíveis** — o switch fica exaustivo sem `default`:

```java
// sem sealed — precisa de default, compilador não sabe todos os tipos
public String processar(Notificacao n) {
    return switch (n) {
        case NotificacaoEmail e -> "Enviando email para " + e.email();
        case NotificacaoSms s   -> "Enviando SMS para " + s.telefone();
        case NotificacaoPush p  -> "Push para dispositivo " + p.dispositivo();
        // sem default — compilador garante que todos os casos estão cobertos
    };
}
```

Se você adicionar um novo tipo ao `permits` e esquecer de cobrir no switch:

```java
public sealed interface Notificacao
    permits NotificacaoEmail, NotificacaoSms, NotificacaoPush, NotificacaoWhatsApp { }

// ❌ erro de compilação — NotificacaoWhatsApp não coberto no switch
// compilador avisa antes de rodar
```

---

## 5. Combinando sealed class com record

Pattern muito comum — sealed interface + records para modelar domínio:

```java
public sealed interface ResultadoCampanha
    permits ResultadoCampanha.Sucesso, ResultadoCampanha.Falha, ResultadoCampanha.Pendente {

    record Sucesso(String campanha, double roi, double receita) implements ResultadoCampanha {}
    record Falha(String campanha, String motivo, int codigo) implements ResultadoCampanha {}
    record Pendente(String campanha, String etapa) implements ResultadoCampanha {}
}
```

```java
ResultadoCampanha resultado = new ResultadoCampanha.Sucesso("Black Friday", 75.5, 15000.0);

String mensagem = switch (resultado) {
    case ResultadoCampanha.Sucesso s ->
        String.format("✅ %s concluída — ROI: %.1f%% | Receita: R$ %.2f",
            s.campanha(), s.roi(), s.receita());
    case ResultadoCampanha.Falha f ->
        String.format("❌ %s falhou — %s (código %d)",
            f.campanha(), f.motivo(), f.codigo());
    case ResultadoCampanha.Pendente p ->
        String.format("⏳ %s aguardando — etapa: %s",
            p.campanha(), p.etapa());
};

System.out.println(mensagem);
```

---

## 6. Hierarquia selada em camadas

```java
// nível 1 — sealed raiz
public sealed interface Evento
    permits EventoCampanha, EventoUsuario, EventoSistema { }

// nível 2 — sealed intermediário
public sealed interface EventoCampanha extends Evento
    permits EventoCampanha.Criada, EventoCampanha.Ativada,
            EventoCampanha.Pausada, EventoCampanha.Encerrada {

    record Criada(String nome, String plataforma) implements EventoCampanha {}
    record Ativada(String nome, double orcamento) implements EventoCampanha {}
    record Pausada(String nome, String motivo) implements EventoCampanha {}
    record Encerrada(String nome, double roi) implements EventoCampanha {}
}

public sealed interface EventoUsuario extends Evento
    permits EventoUsuario.Login, EventoUsuario.Logout, EventoUsuario.AcessoNegado {

    record Login(String email, String ip) implements EventoUsuario {}
    record Logout(String email) implements EventoUsuario {}
    record AcessoNegado(String email, String acao) implements EventoUsuario {}
}

public non-sealed interface EventoSistema extends Evento { }
```

```java
public static String processarEvento(Evento evento) {
    return switch (evento) {
        case EventoCampanha.Criada c ->
            "Nova campanha: " + c.nome() + " em " + c.plataforma();
        case EventoCampanha.Ativada a ->
            "Campanha ativada: " + a.nome() + " | Orçamento: R$ " + a.orcamento();
        case EventoCampanha.Pausada p ->
            "Campanha pausada: " + p.nome() + " | Motivo: " + p.motivo();
        case EventoCampanha.Encerrada e ->
            "Campanha encerrada: " + e.nome() + " | ROI: " + e.roi() + "%";
        case EventoUsuario.Login l ->
            "Login: " + l.email() + " de " + l.ip();
        case EventoUsuario.Logout lo ->
            "Logout: " + lo.email();
        case EventoUsuario.AcessoNegado a ->
            "Acesso negado: " + a.email() + " tentou " + a.acao();
        case EventoSistema s ->
            "Evento de sistema";
    };
}
```

---

## 7. Sealed class vs interface vs abstract class — quando usar

```
Precisa controlar a hierarquia de tipos?
└── SIM → sealed
└── NÃO → abstract class ou interface normal

Os subtipos são principalmente dados?
└── SIM → sealed interface + records
└── NÃO → sealed abstract class + subclasses

Precisa de hierarquia em camadas?
└── SIM → sealed em vários níveis com permits
└── NÃO → sealed simples com final nas folhas

Quer abrir em algum ponto?
└── SIM → non-sealed no ponto de abertura
└── NÃO → final em todos os permits
```

---

## 8. Limitações

```java
// ❌ subclasse deve estar no mesmo pacote ou módulo
// pacote com.cerne.model:
public sealed class Campanha permits CampanhaMetaAds { }

// pacote com.outro:
public class CampanhaMetaAds extends Campanha { } // ❌ erro — pacote diferente

// ✅ mesma compilação unit (mesmo arquivo) — funciona com classes internas
public sealed class Resultado permits Resultado.Ok, Resultado.Erro {
    public final class Ok extends Resultado { }
    public final class Erro extends Resultado { }
}

// ❌ record não pode ser sealed (já é final implicitamente)
public sealed record Campanha(...) { } // erro
```

---

## 9. Resumo — quando sealed classes brilham

```
✅ Modelar domínio fechado (tipos de evento, resultado, estado)
✅ Substituir if/instanceof em cascata por switch exaustivo
✅ Garantir que novos tipos sejam sempre tratados
✅ Combinado com records — modelagem funcional de dados
✅ API pública onde você controla os subtipos
```

---
