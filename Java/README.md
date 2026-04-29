Java
----
Este diretório já contém exercícios e conteúdos da linguagem de programação Java, frameworks e ferramentas. Servirá como base para estudos adicionais.

Sugestões de conteúdo adicional:
- Explanations e comentários para cada exercício
- Novos exercícios para estruturas de dados, padrões de projeto, e APIs

----

<a href="https://ibb.co/jP5ckRxg"><img src="https://i.ibb.co/zT5yVJLG/java-roadmap.gif" alt="java-roadmap" border="0"></a>

<aside>

| **Conceito** | **Nível** | **Status** |
| --- | --- | --- |
| **Fundamentos** |  | ✅ |
| Sintaxe básica, tipos primitivos e operadores | Iniciante | ✅ |
| Variáveis, constantes e escopo | Iniciante | ✅ |
| Condicionais (if, switch) | Iniciante | ✅ |
| Loops (for, while, do-while, for-each) | Iniciante | ✅ |
| Arrays e Strings | Iniciante | ✅ |
| Métodos e sobrecarga | Iniciante | ✅ |
| Packages e imports**novo** | Iniciante | ✅ |
| Orientação a objetos: classes, objetos, construtores | Iniciante | ✅ |
| Encapsulamento, herança e polimorfismo | Iniciante | ✅ |
| Interfaces e classes abstratas | Iniciante | ✅ |
| **Intermediário — Estruturas e APIs** |  |  |
| Coleções: List, Set, Map, Queue | Intermediário | ✅ |
| Generics | Intermediário | 🟨 |
| Iterators e Iterables | Intermediário | 🔲 |
| Exceções: checked, unchecked, custom | Intermediário | 🔲 |
| Enums | Intermediário | 🔲 |
| Records (Java 16+) | Intermediário | 🔲 |
| Sealed classes (Java 17+) | Intermediário | 🔲 |
| Lambdas e expressões funcionais | Intermediário | 🔲 |
| Stream API (filter, map, reduce, collect) | Intermediário | 🔲 |
| Optional | Intermediário | 🔲 |
| Functional interfaces (Predicate, Function, Consumer, Supplier) | Intermediário | 🔲 |
| Method references | Intermediário | 🔲 |
| Anotações (@Override, @FunctionalInterface, custom) | Intermediário | 🔲 |
| Date/Time API (java.time) | Intermediário | 🔲 |
| I/O: leitura e escrita de arquivos | Intermediário | 🔲 |
| Serialização de objetos**novo** | Intermediário | 🔲 |
| Trabalhando com JSON (Jackson / Gson) | Intermediário | 🔲 |
| **Avançado — Como Java funciona (JVM internals)** |  |  |
| JVM: bytecode, class loader, runtime | Avançado | 🔲 |
| Garbage Collection e gerenciamento de memória | Avançado | 🔲 |
| JIT compiler e otimizações da JVM | Avançado | 🔲 |
| Reflection API | Avançado | 🔲 |
| Proxy dinâmico e instrumentação | Avançado | 🔲 |
| Classloaders e isolamento de módulos | Avançado | 🔲 |
| Module system (Java 9+ JPMS) | Avançado | 🔲 |
</aside>

---

<aside>

## Estudo **Build Tools 🔧**

| **Conceito** | **Nível** | **Status** |
| --- | --- | --- |
| **Fundamentos** |  |  |
| Estrutura de projeto (src/main, src/test) | Iniciante | 🔲 |
| pom.xml vs build.gradle | Iniciante | 🔲 |
| Gerenciamento de dependências | Iniciante | 🔲 |
| Ciclo de vida: compile, test, package, install | Iniciante | 🔲 |
| **Intermediário** |  |  |
| Scopes de dependência (compile, test, provided) | Intermediário | 🔲 |
| Plugins e goals personalizados | Intermediário | 🔲 |
| Repositórios locais e remotos (Maven Central, Nexus) | Intermediário | 🔲 |
| Multi-module projects | Intermediário | 🔲 |
| **Avançado** |  |  |
| Profiles Maven | Avançado | 🔲 |
| Build com Gradle (Groovy ou Kotlin DSL) | Avançado | 🔲 |
| Publicar artefatos em repositório | Avançado | 🔲 |
</aside>

