package cinema;

import java.util.Arrays;
import java.util.Scanner;
//Stage 3/5: Tickets
public class Cinema {

    public static void main(String[] args) {
        // setTheater***************************************************************
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row");
        int seatEachRow = scanner.nextInt();

        // printTheater***************************************************************
        String[][] theater = new String[rows][seatEachRow];
        setSeat(theater);
        printTheater(theater, rows, seatEachRow);

        // BuyTicket*******************************************************************
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();
        theater[rowNumber - 1][seatNumber - 1] = "B";

        // printTheaterAgain***************************************************************
        System.out.printf("Ticket price: $%d%n", takeASeat(rows, seatEachRow, rowNumber));
        printTheater(theater, rows, seatEachRow);
    }

    public static void setSeat(String[][] theater) {
        for (String[] strings : theater) {
            Arrays.fill(strings, "S");
        }
    }

    public static void printTheater(String[][] theater, int row, int seat) {
        StringBuilder up = new StringBuilder(" ");
        System.out.println("Cinema:");
        for (int i = 1; i <= seat; i++) {
            up.append(" ").append(i);
        }
        System.out.println(up);

        for (int i = 0; i < row; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seat; j++) {
                System.out.print(" " + theater[i][j]);
            }
            System.out.println();
        }

    }


    public static int takeASeat(int rows, int seatEachRow, int numberRow) {
        int price1 = 10;
        int price2 = 8;
        int half1;


        if (rows * seatEachRow < 60) {
            return price1;
        } else {
            half1 = rows / 2;
        }

        if (numberRow > half1) {
            return price2;
        } else {
            return price1;
        }


    }
}