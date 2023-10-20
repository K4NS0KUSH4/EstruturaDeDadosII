/* NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

public class Main {
    public static void main(String[] args) {
        AVL avlTree = new AVL();
        int[] data = {3, 2, 1, 4, 6, 8, 5, 7, 9, 10};
    
        for(int i = 0; i < data.length; i++) {
            avlTree.insert(data[i]);
        }

        for(int j = 0; j < data.length; j++) {
            System.out.println(avlTree.search(data[j]));
        }
    }
}
