
// ### 1. Arquivo 1: A Classe `Usuario` (Superclasse) e `Administrador` (Subclasse)

// Crie a classe base `Usuario` com os seguintes atributos e métodos:
// * Atributo `protected String nome` (encapsulado).
// * Atributo `protected boolean autenticado` (encapsulado).
// * Um construtor que inicializa o nome do usuário.
// * Um método `public void login()`, que altera o atributo `autenticado` para `true` e imprime: `"Usuário [Nome] logado no sistema."`

// Em seguida, no mesmo arquivo ou em um arquivo separado, crie a subclasse `Administrador` que herda de `Usuario`:
// * Adicione o atributo privado `String nivelAcesso`.
// * Sobrescreva o método `login()` usando `@Override` para imprimir: `"Administrador [Nome] logado com acesso total no nível: [Nivel]."`

public class Administrador extends Usuario {
    private String nivelAcesso;

    public Administrador(String nome, String nivelAcesso) {
        super(nome);
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public void login() {
        this.autenticado = true;
        System.out.println("Administrador " + this.nome + " logado com acesso total no nível: " + this.nivelAcesso + ".");
    }
    
}

