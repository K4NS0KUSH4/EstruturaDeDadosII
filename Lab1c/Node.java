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
        return (this.left == null || this.right == null);
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

    public int getLevel(Node raiz) {
        Node head = this;
        int contador = 0;
        while (head != raiz) {
            if (head.getParent() != null) {
                head = head.getParent();
                ++contador;
            }
        }
        return contador;
    }

    public int getHeight(Node elemento) {
        if (elemento == null) {
            return -1;
        }
        int h_left = 0;
        int h_right = 0;
        if (elemento.getLeft() != null) {
            h_left = getHeight(elemento.getLeft());
        }
        if (elemento.getRight() != null) {
            h_right = getHeight(elemento.getLeft());
        }
        if (h_left > h_right) {
            return h_left + 1;
        }
        return h_right + 1;
    }

    @Override
    public String toString() {
        return " | " + data + " | " +
                "\n | " + (left != null ? left.getData() : null) + " | " +
                " |  " + (right != null ? right.getData() : null) + " | ";
    }

}
