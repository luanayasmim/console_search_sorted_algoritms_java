package Search;

import Util.Util;

public class JumpSearch {
    public static void executar(){

        System.out.println("Escolha uma opção:");
        System.out.println("1 - Executar Jump Search");
        System.out.println("2 - Ver resposta da questão");
        var opcao = Integer.parseInt(System.console().readLine());

        switch (opcao){
            case 1:
                System.out.println("Array para buscar:");
                Integer[] numeros = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };
                Util.imprimirArray(numeros);

                int alvo = 55;
                System.out.println("Valor Procurado: " + alvo);

                int resultado = jumpSearch(numeros, alvo);

                Util.imprimir(resultado);
                break;
            case 2:
                System.out.println("Compare o tempo de execução do Jump Search com o Binary Search em listas de diferentes tamanhos.");
                exercicio();
                System.out.println("Jump Search é eficiente para listas grandes armazenadas em memória sequencial, pois evita o acesso constante aos índices.\n" +
                        "Binary Search é mais rápido em termos absolutos, pois reduz a lista pela metade em cada passo.\n" +
                        "Exemplo com listas de tamanhos diferentes:\n" +
                        "Lista de tamanho 10: Ambos são similares.\n"+
                        "Lista de tamanho 1.000.000: Binary Search é mais rápido porque faz O(log n), enquanto o Jump Search realiza O( √n).\n" +
                        "Explique como ele combina elementos do Jump Search");
                break;
            default:
                System.out.println("Opção inválida");
        }


    }

    private static void exercicio() {
        java.io.Console console = System.console();

        Integer[] arr1 = { 2, 3, 4, 10, 40 }; // Lista Pequena
        Integer[] arr2 = { 2, 3, 4, 10, 40, 45, 115, 289, 567, 890, 1000, 2039, 5014, 6908, 7182 }; //Lista Grande

        int alvo = 40;

        System.out.println("Array 1 ");
        Util.imprimirArray(arr1);
        System.out.println("Array 2 ");
        Util.imprimirArray(arr2);

        System.out.println("Valor procurado: "+alvo);

        System.out.println("Resultado do Array 1 - Jump Search:");
        executarComTempo(arr1, alvo);

        System.out.println("Resultado do Array 2 - Jump Search");
        executarComTempo(arr2, alvo);

        System.out.println("Resultado do Array 1 - Binary Search");
        BinarySearch.executarComTempo(arr1, alvo);

        System.out.println("Resultado do Array 2 - Binary Search:");
        BinarySearch.executarComTempo(arr2, alvo);
    }

    public static void executarComTempo(Integer[] numeros, int alvo){
        long tempoInicial = System.currentTimeMillis();

        int resultado = jumpSearch(numeros, alvo);

        Util.imprimir(resultado);

        long tempoFinal = System.currentTimeMillis()-tempoInicial;
        System.out.println("Tempo de execucao: "+tempoFinal);
    }

    private static int jumpSearch(Integer[] arr, int alvo){
        //Pega o tamanho do array
        int tamanho = arr.length;

        //Calcula o tamanho do salto
        int salto = (int)Math.floor(Math.sqrt(tamanho));

        //Guarda passo anterior
        int saltoAnterior = 0;

        for(int minSalto = Math.min(salto, tamanho)-1; arr[minSalto] < alvo; minSalto = Math.min(salto, tamanho)-1){
            saltoAnterior = salto;
            salto+=(int)Math.floor(Math.sqrt(tamanho));
            if(saltoAnterior>=tamanho)
                return -1;
        }

        while (arr[saltoAnterior]<alvo){
            saltoAnterior++;

            if(saltoAnterior==Math.min(salto, tamanho)) return -1;
        }

        if(arr[saltoAnterior]==alvo)
            return saltoAnterior;

        return -1;
    }
}