---

<aside>

## Estudo **Spring Boot 🌱**

| **Conceito** | **Nível** | **Status** |
| --- | --- | --- |
| **Fundamentos** |  |  |
| Conceitos de IoC e Injeção de Dependência | Iniciante | 🔲 |
| Estrutura de projeto Spring Boot | Iniciante | 🔲 |
| @SpringBootApplication, @Component, @Service, @Repository | Iniciante | 🔲 |
| REST Controllers e mapeamento de rotas | Iniciante | 🔲 |
| Request body, path params e query params | Iniciante | 🔲 |
| Response entities e status codes | Iniciante | 🔲 |
| Validação com Bean Validation (@Valid, @NotNull, etc) | Iniciante | 🔲 |
| application.properties / application.yml | Iniciante | 🔲 |
| **Intermediário** |  |  |
| Spring Data JPA (repositórios, queries, paginação) | Intermediário | 🔲 |
| Relacionamentos com JPA (OneToMany, ManyToMany) | Intermediário | 🔲 |
| Migrations com Flyway ou Liquibase | Intermediário | 🔲 |
| Spring Security: autenticação e autorização | Intermediário | 🔲 |
| JWT com Spring Security | Intermediário | 🔲 |
| Exception handling global (@ControllerAdvice) | Intermediário | 🔲 |
| Profiles (dev, prod, test) | Intermediário | 🔲 |
| Agendamento de tarefas (@Scheduled) | Intermediário | 🔲 |
| Eventos de aplicação (ApplicationEvent) | Intermediário | 🔲 |
| **Avançado** |  |  |
| WebFlux e programação reativa (Reactor) | Avançado | 🔲 |
| Cache com Redis e @Cacheable | Avançado | 🔲 |
| Testes com @SpringBootTest, MockMvc, Testcontainers | Avançado | 🔲 |
| Actuator e observabilidade (métricas, health, tracing) | Avançado | 🔲 |
| Rate limiting e throttling | Avançado | 🔲 |
| Deploy com Docker + Spring Boot | Avançado | 🔲 |
| Estrutura de projetos grandes (módulos, DDD) | Avançado | 🔲 |
| GraalVM Native Image | Avançado | 🔲 |
</aside>

---

<aside>

## Estudo **Hibernate / JPA 🔗**

| **Conceito** | **Nível** | **Status** |
| --- | --- | --- |
| **Fundamentos** |  |  |
| Conceito de ORM e mapeamento objeto-relacional | Iniciante | 🔲 |
| @Entity, @Table, @Column, @Id | Iniciante | 🔲 |
| EntityManager e operações CRUD | Iniciante | 🔲 |
| Configuração com persistence.xml ou Spring | Iniciante | 🔲 |
| Migrations com Flyway | Iniciante | 🔲 |
| **Intermediário** |  |  |
| Relacionamentos: @OneToMany, @ManyToOne, @ManyToMany | Intermediário | 🔲 |
| Lazy vs Eager loading | Intermediário | 🔲 |
| JPQL e Criteria API | Intermediário | 🔲 |
| Herança no banco (@Inheritance) | Intermediário | 🔲 |
| Transações e @Transactional | Intermediário | 🔲 |
| Lifecycle callbacks (@PrePersist, @PostLoad, etc) | Intermediário | 🔲 |
| **Avançado** |  |  |
| N+1 problem e como evitar (fetch joins, batch size) | Avançado | 🔲 |
| Second-level cache | Avançado | 🔲 |
| Connection pooling (HikariCP) | Avançado | 🔲 |
| Query optimization e explain | Avançado | 🔲 |
| Projections e DTOs em queries | Avançado | 🔲 |
</aside>

---

<aside>

## Estudo **Logging 📋**

