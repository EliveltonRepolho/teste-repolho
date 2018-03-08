# Respotas testes

1. **A**
2. **D**
3. **C**
4. **A**
5. **A**
6. **C**
7. **E**

8. Dados dois numeros inteiros A e B, crie um terceiro inteiro C....

    [Link do fonte completo](https://github.com/EliveltonRepolho/teste-repolho/blob/master/teste-2/src/main/java/com/repolho/numero/NumerosInteiros.java)
    
    ```java
        private static int calcularValorC(int a, int b) {
            final String[] c = {""};
            //Capturando qual dos 2 inteiros é o maior... String, quero percorrer char por char deste int
            String menor = String.valueOf(Math.min(a, b));
            String maior = String.valueOf(Math.max(a, b));
    
            String auxA = String.valueOf(a);
            String auxB = String.valueOf(b);
    
            final int[] ultimaPosicaoLida = {0};
    
            IntStream.range(0, menor.length())
                    .forEach((i) -> {
                        c[0] = c[0].concat(String.valueOf(auxA.charAt(i))).concat(String.valueOf(auxB.charAt(i)));
                        ultimaPosicaoLida[0]++;
                    });
    
            //Se tem diferença de tamanho, completar com os números restantes do maior
            if (auxA.length() != auxB.length())
                IntStream.range(ultimaPosicaoLida[0], maior.length())
                        .forEach((i) -> {
                            c[0] = c[0].concat(String.valueOf(maior.charAt(i)));
                        });
    
            //Confere o valor e retorna
            int intC = Integer.valueOf(c[0]);
            return intC > 1_000_000 ? -1 : intC;
        }
    ```

9. Desenvolva um método que dado um nó da árvore calcule a soma de todos os nós subsequentes

    [Link do fonte completo](https://github.com/EliveltonRepolho/teste-repolho/blob/master/teste-2/src/main/java/com/repolho/arvore/BinaryTreeCalc.java)
    
    ```java
        private int calcRecursive(BinaryTree from, int value, Integer sum) {
            sum += from.value;
    
            if(from.left != null)
                sum = calcRecursive(from.left, value, sum);
    
            if(from.right != null)
                sum = calcRecursive(from.right, value, sum);
    
            return sum;
        }
    ```