package Ordenacao;

import Vetor.Parametro;

public class MergeSort implements Ordenavel{

    public void sort(Parametro<?, ?>[] A){
        Parametro<?, ?>[] temp = new Parametro<?, ?>[A.length];
        mergeMain(A, temp, 0, A.length-1);//primeira e ultima posicao
    }

    public Parametro<?, ?>[] mergeMain(Parametro<?, ?>[] A, Parametro<?, ?>[] T, int esq, int dir){
        int mei;
        if(esq < dir){
            mei = (esq + dir)/2;
            mergeMain(A, T, esq, mei);//chamada recursiva para esquerda
            mergeMain(A, T, mei+1, dir);//chamada recursiva para direita
            merge(A, T, esq, mei+1, dir);
        }
        return A;
    }

    private void merge(Parametro<?, ?>[] A, Parametro<?, ?>[] T, int esqPos, int dirPos, int dirFim){
        int esqFim = dirPos -1;//ultima pos da esquerda
        int tempPos = esqPos; //primeira posição
        int numElem = dirFim - esqPos +1;//quantidade de elementos

        while(esqPos <= esqFim && dirPos <= dirFim){
            if(A[esqPos].compararOrdem(A[dirPos].getChave()) <= 0){
                T[tempPos++] = A[esqPos++];
            } else{
                T[tempPos++] = A[dirPos++];
            }
        }
        while(esqPos <= esqFim){//copia o resto da primeira parte
            T[tempPos++] = A[esqPos++];
        }
        while(dirPos <= dirFim) {
            T[tempPos++] = A[dirPos++];
        }
        //copia o vetor
        for(int i = 0; i< numElem; i++, dirFim--){
            A[dirFim] = T[dirFim];
        }
    }

    public Parametro<?, ?>[] mergeMainInsert(Parametro<?, ?>[]A,Parametro<?, ?>[] T, int esq, int dir ){
        int mei;

        if(esq<dir){
            int numElem = dir-esq+1;//quantidade de elementos

            if(numElem >= 15){// a partir do num especificado pode ser utilizado o insertion
                mei = esq + dir /2;
                mergeMainInsert(A, T, esq, mei);//chamada recursiva para esquerda
                mergeMainInsert(A, T, mei+1, dir);//chamada recursiva para direita
                merge(A, T, esq, mei+1, dir);
            } else{
                Parametro<?, ?> chave;
                int i, j;
                for( i = esq+1; i <= dir; i++) {//começa na pos 1
                    chave = A[i];//elemento eleito
                    for(j = i-1; j >= esq && A[j].compararOrdem(chave.getChave()) > 0; j--) {//chave eh o elemento mais a frente
                        A[j+1] = A[j];//copia de posiçao
                    }
                    A[j+1] = chave;//novo elemento eleito
                }
            }
        }
        return A;
    }

    public void mergeSortInsert(Parametro<?, ?>[] A){
        Parametro<?, ?>[] temp = new Parametro<?, ?>[A.length];
        mergeMainInsert(A, temp, 0, A.length-1);//primeira e ultima posicao
    }
}
