/* COMPONENTES DO GRUPO
 * NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
*/

/* REFERÊNCIAS
 * 
 * KISHIMOTO, ANDRÉ. 
 * Material da disciplina. Disponível na plataforma online Moodle.
 * 
 * HATZ, Diogo; AKINA, Leila; ALABARSE, Livia; FARIAS, Pedro.
 * Apl1 de Estrutura de Dados I, 3° Semestre do curso de Ciência da Computação.
 * 
 * ORACLE 
 * Java Documentation: Class ArrayList<E>
 * Disponível em https://docs.oracle.com/javase/8/docs/api/java/util/List.html
 * 
 * ORACLE
 * Java Documentation: Class Stack<E>
 * Disponível em https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
 * 
 * ORACLE
 * Java Documentation: Class List<E>
 * Disponível em https://docs.oracle.com/javase/8/docs/api/java/util/List.html
 * 
 * DEVMEDIA
 * Erro nextLine();
 * Disponível em https://www.devmedia.com.br/forum/erro-usando-metodo-nextline-em-java/509349
 * 
 * GEEKSFORGEEKS
 * Binary Tree Data Structure
 * Disponível em https://www.geeksforgeeks.org/binary-tree-data-structure/
 * 
 * UFRGS MAT
 * Calculando com o zero: dividindo por zero
 * Disponível em http://www.mat.ufrgs.br/~portosil/passa7d.html#:~:text=a%20divis%C3%A3o%201%2F0%20%C3%A9,divis%C3%A3o%200%2F0%20%C3%A9%20indeterminada
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
                    if(exp.equals("")) {
                        System.out.println("\nÁrvore inexistente. Utilize a opção 01 para criar uma árvore de expressão algébrica.");
                        continue;
                    }

                    List<String> postfixExp = util.infixToPostfixConversion(expStrings);
                    binTree.buildTreePostfix(postfixExp);
                    System.out.println("\nÁrvore criada!");
                    break;

                case 3:
                    if(binTree.isEmpty()) {
                        System.out.println("\nÁrvore vazia. Utilize a opção 01 para criar uma árvore de expressão algébrica.");
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
                    if(binTree.isEmpty()) {
                        System.out.println("\nÁrvore vazia. Utilize a opção 01 para criar uma árvore de expressão algébrica.");
                        continue;
                    }

                    System.out.println();

                    float result = binTree.getRoot().visit();
                    
                    if(result == Float.POSITIVE_INFINITY || result == Float.NEGATIVE_INFINITY) {
                        System.out.println(exp + " = " + "Indefinido.");
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
