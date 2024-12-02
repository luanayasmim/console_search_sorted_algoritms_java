package Search;

import Util.Util;

public class TernarySearch {
    public static void executar(){
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Executar Ternary Search");
        System.out.println("2 - Comparar desempenho com o Binary Search");
        System.out.println("3 - Ver resposta da questão");
        var opcao = Integer.parseInt(System.console().readLine());

        switch (opcao){
            case 1:
                System.out.println("Array para buscar:");
                Integer[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 20, 20, 40, 64};
                Util.imprimirArray(arr);

                int alvo = 64;
                System.out.println("Valor Procurado: " + alvo);
                int resultado = ternarySearch(arr, 0, arr.length - 1, alvo);

                Util.imprimir(resultado);
                break;
            case 2:
                exercicio();
                break;
            case 3:
                System.out.println("Identifique situações em que o Ternary Search seria mais eficiente que o Binary Search.");
                System.out.println("Resposta:");
                System.out.println("O Ternary Search pode ser mais útil que o Binary Search em algumas situações específicas, como:\n" +
                        "Quando você está tentando encontrar o máximo ou mínimo de uma função unimodal (onde a função é crescente até um ponto e depois decrescente, ou o contrário).\n" +
                        "Quando o problema exige dividir o espaço de busca em três partes em vez de duas, o que pode se adequar melhor à estrutura do problema.\n" +
                        "Quando você quer refinar a busca de maneira mais precisa, dividindo o intervalo em três direções, em vez de duas, para uma exploração mais detalhada.\n" +
                        "Entretanto, em termos de tempo de execução, ambos os algoritmos têm complexidade O(log n). Isso significa que, no geral, o Ternary Search não é mais rápido que o Binary Search. A grande diferença está na aplicabilidade: o Ternary Search é vantajoso quando o problema naturalmente se beneficia de dividir o intervalo em três partes, como no caso de funções unimodais ou quando a busca pode ser otimizada dessa forma.");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    public static void executarComTempo(Integer[] numeros, int alvo){
        long tempoInicial = System.currentTimeMillis();

        int resultado = ternarySearch(numeros, 0, numeros.length-1, alvo);

        Util.imprimir(resultado);

        long tempoFinal = System.currentTimeMillis()-tempoInicial;
        System.out.println("Tempo de execucao: "+tempoFinal);
    }

    private static void exercicio() {
        java.io.Console console = System.console();

        Integer[] arr = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 };

        int alvo = 25;

        System.out.println("Lista ");
        Util.imprimirArray(arr);

        System.out.println("Valor procurado: "+alvo);

        System.out.println("Resultado com Ternary Search:");
        executarComTempo(arr, alvo);

        System.out.println("Resultado com Binary Search:");
        executarComTempo(arr, alvo);
    }

    private static int ternarySearch(Integer[] numeros, int esquerda, int direita, int alvo){
        // Verifica se o limite esquerdo é menor ou igual ao limite direito
        if (esquerda <= direita) {
            // Calcula dois pontos médios dividindo o subarray atual em três partes iguais
            int meio1 = esquerda + (direita - esquerda) / 3;
            int meio2 = direita - (direita - esquerda) / 3;

            // Verifica se o alvo é igual a algum dos dois pontos médios
            if (numeros[meio1] == alvo) {
                return meio1;
            }
            if (numeros[meio2] == alvo) {
                return meio2;
            }

            // Se o alvo for menor que o elemento em meio1, busca no terço esquerdo do subarray
            if (alvo < numeros[meio1]) {
                return ternarySearch(numeros, esquerda, meio1 - 1, alvo);
            }
            // Se o alvo for maior que o elemento em meio2, busca no terço direito do subarray
            else if (alvo > numeros[meio2]) {
                return ternarySearch(numeros, meio2 + 1, direita, alvo);
            }
            // Se o alvo estiver entre meio1 e meio2, busca no terço do meio do subarray
            else {
                return ternarySearch(numeros, meio1 + 1, meio2 - 1, alvo);
            }
        }
        // Elemento não encontrado, retorna -1
        return -1;
    }
}
