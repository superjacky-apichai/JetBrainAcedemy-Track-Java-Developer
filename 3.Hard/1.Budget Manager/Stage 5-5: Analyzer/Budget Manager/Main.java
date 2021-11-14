package budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
    static File file = new File("purchases.txt");

    public static void main(String[] args) {


        while (true) {
            System.out.println("Choose your action:\n" +
                    "1) Add income\n" +
                    "2) Add purchase\n" +
                    "3) Show list of purchases\n" +
                    "4) Balance\n" +
                    "5) Save\n" +
                    "6) Load\n" +
                    "7) Analyze (Sort)\n" +
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

            case 5:
                try {
                    saveFile();
                } catch (IOException E) {
                    System.out.println(E);
                }
                break;
            case 6:
                try {
                    loadFile();
                } catch (IOException E) {
                    System.out.println(E);
                }
                break;
            case 7:
                while (true) {
                    System.out.println("How do you want to sort?\n" +
                            "1) Sort all purchases\n" +
                            "2) Sort by type\n" +
                            "3) Sort certain type\n" +
                            "4) Back");
                    int input = scanner.nextInt();
                    System.out.println();
                    switch (input) {
                        case 1:
                            if (all.getSize() == 0) {
                                System.out.println("The purchase list is empty!");
                            } else {
                                all.sort();
                            }
                            break;
                        case 2:
                            sortByType();
                            break;
                        case 3:
                            System.out.println("Choose the type of purchase\n" +
                                    "1) Food\n" +
                                    "2) Clothes\n" +
                                    "3) Entertainment\n" +
                                    "4) Other");
                            int inputType = scanner.nextInt();
                            System.out.println();
                            switch (inputType) {
                                case 1:
                                    if (food.getSize() == 0) {
                                        System.out.println("he purchase list is empty!");
                                    } else {
                                        food.sort();
                                    }
                                    break;
                                case 2:
                                    if (clothes.getSize() == 0) {
                                        System.out.println("he purchase list is empty!");
                                    } else {
                                        clothes.sort();
                                    }
                                    break;
                                case 3:
                                    if (entertainment.getSize() == 0) {
                                        System.out.println("he purchase list is empty!");
                                    } else {
                                        entertainment.sort();
                                    }
                                    break;
                                case 4:
                                    if (other.getSize() == 0) {
                                        System.out.println("he purchase list is empty!");
                                    } else {
                                        other.sort();
                                    }
                                    break;
                            }
                            break;

                    }
                    if (input == 4) {
                        break;
                    }
                    System.out.println();
                }
        }

    }

    static void saveFile() throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write("Balance = " + String.format("%.2f", myWallet.showBalance()) + "\n");
        writer.write("Food = " + food.getMap() + "\n");
        writer.write("Clothes = " + clothes.getMap() + "\n");
        writer.write("Entertainment = " + entertainment.getMap() + "\n");
        writer.write("Other = " + other.getMap() + "\n");

        writer.close();

        System.out.println("Purchases were saved!\n");


    }

    static void loadFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        String sBalance = scanner.nextLine();
        String sFood = scanner.nextLine();
        String sClothes = scanner.nextLine();
        String sEntertainment = scanner.nextLine();
        String sOther = scanner.nextLine();
        sBalance = sBalance.replace("Balance = ", "");

        sFood = sFood.replace("Food = {", "");
        sFood = sFood.replace("}", "");

        sClothes = sClothes.replace("Clothes = {", "");
        sClothes = sClothes.replace("}", "");


        sEntertainment = sEntertainment.replace("Entertainment = {", "");
        sEntertainment = sEntertainment.replace("}", "");


        sOther = sOther.replace("Other = {", "");
        sOther = sOther.replace("}", "");


        myWallet.setMyIncome(Double.parseDouble(sBalance));

        String[] foodArray = sFood.split(",");
        String[] clothesArray = sClothes.split(",");
        String[] entertainmentArray = sEntertainment.split(",");
        String[] othersArray = sOther.split(",");

        food.getLoad(foodArray);
        clothes.getLoad(clothesArray);
        entertainment.getLoad(entertainmentArray);
        other.getLoad(othersArray);
        all.getLoad(foodArray);
        all.getLoad(clothesArray);
        all.getLoad(entertainmentArray);
        all.getLoad(othersArray);

        System.out.println("Purchases were loaded!\n");
    }

    static void sortByType() {
        double[] sumtotal = {food.getTotalSum(), clothes.getTotalSum(), entertainment.getTotalSum(), other.getTotalSum()};
        String[] type = {"Food - $", "Clothes - $", "Entertainment - $", "Other - $"};

        for (int i = 0; i < sumtotal.length; i++) {
            for (int j = 0; j < sumtotal.length - 1; j++) {
                if (sumtotal[j] < sumtotal[j + 1]) {
                    double bint = sumtotal[j];
                    String bstring = type[j];
                    sumtotal[j] = sumtotal[j + 1];
                    type[j] = type[j + 1];
                    sumtotal[j + 1] = bint;
                    type[j + 1] = bstring;
                }
            }
        }

        for (int i = 0; i < sumtotal.length; i++) {
            System.out.printf(type[i] + "%.2f\n", sumtotal[i]);
        }

        System.out.printf("Total sum: $%.2f\n", all.getTotalSum());


    }


}
