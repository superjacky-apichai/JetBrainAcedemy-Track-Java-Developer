package encryptdecrypt;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        String input = scanner.nextLine();
        int number = scanner.nextInt();


        switch (choice) {

            case "enc":
                System.out.println(encryption(input, number));
                break;

            case "dec":
                System.out.println(decryption(input, number));
                break;

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

