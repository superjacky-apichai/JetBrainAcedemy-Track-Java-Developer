package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells : ");
        String[] cell = scanner.nextLine().split("");

        System.out.println("---------\n"+
                "| "+cell[0]+" "+cell[1]+" "+cell[2]+" |\n" +
                "| "+cell[3]+" "+cell[4]+" "+cell[5]+" |\n" +
                "| "+cell[6]+" "+cell[7]+" "+cell[8]+" |\n" +
                "---------");


    }
}
