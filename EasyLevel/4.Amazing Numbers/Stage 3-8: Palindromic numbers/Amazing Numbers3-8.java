package numbers;

import java.util.Scanner;
//Stage 3/8: Palindromic numbers
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter 0 to exit.");


        while (true) {
            System.out.println("Enter a request");
            long naturalNumber = scanner.nextLong();
            if (naturalNumber == 0) {
                System.out.println("Goodbye!");
                break;
            }
            if (naturalNumber < 1) {
                System.out.println("The first parameter should be a natural number or zero.\n");

            } else {
                System.out.printf("Properties of %d%n", naturalNumber);
                itEvenOrOdd(naturalNumber);
                itBuzzNumber(naturalNumber);
                itDuckNumber(naturalNumber);
                itPalindromic(naturalNumber);

            }
            System.out.println();
        }
    }

    public static void itEvenOrOdd(long naturalNumber) {

        if (naturalNumber % 2 != 0) {
            System.out.println("        even: false");
            System.out.println("         odd: true");
        } else {
            System.out.println("        even: true");
            System.out.println("         odd: false");

        }
    }

    public static void itBuzzNumber(long naturalNumber) {

        if (naturalNumber % 7 == 0 || naturalNumber % 10 == 7) {
            System.out.println("        buzz: true");
//            System.out.println("It is a Buzz number.");
//            System.out.println("Explanation:");
//            if (naturalNumber % 7 == 0 && naturalNumber % 10 == 7) {
//                System.out.printf("%d is divisible by 7 and it ends with 7.%n", naturalNumber);
//            } else if (naturalNumber % 10 == 7) {
//                System.out.printf("%d ends with 7.", naturalNumber);
//
//            } else {
//                System.out.printf("%d is divisible by 7.%n", naturalNumber);
//            }
        } else {
            System.out.println("        buzz: false");
//            System.out.println("It is not a Buzz number.");
//            System.out.println("Explanation:");
//            System.out.printf("%d is neither divisible by 7 nor it ends with 7.", naturalNumber);
        }
    }

    public static void itDuckNumber(long naturalNumber) {
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

        if (itDuckNumber) {
            System.out.println("        duck: true");
        } else {
            System.out.println("        duck: false");
        }
    }

    public static void itPalindromic(long naturalNumber) {
        StringBuilder palindromic = new StringBuilder(String.valueOf(naturalNumber));
        String palindromic1 = String.valueOf(palindromic);
        palindromic.reverse();


        if (palindromic1.equals(String.valueOf(palindromic))) {
            System.out.println(" palindromic: true");
        } else {
            System.out.println(" palindromic: false");
        }

    }

}
