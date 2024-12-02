package Util;

public class Util {
    public static void imprimir(int resultado){
        if(resultado == -1){
            System.out.println("O valor procurado não foi encontrado :(");
            return;
        }
        System.out.println("O elemento foi encontrado no index: " + resultado );
    }

    public static <T> void imprimirArray(T[] arr) {
        for (T element : arr)
            System.out.print(element + " ");

        System.out.println();
    }

    public static void trocar(Integer[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
