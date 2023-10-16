/* NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

public class AVL extends BST {

    public AVL() { super(); }

    public AVL(Node nodeArg) { super(nodeArg); }

    public Node rotateLeft(Node argRoot) {
        Node newRoot = argRoot.getRight();
        Node leftChild = newRoot.getLeft();
        
        newRoot.setParent(argRoot.getParent());
        if(newRoot.isRoot()) { setRoot(newRoot); }

        newRoot.setLeft(argRoot);
        argRoot.setRight(leftChild);

        return newRoot;
    }

    public Node rotateRight(Node argRoot) {
        Node newRoot = argRoot.getLeft();
        Node rightChild = newRoot.getRight();

        newRoot.setParent(argRoot.getParent());
        if(newRoot.isRoot()) { setRoot(newRoot); }

        newRoot.setRight(argRoot);
        argRoot.setLeft(rightChild);

        return newRoot;
    }

}