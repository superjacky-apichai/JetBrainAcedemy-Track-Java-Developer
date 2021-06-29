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

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String order = scanner.next();
            System.out.println();
            switch (order) {
                case "buy":
                    makeCoffee();
                    System.out.println();
                    break;

                case "fill":
                    fill();
                    System.out.println();
                    break;

                case "take":
                    System.out.println("I gave you $" + dollar);
                    dollar = 0;
                    System.out.println();
                    break;
                case "remaining":
                    System.out.println("The coffee machine has:");
                    System.out.println(water + " ml of water");
                    System.out.println(milk + " ml of milk");
                    System.out.println(coffee + " g of coffee beans");
                    System.out.println(disposableCups + " disposable cups");
                    System.out.println("$" + dollar + " of money");
                    System.out.println();
                    break;

                case "exit":
                    return;
            }


        }
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
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

        String string = scanner.next();

        switch (string) {
            case "1":
                if (espresso(250, 16)) {
                    water = water - 250;
                    coffee = coffee - 16;
                    disposableCups = disposableCups - 1;
                    dollar = dollar + 4;
                }
                break;
            case "2":
                if (espresso(350, 20, 75)) {
                    water = water - 350;
                    coffee = coffee - 20;
                    milk = milk - 75;
                    disposableCups = disposableCups - 1;
                    dollar = dollar + 7;
                }
                break;
            case "3":
                if (espresso(200, 12, 100)) {
                    water = water - 200;
                    coffee = coffee - 12;
                    milk = milk - 100;
                    disposableCups = disposableCups - 1;
                    dollar = dollar + 6;
                }
                break;

            case "back":
                break;

        }


    }

    public static boolean espresso(int waterN, int coffeeN) {
        if (water < waterN) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (coffee < coffeeN) {
            System.out.println("Sorry, not enough coffee!");
            return false;
        } else if (disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }

        return true;
    }

    public static boolean espresso(int waterN, int coffeeN, int milkN) {
        if (water < waterN) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (coffee < coffeeN) {
            System.out.println("Sorry, not enough coffee!");
            return false;
        } else if (milk < milkN) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        System.out.println("I have enough resources, making you a coffee!");
        return true;
    }
}


