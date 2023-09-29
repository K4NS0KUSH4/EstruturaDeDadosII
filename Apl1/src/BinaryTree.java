public class BinaryTree {
    
    private Node root; // Atributos da classe BinaryTree

    // Métodos construtores
    public BinaryTree(Node argRoot) {
        this.root = argRoot;
    }

    public BinaryTree() {
        this(null);
    }

    // Métodos Getters & Setters
    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node argRoot) {
        this.root = argRoot;
    }

    // Métodos descritivos de estado da árvore binária
    public boolean isEmpty() {
        return this.root == null;
    }

    // Método de percurso da árvore em ordem
    public String inOrderTraversal(Node argRoot) {
        if(argRoot == null) {
            return "";
        }

        StringBuilder buffer = new StringBuilder();

        buffer.append(inOrderTraversal(argRoot.getLeft()));
        buffer.append(argRoot.toString());
        buffer.append(inOrderTraversal(argRoot.getRight()));

        return buffer.toString();
    }

    // Método de percurso da árvore binária em pré-ordem
    public String preOrderTraversal(Node argRoot) {
        if(argRoot == null) {
            return "";
        }

        StringBuilder buffer = new StringBuilder();

        buffer.append(argRoot.toString());
        buffer.append(preOrderTraversal(argRoot.getLeft()));
        buffer.append(preOrderTraversal(argRoot.getRight()));

        return buffer.toString();
    }

    // Método de percurso da árvore binária em pós-ordem
    public String postOrderTraversal(Node argRoot) {
        if(argRoot == null) {
            return "";
        }

        StringBuilder buffer = new StringBuilder();

        buffer.append(postOrderTraversal(argRoot.getLeft()));
        buffer.append(postOrderTraversal(argRoot.getRight()));
        buffer.append(argRoot.toString());

        return buffer.toString();
    }

}
