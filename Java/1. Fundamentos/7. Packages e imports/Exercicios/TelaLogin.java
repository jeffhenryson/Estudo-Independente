public class TelaLogin {
    public static void main(String[] args) {
        Usuario usuarioComum = new Usuario("João");
        Administrador administrador = new Administrador("Maria", "Total");

        usuarioComum.login();
        administrador.login();
    }
}
