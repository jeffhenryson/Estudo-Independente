// ## Exercício 6 — Desafio

// Construa um sistema de relatório de performance de campanhas do **Cerne**:

// **Estrutura:**
// - `Map<String, Double>` → campanha e seu ROI
// - `Map<String, List<String>>` → plataforma e suas campanhas
// - `Map<String, String>` → campanha e sua plataforma (índice reverso)

// **Menu `do-while`:**
// 1. Cadastrar campanha → lê nome, plataforma e ROI
//    - Adiciona nos três maps
//    - Bloqueia cadastro duplicado com `containsKey()`
// 2. Buscar campanha → lê nome e exibe plataforma e ROI
//    - Usa `getOrDefault()` para tratar campanha inexistente
// 3. Listar por plataforma → exibe o `Map<String, List<String>>` completo formatado
// 4. Relatório de performance → percorre o map de ROI e classifica:
//    - ROI < 0 → `"Crítico"`
//    - ROI 0–50 → `"Regular"`
//    - ROI > 50 → `"Ótimo"`
// 5. Estatísticas gerais:
//    - Total de campanhas cadastradas
//    - Campanha com maior ROI
//    - Campanha com menor ROI
//    - ROI médio geral
// 0. Sair

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {

        Map<String, Double> campanhaROI = new HashMap<>(); // Campanha e seu ROI //Ex: "Campanha A" -> 25.0
        Map<String, List<String>> plataformaCampanhas = new HashMap<>(); // Plataforma e suas campanhas //Ex: "Google Ads" -> ["Campanha A", "Campanha B"]
        Map<String, String> campanhaPlataforma = new HashMap<>(); // Campanha e sua plataforma (índice reverso) //Ex: "Campanha A" -> "Google Ads"

        // Menu do-while
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar campanha");
            System.out.println("2. Buscar campanha");
            System.out.println("3. Listar por plataforma");
            System.out.println("4. Relatório de performance");
            System.out.println("5. Estatísticas gerais");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    // Cadastrar campanha
                    System.out.print("Nome da campanha: ");
                    String nomeCampanha = scanner.nextLine();
                    if (campanhaROI.containsKey(nomeCampanha)) {
                        System.out.println("Campanha já cadastrada!");
                        break;
                    }
                    System.out.print("Plataforma: ");
                    String plataforma = scanner.nextLine();
                    System.out.print("ROI: ");
                    double roi = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a nova linha

                    // Adicionar nos mapas
                    campanhaROI.put(nomeCampanha, roi);
                    campanhaPlataforma.put(nomeCampanha, plataforma);
                    plataformaCampanhas.computeIfAbsent(plataforma, k -> new ArrayList<>()).add(nomeCampanha);
                    break;

                case 2:
                    // Buscar campanha
                    System.out.print("Nome da campanha: ");
                    String buscaCampanha = scanner.nextLine();
                    String plataformaEncontrada = campanhaPlataforma.getOrDefault(buscaCampanha,
                            "Campanha não encontrada");
                    Double roiEncontrado = campanhaROI.getOrDefault(buscaCampanha, null);
                    if (roiEncontrado != null) {
                        System.out.println("Plataforma: " + plataformaEncontrada);
                        System.out.println("ROI: " + roiEncontrado);
                    } else {
                        System.out.println(plataformaEncontrada);
                    }
                    break;

                case 3:
                    // Listar por plataforma
                    for (Map.Entry<String, List<String>> entry : plataformaCampanhas.entrySet()) {
                        System.out.println("Plataforma: " + entry.getKey());
                        System.out.println("Campanhas: " + entry.getValue());
                    }
                    break;
                case 4:
                    // Relatório de performance
                    for (Map.Entry<String, Double> entry : campanhaROI.entrySet()) {
                        String classificacao;
                        if (entry.getValue() < 0) {
                            classificacao = "Crítico";
                        } else if (entry.getValue() <= 50) {
                            classificacao = "Regular";
                        } else {
                            classificacao = "Ótimo";
                        }
                        System.out.println("Campanha: " + entry.getKey() + " - ROI: " + entry.getValue()
                                + " - Classificação: " + classificacao);
                    }
                    break;
                case 5:
                    // Estatísticas gerais
                    int totalCampanhas = campanhaROI.size();
                    String campanhaMaiorROI = null;
                    String campanhaMenorROI = null;
                    double maiorROI = Double.NEGATIVE_INFINITY;
                    double menorROI = Double.POSITIVE_INFINITY;
                    double somaROI = 0;
                    for (Map.Entry<String, Double> entry : campanhaROI.entrySet()) {
                        double valorROI = entry.getValue();
                        somaROI += valorROI;
                        if (valorROI > maiorROI) {
                            maiorROI = valorROI;
                            campanhaMaiorROI = entry.getKey();
                        }
                        if (valorROI < menorROI) {
                            menorROI = valorROI;
                            campanhaMenorROI = entry.getKey();
                        }
                    }
                    double mediaROI = totalCampanhas > 0 ? somaROI / totalCampanhas : 0;
                    System.out.println("Total de campanhas cadastradas: " + totalCampanhas);
                    System.out.println("Campanha com maior ROI: " + campanhaMaiorROI + " - ROI: " + maiorROI);
                    System.out.println("Campanha com menor ROI: " + campanhaMenorROI + " - ROI: " + menorROI);
                    System.out.println("ROI médio geral: " + mediaROI);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
