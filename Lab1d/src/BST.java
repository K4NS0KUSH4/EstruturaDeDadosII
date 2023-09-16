/* COMPONENTES DO GRUPO 
 * NOME: Jonatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

public class BST extends BinaryTree {

    public BST() {
        super(null);
    }

    public BST(Node root) {
        super(root);
    }

    public Node search(Node rootBST, String data) {
        if(rootBST == null) {
            return null;
        }

        if(rootBST.getData().compareTo(data) < 0) {
            return search(rootBST.getRight(), data);
        }

        if(rootBST.getData().compareTo(data) > 0) {
            return search(rootBST.getLeft(), data);
        }

        return rootBST;
    }

}