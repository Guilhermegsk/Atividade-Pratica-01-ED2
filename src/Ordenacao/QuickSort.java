package Ordenacao;

import Vetor.Parametro;

public class QuickSort implements Ordenavel{

    public void sort(Parametro<?, ?>[]A){
        Parametro<?, ?>[] temp = new Parametro[A.length];

        quickSort(A, 0, A.length-1);
    }

    private void quickSort(Parametro<?, ?>[] A, int inicio, int fim){
        if(inicio<fim){
            int pivo = particiona(A, inicio, fim);

            quickSort(A, inicio, pivo - 1);
            quickSort(A, pivo + 1, fim);
        }
    }

    private int particiona(Parametro<?, ?>[] A, int inicio, int fim){
        Parametro<?, ?> pivo = A[inicio];//eh o primeiro
        int i = inicio+1;
        int f = fim;

        while (i<=f){//enquanto não se cruzarem
            if(A[i].compararOrdem(pivo.getChave()) <=0){//se for maior vai pro f na linha 31
                i++;
            }
            else if(A[f].compararOrdem(pivo.getChave()) >0){
                f--;
            } else{//while vai decrementar até ambas as condições serem falsas
                Parametro<?, ?> troca = A[i];
                A[i] = A[f];
                A[f] = troca;
                i++;
                f--;//faz a troca e volta pro while até i e f se cruzarem
            }
        }
        A[inicio] = A[f];
        A[f] = pivo;//coloca o pivo onde pode dividir ex:a direita os maiores
        return f;
    }
}
