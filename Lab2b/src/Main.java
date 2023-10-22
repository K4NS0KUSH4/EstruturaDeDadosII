/* NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

/* REFERÊNCIAS
 * ÁRVORE AVL.
 * KISHIMOTO, André. 2023.
 * Material de aula disponibilizado na plataforma de ensino Moodle.
*/

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static String treeToStringArray(AVL argTree) {
        return treeToStringArrayHelper(argTree.getRoot());
    }

    private static String treeToStringArrayHelper(Node argNode) {
        if (argNode == null) {
            return "";
        }

        StringBuilder buffer = new StringBuilder();

        Queue<Node> queue = new LinkedList<>();
        queue.add(argNode);

        while (!queue.isEmpty()) {
            Node visited = queue.remove();
            buffer.append(visited.toString());
            if (visited.isRoot()) {
                buffer.append(" (Root)");
            }
            buffer.append("\n");

            if (visited.getLeft() != null) {
                queue.add(visited.getLeft());
            }
            if (visited.getRight() != null) {
                queue.add(visited.getRight());
            }
        }

        return buffer.toString();
    }

    private static void insertNodesFromArray(int[] argArray, AVL argTree) {
        for (int i = 0; i < argArray.length; i++) {
            argTree.insert(argArray[i]);
        }
    }

    private static void runInsertExercise(char argItem, int[] argArray) {
        AVL tree = new AVL();
        insertNodesFromArray(argArray, tree);
        System.out.println("\n//---------------------------------------- ITEM " + argItem
                + " ----------------------------------------//");
        System.out.println(treeToStringArray(tree));
    }

    private static void runRemoveExercise(char argItem, AVL argTree, int argData) {
        System.out.println("\n//---------------------------------------- ITEM " + argItem
                + " ----------------------------------------//");
        System.out.println("Nó removido: " + argTree.search(argData));
        argTree.remove(argData);
        System.out.println(treeToStringArray(argTree));
    }

    public static void main(String[] args) {
        int[] arrayA = { 1, 2, 3 };
        int[] arrayB = { 3, 2, 1 };
        int[] arrayC = { 3, 1, 2 };
        int[] arrayD = { 1, 3, 2 };
        int[] arrayE = { 5, 4, 3, 1, 2, 6, 7, 9, 8 };

        runInsertExercise('A', arrayA);
        runInsertExercise('B', arrayB);
        runInsertExercise('C', arrayC);
        runInsertExercise('D', arrayD);

        AVL treeE = new AVL();
        insertNodesFromArray(arrayE, treeE);
        System.out.println(
                "\n//---------------------------------------- ITEM E ----------------------------------------//");
        System.out.println(treeToStringArray(treeE));

        runRemoveExercise('F', treeE, 4);
        runRemoveExercise('G', treeE, 5);
        runRemoveExercise('H', treeE, 1);
    }

}
