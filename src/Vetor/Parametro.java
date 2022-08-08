package Vetor;


public class Parametro<I , J> {
    TipoOrdem cons; //constante para o tipo de ordem desejada
    private I chave;
    private J valor;

    public Parametro(I chave, J valor, TipoOrdem cons) {
        this.cons = cons;
        this.chave = chave;
        this.valor = valor;
    }

    public I getChave() {
        return this.chave;
    }

    public Object getValor() { //analisa qual o tipo da estrutura
        if (this.valor instanceof Integer) {
            return (Integer) this.valor;
        } else if (this.valor instanceof Double) {
            return (Double) this.valor;
        } else {
            return (String) this.valor;
        }
    }

    private <I> int comparacao(I chaveY, I chaveX) {
        if(chaveY instanceof String) {
            return((String)chaveY).compareTo((String)chaveX); //compareTo retorna 0 se as palavras são iguais
        } else if (chaveY instanceof Integer) {
            return Integer.compare((int)chaveY, (int)chaveX);
        } else {
            return Double.compare((double)chaveY, (double)chaveX);
        }
    }

    public <I> int compararOrdem(I chaveX) {
        if(this.cons == TipoOrdem.values()[0]) {
            return this.comparacao(this.chave, chaveX); // Ordenação em ordem crescente
        } else {
            return this.comparacao(chaveX, this.chave); // Ordenação em ordem decrescente
        }
    }

    public void setCons(TipoOrdem cons) {
        this.cons = cons;
    }
}
