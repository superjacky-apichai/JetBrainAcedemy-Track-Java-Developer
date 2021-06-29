package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int disposableCups = 9;
    static int dollar = 550;

    public static void main(String[] args) {
        buyFillTake();


    }

    public static void buyFillTake() {


            System.out.println("The coffee machine has:");
            System.out.println(water + " ml of water");
            System.out.println(milk + " ml of milk");
            System.out.println(coffee + " g of coffee beans");
            System.out.println(disposableCups + " disposable cups");
            System.out.println("$" + dollar + " of money%n");
            System.out.println("Write action (buy, fill, take):");
            String order = scanner.next();

            switch (order) {
                case "buy":
                    makeCoffee();
                    break;

                case "fill":
                    fill();
                    break;

                case "take":
                    System.out.println("I gave you $" + dollar);
                    dollar = 0;
                    break;


            }

        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + dollar + " of money%n");

    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        disposableCups += scanner.nextInt();
    }

    public static void makeCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int whatCoffee = scanner.nextInt();

        if (whatCoffee == 1) {
            water = water - 250;
            coffee = coffee - 16;
            disposableCups = disposableCups - 1;
            dollar = dollar + 4;

        } else if (whatCoffee == 2) {
            water = water - 350;
            coffee = coffee - 20;
            milk = milk - 75;
            disposableCups = disposableCups - 1;
            dollar = dollar + 7;
        } else if (whatCoffee == 3) {
            water = water - 200;
            coffee = coffee - 12;
            milk = milk - 100;
            disposableCups = disposableCups - 1;
            dollar = dollar + 6;
        }


    }
}


