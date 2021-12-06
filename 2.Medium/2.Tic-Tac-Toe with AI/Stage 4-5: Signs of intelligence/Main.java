package tictactoe;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    //start medium medium

    public static void main(String[] args) {
        Field field = new Field();
        field.getPlace();
        String[] command;

        while (true) {
            System.out.println("Input command:");
            command = scanner.nextLine().split("\\s+");
            if (command.length == 3) {
                if (command[0].equalsIgnoreCase("start")
                        && command[1].equalsIgnoreCase("user") || command[1].equalsIgnoreCase("easy") || command[1].equalsIgnoreCase("medium")
                        && command[2].equalsIgnoreCase("user") || command[2].equalsIgnoreCase("easy") || command[2].equalsIgnoreCase("medium")) {
                    break;
                }
            } else if (command[0].equalsIgnoreCase("exit")) {
                return;
            }

            System.out.println("Bad parameters!");
        }


        field.getField();
        while (field.checkWinner()) {
            if (command[1].equalsIgnoreCase("user")) {
                field.user(1);
            } else if (command[1].equalsIgnoreCase("easy")) {
                field.easy(1);
            } else if (command[1].equalsIgnoreCase("medium")) {
                field.medium(1);
            }
            if (field.checkWinner()) {
                if (command[2].equalsIgnoreCase("user")) {
                    field.user(2);
                } else if (command[2].equalsIgnoreCase("easy")) {
                    field.easy(2);
                } else if (command[2].equalsIgnoreCase("medium")) {
                    field.medium(2);
                }
            } else {
                break;
            }
        }


    }


}
