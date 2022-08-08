package Ordenacao;

import Vetor.Parametro;

public class SelectSort implements Ordenavel{


    public void sort(Parametro<?, ?>[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            int min = i; //O menor atribuido ao primeiro elemento
            for (int j = i + 1; j < A.length; j++) {//Percorre o vetor
                if (A[j].compararOrdem(A[min].getChave()) < 0) {//O retorno do método tende a ser negativo se o valor de j eh menor que min
                    min = j;
                }
            }
            Parametro<?, ?> temp = A[i];
            A[i] = A[min];
            A[min] = temp;
        }
    }

    public void SelectionMinMax(Parametro<?, ?>[] vetor) {
        for(int i = 0, j = vetor.length-1; i < j; i++, j--) {//tamanho do vetor
            int min = i;//i eh o menor
            int max = j;//j maior

            for(int k = i+1, l = j-1; k <= j; k++, l--) {//percorre o vetor

                if(vetor[k].compararOrdem(vetor[min].getChave()) < 0) {//se o atual for menor que o já atribuido ele atualiza
                    min = k;
                }

                if(vetor[l].compararOrdem(vetor[max].getChave()) > 0) {//se o atual for maior que o já atribuido ele atualiza
                    max = l;
                }
            }

            //realiza a troca
            Parametro<?, ?> aux = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = aux;

            if(max == i) {
                max = min;
            }

            aux = vetor[j];
            vetor[j] = vetor[max];
            vetor[max] = aux;
        }
    }

}
