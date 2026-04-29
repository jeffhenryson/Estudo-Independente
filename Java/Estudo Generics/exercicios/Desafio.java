// ## Exercício 6 — Desafio

// Construa um sistema genérico de cache simples para o **Cerne**:

// **Classe `Cache<K, V>`:**
// - Use `Map<K, V>` internamente
// - Atributo `int capacidadeMaxima`
// - Métodos:
//   - `put(K chave, V valor)` → adiciona no cache
//     - Se atingir capacidade máxima, remove a entrada mais antiga
//   - `get(K chave)` → retorna o valor ou `null`
//   - `contem(K chave)` → retorna boolean
//   - `remover(K chave)` → remove entrada
//   - `tamanho()` → retorna quantidade de entradas
//   - `listar()` → imprime todas as entradas formatadas

// **Restrição:** use `LinkedHashMap` internamente — ele mantém ordem de inserção, o que permite saber qual é a entrada mais antiga.

// No `main`, crie três caches com tipos diferentes:

// ```java
// // Cache de sessões de usuário
// Cache<String, String> cacheSessoes = new Cache<>(3);
// cacheSessoes.put("token-abc", "jeff@cerne.com");
// cacheSessoes.put("token-def", "ana@cerne.com");
// cacheSessoes.put("token-ghi", "bob@cerne.com");
// cacheSessoes.put("token-jkl", "carlos@cerne.com"); // deve remover o mais antigo

// // Cache de preços de planos
// Cache<String, Double> cachePrecos = new Cache<>(2);
// cachePrecos.put("pro", 149.90);
// cachePrecos.put("enterprise", 499.90);

// // Cache de configurações
// Cache<String, Integer> cacheConfig = new Cache<>(5);
// cacheConfig.put("timeout", 3000);
// cacheConfig.put("maxUsuarios", 50);
// ```

import java.util.LinkedHashMap;
import java.util.Map;

public class Desafio {
    public static void main(String[] args) {

        // Cache de sessões de usuário
        Cache<String, String> cacheSessoes = new Cache<>(3);
        cacheSessoes.put("token-abc", "jeff@cerne.com");
        cacheSessoes.put("token-def", "ana@cerne.com");
        cacheSessoes.put("token-ghi", "bob@cerne.com");
        cacheSessoes.put("token-jkl", "carlos@cerne.com"); // deve remover o mais antigo

        // Verificando o conteúdo do cache de sessões
        System.out.println("Cache de Sessões:");
        cacheSessoes.listar();

        // Verificando se um token específico está no cache
        System.out.println("\nContém token-abc? " + cacheSessoes.contem("token-abc")); // false
        System.out.println("\nContém token-def? " + cacheSessoes.contem("token-def")); // true

        // Removendo um token e verificando novamente
        cacheSessoes.remover("token-def");
        System.out.println("\nApós remover token-def:");
        cacheSessoes.listar();

        // Retorna a quantidade de entradas no cache
        System.out.println("\nTamanho do cache de sessões: " + cacheSessoes.tamanho());

        // Retorna o valor associado à chave 
        System.out.println("\nValor do token-def: " + cacheSessoes.get("token-def")); // null
        System.out.println("\nValor do token-jkl: " + cacheSessoes.get("token-jkl")); 

        // Cache de preços de planos
        Cache<String, Double> cachePrecos = new Cache<>(2);
        cachePrecos.put("pro", 149.90);
        cachePrecos.put("enterprise", 499.90);

        // Verificando o conteúdo do cache de preços
        System.out.println("\nCache de Preços:");
        cachePrecos.listar();

        // Verificando se um conteúdo específico está no cache
        System.out.println("\nContém 'pro'? " + cachePrecos.contem("pro")); // true
        System.out.println("\nContém 'starter'? " + cachePrecos.contem("starter")); // false

        // Removendo um token e verificando novamente
        cachePrecos.remover("pro");
        System.out.println("\nApós remover 'pro':");
        cachePrecos.listar();

        // Retorna a quantidade de entradas no cache
        System.out.println("\nTamanho do cache de preços: " + cachePrecos.tamanho());

        // Retorna o valor associado à chave 
        System.out.println("\nValor do 'enterprise': " + cachePrecos.get("pro")); // null
        System.out.println("\nValor do 'enterprise': " + cachePrecos.get("enterprise")); 

        // Cache de configurações
        Cache<String, Integer> cacheConfig = new Cache<>(5);
        cacheConfig.put("timeout", 3000);
        cacheConfig.put("maxUsuarios", 50);

        // Verificando o conteúdo do cache de configurações
        System.out.println("\nCache de Configurações:");
        cacheConfig.listar();

        // Verificando se um conteúdo específico está no cache
        System.out.println("\nContém 'timeout'? " + cacheConfig.contem("timeout")); // true
        System.out.println("\nContém 'minUsuarios'? " + cacheConfig.contem("minUsuarios")); // false

        // Removendo um token e verificando novamente
        cacheConfig.remover("timeout");
        System.out.println("\nApós remover 'timeout':");
        cacheConfig.listar();

        // Retorna a quantidade de entradas no cache
        System.out.println("\nTamanho do cache de configurações: " + cacheConfig.tamanho());
        
        // Retorna o valor associado à chave 
        System.out.println("\nValor do 'timeout': " + cacheConfig.get("timeout")); // null
        System.out.println("\nValor do 'maxUsuarios': " + cacheConfig.get("maxUsuarios"));
        
        // Listando novamente para verificar o estado final dos caches
        System.out.println("\nEstado final dos caches:");
        System.out.println("Cache de Sessões:");
        cacheSessoes.listar();
        System.out.println("\nCache de Preços:");
        cachePrecos.listar();  
        System.out.println("\nCache de Configurações:");
        cacheConfig.listar();
    }
}

class Cache<K, V> {
    
    private LinkedHashMap<K, V> cache;
    private int capacidadeMaxima;

    // Construtor
    public Cache(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.cache = new LinkedHashMap<>();
    }

    // Adiciona no cache, removendo a entrada mais antiga se atingir a capacidade máxima
    public void put(K chave, V valor) {
        
        // Se a chave já existe, apenas atualiza o valor
        if (cache.containsKey(chave)) {
            cache.put(chave, valor);
            return;
        }

        // Se atingir a capacidade máxima, remove a entrada mais antiga
        if (cache.size() >= capacidadeMaxima) {
            // Remove a entrada mais antiga (primeira inserida)
            K chaveMaisAntiga = cache.keySet().iterator().next();
            cache.remove(chaveMaisAntiga);
        }
        cache.put(chave, valor);
    }

    // Retorna o valor associado à chave ou `null` se a chave não existir
    public V get(K chave) {
        return cache.get(chave);
    }

    // Retorna `true` se a chave existir no cache, caso contrário `false`
    public boolean contem(K chave) {
        return cache.containsKey(chave);
    }

    // Remove a entrada associada à chave
    public void remover(K chave) {
        cache.remove(chave);
    }

    // Retorna a quantidade de entradas no cache
    public int tamanho() {
        return cache.size();
    }

    // Imprime todas as entradas formatadas
    public void listar() {
        for (Map.Entry<K, V> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}