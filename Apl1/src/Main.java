import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void printMenu() {
        System.out.println(
            "\n01. Inserir expressão aritmética (notação infixa)\n02. Criar árvore binária de expressão aritmética" +
            "\n03. Exibir árvore binária de expressão aritmética\n04. Calcular expressão\n05. Encerrar"
            );
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String expInput = "";
        boolean flag1 = true, flag2 = true;
        int option = -1;

        while (flag1) {
            printMenu();

            while (flag2) {
                System.out.print("Escolha uma opção: ");

                try {
                    option = input.nextInt();

                    if (option <= 0 || option >= 6) {
                        System.out.println("ERRO: Opção inválida. Insira um inteiro de 01 a 05.");
                        option = -1;

                    } else {
                        flag2 = false;
                    }

                } catch (InputMismatchException error) {
                    input.nextLine();
                    option = -1;
                    System.out.println("ERRO: Opção inválida. Tente novamente.");
                }
            }

            flag2 = true;

            switch (option) {
                case 1:
                    // entrada
                    break;

                case 2:
                    // criacao
                    break;

                case 3:
                    // exibicao
                    break;

                case 4:
                    // calculo
                    break;

                default:
                    System.out.println("Encerrando...");
                    flag1 = false;
            }
        }

        input.close();
    }
}
