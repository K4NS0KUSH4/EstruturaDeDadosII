/* COMPONENTES DO GRUPO
 * NOME: Jonatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
 */

public class Main {
    public static void main(String[] args) {
           BinaryTree arvore = new BinaryTree();
           Node A = new Node("A");
           Node B = new Node("B", A);
           Node C = new Node("C", A);
           Node D = new Node("D", B);
           Node E = new Node("E", C);
           Node F = new Node("F", C);
           arvore.setRoot(A);
           A.setLeft(B);
           A.setRight(C);
           B.setLeft(D);
           C.setLeft(E);
           C.setRight(F);
           
           System.out.println(">>>>>>> INFORMAÇÕES SOBRE OS NODOS DA ÁRVORE <<<<<<<");
           System.out.println("NÓ [" + A.getData() + "] : Raiz: " + A.isRoot() + " | Folha: " + A.isLeaf() + " | Grau: " + A.getDegree() + " | Nível: " + A.getLevel() + " | Altura: " + A.getHeight());
           System.out.println("NÓ [" + B.getData() + "] : Raiz: " + B.isRoot() + " | Folha: " + B.isLeaf() + " | Grau: " + B.getDegree() + " | Nível: " + B.getLevel() + " | Altura: " + B.getHeight());
           System.out.println("NÓ [" + C.getData() + "] : Raiz: " + C.isRoot() + " | Folha: " + C.isLeaf() + " | Grau: " + C.getDegree() + " | Nível: " + C.getLevel() + " | Altura: " + C.getHeight());
           System.out.println("NÓ [" + D.getData() + "] : Raiz: " + D.isRoot() + " | Folha: " + D.isLeaf() + " | Grau: " + D.getDegree() + " | Nível: " + D.getLevel() + " | Altura: " + D.getHeight());
           System.out.println("NÓ [" + E.getData() + "] : Raiz: " + E.isRoot() + " | Folha: " + E.isLeaf() + " | Grau: " + E.getDegree() + " | Nível: " + E.getLevel() + " | Altura: " + E.getHeight());
           System.out.println("NÓ [" + F.getData() + "] : Raiz: " + F.isRoot() + " | Folha: " + F.isLeaf() + " | Grau: " + F.getDegree() + " | Nível: " + F.getLevel() + " | Altura: " + F.getHeight());
           
           System.out.println("\n>>>>>>> INFORMAÇÕES SOBRE A ÁRVORE <<<<<<<");
           System.out.println("A árvore está vazia? " + arvore.isEmpty());
           System.out.println("Altura da árvore: " + arvore.getHeight());
           System.out.println("Grau da árvore: " +  arvore.getDegree());
           System.out.print("Percurso em ordem: " );
           arvore.inOrderTraversal();
           System.out.print("\nPercurso em Pós-ordem: " );
           arvore.postOrderTraversal();
           System.out.print("\nPercurso em Pré-ordem: " );
           arvore.preOrderTraversal();
           System.out.print("\nPercurso em nível: ");
           arvore.levelOrderTraversal(A);
    }
}


/* REFERÊNCIAS
 *
 * W3Schools. Java LinkedList.
 * Disponível em https://www.w3schools.com/java/java_linkedlist.asp
 * Acesso em 10 set. 2023.
 * 
 * KISHIMOTO, André. Árvores. 
 * Disponível em https://graduacao.mackenzie.br/mod/resource/view.php?id=986861
 * Acesso em 10 set. 2023.
 * 
 * KISHIMOTO, André. Árvores Binárias.
 * Disponível em https://graduacao.mackenzie.br/mod/resource/view.php?id=986864
 * Acesso em 10 set. 2023.
 * 
 */