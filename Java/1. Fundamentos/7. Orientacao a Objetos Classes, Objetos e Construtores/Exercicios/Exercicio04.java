// ## Exercício 4 — Atributo estático

// Crie uma classe `Cliente` com:

// - Atributo estático `totalClientes` que conta quantos clientes foram criados
// - Atributos de instância: `nome`, `email`, `plano`
// - Construtor que incrementa `totalClientes` a cada instância criada
// - Método estático `getTotalClientes()` que retorna o contador
// - Método `toString()`

// No `main`, crie 4 clientes e imprima o total após cada criação.

public class Exercicio04 {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Alice", "alice@example.com", "Plano A");
        System.out.println("Total de clientes: " + Cliente.getTotalClientes());

        Cliente cliente2 = new Cliente("Bob", "bob@example.com", "Plano B");
        System.out.println("Total de clientes: " + Cliente.getTotalClientes());

        Cliente cliente3 = new Cliente("Charlie", "charlie@example.com", "Plano C");
        System.out.println("Total de clientes: " + Cliente.getTotalClientes());
        
        Cliente cliente4 = new Cliente("Diana", "diana@example.com", "Plano D");
        System.out.println("Total de clientes: " + Cliente.getTotalClientes());
    }
}

class Cliente {

    static int totalClientes;

    String nome;
    String email;
    String plano;

    // Construtor que incrementa totalClientes a cada instância criada
    public Cliente(String nome, String email, String plano) {
        this.nome = nome;
        this.email = email;
        this.plano = plano;
        totalClientes++;
    }

    // Método estático para retornar o total de clientes
    public static int getTotalClientes() {
        return totalClientes;
    }

    // Método toString para representar o cliente como string
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", plano='" + plano + '\'' +
                '}';
    }

}
