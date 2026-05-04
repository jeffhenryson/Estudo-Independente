// ## Exercício 6 — Desafio
// Construa o sistema de cadastro de empresas do **Cerne** com tratamento completo de exceções:

// **Exceções customizadas:**

// ```java
// // unchecked
// class EmailInvalidoException extends RuntimeException {
//     // deve conter o email inválido
// }

// // unchecked
// class EmpresaJaCadastradaException extends RuntimeException {
//     // deve conter o nome da empresa
// }

// // checked
// class LimitePlanoException extends Exception {
//     // deve conter: plano, limite, atual
// }
// ```

// **Classe `CadastroService`:**

// ```java
// class CadastroService {
//     // Map<String, String> empresas — nome → email
//     // Map<String, String> planos — nome → plano
//     // Map<String, Integer> limites — plano → limite de empresas

//     void cadastrarEmpresa(String nome, String email, String plano)
//         throws LimitePlanoException
//     // lança EmailInvalidoException se email não contém "@" e "."
//     // lança EmpresaJaCadastradaException se nome já existe
//     // lança PlanoInvalidoException se plano não é válido (reutilize do Ex 3)
//     // lança LimitePlanoException se o plano atingiu limite de empresas

//     void listarEmpresas()
//     Map<String, Long> contagemPorPlano() // quantas empresas por plano
// }
// ```

// **No `main`:**

// 1. Cadastre empresas válidas de diferentes planos
// 2. Tente cadastrar email inválido → `EmailInvalidoException`
// 3. Tente cadastrar empresa duplicada → `EmpresaJaCadastradaException`
// 4. Tente cadastrar plano inválido → `PlanoInvalidoException`
// 5. Encha um plano até o limite e tente mais uma → `LimitePlanoException`
// 6. Ao final, liste todas as empresas e a contagem por plano

import java.util.Map;
import java.util.HashMap;

public class Desafio {
    public static void main(String[] args) {
        
        Map<String, String> planos = new HashMap<>();
        planos.put("Básico", "Plano Básico");
        planos.put("Premium", "Plano Premium");

        Map<String, Integer> limites = new HashMap<>();
        limites.put("Básico", 2);
        limites.put("Premium", 3);

        CadastroService service = new CadastroService(planos, limites);

        try {
            service.cadastrarEmpresa("Empresa A", "empresaA@exemplo.com", "Básico");
            service.cadastrarEmpresa("Empresa B", "empresaB@exemplo.com", "Básico");
            service.cadastrarEmpresa("Empresa C", "empresaC@exemplo.com", "Premium");
            service.cadastrarEmpresa("Empresa D", "empresaD@exemplo.com", "Premium");
            service.cadastrarEmpresa("Empresa E", "empresaE@exemplo.com", "Premium");

            service.cadastrarEmpresa("Empresa A", "empresaA@exemplo.com", "Básico"); // empresa duplicada
            service.cadastrarEmpresa("Empresa F", "empresaFexemplo.com", "Básico"); // email inválido
            service.cadastrarEmpresa("Empresa G", "empresaG@exemplo.com", "Premium"); // plano Premium cheio 
            service.cadastrarEmpresa("Empresa H", "empresaH@exemplo.com", "Gold"); // plano inválido

        } catch (LimitePlanoException | EmailInvalidoException | EmpresaJaCadastradaException | PlanoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        service.listarEmpresas();
    }

}

class CadastroService {

    private Map<String, String> empresas;
    private Map<String, String> planos;
    private Map<String, Integer> limites;

    public CadastroService(Map<String, String> planos, Map<String, Integer> limites) {
        this.planos = planos;
        this.limites = limites;
        this.empresas = new HashMap<>();
    }

    public void cadastrarEmpresa(String nome, String email, String plano) throws LimitePlanoException {
        if (!email.contains("@") || !email.contains(".")) {
            throw new EmailInvalidoException(email);
        }
        if (empresas.containsKey(nome)) {
            throw new EmpresaJaCadastradaException(nome);
        }
        if (!planos.containsKey(plano)) {
            throw new PlanoInvalidoException(plano);
        }

        int count = 0;

        for (String p : empresas.values()) {
            if (p.equals(plano)) {
                count++;
            }
        }
        if (limites.get(plano) <= count) {
            throw new LimitePlanoException(plano, limites.get(plano), count);
        }
        empresas.put(nome, email);
    }
    
    public void listarEmpresas() {
        // listar empresas
        for (Map.Entry<String, String> entry : empresas.entrySet()) {
            System.out.println("Empresa: " + entry.getKey() + ", Email: " + entry.getValue());
        }
    }
}

class EmpresaJaCadastradaException extends RuntimeException {
    public EmpresaJaCadastradaException(String nome) {
        super("Empresa já cadastrada: " + nome);
    }
}

class EmailInvalidoException extends RuntimeException {
    public EmailInvalidoException(String email) {
        super("Email inválido: " + email);
    }
}

class PlanoInvalidoException extends RuntimeException {
    public PlanoInvalidoException(String plano) {
        super("Plano inválido: " + plano);
    }
}

class LimitePlanoException extends Exception {
    public LimitePlanoException(String plano, int limite, int atual) {
        super("Limite do plano " + plano + " atingido: " + atual + "/" + limite);
    }
}
