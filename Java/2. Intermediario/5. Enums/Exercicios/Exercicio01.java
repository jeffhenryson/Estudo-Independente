// ## Exercício 1 — Enum básico

// Crie um enum `DiaSemana` com os 7 dias e:

// 1. Imprima todos os valores com `values()` e seus `ordinal()`
// 2. Converta a String `"QUARTA"` para enum com `valueOf()`
// 3. Tente converter `"quarta"` e trate o `IllegalArgumentException`
// 4. Use switch moderno para classificar o dia como `"Dia útil"` ou `"Fim de semana"`
// 5. Imprima o `name()` e `ordinal()` de cada dia

public class Exercicio01{
    public static void main(String[] args) {
 
        // 1. Imprima todos os valores com `values()` e seus `ordinal()`
        System.out.println("Dias da semana:");
        for (DiaSemana dia : DiaSemana.values()) {
            System.out.println(dia + " - Ordinal: " + dia.ordinal());
        }

        // 2. Converta a String "QUARTA" para enum com `valueOf()`
        DiaSemana quarta = DiaSemana.valueOf("QUARTA");
        System.out.println("\nConvertido 'QUARTA' para enum: " + quarta);

        // 3. Tente converter "quarta" e trate o `IllegalArgumentException`
        try {
            DiaSemana quartaMinuscula = DiaSemana.valueOf("quarta");
            System.out.println("Convertido 'quarta' para enum: " + quartaMinuscula);
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro ao converter 'quarta': " + e.getMessage());
        }

        // 4. Use switch moderno para classificar o dia como "Dia útil" ou "Fim de semana"
        System.out.println("\nClassificação dos dias:");
        for (DiaSemana dia : DiaSemana.values()) {
            String classificacao = switch (dia) {
                case SÁBADO, DOMINGO -> "Fim de semana";
                default -> "Dia útil";
            };
            System.out.println(dia + ": " + classificacao);
        }

        // 5. Imprima o `name()` e `ordinal()` de cada dia
        System.out.println("\nNome e ordinal de cada dia:");
        for (DiaSemana dia : DiaSemana.values()) {
            System.out.println("Nome: " + dia.name() + ", Ordinal: " + dia.ordinal());
        }
    }
}

enum DiaSemana {
    DOMINGO,
    SEGUNDA,
    TERÇA,
    QUARTA,
    QUINTA,
    SEXTA,
    SÁBADO
}