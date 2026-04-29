// ## Exercício 6 — Desafio

// Construa um mini sistema de gestão com as classes:

// **`Plano`**

// - Atributos: `nome`, `mensalidade`, `limiteUsuarios`, `limiteCampanhas`
// - Construtor completo + `toString()`

// **`Usuario`**

// - Atributos: `nome`, `email`, `cargo`
// - Construtor completo + `toString()`

// **`Empresa`**

// - Atributos: `nome`, `plano` (tipo `Plano`), array de `Usuario[]` com até 5 usuários, `totalUsuarios`
// - Atributo estático `totalEmpresas`
// - Construtor que recebe `nome` e `plano`
// - Métodos:
//     - `adicionarUsuario(Usuario u)` → adiciona se houver slot e dentro do limite do plano
//     - `listarUsuarios()` → imprime todos os usuários
//     - `resumo()` → imprime empresa, plano, total de usuários cadastrados

// **`Main`**

// - Crie 2 planos (`starter` e `pro`)
// - Crie 2 empresas com planos diferentes
// - Crie 5 usuários e distribua entre as empresas
// - Tente ultrapassar o limite de uma delas
// - Chame `resumo()` em cada empresa
// - Imprima `Empresa.totalEmpresas` no final



public class Exercicio06 {
    public static void main(String[] args) {

        // Criando planos
        Plano planoStarter = new Plano("Starter", 19.99, 3, 2);
        Plano planoPro = new Plano("Pro", 49.99, 5, 5);

        // Criando empresas
        Empresa empresaX = new Empresa("Empresa X", planoStarter);
        Empresa empresaY = new Empresa("Empresa Y", planoPro);

        // Criando usuários
        Usuario u1 = new Usuario("Alice", "alice@example.com", "Desenvolvedor");
        Usuario u2 = new Usuario("Bob", "bob@example.com", "Designer");
        Usuario u3 = new Usuario("Charlie", "charlie@example.com", "Gerente");
        Usuario u4 = new Usuario("David", "david@example.com", "Analista");
        Usuario u5 = new Usuario("Eve", "eve@example.com", "Testador");

        // Adicionando usuários às empresas
        empresaX.adicionarUsuario(u1);
        empresaX.adicionarUsuario(u2);
        empresaX.adicionarUsuario(u3);

        empresaY.adicionarUsuario(u4);
        empresaY.adicionarUsuario(u5);

        // Tente ultrapassar o limite de uma das empresas
        Usuario u6 = new Usuario("Frank", "frank@example.com", "DevOps");
        empresaX.adicionarUsuario(u6); // Deve falhar

        // Chame `resumo()` em cada empresa
        System.out.println("\nResumo da Empresa X:");
        empresaX.resumo();

        System.out.println("\nResumo da Empresa Y:");
        empresaY.resumo();

        // Imprima `Empresa.totalEmpresas` no final
        System.out.println("\nTotal de empresas: " + Empresa.totalEmpresas);
    }
}

class Plano {

    String nome;
    double mensalidade;
    int limiteUsuarios;
    int limiteCampanhas;

    public Plano(String nome, double mensalidade, int limiteUsuarios, int limiteCampanhas) {
        this.nome = nome;
        this.mensalidade = mensalidade;
        this.limiteUsuarios = limiteUsuarios;
        this.limiteCampanhas = limiteCampanhas;
    }

    @Override
    public String toString() {
        return "Plano{" +
                "nome='" + nome + '\'' +
                ", mensalidade=" + mensalidade +
                ", limiteUsuarios=" + limiteUsuarios +
                ", limiteCampanhas=" + limiteCampanhas +
                '}';
    }
}

class Usuario {

    String nome;
    String email;
    String cargo;

    public Usuario(String nome, String email, String cargo) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}

class Empresa {

    String nome;
    Plano plano;
    Usuario[] usuarios = new Usuario[5];
    int totalUsuarios = 0;

    static int totalEmpresas = 0;

    public Empresa(String nome, Plano plano) {
        this.nome = nome;
        this.plano = plano;
        totalEmpresas++;
    }

    public void adicionarUsuario(Usuario u) {
        if (totalUsuarios < usuarios.length && totalUsuarios < plano.limiteUsuarios) {
            usuarios[totalUsuarios] = u;
            totalUsuarios++;
            System.out.println("Usuário " + u.nome + " adicionado com sucesso!");
        } else {
            System.out.println("Não é possível adicionar mais usuários. Limite atingido.");
        }
    }

    public void listarUsuarios() {
        System.out.println("Usuários da empresa " + nome + ":");
        for (int i = 0; i < totalUsuarios; i++) {
            System.out.println(usuarios[i]);
        }
    }

    public void resumo() {
        System.out.println("Empresa: " + nome);
        System.out.println("Plano contratado: " + plano.nome);
        System.out.println("Total de usuários cadastrados: " + totalUsuarios);
    }
}
