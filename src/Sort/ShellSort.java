package Sort;

import Util.Util;

public class ShellSort {
    public static void executar(){
        System.out.println("Executando Shell Sort");
        Integer[] numeros = {12, 34, 54, 2, 3};
        Util.imprimirArray(numeros);

        shellSort(numeros);

        Util.imprimirArray(numeros);
    }

    private static void shellSort(Integer[] arr){
        int tamanho = arr.length;

        for (int gap = tamanho/2; gap > 0; gap/=2) {
            for (int i = gap; i < tamanho; i++) {
                int temp = arr[i];

                int j;

                for (j = i; j >= gap && arr[j-gap]>temp; j-=gap)
                    arr[j] = arr[j-gap];

                arr[j] = temp;
            }
        }
    }
}
