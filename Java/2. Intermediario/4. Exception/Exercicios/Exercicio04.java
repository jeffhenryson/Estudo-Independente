// ## Exercício 4 — Exceção checked customizada

// Crie o sistema de limite de usuários do **Cerne**:

// **Exceção:**

// ```java
// class LimiteUsuariosException extends Exception {
//     // atributos: limite, atual
//     // construtor com limite e atual
//     // getters para limite e atual
// }
// ```

// **Classe `Empresa`:**

// - Atributos: `nome`, `plano`, `limiteUsuarios`, `totalUsuarios`
// - Método `adicionarUsuario(String nome) throws LimiteUsuariosException`
//     - Lança se `totalUsuarios >= limiteUsuarios`
// - Método `listarUsuarios()`

// No `main`:

// 1. Crie uma empresa com limite de 3 usuários
// 2. Adicione usuários até ultrapassar o limite
// 3. Capture `LimiteUsuariosException` e use `getLimite()` e `getAtual()` na mensagem
// 4. Mostre que o compilador **obriga** o tratamento por ser checked


public class Exercicio04 {
    public static void main(String[] args){

        Empresa empresa = new Empresa("Cerne", "Premium", 3);

        try {
            empresa.adicionarUsuario("Alice");
            empresa.adicionarUsuario("Bob");
            empresa.adicionarUsuario("Charlie");
            empresa.adicionarUsuario("David"); // Exceção aqui
        } catch (LimiteUsuarioException e) {
            System.out.println("Limite de usuários atingido! Limite: " + e.getLimite() + ", Atual: " + e.getAtual());
        }
    }
}

class Empresa{

    public String nome;
    public String plano;
    public int limiteUsuarios;
    public int totalUsuarios;

    public Empresa(String nome, String plano, int limiteUsuarios) {
        this.nome = nome;
        this.plano = plano;
        this.limiteUsuarios = limiteUsuarios;
        this.totalUsuarios = 0;
    }

    public void adicionarUsuario(String nome) throws LimiteUsuarioException {
        if (totalUsuarios >= limiteUsuarios) {
            throw new LimiteUsuarioException(limiteUsuarios, totalUsuarios);
        }
        totalUsuarios++;
        System.out.println("Usuário " + nome + " adicionado. Total: " + totalUsuarios);
    }

}

class LimiteUsuarioException extends Exception {

    public int limite;
    public int atual;

    public LimiteUsuarioException(int limite, int atual) {
        this.limite = limite;
        this.atual = atual;
    }

    public int getLimite() {
        return limite;
    }

    public int getAtual() {
        return atual;
    }
}