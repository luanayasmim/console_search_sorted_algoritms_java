package Search;

import Util.Util;

public class BinarySearch {
    public static void executar(){
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Executar Binary Search");
        System.out.println("2 - Ver resposta da questão");
        var opcao = Integer.parseInt(System.console().readLine());

        switch (opcao){
            case 1:
                System.out.println("Array para buscar:");
                Integer[] arr = { 2, 3, 4, 10, 40 };
                Util.imprimirArray(arr);

                int alvo = 10;
                System.out.println("Valor Procurado: " + alvo);
                int resultado = binarySearch(arr, 0, arr.length - 1, alvo);

                Util.imprimir(resultado);
                break;
            case 2:
                System.out.println("Explique por que a lista deve estar ordenada para que o Binary Search funcione corretamente. Forneça exemplos.");
                System.out.println("Resposta:");
                System.out.println("A lista deve estar ordenada para a lógica do binary search funcionar corretamente,\n pois ele divide o array em duas partes e compara o meio para verificar se o valor procurado é igual aquele meio, \nse for maior ele pega os elementos da segunda parte e divide novamente até encontrar.\n Da mesma forma que se for menor ele pega os elementos da primeira parte para procurar. \nSe o array estiver desordenado essa lógica não funciona.");
                break;
            default:
                System.out.println("Opção inválida");
        }

    }

    public static void executarComTempo(Integer[] numeros, int alvo){
        long tempoInicial = System.currentTimeMillis();

        int resultado = binarySearch(numeros, 0, numeros.length-1, alvo);

        Util.imprimir(resultado);

        long tempoFinal = System.currentTimeMillis()-tempoInicial;
        System.out.println("Tempo de execucao: "+tempoFinal);
    }

    public static int binarySearch(Integer[] arr, int inicio, int fim, int alvo){
        if (fim >= inicio) {
            int mid = inicio + (fim - inicio) / 2;

            if (arr[mid] == alvo)
                return mid;

            if (arr[mid] > alvo)
                return binarySearch(arr, inicio, mid - 1, alvo);

            return binarySearch(arr, mid + 1, fim, alvo);
        }

        return -1;
    }
}
