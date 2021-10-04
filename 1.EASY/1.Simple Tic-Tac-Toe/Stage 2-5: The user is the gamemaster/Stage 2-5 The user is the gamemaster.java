package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cells: ");
        String[] oX = scanner.nextLine().split("");

        System.out.println("---------");
        System.out.println("| " + oX[0] + " " + oX[1] + " " + oX[2] + " " + "|");
        System.out.println("| " + oX[3] + " " + oX[4] + " " + oX[5] + " " + "|");
        System.out.println("| " + oX[6] + " " + oX[7] + " " + oX[8] + " " + "|");
        System.out.println("---------");


    }
}
