package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        System.out.printf("Total income: \n$%d", calculateIncome());

    }

    public static int calculateIncome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numberOfRow = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfCollum = scanner.nextInt();
        if (numberOfRow * numberOfCollum <= 60) {
            return (numberOfRow * numberOfCollum) * 10;
        } else {
            int firstHalf = numberOfRow /2;
            int secondHalf = (double) numberOfRow % 2 == 0 ? numberOfRow / 2
                    : (numberOfRow / 2) + 1;


            int sumFirstHalf = (firstHalf*numberOfCollum) * 10;
            int sumSecondHalf = (secondHalf*numberOfCollum) * 8;
            return sumFirstHalf + sumSecondHalf;


        }
    }
}