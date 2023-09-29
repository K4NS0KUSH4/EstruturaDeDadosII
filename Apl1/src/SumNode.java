/* COMPONENTES DO GRUPO
 * NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

// Classe base que representa um nó que armazena o operador de soma
public class SumNode extends Node {

    // Atributos da classe SumNode
    private float result;
    private String symbol;

    // Métodos construtores
    public SumNode(Node argParent) {
        super(argParent);
        this.symbol = "+";
    }

    public SumNode() {
        this(null);
    }

    @Override // Sobrescreve implementação do método da superclasse
    public String toString() {
        return this.symbol;
    }

    // Método solicitado no enunciado da aplicação
    @Override // Sobreescreve implementação do método da superclasse
    public float visit() {
        this.result = this.getLeft().visit() + this.getRight().visit();
        return this.result;
    }

}
