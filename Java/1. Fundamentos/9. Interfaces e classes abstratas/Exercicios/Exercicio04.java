// ## Exercício 4 — Abstrata + Interface juntas

// Crie:

// **Interface `Calculavel`**

// - `double calcularTotal()`
// - `default String formatarTotal()` → retorna `"R$ X.XX"`

// **Classe abstrata `ItemCobranca`** implementa `Calculavel`

// - Atributos `protected`: `descricao`, `quantidade`
// - Construtor
// - Método abstrato: `double calcularUnitario()`
// - `calcularTotal()` já implementado → `calcularUnitario() * quantidade`

// **`AssinaturaPlano`** (filho)

// - Atributo extra: `mensalidade`
// - `calcularUnitario()` → retorna `mensalidade`

// **`ServicoAvulso`** (filho)

// - Atributo extra: `valorHora`, `horasTrabalhadas`
// - `calcularUnitario()` → retorna `valorHora * horasTrabalhadas`

// No `main`:

// 1. Crie um array `Calculavel[]` com instâncias de ambos
// 2. Imprima `descricao` e `formatarTotal()` de cada um
// 3. Some o total geral da fatura


public class Exercicio04 {
    public static void main(String[] args) {
        Calculavel[] itens = {
            new AssinaturaPlano("Plano Premium", 1, 99.99),
            new ServicoAvulso("Manutenção", 1, 50.0, 2)
        };

        double totalGeral = 0;
        for (Calculavel item : itens) {
            System.out.println("Descrição: " + item.toString());
            System.out.println("Total: " + item.formatarTotal());
            totalGeral += item.calcularTotal();
        }

        System.out.println("\nTotal geral da fatura: " + String.format("R$ %.2f", totalGeral));
    }
}

interface Calculavel {
    double calcularTotal();
    
    default String formatarTotal() {
        return String.format("R$ %.2f", calcularTotal());
    }
}

abstract class ItemCobranca implements Calculavel {

    protected String descricao;
    protected int quantidade;

    public ItemCobranca(String descricao, int quantidade) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public abstract double calcularUnitario();

    @Override
    public double calcularTotal() {
        return calcularUnitario() * quantidade;
    }
}

class AssinaturaPlano extends ItemCobranca {

    private double mensalidade;

    public AssinaturaPlano(String descricao, int quantidade, double mensalidade) {
        super(descricao, quantidade);
        this.mensalidade = mensalidade;
    }

    @Override
    public double calcularUnitario() {
        return mensalidade;
    }
}

class ServicoAvulso extends ItemCobranca {

    private double valorHora;
    private int horasTrabalhadas;

    public ServicoAvulso(String descricao, int quantidade, double valorHora, int horasTrabalhadas) {
        super(descricao, quantidade);
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double calcularUnitario() {
        return valorHora * horasTrabalhadas;
    }
}