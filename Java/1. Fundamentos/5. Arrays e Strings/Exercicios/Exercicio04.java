// ## Exercício 4 — Split e join

// Dado o CSV abaixo:

// ```java
// String csv = "Jeff,28,Cerne,João Pessoa,CTO";
// ```

// 1. Separe os valores com `split()`
// 2. Imprima cada campo em uma linha com seu rótulo:

// ```
// Nome: Jeff
// Idade: 28
// Empresa: Cerne
// Cidade: João Pessoa
// Cargo: CTO
// ```

public class Exercicio04 {
    public static void main(String[] args) {
        
        String csv = "Jeff,28,Cerne,João Pessoa,CTO";

        // 1. Separar os valores com `split()`
        String[] campos = csv.split(",");

        // 2. Imprimir cada campo em uma linha com seu rótulo
        System.out.println("Nome: " + campos[0]);
        System.out.println("Idade: " + campos[1]);
        System.out.println("Empresa: " + campos[2]);
        System.out.println("Cidade: " + campos[3]);
        System.out.println("Cargo: " + campos[4]);
    }
}
