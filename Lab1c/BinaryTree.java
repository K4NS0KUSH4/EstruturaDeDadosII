/* COMPONENTES DO GRUPO 
 * NOME: Jonatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

import java.util.Queue;
import java.util.LinkedList;

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

        int leftLevel = (root.getLeft() != null) ? root.getLeft().getLevel() : 0;
        int rightLevel = (root.getRight() != null) ? root.getRight().getLevel() : 0;

        return (leftLevel > rightLevel) ? 1 + leftLevel : 1 + rightLevel;
    }

    // Left >>> Node >>> Right
    public void inOrderTraversal() {
        if(isEmpty()) {
            return;
        }

        Node root = this.root;

        if(root.getLeft() != null) {
            BinaryTree leftTree = new BinaryTree(root.getLeft());
            leftTree.inOrderTraversal();
        }

        System.out.print(root.getData() + " ");

        if(root.getRight() != null) {
            BinaryTree rightTree = new BinaryTree(root.getRight());
            rightTree.inOrderTraversal();
        }
    }

    // Node >>> Left >>> Right
    public void preOrderTraversal() {
        if(isEmpty()) {
            return;
        }

        Node root = this.root;
        System.out.print(root.getData() + " ");

        if(root.getLeft() != null) {
            BinaryTree leftTree = new BinaryTree(root.getLeft());
            leftTree.preOrderTraversal();
        }

        if(root.getRight() != null) {
            BinaryTree rightTree = new BinaryTree(root.getRight());
            rightTree.preOrderTraversal();
        }
    }

    // Left >>> Right >>> Node
    public void postOrderTraversal() {
        if(isEmpty()) {
            return;
        }

        Node root = this.root;

        if(root.getLeft() != null) {
            BinaryTree leftTree = new BinaryTree(root.getLeft());
            leftTree.postOrderTraversal();
        }
        
        if(root.getRight() != null) {
            BinaryTree rightTree = new BinaryTree(root.getRight());
            rightTree.postOrderTraversal();
        }
        
        System.out.print(root.getData() + " ");
    }

    public void levelOrderTraversal(Node root) {
        Node head = root;
        Queue<Node> fila = new LinkedList<>();
        fila.add(head);

        while(!fila.isEmpty()) {
            head = fila.remove();
            System.out.print(head.getData() + " ");
            if (head.getLeft() != null) {
                fila.add(head.getLeft());
            }
            if (head.getRight() != null) {
                fila.add(head.getRight());
            }
        }
    }
}