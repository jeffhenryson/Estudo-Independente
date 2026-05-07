// ## 3. Cadastro de Clientes e Funcionários

// **Enunciado:** Crie uma superclasse chamada `Pessoa` com os atributos `String nome` e `String cpf`.
// * Crie subclasses chamadas `Cliente` (com atributo `int codigoCliente`) e `Funcionario` (com atributo `double salarioBase`).
// * Implemente os construtores adequados em ambas as classes utilizando o comando `super()` e garanta que os atributos sejam protegidos ou privados com os respectivos *getters*.

public class Exercicio03 {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Maria", "123.456.789-00", 101);
        Funcionario funcionario = new Funcionario("João", "987.654.321-00", 3000);

        System.out.println("Cliente: " + cliente.nome + ", CPF: " + cliente.cpf + ", Código: " + cliente.getCodigoCliente());
        System.out.println("Funcionário: " + funcionario.nome + ", CPF: " + funcionario.cpf + ", Salário Base: " + funcionario.getSalarioBase());
    }
}

class Pessoa {
    protected String nome;
    protected String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
}

class Cliente extends Pessoa {
    private int codigoCliente;

    public Cliente(String nome, String cpf, int codigoCliente) {
        super(nome, cpf);
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }
}

class Funcionario extends Pessoa {
    private double salarioBase;

    public Funcionario(String nome, String cpf, double salarioBase) {
        super(nome, cpf);
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}
