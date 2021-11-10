package budget;

import java.util.Scanner;

import budget.ShowListOfPurchases.*;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static MyWallet myWallet = new MyWallet();
    static Menu food = new Food();
    static Menu clothes = new Clothes();
    static Menu entertainment = new Entertainment();
    static Menu other = new Other();
    static Menu all = new All();

    public static void main(String[] args) {


        while (true) {
            System.out.println("Choose your action:\n" +
                    "1) Add income\n" +
                    "2) Add purchase\n" +
                    "3) Show list of purchases\n" +
                    "4) Balance\n" +
                    "0) Exit");
            int inputChoice = scanner.nextInt();
            System.out.println();


            if (inputChoice == 0) {
                System.out.println("Bye!");
                return;
            } else {
                interfaceMenu(inputChoice);
            }
            System.out.println();
        }

    }


    static void interfaceMenu(int inputChoice) {

        switch (inputChoice) {
            case 1:
                System.out.println("Enter income:");
                double income = scanner.nextDouble();
                myWallet.setMyIncome(income);
                System.out.println("Income was added!");
                break;
            case 2:
                while (true) {
                    System.out.println("Choose the type of purchase\n" +
                            "1) Food\n" +
                            "2) Clothes\n" +
                            "3) Entertainment\n" +
                            "4) Other\n" +
                            "5) Back");
                    int choice = scanner.nextInt();
                    System.out.println();

                    if (choice == 5) {
                        break;
                    } else {
                        System.out.println("Enter purchase name:");
                        String name = scanner.nextLine();
                        name = scanner.nextLine();
                        System.out.println("Enter its price:");
                        double price = scanner.nextDouble();
                        switch (choice) {
                            case 1:
                                food.setPurchase(name, price);
                                all.setPurchase(name, price);
                                myWallet.AddPurchase(price);
                                break;
                            case 2:
                                clothes.setPurchase(name, price);
                                all.setPurchase(name, price);
                                myWallet.AddPurchase(price);
                                break;
                            case 3:
                                entertainment.setPurchase(name, price);
                                all.setPurchase(name, price);
                                myWallet.AddPurchase(price);
                                break;
                            case 4:
                                other.setPurchase(name, price);
                                all.setPurchase(name, price);
                                myWallet.AddPurchase(price);
                                break;
                        }
                    }
                    System.out.println("Purchase was added!\n");
                }

                break;
            case 3:
                if (all.getSize() == 0) {
                    System.out.println("The purchase list is empty!");

                } else {
                    while (true) {
                        System.out.println("Choose the type of purchases\n" +
                                "1) Food\n" +
                                "2) Clothes\n" +
                                "3) Entertainment\n" +
                                "4) Other\n" +
                                "5) All\n" +
                                "6) Back");

                        int choice = scanner.nextInt();
                        System.out.println();
                        if (choice == 6) {
                            break;
                        } else {
                            switch (choice) {
                                case 1:
                                    food.getPurchase();
                                    break;
                                case 2:
                                    clothes.getPurchase();
                                    break;
                                case 3:
                                    entertainment.getPurchase();
                                    break;
                                case 4:
                                    other.getPurchase();
                                    break;
                                case 5:
                                    all.getPurchase();
                                    break;
                            }
                        }

                        System.out.println();
                    }

                }

                break;

            case 4:
                System.out.printf("Balance: $%.2f\n", myWallet.showBalance());
                break;


        }

    }


}
