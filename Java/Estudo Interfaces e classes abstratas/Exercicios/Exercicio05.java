// ## Exercício 5 — Polimorfismo via interface

// Crie a interface `Notificavel`:

// ```java
// interface Notificavel {
//     void notificar(String mensagem);
//     String getTipoNotificacao();
// }
// ```

// Crie 3 implementações:

// - `NotificacaoEmail` → imprime `"[EMAIL para email@x.com]: mensagem"`
// - `NotificacaoSms` → imprime `"[SMS para +55...]: mensagem"`
// - `NotificacaoPush` → imprime `"[PUSH - dispositivo]: mensagem"`

// Crie uma classe `CentralNotificacoes`:

// - Atributo: `Notificavel[]` com até 10 notificadores
// - Método `adicionar(Notificavel n)`
// - Método `notificarTodos(String mensagem)` → dispara para todos via polimorfismo
// - Método `listarCanais()` → imprime o tipo de cada notificador

// No `main`, adicione os 3 tipos e chame `notificarTodos()`.

public class Exercicio05 {
    public static void main(String[] args) {
        CentralNotificacoes central = new CentralNotificacoes();

        central.adicionar(new NotificacaoEmail());
        central.adicionar(new NotificacaoSms());
        central.adicionar(new NotificacaoPush());

        System.out.println("Canais de notificação:");
        central.listarCanais();

        System.out.println("\nEnviando notificação para todos:");
        central.notificarTodos("Olá, esta é uma mensagem de teste!");
    }
}

interface Notificavel {
    void notificar(String mensagem);

    String getTipoNoticacao();
}

class NotificacaoEmail implements Notificavel {
    @Override
    public void notificar(String mensagem) {
        System.out.println("[EMAIL para email@x.com]: " + mensagem);
    }

    @Override
    public String getTipoNoticacao() {
        return "EMAIL";
    }
}

class NotificacaoSms implements Notificavel {
    @Override
    public void notificar(String mensagem) {
        System.out.println("[SMS para +55...]: " + mensagem);
    }

    @Override
    public String getTipoNoticacao() {
        return "SMS";
    }
}

class NotificacaoPush implements Notificavel {
    @Override
    public void notificar(String mensagem) {
        System.out.println("[PUSH - dispositivo]: " + mensagem);
    }

    @Override
    public String getTipoNoticacao() {
        return "PUSH";
    }
}

class CentralNotificacoes {

    private Notificavel[] notificadores = new Notificavel[10];

    private int count = 0;

    public void adicionar(Notificavel n) {
        if (count < notificadores.length) {
            notificadores[count++] = n;
        } else {
            System.out.println("Limite de notificadores atingido.");
        }
    }

    public void notificarTodos(String mensagem) {
        for (int i = 0; i < count; i++) {
            notificadores[i].notificar(mensagem);
        }
    }

    public void listarCanais() {
        for (int i = 0; i < count; i++) {
            System.out.println(notificadores[i].getTipoNoticacao());
        }
    }
}