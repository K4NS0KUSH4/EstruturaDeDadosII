import java.util.List;
import java.util.Stack;

public class BinaryTree {
    
    private Utilities util = new Utilities(); 
    private Node root; // Atributos da classe BinaryTree

    // Métodos construtores
    public BinaryTree(Node argRoot) {
        this.root = argRoot;
    }

    public BinaryTree() {
        this(null);
    }

    // Métodos Getters & Setters
    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node argRoot) {
        this.root = argRoot;
    }

    // Métodos descritivos de estado da árvore binária
    public boolean isEmpty() {
        return this.root == null;
    }

    // Método de percurso da árvore em ordem
    public String inOrderTraversal(Node argRoot) {
        if(argRoot == null) {
            return "";
        }

        StringBuilder buffer = new StringBuilder();

        buffer.append(inOrderTraversal(argRoot.getLeft()));
        buffer.append(argRoot.toString());
        buffer.append(inOrderTraversal(argRoot.getRight()));

        return buffer.toString();
    }

    // Método de percurso da árvore binária em pré-ordem
    public String preOrderTraversal(Node argRoot) {
        if(argRoot == null) {
            return "";
        }

        StringBuilder buffer = new StringBuilder();

        buffer.append(argRoot.toString());
        buffer.append(preOrderTraversal(argRoot.getLeft()));
        buffer.append(preOrderTraversal(argRoot.getRight()));

        return buffer.toString();
    }

    // Método de percurso da árvore binária em pós-ordem
    public String postOrderTraversal(Node argRoot) {
        if(argRoot == null) {
            return "";
        }

        StringBuilder buffer = new StringBuilder();

        buffer.append(postOrderTraversal(argRoot.getLeft()));
        buffer.append(postOrderTraversal(argRoot.getRight()));
        buffer.append(argRoot.toString());

        return buffer.toString();
    }

    public Node createOperator(String symbol) {
        if(symbol.equals("+")) {
            return new SumNode();
        }

        if(symbol.equals("-")) {
            return new SubNode();
        }

        if(symbol.equals("/")) {
            return new DivNode();
        }

        return new MultNode();
    }

    public void buildTreePostfix(List<String> expTokens) {
        Stack<Node> aux = new Stack<>();

        for(int i = 0; i < expTokens.size(); i++) {
            if(util.isOperand(expTokens.get(i))) {
                OperandNode operand = new OperandNode(Float.parseFloat(expTokens.get(i)));
                aux.push(operand);
            }

            else if(util.isOperator(expTokens.get(i))) {
                Node operator = createOperator(expTokens.get(i));

                operator.setLeft(aux.pop());
                operator.setRight(aux.pop());
                aux.push(operator);
            }
        }

        if(!(aux.isEmpty())) {
            this.root = aux.pop();
        }
    }

}
