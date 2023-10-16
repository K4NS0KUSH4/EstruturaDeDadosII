/* NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

public class Main {

    public static void main(String[] args) {
        AVL tree = new AVL();
        int nodeDatas[] = {4, 3, 8, 7, 10, 9, 11};
        
        for(int i = 0; i < nodeDatas.length; i++) {
            tree.insert(nodeDatas[i]);
        }

        for(int j = 0; j < nodeDatas.length; j++) {
            Node aux = tree.search(nodeDatas[j]);
            aux.updateBalanceFactor();
            System.err.println(aux);
        }

        System.out.println();

        tree.rotateLeft(tree.getRoot());

        for(int k = 0; k < nodeDatas.length; k++) {
            Node aux = tree.search(nodeDatas[k]);
            aux.updateBalanceFactor();
            System.err.println(aux);
        }
    }

}