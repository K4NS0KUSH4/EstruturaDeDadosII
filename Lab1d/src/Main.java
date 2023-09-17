/* COMPONENTES DO GRUPO 
 * NOME: Jonatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

public class Main {
    public static void main(String[] args) {
        Node nodeD = new Node("D");
        BST bstree = new BST(nodeD);
        Node nodeB = new Node("B", nodeD);
        nodeD.setLeft(nodeB);
        Node nodeA = new Node("A", nodeB);
        nodeB.setLeft(nodeA);
        Node nodeC = new Node("C", nodeB);
        nodeB.setRight(nodeC);
        Node nodeF = new Node("F", nodeD);
        nodeD.setRight(nodeF);
        Node nodeE = new Node("E", nodeF);
        nodeF.setLeft(nodeE);
        Node nodeG = new Node("G", nodeF);
        nodeF.setRight(nodeG);
        System.out.println(bstree.findSucessor("A"));
    }
}