// ## Exercício 5 — Conversão

// 1. Crie um array `String[]` com 4 plataformas de anúncio
// 2. Converta para `ArrayList` usando `Arrays.asList()`
// 3. Imprima a lista
// 4. Extraia um `subList()` com os 2 primeiros elementos
// 5. Converta o ArrayList de volta para array com `toArray()`
// 6. Imprima o array final com `Arrays.toString()`

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicio05 {
    public static void main(String[] args) {
        
        // 1. Criar um array de String com 4 plataformas de anúncio
        String[] plataformas = {"Google Ads", "Facebook Ads", "LinkedIn Ads", "Twitter Ads"};

        // 2. Converter para ArrayList usando Arrays.asList()
        List<String> listaPlataformas = new ArrayList<>(Arrays.asList(plataformas));

        // 3. Imprimir a lista
        System.out.println("Lista de plataformas: " + listaPlataformas);

        // 4. Extrair um subList() com os 2 primeiros elementos
        List<String> subLista = listaPlataformas.subList(0, 2);
        System.out.println("Sublista (2 primeiros elementos): " + subLista);

        // 5. Converter o ArrayList de volta para array com toArray()
        String[] arrayFinal = subLista.toArray(new String[0]);

        // 6. Imprimir o array final com Arrays.toString()
        System.out.println("Array final: " + Arrays.toString(arrayFinal));
    }
}
