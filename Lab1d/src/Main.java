/* COMPONENTES DO GRUPO 
 * NOME: Jonatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

public class Main {
    public static void main(String[] args) {
        BST bstree = new BST();
        Node Dnode = new Node("D", null);
        bstree.setRoot(Dnode);
        Node binSearchRoot = bstree.getRoot();
        binSearchRoot = bstree.insert("B", binSearchRoot, null);
        binSearchRoot = bstree.insert("C", binSearchRoot, null);
        binSearchRoot = bstree.insert("A", binSearchRoot, null);
        binSearchRoot = bstree.insert("E", binSearchRoot, null);
        binSearchRoot = bstree.insert("F", binSearchRoot, null);
        binSearchRoot = bstree.insert("G", binSearchRoot, null);
        bstree.postOrderTraversal(binSearchRoot);
    }
}