package numbers;

import java.util.Locale;
import java.util.Scanner;
//Stage 6/8: Sunny and Square numbers
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println(supportedRequests());


        while (true) {
            System.out.print("Enter a request: ");
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
                }
                else if (input.length == 2) {
                    ifItTwoNumber(input);

                }
                else if (input.length == 3) {
                    ifItThreeNumber(input);
                }
                else if (input.length == 4) {
                    ifItFourNumber(input);
                }
            } catch (Exception exception) {
                System.out.println("The first parameter should be a natural number or zero.");
            }

            System.out.println();
        }

    }

    public static String supportedRequests() {
        return ("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameters show how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and two properties to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }


    //checkNumber*********************************************************************************************************************
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

        if (itSpyNumber(naturalNumber)) {
            checker = checker + ("spy, ");
        }
        if (itSquareNumber(naturalNumber)) {
            checker = checker + ("square, ");
        }

        if (itSunnyNumber(naturalNumber)) {
            checker = checker + ("sunny, ");
        }

        if (itEvenOrOdd(naturalNumber)) {
            checker = checker + ("even");
        } else {
            checker = checker + ("odd");
        }


        return checker;

    }


    //ifItFourNumber***************************************************************************************************
    public static void ifItFourNumber(String[] naturalNumber) {
        long firstElement = Long.parseLong(naturalNumber[0]);
        long secondElement = Long.parseLong(naturalNumber[1]);

        if (secondElement < 0) {
            System.out.println("The second parameter should be a natural number");
            return;
        } else if (firstElement < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            return;

        }

        String[] toCompare = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "EVEN", "ODD"};
        boolean[] findObject = new boolean[2];
        int[] whereToFindObject = new int[2];
        for (int i = 0; i < toCompare.length; i++) {
            if (naturalNumber[2].equalsIgnoreCase(toCompare[i])) {
                findObject[0] = true;
                whereToFindObject[0] = i;
                break;
            }

        }

        for (int i = 0; i < toCompare.length; i++) {
            if (naturalNumber[3].equalsIgnoreCase(toCompare[i])) {
                findObject[1] = true;
                whereToFindObject[1] = i;
                break;
            }

        }
        if (!findObject[0] && !findObject[1]) {
            System.out.printf("The properties [%s,%s] are wrong.\n" +
                    "Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD]", naturalNumber[2].toUpperCase(Locale.ROOT), naturalNumber[3].toUpperCase(Locale.ROOT));
            return;
        } else if (!findObject[0]) {
            System.out.printf("The property [%s] is wrong.\n" +
                    "Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD]", naturalNumber[2].toUpperCase(Locale.ROOT));
            return;
        } else if (!findObject[1]) {
            System.out.printf("The property [%s] is wrong.\n" +
                    "Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD]", naturalNumber[3].toUpperCase(Locale.ROOT));
            return;
        } else if (whereToFindObject[0] == 5 && whereToFindObject[1] == 6 || whereToFindObject[0] == 6 && whereToFindObject[1] == 5) {
            System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]\n" +
                    "There are no numbers with these properties.");
            return;
        } else if (whereToFindObject[0] == 7 && whereToFindObject[1] == 8 || whereToFindObject[0] == 8 && whereToFindObject[1] == 7) {
            System.out.println("The request contains mutually exclusive properties: [ODD, EVEN]\n" +
                    "There are no numbers with these properties.");
            return;
        } else if (whereToFindObject[0] == 1 && whereToFindObject[1] == 4 || whereToFindObject[0] == 4 && whereToFindObject[1] == 1) {
            System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]\n" +
                    "There are no numbers with these properties.");
            return;
        }


        while (secondElement > 0) {

            boolean[] letCheck = {itBuzzNumber(firstElement), itDuckNumber(firstElement), itPalindromic(firstElement),
                    itGapfulNumber(firstElement), itSpyNumber(firstElement), itSquareNumber(firstElement),
                    itSunnyNumber(firstElement), itEvenOrOdd(firstElement), !itEvenOrOdd(firstElement)};

            if (letCheck[whereToFindObject[0]] && letCheck[whereToFindObject[1]]) {
                System.out.println(checkNumber(firstElement));
                secondElement--;
            }
            firstElement++;

        }

    }


    //ifItThreeNumber***************************************************************************************************
    public static void ifItThreeNumber(String[] naturalNumber) {
        long firstElement = Long.parseLong(naturalNumber[0]);
        long secondElement = Long.parseLong(naturalNumber[1]);

        if (secondElement < 0) {
            System.out.println("The second parameter should be a natural number");
            return;
        } else if (firstElement < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            return;

        }

        String[] toCompare = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "EVEN", "ODD"};
        boolean findObject = false;
        int whereToFind = 0;
        for (int i = 0; i < toCompare.length; i++) {
            if (naturalNumber[2].equalsIgnoreCase(toCompare[i])) {
                findObject = true;
                whereToFind = i;
                break;
            }
        }

        if (!findObject) {
            System.out.printf("The property [%s] is wrong.\n" +
                    "Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD]", naturalNumber[2].toUpperCase(Locale.ROOT));
            return;
        }

        while (secondElement > 0) {

            boolean[] letCheck = {itBuzzNumber(firstElement), itDuckNumber(firstElement), itPalindromic(firstElement),
                    itGapfulNumber(firstElement), itSpyNumber(firstElement), itSquareNumber(firstElement),
                    itSunnyNumber(firstElement), itEvenOrOdd(firstElement), !itEvenOrOdd(firstElement)};

            if (letCheck[whereToFind]) {

                System.out.println(checkNumber(firstElement));
                secondElement--;
            }

            firstElement++;
        }

    }


    //ifItTwoNumber********************************************************************************************************
    public static void ifItTwoNumber(String[] naturalNumber) {
        long firstElement = Long.parseLong(naturalNumber[0]);
        long secondElement = Long.parseLong(naturalNumber[1]);
        if (secondElement < 0) {
            System.out.println("The second parameter should be a natural number");
            return;
        } else if (firstElement < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            return;
        }


        for (int i = 0; i < secondElement; i++) {

            System.out.println(checkNumber(firstElement));

            firstElement += 1;
        }


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

                System.out.println("      gapful: true");
            } else {
                System.out.println("      gapful: false");
            }

            if (itSpyNumber(naturalNumber)) {

                System.out.println("         spy: true");
            } else {
                System.out.println("         spy: false");
            }


            if (itSquareNumber(naturalNumber)) {

                System.out.println("         square: true");
            } else {
                System.out.println("         square: false");
            }

            if (itSunnyNumber(naturalNumber)) {

                System.out.println("         sunny: true");
            } else {
                System.out.println("         sunny: false");
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

    //itSpyNumber*********************************************************************
    public static boolean itSpyNumber(long naturalNumber) {
        if (naturalNumber < 10) {
            return true;
        }
        String[] separate = String.valueOf(naturalNumber).split("");
        int[] toInt = new int[separate.length];
        for (int i = 0; i < separate.length; i++) {
            toInt[i] = Integer.parseInt(separate[i]);
        }

        long sumPlus = 0;
        long sumMultiply = 1;
        for (int j : toInt) {

            sumPlus += j;
            sumMultiply *= j;

        }
        return sumPlus == sumMultiply;
    }

    //itSquareNumber*********************************************************************
    public static boolean itSquareNumber(long naturalNumber) {

        double forSquare = naturalNumber;


        return Math.sqrt(forSquare) % 1 == 0;
    }

    //itSunnyNumber*********************************************************************
    public static boolean itSunnyNumber(long naturalNumber) {

        double forSquare = naturalNumber;

        return (Math.sqrt(forSquare + 1) % 1 == 0);
    }



}
