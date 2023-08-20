public class Automovel {
    private String placa;
    private String marca;
    private int ano;
    private float preco;

    // Métodos Construtores
    public Automovel() { // Sem parâmetros
        this("", "", 0, 0.0f);
    }

    public Automovel(String placaArg, String marcaArg, int anoArg, float precoArg) {
        this.placa = placaArg;
        this.marca = marcaArg;
        this.ano = anoArg;
        this.preco = precoArg;
    }

    // Métodos Getters e Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placaArg) {
        this.placa = placaArg;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marcaArg) {
        this.marca = marcaArg;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int anoArg) {
        this.ano = anoArg;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float precoArg) {
        this.preco = precoArg;
    }

    // Override do Método toString()
    @Override
    public String toString() {
        return "Placa: " + placa + " | " + "Marca: " + marca + " | " +
            "Ano: " + ano + " | " + "Preço: R$" + preco + ";";
    }
}