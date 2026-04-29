// ## Exercício 1 — HashMap básico

// Crie um `HashMap<String, Double>` com os planos do **Cerne** e:

// 1. Adicione `starter`, `pro` e `enterprise` com seus preços
// 2. Imprima todos com `entrySet()` formatado com `printf`
// 3. Busque o preço de `"pro"` com `get()`
// 4. Tente buscar `"vip"` com `get()` e depois com `getOrDefault()`
// 5. Atualize o preço do `"pro"` com `put()` e confirme
// 6. Verifique se a chave `"starter"` existe com `containsKey()`
// 7. Verifique se o valor `499.90` existe com `containsValue()`
// 8. Remova `"starter"` e imprima o mapa final

import java.util.HashMap;
import java.util.Map;

public class Exercicio01 {
    public static void main(String[] args) {

        Map<String, Double> planos = new HashMap<>();
        planos.put("starter", 199.90);
        planos.put("pro", 299.90);
        planos.put("enterprise", 499.90);

        System.out.println("Planos do Cerne:");
        for (Map.Entry<String, Double> entry : planos.entrySet()) {
            System.out.printf("%s: R$ %.2f%n", entry.getKey(), entry.getValue());
        }

        Double precoPro = planos.get("pro");
        System.out.printf("\nPreço do plano 'pro': R$ %.2f%n", precoPro);

        Double precoVip = planos.get("vip");
        System.out.printf("\nPreço do plano 'vip' (get): %s%n", precoVip);
        
        Double precoVipDefault = planos.getOrDefault("vip", 0.0);
        System.out.printf("Preço do plano 'vip' (getOrDefault): R$ %.2f%n", precoVipDefault);

        planos.put("pro", 349.90);
        System.out.printf("\nNovo preço do plano 'pro': R$ %.2f%n", planos.get("pro"));

        boolean hasStarter = planos.containsKey("starter");
        System.out.printf("\nO plano 'starter' existe? %b%n", hasStarter);

        boolean has49990 = planos.containsValue(499.90);
        System.out.printf("Existe um plano com preço R$ 499.90? %b%n", has49990);

        planos.remove("starter");
        System.out.println("\nPlanos após remover 'starter':");
        for (Map.Entry<String, Double> entry : planos.entrySet()) {
            System.out.printf("%s: R$ %.2f%n", entry.getKey(), entry.getValue());
        }
    }
}
