package converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Set input int variable as decimal number
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number in decimal system: ");
        System.out.println();
        int decimalInput = scanner.nextInt();

        //input the target base that you want to convert
        //as binary_2  octal_8  Hexadecimal_16
        System.out.print("Enter target base: ");
        System.out.println();
        int targetBase = scanner.nextInt();

        //this method is the interface menu you chose the target base
        interfaceMenu(decimalInput, targetBase);
    }

    //Step1 interface menu method you chose which targetBase you want to convert
    public static void interfaceMenu(int inputDecimal, int targetBase) {

        switch (targetBase) {
            case 2:
                System.out.println("Conversion result: " + convertToBinary_2(inputDecimal));
                break;
            case 8:
                System.out.println("Conversion result: " + convertToOctal_8(inputDecimal));
                break;
            case 16:
                System.out.println("Conversion result: " + convertToHexadecimal_16(inputDecimal));
                break;
            default:
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

    //Step 3 set method that return octalNumber_8
    // form convert decimal number with Integer.toOctalString()
    public static StringBuilder convertToOctal_8(int inputDecimal) {
        StringBuilder storeOfOctal_8 = new StringBuilder();
        storeOfOctal_8.append(Integer.toOctalString(inputDecimal));
        return storeOfOctal_8;
    }

    //Step 4 set method that return Hexadecimal_16
    // form convert decimal number with Integer.toHexString()
    public static StringBuilder convertToHexadecimal_16(int inputDecimal) {
        StringBuilder storeOfHexadecimal_16 = new StringBuilder();

        storeOfHexadecimal_16.append(Integer.toHexString(inputDecimal));
        return storeOfHexadecimal_16;
    }
}
