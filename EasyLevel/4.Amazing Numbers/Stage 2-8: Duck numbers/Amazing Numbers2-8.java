package numbers;

import java.util.Scanner;
//Stage 2/8: Duck numbers
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int naturalNumber = scanner.nextInt();

        if (naturalNumber < 1) {
            System.out.println("This number is not natural!");
        } else {
            System.out.printf("Properties of %d%n", naturalNumber);
            itEvenOrOdd(naturalNumber);
            itBuzzNumber(naturalNumber);
            itDuckNumber(naturalNumber);

        }
    }

    public static void itEvenOrOdd(int naturalNumber) {

        if (naturalNumber % 2 != 0) {
            System.out.println("even: false");
            System.out.println("odd: true");
        } else {
            System.out.println("even: true");
            System.out.println("odd: false");

        }
    }

    public static void itBuzzNumber(int naturalNumber) {

        if (naturalNumber % 7 == 0 || naturalNumber % 10 == 7) {
            System.out.println("buzz: true");
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
            System.out.println("buzz: false");
//            System.out.println("It is not a Buzz number.");
//            System.out.println("Explanation:");
//            System.out.printf("%d is neither divisible by 7 nor it ends with 7.", naturalNumber);
        }
    }

    public static void itDuckNumber(int naturalNumber) {
        int backUp = 0;
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
            System.out.println("duck: true");
        } else {
            System.out.println("duck: false");
        }
    }

}
