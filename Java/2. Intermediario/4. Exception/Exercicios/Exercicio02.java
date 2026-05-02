// ## Exercício 2 — throws e checked exceptions

// Crie um sistema de leitura de configuração:

// 1. Método `lerConfiguracao(String caminho) throws IOException` que:
//     - Se o caminho for `null` ou vazio → lança `IllegalArgumentException`
//     - Se o caminho não terminar com `".properties"` → lança `IllegalArgumentException`
//     - Simula leitura — se caminho for `"config.properties"` retorna `"host=localhost;porta=5432"`
//     - Qualquer outro caminho → lança `IOException` com mensagem `"Arquivo não encontrado: [caminho]"`
// 2. No `main`, chame o método com 4 cenários diferentes e trate cada exceção separadamente

import java.io.IOException;

public class Exercicio02 {

    public static void main(String[] args) {
        // Cenário 1: Caminho nulo
        try {
            lerConfiguracao(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro de IO: " + e.getMessage());
        }

        // Cenário 2: Caminho vazio
        try {
            lerConfiguracao("");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro de IO: " + e.getMessage());
        }

        // Cenário 3: Caminho sem extensão .properties
        try {
            lerConfiguracao("config.txt");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro de IO: " + e.getMessage());
        }

        // Cenário 4: Caminho correto
        try {
            String config = lerConfiguracao("config.properties");
            System.out.println("Configuração lida: " + config);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro de IO: " + e.getMessage());
        }
    }

    public static String lerConfiguracao(String caminho) throws IOException {
        if (caminho == null || caminho.isEmpty()) {
            throw new IllegalArgumentException("Caminho não pode ser nulo ou vazio.");
        }
        if (!caminho.endsWith(".properties")) {
            throw new IllegalArgumentException("Caminho deve terminar com '.properties'.");
        }
        if ("config.properties".equals(caminho)) {
            return "host=localhost;porta=5432";
        }
        throw new IOException("Arquivo não encontrado: " + caminho);
    }
}

