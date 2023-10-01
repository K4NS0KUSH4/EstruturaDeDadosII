/* COMPONENTES DO GRUPO
 * NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

// Classe base que representa um nó que armazena o operador de subtração
public class SubNode extends Node {

    // Atributos da classe SubtractionNode
    private float result;
    private String symbol;

    // Métodos construtores
    public SubNode(Node argParent) {
        super(argParent);
        this.symbol = "-";
    }

    public SubNode() {
        this(null);
    }

    @Override // Sobrescreve implementação do método da superclasse
    public String toString() {
        return this.symbol + " ";
    }

    // Método solicitado no enunciado da aplicação
    @Override // Sobreescreve implementação do método da superclasse
    public float visit() {
        if(this.getLeft() != null && this.getRight() != null) {
            this.result = this.getLeft().visit() - this.getRight().visit();
        }

        else if(this.getLeft() == null) {
            return (-1) * this.getRight().visit();
        }

        else if(this.getRight() == null) {
            return (-1) * this.getLeft().visit();
        }
        
        return this.result;
    }

}
