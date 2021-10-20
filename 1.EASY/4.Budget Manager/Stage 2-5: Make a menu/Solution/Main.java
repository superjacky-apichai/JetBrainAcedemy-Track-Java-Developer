package budget;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Set input choice to implement at the interface menu method
        MyWallet myWallet = new MyWallet();

        while (true) {
            System.out.println("Choose your action:\n" +
                    "1) Add income\n" +
                    "2) Add purchase\n" +
                    "3) Show list of purchases\n" +
                    "4) Balance\n" +
                    "0) Exit");
            int choiceInput = scanner.nextInt();
            System.out.println();
            if (choiceInput == 0) {

                System.out.println("Bye!");
                break;
            } else {
                interfaceMenu(choiceInput, myWallet);
            }
        }
    }

    //Set interface menu method to implement Wallet object
    public static void interfaceMenu(int choice, MyWallet myWallet) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println("Enter income:");
                myWallet.setPlusTotalIncome(scanner.nextInt());
                System.out.println("Income was added!\n");
                break;
            case 2:
                System.out.println("Enter purchase name:");
                String inputString = scanner.nextLine();
                System.out.println("Enter its price:");
                double inputInteger = scanner.nextDouble();

                myWallet.setMinusTotalIncome(inputInteger);
                myWallet.setList(inputString + " $" + inputInteger);
                myWallet.setTotalPurchase(inputInteger);
                System.out.println("Purchase was added!\n");
                break;
            case 3:
                if (myWallet.getListIndex() == 0) {
                    System.out.println("The purchase list is empty\n");
                } else {
                    for (int i = 0; i < myWallet.list.toArray().length; i++) {
                        System.out.println(myWallet.list.get(i));
                    }
                    System.out.printf("Total sum: $%.2f\n", myWallet.totalPurchase);
                    System.out.println();
                }
                break;
            case 4:
                System.out.printf("Balance: $%.2f\n", myWallet.getTotalIncome());
                System.out.println();
                break;


        }

    }

}
