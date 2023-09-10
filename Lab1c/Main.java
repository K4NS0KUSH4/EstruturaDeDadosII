public class Main {
    public static void main(String[] args) {
           BinaryTree arvore = new BinaryTree();
           Node A = new Node("A");
           Node B = new Node("B",A);
           Node C = new Node("C",A);
           Node D = new Node("D",B);
           Node E = new Node("E",C);
           Node F = new Node( "F",C);
           arvore.setRoot(A);
           B.setParent(A);
           A.setLeft(B);
           A.setRight(C);
           B.setLeft(D);
           C.setLeft(E);
           C.setRight(F);
           
           
           
           System.out.println("-=-=-=-INFORMACOES SOBRE OS NOS-=-=-=-= ");
           System.out.println("NÓ A | Raiz:" + A.isRoot() + " |Folha:" + A.isLeaf() + " |Grau: " + A.getDegree() + " |Nivel: " + A.getLevel() + " |Altura: " + A.getHeight());
           System.out.println("NÓ B | Raiz:" + B.isRoot() + " |Folha:" + B.isLeaf() + " |Grau: " + B.getDegree() + " |Nivel: " + B.getLevel() + " |Altura: " + B.getHeight());
           System.out.println("NÓ C | Raiz:" + C.isRoot() + " |Folha:" + C.isLeaf() + " |Grau: " + C.getDegree() + " |Nivel: " + C.getLevel() + " |Altura: " + C.getHeight());
           System.out.println("NÓ D | Raiz:" + D.isRoot() + " |Folha:" + D.isLeaf() + " |Grau: " + D.getDegree() + " |Nivel: " + D.getLevel() + " |Altura: " + D.getHeight());
           System.out.println("NÓ E | Raiz:" + E.isRoot() + " |Folha:" + E.isLeaf() + " |Grau: " + E.getDegree() + " |Nivel: " + E.getLevel() + " |Altura: " + E.getHeight());
           System.out.println("NÓ F | Raiz:" + F.isRoot() + " |Folha:" + F.isLeaf() + " |Grau: " + F.getDegree() + " |Nivel: " + F.getLevel() + " |Altura: " + F.getHeight());
           
           System.out.println("\n=-=-=-=-INFORMACOES SOBRE A ARVORE-=-=-=- ");
           System.out.println("A arvore esta vazia? " + arvore.isEmpty());
           System.out.println("Altura da arvore: " + arvore.getHeight());
           System.out.println("Grau da arvore: " +  arvore.getDegree());
           System.out.print("Percurso em ordem: " );
           arvore.inOrderTraversal(A);
           System.out.println();
           System.out.print("Percurso em Pos ordem: " );
           arvore.postOrderTraversal(A);
           System.out.println();
           System.out.print("Percurso em Pre ordem: " );
           arvore.preOrderTraversal(A);
           System.out.println();
           System.out.print("Percurso em nivel: ");
           arvore.levelOrderTraversal(A);
    }
}
