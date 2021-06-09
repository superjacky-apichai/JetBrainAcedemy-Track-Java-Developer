package cinema;

import java.util.Arrays;
import java.util.Scanner;
//Stage 4/5: Menu, please_
public class Cinema {

    public static void main(String[] args) {
        // setTheater***************************************************************
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row");
        int seatEachRow = scanner.nextInt();
        // SetTheater***************************************************************
        String[][] theater = new String[rows][seatEachRow];
        setSeat(theater);

        //ChoiceForSell****************************************************************
        loopForSell(rows,seatEachRow,theater);

        


    }

    public static void loopForSell(int rows,int seatEachRow,String[][] theater){
        Scanner scanner = new  Scanner(System.in);
        while (true) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "0. Exit");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    printTheater(theater, rows, seatEachRow);
                    break;
                case 2:
                    // BuyTicket*******************************************************************
                    System.out.println("Enter a row number:");
                    int rowNumber = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int seatNumber = scanner.nextInt();

                    theater[rowNumber - 1][seatNumber - 1] = "B";
                    System.out.printf("Ticket price: $%d%n", takeASeat(rows, seatEachRow, rowNumber));
                    break;

            }
            System.out.println();

        }

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