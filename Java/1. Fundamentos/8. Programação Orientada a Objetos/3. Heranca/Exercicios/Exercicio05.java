
// ## 5. E-commerce: Produtos Físicos e Digitais

// **Enunciado:** Crie uma classe base chamada `Produto` com os atributos `String nome` e `double preco`.
// * Crie duas subclasses:
//   * `ProdutoFisico`, que adiciona o atributo `double peso`.
//   * `ProdutoDigital`, que adiciona o atributo `double tamanhoEmMb`.
// * Crie um método em ambas as subclasses que calcule o preço total, adicionando taxas ou descontos específicos para o tipo de produto.

public class Exercicio05 {
    public static void main(String[] args) {
        ProdutoFisico produtoFisico = new ProdutoFisico("Cadeira", 150.00, 5.0);
        ProdutoDigital produtoDigital = new ProdutoDigital("E-book", 50.00, 2.0);

        System.out.println("Produto Físico: " + produtoFisico.nome + ", Preço Total: " + produtoFisico.calcularPrecoTotal());
        System.out.println("Produto Digital: " + produtoDigital.nome + ", Preço Total: " + produtoDigital.calcularPrecoTotal());
    }
}

class Produto {
    protected String nome;
    protected double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}

class ProdutoFisico extends Produto {
    private double peso;

    public ProdutoFisico(String nome, double preco, double peso) {
        super(nome, preco);
        this.peso = peso;
    }

    public double calcularPrecoTotal() {
        // Exemplo: adicionar uma taxa de 10% para produtos físicos
        return preco * 1.10;
    }
}

class ProdutoDigital extends Produto {
    private double tamanhoEmMb;

    public ProdutoDigital(String nome, double preco, double tamanhoEmMb) {
        super(nome, preco);
        this.tamanhoEmMb = tamanhoEmMb;
    }

    public double calcularPrecoTotal() {
        // Exemplo: aplicar um desconto de 5% para produtos digitais
        return preco * 0.95;
    }
}