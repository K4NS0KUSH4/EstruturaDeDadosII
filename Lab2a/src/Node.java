/* NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

public class Node {
    
    private int data;
    private int balanceFactor;
    private Node parent;
    private Node left;
    private Node right;

    public Node() { this(0); }
    
    public Node(int argData) {
        data = argData;
        balanceFactor = 0;
        right = null;
        left = null;
        parent = null;
    }

    public Node(int argData, Node argParent) {
        data = argData;
        balanceFactor = 0;
        right = null;
        left = null;
        parent = argParent;
    }

    public int getData() { return this.data; }

    public void setData(int argData) { this.data = argData; }

    public int getBalanceFactor() { return this.balanceFactor; }

    public void updateBalanceFactor() {
        int rightHeight = (right == null ? 0 : right.getHeight());
        int leftHeight = (left == null ? 0 : left.getHeight());
        balanceFactor = rightHeight - leftHeight;
    }

    public Node getParent() { return this.parent; }

    public void setParent(Node argParent) { this.parent = argParent; }

    public Node getLeft() { return this.left; }

    public void setLeft(Node argLeft) {
        if(argLeft != null) {
            argLeft.setParent(this);
        }

        this.left = argLeft;
    }

    public Node getRight() { return this.right; }

    public void setRight(Node argRight) {
        if(argRight != null) {
            argRight.setParent(this);
        }
        
        this.right = argRight;
    }
    
    public boolean isRoot() { return parent == null; }
    
    public boolean isLeaf() { return getDegree() == 0; }
    
    public int getDegree() {
        if(left == null && right == null) { return 0; }
        if(left != null && right != null) { return 2; }
        return 1;
    }

    public int getLevel() {
        if(isRoot()) { return 0; }
        return 1 + parent.getLevel();
    }

    public int getHeight() {
        if(isLeaf()) { return 0; }
        int rightHeight = right == null ? 0 : right.getHeight();
        int leftHeight = left == null ? 0 : left.getHeight();
        return rightHeight > leftHeight ? rightHeight + 1 : leftHeight + 1;
    }

    @Override
    public String toString() {
        return "[Data: " + data
                + "; Parent: " + (parent == null ? null : parent.getData())
                + "; Left: " + (left == null ? null : left.getData())
                + "; Right: " + (right == null ? null : right.getData())
                + "; Height: " + getHeight() 
                + "; Balance Factor: " + balanceFactor
                + "]";
    }

}
