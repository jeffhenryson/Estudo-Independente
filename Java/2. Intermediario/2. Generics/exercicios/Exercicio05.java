// ## Exercício 5 — Interface genérica Repository

// Implemente o padrão Repository com Generics:

// **Interface:**
// ```java
// interface Repositorio<T, ID> {
//     void salvar(T entidade);
//     T buscarPorId(ID id);
//     List<T> buscarTodos();
//     boolean deletar(ID id);
//     int total();
// }
// ```

// **Classe `Campanha`:**
// - Atributos: `int id`, `String nome`, `String plataforma`
// - Construtor + getters + toString

// **Classe `CampanhaRepositorio`** implements `Repositorio<Campanha, Integer>`:
// - Use `List<Campanha>` internamente
// - `salvar()` → adiciona na lista
// - `buscarPorId()` → busca por id com for-each, retorna null se não achar
// - `buscarTodos()` → retorna cópia da lista
// - `deletar()` → remove por id, retorna true se removeu
// - `total()` → retorna tamanho da lista

// No `main`:
// 1. Salve 3 campanhas
// 2. Busque por id existente e inexistente
// 3. Liste todas
// 4. Delete uma e liste novamente

import java.util.ArrayList;
import java.util.List;

public class Exercicio05 {
    public static void main(String[] args) {
        
        CampanhaRepositorio repositorio = new CampanhaRepositorio();

        // 1. Salve 3 campanhas
        repositorio.salvar(new Campanha(1, "Campanha A", "Facebook"));
        repositorio.salvar(new Campanha(2, "Campanha B", "Google"));
        repositorio.salvar(new Campanha(3, "Campanha C", "Instagram"));

        // 2. Busque por id existente e inexistente
        System.out.println("Buscando por ID 2: " + repositorio.buscarPorId(2));
        System.out.println("Buscando por ID 5: " + repositorio.buscarPorId(5));

        // 3. Liste todas
        System.out.println("Todas as campanhas:");
        for (Campanha campanha : repositorio.buscarTodos()) {
            System.out.println(campanha);
        }

        // 4. Delete uma e liste novamente
        System.out.println("Deletando campanha com ID 2...");
        repositorio.deletar(2);

        System.out.println("Todas as campanhas após deleção:");
        for (Campanha campanha : repositorio.buscarTodos()) {
            System.out.println(campanha);
        }
    }
}

interface Repositorio<T, ID> {
    void salvar(T entidade);
    T buscarPorId(ID id);
    List<T> buscarTodos();
    boolean deletar(ID id);
    int total();
}

class Campanha {

    private int id;
    private String nome;
    private String plataforma;

    public Campanha(int id, String nome, String plataforma) {
        this.id = id;
        this.nome = nome;
        this.plataforma = plataforma;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPlataforma() {
        return plataforma;
    }

    @Override
    public String toString() {
        return "Campanha{id=" + id + ", nome='" + nome + "', plataforma='" + plataforma + "'}";
    }
}

class CampanhaRepositorio implements Repositorio<Campanha, Integer> {

    private List<Campanha> campanhas = new ArrayList<>();

    @Override
    public void salvar(Campanha entidade) {
        campanhas.add(entidade);
    }

    @Override
    public Campanha buscarPorId(Integer id) {
        for (Campanha campanha : campanhas) {
            if (campanha.getId() == id) {
                return campanha;
            }
        }
        return null;
    }

    @Override
    public List<Campanha> buscarTodos() {
        return new ArrayList<>(campanhas);
    }

    @Override
    public boolean deletar(Integer id) {
        return campanhas.removeIf(campanha -> campanha.getId() == id); 
    }

    @Override
    public int total() {
        return campanhas.size();
    }

}