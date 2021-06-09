package numbers;

import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;

public class LessThanTwoElement {
    final private static NumberFormat format = NumberFormat.getInstance(Locale.US);


    public static void oneElement(long naturalNumber) {
        System.out.println("Properties of " + format.format(naturalNumber));
        System.out.printf("       even: %s%n", itEvenOrOdd(naturalNumber));
        System.out.printf("        odd: %s%n", !itEvenOrOdd(naturalNumber));
        System.out.printf("       buzz: %s%n", itBuzzNumber(naturalNumber));
        System.out.printf("       duck: %s%n", itDuckNumber(naturalNumber));
        System.out.printf("palindromic: %s%n", itPalindromic(naturalNumber));
        System.out.printf("     gapful: %s%n", itGapfulNumber(naturalNumber));
        System.out.printf("        spy: %s%n", itSpyNumber(naturalNumber));
        System.out.printf("     square: %s%n", itSquareNumber(naturalNumber));
        System.out.printf("      sunny: %s%n", itSunnyNumber(naturalNumber));
        System.out.printf("    jumping: %s%n", itJumpingNumber(naturalNumber));
        System.out.printf("      happy: %s%n", isHappy(naturalNumber));
        System.out.printf("        sad: %s%n", !isHappy(naturalNumber));


    }

    public static void twoElement(String[] element) {
        long naturalNumber = Long.parseLong(element[0]);
        long elementTwo = Long.parseLong(element[1]);

        while (elementTwo > 0) {

            String stringBuilder = format.format(naturalNumber) + " is " +
                    (itEvenOrOdd(naturalNumber) ? "even, " : "odd, ") +
                    (itBuzzNumber(naturalNumber) ? "buzz, " : "") +
                    (itDuckNumber(naturalNumber) ? "duck, " : "") +
                    (itPalindromic(naturalNumber) ? "palindromic, " : "") +
                    (itGapfulNumber(naturalNumber) ? "gapful, " : "") +
                    (itSpyNumber(naturalNumber) ? "spy, " : "") +
                    (itSquareNumber(naturalNumber) ? "square, " : "") +
                    (itSunnyNumber(naturalNumber) ? "sunny, " : "") +
                    (itJumpingNumber(naturalNumber) ? "jumping, " : "") +
                    (isHappy(naturalNumber) ? "happy" : "") +
                    (!isHappy(naturalNumber) ? "sad" : "");

            System.out.println(stringBuilder);
            naturalNumber++;
            elementTwo--;
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


        return Math.sqrt((double) naturalNumber) % 1 == 0;
    }

    //itSunnyNumber*********************************************************************
    public static boolean itSunnyNumber(long naturalNumber) {

        return (Math.sqrt((double) naturalNumber + 1) % 1 == 0);
    }

    //itJumpingNumber*********************************************************************
    public static boolean itJumpingNumber(long naturalNumber) {
        String[] separateNumber = String.valueOf(naturalNumber).split("");
        boolean itJumping = false;
        int[] reUnite = new int[separateNumber.length];

        for (int i = 0; i < separateNumber.length; i++) {
            reUnite[i] = Integer.parseInt(separateNumber[i]);
        }
        if (reUnite.length == 1) {
            return true;
        } else {
            for (int i = 0; i < reUnite.length - 1; i++) {
                if (reUnite[i] + 1 == reUnite[i + 1] || reUnite[i] - 1 == reUnite[i + 1]) {
                    itJumping = true;
                } else {
                    itJumping = false;
                    break;
                }
            }
        }
        return itJumping;
    }


    //itHappyNumber*********************************************************************
    static int sumDigitSquare(long naturalNumber) {
        int sq = 0;
        while (naturalNumber > 0) {
            long digit = naturalNumber % 10;
            sq += digit * digit;
            naturalNumber = naturalNumber / 10;
        }
        return sq;
    }

    static boolean isHappy(long naturalNumber) {

        HashSet<Long> s = new HashSet<>();
        s.add(naturalNumber);

        while (true) {


            if (naturalNumber == 1)
                return true;


            naturalNumber = sumDigitSquare(naturalNumber);


            if ((s.contains(naturalNumber) && naturalNumber != (long) s.toArray()[s.size() - 1]))
                return false;

            s.add(naturalNumber);
        }
    }
}