| **Conceito** | **Nível** | **Status** |
| --- | --- | --- |
| **Fundamentos** |  |  |
| Níveis de log: DEBUG, INFO, WARN, ERROR**novo** | Iniciante | 🔲 |
| java.util.logging (JUL) — logging nativo**novo** | Iniciante | 🔲 |
| **Bibliotecas de logging** |  |  |
| SLF4J — facade de logging | Intermediário | 🔲 |
| Logback — implementação padrão com Spring | Intermediário | 🔲 |
| Log4j2 — alternativa de alta performance**novo** | Intermediário | 🔲 |
| Configuração via logback.xml / log4j2.xml**novo** | Intermediário | 🔲 |
| **Logging em produção** |  |  |
| MDC (Mapped Diagnostic Context) para rastreio**novo** | Avançado | 🔲 |
| Log estruturado (JSON) para observabilidade**novo** | Avançado | 🔲 |
| Integração com Spring Boot Actuator**novo** | Avançado | 🔲 |
</aside>

---

<aside>

## Estudo **Concorrência ⚡**

| **Conceito** | **Nível** | **Status** |
| --- | --- | --- |
| **Fundamentos de Threads** |  |  |
| Threads e Runnable | Intermediário | 🔲 |
| Ciclo de vida de uma thread**novo** | Intermediário | 🔲 |
| synchronized, locks e volatile | Intermediário | 🔲 |
| wait(), notify() e notifyAll()**novo** | Intermediário | 🔲 |
| **Concorrência avançada** |  |  |
| ExecutorService e thread pools**novo** | Avançado | 🔲 |
| CompletableFuture e programação assíncrona | Avançado | 🔲 |
| java.util.concurrent (ConcurrentHashMap, BlockingQueue, etc)**novo** | Avançado | 🔲 |
| Virtual Threads (Java 21, Project Loom) | Avançado | 🔲 |
</aside>

---

<aside>

## Estudo **JDBC 🗄️**

| **Conceito** | **Nível** | **Status** |
| --- | --- | --- |
| **JDBC puro** |  |  |
| Conceito de JDBC e drivers**novo** | Intermediário | 🔲 |
| Connection, Statement e ResultSet**novo** | Intermediário | 🔲 |
| PreparedStatement e prevenção de SQL Injection**novo** | Intermediário | 🔲 |
| Transações com JDBC**novo** | Intermediário | 🔲 |
| Connection pooling básico (DataSource)**novo** | Intermediário | 🔲 |
| **Abstrações sobre JDBC** |  |  |
| Spring JDBC Template**novo** | Avançado | 🔲 |
| Jdbi3 — alternativa leve ao JPA**novo** | Avançado | 🔲 |
</aside>

---

<aside>

## Estudo **Testing 🧪**

| **Conceito** | **Nível** | **Status** |
| --- | --- | --- |
| **Testes unitários** |  |  |
| JUnit 5: anotações, assertions, ciclo de vida | Intermediário | 🔲 |
| Mockito: mocks, stubs e verify | Intermediário | 🔲 |
| Testes com exceções e edge cases**novo** | Intermediário | 🔲 |
| Parametrized tests (JUnit 5)**novo** | Intermediário | 🔲 |
| **Testes de integração e carga** |  |  |
| Testes com @SpringBootTest e MockMvc | Avançado | 🔲 |
| Testcontainers — banco real em testes | Avançado | 🔲 |
| Rest Assured — testes de API REST**novo** | Avançado | 🔲 |
| JMeter — testes de carga e performance**novo** | Avançado | 🔲 |
</aside>

---

<aside>

## Estudo **Profiling 📊**

| **Conceito** | **Nível** | **Status** |
| --- | --- | --- |
| **Ferramentas** |  |  |
| JMH — microbenchmarks precisos em Java | Avançado | 🔲 |
| VisualVM — análise de heap e threads em tempo real | Avançado | 🔲 |
| Java Flight Recorder (JFR) + JDK Mission Control**novo** | Avançado | 🔲 |
| Análise de GC logs**novo** | Avançado | 🔲 |
| Detecção de memory leaks e heap dumps**novo** | Avançado | 🔲 |
</aside>

---
