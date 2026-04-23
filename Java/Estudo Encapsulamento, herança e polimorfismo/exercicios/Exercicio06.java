// ## Exercício 6 — Desafio

// Expanda o sistema de gestão com herança e encapsulamento:

// **`Usuario`** (pai)

// - Atributos `private`: `nome`, `email`
// - Construtor + getters
// - Método `perfil()` → imprime nome e email
// - Método `temPermissao(String acao)` → retorna `false` por padrão

// **`UsuarioAdmin`** (filho)

// - Atributo extra: `nivelAcesso` (int 1-3)
// - `@Override temPermissao(String acao)`:
//     - nível 1 → só `"ler"`
//     - nível 2 → `"ler"` e `"editar"`
//     - nível 3 → qualquer ação
// - `@Override perfil()` → chama `super.perfil()` e adiciona nível de acesso

// **`UsuarioCliente`** (filho)

// - Atributo extra: `planoContratado`
// - `@Override temPermissao(String acao)` → só `"ler"` e `"criar-campanha"`
// - `@Override perfil()` → chama `super.perfil()` e adiciona plano

// **`SistemaPermissao`** (classe separada)

// - Método estático `verificar(Usuario u, String acao)`:
//     - chama `u.temPermissao(acao)` — polimorfismo puro
//     - imprime `"[nome] TEM permissão para [acao]"` ou `"[nome] NÃO TEM permissão para [acao]"`

// No `main`:

// 1. Crie um `UsuarioAdmin` nível 2, um nível 3 e um `UsuarioCliente`
// 2. Teste várias ações com `SistemaPermissao.verificar()`
// 3. Coloque todos em um array `Usuario[]` e itere chamando `perfil()` — polimorfismo

public class Exercicio06 {
    public static void main(String[] args) {

        UsuarioAdmin adminNivel2 = new UsuarioAdmin("Alice", "alice@example.com", 2);
        UsuarioAdmin adminNivel3 = new UsuarioAdmin("Bob", "bob@example.com", 3);
        UsuarioCliente cliente = new UsuarioCliente("Charlie", "charlie@example.com", "Plano Premium");

        SistemaPermissao.verificar(adminNivel2, "ler");
        SistemaPermissao.verificar(adminNivel2, "editar");
        SistemaPermissao.verificar(adminNivel2, "deletar");

        SistemaPermissao.verificar(adminNivel3, "ler");
        SistemaPermissao.verificar(adminNivel3, "editar");
        SistemaPermissao.verificar(adminNivel3, "deletar");

        SistemaPermissao.verificar(cliente, "ler");
        SistemaPermissao.verificar(cliente, "criar-campanha");
        SistemaPermissao.verificar(cliente, "editar");

        Usuario[] usuarios = {adminNivel2, adminNivel3, cliente};

        for (Usuario u : usuarios) {
            System.out.println("\nPerfil do usuário:");
            u.perfil();
        }
    }
}

class Usuario {
    
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void perfil() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
    }

    public boolean temPermissao(String acao) {
        return false; // Por padrão, nenhum usuário tem permissão
    }
}

class UsuarioAdmin extends Usuario {
    
    private int nivelAcesso;

    public UsuarioAdmin(String nome, String email, int nivelAcesso) {
        super(nome, email);
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public boolean temPermissao(String acao) {
        if (nivelAcesso == 1) {
            return acao.equals("ler");
        } else if (nivelAcesso == 2) {
            return acao.equals("ler") || acao.equals("editar");
        } else if (nivelAcesso == 3) {
            return true; // Nível 3 tem permissão para qualquer ação
        }
        return false;
    }

    @Override
    public void perfil() {
        super.perfil();
        System.out.println("Nível de Acesso: " + nivelAcesso);
    }
}

class UsuarioCliente extends Usuario {
    
    private String planoContratado;

    public UsuarioCliente(String nome, String email, String planoContratado) {
        super(nome, email);
        this.planoContratado = planoContratado;
    }

    @Override
    public boolean temPermissao(String acao) {
        return acao.equals("ler") || acao.equals("criar-campanha");
    }

    @Override
    public void perfil() {
        super.perfil();
        System.out.println("Plano Contratado: " + planoContratado);
    }
}

class SistemaPermissao {

    public static void verificar(Usuario u, String acao) {
        if (u.temPermissao(acao)) {
            System.out.println(u.getNome() + " TEM permissão para " + acao);
        } else {
            System.out.println(u.getNome() + " NÃO TEM permissão para " + acao);
        }
    }
}