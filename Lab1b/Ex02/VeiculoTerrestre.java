public class VeiculoTerrestre {
    private int ano;
    private String cor;

    protected VeiculoTerrestre() { // Acesso permitido apenas a esta classe e suas subclasses
        this(0, "");
    }

    public VeiculoTerrestre(int ano, String cor) {
        this.ano = ano;
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Ano: " + ano + " | Cor: " + cor;
    }
}
