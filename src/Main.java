
import Ordenacao.*;
import Vetor.*;
import String.*;

import java.util.*;


public class Main {


    public static void main(String[] args) {
        System.out.println("--Bem vindo ao sistema--");
        Scanner escolha = new Scanner(System.in);
        int alt = 0;
        int ordem = 0;
        boolean var = true;
        System.out.println("\nQual o tamanho do vetor desejado?");
        Scanner leitor = new Scanner(System.in);
        int tamVetor = leitor.nextInt();
        Parametro<?, ?>[] vetorMain = new Parametro[tamVetor];
        Random gera = new Random();
        Scanner leitorOrdem = new Scanner(System.in);

        while (var){
            System.out.println("Escolha ordem:");
            System.out.println("\n Deseja ordenar de forma crescente ou descrescente?\n1 - Crescente\t2 - Decrescente");
            try {
                ordem = leitorOrdem.nextInt();
                if (ordem == 1) {
                    System.out.println("\nOrdem escolhida: crescente");
                    var = false;
                } else if (ordem == 2) {
                    System.out.println("\nOrdem escolhida: decrescente");
                    var = false;
                } else {
                    System.out.println("\nPor favor escolha entre uma das opcoes!");
                }
            }catch(InputMismatchException ex){
                System.out.println(ex.getMessage());
                main(args);//reinicia o programa

            }
        }
        var = true;
        while(var) {
            System.out.println("\nEscolha a chave e valor respectivamente:");
            System.out.println("(1-String e Double)");
            System.out.println("(2-Double e String)");
            System.out.println("(3-Double Interger)");
            try {
                alt = escolha.nextInt();

                if (alt == 1) {
                    Parametro<String, Double>[] vetorAux = new Parametro[tamVetor];
                    for (int i = 0; i < tamVetor; i++) {
                        vetorAux[i] = new Parametro<>(Gerador.getStringRandom(15), gera.nextDouble(25), TipoOrdem.values()[ordem - 1]); // Colocando valores aleatórios para cada posição do vetor
                    }
                    vetorMain = vetorAux;
                    var = false;
                    System.out.println("Vetor preenchido aleatoriamente com sucesso");
                } else if (alt == 2) {
                    Parametro<Double, String>[] vetorAux = new Parametro[tamVetor];
                    for (int i = 0; i < tamVetor; i++) {
                        vetorAux[i] = new Parametro<>(gera.nextDouble(25), Gerador.getStringRandom(15), TipoOrdem.values()[ordem - 1]); // Colocando valores aleatórios para cada posição do vetor
                    }
                    vetorMain = vetorAux;
                    var = false;
                    System.out.println("Vetor preenchido aleatoriamente com sucesso");
                } else if (alt == 3) {
                    Parametro<Double, Integer>[] vetorAux = new Parametro[tamVetor];
                    for (int i = 0; i < tamVetor; i++) {
                        vetorAux[i] = new Parametro<>(gera.nextDouble(25), gera.nextInt(25), TipoOrdem.values()[ordem - 1]); // Colocando valores aleatórios para cada posição do vetor
                    }
                    vetorMain = vetorAux;
                    var = false;
                    System.out.println("Vetor preenchido aleatoriamente com sucesso");
                } else {
                    System.out.println("Digite um número válido!");
                }
            } catch (InputMismatchException ex) {
                ex.getMessage();
                main(args);//reinicia o programa
            }
        }
        while (true) {
            System.out.println("\n1-SelectSort" + "\n2-InsertSort" + "\n3-MergeSort" + "\n4-QuickSort" + "\n5-HeapSort" + "\n6-Algoritmos especiais");
            System.out.println("7-Designar outra Ordem");
            Scanner input = new Scanner(System.in);
            int opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    Ordenavel select = new SelectSort();
                    long tempoInicial = System.currentTimeMillis();
                    select.sort(vetorMain);

                    System.out.println("\nVetor ordenado com sucesso");
                    for (int i = 0; i < vetorMain.length; i++) {
                        System.out.println("[" + vetorMain[i].getChave() + ", " + vetorMain[i].getValor() + "]");
                    }
                    System.out.println("\n\nTempo de execução:");
                    System.out.println(System.currentTimeMillis() - tempoInicial + " ms");
                    break;
                case 2:
                    Ordenavel insert = new InsertSort();
                    long tempoInicial2 = System.currentTimeMillis();
                    insert.sort(vetorMain);

                    System.out.println("\nVetor ordenado com sucesso");
                    for(int i = 0; i < vetorMain.length; i++){
                        System.out.println("[" + vetorMain[i].getChave() + ", " + vetorMain[i].getValor() + "]");
                    }
                    System.out.println("\n\nTempo de execução:");
                    System.out.println(System.currentTimeMillis() - tempoInicial2 + " ms");
                    break;
                case 3:
                    Ordenavel merge = new MergeSort();
                    long tempoInicial3 = System.currentTimeMillis();
                    merge.sort(vetorMain);

                    System.out.println("\nVetor ordenado com sucesso");
                    for(int i = 0; i < vetorMain.length; i++){
                        System.out.println("[" + vetorMain[i].getChave() + ", " + vetorMain[i].getValor() + "]");
                    }
                    System.out.println("\n\nTempo de execução:");
                    System.out.println(System.currentTimeMillis() - tempoInicial3 + " ms");
                    break;
                case 4:
                    Ordenavel quick = new QuickSort();
                    long tempoInicial4 = System.currentTimeMillis();
                    quick.sort(vetorMain);

                    System.out.println("\nVetor ordenado com sucesso");
                    for(int i = 0; i < vetorMain.length; i++){
                        System.out.println("[" + vetorMain[i].getChave() + ", " + vetorMain[i].getValor() + "]");
                    }
                    System.out.println("\n\nTempo de execução:");
                    System.out.println(System.currentTimeMillis() - tempoInicial4 + " ms");
                    break;
                case 5:
                    Ordenavel heap = new HeapSort();
                    long tempoInicial5 = System.currentTimeMillis();
                    heap.sort(vetorMain);

                    System.out.println("\nVetor ordenado com sucesso");
                    for(int i = 0; i < vetorMain.length; i++){
                        System.out.println("[" + vetorMain[i].getChave() + ", " + vetorMain[i].getValor() + "]");
                    }
                    System.out.println("\n\nTempo de execução:");
                    System.out.println(System.currentTimeMillis() - tempoInicial5 + " ms");
                    break;
                case 6:
                    System.out.println("\nDeseja utilizar o:\n\n1-Selectsort Melhorado\n2-Mergesort Melhorado");
                    Scanner selecao = new Scanner(System.in);
                    int algoritmo = selecao.nextInt();
                    if(algoritmo == 1){
                        SelectSort minmax = new SelectSort();
                        long tempoInicialES = System.currentTimeMillis();
                        minmax.SelectionMinMax(vetorMain);

                        System.out.println("\nVetor ordenado com sucesso");
                        for(int i = 0; i < vetorMain.length; i++){
                            System.out.println("[" + vetorMain[i].getChave() + ", " + vetorMain[i].getValor() + "]");
                        }
                        System.out.println("\n\nTempo de execução:");
                        System.out.println(System.currentTimeMillis() - tempoInicialES + " ms");
                        break;
                    } else if(algoritmo==2){
                        MergeSort mergeInsert = new MergeSort();
                        long tempoInicialES2 = System.currentTimeMillis();
                        mergeInsert.mergeSortInsert(vetorMain);

                        System.out.println("\nVetor ordenado com sucesso");
                        for(int i = 0; i < vetorMain.length; i++){
                            System.out.println("[" + vetorMain[i].getChave() + ", " + vetorMain[i].getValor() + "]");
                        }
                        System.out.println("\n\nTempo de execução:");
                        System.out.println(System.currentTimeMillis() - tempoInicialES2 + " ms");
                        break;
                    }
                case 7:
                    System.out.println("Escolha ordem:");
                    System.out.println("\n Deseja ordenar de forma crescente ou descrescente?\n1 - Crescente\t2 - Decrescente");
                    ordem = leitorOrdem.nextInt();
                    for(int i = 0; i < vetorMain.length; i++){
                        vetorMain[i].setCons(TipoOrdem.values()[ordem - 1]);
                    }
                    System.out.println("Ordem selecionada com sucesso");
                    break;
                default:
                    System.out.println("Digite uma opcao válida!");
                    break;
            }
        }
    }
}
