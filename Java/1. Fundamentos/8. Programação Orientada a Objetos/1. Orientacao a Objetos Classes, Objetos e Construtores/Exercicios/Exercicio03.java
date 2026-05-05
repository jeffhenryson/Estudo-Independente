// ## Exercício 3 — `this` e shadowing

// Corrija o código abaixo e explique o que estava errado:

// ```java
// public class Contrato {
//     String empresa;
//     String plano;
//     int meses;
//     double valorTotal;

//     public Contrato(String empresa, String plano, int meses, double valorTotal) {
//         empresa = empresa;
//         plano = plano;
//         meses = meses;
//         valorTotal = valorTotal;
//     }

//     public void exibir() {
//         System.out.printf("Empresa: %s | Plano: %s | Meses: %d | Total: R$ %.2f%n",
//             empresa, plano, meses, valorTotal);
//     }

//     public static void main(String[] args) {
//         Contrato c = new Contrato("Cerne", "pro", 12, 1798.80);
//         c.exibir();
//     }
// }
// ```

public class Exercicio03 {
    public static void main(String[] args) {
        Contrato c = new Contrato("Cerne", "pro", 12, 1798.80);
        c.exibir();
    }
}

class Contrato {
    
    String empresa;
    String plano;
    int meses;
    double valorTotal;

    public Contrato(String empresa, String plano, int meses, double valorTotal) {
        this.empresa = empresa;
        this.plano = plano;
        this.meses = meses;
        this.valorTotal = valorTotal;
    }

    public void exibir() {
        System.out.printf("Empresa: %s | Plano: %s | Meses: %d | Total: R$ %.2f%n",
                empresa, plano, meses, valorTotal);
    }
}