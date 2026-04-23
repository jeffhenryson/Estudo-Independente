// ## Exercício 5 — Interação entre objetos

// Crie duas classes:

// **`Plano`**

// - Atributos: `nome`, `mensalidade`, `limiteUsuarios`
// - Construtor completo
// - Método `toString()`

// **`Empresa`**

// - Atributos: `nome`, `plano` (do tipo `Plano`), `totalUsuarios`
// - Construtor que recebe `nome` e `plano`
// - Método `podeAdicionarUsuario()` → retorna `boolean` comparando `totalUsuarios` com `plano.limiteUsuarios`
// - Método `adicionarUsuario()` → incrementa se puder, imprime aviso se não puder
// - Método `resumo()` → imprime empresa, plano contratado e usuários

// No `main`:

// 1. Crie 2 planos
// 2. Crie 2 empresas com planos diferentes
// 3. Tente adicionar usuários além do limite em uma delas

public class Exercicio05 {
    public static void main(String[] args) {
        
        // Criando planos
        Plano planoBasico = new Plano("Básico", 29.99, 5);
        Plano planoPremium = new Plano("Premium", 59.99, 10);

        // Criando empresas
        Empresa empresaA = new Empresa("Empresa A", planoBasico);
        Empresa empresaB = new Empresa("Empresa B", planoPremium);

        // Adicionando usuários na Empresa A (plano básico)
        for (int i = 0; i < 6; i++) { // Tentando adicionar 6 usuários, mas o limite é 5
            System.out.println("Adicionando usuário " + (i + 1) + " na Empresa A:");
            empresaA.adicionarUsuario();
        }

        // Resumo das empresas
        System.out.println("\nResumo da Empresa A:");
        empresaA.resumo();

        System.out.println("\nResumo da Empresa B:");
        empresaB.resumo();
    }
}

class Plano {

    String nome;
    double mensalidade;
    int limiteUsuarios;

    // Construtor completo
    public Plano(String nome, double mensalidade, int limiteUsuarios) {
        this.nome = nome;
        this.mensalidade = mensalidade;
        this.limiteUsuarios = limiteUsuarios;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Plano{" +
                "nome='" + nome + '\'' +
                ", mensalidade=" + mensalidade +
                ", limiteUsuarios=" + limiteUsuarios +
                '}';
    }
}

class Empresa {

    String nome;
    Plano plano;
    int totalUsuarios;

    // Construtor que recebe nome e plano
    public Empresa(String nome, Plano plano) {
        this.nome = nome;
        this.plano = plano;
        this.totalUsuarios = 0; // Inicialmente sem usuários
    }

    // Método podeAdicionarUsuario()
    public boolean podeAdicionarUsuario() {
        return totalUsuarios < plano.limiteUsuarios;
    }

    // Método adicionarUsuario()
    public void adicionarUsuario() {
        if (podeAdicionarUsuario()) {
            totalUsuarios++;
            System.out.println("Usuário adicionado. Total de usuários: " + totalUsuarios);
        } else {
            System.out.println("Não é possível adicionar mais usuários. Limite atingido.");
        }
    }

    // Método resumo()
    public void resumo() {
        System.out.println("Empresa: " + nome);
        System.out.println("Plano contratado: " + plano.nome);
        System.out.println("Total de usuários: " + totalUsuarios);
    }
}