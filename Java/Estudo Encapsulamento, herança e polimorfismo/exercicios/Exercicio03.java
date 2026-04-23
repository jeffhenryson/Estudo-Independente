// ## Exercício 3 — Override e `super`

// Crie a hierarquia de planos do **Cerne**:

// **`Plano`** (pai)

// - Atributos `protected`: `nome`, `mensalidade`
// - Método `descricao()` → imprime nome e mensalidade
// - Método `calcularAnual()` → retorna `mensalidade * 12`

// **`PlanoComDesconto`** (filho)

// - Atributo extra: `percentualDesconto`
// - `Override calcularAnual()` → aplica o desconto no valor anual
// - `Override descricao()` → chama `super.descricao()` e adiciona o desconto

// **`PlanoEnterprise`** (filho de `PlanoComDesconto`)

// - Atributo extra: `gerentеDedicado`
// - `Override descricao()` → chama `super.descricao()` e adiciona o gerente

// No `main`, crie um de cada e chame `descricao()` e `calcularAnual()` em todos.

public class Exercicio03 {

    public static void main(String[] args) {
        
        Plano plano = new Plano("Starter", 29.99);
        PlanoComDesconto planoDesconto = new PlanoComDesconto("Pro", 49.99, 10);
        PlanoEnterprise planoEnterprise = new PlanoEnterprise("Enterprise", 99.99, 20, true);

        plano.descricao();
        System.out.println("Valor Anual: " + plano.calcularAnual());

        System.out.println();

        planoDesconto.descricao();
        System.out.println("Valor Anual com Desconto: " + planoDesconto.calcularAnual());

        System.out.println();

        planoEnterprise.descricao();
        System.out.println("Valor Anual com Desconto: " + planoEnterprise.calcularAnual());

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
