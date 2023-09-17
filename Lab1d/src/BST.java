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
        if(root != null) {
            
            if(root.getData().compareTo(data) == 0) {
                return root;
            }

            else if(root.getData().compareTo(data) > 0) {
                return search(data, root.getLeft());
            }

            else if(root.getData().compareTo(data) < 0) {
                return search(data, root.getRight());
            }
        }

        return null;
    }

    public Node insert(String data, Node root, Node parent) {
        if(root == null) {
            root = new Node(data, parent);
            return root;
        }

        else if(root.getData().compareTo(data) > 0) {
            root.setLeft(insert(data, root.getLeft(), root));
        }

        else if(root.getData().compareTo(data) < 0) {
            root.setRight(insert(data, root.getRight(), root));
        }

        return root;
    }

    private Node removeNode(Node root) {
        if(root.isLeaf()) {
            root = null;
        }

        else if(root.getLeft() == null) {
            root = root.getRight();
        }

        else if(root.getRight() == null) {
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

}