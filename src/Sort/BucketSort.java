package Sort;

import Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class BucketSort {

    public static void executar(){
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Executar Bucket Sort com valores de ponto flutuante");
        System.out.println("2 - Executar Bucket Sort com valores inteiros");
        System.out.println("3 - Ver resposta da questão");
        var opcao = Integer.parseInt(System.console().readLine());

        switch (opcao){
            case 1:
                executarParaFloat();
                break;
            case 2:
                executarParaInteger();
                break;
            case 3:
                System.out.println("Explique como os \"baldes\" são preenchidos e ordenados.");
                System.out.println("Resposta:");
                System.out.println("Os baldes são formados pela distribuição uniforme dos elementos. Uma vez que os elementos são divididos em baldes, eles podem ser ordenados usando qualquer outro algoritmo de ordenação. \nFinalmente, os elementos classificados são reunidos de forma ordenada");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    public static void executarParaFloat(){

        Float[] numeros =  {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};
        System.out.println("Array desordenado:");
        Util.imprimirArray(numeros);

        bucketSort(numeros);

        Util.imprimirArray(numeros);
    }

    public static void executarParaInteger(){
        Integer[] numeros = {10, 2, 11, 43, 3, 5};
        System.out.println("Array desordenado:");
        Util.imprimirArray(numeros);

        bucketSort(numeros);

        Util.imprimirArray(numeros);
    }

    //region Métodos privados para fazer o bucket sort com o float
    private static void bucketSort(Float[] arr){
        int tamanho = arr.length;

        //Cria n baldes vazios
        List<Float>[] baldes = new ArrayList[tamanho];
        for (int i = 0; i < tamanho; i++)
            baldes[i] = new ArrayList<>();


        //Coloca os elementos do array em diferentes baldes
        for (Float aFloat : arr) {
            int bi = (int) (tamanho * aFloat);
            baldes[bi].add(aFloat);
        }

        //Ordena individualmente os baldes usando o insertion sort
        for (int i = 0; i < tamanho; i++)
            insertionSort(baldes[i]);


        //Concatena todos os baldes dentro do array
        int index = 0;
        for (int i = 0; i < tamanho; i++)
            for (int j = 0; j < baldes[i].size(); j++)
                arr[index++] = baldes[i].get(j);
    }

    private static void insertionSort(List<Float> baldes){
        for (int i = 1; i < baldes.size(); ++i) {
            float chave = baldes.get(i);
            int j = i - 1;
            while(j>=0 && baldes.get(j) > chave){
                baldes.set(j+1, baldes.get(j));
                j--;
            }
            baldes.set(j + 1, chave);
        }
    }
    //endregion

    //region Métodos privados para fazer o bucket sort com o interger
    private static void bucketSort(Integer[] array){
        int tamanho = array.length;

        //Cria n baldes vazios
        List<Integer>[] baldes = new ArrayList[tamanho];
        for (int i = 0; i < tamanho; i++)
            baldes[i] = new ArrayList<>();


        //int max = Arrays.stream(array).max().getAsInt();
        Optional<Integer> max = Arrays.stream(array).max(Integer::compare);
        //Coloca os elementos do array em diferentes baldes
        for (int i = 0; i < tamanho; i++) {
            int bi = (int) ((double) array[i] / (max.get() + 1) * tamanho);
            baldes[bi].add(array[i]);
        }

        //Ordena individualmente os baldes usando o insertion sort
        for (int i = 0; i < tamanho; i++)
            insertionSortParaInteger(baldes[i]);


        //Concatena todos os baldes dentro do array
        int index = 0;
        for (int i = 0; i < tamanho; i++)
            for (int j = 0; j < baldes[i].size(); j++)
                array[index++] = baldes[i].get(j);
    }

    private static void insertionSortParaInteger(List<Integer> baldes){
        for (int i = 1; i < baldes.size(); ++i) {
            int chave = baldes.get(i);
            int j = i - 1;
            while(j>=0 && baldes.get(j) > chave){
                baldes.set(j+1, baldes.get(j));
                j--;
            }
            baldes.set(j + 1, chave);
        }
    }
    //endregion
}
