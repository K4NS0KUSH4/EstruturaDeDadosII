
public class Celula {
    public int chave;
    public String valor;

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Celula(int chave, String valor) {
        this.chave = chave;
        this.valor = valor;
    }

    
    @Override
    public String toString(){
        return "Chave: " + chave + "| Data: " + valor;
    }
}
    

