package converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Use while loop to reuse program when user don't print "/exit"
        while (true) {
            // input baseNumber form base number system, and it can input "/exit"to terminate program
            System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            String choiceInput = scanner.next();

            //Program will terminate if user input String "/exit"
            if (choiceInput.equals("/exit")) {
                return;
            } else {
                //if program input baseNumber program will implement this block
                //input target base Number to convert to
                int toBaseNumber = scanner.nextInt();
                //use while loop to reuse program while the program don't print "/back"
                while (true) {
                    System.out.printf("Enter number in base %s to convert to base %d (To go back type /back) ", choiceInput, toBaseNumber);
                    //input number that you want to convert
                    String inputNumberToConvert = scanner.next();
                    //used to split if this program input bigDecimal number
                    String[] firstHalfAndSecond = inputNumberToConvert.split("\\.");

                    //this block will terminate to main program if in user input "/back"
                    if (inputNumberToConvert.equals("/back")) {
                        System.out.println();
                        break;
                    } else if (firstHalfAndSecond.length == 1) {
                        // this block will implement if user input only Biginteger
                        //used to create Biginteger Instance to store Number in base number
                        BigInteger output = new BigInteger(inputNumberToConvert, Integer.parseInt(choiceInput));
                        //create String to store and convert form base Number bigInteger to target base number
                        String value = output.toString(toBaseNumber);

                        //output the result
                        System.out.println("Conversion result: " + value + "\n");
                    } else if (firstHalfAndSecond.length == 2) {
                        //this block will implement if user input BigDecimal
                        //used to separate to 2 part fist integer number second fraction number
                        //first part convert to BigInteger and convert from base number to target number
                        BigInteger Big1 = new BigInteger(firstHalfAndSecond[0], Integer.parseInt(choiceInput));
                        // create String sum to store the result from first part and second part and output it
                        String sum = Big1.toString(toBaseNumber);

                        //create String secondHalf to store second part(FractionNumber) and implement in covertFraction method
                        String secondHalf = firstHalfAndSecond[1];
                        //covertFraction method is used to convert BigDecimal number from base number to targetNumber
                        sum += covertFraction(choiceInput, toBaseNumber, secondHalf);
                        //output the result
                        System.out.println("Conversion result: " + sum + "\n");


                    }
                }
            }
        }


    }

    //this method referent form https://www.rapidtables.com/convert/number/base-converter.html
    // and input convert referent form 35 to 17 and num af.xy
    // Example
    //Enter number in base 35 to convert to base 17 (To go back type /back) > af.xy
    // Conversion result: 148.g88a8
    public static String covertFraction(String form, int to, String input) {
        //need to create toCharArray to convert from single baser than 10  to number and store it to inputArray
        String[] toChar = input.split("");
        String[] inputArray = new String[toChar.length];

        //convert from single baser than 10  to number and store it to inputArray
        for (int i = 0; i < toChar.length; i++) {
            inputArray[i] = String.valueOf(Integer.parseInt((toChar[i]), Integer.parseInt(form)));
        }

        //convert from base integer number to fraction base number
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = String.valueOf(Integer.parseInt(inputArray[i]) * Math.pow(Double.parseDouble(form), -(i + 1)));
        }

        //store String s to store sum of all fraction number in input array
        String s = inputArray[0];
        if (inputArray.length > 1) {
            for (int i = 1; i < inputArray.length; i++) {
                s = String.valueOf(Double.parseDouble(s) + Double.parseDouble(inputArray[i]));

            }
        }

        //create BigDecimal outputBigDecimal to store fraction value from
        BigDecimal outputBigDecimal = new BigDecimal(s);
        //Convert base number target integer to BigDecimal
        BigDecimal convertTo = new BigDecimal(to);
        //BeCause task want juts only 5 fraction digit number
        //we store input result to store result from converting
        //and power up outputBigDecimal to 5
        String[] inputResult = new String[5];
        outputBigDecimal = outputBigDecimal.multiply(convertTo.pow(5));

        //collect the result from convert to base target number to inputResult array
        for (int i = 4; i >= 0; i--) {
            inputResult[i] = String.valueOf(outputBigDecimal.remainder(convertTo));
            outputBigDecimal = outputBigDecimal.divide(convertTo, 5, RoundingMode.HALF_DOWN);
        }

        //split fraction out to collect only integer number result
        StringBuilder outputResult = new StringBuilder(".");
        for (int i = 0; i < 5; i++) {
            String[] arrayForSplit = inputResult[i].split("\\.");

            outputResult.append(Character.forDigit(Integer.parseInt(arrayForSplit[0]), to));
        }
        // return the result
        return outputResult.toString();

    }

}
