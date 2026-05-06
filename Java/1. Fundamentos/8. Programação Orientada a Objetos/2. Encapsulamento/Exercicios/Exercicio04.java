// ## 4. Cadastro de Usuário com Validação de Senha

// **Enunciado:** Crie uma classe chamada `Usuario` com os atributos privados `String nome` e `String senha`.
// * O nome não pode ser alterado depois da inicialização (não deve ter o `setter` do nome).
// * A senha pode ser alterada através do método `setSenha`, mas o programa deve validar se a nova senha possui pelo menos 6 caracteres. Caso contrário, exiba uma mensagem como `"Senha muito curta!"`.

public class Exercicio04 {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("João", "12345"); // Deve exibir uma mensagem de erro
        usuario.setSenha("123456"); // Deve ser permitido
    }
}

class Usuario {
    private String nome;
    private String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        setSenha(senha); // Usando o setter para aplicar a validação
    }

    public String getNome() {
        return nome;
    }

    public void setSenha(String senha) {
        if (senha.length() >= 6) {
            this.senha = senha;
        } else {
            System.out.println("Senha muito curta! A senha deve conter pelo menos 6 caracteres. Senha não alterada.");
        }
    }
}
