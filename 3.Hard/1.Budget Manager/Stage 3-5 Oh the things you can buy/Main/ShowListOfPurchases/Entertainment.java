package budget.ShowListOfPurchases;

import budget.Menu;

import java.util.HashMap;
import java.util.Map;

public class Entertainment implements Menu {
    Map<String, Double> purchase = new HashMap<>();


    public void getPurchase() {
        if (purchase.size() == 0) {
            System.out.println("The purchase list is empty!");
        } else {
            System.out.println("Entertainment:");
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
}
