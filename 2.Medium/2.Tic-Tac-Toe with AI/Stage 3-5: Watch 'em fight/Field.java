package tictactoe;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Field {
    String[][] field = new String[3][3];


    void getPlace() {


        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {

                field[i][j] = " ";

            }
        }

    }

    void getField() {

        System.out.println("---------");
        System.out.println("| " + field[0][0] + " " + field[0][1] + " " + field[0][2] + " |");
        System.out.println("| " + field[1][0] + " " + field[1][1] + " " + field[1][2] + " |");
        System.out.println("| " + field[2][0] + " " + field[2][1] + " " + field[2][2] + " |");
        System.out.println("---------");
    }


    boolean checkWinner() {

        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals("X") && field[i][1].equals("X") && field[i][2].equals("X")) {
                System.out.println("X wins");
                return false;
            } else if (field[i][0].equals("O") && field[i][1].equals("O") && field[i][2].equals("O")) {
                System.out.println("O wins");
                return false;
            }

        }

        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals("X") && field[1][i].equals("X") && field[2][i].equals("X")) {
                System.out.println("X wins");
                return false;
            } else if (field[0][i].equals("O") && field[1][i].equals("O") && field[2][i].equals("O")) {
                System.out.println("O wins");
                return false;
            }
        }

        if (field[0][0].equals("X") && field[1][1].equals("X") && field[2][2].equals("X")
                || field[2][0].equals("X") && field[1][1].equals("X") && field[0][2].equals("X")) {
            System.out.println("X wins");
            return false;
        } else if (field[0][0].equals("O") && field[1][1].equals("O") && field[2][2].equals("O")
                || field[2][0].equals("O") && field[1][1].equals("O") && field[0][2].equals("O")) {
            System.out.println("O wins");
            return false;
        }


        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (field[i][j].equals(" ")) {
                    return true;
                }
            }

        }

        System.out.println("Draw");
        return false;
    }

    boolean userMove(int xo) {
        Scanner scanner = new Scanner(System.in);
        int x ;
        int y ;

        try {
            x = scanner.nextInt();

        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            return false;
        }

        try {
            y = scanner.nextInt();

        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            return false;
        }

        x -= 1;
        y -= 1;


        if (x > 2 || y > 2) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        } else if (!Objects.equals(field[x][y], " ")) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        } else {
            if (xo == 1) {
                field[x][y] = "X";
            } else {
                field[x][y] = "O";
            }
        }
        return true;

    }

    void user(int xo) {
        while (true) {
            System.out.println("Enter the coordinates:");
            if (userMove(xo)) {
                getField();
                return;
            }
        }
    }

    void easy(int xo) {
        Random random = new Random();
        System.out.println("Making move level \"easy\"");
        while (true) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (field[x][y].equals(" ")) {
                if (xo == 1) {
                    field[x][y] = "X";
                } else {
                    field[x][y] = "O";
                }
                getField();
                return;
            }
        }

    }

}
