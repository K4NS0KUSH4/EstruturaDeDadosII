/* COMPONENTES DO GRUPO
 * NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

// Classe base que representa um nó da árvore binária
public class Node {

    // Atributos da classe Node
    private Node left;
    private Node right;
    private Node parent;

    // Métodos construtores
    public Node(Node argParent) {
        this.parent = argParent;
    }

    public Node() { 
        this(null); 
    }

    // Métodos Getters & Setters
    public Node getLeft() { 
        return this.left; 
    }

    public void setLeft(Node argLeft) { 
        this.left = argLeft; 

        if(left != null) {
            this.left.setParent(this);
        }
    }

    public Node getRight() { 
        return this.right; 
    }

    public void setRight(Node argRight) { 
        this.right = argRight;
        
        if(right != null) {
            this.right.setParent(this);
        }
    }

    public Node getParent() { 
        return this.parent; 
    }

    public void setParent(Node argParent) { 
        this.parent = argParent; 
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean hasLeftChild() {
        return left != null;
    }

    public boolean hasRightChild() {
        return right != null;
    }

    // Método solicitado no enunciado da aplicação
    public float visit() {
        return Float.NaN;
    } 

}