/* NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

public class AVL extends BST {

    public AVL() { super(); }

    public AVL(Node nodeArg) { super(nodeArg); }

    private Node rotateLeft(Node argRoot) {
        Node newRoot = argRoot.getRight();
        Node leftChild = newRoot.getLeft();
        
        if(argRoot.isRoot()) { 
            newRoot.setParent(null);
            setRoot(newRoot); 
        }

        else if(argRoot.isRightChild()) {
            argRoot.getParent().setRight(newRoot);
        }

        else if(argRoot.isLeftChild()) {
            argRoot.getParent().setLeft(newRoot);
        }

        newRoot.setLeft(argRoot);
        argRoot.setRight(leftChild);

        return newRoot;
    }

    private Node rotateRight(Node argRoot) {
        Node newRoot = argRoot.getLeft();
        Node rightChild = newRoot.getRight();

        if(argRoot.isRoot()) { 
            newRoot.setParent(null);
            setRoot(newRoot); 
        }

        else if(argRoot.isRightChild()) {
            argRoot.getParent().setRight(newRoot);
        }

        else if(argRoot.isLeftChild()) {
            argRoot.getParent().setLeft(newRoot);
        }

        newRoot.setRight(argRoot);
        argRoot.setLeft(rightChild);

        return newRoot;
    }

    private Node rotateLeftRight(Node argRoot) {
        Node leftChild = argRoot.getLeft();
        Node newRoot = leftChild.getRight();
        
        argRoot.setLeft(newRoot);
        leftChild.setRight(newRoot.getLeft());
        newRoot.setLeft(leftChild);

        return rotateRight(argRoot);
    }

    private Node rotateRightLeft(Node argRoot) {
        Node rightChild = argRoot.getRight();
        Node newRoot = rightChild.getLeft();

        argRoot.setRight(newRoot);
        rightChild.setLeft(newRoot.getRight());
        newRoot.setRight(rightChild);

        return rotateLeft(argRoot);
    }

    private void postOrderUpdateBF(Node argNode) {
        if(argNode == null) { return; }
        postOrderUpdateBF(argNode.getLeft());
        postOrderUpdateBF(argNode.getRight());
        argNode.updateBalanceFactor();
    }

    private void balanceAVL(Node argNode) {
        if(argNode == null) { return; }

        balanceAVL(argNode.getLeft());
        balanceAVL(argNode.getRight());
        postOrderUpdateBF(argNode);
        
        if(argNode.getBalanceFactor() < -1) {
            if(argNode.getLeft().getBalanceFactor() == 1) { rotateLeftRight(argNode); }
            else if(argNode.getLeft().getBalanceFactor() == -1) { rotateRight(argNode); }
        }
        
        else if(argNode.getBalanceFactor() > 1) {
            if(argNode.getRight().getBalanceFactor() == -1) { rotateRightLeft(argNode); }
            else if(argNode.getRight().getBalanceFactor() == 1) { rotateLeft(argNode); }
        }

        postOrderUpdateBF(argNode.getParent());
    }

    @Override
    public void insert(int argData) {
        super.insert(argData);
        balanceAVL(root);
    }

}