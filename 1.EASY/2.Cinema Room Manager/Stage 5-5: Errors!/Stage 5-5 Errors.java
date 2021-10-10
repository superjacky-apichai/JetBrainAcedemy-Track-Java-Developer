package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        //create input to indicate size of theatre
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numberOfRow = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeatEachRow = scanner.nextInt();

        //create array to store size of theatre
        char[][] rowAndSeat = new char[numberOfRow][numberOfSeatEachRow];


        // Set and implement method
        //this method set the theatre to 'S'
        setRowAndSeat(rowAndSeat);

        //implement interface of theatre
        interfaceMenu(rowAndSeat);


    }


    //Step1 Set row and seatEachRow to emptySeat or 'S'
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
        //Set and Input numberOfRow and Seat to buy
        Scanner scanner = new Scanner(System.in);
        int numberOfSeatEachRow;
        int numberOfRow;

        //Use loop because if exception happen
        //program will come back to input buy menu again
        while (true) {
            System.out.println("Enter a row number:");
            numberOfRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            numberOfSeatEachRow = scanner.nextInt();
            //set if exception happen
            if (numberOfRow > rowAndSeat.length || numberOfSeatEachRow > rowAndSeat[0].length) {
                System.out.println("Wrong input!\n");
            } else {
                //set seat that has occupied
                if (rowAndSeat[numberOfRow - 1][numberOfSeatEachRow - 1] == 'B') {
                    System.out.println("That ticket has already been purchased!\n");
                } else {
                    //this will happen if input correctly
                    rowAndSeat[numberOfRow - 1][numberOfSeatEachRow - 1] = 'B';
                    break;
                }
            }
        }

        //set if number of seat less than 60 seat
        //the price is $10
        if (rowAndSeat.length * rowAndSeat[0].length <= 60) {
            System.out.println("Ticket price: $10\n");
        } else {
            //set if number of seat greater than 60 seat
            //the price for the firstHalf seat is $10
            //and the second half is $8

            int firstHalf = rowAndSeat.length / 2;
            if (numberOfRow <= firstHalf) {
                System.out.println("Ticket price: $10\n");
            } else {
                System.out.println("Ticket price: $8\n");
            }
        }
    }

    public static String statistics(char[][] rowAndSeat) {

        int countTicket = 0;
        int countMoney = 0;
        final int countAllSeat = rowAndSeat.length * rowAndSeat[0].length;

        //firstHalf and secondHalf has store
        //when the numberOfTheatre greater than 60;
        final int firstHalf = rowAndSeat.length / 2;
        final int secondHalf = rowAndSeat.length % 2 == 0 ?
                rowAndSeat.length / 2 : (rowAndSeat.length / 2) + 1;

        //store totalIncome to calculate totalIncome if the ticket soldOut
        final int totalIncome = rowAndSeat.length * rowAndSeat[0].length <= 60 ?
                countAllSeat * 10 : ((firstHalf * rowAndSeat[0].length) * 10)
                + ((secondHalf * rowAndSeat[0].length) * 8);

        //this loop to store the ticket we sold and totalIncome we already have
        for (int i = 0; i < rowAndSeat.length; i++) {
            for (int j = 0; j < rowAndSeat[0].length; j++) {
                if (rowAndSeat[i][j] == 'B') {
                    countTicket++;
                    if (i + 1 <= firstHalf || rowAndSeat.length * rowAndSeat[0].length <= 60) {
                        countMoney += 10;
                    } else {
                        countMoney += 8;
                    }
                }
            }
        }

        //find the percentage that ticket we have sold and all seat in theatre
        final double findPercentage = (double) (countTicket * 100) / countAllSeat;

        final String printFormat1 = String.format("Number of purchased tickets: %d\n", countTicket);
        final String printFormat2 = String.format("Percentage: %.2f%s\n", findPercentage, "%");
        final String printFormat3 = String.format("Current income: $%d\n", countMoney);
        final String printFormat4 = String.format("Total income: $%d\n", totalIncome);


        return printFormat1 + printFormat2 + printFormat3 + printFormat4;

    }


    //Step4 Create interface menu
    public static void interfaceMenu(char[][] rowAndSeat) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit" + "\n");
            int choice = scanner.nextInt();
            switch (choice) {

                case 1:
                    printCinemaTheatre(rowAndSeat);
                    break;
                case 2:
                    calculatePrice(rowAndSeat);
                    break;
                case 3:
                    System.out.println(statistics(rowAndSeat));
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Wrong input!\n");
                    return;
            }


        }
    }
}