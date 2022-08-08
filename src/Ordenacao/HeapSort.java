package Ordenacao;

import Vetor.Parametro;
import java.lang.Math;

public class HeapSort implements Ordenavel {

    public void sort(Parametro<?, ?>[] A) {
        buildMaxHeap(A, A.length - 1);
        for (int i = A.length - 1; i >= 1; i--) {
            Parametro<?, ?> aux = A[0];
            A[0] = A[i];
            A[i] = aux;

            maxHeapify(A, 0, i - 1);
        }
    }
    private void buildMaxHeap(Parametro<?, ?>[] A, int n){//n sendo a quantidade de elementos
        for(int i = (int)Math.floor((double)n/2); i >= 0; i--) {//i recebe o piso/2 ex: piso=10 i = 5
            maxHeapify(A, i, n);
        }
    }
    private void maxHeapify(Parametro<?, ?>[] A,int i, int n){// n sendo o num elementos e i o indice
        int comp=0;
        int l = 2*(i);
        int r = 2*(i)+1;
        int max;

        if(l <= n && A[l].compararOrdem(A[i].getChave())>0){//Se o filho eh maior que o pai
            max = l;

        } else{//se nao o maior eh o da coordenada
            max = i;
        }
        if(r <= n && A[r].compararOrdem(A[max].getChave()) >0){
            max = r;
        }

        if(max != i){//se for diferente de i faz a troca
            Parametro<?, ?> temp = A[max];
            A[max] = A[i];
            A[i] = temp;
            maxHeapify(A, max, n);
        }
    }
}
