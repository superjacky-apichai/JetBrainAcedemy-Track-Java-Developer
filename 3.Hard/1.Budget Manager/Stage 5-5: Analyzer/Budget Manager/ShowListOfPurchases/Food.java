package budget.ShowListOfPurchases;

import budget.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Food implements Menu {
    Map<String, Double> purchase = new HashMap<>();
    double totalSum;


    public void getPurchase() {
        if (purchase.size() == 0) {
            System.out.println("The purchase list is empty!");
        } else {
            System.out.println("Food:");
            double sum = 0;
            for (var i : purchase.entrySet()) {
                System.out.printf("%s $%.2f\n", i.getKey(), i.getValue());
                sum += i.getValue();
            }
            System.out.printf("Total sum: $%.2f\n", sum);
        }
    }


    public void setPurchase(String k, Double v) {
        this.purchase.put(k, v);
    }

    public int getSize() {
        return this.purchase.size();

    }

    public Map getMap() {
        return this.purchase;
    }

    public void getLoad(String[] fileLoad) {

        try {
            for (int i = 0; i < fileLoad.length; i++) {
                fileLoad[i] = fileLoad[i].trim();
                String[] forSplit = fileLoad[i].split("=");
                this.purchase.put(forSplit[0], Double.valueOf(forSplit[1]));
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
    }

    public double getTotalSum() {
        for (var i : purchase.entrySet()) {
            this.totalSum += i.getValue();
        }
        return this.totalSum;
    }

    @Override
    public void sort() {
        String[] bString = new String[purchase.size()];
        double[] bDouble = new double[purchase.size()];
        List<Double> listDouble = new ArrayList<>(purchase.values());
        List<String> listString = new ArrayList<>(purchase.keySet());

        for (int i = 0; i < purchase.size(); i++) {
            bString[i] = listString.get(i);
            bDouble[i] = listDouble.get(i);
        }

        for (int i = 0; i < purchase.size(); i++) {
            for (int j = 0; j < purchase.size() - 1; j++) {

                if (bDouble[j] < bDouble[j + 1] || bDouble[j] == bDouble[j + 1] && bString[j].compareTo(bString[j + 1]) < 0) {
                    String bUpString = bString[j];
                    double bUpDouble = bDouble[j];

                    bDouble[j] = bDouble[j + 1];
                    bString[j] = bString[j + 1];

                    bDouble[j + 1] = bUpDouble;
                    bString[j + 1] = bUpString;
                }
            }
        }

        System.out.println("All:");
        for (int i = 0; i < purchase.size(); i++) {
            System.out.printf("%s $%.2f\n", bString[i], bDouble[i]);
        }

        System.out.printf("Total: $%.2f\n", getTotalSum());
        System.out.println();


    }
}
