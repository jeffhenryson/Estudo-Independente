// ## Exercício 3 — Lambda como parâmetro

// Crie a functional interface:

// ```java
// @FunctionalInterface
// interface FiltroRelatorio {
//     boolean aceitar(String campanha, double roi, String plataforma);
// }
// ```

// Crie o método:
// ```java
// static List<String> filtrarCampanhas(
//     List<String> nomes,
//     List<Double> rois,
//     List<String> plataformas,
//     FiltroRelatorio filtro
// )
// ```

// No `main`, chame o método com os seguintes filtros via lambda:
// 1. Só campanhas com ROI > 50
// 2. Só campanhas da plataforma `"Meta Ads"`
// 3. Campanhas com ROI positivo E plataforma `"Google Ads"`
// 4. Campanhas cujo nome contém `"Black"`

import java.util.List;
import java.util.ArrayList;

public class Exercicio03 {
    public static void main(String[] args) {
        
        List<String> nomes = List.of("Campanha Black Friday", "Meta Remarketing", "Google Awareness", "Black Meta", "Google ROI");
        List<Double> rois = List.of(60.0, 45.0, 10.0, 70.0, -5.0);
        List<String> plataformas = List.of("Meta Ads", "Meta Ads", "Google Ads", "Meta Ads", "Google Ads");

        // 1. Só campanhas com ROI > 50
        System.out.println("Campanhas com ROI > 50: " + filtrarCampanhas(nomes, rois, plataformas, (campanha, roi, plataforma) -> roi > 50));

        // 2. Só campanhas da plataforma 'Meta Ads'
        System.out.println("Campanhas da plataforma 'Meta Ads': " + filtrarCampanhas(nomes, rois, plataformas, (campanha, roi, plataforma) -> plataforma.equals("Meta Ads")));

        // 3. Campanhas com ROI positivo E plataforma 'Google Ads'
        System.out.println("Campanhas com ROI positivo e plataforma 'Google Ads': " + filtrarCampanhas(nomes, rois, plataformas, (campanha, roi, plataforma) -> roi > 0 && plataforma.equals("Google Ads")));

        // 4. Campanhas cujo nome contém 'Black'
        System.out.println("Campanhas cujo nome contém 'Black': " + filtrarCampanhas(nomes, rois, plataformas, (campanha, roi, plataforma) -> campanha.contains("Black")));
    }

    static List<String> filtrarCampanhas(
        List<String> nomes,
        List<Double> rois,
        List<String> plataformas,
        FiltroRelatorio filtro
    ) {
        List<String> resultado = new ArrayList<>();
        for (int i = 0; i < nomes.size(); i++) {
            if (filtro.aceitar(nomes.get(i), rois.get(i), plataformas.get(i))) {
                resultado.add(nomes.get(i));
            }
        }
        return resultado;
    }
}

@FunctionalInterface
interface FiltroRelatorio {
    boolean aceitar(String campanha, double roi, String plataforma);
}