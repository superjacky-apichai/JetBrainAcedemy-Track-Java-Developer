package encryptdecrypt;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    static int a;
    static String inputMode;
    static boolean isMode;
    static String inputString;


    public static void main(String[] args) {
        Process process = new ForLetter();
        boolean isOut = false;
        String fileOut = "";
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

                case "-alg":
                    if (args[i + 1].equals("unicode")) {
                        process = new ForUnicode();
                    }

            }
        }

        for (int i = 0; i < args.length; i++) {
            if ("-in".equals(args[i])) {


                boolean isData = false;
                for (String arg : args) {
                    if (arg.equals("-data")) {
                        isData = true;
                        break;
                    }
                }

                if (!isData) {

                    Path pathIn = Paths.get(System.getProperty("user.dir") + "\\" + args[i + 1]);


                    for (int j = 0; j < args.length; j++) {
                        if (args[j].equals("-out")) {
                            fileOut = args[j + 1];

                            isOut = true;

                            break;
                        }
                    }

                    File file = new File(String.valueOf(pathIn));

                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNext()) {
                            inputString = scanner.nextLine();
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Error");
                    }


                }
                break;
            }
        }

        print(isMode, isOut, inputString, a, process, fileOut);
    }


    public static void print(boolean isMode, boolean isOut, String inputString, int a, Process process, String fileOut) {

        if (isOut) {

            try (PrintWriter fileWriter = new PrintWriter(fileOut)) {

                if (isMode) {
                    switch (inputMode) {
                        case "enc":
                            fileWriter.println(process.encryption(inputString, a));
                            break;

                        case "dec":
                            fileWriter.println(process.decryption(inputString, a));
                            break;
                    }

                } else {
                    fileWriter.println(process.encryption(inputString, a));
                }

            } catch (IOException e) {
                System.out.println("Error");
            }
        } else {
            if (isMode) {

                switch (inputMode) {
                    case "enc":
                        System.out.println(process.encryption(inputString, a));
                        break;

                    case "dec":
                        System.out.println(process.decryption(inputString, a));
                        break;
                }

            } else {
                System.out.println(process.encryption(inputString, a));
            }


        }
    }

}

abstract class Process {


    protected abstract StringBuilder encryption(String input, int count);

    protected abstract StringBuilder decryption(String input, int count);

}

class ForUnicode extends Process {


    public StringBuilder encryption(String input, int count) {
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


    public StringBuilder decryption(String input, int count) {
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


class ForLetter extends Process {
    @Override
    protected StringBuilder encryption(String input, int count) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char character : input.toCharArray()) {
            if (Character.isLetter(character)) {
                int originalAlphabetPosition = Character.isUpperCase(character) ? character - 'A' : character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + count) % 26;
                char newCharacter = (char) (Character.isUpperCase(character) ? newAlphabetPosition + 'A' : newAlphabetPosition + 'a');
                stringBuilder.append(newCharacter);
            } else {
                stringBuilder.append(character);
            }


        }
        return stringBuilder;
    }

    @Override
    protected StringBuilder decryption(String input, int count) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(encryption(input, 26 - (count % 26)));

        return stringBuilder;
    }
}


