// ## Exercício 2 — Passagem por valor vs referência

// Sem rodar o código, diga o que será impresso e **por quê**:

// ```java
// public class Main {

//     public static void tentarDobrar(int numero) {
//         numero = numero * 2;
//     }

//     public static void dobrarArray(int[] arr) {
//         for (int i = 0; i < arr.length; i++) {
//             arr[i] = arr[i] * 2;
//         }
//     }

//     public static void main(String[] args) {
//         int x = 10;
//         tentarDobrar(x);
//         System.out.println(x);

//         int[] nums = {1, 2, 3};
//         dobrarArray(nums);
//         System.out.println(Arrays.toString(nums));
//     }
// }
// ```

// **Resposta:**
// O código vai imprimir:
// ```
// 10
// [2, 4, 6]
// ```
