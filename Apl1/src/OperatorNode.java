/* COMPONENTES DO GRUPO
 * NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

// Classe base que representa um nó que armazena um operador
public class OperatorNode extends Node {

    private char operator; // Atributos da classe OperatorNode

    // Métodos construtores
    public OperatorNode(char argOperator, Node argLeft, Node argRight, Node argParent) {
        super(argLeft, argRight, argParent);
        this.operator = argOperator;
    }

    public OperatorNode(char argOperator, Node argParent) { this(argOperator, null, null, argParent); }

    public OperatorNode(char argOperator) { this(argOperator, null); }

    public OperatorNode() { this('\0'); }

    // Métodos Getters & Setters
    public char getOperator() { return this.operator; }
    
    public void setOperator(char argOperator) { this.operator = argOperator; }

    // Método solicitado no enunciado da aplicação 
    @Override // Sobrescreve implementação do método da superclasse
    public float visit() {
        return 0.0f; // Continuar daqui
    }

}