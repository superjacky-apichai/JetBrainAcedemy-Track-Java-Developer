package tictactoe;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Field field = new Field();
        field.getPlace();
        field.getField();


        while (true) {
            System.out.println("Enter the coordinates:");


            while (true) {
                if (field.moveXO()) {
                    field.getField();
                    break;
                }
            }
            if (!field.checkWinner()) {
                System.out.println("Making move level \"easy\"");
                field.easy();
                field.getField();
            } else {
                break;
            }
        }


    }


}
