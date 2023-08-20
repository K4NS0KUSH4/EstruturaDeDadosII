public class Concurso {
    private String nome;
    private Candidato[] candidatos;
    private Juri[] jurados;

    public Concurso() {
        this("\0", null, null);
    }

    public Concurso(String nomeArg, Candidato[] candidatosArg, Juri[] juriArg) {
        this.nome = nomeArg;
        this.candidatos = candidatosArg;
        this.jurados = juriArg; 
    }

    public String filtraGeneroMusical(String generoMusical){
        StringBuilder filtrados = new StringBuilder();
        for (int i = 0; i < candidatos.length; i++){
           if(generoMusical.equals(candidatos[i].getGenMus())){
               filtrados.append(candidatos[i].getNome());
           }
	    }
	    for (int i = 0; i < jurados.length;i++){
           if(generoMusical.equals(jurados[i].getGenMusPrin())){
               filtrados.append(" - "); 
               filtrados.append(jurados[i].getNomeArtistico());
           }
        }
        return filtrados.toString();
    }

    public String filtraSexoIdade(String sexo, int idadeMin, int idadeMax) {
        StringBuilder filtrados = new StringBuilder();
        for(int i = 0; i < candidatos.length; i++) {
            if(sexo.equals(candidatos[i].getSexo()) && candidatos[i] instanceof Candidato) {
                if(idadeMax < candidatos[i].getIdade() && idadeMin > candidatos[i].getIdade()) {
                    filtrados.append(candidatos[i].getNome());
                } 
            }
        }
        
        return filtrados.toString();
    }

    public int contaCandidatos(String sexo){
        int contador = 0;
        for (int i =0; i < candidatos.length; i++){
            if(sexo.equals(candidatos[i].getSexo())){
                contador += 1;
            }
        }
        
        return contador;
    }

    @Override 
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        buffer.append("CONCURSO " + nome);
        buffer.append("\n\nCANDIDATOS\n");
        for (int i = 0; i < candidatos.length; i++){
            buffer.append(candidatos[i] + "\n");
        }
        buffer.append("\nJURI\n");
        for (int i=0; i < jurados.length; i++){
            buffer.append(jurados[i] + "\n");
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        Candidato candidato01 = new Candidato(1, "123.456.564.67", "Zeca Pagodes", 69, "Masculino", "Samba");
        Candidato candidato02 = new Candidato(2, "394.234.543.32", "Pipokinha", 23, "Feminino", "Funk");
        Candidato candidato03 = new Candidato(3, "779.223.442.13", "Manoel Gomes", 37, "Masculino", "MPB");
        Candidato[] candidatos = {candidato01, candidato02, candidato03};

        Juri jurado01 = new Juri("Julio", "Julão da massa", "Rap");
        Juri jurado02 = new Juri("Jordan Americo", "JorJor", "House");
        Juri jurado03 = new Juri("Amelia Aparecida", "Amelecida", "MPB");
        Juri[] jurados = {jurado01, jurado02, jurado03};

        Concurso concurso = new Concurso("The Voice Chernobyl", candidatos, jurados);
        System.out.println(concurso);

        System.out.println("Candidatos e jurados que tocam 'Funk'");
        System.out.println(concurso.filtraGeneroMusical("Funk"));
        System.out.println("\nCandidatos e juris que tocam 'MPB'");
        System.out.println(concurso.filtraGeneroMusical("MPB"));
        System.out.println("\nCandidatos 'HOMENS' que tem entre 50 e 80 anos");
        System.out.println(concurso.filtraSexoIdade("Masculino", 80, 50));
        System.out.print("\nQuantidade de candidatos do sexo Masculino: ");
        System.out.println(concurso.contaCandidatos("Masculino"));
        System.out.print("Quantidade de candidatos do sexo Feminino: ");
        System.out.println(concurso.contaCandidatos("Feminino"));
    }
}
