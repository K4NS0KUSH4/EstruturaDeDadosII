import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Main {
    
    public static void printMenu() {
        System.out.println(
            "\n01. Inserir expressão aritmética (notação infixa)\n02. Criar árvore binária de expressão aritmética" +
            "\n03. Exibir árvore binária de expressão aritmética\n04. Calcular expressão\n05. Encerrar"
            );
        }
        
    public static void main(String[] args) {
        Utilities util = new Utilities();
        BinaryTree binTree = new BinaryTree();
        Scanner inputOption = new Scanner(System.in);
        List<String> expStrings = new ArrayList<>();
        Scanner inputExp = new Scanner(System.in);
        String exp = "";
        boolean flag1 = true, flag2 = true;
        int option = -1;

        while (flag1) {
            printMenu();

            while (flag2) {
                System.out.print("Escolha uma opção: ");

                try {
                    option = inputOption.nextInt();

                    if (option <= 0 || option >= 6) {
                        System.out.println("ERRO: Opção inválida. Insira um inteiro de 01 a 05.");
                        option = -1;

                    } else {
                        flag2 = false;
                    }

                } catch (InputMismatchException error) {
                    inputOption.nextLine();
                    option = -1;
                    System.out.println("ERRO: Opção inválida. Tente novamente.");
                }
            }

            flag2 = true;

            switch (option) {
                case 1:
                    System.out.print("\nInsira a expressão aritmética: ");
                    exp = inputExp.nextLine();

                    try {
                        Tokenizer expToken = new Tokenizer(exp);
                        expStrings = expToken.tokenize();
                        System.out.println("Expressão válida!");
                    } catch (Exception e) {
                        System.out.println("Expressão inválida!");
                        exp = "";
                        expStrings = null;
                    }

                    break;

                case 2:
                    System.out.println(".");
                    List<String> postfixExp = util.infixToPostfixConversion(expStrings);
                    System.out.println(postfixExp);
                    binTree.buildTreePostfix(postfixExp);
                    System.out.println(binTree.getRoot());
                    System.out.println("Árvore criada!");
                    break;

                case 3:
                    if(binTree.isEmpty()) {
                        System.out.println("Árvore vazia.");
                        continue;
                    }

                    System.out.println("Percurso em pré-ordem: ");
                    System.out.println(binTree.preOrderTraversal(binTree.getRoot()));

                    System.out.println("Percurso em ordem: ");
                    System.out.println(binTree.inOrderTraversal(binTree.getRoot()));

                    System.out.println("Percurso em pós-ordem: ");
                    System.out.println(binTree.postOrderTraversal(binTree.getRoot()));

                    break;

                case 4:
                    float result = binTree.getRoot().visit();
                    System.out.println(result);
                    break;

                default:
                    System.out.println("Encerrando...");
                    flag1 = false;
            }
        }

        inputOption.close();
        inputExp.close();
    }
}
