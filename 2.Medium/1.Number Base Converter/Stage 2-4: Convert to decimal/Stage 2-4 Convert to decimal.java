package converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Set input String to alternate menu
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ");
            String choiceInput = scanner.next();

            if (choiceInput.equals("/exit")) {
                return;
            } else {
                interfaceMenu(choiceInput);
            }
        }


    }

    //Step1 interface menu method you chose
    public static void interfaceMenu(String choiceInput) {
        Scanner scanner = new Scanner(System.in);
        switch (choiceInput) {
            case "/from":
                System.out.print("Enter a number in decimal system: ");
                int formDecimal = scanner.nextInt();
                System.out.print("Enter the target base: ");
                int targetBase = scanner.nextInt();
                switch (targetBase) {
                    case 2:
                        System.out.println("Conversion result: " + convertToBinary_2(formDecimal));
                        break;
                    case 8:
                        System.out.println("Conversion result: " + convertToOctal_8(formDecimal));
                        break;
                    case 16:
                        System.out.println("Conversion result: " + convertToHexadecimal_16(formDecimal));
                        break;
                    default:
                        break;
                }
                break;
            case "/to":
                System.out.print("Enter source number: ");
                String sourceNumber = scanner.next();
                System.out.print("Enter source base: ");
                int sourceBase = scanner.nextInt();
                switch (sourceBase) {
                    case 2:
                        System.out.println("Conversion to decimal result: " + convertBinary_2ToDecimal(sourceNumber));
                        break;
                    case 8:
                        System.out.println("Conversion to decimal result: " + convertOctal_8ToDecimal(sourceNumber));
                        break;
                    case 16:
                        System.out.println("Conversion to decimal result: " + convertHexadecimal_16ToDecimal(sourceNumber));
                        break;

                }
                break;
        }


    }


    //Step 2 set method that return binary_2
    // form convert decimal number with Integer.toBinaryString()
    public static StringBuilder convertToBinary_2(int inputDecimal) {
        StringBuilder storeOfBinary_2 = new StringBuilder();
        storeOfBinary_2.append(Integer.toBinaryString(inputDecimal));

        return storeOfBinary_2;

    }

    //Step 2.1 convert Binary_2 to decimal number with Integer.parseInt()
    public static int convertBinary_2ToDecimal(String inputBinary_2) {

        return Integer.parseInt(inputBinary_2, 2);
    }

    //Step 3 set method that return octalNumber_8
    // form convert decimal number with Integer.toOctalString()
    public static StringBuilder convertToOctal_8(int inputDecimal) {
        StringBuilder storeOfOctal_8 = new StringBuilder();
        storeOfOctal_8.append(Integer.toOctalString(inputDecimal));
        return storeOfOctal_8;
    }

    //Step 3.1 convert Octal_8 to decimal number with Integer.parseInt()
    public static int convertOctal_8ToDecimal(String inputOctal_8) {

        return Integer.parseInt(inputOctal_8, 8);
    }

    //Step 4 set method that return Hexadecimal_16
    // form convert decimal number with Integer.toHexString()
    public static StringBuilder convertToHexadecimal_16(int inputDecimal) {
        StringBuilder storeOfHexadecimal_16 = new StringBuilder();

        storeOfHexadecimal_16.append(Integer.toHexString(inputDecimal));
        return storeOfHexadecimal_16;

    }

    //Step 4.1 convert Hexadecimal_16 to decimal number with Integer.parseInt()
    public static int convertHexadecimal_16ToDecimal(String inputOctal_8) {

        return Integer.parseInt(inputOctal_8, 16);
    }


}
