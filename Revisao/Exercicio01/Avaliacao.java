public class Avaliacao {
    String nome;
    String tipoAvaliacao;
    float notaMaxima;

    // Item A
    public Avaliacao() {
        this("", "", 0.0f);
    }

    public Avaliacao(String nameArg, String typeArg, float maxGradeArg) {
        this.nome = nameArg;
        this.tipoAvaliacao = typeArg;
        this.notaMaxima = maxGradeArg;
    }

    // Item B
    public float getFinalPercent() {
        return notaMaxima * 10;
    }

    // Item C
    @Override
    public String toString() {
        return "Nome: " + nome + " | Tipo: " + tipoAvaliacao + " | Nota máxima: " +
        notaMaxima + " | Percentual final: " + getFinalPercent() + "% ;";
    }
}