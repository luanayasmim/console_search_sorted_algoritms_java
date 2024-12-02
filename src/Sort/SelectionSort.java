package Sort;

import Util.Util;

public class SelectionSort {
    public static void executar(){
        System.out.println("Executar Selection Sort");
        Integer[] numeros = {64, 25, 12, 22, 11};
        Util.imprimirArray(numeros);

        selectionSort(numeros);

        Util.imprimirArray(numeros);
    }

    private static void selectionSort(Integer[] arr){
        int tamanho = arr.length;

        for (int i = 0; i < tamanho-1; i++) {
            int minIndex = i;

            for (int j = i+1; j < tamanho; j++) {
                if(arr[j]<arr[minIndex])
                    minIndex=j;
            }

            //todo: extrair para uma classe de utils com o método de trocar
            Util.trocar(arr, i, minIndex);
        }
    }
}
