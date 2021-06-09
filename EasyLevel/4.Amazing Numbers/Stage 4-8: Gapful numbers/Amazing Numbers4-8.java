package numbers;

import java.util.Scanner;
//Stage 4/8: Gapful numbers
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println(supportedRequests());


        while (true) {
            System.out.println("Enter a request");
            String[] input = scanner.nextLine().split(" ");
            try {

                if (input.length == 1) {
                    long naturalNumber = Long.parseLong(input[0]);
                    if (naturalNumber == 0) {
                        System.out.println("Goodbye!");
                        break;
                    } else {

                        ifItOneNumber(naturalNumber);

                    }
                } else {
                    ifItTwoNumber(input);

                }
            } catch (Exception exception) {
                System.out.println("The first parameter should be a natural number or zero.");
            }

            System.out.println();
        }

    }

    public static String supportedRequests() {
        String reports = ("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameters show how many consecutive numbers are to be processed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");

        return reports;
    }

    //ifItTwoNumber********************************************************************************************************
    public static void ifItTwoNumber(String[] naturalNumber) {
        long firstElement = Long.parseLong(naturalNumber[0]);
        long secondElement = Long.parseLong(naturalNumber[1]);
        if (secondElement < 0) {
            System.out.println("The second parameter should be a natural number");
        } else if (firstElement < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
        } else {
            for (int i = 0; i < secondElement; i++) {

                System.out.println(checkNumber(firstElement));

                firstElement += 1;
            }

        }
    }

    public static String checkNumber(long naturalNumber) {
        String checker = "         " + naturalNumber + " is ";


        if (itBuzzNumber(naturalNumber)) {
            checker = checker + ("buzz, ");
        }

        if (itDuckNumber(naturalNumber)) {
            checker = checker + ("duck, ");
        }

        if (itPalindromic(naturalNumber)) {
            checker = checker + ("palindromic, ");
        }
        if (itGapfulNumber(naturalNumber)) {
            checker = checker + ("gapful, ");
        }

        if (itEvenOrOdd(naturalNumber)) {
            checker = checker + ("even");
        } else {
            checker = checker + ("odd");
        }


        return checker;

    }

    //ifItOneNumber********************************************************************************************************
    public static void ifItOneNumber(long naturalNumber) {
        if (naturalNumber < 0) {
            System.out.println("The first parameter should be a natural number or zero.\n");

        } else {
            System.out.printf("Properties of %d%n", naturalNumber);

            if (itBuzzNumber(naturalNumber)) {
                System.out.println("        buzz: true");
            } else {
                System.out.println("        buzz: false");
            }

            if (itDuckNumber(naturalNumber)) {
                System.out.println("        duck: true");
            } else {
                System.out.println("        duck: false");
            }
            if (itPalindromic(naturalNumber)) {
                System.out.println(" palindromic: true");

            } else {
                System.out.println(" palindromic: false");
            }

            if (itGapfulNumber(naturalNumber)) {

                System.out.println("       gapful: true");
            } else {
                System.out.println("       gapful: false");
            }
            if (itEvenOrOdd(naturalNumber)) {
                System.out.println("        even: true");
                System.out.println("         odd: false");
            } else {
                System.out.println("        even: false");
                System.out.println("         odd: true");

            }
        }

    }

    //itEvenOrOdd*********************************************************************
    public static boolean itEvenOrOdd(long naturalNumber) {
        return naturalNumber % 2 == 0;
    }

    //itBuzzNumber*********************************************************************
    public static boolean itBuzzNumber(long naturalNumber) {

        return naturalNumber % 7 == 0 || naturalNumber % 10 == 7;
    }

    //itDuckNumber*********************************************************************
    public static boolean itDuckNumber(long naturalNumber) {
        long backUp;
        boolean itDuckNumber = false;

        while (naturalNumber > 0) {
            backUp = naturalNumber % 10;

            if (backUp == 0) {
                itDuckNumber = true;
                break;
            } else {
                naturalNumber = naturalNumber / 10;
            }
        }

        return itDuckNumber;
    }

    //itPalindromic*********************************************************************
    public static boolean itPalindromic(long naturalNumber) {
        StringBuilder palindromic = new StringBuilder(String.valueOf(naturalNumber));
        String palindromic1 = String.valueOf(palindromic);
        palindromic.reverse();

        return palindromic1.equals(String.valueOf(palindromic));
    }

    //itGapfulNumber*********************************************************************
    public static boolean itGapfulNumber(long naturalNumber) {
        String[] gapful = String.valueOf(naturalNumber).split("");

        if (gapful.length < 3) {
            return false;
        } else {
            String firstAndLast = gapful[0] + gapful[gapful.length - 1];
            int sumFirstAndLast = Integer.parseInt(firstAndLast);

            return naturalNumber % sumFirstAndLast == 0;

        }

    }

}
