package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        System.out.println("Write how many cups of coffee you will need:");
        Scanner scanner = new Scanner(System.in);
        int cupQuantity = scanner.nextInt();
        makeCoffee(cupQuantity);
    }

    public static void makeCoffee(int cup) {

        int water = 200;
        int milk = 50;
        int coffee = 15;
        System.out.printf("For %d cups of coffee you will need:%n", cup);
        System.out.println(water * cup + " ml of water");
        System.out.println(milk * cup + " ml of milk");
        System.out.println(coffee * cup + " g of coffee beans");


    }
}


//abstract class Set {
//
//    public abstract void makeCoffee(int cu);
//}
//
//class Coffee extends Set {
//    int water = 200;
//    int milk = 50;
//    int coffee = 15;
//
//    @Override
//    public void makeCoffee(int cup) {
//        System.out.printf("For %d cups of coffee you will need:%n", cup);
//        System.out.println(water * cup + " ml of water");
//        System.out.println(milk * cup + " ml of milk");
//        System.out.println(coffee * cup + " g of coffee bean");
//
//    }
//}