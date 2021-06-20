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

        for (int i = 0; i < args.length; i++) {
            if ("-in".equals(args[i])) {
                String fileOut = "";
                
                boolean isData = false;
                for (String arg : args) {
                    if (arg.equals("-data")) {
                        isData = true;
                        break;
                    }
                }

                if (!isData) {
                    boolean isOut = false;
                    Path pathIn = Paths.get(System.getProperty("user.dir") + "\\" + args[i + 1]);
                    ;

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


                    if (isOut) {

                        try (PrintWriter fileWriter = new PrintWriter(fileOut)) {

                            if (isMode) {
                                switch (inputMode) {
                                    case "enc":
                                        fileWriter.println(encryption(inputString, a));
                                        break;

                                    case "dec":
                                        fileWriter.println(decryption(inputString, a));
                                        break;
                                }

                            } else {
                                fileWriter.println(encryption(inputString, a));
                            }

                        } catch (IOException e) {
                            System.out.println("Error");
                        }
                    }

                    return;
                }
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

