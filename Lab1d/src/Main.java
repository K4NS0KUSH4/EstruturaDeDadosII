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
        binSearchRoot = bstree.remove("D", binSearchRoot);
        binSearchRoot = bstree.remove("B", binSearchRoot);
        System.out.println(bstree.getRoot());

    }
}