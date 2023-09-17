/* COMPONENTES DO GRUPO 
 * NOME: Jonatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this(null);
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getDegree() {
        Node root = this.root;

        if(root.isLeaf()) {
            return 0;
        }

        int leftDegree = (root.getLeft() != null) ? root.getLeft().getDegree() : 0;
        int rightDegree = (root.getRight() != null) ? root.getRight().getDegree() : 0;

        return (leftDegree > rightDegree) ? leftDegree : rightDegree;
    }

    public int getHeight() {
        Node root = this.root; 

        if(root.isLeaf()) {
            return 0;
        }

        int leftLevel = (root.getLeft() != null) ? root.getLeft().getHeight() : 0;
        int rightLevel = (root.getRight() != null) ? root.getRight().getHeight() : 0;

        return (leftLevel > rightLevel) ? 1 + leftLevel : 1 + rightLevel;
    }

    // Left >>> Node >>> Right
    public void inOrderTraversal(Node root) {
        if(isEmpty()) {
            return;
        }

        if(root.getLeft() != null) {
            inOrderTraversal(root.getLeft());
        }

        System.out.print(root.getData() + " ");

        if(root.getRight() != null) {
            inOrderTraversal(root.getRight());
        }
    }

    // Node >>> Left >>> Right
    public void preOrderTraversal(Node root) {
        if(isEmpty()) {
            return;
        }

        System.out.print(root.getData() + " ");

        if(root.getLeft() != null) {
            preOrderTraversal(root.getLeft());
        }

        if(root.getRight() != null) {
            preOrderTraversal(root.getRight());
        }
    }

    // Left >>> Right >>> Node
    public void postOrderTraversal(Node root) {
        if(isEmpty()) {
            return;
        }

        if(root.getLeft() != null) {
            postOrderTraversal(root.getLeft());
        }
        
        if(root.getRight() != null) {
            postOrderTraversal(root.getRight());
        }
        
        System.out.print(root.getData() + " ");
    }
}