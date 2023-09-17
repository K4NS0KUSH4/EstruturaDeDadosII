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

    public Node search(String data, Node root) {
        if(root == null) {
            return null;
        }

        else if(root.getData().compareTo(data) == 0) {
            return root;
        }

        else if(root.getData().compareTo(data) > 0) {
            return search(data, root.getLeft());
        }

        else {
            return search(data, root.getRight());
        }
    }

    public Node insert(String data, Node root, Node parent) {
        if(root == null) {
            root = new Node(data, parent);
        }

        else if(root.getData().compareTo(data) > 0) {
            root.setLeft(insert(data, root.getLeft(), root));
        }

        else if(root.getData().compareTo(data) < 0) {
            root.setRight(insert(data, root.getRight(), root));
        }

        else {
            throw new RuntimeException("Nodo de chave " + data + " já existente.");
        }

        return root;
    }

    private Node removeNode(Node root) {
        if(root.isLeaf()) {
            if(root.isRoot()) {
                setRoot(null);
            }

            root = null;
        }

        else if(root.getLeft() == null) {
            if(root.isRoot()) {
                setRoot(findSucessor(root.getData()));
            }
            root = root.getRight();
        }

        else if(root.getRight() == null) {
            if(root.isRoot()) {
                setRoot(findPredecessor(root.getData()));
            }
            root = root.getLeft();
        }

        else {
            Node predecessor = findPredecessor(root.getData());
            root.setData(predecessor.getData());
            root.setLeft(remove(predecessor.getData(), root.getLeft()));
        }
        
        return root;
    }

    public Node remove(String data, Node root) {
        if(search(data, root) == null) {
            throw new RuntimeException("Nodo de chave " + data + " não encontrado.");
        }

        if(root == null) {
            return null;
        }

        else if(root.getData().compareTo(data) > 0) {
            root.setLeft(remove(data, root.getLeft()));
        }

        else if(root.getData().compareTo(data) < 0) {
            root.setRight(remove(data, root.getRight()));
        }

        else {
            root = removeNode(root);
        }

        return root;
    }

    public Node findMin(Node root) {
        if(isEmpty()) {
            return null;
        }

        if(root.getLeft() == null) {
            return root;
        }

        return findMin(root.getLeft());
    }

    public Node findMax(Node root) {
        if(isEmpty()) {
            return null;
        }

        if(root.getRight() == null) {
            return root;
        }

        return findMax(root.getRight());
    }

    public Node findPredecessor(String data) {
        Node wanted = search(data, getRoot());

        if(wanted == null || wanted == findMin(getRoot())) {
            return null;
        }

        if(wanted.getLeft() != null) {
            return findMax(wanted.getLeft());
        }

        while(wanted.getData().compareTo(data) >= 0) {
            wanted = wanted.getParent();
        }

        return wanted;
    }

    public Node findSucessor(String data) {
        Node wanted = search(data, getRoot());

        if(wanted == null || wanted == findMax(getRoot())) {
            return null;
        }

        if(wanted.getRight() != null) {
            return findMin(wanted.getRight());
        }

       while(wanted.getData().compareTo(data) <= 0) {
            wanted = wanted.getParent();
        }

        return wanted;
    }

    private void inOrderInfo(Node root) {
        if(isEmpty()) {
            return;
        }

        if(root.getLeft() != null) {
            inOrderInfo(root.getLeft());
        }

        System.out.println("| Chave: " + root.getData() + "; Parent: " + (root.getParent() == null ? null : root.getParent().getData()) + "; Left: " +
            (root.getLeft() == null ? null : root.getLeft().getData()) + "; Right: " + (root.getRight() == null ? null : root.getRight().getData()) + 
            "; É raiz? " + root.isRoot() + "; É folha? " + root.isLeaf() + "; Grau: " + root.getDegree() + "; Nível: " +
            root.getLevel() + "; Altura: " + root.getHeight() + " |");

        if(root.getRight() != null) {
            inOrderInfo(root.getRight());
        }
    }

    public void treeOrderInfo(Node root) {
        inOrderInfo(root);
    }

    public void clear(Node root) {
        while(!isEmpty()) {
            remove(root.getData(), root);
        }
    }

}