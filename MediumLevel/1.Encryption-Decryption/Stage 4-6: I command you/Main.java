package encryptdecrypt;

import java.util.Scanner;

public class Main {
    static int a;
    static String inputMode;
    static boolean isMode;
    static String inputString;


    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {

            switch (args[i]) {
                case "-mode":
                    isMode = true;
                    inputMode = args[i + 1];

                    break;
                case "-key":
                    a = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    inputString = args[i + 1];
                    break;
            }

        }


        if (isMode) {
            switch (inputMode) {
                case "enc":
                    System.out.println(encryption(inputString, a));
                    break;

                case "dec":
                    System.out.println(decryption(inputString, a));
                    break;
            }

        } else {
            System.out.println(encryption(inputString, a));
        }


    }

    public static StringBuilder encryption(String input, int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            for (int j = 1; j <= count; j++) {

                ch++;

            }


            stringBuilder.append(ch);
        }
        return stringBuilder;
    }


    public static StringBuilder decryption(String input, int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            for (int j = 1; j <= count; j++) {

                ch--;


            }


            stringBuilder.append(ch);
        }
        return stringBuilder;
    }
}

