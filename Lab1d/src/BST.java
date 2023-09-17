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