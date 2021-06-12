package encryptdecrypt;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int number = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            for (int j = 1; j <= number; j++) {

                if (Character.isLetter(ch)) {

                    ch++;
                }

                if (ch > 122) {
                    ch = 97;
                }
            }


            stringBuilder.append(ch);
        }
        System.out.println(stringBuilder);

    }
}
