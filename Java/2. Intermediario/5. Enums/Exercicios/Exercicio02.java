// ## Exercício 2 — Enum com atributos e métodos

// Crie o enum `Plano` completo do **Cerne**:

// - Constantes: `STARTER`, `PRO`, `ENTERPRISE`
// - Atributos: `nome`, `mensalidade`, `limiteUsuarios`, `limiteCampanhas`
// - Métodos:
//     - `calcularAnual()` → mensalidade * 12
//     - `calcularComDesconto(double percentual)` → mensalidade com desconto
//     - `resumo()` → string formatada com todos os dados
//     - `podeAdicionarUsuario(int totalAtual)` → boolean

// No `main`:

// 1. Imprima o resumo de todos os planos
// 2. Calcule o valor anual de cada plano
// 3. Aplique 15% de desconto no `PRO` e imprima
// 4. Verifique se cada plano pode adicionar usuário dado um total atual

public class Exercicio02 {
    public static void main(String[] args) {
        
        for (Plano plano : Plano.values()) {
            System.out.println(plano.resumo());
            System.out.println("-----------------------------");
            System.out.printf("Valor anual: R$%.2f%n", plano.calcularAnual());
            if (plano == Plano.PRO) {
                System.out.printf("Valor com 15%% de desconto: R$%.2f%n", plano.calcularComDesconto(15));
            }
            int totalAtual = 10; // Exemplo de total atual
            System.out.printf("Pode adicionar usuário (total atual: %d)? %b%n",
                    totalAtual, plano.podeAdicionarUsuario(totalAtual));
        }
    }
}

enum Plano {
    STARTER("Starter", 29.99, 5, 10),
    PRO("Pro", 59.99, 20, 50),
    ENTERPRISE("Enterprise", 99.99, 100, 200);

    private String nome;
    private double mensalidade;
    private int limiteUsuarios;
    private int limiteCampanhas;

    Plano(String nome, double mensalidade, int limiteUsuarios, int limiteCampanhas) {
        this.nome = nome;
        this.mensalidade = mensalidade;
        this.limiteUsuarios = limiteUsuarios;
        this.limiteCampanhas = limiteCampanhas;
    }

    public double calcularAnual() {
        return mensalidade * 12;
    }

    public double calcularComDesconto(double percentual) {
        return mensalidade * (1 - percentual / 100);
    }

    public String resumo() {
        return String.format("%s: R$%.2f/mês, Limite de Usuários: %d, Limite de Campanhas: %d",
                nome, mensalidade, limiteUsuarios, limiteCampanhas);
    }

    public boolean podeAdicionarUsuario(int totalAtual) {
        return totalAtual < limiteUsuarios;
    }
}