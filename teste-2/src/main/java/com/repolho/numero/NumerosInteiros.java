package com.repolho.numero;

import java.util.stream.IntStream;

/**
 * Created by repolhoe on 07/03/2018.
 */
class NumerosInteiros {

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

    public static int executarCalculo(int a, int b){
        System.out.printf("Valores: A: %d, B: %d -> ", a, b);
        int c = calcularValorC(a, b);
        System.out.printf("Resultado: C: %d \n", c);
        return c;
    }

    public static void main(String[] args) {
        executarCalculo(10256, 512);  // = 15012256 :: -1
        executarCalculo(10, 20);      // = 1200
        executarCalculo(987, 123456); // = 918273456 :: -1
        executarCalculo(987, 123);    // = 918273
    }
}