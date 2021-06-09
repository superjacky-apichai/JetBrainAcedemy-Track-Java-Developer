package numbers;


import java.util.Scanner;
//Stage 7/8: Jumping numbers
public class Main {
    final private static Scanner scanner = new Scanner(System.in);
    final private static String welcomeText = "Welcome to Amazing Numbers!\n" +
            "\n" +
            "Supported requests:\n" +
            "- enter a natural number to know its properties;\n" +
            "- enter two natural numbers to obtain the properties of the list:\n" +
            "  * the first parameter represents a starting number;\n" +
            "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
            "- two natural numbers and properties to search for;\n" +
            "- separate the parameters with one space;\n" +
            "- enter 0 to exit.\n";


    public static void main(String[] args) {
        System.out.println(welcomeText);

        while (true) {
            System.out.print("Enter a request: ");

            String[] forCountElement = scanner.nextLine().split("\\s");

            try {

                long naturalNumber = Long.parseLong(forCountElement[0]);
                if (naturalNumber < 0) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    continue;
                }

            } catch (Exception e) {
                System.out.println("The first parameter should be a natural number or zero.");
                continue;
            }


            long naturalNumber = Long.parseLong(forCountElement[0]);


            if (naturalNumber == 0) {
                System.out.println("Goodbye!");
                break;
            } else if (forCountElement.length == 1) {
                LessThanTwoElement.oneElement(naturalNumber);
            } else {
                try {
                    long secondElement = Long.parseLong(forCountElement[1]);
                    if (secondElement < 1) {
                        System.out.println("The second parameter should be a natural number.");
                        continue;
                    }


                } catch (Exception e) {
                    System.out.println("The second parameter should be a natural number.");
                    continue;
                }

                if (forCountElement.length == 2) {
                    LessThanTwoElement.twoElement(forCountElement);
                } else {
                    FindNumberMoreThanThreeElement.moreThanThreeElement(forCountElement);
                }

            }

        }
    }


}

