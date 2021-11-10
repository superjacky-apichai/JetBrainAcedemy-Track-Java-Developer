package budget;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();

        while (scanner.hasNext()) {
            input.append(scanner.nextLine()).append("\n");
        }

        String[] splitToArray = input.toString().split("\n");
        double total = 0;

        for (String s : splitToArray) {
            System.out.println(s);
            String[] split$Array = s.split("\\$");
            total += Double.parseDouble(split$Array[1]);
        }
        System.out.println();
        System.out.println("Total: $" + total);

    }
}
