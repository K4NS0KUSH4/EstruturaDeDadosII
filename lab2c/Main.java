//Referencias:
//https://joaoarthurbm.github.io/eda/posts/hashtable/
//https://www.youtube.com/watch?v=eSklGt_70-U&t=297s&ab_channel=ProfessorDouglasMaioli




public class Main {

    public static void main(String[] args) {
        OpenHash hash = new OpenHash(50);
        System.out.println("Opereações com endereçamento aberto ");
        System.out.println(hash.inserir(123,"Jonatas"));
        System.out.println(hash.inserir(123,"Pedro"));
        System.out.println(hash.inserir(001, "Gloves"));
        System.out.println(hash.inserir(102, "Chaves"));
        System.out.println(hash.inserir(100, "Chiquinha"));
        System.out.println(hash.inserir(117, "Madruga"));
        System.out.println(hash.inserir(128, "Neymar"));
        System.out.println(hash.inserir(98, "Defante"));
        System.out.println(hash.inserir(55, "Larissa"));

        System.out.println("\n Buscando a chave 123 na tabela: ");
        System.out.println(hash.busca(123));
        System.out.println("Buscando a chave 124 na tabela: ");
        System.out.println(hash.busca(124));
        System.out.println("\n -- Removendo a chave 123" );
        System.out.println(hash.remover(123));
        System.out.println("Buscando a chave 123 na tabela: ");
        System.out.println(hash.busca(123));
        System.out.println("-- Removendo a chave 124" );
        System.out.println(hash.remover(124));
        
        System.out.println("\nOperações com o Encadeamento de hash");
        ChainHash hash_encadeado = new ChainHash(50);
        System.out.println(hash_encadeado.inserir(123,"Jônatas"));
        System.out.println(hash_encadeado.inserir(123,"Pedro"));
        System.out.println(hash_encadeado.inserir(23,"Socorro Deus da Silva"));
        System.out.println(hash_encadeado.inserir(128,"Neymar"));
        System.out.println("\nBuscando a chave 123 na tabela ");
        System.out.println(hash_encadeado.busca(123));
        System.out.println("Buscando a chave 23 na tabela ");
        System.out.println(hash_encadeado.busca(23));
        System.out.println("Buscando a chave 01 na tabela ");
        System.out.println(hash_encadeado.busca(01));
        
        System.out.println("Removendo a chave 123 da tabela ");
        System.out.println(hash_encadeado.remover(123));
        System.out.println("\nBuscando a chave 123 na tabela ");
        System.out.println(hash_encadeado.busca(123));
        System.out.println("\nBuscando a chave 23 na tabela ");
        System.out.println(hash_encadeado.busca(23));
    }
}
