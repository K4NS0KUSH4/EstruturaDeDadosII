/* COMPONENTES DO GRUPO 
 * NOME: Jonatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

public class Node {

    private String data;
    private Node parent;
    private Node left;
    private Node right;

    public Node() {
        this(null, null);
    }

    public Node(String data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public Node(String data, Node parent) {
        this.data = data;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return (this.left == null && this.right == null);
    }

    public int getDegree() {
        if (this.left == null && this.right == null) {
            return 0;
        }

        if (this.left != null && this.right == null || this.left == null && this.right != null) {
            return 1;
        }

        return 2;
    }

    public int getLevel() {
        if(isRoot()) {
            return 0;
        }

        return 1 + getParent().getLevel();
    }

    public int getHeight() {
        if(isLeaf()) {
            return 0;
        }

        int leftHeight = (getLeft() != null) ? getLeft().getHeight() : 0;
        int rightHeight = (getRight() != null) ? getRight().getHeight() : 0;
        int greater = (leftHeight > rightHeight) ? leftHeight : rightHeight;
        
        return 1 + greater;
    }

    @Override
    public String toString() {
        return " L\t[" + data + "]\t R" +
                "\n[" + (left != null ? left.getData() : " ") + "]" +
                "\t\t[" + (right != null ? right.getData() : " ") + "]";
    }

}
