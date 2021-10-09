package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numberOfRow = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeatEachRow = scanner.nextInt();
        char[][] rowAndSeat = new char[numberOfRow][numberOfSeatEachRow];

        setRowAndSeat(rowAndSeat);

        interfaceMenu(rowAndSeat);


    }


    //Step1 Set row and seat each row
    public static void setRowAndSeat(char[][] rowAndSeat) {
        for (int i = 0; i < rowAndSeat.length; i++) {
            for (int j = 0; j < rowAndSeat[0].length; j++) {
                rowAndSeat[i][j] = 'S';
            }

        }

    }

    //Step2 create method to print cinema theatre
    public static void printCinemaTheatre(char[][] rowAndSeat) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < rowAndSeat[0].length; i++) {
            System.out.print(i + 1 + " ");
        }

        System.out.println();
        for (int i = 0; i < rowAndSeat.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < rowAndSeat[0].length; j++) {
                System.out.print(rowAndSeat[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println();

    }

    //Step3 Calculate for printing Price
    public static void calculatePrice(char[][] rowAndSeat) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int numberOfRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int numberOfSeatEachRow = scanner.nextInt();
        numberOfRow -= 1;
        numberOfSeatEachRow -= 1;
        System.out.println(numberOfRow);
        System.out.println(numberOfSeatEachRow);

        if (rowAndSeat.length * rowAndSeat[0].length <= 60) {
            System.out.println("Ticket price: $10\n");
        } else {
            int firstHalf = rowAndSeat.length / 2;
//            int secondHalf = (double) rowAndSeat.length % 2 == 0 ? rowAndSeat.length / 2
//                    : (rowAndSeat.length / 2) + 1;

            if (numberOfRow + 1 <= firstHalf) {
                System.out.println("Ticket price: $10\n");
            } else {
                System.out.println("Ticket price: $8\n");
            }

        }
        rowAndSeat[numberOfRow][numberOfSeatEachRow] = 'B';
    }


    //Step4 Create interface
    public static void interfaceMenu(char[][] rowAndSeat) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "0. Exit");
            int choice = scanner.nextInt();
            switch (choice) {

                case 1:
                    printCinemaTheatre(rowAndSeat);
                    break;
                case 2:
                    calculatePrice(rowAndSeat);
                    break;
                case 0:
                    return;
            }


        }
    }
}
