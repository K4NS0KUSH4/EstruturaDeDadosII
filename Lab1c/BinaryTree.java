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

    // Esquerda -> No -> Direita
    public void inOrderTraversal(Node root) {
        Node head = root;
        if (head == null) {
            System.out.println("Null");
        }
        if (head.getLeft() != null) {
            inOrderTraversal(head.getLeft());
        }
        System.out.print(head.getData() + " ");
        if (head.getRight() != null) {
            inOrderTraversal(head.getRight());
        }
    }

    // No -> esquerda -> Direita
    public void preOrderTraversal(Node root) {
        Node head = root;
        if (head == null) {
            System.out.println("Null");
        }
        System.out.print(head.getData() + " ");
        if (head.getLeft() != null) {
            preOrderTraversal(head.getLeft());
        }
        if (head.getRight() != null) {
            preOrderTraversal(head.getRight());
        }
    }

    // Esquerda -> Direita -> No
    public void postOrderTraversal(Node root) {
        Node head = root;
        if (head.getLeft() != null) {
            postOrderTraversal(head.getLeft());
        }
        if (head.getRight() != null) {
            postOrderTraversal(head.getRight());
        }
        System.out.print(head.getData() + " ");
    }

    public void levelOrderTraversal(Node root) {
        Node head = root;
        Queue<Node> fila = new LinkedList<>();
        fila.add(head);
        while (!fila.isEmpty()) {
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
