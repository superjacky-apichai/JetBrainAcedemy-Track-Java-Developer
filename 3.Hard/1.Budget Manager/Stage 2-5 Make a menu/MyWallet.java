package budget;

import java.util.ArrayList;

public class MyWallet {

    double TotalIncome = 0;
    ArrayList<String> list = new ArrayList<>();
    double totalPurchase = 0;


    public double getTotalIncome() {
        return TotalIncome;
    }

    public void setPlusTotalIncome(double totalIncome) {
        TotalIncome += totalIncome;
    }

    public void setMinusTotalIncome(double totalIncome) {
        TotalIncome -= totalIncome;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public int getListIndex() {
        return list.size();
    }

    public void setList(String list) {
        this.list.add(list);
    }

    public double getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(double totalPurchase) {
        this.totalPurchase += totalPurchase;
    }
}
