public class Juri {
    private String nomeCompleto;
    private String nomeArtistico;
    private String generoMusicalPrincipal;

    public Juri() {
        this("\0", "\0", "\0");
    }

    public Juri(String nomeCompletoArg, String nomeArtisticoArg, String genMusPrinArg) {
        this.nomeCompleto = nomeCompletoArg;
        this.nomeArtistico = nomeArtisticoArg;
        this.generoMusicalPrincipal = genMusPrinArg; 
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompletoArg) {
        this.nomeCompleto = nomeCompletoArg;
    }

    public String getNomeArtistico() {
        return nomeArtistico;
    }

    public void setNomeArtistico(String nomeArtisticoArg) {
        this.nomeArtistico = nomeArtisticoArg;
    }

    public String getGenMusPrin() {
        return generoMusicalPrincipal;
    }

    public void setGenMusPrin(String genMusPrinArg) {
        this.generoMusicalPrincipal = genMusPrinArg;
    }

    @Override
    public String toString() {
        return "Nome Completo: " + nomeCompleto + " | " + "Nome Artístico: " +
            nomeArtistico + " | " + "Gênero Musical Principal: " + generoMusicalPrincipal + ";"; 
    }
}
