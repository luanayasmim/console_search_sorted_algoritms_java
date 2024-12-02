package Sort;

import Util.Util;

public class MergeSort {
    public static void executar(){
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Executar Merge Sort para inteiros");
        System.out.println("2 - Executar Merge Sort para string");
        System.out.println("3 - Ver resposta da questão");
        var opcao = Integer.parseInt(System.console().readLine());

        switch (opcao){
            case 1:
                executarParaInteger();
                break;
            case 2:
                executarParaString();
                break;
            case 3:
                System.out.println("Explique o conceito de \"dividir para conquistar\" usado nesse algoritmo");
                System.out.println("Resposta:");
                System.out.println("Funciona dividindo recursivamente o array de entrada em subarrays menores e ordenando esses subarrays e em seguida mesclando-os novamente para obter o array ordenado");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    public static void executarParaInteger(){
        Integer[] numeros = {12, 11, 13, 5, 6, 7};
        Util.imprimirArray(numeros);

        sort(numeros, 0, numeros.length-1);

        Util.imprimirArray(numeros);
    }

    public static void executarParaString() {
        String[] palavras = {"banana", "abacaxi", "uva", "laranja", "manga", "kiwi"};
        Util.imprimirArray(palavras);

        sort(palavras, 0, palavras.length - 1);

        Util.imprimirArray(palavras);
    }

    //region Merge sort para valores inteiros
    private static void sort(Integer[] arr, int inicio, int fim){
        if(inicio < fim){
            //Encontra o meio
            int meio = inicio + (fim - inicio)/2;

            //Divide as metades
            sort(arr, inicio, meio);
            sort(arr, meio+1, fim);

            // Faz o merge das metades ordenadas
            merge(arr, inicio, meio, fim);
        }
    }

    private static void merge(Integer[] arr, int inicio, int meio, int fim){
        //Encontra os lados dos subarrays para fazer o merge
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        //Cria arrays temporários
        int[] parte1 = new int[n1];
        int[] parte2 = new int[n2];

        //Copia os dados para os arrays temporários
        for (int i = 0; i < n1; ++i)
            parte1[i] = arr[inicio + i];

        for (int i = 0; i < n2; ++i)
            parte2[i] = arr[meio+1+i];

        int i = 0, j = 0, k=inicio;

        while(i < n1 && j < n2){
            if (parte1[i] <= parte2[j]) {
                arr[k] = parte1[i];
                i++;
            }
            else {
                arr[k] = parte2[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k] = parte1[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = parte2[j];
            j++;
            k++;
        }
    }
    //endregion

    private static void sort(String[] arr, int inicio, int fim){
        if(inicio < fim){
            //Encontra o meio
            int meio = inicio + (fim - inicio)/2;

            //Divide as metades
            sort(arr, inicio, meio);
            sort(arr, meio+1, fim);

            // Faz o merge das metades ordenadas
            merge(arr, inicio, meio, fim);
        }
    }

    private static void merge(String[] arr, int inicio, int meio, int fim){
        //Encontra os lados dos subarrays para fazer o merge
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        //Cria arrays temporários
        String[] parte1 = new String[n1];
        String[] parte2 = new String[n2];

        //Copia os dados para os arrays temporários
        System.arraycopy(arr, inicio, parte1, 0, n1);

        for (int i = 0; i < n2; ++i)
            parte2[i] = arr[meio+1+i];

        int i = 0, j = 0, k=inicio;

        while(i < n1 && j < n2){
            if (parte1[i].compareTo(parte2[j]) <= 0) {
                arr[k] = parte1[i];
                i++;
            }
            else {
                arr[k] = parte2[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k] = parte1[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = parte2[j];
            j++;
            k++;
        }
    }
}
