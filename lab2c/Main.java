/* NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
 */

/* Referências:
 * https://joaoarthurbm.github.io/eda/posts/hashtable/
 * https://www.youtube.com/watch?v=eSklGt_70-U&t=297s&ab_channel=ProfessorDouglasMaioli
*/

public class Main {

    public static void main(String[] args) {
        HashTable hash = new HashTableOpenA(50);
        System.out.println("Operações com endereçamento aberto");
        System.out.println(hash.insert(123,"Jonatas"));
        System.out.println(hash.insert(123,"Pedro"));
        System.out.println(hash.insert(001, "Gloves"));
        System.out.println(hash.insert(102, "Chaves"));
        System.out.println(hash.insert(100, "Chiquinha"));
        System.out.println(hash.insert(117, "Madruga"));
        System.out.println(hash.insert(128, "Neymar"));
        System.out.println(hash.insert(98, "Defante"));
        System.out.println(hash.insert(55, "Larissa"));

        System.out.print("\nBuscando a chave 123 na tabela: ");
        System.out.println(hash.search(123));
        System.out.print("Buscando a chave 124 na tabela: ");
        System.out.println(hash.search(124));
        System.out.print("\nRemovendo a chave 123: " );
        System.out.println(hash.remove(123));
        System.out.print("Buscando a chave 123 na tabela: ");
        System.out.println(hash.search(123));
        System.out.print("Removendo a chave 124: " );
        System.out.println(hash.remove(124));
        
        System.out.println("\nOperações com o Encadeamento de Hash");
        HashTable hash_encadeado = new HashTableChaining(50);
        System.out.println(hash_encadeado.insert(123,"Jônatas"));
        System.out.println(hash_encadeado.insert(123,"Pedro"));
        System.out.println(hash_encadeado.insert(23,"Socorro Deus da Silva"));
        System.out.println(hash_encadeado.insert(128,"Neymar"));
        System.out.print("\nBuscando a chave 123 na tabela: ");
        System.out.println(hash_encadeado.search(123));
        System.out.print("Buscando a chave 23 na tabela: ");
        System.out.println(hash_encadeado.search(23));
        System.out.print("Buscando a chave 01 na tabela: ");
        System.out.println(hash_encadeado.search(01));
        
        System.out.print("Removendo a chave 123 da tabela: ");
        System.out.println(hash_encadeado.remove(123));
        System.out.print("\nBuscando a chave 123 na tabela: ");
        System.out.println(hash_encadeado.search(123));
        System.out.print("Buscando a chave 23 na tabela: ");
        System.out.println(hash_encadeado.search(23));
    }
}
