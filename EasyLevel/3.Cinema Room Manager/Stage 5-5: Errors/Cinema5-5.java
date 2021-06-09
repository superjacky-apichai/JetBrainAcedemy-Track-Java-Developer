package cinema;

import java.util.Arrays;
import java.util.Scanner;
//Stage 5/5: Errors_
public class Cinema {

    public static void main(String[] args) {
        // setTheater***************************************************************
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        final int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row");
        final int seatEachRow = scanner.nextInt();
        System.out.println();
        // SetTheater***************************************************************
        String[][] theater = new String[rows][seatEachRow];
        setSeat(theater);

        //ChoiceForSell****************************************************************
        loopForSell(rows, seatEachRow, theater);


    }

    public static void loopForSell(int rows, int seatEachRow, String[][] theater) {
        Scanner scanner = new Scanner(System.in);
        int income = 0;
        while (true) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
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
                    while (true) {
                        System.out.println();
                        System.out.println("Enter a row number:");
                        final int rowNumber = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        final int seatNumber = scanner.nextInt();
                        System.out.println();
                        try {

                            if (theater[rowNumber - 1][seatNumber - 1].equals("B")) {
                                System.out.println("That ticket has already been purchased!");

                            } else {
                                theater[rowNumber - 1][seatNumber - 1] = "B";
                                System.out.printf("Ticket price: $%d%n", takeASeat(rows, seatEachRow, rowNumber));
                                income += takeASeat(rows, seatEachRow, rowNumber);
                                break;
                            }
                        } catch (Exception exception) {
                            System.out.println("Wrong input!");
                        }
                    }
                    break;


                case 3:
                    statistics(theater, rows, seatEachRow, income);

            }
            System.out.println();

        }

    }


    public static void statistics(String[][] theater, int rows, int seatEachRow, int income) {
        int count = 0;
        for (int i = 0; i < theater.length; i++) {
            for (int j = 0; j < theater[i].length; j++) {
                if (theater[i][j].equals("B")) {
                    count++;
                }
            }
        }

        final double countForDouble = count;
        final double sumForDouble = rows * seatEachRow;
        final double percentage = (countForDouble / sumForDouble) * 100;
        System.out.printf("Number of purchased tickets: %d%n", count);
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.printf("Current income: $%d%n", income);
        System.out.printf("Total income: $%d%n", totalIncome(rows, seatEachRow));

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

    public static int totalIncome(int rows, int seatEachRow) {
        int price1 = 10;
        int price2 = 8;
        int half1;
        int half2;


        if (rows * seatEachRow < 60) {
            return price1 * (rows * seatEachRow);
        } else {
            half1 = rows / 2;
        }

        if (rows % 2 != 0) {
            half2 = (rows / 2) + 1;
        } else {
            half2 = rows / 2;
        }

        half1 = price1 * (half1 * seatEachRow);

        half2 = price2 * (half2 * seatEachRow);

        return half1 + half2;
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