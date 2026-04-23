// ## Exercício 4 — Polimorfismo

// Usando as classes do exercício anterior:

// 1. Crie um array `Plano[]` com instâncias dos 3 tipos
// 2. Percorra com `for-each` e chame `descricao()` e `calcularAnual()` em cada um — observe o polimorfismo
// 3. Use `instanceof` para identificar o tipo real de cada objeto e imprima uma mensagem específica para cada tipo

public class Exercicio04 {
    public static void main(String[] args) {
        Plano[] planos = {
            new Plano("Starter", 29.99),
            new PlanoComDesconto("Pro", 49.99, 10),
            new PlanoEnterprise("Enterprise", 99.99, 20, true)
        };

        for (Plano plano : planos) {
            plano.descricao();
            System.out.println("Valor Anual: " + plano.calcularAnual());

            if (plano instanceof PlanoEnterprise) {
                System.out.println("Este é um plano Enterprise.");
            } else if (plano instanceof PlanoComDesconto) {
                System.out.println("Este é um plano com desconto.");
            } else {
                System.out.println("Este é um plano básico.");
            }

            System.out.println();
        }
    }
}


class Plano {

    protected String nome;
    protected double mensalidade;

    public Plano(String nome, double mensalidade) {
        this.nome = nome;
        this.mensalidade = mensalidade;
    }

    public void descricao() {
        System.out.println("Plano: " + nome + ", Mensalidade: " + mensalidade);
    }

    public double calcularAnual() {
        return mensalidade * 12;
    }
}

class PlanoComDesconto extends Plano {

    protected double percentualDesconto;

    public PlanoComDesconto(String nome, double mensalidade, double percentualDesconto) {
        super(nome, mensalidade);
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public double calcularAnual() {
        double valorAnual = super.calcularAnual();
        return valorAnual * (1 - percentualDesconto / 100);
    }

    @Override
    public void descricao() {
        super.descricao();
        System.out.println("Desconto: " + percentualDesconto + "%");
    }
}

class PlanoEnterprise extends PlanoComDesconto {

    protected boolean gerenteDedicado;

    public PlanoEnterprise(String nome, double mensalidade, double percentualDesconto, boolean gerenteDedicado) {
        super(nome, mensalidade, percentualDesconto);
        this.gerenteDedicado = gerenteDedicado;
    }

    @Override
    public void descricao() {
        super.descricao();
        System.out.println("Gerente Dedicado: " + (gerenteDedicado ? "Sim" : "Não"));
    }
}

