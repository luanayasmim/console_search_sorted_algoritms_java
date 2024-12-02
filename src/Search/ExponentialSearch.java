package Search;

import Util.Util;

public class ExponentialSearch {
    public static void executar(){
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Executar Exponential Search");
        System.out.println("2 - Ver resposta da questão");
        var opcao = Integer.parseInt(System.console().readLine());

        switch (opcao){
            case 1:
                System.out.println("Array para buscar:");
                Integer[] numeros = {2, 3, 4, 10, 40, 50, 60, 70};
                Util.imprimirArray(numeros);

                int alvo = 50;
                System.out.println("Valor Procurado: " + alvo);


                int resultado = exponentialSearch(numeros, alvo);

                Util.imprimir(resultado);
                break;
            case 2:
                System.out.println("Analise o desempenho do Exponential Search em listas muito grandes e pequenas.");
                System.out.println("Resposta:");
                System.out.println("Listas pequenas: O overhead do Exponential Search pode torná-lo mais lento que o Binary Search.");
                System.out.println("Listas grandes: Ele é eficiente para encontrar rapidamente o intervalo onde o valor pode estar, especialmente útil em listas parcialmente indexadas ou dispersas.");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    private static int exponentialSearch(Integer[] arr, int alvo){
        if(arr[0]==alvo)
            return 0;

        int tamanho = arr.length;

        int i = 1;
        while(i<tamanho && arr[i]<=alvo) i = i*2;

        return BinarySearch.binarySearch(arr, i/2, Math.min(i, tamanho-1), alvo);
    }
}
