/* COMPONENTES DO GRUPO
 * NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

// Classe base que representa um nó da árvore binária
public class Node {

    // Atributos da classe Node
    private String data;
    private Node left;
    private Node right;
    private Node parent;

    // Método construtor com 4 parâmetros definidos
    public Node(String argData, Node argLeft, Node argRight, Node argParent) {
        this.data = argData;
        this.left = argLeft;
        this.right = argRight;
        this.parent = argParent;
    } 

    // Método construtor com apenas o parâmetro definido
    public Node(String argData) { this(argData, null, null, null); }

    // Método construtor sem parâmetros definidos
    public Node() { this(null, null, null, null); }

    // Métodos Getters & Setters
    public String getData() { return this.data; }

    public void setData(String argData) { this.data = argData; }

    public Node getLeft() { return this.left; }

    public void setLeft(Node argLeft) { this.left = argLeft; }

    public Node getRight() { return this.right; }

    public void setRight(Node argRight) { this.right = argRight; }

    public Node getParent() { return this.parent; }

    public void setParent(Node argParent) { this.parent = argParent; }

    // Método requisitado no enunciado da aplicação
    public float visit() {
        return Float.NaN;
    }

}