package tictactoe;


import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String[][] xoField = new String[3][3];

        setField(xoField);
        printArray(xoField);
        whoWin(xoField);

//        while (!whoWin(xoField)) {}


        moveXo(xoField);


    }

    //Step1 Set inputValue and set xo form 1D array to 2D array
    public static void setField(String[][] xoField) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String[] inputXo = scanner.next().split("");
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                xoField[i][j] = inputXo[count];
                count++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(xoField[i][j], "_")) {
                    xoField[i][j] = " ";
                }
            }
        }


    }

    //Step2 set to print array during test code
    public static void printArray(String[][] xoField) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(xoField[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

    }

    //Step3 set to testing who win this game
    public static boolean whoWin(String[][] xoField) {
        boolean xWin = false;
        boolean oWin = false;
        boolean isGameFinish = false;

        //Step3.1 Set loop to check winner in Row
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= 0; j++) {


                if (Objects.equals(xoField[i][j], "X")
                        && Objects.equals(xoField[i][j + 1], "X")
                        && Objects.equals(xoField[i][j + 2], "X")) {
                    xWin = true;
                }

                if (Objects.equals(xoField[i][j], "O")
                        && Objects.equals(xoField[i][j + 1], "O")
                        && Objects.equals(xoField[i][j + 2], "O")) {
                    oWin = true;
                }

            }
        }

        //Step3.2 Set loop to check winner in collum

        for (int i = 0; i <= 0; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(xoField[i][j], "X")
                        && Objects.equals(xoField[i + 1][j], "X")
                        && Objects.equals(xoField[i + 2][j], "X")) {
                    xWin = true;
                } else if (Objects.equals(xoField[i][j], "O")
                        && Objects.equals(xoField[i + 1][j], "O")
                        && Objects.equals(xoField[i + 2][j], "O")) {
                    oWin = true;
                }

            }
        }

        //Step3.3 Set to Check winner in diagonal
        if (Objects.equals(xoField[0][0], "X")
                && Objects.equals(xoField[1][1], "X")
                && Objects.equals(xoField[2][2], "X")
                || Objects.equals(xoField[0][2], "X")
                && Objects.equals(xoField[1][1], "X")
                && Objects.equals(xoField[2][0], "X")) {
            xWin = true;
        } else if (Objects.equals(xoField[0][0], "O")
                && Objects.equals(xoField[1][1], "O")
                && Objects.equals(xoField[2][2], "O")
                || Objects.equals(xoField[0][2], "O")
                && Objects.equals(xoField[1][1], "O")
                && Objects.equals(xoField[2][0], "O")) {
            oWin = true;
        }

        //Step3.4 Set to check  is game finish yet, and it is possible
        int countX = 0;
        int countO = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(xoField[i][j], "X")) {
                    countX++;
                } else if (Objects.equals(xoField[i][j], "O")) {
                    countO++;
                }
            }
        }
        if (countX + countO == 9) {
            isGameFinish = true;
        }

        //Final step Set output condition of this game
        if (xWin && oWin
                || countX + 2 == countO
                || countO + 2 == countX) {
            System.out.println("Impossible");
            return true;
        } else if (xWin) {
            System.out.println("X wins");
            return true;
        } else if (oWin) {
            System.out.println("O wins");
            return true;
        } else if (!xWin && !oWin
                && isGameFinish) {
            System.out.println("Draw");
            return true;
        }

        return false;
    }

    //Step4 inputX/O move
    public static void moveXo(String[][] xoField) {
        //input Row/Collum to move
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {

                System.out.print("Enter the coordinates: ");
                int inputRow = scanner.nextInt();
                int inputCollum = scanner.nextInt();
                inputRow -= 1;
                inputCollum -= 1;


                if (inputRow > 2 || inputCollum > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");

                } else if (!xoField[inputRow][inputCollum].equals(" ")) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    xoField[inputRow][inputCollum] = "X";
                    printArray(xoField);
                    break;
                }
            } catch (Exception E) {
                System.out.println("You should enter numbers!");

            }
        }

    }


}
