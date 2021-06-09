package cinema;

import java.util.Scanner;
//Stage 2/5: Sold_
public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row");
        int seatEachRow = scanner.nextInt();



//        System.out.println("Cinema:\n" +
//                "  1 2 3 4 5 6 7 8 \n" +
//                "1 S S S S S S S S \n" +
//                "2 S S S S S S S S \n" +
//                "3 S S S S S S S S \n" +
//                "4 S S S S S S S S \n" +
//                "5 S S S S S S S S \n" +
//                "6 S S S S S S S S \n" +
//                "7 S S S S S S S S \n");

        if (rows <= 9 || seatEachRow <= 9) {
            System.out.printf("Total income:%n$%d", takeASeat(rows, seatEachRow));
        }
    }


    public static int takeASeat(int rows, int seatEachRow) {
        int price1 = 10;
        int price2 = 8;
        int half1;
        int half2;

        if (rows * seatEachRow < 60) {
            return price1 * (rows * seatEachRow);
        } else {

            if (rows % 2 != 0) {
                half1 = ((rows / 2) * seatEachRow) * price1;
                half2 = (((rows / 2) + 1) * seatEachRow) * price2;
                return half1 + half2;
            } else {
                half1 = ((rows / 2) * seatEachRow) * price1;
                half2 = ((rows / 2) * seatEachRow) * price2;
                return half1 + half2;
            }


        }


    }
}