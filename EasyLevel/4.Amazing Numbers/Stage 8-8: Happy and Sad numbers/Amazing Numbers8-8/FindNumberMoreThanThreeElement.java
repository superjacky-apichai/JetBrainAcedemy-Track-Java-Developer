package numbers;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class FindNumberMoreThanThreeElement {

    final private static NumberFormat format = NumberFormat.getInstance(Locale.US);

    public static void moreThanThreeElement(String[] element) {
        long firstElement = Long.parseLong(element[0]);
        long secondElement = Long.parseLong(element[1]);

        if (findWrongProperty(element)) {
            while (secondElement > 0) {

                if (checkProperty(firstElement, element)) {
                    secondElement--;
                }

                firstElement++;

            }

        }

    }


    public static boolean checkProperty(long naturalNumber, String[] strings) {
        String[] s = new String[strings.length - 2];
        System.arraycopy(strings, 2, s, 0, strings.length - 2);
        boolean[] checkProperty = {LessThanTwoElement.itEvenOrOdd(naturalNumber), !LessThanTwoElement.itEvenOrOdd(naturalNumber)
                , LessThanTwoElement.itBuzzNumber(naturalNumber), LessThanTwoElement.itDuckNumber(naturalNumber)
                , LessThanTwoElement.itPalindromic(naturalNumber), LessThanTwoElement.itGapfulNumber(naturalNumber)
                , LessThanTwoElement.itSpyNumber(naturalNumber), LessThanTwoElement.itSquareNumber(naturalNumber)
                , LessThanTwoElement.itSunnyNumber(naturalNumber), LessThanTwoElement.itJumpingNumber(naturalNumber)
                , LessThanTwoElement.isHappy(naturalNumber), !LessThanTwoElement.isHappy(naturalNumber)};

        boolean allTrue = false;
        int countAllTrue = 0;
        for (property j : property.values()) {
            for (String value : s) {
                if (value.equalsIgnoreCase(String.valueOf(j)) && checkProperty[j.number] || value.equalsIgnoreCase(String.valueOf(j.section)) && !checkProperty[j.number]) {
                    allTrue = true;
                }
                if (allTrue) {
                    countAllTrue++;
                    allTrue = false;
                }

            }
        }
        if (countAllTrue == s.length) {
            System.out.println(printProperty(naturalNumber));
            return true;
        }

        return false;

    }


    public static String printProperty(long naturalNumber) {

        return format.format(naturalNumber) + " is " +
                (LessThanTwoElement.itEvenOrOdd(naturalNumber) ? "even, " : "odd, ") +
                (LessThanTwoElement.itBuzzNumber(naturalNumber) ? "buzz, " : "") +
                (LessThanTwoElement.itDuckNumber(naturalNumber) ? "duck, " : "") +
                (LessThanTwoElement.itPalindromic(naturalNumber) ? "palindromic, " : "") +
                (LessThanTwoElement.itGapfulNumber(naturalNumber) ? "gapful, " : "") +
                (LessThanTwoElement.itSpyNumber(naturalNumber) ? "spy, " : "") +
                (LessThanTwoElement.itSquareNumber(naturalNumber) ? "square, " : "") +
                (LessThanTwoElement.itSunnyNumber(naturalNumber) ? "sunny, " : "") +
                (LessThanTwoElement.itJumpingNumber(naturalNumber) ? "jumping, " : "") +
                (LessThanTwoElement.isHappy(naturalNumber) ? "happy" : "") +
                (!LessThanTwoElement.isHappy(naturalNumber) ? "sad" : "");

    }

    public static boolean findWrongProperty(String[] strings) {
        String[] s = new String[strings.length - 2];
        System.arraycopy(strings, 2, s, 0, strings.length - 2);

        boolean toFindWrongWord = true;
        StringBuilder fillWrongWord = new StringBuilder();

        for (String value : s) {
            for (property j : property.values()) {
                if (value.equalsIgnoreCase(String.valueOf(j)) || value.equalsIgnoreCase(String.valueOf(j.section))) {
                    toFindWrongWord = false;
                    break;
                }
            }

            if (toFindWrongWord) {
                fillWrongWord.append(value).append(" ");
            }
            toFindWrongWord = true;
        }
        String[] wrongWord = fillWrongWord.toString().split(" ");
        if (fillWrongWord.length() > 0) {


            System.out.printf("The %s %s %s wrong.\n" +
                    "Available properties: [EVEN, ODD,BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING,SAD,HAPPY]%n", wrongWord.length == 1 ? "property" : "properties", Arrays.toString(wrongWord).toUpperCase(Locale.ROOT), wrongWord.length == 1 ? "is" : "are");

            return false;
        } else {
            for (String value : s) {
                for (String item : s) {

                    if (value.equalsIgnoreCase("odd") && item.equalsIgnoreCase("even")
                            || item.equalsIgnoreCase("odd") && value.equalsIgnoreCase("even")) {
                        System.out.println("The request contains mutually exclusive properties: [EVEN, ODD] \n" +
                                "There are no numbers with these properties.");
                        return false;
                    } else if ((value.equalsIgnoreCase("square") && item.equalsIgnoreCase("sunny")
                            || item.equalsIgnoreCase("square") && value.equalsIgnoreCase("sunny"))) {
                        System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY] \n" +
                                "There are no numbers with these properties.");
                        return false;
                    } else if ((value.equalsIgnoreCase("duck") && item.equalsIgnoreCase("spy")
                            || item.equalsIgnoreCase("duck") && value.equalsIgnoreCase("spy"))) {
                        System.out.println("The request contains mutually exclusive properties: [DUCK, SPY] \n" +
                                "There are no numbers with these properties.");
                        return false;
                    } else if (item.equalsIgnoreCase("-odd") && value.equalsIgnoreCase("-even")
                            || value.equalsIgnoreCase("-odd") && item.equalsIgnoreCase("-even")) {
                        System.out.println("The request contains mutually exclusive properties: [-EVEN, -ODD] \n" +
                                "There are no numbers with these properties.");
                        return false;
                    } else if (item.equalsIgnoreCase("happy") && value.equalsIgnoreCase("sad")
                            || value.equalsIgnoreCase("happy") && item.equalsIgnoreCase("sad")) {
                        System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD] \n" +
                                "There are no numbers with these properties.");
                        return false;
                    } else if (item.equalsIgnoreCase("-happy") && value.equalsIgnoreCase("-sad")
                            || value.equalsIgnoreCase("-happy") && item.equalsIgnoreCase("-sad")) {
                        System.out.println("The request contains mutually exclusive properties: [-HAPPY, -SAD] \n" +
                                "There are no numbers with these properties.");
                        return false;
                    } else {
                        for (property j : property.values()) {
                            if (value.equalsIgnoreCase(String.valueOf(j)) && item.equalsIgnoreCase(String.valueOf(j.section))
                                    || value.equalsIgnoreCase(String.valueOf(j.section)) && item.equalsIgnoreCase(String.valueOf(j))) {
                                System.out.printf("The request contains mutually exclusive properties: [%s, %s] \n" +
                                        "There are no numbers with these properties.%n", item.toUpperCase(Locale.ROOT), value.toUpperCase(Locale.ROOT));
                                return false;
                            }

                        }
                    }

                }
            }

        }

        return true;
    }

}
