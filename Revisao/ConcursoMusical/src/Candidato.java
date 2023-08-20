public class Candidato {
    private int numCandidato;
    private String cpf;
    private String nome;
    private int idade;
    private String sexo;
    private String generoMusical;

    public Candidato() {
        this(0, "\0", "\0", 0, "\0", "\0");
    }

    public Candidato(int numeroArg, String cpfArg, String nomeArg, int idadeArg, String sexoArg, String genMusArg) {
        this.numCandidato = numeroArg;
        this.cpf = cpfArg;
        this.nome = nomeArg;
        this.idade = idadeArg;
        this.sexo = sexoArg;
        this.generoMusical = genMusArg;
    }

    public int getNumCandidato() {
        return numCandidato;
    }

    public void setNumCandidato(int numArg) {
        this.numCandidato = numArg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpfArg) {
        this.cpf = cpfArg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeArg) {
        this.nome = nomeArg;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idadeArg) {
        this.idade = idadeArg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexoArg) {
        this.sexo = sexoArg;
    }

    public String getGenMus() {
        return generoMusical;
    }

    public void setGenMus(String genMusArg) {
        this.generoMusical = genMusArg;
    }

    @Override
    public String toString() {
        return "Número: " + numCandidato + " | " + "CPF: " + cpf + " | " + "Nome: " + 
            nome + " | " + "Idade: " + idade + " | " + "Sexo: " + sexo + " | " +
            "Gênero Musical: " + generoMusical + ";";
    }
}