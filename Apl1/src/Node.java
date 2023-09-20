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
    public Node(Node argLeft, Node argRight, Node argParent) {
        this.left = argLeft;
        this.right = argRight;
        this.parent = argParent;
    }
    
    public Node(Node argParent) { this(null, null, argParent); }

    public Node() { this(null, null, null); }

    // Métodos Getters & Setters
    public Node getLeft() { return this.left; }

    public void setLeft(Node argLeft) { this.left = argLeft; }

    public Node getRight() { return this.right; }

    public void setRight(Node argRight) { this.right = argRight; }

    public Node getParent() { return this.parent; }

    public void setParent(Node argParent) { this.parent = argParent; }

    // Método solicitado no enunciado da aplicação
    public float visit() {
        return Float.NaN;
    } 

}