public class Usuario {
    protected String nome;
    protected boolean autenticado;

    public Usuario(String nome) {
        this.nome = nome;
        this.autenticado = false;
    }

    public void login() {
        this.autenticado = true;
        System.out.println("Usuário " + this.nome + " logado no sistema.");
    }
}
