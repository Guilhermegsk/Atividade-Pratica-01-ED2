package Ordenacao;

import Vetor.Parametro;

public class InsertSort implements Ordenavel {

    public void sort(Parametro<?, ?>[] A){
        int i, j;
        int comp=0;
        Parametro<?, ?> chave;

        for(j = 1; j < A.length; j++){//percorre o vetor
            chave = A[j];//elemento eleito
            for(i =j - 1; i >= 0 && A[i].compararOrdem(chave.getChave()) >0 ; i--){//a chave eh o elemento mais a frente
                A[i+1] = A[i];//copia de posicao
                comp++;
            }
            A[i+1] = chave;//novo elemento eleito
        }
        System.out.println("Num Comparações" + comp);
    }
}
