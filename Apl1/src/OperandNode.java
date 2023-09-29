/* COMPONENTES DO GRUPO
 * NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

// Classe base que representa um nó que armazena um operando
public class OperandNode extends Node {

    private float operand; // Atributo da classe OperandNode
    
    // Métodos construtores
    public OperandNode(float argOperand, Node argParent) {
        super(argParent);
        this.operand = argOperand;
    }

    public OperandNode(float argOperand) { this(argOperand, null); }

    public OperandNode() { this(0.0f); }

    // Métodos Getters & Setters
    public float getOperand() { return this.operand; }

    public void setOperand(float argOperand) { this.operand = argOperand; }
 
    @Override // Sobrescreve implementação do método da superclasse
    public String toString() {
        return "" + this.operand;
    }

    // Método solicitado no enunciado da aplicação 
    @Override // Sobrescreve implementação do método da superclasse
    public float visit() { return this.operand; }
    
}
