package Sort;

import Util.Util;

public class QuickSort {
    public static void executar(){
        System.out.println("Executar Quick Sort");
        Integer[] numeros = {10, 7, 8, 9, 1, 5};
        Util.imprimirArray(numeros);

        quickSort(numeros, 0, numeros.length-1);

        Util.imprimirArray(numeros);
    }

    private static void quickSort(Integer[] arr, int inicio, int fim){
        if(inicio<fim){
            int indexPivo = particao(arr, inicio, fim);

            quickSort(arr, inicio, indexPivo-1);
            quickSort(arr,indexPivo+1, fim);
        }
    }

    private static int particao(Integer[] arr, int inicio, int fim){
        int pivo = arr[fim];

        int i = inicio-1;

        for (int j = inicio; j <= fim; j++) {
            if(arr[j] < pivo){
                i++;
                Util.trocar(arr, i, j);
            }
        }

        Util.trocar(arr, i+1, fim);
        return i+1;
    }
}
