## 1. O que são Packages (Pacotes)

Os pacotes em Java funcionam como pastas ou diretórios dentro do seu sistema de arquivos. O principal objetivo de um pacote é **organizar classes** relacionadas e evitar conflitos de nomes (por exemplo, ter duas classes chamadas `Cliente` em partes diferentes do projeto).

Por convenção, os pacotes são escritos em letras minúsculas, usando o padrão de domínios invertidos da empresa para garantir que sejam únicos globalmente (como `com.suaempresa.projeto`).

```java
package com.cerne.financeiro;

public class Conta {
    // Código da classe
}
```

> **Regra de Ouro:** A declaração de `package` deve ser sempre a **primeira linha** de código no seu arquivo `.java`, antes de qualquer importação.



---

## 2. O que são Imports (Importações)

Quando você precisa utilizar uma classe que está em um pacote **diferente** daquele onde você está trabalhando, você precisa importá-la. 

O Java possui uma biblioteca padrão extensa e, para não sobrecarregar a memória, as classes não são carregadas automaticamente (com exceção do pacote `java.lang`, que inclui classes fundamentais como `String` e `System`).

```java
package com.cerne.principal;

// Importa uma classe específica do pacote util
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
}
```

---

## 3. Utilização de Wildcards (`*`)

Quando você precisa usar várias classes de um mesmo pacote, você pode utilizar o caractere curinga (`*`) para importar todas as classes daquele diretório de uma só vez.

```java
// Importa todas as classes dentro do pacote java.util (Scanner, ArrayList, etc.)
import java.util.*;

public class Exemplo {
    List<String> lista = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
}
```

> **Boas Práticas:** Embora o uso do `*` seja prático, importar apenas as classes que você realmente utiliza deixa seu código mais legível e facilita a identificação das dependências da classe.

---

## 4. Importações Estáticas (`import static`)

A importação estática permite que você utilize membros estáticos (como métodos e constantes) de outra classe **sem precisar digitar o nome da classe** antes de chamá-los.

```java
package com.cerne;

// Importação estática do método Math.sqrt
import static java.lang.Math.sqrt;

public class Calculos {
    public void fazerCalculo() {
        // Antes: Math.sqrt(16);
        // Agora: 
        double resultado = sqrt(16);
    }
}
```

---
