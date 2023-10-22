/* NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    
    protected Node root;
    
    public BinaryTree() { this(null); }
    
    public BinaryTree(Node argRoot) {
        root = argRoot;
    }

    public Node getRoot() { return root; }

    public void setRoot(Node argRoot) { root = argRoot; }

    public boolean isEmpty() { return root == null; }

    public int getDegree() { return getDegreeHelper(root); }

    private int getDegreeHelper(Node argNode) {
        if(argNode == null || argNode.isLeaf()) { return 0; }

        int degree = argNode.getDegree();

        if(argNode.getLeft() != null) {
            degree = Math.max(degree, getDegreeHelper(argNode.getLeft()));
        }

        if(argNode.getRight() != null) {
            degree = Math.max(degree, getDegreeHelper(argNode.getRight()));
        }

        return degree;
    }

    public int getHeight() {
        if(isEmpty()) { return 0; } 
        return root.getHeight();
    }

    public String inOrderTraversal() { return inOrderTraversalHelper(root); }

    private String inOrderTraversalHelper(Node argNode) {
        if(argNode == null) { return ""; }

        StringBuilder buffer = new StringBuilder();

        buffer.append(inOrderTraversalHelper(argNode.getLeft()));
        buffer.append(argNode.getData() + " ");
        buffer.append(inOrderTraversalHelper(argNode.getRight()));

        return buffer.toString();
    }

    public String preOrderTraversal() { return preOrderTraversalHelper(root); }

    private String preOrderTraversalHelper(Node argNode) {
        if(argNode == null) { return ""; }

        StringBuilder buffer = new StringBuilder();

        buffer.append(argNode.getData() + " ");
        buffer.append(preOrderTraversalHelper(argNode.getLeft()));
        buffer.append(preOrderTraversalHelper(argNode.getRight()));

        return buffer.toString();
    }

    public String postOrderTraversal() { return postOrderTraversalHelper(root); }

    private String postOrderTraversalHelper(Node argNode) {
        if(argNode == null) { return ""; }

        StringBuilder buffer = new StringBuilder();

        buffer.append(postOrderTraversalHelper(argNode.getLeft()));
        buffer.append(postOrderTraversalHelper(argNode.getRight()));
        buffer.append(argNode.getData() + " ");

        return buffer.toString();
    }

    public String levelOrderTraversal() { return levelOrderTraversalHelper(root); }

    private String levelOrderTraversalHelper(Node argNode) {
        if(argNode == null) { return ""; }

        StringBuilder buffer = new StringBuilder();

        Queue<Node> queue = new LinkedList<>();
        queue.add(argNode);

        while(!queue.isEmpty()) {
            Node visited = queue.remove();
            buffer.append(visited.getData() + " ");

            if(visited.getLeft() != null) { queue.add(visited.getLeft()); }
            if(visited.getRight() != null) { queue.add(visited.getRight()); }
        }

        return buffer.toString();
    }

    @Override
    public String toString() {
        return "[Tree root: " + (root == null ? null : root.getData())
                + "; Degree: " + getDegree()
                + "; Height: " + getHeight()
                + "; " + (isEmpty() ? "Empty]" : "Not empty]");
    }

}
