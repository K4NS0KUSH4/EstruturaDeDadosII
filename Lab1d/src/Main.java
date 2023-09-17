/* COMPONENTES DO GRUPO 
 * NOME: Jonatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

public class Main {
    public static void main(String[] args) {
        Node nodeA = new Node("A", null);
        BST bstree = new BST(nodeA);
        System.out.println(bstree.search("A", nodeA));
        System.out.println(bstree.insert("B", nodeA, null));
        System.out.println(nodeA);
        bstree.inOrderTraversal(nodeA);
        bstree.postOrderTraversal(nodeA);
    }
}