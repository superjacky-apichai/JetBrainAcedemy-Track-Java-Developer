package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        howMuchYourSupple();


    }

    public static void howMuchYourSupple() {
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cupOfCoffee = scanner.nextInt();

        int coffeeCanMake = 0;
        while (water >= 200 && milk >= 50 && coffee >= 15) {
            water = water - 200;
            milk = milk - 50;
            coffee = coffee - 15;
            coffeeCanMake++;
        }
        if (coffeeCanMake == cupOfCoffee) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (coffeeCanMake > cupOfCoffee) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", coffeeCanMake - cupOfCoffee);
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee", coffeeCanMake);
        }

    }

}