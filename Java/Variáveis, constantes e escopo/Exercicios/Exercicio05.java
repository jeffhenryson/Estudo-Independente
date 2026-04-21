// ## Exercício 5 — Shadowing e `this`

// Corrija o código para que o método `atualizar` modifique o **atributo da classe**, não a variável local — e que o `mostrar` exiba o valor correto:

// public class Conta {
//     double saldo = 1000.0;

//     public void atualizar(double saldo) {
//         saldo = saldo + 500.0;
//     }

//     public void mostrar() {
//         System.out.println("Saldo: " + saldo);
//     }

//     public static void main(String[] args) {
//         Conta c = new Conta();
//         c.atualizar(c.saldo);
//         c.mostrar(); // deve imprimir 1500.0
//     }
// }

public class Exercicio05 {
        public static void main(String[] args) {
        Conta c = new Conta();
        c.atualizar(c.saldo);
        c.mostrar();
    }
}

class Conta {
    double saldo = 1000.0;

    public void atualizar(double saldo) {
        this.saldo = saldo + 500.0;
    }

    public void mostrar() {
        System.out.println("Saldo: " + saldo);
    }
}

