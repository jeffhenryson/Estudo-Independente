// ## Exercício 3 — Exceção unchecked customizada

// Crie o sistema de validação de planos do **Cerne**:

// **Exceção:**

// ```java
// class PlanoInvalidoException extends RuntimeException {
//     // construtor com nome do plano
//     // construtor com nome do plano e causa (Throwable)
//     // getter para o plano inválido
// }
// ```

// **Serviço:**

// ```java
// class PlanoService {
//     // planos válidos: "starter", "pro", "enterprise"
//     double getMensalidade(String plano)    // lança PlanoInvalidoException se inválido
//     int getLimiteUsuarios(String plano)    // lança PlanoInvalidoException se inválido
//     String getDescricao(String plano)      // lança PlanoInvalidoException se inválido
// }
// ```

// No `main`:

// 1. Teste com planos válidos e imprima as informações
// 2. Teste com plano inválido e capture `PlanoInvalidoException`
// 3. Mostre que não é obrigado a declarar `throws` — é unchecked

public class Exercicio03{
    public static void main(String[] Args){

        // No `main`:

        // 1. Teste com planos válidos e imprima as informações
        // 2. Teste com plano inválido e capture `PlanoInvalidoException`
        // 3. Mostre que não é obrigado a declarar `throws` — é unchecked

        PlanoService planoService = new PlanoService();
        String[] planos = {"starter", "pro", "enterprise", "invalid"};

        for (String plano : planos) {
            try {
                System.out.println("Plano: " + plano);
                System.out.println("Mensalidade: " + planoService.getMensalidade(plano));
                System.out.println("Limite de Usuários: " + planoService.getLimiteUsuarios(plano));
                System.out.println("Descrição: " + planoService.getDescricao(plano));
                System.out.println();
            } catch (PlanoInvalidoException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }

    }
}

class PlanoService {

    public double getMensalidade(String plano) {
        switch (plano.toLowerCase()) {
            case "starter":
                return 29.99;
            case "pro":
                return 59.99;
            case "enterprise":
                return 99.99;
            default:
                throw new PlanoInvalidoException(plano);
        }
    }

    public int getLimiteUsuarios(String plano) {
        switch (plano.toLowerCase()) {
            case "starter":
                return 5;
            case "pro":
                return 20;
            case "enterprise":
                return 100;
            default:
                throw new PlanoInvalidoException(plano);
        }
    }

    public String getDescricao(String plano) {
        switch (plano.toLowerCase()) {
            case "starter":
                return "Plano básico para pequenas equipes.";
            case "pro":
                return "Plano intermediário para equipes em crescimento.";
            case "enterprise":
                return "Plano avançado para grandes empresas.";
            default:
                throw new PlanoInvalidoException(plano);
        }
    }
}

class PlanoInvalidoException extends RuntimeException {

    private String planoInvalido;

    public PlanoInvalidoException(String planoInvalido) {
        super("Plano inválido: " + planoInvalido);
        this.planoInvalido = planoInvalido;
    }

    public PlanoInvalidoException(String planoInvalido, Throwable cause) {
        super("Plano inválido: " + planoInvalido, cause);
        this.planoInvalido = planoInvalido;
    }

    public String getPlanoInvalido() {
        return planoInvalido;
    }

}