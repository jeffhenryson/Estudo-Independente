// ## Exercício 1 — Encapsulamento

// Crie uma classe `Usuario` com os atributos **privados**: `nome`, `email`, `plano`, `ativo`.

// - Construtor completo
// - Getters para todos os atributos
// - Setter só para `plano` — com validação: só aceita `"starter"`, `"pro"` ou `"enterprise"`
// - Setter só para `email` — com validação: deve conter `"@"` e `"."`
// - Sem setter para `nome` e `ativo` — `nome` nunca muda, `ativo` só muda via métodos:
//     - `ativar()` e `desativar()`
// - Método `toString()`

// No `main`, tente setar valores inválidos e veja as validações funcionando.

public class Exercicio01 {

    public static void main(String[] args) {
        Usuario usuario = new Usuario("João", "joao@email.com", "pro", true);
        System.out.println(usuario);

        // Testando validação de email
        usuario.setEmail("joaoemail.com"); // Email inválido
        usuario.setEmail("joao@emailcom"); // Email inválido
        usuario.setEmail("joao@email.com"); // Email válido

        // Testando validação de plano
        usuario.setPlano("basic"); // Plano inválido
        usuario.setPlano("enterprise"); // Plano válido
        System.out.println(usuario);

        // Testando ativação e desativação
        usuario.desativar();
        System.out.println(usuario);

        usuario.ativar();
        System.out.println(usuario);
    }

}

class Usuario {

    private String nome;
    private String email;
    private String plano;
    private boolean ativo;

    public Usuario(String nome, String email, String plano, boolean ativo) {
        this.nome = nome;
        setEmail(email);
        setPlano(plano);
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getPlano() {
        return plano;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setEmail(String email) {
        if (email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("Email inválido: " + email);
        }
    }

    public void setPlano(String plano) {
        if (plano.equals("starter") || plano.equals("pro") || plano.equals("enterprise")) {
            this.plano = plano;
        } else {
            System.out.println("Plano inválido: " + plano);
        }
    }

    public void ativar() {
        this.ativo = true;
    }

    public void desativar() {
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", plano='" + plano + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
