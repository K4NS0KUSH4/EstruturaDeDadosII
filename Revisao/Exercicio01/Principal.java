import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String nameArg = "", typeArg = "";
        Scanner input = new Scanner(System.in);
        Avaliacao evalArray[] = new Avaliacao[3];
        float maxGradeArg = 0.0f;
        int count = 0;

        while(count < 3) {
            boolean flag = true;
            int numOfEval = count + 1;
            System.out.println("\n|------------ AVALIAÇÃO " + numOfEval + " ------------|");

            System.out.print("Insira o nome: ");
            nameArg = input.nextLine();
            System.out.print("Insira o tipo: ");
            typeArg = input.nextLine();
            
            while(flag) {
                try {
                    System.out.print("Insira a nota máxima: ");
                    maxGradeArg = input.nextFloat();
                    input.nextLine();
                    flag = false;
                } catch (InputMismatchException invalidInput) {
                    System.err.println("\nEntrada de dados inválida. Tente novamente.");
                    input.nextLine();
                }
            }

            Avaliacao aux = new Avaliacao(nameArg, typeArg, maxGradeArg);
            evalArray[count] = aux;
            count++;
        }

        input.close();
        System.out.println("\n|------------ AVALIAÇOES REGISTRADAS ------------|");

        for(int i = 0; i < evalArray.length; i++) {
            System.out.println(evalArray[i].toString());
        }
    }
}