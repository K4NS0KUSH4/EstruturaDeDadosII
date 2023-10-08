/* NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

public class BST extends BinaryTree {
    
    public BST() { super(); }
    
    public BST(Node argRoot) { super(argRoot); }
    
    public Node search(int argData) { return searchHelper(root, argData); }
    
    private Node searchHelper(Node argNode, int argData) {
        if(argNode == null) { return null; }
        if(argData < argNode.getData()) { return searchHelper(argNode.getLeft(), argData); }
        if(argData > argNode.getData()) { return searchHelper(argNode.getRight(), argData); }
        return argNode;
    }

    public void insert(int argData) { root = insertHelper(root, null, argData); }

    private Node insertHelper(Node argNode, Node argParent, int argData) {
        if(argNode == null) { return new Node(argData, argParent); }
        if(argData < argNode.getData()) { argNode.setLeft(insertHelper(argNode.getLeft(), argNode, argData)); }
        else if(argData > argNode.getData()) { argNode.setRight(insertHelper(argNode.getRight(), argNode, argData)); }
        else { throw new RuntimeException("Node[data=" + argData + "] already inserted."); }
        return argNode;
    }

    public void remove(int argData) { root = removeHelper(root, argData); }

    private Node removeHelper(Node argNode, int argData) {
        if(argNode == null) { throw new RuntimeException("Node[" + argData + "] doesn't exist in BST."); }
        if(argData < argNode.getData()) { argNode.setLeft(removeHelper(argNode.getLeft(), argData)); }
        else if(argData > argNode.getData()) { argNode.setRight(removeHelper(argNode.getRight(), argData)); }
        else { argNode = removeNode(argNode); }
        return argNode;
    }

    private Node removeNode(Node argNode) {
        if(argNode.isLeaf()) { return null; }
        if(argNode.getLeft() == null) { return argNode.getRight(); }
        else if(argNode.getRight() == null) { return argNode.getLeft(); }
        else {
            Node predecessor = findPredecessor(argNode.getData());
            argNode.setData(predecessor.getData());
            argNode.setLeft(removeHelper(argNode.getLeft(), predecessor.getData()));
        }

        return argNode;
    }

    public Node findMin() {
        if(root == null) { return null; }
        return findMinHelper(root);
    }
    
    private Node findMinHelper(Node argNode) {
        if(argNode.getLeft() == null) { return argNode; }
        return findMinHelper(argNode.getLeft());
    }

    public Node findMax() {
        if(root == null) { return null; }
        return findMaxHelper(root);
    }

    private Node findMaxHelper(Node argNode) {
        if(argNode.getRight() == null) { return argNode; }
        return findMaxHelper(argNode.getRight());
    }

    public Node findPredecessor(int argData) {
        Node found = search(argData);
        if(found == null) { throw new RuntimeException("Node[data=" + argData + "] not found."); }
        return findPredecessorHelper(found);
    }

    private Node findPredecessorHelper(Node argNode) {
        if(argNode.getLeft() != null) { return findMaxHelper(argNode.getLeft()); }
        
        Node current = argNode;
        Node parent = argNode.getParent();

        while(parent != null && current == parent.getLeft()) {
            current = parent;
            parent = current.getParent();
        }

        return parent;
    }

    public Node findSuccessor(int argData) {
        Node found = search(argData);
        if(found == null) { throw new RuntimeException("Node[data=" + argData + "] not found."); }
        return findSuccessorHelper(found);
    }

    private Node findSuccessorHelper(Node argNode) {
        if(argNode.getRight() != null) { return findMinHelper(argNode.getRight()); }

        Node current = argNode; 
        Node parent = argNode.getParent();

        while(parent != null && current == parent.getRight()) {
            current = parent;
            parent = current.getParent();
        }

        return parent;
    }

    public void clear() { root = clearHelper(root); }

    private Node clearHelper(Node argNode) {
        if(argNode == null) { return null; }
        argNode.setLeft(clearHelper(argNode.getLeft()));
        argNode.setRight(clearHelper(argNode.getRight()));
        argNode.setParent(null);
        return null;
    }

}
