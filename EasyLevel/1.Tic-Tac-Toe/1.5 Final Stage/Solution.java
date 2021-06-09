package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Input part***************************************************************************************
        String[][] xoBox = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                xoBox[i][j] = " ";

            }
        }

        //Mathematics parts***************************************************************************************
        System.out.println("---------\n" +
                "| " + xoBox[0][0] + " " + xoBox[0][1] + " " + xoBox[0][2] + " |\n" +
                "| " + xoBox[1][0] + " " + xoBox[1][1] + " " + xoBox[1][2] + " |\n" +
                "| " + xoBox[2][0] + " " + xoBox[2][1] + " " + xoBox[2][2] + " |\n" +
                "---------");

        occupied(xoBox);

    }

    //occupied!***************************************************************************************
    public static void occupied(String[][] xoBox) {
        Scanner scanner = new Scanner(System.in);
        boolean itXOrO = false;

        while (true) {

            System.out.print("Enter the coordinates: ");
            String[] place = scanner.nextLine().split(" ");
            int[] placeInt = new int[2];

            try {


                placeInt[0] = Integer.parseInt(place[0]);
                placeInt[1] = Integer.parseInt(place[1]);
            } catch (NumberFormatException notNumber) {
                System.out.println("You should enter numbers!");
                continue;
            }


            if (placeInt[0] > 3 || placeInt[0] < 1 || placeInt[1] > 3 || placeInt[1] < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else if (xoBox[placeInt[0] - 1][placeInt[1] - 1].equals("X")
                    || xoBox[placeInt[0] - 1][placeInt[1] - 1].equals("O")) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            } else if (!itXOrO) {
                xoBox[placeInt[0] - 1][placeInt[1] - 1] = "X";
                itXOrO = true;

            } else {
                xoBox[placeInt[0] - 1][placeInt[1] - 1] = "O";
                itXOrO = false;
            }


            System.out.println("---------\n" +
                    "| " + xoBox[0][0] + " " + xoBox[0][1] + " " + xoBox[0][2] + " |\n" +
                    "| " + xoBox[1][0] + " " + xoBox[1][1] + " " + xoBox[1][2] + " |\n" +
                    "| " + xoBox[2][0] + " " + xoBox[2][1] + " " + xoBox[2][2] + " |\n" +
                    "---------");


            if (whoWin(xoBox)) {
                break;
            }

        }


    }


    //whoWin***************************************************************************************
    public static boolean whoWin(String[][] xoBox) {

        boolean xWin = false;
        boolean oWin = false;


        //ROW***************************************************************************************
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (xoBox[i - 1][j].equals("O") && xoBox[i][j].equals("O") && xoBox[i + 1][j].equals("O")) {
                    oWin = true;
                } else if (xoBox[i - 1][j].equals("X") && xoBox[i][j].equals("X") && xoBox[i + 1][j].equals("X")) {
                    xWin = true;
                }
            }
        }

        if (xWin && oWin) {
            System.out.println("Impossible");
            return true;

        } else if (xWin) {
            System.out.println("X wins");
            return true;

        } else if (oWin) {
            System.out.println("O wins");
            return true;

        }

        //COLLUM***************************************************************************************
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 2; j++) {
                if (xoBox[i][j - 1].equals("O") && xoBox[i][j].equals("O") && xoBox[i][j + 1].equals("O")) {
                    oWin = true;
                } else if (xoBox[i][j - 1].equals("X") && xoBox[i][j].equals("X") && xoBox[i][j + 1].equals("X")) {
                    xWin = true;
                }
            }
        }

        if (xWin && oWin) {
            System.out.println("Impossible");
            return true;

        } else if (xWin) {
            System.out.println("X wins");
            return true;

        } else if (oWin) {
            System.out.println("O wins");
            return true;
        }

        //oblique***************************************************************************************
        if (xoBox[0][0].equals("O") && xoBox[1][1].equals("O") && xoBox[2][2].equals("O")
                || xoBox[0][2].equals("O") && xoBox[1][1].equals("O") && xoBox[2][0].equals("O")) {
            oWin = true;
        }

        if (xoBox[0][0].equals("X") && xoBox[1][1].equals("X") && xoBox[2][2].equals("X")
                || xoBox[0][2].equals("X") && xoBox[1][1].equals("X") && xoBox[2][0].equals("X")) {
            xWin = true;
        }

        if (xWin) {
            System.out.println("X wins");
            return true;

        } else if (oWin) {
            System.out.println("O wins");
            return true;

        }

        //Draw***************************************************************************************
        int countX = 0;
        int countO = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (xoBox[i][j].equals("X")) {
                    countX++;
                } else if (xoBox[i][j].equals("O")) {
                    countO++;
                }
            }
        }
        if (countX == 4 && countO == 5
                || countO == 4 && countX == 5) {
            System.out.println("Draw");
            return true;
        }

        return false;
    }


}
