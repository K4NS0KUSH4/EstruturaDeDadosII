/* COMPONENTES DO GRUPO 
 * NOME: Jonatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

public class Main {
    public static void printNodeInfo(Node node) {
        System.out.println("\n||-------- NODO " + node.getData() + " --------||");
        System.out.println("Chave: " + node.getData() + "\tGrau: " + node.getDegree());
        System.out.println("Altura: " + node.getHeight() + "\tNível: " + node.getLevel());
        System.out.println("Parent: " + (node.getParent() == null? null : node.getParent().getData()) + "\tLeft: " + (node.getLeft() == null ? null : node.getLeft().getData()));
        System.out.println("Right: " + (node.getRight() == null ? null : node.getRight().getData()) + "\tÉ folha? " + (node.isLeaf() ? "Sim" : "Não"));
        System.out.println("É raiz? " + (node.isRoot() ? "Sim\n" : "Não\n"));
    }

public static void printBSTreeInfo(BST tree) {
    System.out.println("\n||-------- Binary Search Tree --------||");
    System.out.println("Árvore vazia? " + (tree.isEmpty() ? "Sim" : "Não"));
    System.out.println("Altura: " + (tree.isEmpty() ? 0 : tree.getHeight()) + "\tGrau: " + (tree.isEmpty() ? "0" : tree.getDegree()));
    System.out.println("Raiz: " + (tree.getRoot() == null ? null : tree.getRoot().getData()));
    System.out.println("Percurso em ordem: ");
    tree.inOrderTraversal(tree.getRoot());
    System.out.println();
}

    public static void main(String[] args) {
        System.out.println("Iniciando testes para validação da implementação da BSTree.");
        BST bstree = new BST();
        printBSTreeInfo(bstree);
        
        System.out.println("\nCriando nodo de chave 30 (String) e definindo-o como raiz da BST");
        Node node30 = new Node("30", null);
        bstree.setRoot(node30);
        printNodeInfo(node30);

        System.out.println("Guardando referência do nodo raiz em binSearchRoot");
        Node binSearchRoot = bstree.getRoot();
        System.out.println("binSearchRoot = " + binSearchRoot.getData());

        System.out.println("\nInserindo nodo de chave 15");
        binSearchRoot = bstree.insert("15", binSearchRoot, null);
        System.out.println("Informações do nodo 15 (obtido a partir do método Search da BST): ");
        printNodeInfo(bstree.search("15", binSearchRoot));

        System.out.println("Atualização dos dados do nodo raiz da BST:");
        printNodeInfo(bstree.getRoot());

        System.out.println("Atualização da BST:");
        printBSTreeInfo(bstree);

        System.out.println("\nInserindo nodo de chave 38");
        binSearchRoot = bstree.insert("38", binSearchRoot, null);
        bstree.treeOrderInfo(binSearchRoot);

        System.out.println("\nInserindo nodo de chave 10");
        binSearchRoot = bstree.insert("10", binSearchRoot, null);
        bstree.treeOrderInfo(binSearchRoot);

        System.out.println("\nInserindo nodo de chave 20");
        binSearchRoot = bstree.insert("20", binSearchRoot, null);
        bstree.treeOrderInfo(binSearchRoot);

        System.out.println("\nInserindo nodo de chave 08");
        binSearchRoot = bstree.insert("08", binSearchRoot, null);
        bstree.treeOrderInfo(binSearchRoot);

        System.out.println("\nInserindo nodo de chave 16");
        binSearchRoot = bstree.insert("16", binSearchRoot, null);
        bstree.treeOrderInfo(binSearchRoot);

        System.out.println("\nInserindo nodo de chave 27");
        binSearchRoot = bstree.insert("27", binSearchRoot, null);
        bstree.treeOrderInfo(binSearchRoot);

        System.out.println("\nInserindo nodo de chave 51");
        binSearchRoot = bstree.insert("51", binSearchRoot, null);
        bstree.treeOrderInfo(binSearchRoot);

        System.out.println("\nAtualização da BST: ");
        printBSTreeInfo(bstree);

        System.out.println("\nAltura dos nodos de chaves 08, 10, 15 e 30 deve ser, respectivamente, 0, 1, 2 e 3:");
        String[] keys = {"08", "10", "15", "30"};
        for(int i = 0; i < keys.length; i++) {
            System.out.println("Altura de nodo de chave " + keys[i] + ": " + bstree.search(keys[i], binSearchRoot).getHeight());
        }

        System.out.println("\nSimulando inserção de nodo de chave 20 (já inserido na árvore): ");
        try {
            binSearchRoot = bstree.insert("20", binSearchRoot, null);
        } catch(RuntimeException error) {
            System.err.println(error.getMessage());
        }

        System.out.println("\nSimulando remoção de nodo de chave 55 (não inserido na árvore): ");
        try{
            binSearchRoot = bstree.remove("55", binSearchRoot);
        } catch(RuntimeException error) {
            System.err.println(error.getMessage());
        }

        System.out.println("\nRemovendo nodo de chave 30 (possui subárvores esquerda e direita)");
        binSearchRoot = bstree.remove("30", binSearchRoot);
        printBSTreeInfo(bstree);
        bstree.treeOrderInfo(binSearchRoot);

        System.out.println("\nRemovendo nodo de chave 08 (nodo é uma folha)");
        binSearchRoot = bstree.remove("08", binSearchRoot);
        printBSTreeInfo(bstree);
        bstree.treeOrderInfo(binSearchRoot);

        System.out.println("\nRemovendo nodo de chave 38 (não possui subárvore esquerda)");
        binSearchRoot = bstree.remove("38", binSearchRoot);
        printBSTreeInfo(bstree);
        bstree.treeOrderInfo(binSearchRoot);

        System.out.println("\nRemovendo nodo de chave 20 (não possui subárvore direita)");
        binSearchRoot = bstree.remove("20", binSearchRoot);
        printBSTreeInfo(bstree);
        bstree.treeOrderInfo(binSearchRoot);

        System.out.println("\nValor mínimo da árvore: " + bstree.findMin(binSearchRoot).getData());
        System.out.println("Valor máximo da árvore: " + bstree.findMax(binSearchRoot).getData());
        System.out.println("Antecessor de 27: " + bstree.findPredecessor(bstree.search("27", binSearchRoot).getData()).getData());
        System.out.println("Sucessor de 27: " + bstree.findSucessor(bstree.search("27", binSearchRoot).getData()).getData());

        System.out.println("\nLimpando árvore");
        bstree.clear(binSearchRoot);

        printBSTreeInfo(bstree);
    }
}

/* REFERÊNCIAS
 *
 * Techie Delight. Delete a binary tree - Iterative and Recursive. 
 * Disponível em https://www.techiedelight.com/delete-given-binary-tree-iterative-recursive/
 * Acesso em 16 set 2023.
 * 
 * Javatpoint. Binary Search Tree
 * Disponível em https://www.javatpoint.com/binary-search-tree
 * Acesso em 16 set 2023.
 * 
 * Baeldung. Calculating the height of a Binary Tree
 * Disponível em https://www.baeldung.com/cs/binary-tree-height
 * Acesso em 16 set 2023.
 * 
 * GeeksForGeeks. Deletion in a Binary Search Tree (BST)
 * Disponível em https://www.geeksforgeeks.org/deletion-in-binary-search-tree/
 * Acesso em 17 set 2023.
 */