import Search.*;
import Sort.*;

import java.io.Console;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        java.io.Console console = System.console();

        boolean sair = false;
        do {
            System.out.println("Lista de estrutura de dados");
            System.out.println("Qual tipo de algoritmo devemos testar?");
            System.out.println("1 - Search");
            System.out.println("2 - Sort");
            System.out.println("0 - Sair\n");

            var tipo = Integer.parseInt(System.console().readLine());

            switch (tipo){
                case 0:
                    sair = true;
                    break;
                case 1:
                    algoritmosDeBusca(console);
                    break;
                case 2:
                    algoritmosDeOrdenacao(console);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        }while (!sair);
    }

    private static void algoritmosDeBusca(Console console) {
        System.out.println("Escolha qual é o tipo de algoritmo de busca que você deseja executar");
        System.out.println("1 - Binary Search");
        System.out.println("2 - Exponential Search");
        System.out.println("3 - Interpolation Search");
        System.out.println("4 - Jump Search");
        System.out.println("5 - Ternary Search");

        var opcao = Integer.parseInt(System.console().readLine());


        switch (opcao){
            case 1:
                BinarySearch.executar();
                break;
            case 2:
                ExponentialSearch.executar();
                break;
            case 3:
                InterpolationSearch.executar();
                break;
            case 4:
                JumpSearch.executar();
                break;
            case 5:
                TernarySearch.executar();
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    private static void algoritmosDeOrdenacao(Console console) {
        System.out.println("Escolha qual é o tipo de algoritmo de ordenacao que você deseja executar");
        System.out.println("1 - Bucket Sort");
        System.out.println("2 - Merge Sort");
        System.out.println("3 - Quick Sort");
        System.out.println("4 - Radix Sort");
        System.out.println("5 - Selection Sort");
        System.out.println("6 - Shell Sort");
        var opcao = Integer.parseInt(System.console().readLine());

        switch (opcao){
            case 1:
                BucketSort.executar();
                break;
            case 2:
                MergeSort.executar();
                break;
            case 3:
                QuickSort.executar();
                break;
            case 4:
                RadixSort.executar();
                break;
            case 5:
                SelectionSort.executar();
                break;
            case 6:
                ShellSort.executar();
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
}