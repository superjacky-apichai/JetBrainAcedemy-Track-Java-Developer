package numbers;

import java.util.Scanner;
//Stage 1/8: Buzz numbers
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int naturalNumber = scanner.nextInt();

        if (naturalNumber < 1) {
            System.out.println("This number is not natural!");
        } else {
            itEvenOrOdd(naturalNumber);
            itBuzzNumber(naturalNumber);

        }
    }

    public static void itEvenOrOdd(int naturalNumber) {

        if (naturalNumber % 2 != 0) {
            System.out.println("This number is Odd.");
        } else {
            System.out.println("This number is Even.");
        }
    }

    public static void itBuzzNumber(int naturalNumber) {

        if (naturalNumber % 7 == 0 || naturalNumber % 10 == 7) {
            System.out.println("It is a Buzz number.");
            System.out.println("Explanation:");
            if (naturalNumber % 7 == 0 && naturalNumber % 10 == 7) {
                System.out.printf("%d is divisible by 7 and it ends with 7.%n", naturalNumber);
            } else if (naturalNumber % 10 == 7) {
                System.out.printf("%d ends with 7.", naturalNumber);

            } else {
                System.out.printf("%d is divisible by 7.%n", naturalNumber);
            }
        } else {
            System.out.println("It is not a Buzz number.");
            System.out.println("Explanation:");
            System.out.printf("%d is neither divisible by 7 nor it ends with 7.", naturalNumber);
        }
    }


}
