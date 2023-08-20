import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    // Item A
    private static final int MAX_CARROS = 100; 
    private static Automovel autoArray[] = new Automovel[MAX_CARROS];

    // Item D 
    public static String getCarsOf(String marcaArg) {
        StringBuilder buffer = new StringBuilder();

        for(int i = 0; i < autoArray.length; i++) {
            if(autoArray[i] != null && autoArray[i].getMarca().equals(marcaArg)) {
                buffer.append(autoArray[i] + "\n");
            }
        }

        return buffer.toString();
    }

    // Item E 
    public static float getAverageOf(Automovel[] array) {
        float total = 0.0f;
        int arrayLength = 0;
        int count = 0;

        while(array[count] != null) {
            total += array[count].getPreco();
            arrayLength++;
            count++;
        }

        return (total/(float)arrayLength);
    }

    // Item F 
    public static int getNumAfter(int anoArg) {
        int count = 0, numAfter = 0;

        while(autoArray[count] != null) {
            if(autoArray[count].getAno() == anoArg) {
                numAfter++;
            }

            count++;
        }

        return numAfter;
    }

    // Item G 
    public static float getAverageBetween(int startYear, int finalYear) {
        float total = 0.0f;
        int count = 0, numOfCarsBetween = 0;

        while(autoArray[count] != null) {
            int currentCarYear = autoArray[count].getAno();

            if(currentCarYear >= startYear && currentCarYear <= finalYear) {
                total += autoArray[count].getPreco();
                numOfCarsBetween++;
            }

            count++;
        }

        return (total/(float) numOfCarsBetween); 
    }

    public static void main(String[] args) {
        int numOfCars = 0, anoArg = 0, afterYear = 0, startYearArg = 0, finalYearArg = 0;
        Scanner input = new Scanner(System.in);
        String placaArg = "", marcaArg = "";
        float precoArg = 0.0f;
        boolean flag = true;

        // Item B
        while(flag) {
            try {
                System.out.print("Insira o número de carros (Máximo = 100): ");
                numOfCars = input.nextInt();

                if(numOfCars >= 0 && numOfCars <= MAX_CARROS) {
                    flag = false;
                } else {
                    System.out.println("Número inválido. Tente novamente.");
                }

                input.nextLine();
            } catch (InputMismatchException error) {
                System.err.println("Entrada de dados inválida. Tente novamente.");
                input.nextLine(); 
            }
        }

        for(int i = 0; i < numOfCars; i++) {
            int numOfAuto = i + 1;
            System.out.println("\n|------------ AUTOMÓVEL " + numOfAuto + " ------------|");
            System.out.print("Insira a placa do automóvel: ");
            placaArg = input.nextLine();
            System.out.print("Insira a marca do automóvel: ");
            marcaArg = input.nextLine();
            
            flag = true;
            while(flag) {
                try {
                    System.out.print("Insira o ano do automóvel: ");
                    anoArg = input.nextInt();
                    input.nextLine();
                    flag = false;
                } catch (InputMismatchException error) {
                    System.err.println("\nEntrada de dados inválida. Tente novamente.");
                    input.nextLine();
                }
            }

            flag = true;
            while(flag) {
                try {
                    System.out.print("Insira o preço do automóvel: ");
                    precoArg = input.nextFloat();
                    input.nextLine();
                    flag = false;
                } catch (InputMismatchException error) {
                    System.err.println("\nEntrada de dados inválida. Tente novamente.");
                    input.nextLine();
                }
            }

            Automovel aux = new Automovel(placaArg, marcaArg, anoArg, precoArg);
            autoArray[i] = aux;
        }

        // Item C
        System.out.println("\n|------------ AUTOMÓVEIS REGISTRADOS ------------|");
        for(int j = 0; j < numOfCars; j++) {
            System.out.println(autoArray[j].toString());
        }

        System.out.print("\nInsira uma marca de automóvel: ");
        String marcaInput = input.nextLine();
        System.out.println("\n|------------ AUTOMÓVEIS DA MARCA " + marcaInput + 
            " ------------|");
        System.out.println(getCarsOf(marcaInput));

        System.out.println("Preço médio dos carros registrados: R$" + getAverageOf(autoArray) + "\n");

        flag = true;
        while(flag) {
            try {
                System.out.print("Insira um ano: ");
                afterYear = input.nextInt();
                input.nextLine();
                
                if(afterYear < 0) {
                    System.out.println("Ano inválido. Tente novamente");
                } else {
                    flag = false;
                }
            } catch (InputMismatchException error) {
                System.err.println("Entrada de dados inválida (apenas números inteiros). Tente novamente.");
                input.nextLine();
            }
        }

        afterYear++;
        System.out.println("Número de automóveis fabricados em " + afterYear + 
        " (um ano após o ano informado): " + getNumAfter(afterYear) + "\n");

        flag = true;
        while(flag) {
            try {
                System.out.print("Insira o ano inicial: ");
                startYearArg = input.nextInt();
                input.nextLine();

                if(startYearArg < 0) {
                    System.out.println("Ano inválido. Tente novamente.");
                } else {
                    flag = false;
                }
            } catch (InputMismatchException error) {
                System.err.println("Entrada de dados inválida (apenas números inteiros). Tente novamente.");
                input.nextLine();
            }
        }

        flag = true;
        while(flag) {
            try {
                System.out.print("Insira o ano final: ");
                finalYearArg = input.nextInt();
                input.nextLine();

                if(finalYearArg < 0 || finalYearArg < startYearArg) {
                    System.out.println("Ano inválido. Tente novamente.");
                } else {
                    flag = false;
                }
            } catch (InputMismatchException error) {
                System.err.println("Entrada de dados inválida (apenas números inteiros). Tente novamente.");
                input.nextLine();
            }
        }

        System.out.println("\nMédia dos preços dos carros fabricados de " + startYearArg +
        " até " + finalYearArg + ": R$" + getAverageBetween(startYearArg, finalYearArg));

        input.close();
    }
}