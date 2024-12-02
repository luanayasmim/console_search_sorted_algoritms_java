package Search;

import Util.Util;

public class InterpolationSearch {
    public static void executar(){
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Executar Interpolation Search");
        System.out.println("2 - Ver Comparação de execuções de lista unificadas e não unificadas com interpolation e binary search");
        System.out.println("3 - Ver resposta da questão");
        var opcao = Integer.parseInt(System.console().readLine());

        switch (opcao){
            case 1:
                System.out.println("Array para buscar:");
                Integer[] numeros = { 10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47 };

                Util.imprimirArray(numeros);

                int alvo = 20;
                System.out.println("Valor Procurado: " + alvo);

                executarComTempo(numeros, alvo);
                break;
            case 2:
               exercicio();
                break;
            case 3:
                System.out.println("Identifique casos em que o Interpolation Search é mais eficiente que o Binary Search.");
                System.out.println("O interpolation search é mais eficiente para buscar em um array com elementos uniformemente distribuidos\n" +
                        "O tempo de execução é de  O(log2(log2 n))");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    public static void executarComTempo(Integer[] arr, int alvo){
        long tempoInicial = System.currentTimeMillis();
        int resultado = interpolationSearch(arr, 0, arr.length-1, alvo);

        Util.imprimir(resultado);

        long tempoFinal = System.currentTimeMillis()-tempoInicial;
        System.out.println("Tempo de execução em milisegundos "+tempoFinal);
    }

    private static void exercicio() {
        java.io.Console console = System.console();

        Integer[] numerosUniformes = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 }; // Lista Uniforme
        Integer[] numerosNaoUniformes = {1, 3, 5, 8, 19, 25, 86, 109, 214, 500}; //Lista não uniforme

        int alvo = 25;

        System.out.println("Lista Uniforme: ");
        Util.imprimirArray(numerosUniformes);
        System.out.println("Lista nao uniforme");
        Util.imprimirArray(numerosNaoUniformes);

        System.out.println("Valor procurado: "+alvo);

        System.out.println("Resultado com valores uniformes:");
        executarComTempo(numerosUniformes, alvo);

        System.out.println("Resultado com valores não uniformes:");
        executarComTempo(numerosNaoUniformes, alvo);

        System.out.println("Resultado com valores uniformes utilizando o Binary Search");
        BinarySearch.executarComTempo(numerosUniformes, alvo);

        System.out.println("Resultado com valores não uniformes utilizando o Binary Search:");
        BinarySearch.executarComTempo(numerosNaoUniformes, alvo);
    }

    private static int interpolationSearch(Integer[] arr, int inicio, int fim, int alvo) {
        int pos;

        if (inicio <= fim && alvo >= arr[inicio] && alvo <= arr[fim]) {
            pos = inicio + (((fim - inicio) / (arr[fim] - arr[inicio])) * (alvo - arr[inicio]));

            if (arr[pos] == alvo)
                return pos;

            if (arr[pos] < alvo)
                return interpolationSearch(arr, pos + 1, fim, alvo);

            if (arr[pos] > alvo)
                return interpolationSearch(arr, inicio, pos - 1, alvo);
        }
        return -1;
    }
}
