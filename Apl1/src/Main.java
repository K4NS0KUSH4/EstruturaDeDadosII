/* COMPONENTES DO GRUPO
 * NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Main {
    
    public static void printMenu() {
        System.out.println(
            "\n01. Inserir expressão aritmética (notação infixa)\n02. Criar árvore binária de expressão aritmética" +
            "\n03. Exibir árvore binária de expressão aritmética\n04. Calcular expressão\n05. Encerrar\n"
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
                if(!exp.equals("")) {
                    System.out.print("Expressão atual: " + exp + "\n");
                }
                System.out.print("Escolha uma opção: ");

                try {
                    option = inputOption.nextInt();

                    if (option <= 0 || option >= 6) {
                        System.out.println("\nERRO: Opção inválida. Insira um inteiro de 01 a 05.");
                        option = -1;

                    } else {
                        flag2 = false;
                    }

                } catch (InputMismatchException error) {
                    inputOption.nextLine();
                    option = -1;
                    System.out.println("\nERRO: Opção inválida. Tente novamente.");
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
                        
                        if(util.verifyBrackets(exp)) {
                            if(util.verifyOperators(expStrings)) {
                                System.out.println("Expressão válida!");
                            } else {
                                throw new Exception();
                            }
                            
                        } else {
                            throw new Exception();
                        }

                    } catch (Exception e) {
                        System.out.println("Expressão inválida!");
                        exp = "";
                        expStrings = null;
                    }

                    break;

                case 2:
                    List<String> postfixExp = util.infixToPostfixConversion(expStrings);
                    binTree.buildTreePostfix(postfixExp);
                    System.out.println("Árvore criada!");
                    break;

                case 3:
                    if(binTree.isEmpty()) {
                        System.out.println("\nÁrvore vazia.");
                        continue;
                    }

                    System.out.print("\nPercurso em pré-ordem: ");
                    System.out.println(binTree.preOrderTraversal(binTree.getRoot()));

                    System.out.print("Percurso em ordem: ");
                    System.out.println(binTree.inOrderTraversal(binTree.getRoot()));

                    System.out.print("Percurso em pós-ordem: ");
                    System.out.println(binTree.postOrderTraversal(binTree.getRoot()));

                    break;

                case 4:
                    float result = binTree.getRoot().visit();
                    
                    if(result == Float.POSITIVE_INFINITY || result == Float.NEGATIVE_INFINITY) {
                        System.out.println(exp + " = " + "Indefinido.");
                    }

                    else if(result == Float.NaN) {
                        System.out.println(exp + " = " + "Indeterminado.");
                    }

                    else {
                        System.out.println(exp + " = " + result);
                    }

                    break;

                default:
                    System.out.println("\nEncerrando...");
                    flag1 = false;
            }
        }

        inputOption.close();
        inputExp.close();
    }
}
