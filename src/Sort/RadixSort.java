package Sort;

import Util.Util;
import java.util.Arrays;

public class RadixSort {
    public static void executar(){
        System.out.println("Executar Radix Sort");
        Integer[] numeros = {170, 45, 75, 90, 802, 24, 2, 66};
        Util.imprimirArray(numeros);

        radixSort(numeros, numeros.length);

        Util.imprimirArray(numeros);
    }

    private static void radixSort(Integer[] arr, int n){
        //Encontra o número máximo para sabermos a quantidade de digitos
        int max = getMax(arr, arr.length);

        for (int i = 1; max/i > 0 ; i*=10) {
            countSort(arr, n, i);
        }
    }

    private static int getMax(Integer[] arr, int n){
        int max = arr[0];
        for(int i = 1; i < n; i++)
            if (arr[i] > max) max = arr[i];

        return max;
    }

    private static void countSort(Integer[] arr, int n, int exp){
        int[] saida = new int[n];
        int[] count = new int[10];

        int i;

        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(arr[i]/exp)%10]++;

        for(i=1; i<10;i++)
            count[i]+=count[i-1];

        for(i=n-1;i>-0;i--){
            saida[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        for (i = 0; i < n; i++) {
            arr[i] = saida[i];
        }
    }
}
