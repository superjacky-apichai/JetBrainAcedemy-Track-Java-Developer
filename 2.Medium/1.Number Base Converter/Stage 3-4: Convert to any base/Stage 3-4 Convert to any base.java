package converter;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Set input String to alternate menu
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            String choiceInput = scanner.next();


            if (choiceInput.equals("/exit")) {
                return;
            } else {
                int baseNumber = scanner.nextInt();
                while (true) {
                    System.out.printf("Enter number in base %s to convert to base %d (To go back type /back) ", choiceInput, baseNumber);
                    String inputNumberToConvert = scanner.next();

                    if (inputNumberToConvert.equals("/back")) {
                        break;
                    } else {

                        BigInteger output = new BigInteger(inputNumberToConvert, Integer.parseInt(choiceInput));
                        String value = output.toString(baseNumber);

                        System.out.println("Conversion result: " + value + "\n");
                    }
                }
            }
        }


    }

}
