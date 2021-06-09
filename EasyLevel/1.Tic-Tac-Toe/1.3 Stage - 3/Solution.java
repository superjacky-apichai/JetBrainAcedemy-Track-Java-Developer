package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Input part***************************************************************************************
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells : ");
        String[][] xoBox = new String[3][3];
        String[] input = scanner.nextLine().split("");
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                xoBox[i][j] = input[count];
                count++;
            }
        }

        //Mathematics parts***************************************************************************************
        System.out.println("---------\n" +
                "| " + xoBox[0][0] + " " + xoBox[0][1] + " " + xoBox[0][2] + " |\n" +
                "| " + xoBox[1][0] + " " + xoBox[1][1] + " " + xoBox[1][2] + " |\n" +
                "| " + xoBox[2][0] + " " + xoBox[2][1] + " " + xoBox[2][2] + " |\n" +
                "---------");

        if (itImpossibleAndDraw(xoBox)) {

        } else {
            whoWin(xoBox);
        }
    }

    //Impossible***************************************************************************************
    public static boolean itImpossibleAndDraw(String[][] xoBox) {
        boolean itImpossible = false;
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

        if (countO + 1 < countX || countX + 1 < countO) {
            System.out.println("Impossible");
            itImpossible = true;
        }
        return itImpossible;
    }

    //whoWin***************************************************************************************
    public static void whoWin(String[][] xoBox) {

        boolean xWin = false;
        boolean oWin = false;


        while (true) {
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
                break;
            } else if (xWin) {
                System.out.println("X wins");
                break;
            } else if (oWin) {
                System.out.println("O wins");
                break;
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
                break;
            } else if (xWin) {
                System.out.println("X wins");
                break;
            } else if (oWin) {
                System.out.println("O wins");
                break;
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
                break;
            } else if (oWin) {
                System.out.println("O wins");
                break;
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

                break;
            }

            //Game not finished***************************************************************************************
            System.out.println("Game not finished");
            break;

        }
    }

}
