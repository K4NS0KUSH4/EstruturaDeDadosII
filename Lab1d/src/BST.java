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

        if(root.getData().compareTo(data) < 0) {
            return search(data, root.getRight());
        }

        if(root.getData().compareTo(data) > 0) {
            return search(data, root.getLeft());
        }

        return root;
    }

    public Node insert(String data, Node root, Node parent) {
        if(root != null) {

            if(search(data, root) != null) {
                throw new RuntimeException("Nodo já existente na árvore.");
            }

            if(root.getData().compareTo(data) > 0) {
                root.setLeft(insert(data, root.getLeft(), root));
            }

            else if(root.getData().compareTo(data) < 0) {
                root.setRight(insert(data, root.getRight(), root));
            }

        }

        Node newNode = new Node(data, parent);
        return newNode;
    }

}